package balanjika.smart.sindhu.smartbalanjka;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import dbhelper.DBHelper;
import Mail.SendMailTask;

public class NewSigin extends ActionBarActivity {
    private EditText gmail_password;
    private EditText gmail_username;
    private String gmail_password_text;
    private String gmail_username_text;
    private SharPref sharpref;
    Cursor c=null;
    int count;
    private ProgressDialog pdia;
    public NewSigin() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_signin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        Button send = (Button) this.findViewById(R.id.Login_newsignin);
        gmail_password = (EditText) this.findViewById(R.id.editPassword_newsignin);
        gmail_username = (EditText) this.findViewById(R.id.editusername_newsignin);
        sharpref = SharPref.getInstance(this);
        count = 0;
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
                } catch (Exception sqle) {
                }
                count = 0;
                c = myDbHelper.query("Profile", null, null, null, null, null, null);
                if (c.moveToFirst()) {
                    do {
                        if ((c.getString(1).equalsIgnoreCase(gmail_username_text))) {
                            count = count + 1;
                        }
                    } while (c.moveToNext());
                }
                Toast.makeText(NewSigin.this, count + gmail_username_text, Toast.LENGTH_LONG).show();
                if (count == 0) {
                    new SendMailTask(NewSigin.this).execute(gmail_username_text,
                            gmail_password_text, toEmailList,
                            getResources().getString(R.string.newaccount_header),
                            getResources().getString(R.string.newaccount_content) + " " + gmail_username_text + ".");
                    new LongOperation(NewSigin.this).execute("");
                } else {
                    Toast.makeText(NewSigin.this, getResources().getString(R.string.alreadyaccount_toast), Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private class LongOperation extends AsyncTask<String, Void, String> {
        private Activity sendMailActivity;
        public LongOperation(Activity activity) {
            sendMailActivity = activity;

        }
        @Override
        protected String doInBackground(String... params) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            pdia.dismiss();
            if (SendMailTask.isMailSend) {
                gmail_username.setText("");
                gmail_password.setText("");
                sharpref.setMailUsername(gmail_username_text);
                sharpref.setMailPassword(gmail_password_text);
                Intent in = new Intent(NewSigin.this, CreateLogin.class);
                startActivity(in);
            } else {
                Toast.makeText(NewSigin.this, getResources().getString(R.string.correct_toast), Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected void onPreExecute() {
            pdia = new ProgressDialog(sendMailActivity);
            pdia.setMessage(getResources().getString(R.string.Loading));
            pdia.show();
            pdia.setCancelable(false);
            pdia.setCanceledOnTouchOutside(false);
        }

        @Override
        protected void onProgressUpdate(Void... values) {

        }
    }
}
