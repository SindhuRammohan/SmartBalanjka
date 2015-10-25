package balanjika.smart.sindhu.Detailed;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Arrays;
import java.util.List;

import Mail.NetworkStateReceiver;
import Mail.SendMailTask;
import balanjika.smart.sindhu.smartbalanjka.R;
import balanjika.smart.sindhu.smartbalanjka.SharPref;
import balanjika.smart.sindhu.smartbalanjka.SplashScreen;


public class Contactus extends ActionBarActivity {
    NetworkStateReceiver checkInternet = new NetworkStateReceiver();
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

        if(!subject.getText().toString().equalsIgnoreCase("") && !body.getText().toString().equalsIgnoreCase("") &&
            !sharpref.getTempMailUsername().equalsIgnoreCase("") && !sharpref.getTempMailPassword().equalsIgnoreCase("")) {
            String toEmails = getResources().getString(R.string.my_username);
            List<String> toEmailList = Arrays.asList(toEmails
                    .split("\\s*,\\s*"));
            if(checkInternet.isOnline(getApplicationContext())) {
            new SendMailTask(Contactus.this).execute(sharpref.getTempMailUsername(),
                    sharpref.getTempMailPassword(), toEmailList,
                    getResources().getString(R.string.helpHeader) + " " +
                    subject.getText().toString(),
                    getResources().getString(R.string.helpBody) + " " +
                    body.getText().toString());
            } else {
                Toast.makeText(Contactus.this,getResources().getString(R.string.internet_connect_toast),Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(Contactus.this, getResources().getString(R.string.contactus_toast), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}