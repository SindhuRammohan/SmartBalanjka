package balanjika.smart.sindhu.smartbalanjka;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import DBHelper.DBHelper;

public class LogIn extends Activity {

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
            c = myDbHelper.query("Profile", null, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    if (c.getString(3).equalsIgnoreCase(str)) {
                        if (c.getString(4).equalsIgnoreCase(password)) {
                            isSend = true;
                            Intent in = new Intent(getBaseContext(), HomeScreen.class);
                            startActivity(in);
                        }
                    }

                } while (c.moveToNext());
            }
            if (!isSend) {
                username_text = sharpref.getUsername();
                password_text = sharpref.getPassword();
                if ((username_text.equalsIgnoreCase(str)) && (password_text.equalsIgnoreCase(password))) {
                    isSend = true;
                    Intent in = new Intent(getBaseContext(), HomeScreen.class);
                    startActivity(in);
                }
            }
            if (!isSend) {
                Toast.makeText(LogIn.this, getResources().getString(R.string.correct_toast), Toast.LENGTH_LONG).show();
            }
        }
    }




    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(getResources().getString(R.string.Exit));
        builder.setPositiveButton(getResources().getString(R.string.Yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
                finish();
                return;
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.No), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}