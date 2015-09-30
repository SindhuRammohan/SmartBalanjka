package balanjika.smart.sindhu.smartbalanjka;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import dbhelper.DBHelper;
import balanjika.smart.sindhu.Detailed.Homescreen;

public class LogIn extends ActionBarActivity {

    private EditText editusername;
    private String str;
    private String password;
    private String username_text;
    private String password_text;
    private EditText editpassword;
    private TextView forget;
    private TextView new_signin;
    Cursor c=null;
    boolean isSend;
    private SharPref sharpref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.logo);
        editusername = (EditText)findViewById(R.id.editusername);
        editpassword = (EditText)findViewById(R.id.editPassword);
        forget = (TextView)findViewById(R.id.forget);
        new_signin = (TextView)findViewById(R.id.sign);
        sharpref = SharPref.getInstance(this);

        forget.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editusername.setText("");
                editpassword.setText("");
                Intent in = new Intent(LogIn.this, ForgetPassword.class);
                startActivity(in);
            }
        });
        new_signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editusername.setText("");
                editpassword.setText("");
                Intent in = new Intent(LogIn.this, NewSigin.class);
                startActivity(in);
            }
        });
    }

    public void existinglogin(View view){
        str = editusername.getText().toString();
        password = editpassword.getText().toString();
        if(str.equalsIgnoreCase("")){
            Toast.makeText(LogIn.this, getResources().getString(R.string.usernameblank_toast), Toast.LENGTH_LONG).show();
        } else if(password.equalsIgnoreCase("")) {
            Toast.makeText(LogIn.this, getResources().getString(R.string.passwordblank_toast), Toast.LENGTH_LONG).show();
        } else {
            DBHelper myDbHelper = new DBHelper(LogIn.this);
            try {
                myDbHelper.createDataBase();
            } catch (IOException ioe) {
                throw new Error("Unable to create database");
            }

            try {
                myDbHelper.openDataBase();
            } catch (Exception sqle) {
            }
            isSend = false;
            c = myDbHelper.query(getResources().getString(R.string.table_Profile), null, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    if (c.getString(3).equalsIgnoreCase(str)) {
                        if (c.getString(4).equalsIgnoreCase(password)) {
                            isSend = true;
                            editusername.setText("");
                            editpassword.setText("");


                            if(c.getString(19).equalsIgnoreCase(getResources().getString(R.string.yes))){
                                sharpref.setMatrimonyType(2);
                                sharpref.setTempMailUsername(c.getString(1));
                                sharpref.setTempMailPassword(c.getString(2));
                                sharpref.setUsername(c.getString(3));
                                sharpref.setPassword(c.getString(4));
                                sharpref.setgender(c.getString(5));
                                sharpref.setaddress(c.getString(6));
                                sharpref.setCity(c.getString(7));
                                sharpref.setDistrict(c.getString(8));
                                sharpref.setCountry(c.getString(9));
                                sharpref.setphone(c.getString(10));
                                sharpref.setblood(c.getString(11));
                                sharpref.setdob(c.getString(12));
                                sharpref.setstatus(c.getString(13));
                                sharpref.setstatusdate(c.getString(14));
                                sharpref.setTempMail(c.getString(15));
                                sharpref.setAbout(c.getString(16));
                                sharpref.setquestion(c.getString(17));
                                sharpref.setanswer(c.getString(18));
                                sharpref.setRashi(c.getString(20));
                                sharpref.setNakthara(c.getString(21));
                                sharpref.setQualification(c.getString(22));
                                sharpref.setWork(c.getString(23));
                                sharpref.setTempHeight(c.getString(24));
                                sharpref.setWeight(c.getString(25));
                                sharpref.setNotes(c.getString(26));
                            } else if(c.getString(19).equalsIgnoreCase(getResources().getString(R.string.no))){
                                sharpref.setMatrimonyType(1);
                                sharpref.setTempMailUsername(c.getString(1));
                                sharpref.setTempMailPassword(c.getString(2));
                                sharpref.setUsername(c.getString(3));
                                sharpref.setPassword(c.getString(4));
                                sharpref.setgender(c.getString(5));
                                sharpref.setaddress(c.getString(6));
                                sharpref.setCity(c.getString(7));
                                sharpref.setDistrict(c.getString(8));
                                sharpref.setCountry(c.getString(9));
                                sharpref.setphone(c.getString(10));
                                sharpref.setblood(c.getString(11));
                                sharpref.setdob(c.getString(12));
                                sharpref.setstatus(c.getString(13));
                                sharpref.setstatusdate(c.getString(14));
                                sharpref.setTempMail(c.getString(15));
                                sharpref.setAbout(c.getString(16));
                                sharpref.setquestion(c.getString(17));
                                sharpref.setanswer(c.getString(18));
                            }

                            Intent in = new Intent(getBaseContext(), Homescreen.class);
                            startActivity(in);
                        }
                    }

                } while (c.moveToNext());
            }
            if (!isSend) {
                username_text = sharpref.getUsername();
                password_text = sharpref.getPassword();
                if(username_text != null  && password_text != null) {
                    if ((username_text.equalsIgnoreCase(str)) && (password_text.equalsIgnoreCase(password))) {
                        isSend = true;
                        editusername.setText("");
                        editpassword.setText("");
                        sharpref.setTempMailUsername(sharpref.getMailUsername());
                        sharpref.setTempMailPassword(sharpref.getMailPassword());
                        Intent in = new Intent(getBaseContext(), Homescreen.class);
                        startActivity(in);
                    }
                }
            }
            if (!isSend) {
                Toast.makeText(LogIn.this, getResources().getString(R.string.correct_toast), Toast.LENGTH_LONG).show();
            }
        }
    }




    @Override
    public void onBackPressed() {
        CustomDialogClass cdd = new CustomDialogClass(LogIn.this);
        cdd.show();
    }
}