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

public class NewKDEvents  extends ActionBarActivity {
    Calendar myCalendar = Calendar.getInstance();
    private EditText addVenue;
    private EditText addDate;
    private EditText addTime;
    private EditText addContact;
    private EditText addSpecification;
    private EditText addothers;
    private Button addKD;
    private SharPref sharpref;
    private NetworkStateReceiver checkInternet = new NetworkStateReceiver();
    int mHour = myCalendar.get(Calendar.HOUR_OF_DAY);
    int mMinute = myCalendar.get(Calendar.MINUTE);
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



        addTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog mTimePicker = new TimePickerDialog(NewKDEvents.this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timepicker, int selectedhour, int selectedminute) {
                            addTime.setText(selectedhour + ":" + selectedminute);
                        }
                    }, mHour, mMinute, true);
                mTimePicker.setTitle(getResources().getString(R.string.Set_Time));
                mTimePicker.show();
            }
        });


        addDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(NewKDEvents.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        addKD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(addVenue.getText().toString().equalsIgnoreCase("") ||
                        addDate.getText().toString().equalsIgnoreCase("") ||
                        addTime.getText().toString().equalsIgnoreCase("") ||
                        addContact.getText().toString().equalsIgnoreCase("") ||
                        addSpecification.getText().toString().equalsIgnoreCase("") ||
                        addothers.getText().toString().equalsIgnoreCase(""))) {

                    String toEmails = getResources().getString(R.string.my_username);
                    List<String> toEmailList = Arrays.asList(toEmails.split("\\s*,\\s*"));
                    if(checkInternet.isOnline(getApplicationContext())) {

                        addVenue.setText("");
                        addDate.setText("");
                        addTime.setText("");
                        addContact.setText("");
                        addSpecification.setText("");
                        addothers.setText("");
                    new SendMailTask(NewKDEvents.this).execute(sharpref.getTempMailUsername(),
                            sharpref.getTempMailPassword(), toEmailList,
                            getResources().getString(R.string.KDaccount_content) + " " +
                            addVenue.getText().toString(),
                            getResources().getString(R.string.KDHeader) + " " +
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
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; // In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        addDate.setText(sdf.format(myCalendar.getTime()));
    }
}
