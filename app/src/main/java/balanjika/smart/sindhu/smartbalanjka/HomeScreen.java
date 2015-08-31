package balanjika.smart.sindhu.smartbalanjka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import Mail.SendMailTask;

public class HomeScreen extends Activity {

    private EditText password;
    private EditText password_again;
    private EditText username;
    private String password_text;
    private String password_again_text;
    private String username_text;
    private SharPref sharpref;
    public HomeScreen() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_username);
        Button send = (Button) this.findViewById(R.id.Login_create);
        password = (EditText) this.findViewById(R.id.editPassword_create);
        password_again = (EditText) this.findViewById(R.id.editagainPassword_create);
        username = (EditText) this.findViewById(R.id.editusername_create);
        sharpref = SharPref.getInstance(this);
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                username_text = username.getText().toString();
                password_text = password.getText().toString();
                password_again_text = password_again.getText().toString();

                if(password_text.equalsIgnoreCase(password_again_text)) {
                    if(password_text.length() > 6) {
                        username.setText("");
                        password.setText("");
                        password_again.setText("");
                        sharpref.setUsername(username_text);
                        sharpref.setPassword(password_text);
                        Intent in = new Intent(HomeScreen.this, MyProfile.class);
                        startActivity(in);
                    } else {
                        Toast.makeText(HomeScreen.this, getResources().getString(R.string.weekpassword_toast), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(HomeScreen.this, getResources().getString(R.string.samepassword_toast), Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
