package balanjika.smart.sindhu.Detailed;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import Mail.NetworkStateReceiver;
import Mail.SendMailTask;
import balanjika.smart.sindhu.smartbalanjka.LogIn;
import balanjika.smart.sindhu.smartbalanjka.R;
import balanjika.smart.sindhu.smartbalanjka.SharPref;
import balanjika.smart.sindhu.smartbalanjka.SplashScreen;

public class ViewProfile extends ActionBarActivity implements View.OnClickListener {

    Calendar myCalendar = Calendar.getInstance();
    private String[] countries_list;
    private String[] blood_list;
    private String[] rashi_list;
    private String[] nakthara_list ;
    private String[] spinner_list;
    private String[] gender_list;
    private LinearLayout linear;
    private EditText City;
    private EditText District;
    private EditText Country;
    private EditText phone;
    private EditText About;
    private EditText Rashi;
    private EditText Nakthara;
    private EditText Notes;
    private EditText Work;
    private EditText Height;
    private EditText Weight;
    private EditText Qualification;
    private EditText Mail;
    private EditText address;
    private EditText gender;
    private EditText textview_blood;
    private EditText dob;
    private EditText status;
    private EditText question;
    private EditText answer;
    private EditText statusdate;
    private Button matrimony;
    private TextView myName;
    private TextView MailId;
    private Button save;

    private String gmail_username_text;
    private String gmail_password_text;

    private SharPref sharpref;

    private NetworkStateReceiver checkInternet = new NetworkStateReceiver();
    int type = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_details);
        sharpref = SharPref.getInstance(this);


        blood_list = getResources().getStringArray(R.array.blood_list);
        spinner_list = getResources().getStringArray(R.array.matrimony_list);
        gender_list = getResources().getStringArray(R.array.gender_list);
        nakthara_list = getResources().getStringArray(R.array.nakthara_list);
        rashi_list  = getResources().getStringArray(R.array.rashi_list);
        countries_list = getResources().getStringArray(R.array.country_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
        }

        gender = (EditText) findViewById(R.id.gender);
        address = (EditText) findViewById(R.id.address);

        City = (EditText) findViewById(R.id.City);
        District = (EditText) findViewById(R.id.District);
        Country = (EditText) findViewById(R.id.Country);
        phone = (EditText) findViewById(R.id.phone);
        textview_blood = (EditText) findViewById(R.id.Blood);
        dob = (EditText) findViewById(R.id.DOB);
        status = (EditText) findViewById(R.id.status);
        statusdate = (EditText) findViewById(R.id.statusdate);
        Mail = (EditText) findViewById(R.id.Mail);
        About = (EditText) findViewById(R.id.About);
        question = (EditText) findViewById(R.id.question);
        answer = (EditText) findViewById(R.id.answer);
        Rashi = (EditText) findViewById(R.id.Rashi);
        Nakthara = (EditText) findViewById(R.id.Nakthara);
        Qualification = (EditText) findViewById(R.id.Qualification);
        Work = (EditText) findViewById(R.id.Work);
        Height = (EditText) findViewById(R.id.Height);
        Weight = (EditText) findViewById(R.id.Weight);
        Notes = (EditText) findViewById(R.id.Notes);




        linear = (LinearLayout) findViewById(R.id.layoutunregister);
        linear.setVisibility(View.GONE);
        matrimony = (Button) findViewById(R.id.matrimony);
        save = (Button) findViewById(R.id.save);
        Button nothanks = (Button) findViewById(R.id.nothanks);
        Button unregister = (Button) findViewById(R.id.unregister);
        myName = (TextView) findViewById(R.id.myNameText);
        MailId = (TextView) findViewById(R.id.mailidText);


        myName.setText(sharpref.getUsername());
        MailId.setText(sharpref.getMailUsername());


        if(sharpref.getMatrimonyType() == 1) {
            gender.setText(sharpref.getTempgender()) ;
            address.setText(sharpref.getTempaddress());
            City.setText(sharpref.getTempCity());
            District.setText(sharpref.getTempDistrict());
            Country.setText(sharpref.getTempCountry());
            phone.setText(sharpref.getTempphone());
            textview_blood.setText(sharpref.getTempblood());
            dob.setText(sharpref.getTempdob());
            status.setText(sharpref.getTempstatus());
            statusdate.setText(sharpref.getTempstatusdate());
            Mail.setText(sharpref.getTempMail());
            About.setText(sharpref.getTempAbout());
            question.setText(sharpref.getTempquestion());
            answer.setText(sharpref.getTempanswer());
            matrimony.setVisibility(View.VISIBLE);
            save.setVisibility(View.VISIBLE);
            linear.setVisibility(View.GONE);
        } else if(sharpref.getMatrimonyType() == 2) {
            gender.setText(sharpref.getTempgender()) ;
            address.setText(sharpref.getTempaddress());
            City.setText(sharpref.getTempCity());
            District.setText(sharpref.getTempDistrict());
            Country.setText(sharpref.getTempCountry());
            phone.setText(sharpref.getTempphone());
            textview_blood.setText(sharpref.getTempblood());
            dob.setText(sharpref.getTempdob());
            status.setText(sharpref.getTempstatus());
            statusdate.setText(sharpref.getTempstatusdate());
            Mail.setText(sharpref.getTempMail());
            About.setText(sharpref.getTempAbout());
            question.setText(sharpref.getTempquestion());
            answer.setText(sharpref.getTempanswer());
            Rashi.setText(sharpref.getTempRashi());
            Nakthara.setText(sharpref.getTempNakthara());
            Qualification.setText(sharpref.getTempQualification());
            Work.setText(sharpref.getTempWork());
            Height.setText(sharpref.getTempHeight());
            Weight.setText(sharpref.getTempWeight());
            Notes.setText(sharpref.getTempNotes());
            matrimony.setVisibility(View.GONE);
            save.setVisibility(View.GONE);
            linear.setVisibility(View.VISIBLE);
        }




        linear.setVisibility(View.VISIBLE);
        unregister.setVisibility(View.VISIBLE);
