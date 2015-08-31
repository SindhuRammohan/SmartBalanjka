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
import Mail.SendMailTask;
import DBHelper.DBHelper;


public class ForgetPassword extends Activity {

    private EditText gmail_password;
    private EditText gmail_username;
    private EditText username;
    private String gmail_password_text;
    private String gmail_username_text;
    private String username_text;
    Cursor c=null;
    boolean isMailSend;
    public ForgetPassword() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
        Button send = (Button) this.findViewById(R.id.Login_forgetpassword);
        gmail_password = (EditText) this.findViewById(R.id.editmailPassword_forgetpassword);
        username = (EditText) this.findViewById(R.id.editusername_forgetpassword);
        gmail_username = (EditText) this.findViewById(R.id.editMailID_forgetpassword);

        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                username_text       = username.getText().toString();
                gmail_username_text = gmail_username.getText().toString();
                gmail_password_text = gmail_password.getText().toString();

                DBHelper myDbHelper = new DBHelper(ForgetPassword.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }

                try {
                    myDbHelper.openDataBase();
                }catch(Exception sqle){
                }

                isMailSend = false;
                c=myDbHelper.query("Profile", null, null, null, null, null, null);
                if(c.moveToFirst())
                {
                    do {
                        if (c.getString(1).equalsIgnoreCase(gmail_username_text)) {
                            if (c.getString(2).equalsIgnoreCase(gmail_password_text)) {
                                if (c.getString(3).equalsIgnoreCase(username_text)) {
                                    String toEmails = gmail_username_text;
                                    List<String> toEmailList = Arrays.asList(toEmails
                                            .split("\\s*,\\s*"));
                                    new SendMailTask(ForgetPassword.this).execute(getResources().getString(R.string.my_username),
                                            getResources().getString(R.string.my_password), toEmailList,
                                            getResources().getString(R.string.Reset_header),
                                            getResources().getString(R.string.Reset_content) + " " + c.getString(1) +"."+
                                                   "\n" + getResources().getString(R.string.Reset_subcontent) + " " +  c.getString(4) );
                                    username.setText("");
                                    gmail_username.setText("");
                                    gmail_password.setText("");
                                    isMailSend = true;
                                    Toast.makeText(ForgetPassword.this,getResources().getString(R.string.Reset_toast),Toast.LENGTH_LONG).show();
                                    Intent in = new Intent(ForgetPassword.this , LogIn.class);
                                    startActivity(in);

                                }
                            }
                        }
                    } while (c.moveToNext()) ;
                }

                if(!isMailSend) {
                    Toast.makeText(ForgetPassword.this,getResources().getString(R.string.NotReset_toast),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
