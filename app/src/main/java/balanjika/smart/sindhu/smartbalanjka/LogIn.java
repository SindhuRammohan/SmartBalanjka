package balanjika.smart.sindhu.smartbalanjka;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
    private TextView new_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        editusername = (EditText)findViewById(R.id.editusername);
        editpassword = (EditText)findViewById(R.id.editPassword);
        forget = (TextView)findViewById(R.id.forget);
        new_signin = (TextView)findViewById(R.id.sign);

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
//        Intent in = new Intent(getBaseContext(), HomeScreen.class);
//        startActivity(in);
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