//        sharpref.getTempstatusdate();
        matrimony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear.setVisibility(View.VISIBLE);
                matrimony.setVisibility(View.GONE);
                save.setVisibility(View.GONE);
            }
        });

        nothanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear.setVisibility(View.GONE);
                matrimony.setVisibility(View.VISIBLE);
                save.setVisibility(View.VISIBLE);

                gmail_username_text = sharpref.getMailUsername();
                gmail_password_text = sharpref.getMailPassword();
                String toEmails = getResources().getString(R.string.my_username);
                List<String> toEmailList = Arrays.asList(toEmails
                        .split("\\s*,\\s*"));
                if (!(Rashi.getText().toString().equalsIgnoreCase("") ||
                        Nakthara.getText().toString().equalsIgnoreCase("") ||
                        Qualification.getText().toString().equalsIgnoreCase("") ||
                        Work.getText().toString().equalsIgnoreCase("") ||
                        Height.getText().toString().equalsIgnoreCase("") ||
                        Weight.getText().toString().equalsIgnoreCase("") ||
                        Notes.getText().toString().equalsIgnoreCase(""))) {
                    if (checkInternet.isOnline(getApplicationContext())) {
                        new SendMailTask(ViewProfile.this).execute(gmail_username_text,
                                gmail_password_text, toEmailList,
                                getResources().getString(R.string.removeaccount_header),
                                getResources().getString(R.string.removeaccount_content) + " " +
                                        Rashi.getText().toString()
                                        +",\n"+ Nakthara.getText().toString()
                                        +",\n"+ Qualification.getText().toString()
                                        +",\n"+ Work.getText().toString()
                                        +",\n"+ Height.getText().toString()
                                        +",\n"+ Weight.getText().toString()
                                        +",\n"+ Notes.getText().toString()
                                        +",\n"+ type);
                        Rashi.setText("");
                        Nakthara.setText("");
                        Qualification.setText("");
                        Work.setText("");
                        Height.setText("");
                        Weight.setText("");
                        Notes.setText("");
                    } else {
                        Toast.makeText(ViewProfile.this, getResources().getString(R.string.internet_connect_toast), Toast.LENGTH_LONG).show();
                    }
                }else{
                    linear.setVisibility(View.GONE);
                    matrimony.setVisibility(View.VISIBLE);
                    save.setVisibility(View.VISIBLE);
                }
            }
        });



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(gender.getText().toString().equalsIgnoreCase("") ||
                        address.getText().toString().equalsIgnoreCase("") ||
                        City.getText().toString().equalsIgnoreCase("") ||
                        District.getText().toString().equalsIgnoreCase("") ||
                        Country.getText().toString().equalsIgnoreCase("") ||
                        phone.getText().toString().equalsIgnoreCase("")||
                        textview_blood.getText().toString().equalsIgnoreCase("")||
                        dob.getText().toString().equalsIgnoreCase("")||
                        status.getText().toString().equalsIgnoreCase("")||
                        statusdate.getText().toString().equalsIgnoreCase("")||
                        Mail.getText().toString().equalsIgnoreCase("")||
                        About.getText().toString().equalsIgnoreCase("")||
                        question.getText().toString().equalsIgnoreCase("")||
                        answer.getText().toString().equalsIgnoreCase(""))){
                    type = 1;
                    if (!(gender.getText().toString().equalsIgnoreCase(sharpref.getTempgender()) &&
                            address.getText().toString().equalsIgnoreCase(sharpref.getTempaddress()) &&
                            City.getText().toString().equalsIgnoreCase(sharpref.getTempCity()) &&
                            District.getText().toString().equalsIgnoreCase(sharpref.getTempDistrict()) &&
                            Country.getText().toString().equalsIgnoreCase(sharpref.getTempCountry()) &&
                            phone.getText().toString().equalsIgnoreCase(sharpref.getTempphone()) &&
                            textview_blood.getText().toString().equalsIgnoreCase(sharpref.getTempblood()) &&
                            dob.getText().toString().equalsIgnoreCase(sharpref.getTempdob()) &&
                            status.getText().toString().equalsIgnoreCase(sharpref.getTempstatus()) &&
                            statusdate.getText().toString().equalsIgnoreCase(sharpref.getTempstatusdate())&&
                            Mail.getText().toString().equalsIgnoreCase(sharpref.getTempMail()) &&
                            About.getText().toString().equalsIgnoreCase(sharpref.getTempAbout()) &&
                            question.getText().toString().equalsIgnoreCase(sharpref.getTempquestion()) &&
                            answer.getText().toString().equalsIgnoreCase(sharpref.getTempanswer()))) {

                        gmail_username_text = sharpref.getMailUsername();
                        gmail_password_text = sharpref.getMailPassword();



                        String toEmails = getResources().getString(R.string.my_username);

                        List<String> toEmailList = Arrays.asList(toEmails
                                .split("\\s*,\\s*"));
                        if(checkInternet.isOnline(getApplicationContext())) {
                            new SendMailTask(ViewProfile.this).execute(gmail_username_text,
                                    gmail_password_text, toEmailList,
                                    getResources().getString(R.string.editaccount_header),
                                    getResources().getString(R.string.editaccount_content) + " " +
                                            gender.getText().toString() +",\n"+
                                            address.getText().toString()
                                            +",\n"+ City.getText().toString()
                                            +",\n"+ District.getText().toString()
                                            +",\n"+ Country.getText().toString()
                                            +",\n"+ phone.getText().toString()
                                            +",\n"+ textview_blood.getText().toString()
                                            +",\n"+ dob.getText().toString()
                                            +",\n"+ status.getText().toString()
                                            +",\n"+ Mail.getText().toString()
                                            +",\n"+ About.getText().toString()
                                            +",\n"+ question.getText().toString()
                                            +",\n"+ answer.getText().toString()
                                            +",\n"+ type);
                        } else {
                            Toast.makeText(ViewProfile.this,getResources().getString(R.string.internet_connect_toast),Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(ViewProfile.this, getResources().getString(R.string.nochange_toast), Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(ViewProfile.this, getResources().getString(R.string.blank_toast), Toast.LENGTH_LONG).show();
                }
            }
        });

        unregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(gender.getText().toString().equalsIgnoreCase("") ||
                        address.getText().toString().equalsIgnoreCase("") ||
                        City.getText().toString().equalsIgnoreCase("") ||
                        District.getText().toString().equalsIgnoreCase("") ||
                        Country.getText().toString().equalsIgnoreCase("") ||
                        phone.getText().toString().equalsIgnoreCase("") ||
                        textview_blood.getText().toString().equalsIgnoreCase("") ||
                        dob.getText().toString().equalsIgnoreCase("") ||
                        status.getText().toString().equalsIgnoreCase("") ||
                        statusdate.getText().toString().equalsIgnoreCase("") ||
                        Mail.getText().toString().equalsIgnoreCase("") ||
                        About.getText().toString().equalsIgnoreCase("") ||
                        question.getText().toString().equalsIgnoreCase("") ||
                        answer.getText().toString().equalsIgnoreCase("") ||
                        Rashi.getText().toString().equalsIgnoreCase("") ||
                        Nakthara.getText().toString().equalsIgnoreCase("") ||
                        Qualification.getText().toString().equalsIgnoreCase("") ||
                        Work.getText().toString().equalsIgnoreCase("") ||
                        Height.getText().toString().equalsIgnoreCase("") ||
                        Weight.getText().toString().equalsIgnoreCase("") ||
                        Notes.getText().toString().equalsIgnoreCase(""))) {
                    type = 2;
                    if (!(gender.getText().toString().equalsIgnoreCase(sharpref.getTempgender()) &&
                            address.getText().toString().equalsIgnoreCase(sharpref.getTempaddress()) &&
                            City.getText().toString().equalsIgnoreCase(sharpref.getTempCity()) &&
                            District.getText().toString().equalsIgnoreCase(sharpref.getTempDistrict()) &&
                            Country.getText().toString().equalsIgnoreCase(sharpref.getTempCountry()) &&
                            phone.getText().toString().equalsIgnoreCase(sharpref.getTempphone()) &&
                            textview_blood.getText().toString().equalsIgnoreCase(sharpref.getTempblood()) &&
                            dob.getText().toString().equalsIgnoreCase(sharpref.getTempdob()) &&
                            status.getText().toString().equalsIgnoreCase(sharpref.getTempstatus()) &&
                            statusdate.getText().toString().equalsIgnoreCase(sharpref.getTempstatusdate()) &&
                            Mail.getText().toString().equalsIgnoreCase(sharpref.getTempMail()) &&
                            About.getText().toString().equalsIgnoreCase(sharpref.getTempAbout()) &&
                            question.getText().toString().equalsIgnoreCase(sharpref.getTempquestion()) &&
                            answer.getText().toString().equalsIgnoreCase(sharpref.getTempanswer()) &&
                            Rashi.getText().toString().equalsIgnoreCase(sharpref.getTempRashi()) &&
                            Nakthara.getText().toString().equalsIgnoreCase(sharpref.getTempNakthara()) &&
                            Qualification.getText().toString().equalsIgnoreCase(sharpref.getTempQualification()) &&
                            Work.getText().toString().equalsIgnoreCase(sharpref.getTempWork()) &&
                            Height.getText().toString().equalsIgnoreCase(sharpref.getTempHeight()) &&
                            Weight.getText().toString().equalsIgnoreCase(sharpref.getTempWeight()) &&
                            Notes.getText().toString().equalsIgnoreCase(sharpref.getTempNotes()))) {

                        gmail_username_text = sharpref.getMailUsername();
                        gmail_password_text = sharpref.getMailPassword();


                        String toEmails = getResources().getString(R.string.my_username);

                        List<String> toEmailList = Arrays.asList(toEmails
                                .split("\\s*,\\s*"));
                        if (checkInternet.isOnline(getApplicationContext())) {
                            new SendMailTask(ViewProfile.this).execute(gmail_username_text,
                                    gmail_password_text, toEmailList,
                                    getResources().getString(R.string.editaccount_header),
                                    getResources().getString(R.string.editaccount_content) + " " +
                                            gender.getText().toString() +",\n"+
                                            address.getText().toString()
                                            +",\n"+ City.getText().toString()
                                            +",\n"+ District.getText().toString()
                                            +",\n"+ Country.getText().toString()
                                            +",\n"+ phone.getText().toString()
                                            +",\n"+ textview_blood.getText().toString()
                                            +",\n"+ dob.getText().toString()
                                            +",\n"+ status.getText().toString()
                                            +",\n"+ Mail.getText().toString()
                                            +",\n"+ About.getText().toString()
                                            +",\n"+ question.getText().toString()
                                            +",\n"+ answer.getText().toString()
                                            +",\n"+ Rashi.getText().toString()
                                            +",\n"+ Nakthara.getText().toString()
                                            +",\n"+ Qualification.getText().toString()
                                            +",\n"+ Work.getText().toString()
                                            +",\n"+ Height.getText().toString()
                                            +",\n"+ Weight.getText().toString()
                                            +",\n"+ Notes.getText().toString()
                                            +",\n"+ type);
                        } else {
                            Toast.makeText(ViewProfile.this, getResources().getString(R.string.internet_connect_toast), Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(ViewProfile.this, getResources().getString(R.string.nochange_toast), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(ViewProfile.this, getResources().getString(R.string.blank_toast), Toast.LENGTH_LONG).show();
                }
            }
        });

        Mail= (EditText) findViewById(R.id.Mail);
        City = (EditText) findViewById(R.id.City);
        District = (EditText) findViewById(R.id.District);
        Country = (EditText) findViewById(R.id.Country);
        phone = (EditText) findViewById(R.id.phone);
        About = (EditText) findViewById(R.id.About);
        Rashi = (EditText) findViewById(R.id.Rashi);
        Nakthara = (EditText) findViewById(R.id.Nakthara);
        Qualification = (EditText) findViewById(R.id.Qualification);
        Work = (EditText) findViewById(R.id.Work);
        Height = (EditText) findViewById(R.id.Height);
        Weight = (EditText) findViewById(R.id.Weight);
        Notes = (EditText) findViewById(R.id.Notes);
        question = (EditText) findViewById(R.id.question);
        answer = (EditText) findViewById(R.id.answer);
        status = (EditText) findViewById(R.id.status);
        statusdate = (EditText) findViewById(R.id.statusdate);
//        statusdate.setVisibility(View.GONE);
        textview_blood = (EditText) findViewById(R.id.Blood);
        dob = (EditText) findViewById(R.id.DOB);
        textview_blood.setInputType(InputType.TYPE_NULL); // To hide the
        // softkeyboard
        final ArrayAdapter<String> spinner_countries = new ArrayAdapter<String>(
                ViewProfile.this, android.R.layout.simple_spinner_dropdown_item,
                countries_list);
        final ArrayAdapter<String> spinner_blood = new ArrayAdapter<String>(
                ViewProfile.this, android.R.layout.simple_spinner_dropdown_item,
                blood_list);
        final ArrayAdapter<String> spinner_rashi = new ArrayAdapter<String>(
                ViewProfile.this, android.R.layout.simple_spinner_dropdown_item,
                rashi_list);
        final ArrayAdapter<String> spinner_nakthara = new ArrayAdapter<String>(
                ViewProfile.this, android.R.layout.simple_spinner_dropdown_item,
                nakthara_list);
        final ArrayAdapter<String> spinner_Gender = new ArrayAdapter<String>(
                ViewProfile.this, android.R.layout.simple_spinner_dropdown_item,
                gender_list);

        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ViewProfile.this).setTitle(getResources().getString(R.string.Select_Gender)).setAdapter(spinner_Gender,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                gender.setText(gender_list[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });
        Nakthara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ViewProfile.this).setTitle(getResources().getString(R.string.Select_Nakthara)).setAdapter(spinner_nakthara,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Nakthara.setText(nakthara_list[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });
        Rashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ViewProfile.this).setTitle(getResources().getString(R.string.Select_Rashi)).setAdapter(spinner_rashi,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Rashi.setText(rashi_list[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });
        textview_blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ViewProfile.this).setTitle(getResources().getString(R.string.Select_BloodGroup)).setAdapter(spinner_blood,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                textview_blood.setText(blood_list[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        Country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ViewProfile.this).setTitle(getResources().getString(R.string.Select_Country)).setAdapter(spinner_countries,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Country.setText(countries_list[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        final ArrayAdapter<String> date_spinner = new ArrayAdapter<String>(
                ViewProfile.this, android.R.layout.simple_spinner_dropdown_item,
                spinner_list);
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ViewProfile.this).setTitle(getResources().getString(R.string.Select_Status)).setAdapter(date_spinner,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                status.setText(spinner_list[which].toString());
                                String text = ViewProfile.this.status.getText().toString().toLowerCase();
                                if (text.compareTo(getResources().getString(R.string.married)) == 0) {
                                    statusdate.setVisibility(View.VISIBLE);
                                } else {
                                    statusdate.setVisibility(View.GONE);
                                }
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });


        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ViewProfile.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        statusdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ViewProfile.this, marriagedate, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



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
        dob.setText(sdf.format(myCalendar.getTime()));
    }
    DatePickerDialog.OnDateSetListener marriagedate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            marriageupdateLabel();
        }
    };

    private void marriageupdateLabel() {
        String myFormat = "MM/dd/yy"; // In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        statusdate.setText(sdf.format(myCalendar.getTime()));
    }
    @Override
    public void onClick(View arg0) {
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

