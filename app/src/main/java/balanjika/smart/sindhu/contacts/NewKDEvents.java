package balanjika.smart.sindhu.contacts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import Mail.NetworkStateReceiver;
import Mail.SendMailTask;
import balanjika.smart.sindhu.smartbalanjka.R;
import balanjika.smart.sindhu.smartbalanjka.SharPref;
import balanjika.smart.sindhu.smartbalanjka.SplashScreen;

public class NewKDEvents  extends ActionBarActivity {

    private EditText addVenue;
    private EditText addDate;
    private EditText addTime;
    private EditText addContact;
    private EditText addSpecification;
    private EditText addothers;
    private Button addKD;
    private SharPref sharpref;
    private NetworkStateReceiver checkInternet = new NetworkStateReceiver();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_kd);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        sharpref = SharPref.getInstance(this);


        addVenue = (EditText) findViewById(R.id.addVenue);
        addDate = (EditText) findViewById(R.id.addDate);
        addTime = (EditText) findViewById(R.id.addTime);
        addContact = (EditText) findViewById(R.id.addContact);
        addSpecification = (EditText) findViewById(R.id.addSpecification);
        addothers = (EditText) findViewById(R.id.addothers);
        addKD = (Button) findViewById(R.id.addKD);



        addKD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(addVenue.getText().toString().equalsIgnoreCase("") &&
                        addDate.getText().toString().equalsIgnoreCase("") &&
                        addTime.getText().toString().equalsIgnoreCase("") &&
                        addContact.getText().toString().equalsIgnoreCase("") &&
                        addSpecification.getText().toString().equalsIgnoreCase("") &&
                        addothers.getText().toString().equalsIgnoreCase(""))) {


                    addVenue.setText("");
                    addDate.setText("");
                    addTime.setText("");
                    addContact.setText("");
                    addSpecification.setText("");
                    addothers.setText("");



                    String toEmails = getResources().getString(R.string.my_username);
                    List<String> toEmailList = Arrays.asList(toEmails.split("\\s*,\\s*"));
                    if(checkInternet.isOnline(getApplicationContext())) {
                    new SendMailTask(NewKDEvents.this).execute(sharpref.getTempMailUsername(),
                            sharpref.getTempMailPassword(), toEmailList,
                            addVenue.getText().toString(),
                            addDate.getText().toString() + "\n" +
                                    addTime.getText().toString() + "\n" +
                                    addContact.getText().toString() + "\n" +
                                    addSpecification.getText().toString() + "\n" +
                                    addothers.getText().toString() );
                    } else {
                        Toast.makeText(NewKDEvents.this,getResources().getString(R.string.internet_connect_toast),Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(NewKDEvents.this, getResources().getString(R.string.correct_Details_toast), Toast.LENGTH_LONG).show();
                }
            }
        });
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
