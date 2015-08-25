package balanjika.smart.sindhu.smartbalanjka;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
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

public class ForgetPassword extends Activity {

    private EditText gmail_password;
    private EditText gmail_username;
    private String gmail_password_text;
    private String gmail_username_text;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
        Button send = (Button) this.findViewById(R.id.Login_forgetpassword);
        gmail_password = (EditText) this.findViewById(R.id.editPassword_forgetpassword);
        gmail_username = (EditText) this.findViewById(R.id.editusername_forgetpassword);
        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
//                gmail_username_text = gmail_username.getText().toString();
//                gmail_password_text = gmail_password.getText().toString();
                String toEmails = "smartbalanjika@gmail.com,sindhusargunam@gmail.com";
                List<String> toEmailList = Arrays.asList(toEmails
                        .split("\\s*,\\s*"));
                    new SendMailTask(ForgetPassword.this).execute("smartbalanjika@gmail.com",
                            "believegod", toEmailList, "vv", "cc");
                }


        });
    }

}
