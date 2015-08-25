package balanjika.smart.sindhu.smartbalanjka;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LogIn extends Activity {

    private EditText editusername;
    private String str;
    private String password;
    private EditText editpassword;
    private TextView forget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        editusername = (EditText)findViewById(R.id.editusername);
        editpassword = (EditText)findViewById(R.id.editPassword);
        forget = (TextView)findViewById(R.id.forget);

        forget.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent(LogIn.this , ForgetPassword.class);
                startActivity(in);
            }
        });

    }


    public void forgetPassword(View view) {
        Intent in = new Intent(LogIn.this , ForgetPassword.class);
        startActivity(in);
    }

    public void newSignin(View view){
        Intent in = new Intent(getBaseContext(), NewSigin.class);
        startActivity(in);
    }

    public void existinglogin(View view){
        str = editusername.getText().toString();
        password = editpassword.getText().toString();
//        Intent in = new Intent(getBaseContext(), HomeScreen.class);
//        startActivity(in);
    }




    @Override
    public void onBackPressed() {
    }
}