package balanjika.smart.sindhu.smartbalanjka;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    private DBHelper mydb ;
    String nam;
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



        mydb = new DBHelper(this);
        Cursor rs = mydb.getData(1);
        nam = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_NAME));




        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                username_text       = gmail_username.getText().toString();
                gmail_username_text = gmail_username.getText().toString();
                gmail_password_text = gmail_password.getText().toString();

                Log.d("dddd",nam + "dddd");

                String toEmails = "smartbalanjika@gmail.com,sindhusargunam@gmail.com";
                List<String> toEmailList = Arrays.asList(toEmails
                        .split("\\s*,\\s*"));
                    new SendMailTask(ForgetPassword.this).execute(getResources().getString(R.string.my_username),
                            getResources().getString(R.string.my_password), toEmailList, "vv", "cc");




                }


        });
    }

}
