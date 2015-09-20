package balanjika.smart.sindhu.Detailed;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import Mail.SendMailTask;
import balanjika.smart.sindhu.smartbalanjka.R;
import balanjika.smart.sindhu.smartbalanjka.SharPref;

/**
 * Created by rajesh on 07-09-2015.
 */
public class Contactus extends ActionBarActivity {

    private EditText subject;
    private EditText body;
    private SharPref sharpref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        subject = (EditText)findViewById(R.id.subject);
        body = (EditText)findViewById(R.id.body);
        sharpref = SharPref.getInstance(this);
    }
    public void sendmail(View v) {
        Log.d("contactus",""+ subject.getText().toString() + body.getText().toString() +
                sharpref.getTempMailUsername() + sharpref.getTempMailPassword() );

        if(!subject.getText().toString().equalsIgnoreCase("") && !body.getText().toString().equalsIgnoreCase("") &&
            !sharpref.getTempMailUsername().equalsIgnoreCase("") && !sharpref.getTempMailPassword().equalsIgnoreCase("")) {
            String toEmails = getResources().getString(R.string.my_username);
            List<String> toEmailList = Arrays.asList(toEmails
                    .split("\\s*,\\s*"));
            new SendMailTask(Contactus.this).execute(sharpref.getTempMailUsername(),
                    sharpref.getTempMailPassword(), toEmailList,
                    subject.getText().toString(),
                    body.getText().toString());

        } else {
            Toast.makeText(Contactus.this, getResources().getString(R.string.contactus_toast), Toast.LENGTH_LONG).show();
        }

    }
}