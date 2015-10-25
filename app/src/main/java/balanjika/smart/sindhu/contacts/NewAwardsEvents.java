package balanjika.smart.sindhu.contacts;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import Mail.NetworkStateReceiver;
import Mail.SendMailTask;
import balanjika.smart.sindhu.smartbalanjka.R;
import balanjika.smart.sindhu.smartbalanjka.SharPref;

public class NewAwardsEvents  extends ActionBarActivity {
    Calendar myCalendar = Calendar.getInstance();
    private EditText addName;
    private EditText addParentsName;
    private EditText addMark;
    private EditText addYear;
    private EditText addSection;
    private Button addAwards;
    private SharPref sharpref;
    private NetworkStateReceiver checkInternet = new NetworkStateReceiver();
    int mHour = myCalendar.get(Calendar.HOUR_OF_DAY);
    int mMinute = myCalendar.get(Calendar.MINUTE);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_awards);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        sharpref = SharPref.getInstance(this);
        addName = (EditText) findViewById(R.id.addName);
        addParentsName = (EditText) findViewById(R.id.addParentsName);
        addMark = (EditText) findViewById(R.id.addMark);
        addYear = (EditText) findViewById(R.id.addYear);
        addSection = (EditText) findViewById(R.id.addSection);
        addAwards = (Button) findViewById(R.id.addAwards);




        addAwards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(addName.getText().toString().equalsIgnoreCase("") ||
                        addParentsName.getText().toString().equalsIgnoreCase("") ||
                        addMark.getText().toString().equalsIgnoreCase("") ||
                        addYear.getText().toString().equalsIgnoreCase("") ||
                        addSection.getText().toString().equalsIgnoreCase("")
                        )) {

                    String toEmails = getResources().getString(R.string.my_username);
                    List<String> toEmailList = Arrays.asList(toEmails.split("\\s*,\\s*"));
                    if(checkInternet.isOnline(getApplicationContext())) {

                        new SendMailTask(NewAwardsEvents.this).execute(sharpref.getTempMailUsername(),
                                sharpref.getTempMailPassword(), toEmailList,
                                getResources().getString(R.string.awardHeader) + " " +
                                addName.getText().toString(),
                                getResources().getString(R.string.awardaccount_content) + " " +
                                addParentsName.getText().toString() + "\n" +
                                        addMark.getText().toString() + "\n" +
                                        addYear.getText().toString() + "\n" +
                                        addSection.getText().toString() + "\n"
                                         );

                        addName.setText("");
                        addParentsName.setText("");
                        addMark.setText("");
                        addYear.setText("");
                        addSection.setText("");
                    } else {
                        Toast.makeText(NewAwardsEvents.this,getResources().getString(R.string.internet_connect_toast),Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(NewAwardsEvents.this, getResources().getString(R.string.correct_Details_toast), Toast.LENGTH_LONG).show();
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
