package balanjika.smart.sindhu.smartbalanjka;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import DBHelper.DBHelper;
import Mail.SendMailTask;

public class NewSigin extends Activity {
    private EditText gmail_password;
    private EditText gmail_username;
    private String gmail_password_text;
    private String gmail_username_text;
    private SharPref sharpref;
    Cursor c=null;
    boolean isEqual;
    public NewSigin() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_signin);
        Button send = (Button) this.findViewById(R.id.Login_newsignin);
        gmail_password = (EditText) this.findViewById(R.id.editPassword_newsignin);
        gmail_username = (EditText) this.findViewById(R.id.editusername_newsignin);
        sharpref = SharPref.getInstance(this);

        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                gmail_username_text = gmail_username.getText().toString();
                gmail_password_text = gmail_password.getText().toString();
                String toEmails = getResources().getString(R.string.my_username);
                List<String> toEmailList = Arrays.asList(toEmails
                        .split("\\s*,\\s*"));
                DBHelper myDbHelper = new DBHelper(NewSigin.this);

                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }

                try {
                    myDbHelper.openDataBase();
                }catch(Exception sqle){
                }

                isEqual = false;
                c=myDbHelper.query("Profile", null, null, null, null, null, null);
                if(c.moveToFirst())
                {
                    do {
                        if (!(c.getString(1).equalsIgnoreCase(gmail_username_text))) {
                            isEqual = true;
                        }
                    } while (c.moveToNext()) ;
                }

                if(!isEqual){
                    new SendMailTask(NewSigin.this).execute(gmail_username_text,
                            gmail_password_text, toEmailList,
                            getResources().getString(R.string.newaccount_header),
                            getResources().getString(R.string.newaccount_content) + " " + gmail_username_text + ".");
                    if (SendMailTask.isMailSend) {
                        gmail_username.setText("");
                        gmail_password.setText("");
                        sharpref.setMailUsername(gmail_username_text);
                        sharpref.setMailPassword(gmail_password_text);
                        Intent in = new Intent(NewSigin.this, HomeScreen.class);
                        startActivity(in);
                    } else {
                        Toast.makeText(NewSigin.this,getResources().getString(R.string.newaccount_toast),Toast.LENGTH_LONG).show();
                    }


                }
            }
        });
    }
}
