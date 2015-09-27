package balanjika.smart.sindhu.smartbalanjka;

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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import Mail.SendMailTask;

public class MyProfile extends ActionBarActivity implements View.OnClickListener {




    Calendar myCalendar = Calendar.getInstance();
    private String[] countries_list = {
            "Afghanistan",
            "Albania",
            "Algeria",
            "Andorra",
            "Angola",
            "Antigua and Barbuda",
            "Argentina",
            "Armenia",
            "Aruba",
            "Australia",
            "Austria",
            "Azerbaijan",

            "Bahamas",
            "Bahrain",
            "Bangladesh",
            "Barbados",
            "Belarus",
            "Belgium",
            "Belize",
            "Benin",
            "Bhutan",
            "Bolivia",
            "Bosnia and Herzegovina",
            "Botswana",
            "Brazil",
            "Brunei ",
            "Bulgaria",
            "Burkina Faso",
            "Burma",
            "Burundi",


            "Cambodia",
            "Cameroon",
            "Canada",
            "Cape Verde",
            "Central African Republic",
            "Chad",
            "Chile",
            "China",
            "Colombia",
            "Comoros",
            "Congo, Democratic Republic of the",
            "Congo, Republic of the",
            "Costa Rica",
            "Cote d'Ivoire",
            "Croatia",
            "Cuba",
            "Curacao",
            "Cyprus",
            "Czech Republic",



            "Denmark",
            "Djibouti",
            "Dominica",
            "Dominican Republic",


            "East Timor (see Timor-Leste)",
            "Ecuador",
            "Egypt",
            "El Salvador",
            "Equatorial Guinea",
            "Eritrea",
            "Estonia",
            "Ethiopia",



            "Fiji",
            "Finland",
            "France",


            "Gabon",
            "Gambia, The",
            "Georgia",
            "Germany",
            "Ghana",
            "Greece",
            "Grenada",
            "Guatemala",
            "Guinea",
            "Guinea-Bissau",
            "Guyana",


            "Haiti",
            "Holy See",
            "Honduras",
            "Hong Kong",
            "Hungary",



            "Iceland",
            "India",
            "Indonesia",
            "Iran",
            "Iraq",
            "Ireland",
            "Israel",
            "Italy",



            "Jamaica",
            "Japan",
            "Jordan",


            "Kazakhstan",
            "Kenya",
            "Kiribati",
            "Korea, North",
            "Korea, South",
            "Kosovo",
            "Kuwait",
            "Kyrgyzstan",



            "Laos",
            "Latvia",
            "Lebanon",
            "Lesotho",
            "Liberia",
            "Libya",
            "Liechtenstein",
            "Lithuania",
            "Luxembourg",





            "Macau",
            "Macedonia",
            "Madagascar",
            "Malawi",
            "Malaysia",
            "Maldives",
            "Mali",
            "Malta",
            "Marshall Islands",
            "Mauritania",
            "Mauritius",
            "Mexico",
            "Micronesia",
            "Moldova",
            "Monaco",
            "Mongolia",
            "Montenegro",
            "Morocco",
            "Mozambique",

            "Namibia",
            "Nauru",
            "Nepal",
            "Netherlands",
            "Netherlands Antilles",
            "New Zealand",
            "Nicaragua",
            "Niger",
            "Nigeria",
            "North Korea",
            "Norway",


            "Oman",




            "Pakistan",
            "Palau",
            "Palestinian Territories",
            "Panama",
            "Papua New Guinea",
            "Paraguay",
            "Peru",
            "Philippines",
            "Poland",
            "Portugal",


            "Qatar",


            "Romania",
            "Russia",
            "Rwanda",


            "Saint Kitts and Nevis",
            "Saint Lucia",
            "Saint Vincent and the Grenadines",
            "Samoa ",
            "San Marino",
            "Sao Tome and Principe",
            "Saudi Arabia",
            "Senegal",
            "Serbia",
            "Seychelles",
            "Sierra Leone",
            "Singapore",
            "Sint Maarten",
            "Slovakia",
            "Slovenia",
            "Solomon Islands",
            "Somalia",
            "South Africa",
            "South Korea",
            "South Sudan",
            "Spain ",
            "Sri Lanka",
            "Sudan",
            "Suriname",
            "Swaziland ",
            "Sweden",
            "Switzerland",
            "Syria",



            "Taiwan",
            "Tajikistan",
            "Tanzania",
            "Thailand",
            "Timor-Leste",
            "Togo",
            "Tonga",
            "Trinidad and Tobago",
            "Tunisia",
            "Turkey",
            "Turkmenistan",
            "Tuvalu",

            "Uganda",
            "Ukraine",
            "United Arab Emirates",
            "United Kingdom",
            "Uruguay",
            "Uzbekistan",


            "Vanuatu",
            "Venezuela",
            "Vietnam",


            "Yemen",


            "Zambia",
            "Zimbabwe"
    };
    private String[] blood_list = { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" };
    private String[] rashi_list = {
            "Mesha-Aries",
            "Vrishabha-Taurus",
            "Mithuna-Gemini",
            "Karka-Cancer",
            "Simha-Leo",
            "Kanya-Virgo",
            "Tula-Libra",
            "Vrishchika-Scorpio",
            "Dhanu-Sagittarius",
            "Makara-Capricorn",
            "Kumbha-Aquarius",
            "Meena-Pisces"
    };
    private String[] nakthara_list = {
            "Ashvini/Aswini-Aswini",
            "Bharani-Bharani",
            "Krittika/Krithika-Karthigai",
            "Rohini-Rohini",
            "Mrigashirsha-Mrigasheersham",
            "Ardra-Thiruvaathirai",
            "Punarvasu-Punarpoosam",
            "Pushya-Poosam",
            "Ashlesha-Aayilyam",
            "Magha-Makam",
            "Purva Phalguni-Pooram",
            "Uttara Phalguni-Uthiram",
            "Hasta-Hastham",
            "Chitra-Chithirai",
            "Swati-Swaathi",
            "Vishakha-Visaakam",
            "Anuradha-Anusham",
            "Jyeshtha-Kettai",
            "Mula-Moolam",
            "Purva Ashadha-Pooraadam",
            "Uttara Ashadha-Uthiraadam",
            "Shravana-Thiruvonam",
            "Dhanishtha-Avittam",
            "Shatabhisha  -Chathayam/Sadayam",
            "Purva Bhadrapada-Poorattathi",
            "Uttara Bhadrapada-Uthirattathi",
            "Revati-Revathi"	 };
    private String[] spinner_list= { "Married", "Single", "Diversed"};
    private String[] gender_list= { "Female", "Male"};
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

    private ProgressDialog pDialog;
    private String gmail_username_text;
    private String gmail_password_text;

    private SharPref sharpref;


    int type = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_details);
        sharpref = SharPref.getInstance(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
        }

        gender = (EditText) findViewById(R.id.gender);
        address = (EditText) findViewById(R.id.address);
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
                Rashi.setText("");
                Nakthara.setText("");
                Qualification.setText("");
                Work.setText("");
                Height.setText("");
                Weight.setText("");
                Notes.setText("");
            }
        });



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(gender.getText().toString().equalsIgnoreCase("") ||
                address.getText().toString().equalsIgnoreCase("")||
                City.getText().toString().equalsIgnoreCase("")||
                District.getText().toString().equalsIgnoreCase("")||
                Country.getText().toString().equalsIgnoreCase("")||
                phone.getText().toString().equalsIgnoreCase("")||
                textview_blood.getText().toString().equalsIgnoreCase("")||
                dob.getText().toString().equalsIgnoreCase("")||
                status.getText().toString().equalsIgnoreCase("")||
                statusdate.getText().toString().equalsIgnoreCase("")||
                Mail.getText().toString().equalsIgnoreCase("")||
                About.getText().toString().equalsIgnoreCase("")||
                question.getText().toString().equalsIgnoreCase("")||
                answer.getText().toString().equalsIgnoreCase(""))) {
                    type = 1;
                    gmail_username_text = sharpref.getMailUsername();
                    gmail_password_text = sharpref.getMailPassword();
                    String toEmails = getResources().getString(R.string.my_username);
                    List<String> toEmailList = Arrays.asList(toEmails
                            .split("\\s*,\\s*"));
                    new SendMailTask(MyProfile.this).execute(gmail_username_text,
                            gmail_password_text, toEmailList,
                            getResources().getString(R.string.addaccount_header),
                            getResources().getString(R.string.addaccount_content) + " " +
                            gender.getText().toString() +
                            address.getText().toString()
                            +City.getText().toString()
                            +District.getText().toString()
                            +Country.getText().toString()
                            +phone.getText().toString()
                            +textview_blood.getText().toString()
                            +dob.getText().toString()
                            +status.getText().toString()
                            +statusdate.getText().toString()
                            + Mail.getText().toString()
                            +About.getText().toString()
                            +question.getText().toString()
                            + answer.getText().toString()
                            + type);
                    Intent in = new Intent(MyProfile.this, LogIn.class);
                    startActivity(in);
                }else {
                    Toast.makeText(MyProfile.this, getResources().getString(R.string.blank_toast), Toast.LENGTH_LONG).show();
                }
            }
        });

        unregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(gender.getText().toString().equalsIgnoreCase("") ||
                        address.getText().toString().equalsIgnoreCase("")||
                        City.getText().toString().equalsIgnoreCase("")||
                        District.getText().toString().equalsIgnoreCase("")||
                        Country.getText().toString().equalsIgnoreCase("")||
                        phone.getText().toString().equalsIgnoreCase("")||
                        textview_blood.getText().toString().equalsIgnoreCase("")||
                        dob.getText().toString().equalsIgnoreCase("")||
                        status.getText().toString().equalsIgnoreCase("")||
                        statusdate.getText().toString().equalsIgnoreCase("")||
                        Mail.getText().toString().equalsIgnoreCase("")||
                        About.getText().toString().equalsIgnoreCase("")||
                        question.getText().toString().equalsIgnoreCase("")||
                        answer.getText().toString().equalsIgnoreCase("")||
                        Rashi.getText().toString().equalsIgnoreCase("")||
                        Nakthara.getText().toString().equalsIgnoreCase("")||
                        Qualification.getText().toString().equalsIgnoreCase("")||
                        Work.getText().toString().equalsIgnoreCase("")||
                        Height.getText().toString().equalsIgnoreCase("")||
                        Weight.getText().toString().equalsIgnoreCase("")||
                        Notes.getText().toString().equalsIgnoreCase(""))) {
                    type = 2;
                    gmail_username_text = sharpref.getMailUsername();
                    gmail_password_text = sharpref.getMailPassword();
                    String toEmails = getResources().getString(R.string.my_username);

                    List<String> toEmailList = Arrays.asList(toEmails
                            .split("\\s*,\\s*"));
                    new SendMailTask(MyProfile.this).execute(gmail_username_text,
                        gmail_password_text, toEmailList,
                        getResources().getString(R.string.addaccount_header),
                        getResources().getString(R.string.addaccount_content) + " " +
                        gender.getText().toString() +
                        address.getText().toString()
                        +City.getText().toString()
                        +District.getText().toString()
                        +Country.getText().toString()
                        +phone.getText().toString()
                        +textview_blood.getText().toString()
                        +dob.getText().toString()
                        +status.getText().toString()
                        + Mail.getText().toString()
                        +About.getText().toString()
                        +question.getText().toString()
                        + answer.getText().toString()
                        + Rashi.getText().toString()
                        +Nakthara.getText().toString()
                        +Qualification.getText().toString()
                        + Work.getText().toString()
                        +Height.getText().toString()
                        + Weight.getText().toString()
                        + Notes.getText().toString()
                        + type);
                    Intent in = new Intent(MyProfile.this, LogIn.class);
                    startActivity(in);
                } else {
                    Toast.makeText(MyProfile.this, getResources().getString(R.string.blank_toast), Toast.LENGTH_LONG).show();
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
        statusdate.setVisibility(View.GONE);
        textview_blood = (EditText) findViewById(R.id.Blood);
        dob = (EditText) findViewById(R.id.DOB);
        textview_blood.setInputType(InputType.TYPE_NULL); // To hide the
        // softkeyboard
        final ArrayAdapter<String> spinner_countries = new ArrayAdapter<String>(
                MyProfile.this, android.R.layout.simple_spinner_dropdown_item,
                countries_list);
        final ArrayAdapter<String> spinner_blood = new ArrayAdapter<String>(
                MyProfile.this, android.R.layout.simple_spinner_dropdown_item,
                blood_list);
        final ArrayAdapter<String> spinner_rashi = new ArrayAdapter<String>(
                MyProfile.this, android.R.layout.simple_spinner_dropdown_item,
                rashi_list);
        final ArrayAdapter<String> spinner_nakthara = new ArrayAdapter<String>(
                MyProfile.this, android.R.layout.simple_spinner_dropdown_item,
                nakthara_list);
        final ArrayAdapter<String> spinner_Gender = new ArrayAdapter<String>(
                MyProfile.this, android.R.layout.simple_spinner_dropdown_item,
                gender_list);

        gender.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MyProfile.this).setTitle(getResources().getString(R.string.Select_Gender)).setAdapter(spinner_Gender,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gender.setText(gender_list[which].toString());
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });
        Nakthara.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MyProfile.this).setTitle(getResources().getString(R.string.Select_Nakthara)).setAdapter(spinner_nakthara,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Nakthara.setText(nakthara_list[which].toString());
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });
        Rashi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MyProfile.this).setTitle(getResources().getString(R.string.Select_Rashi)).setAdapter(spinner_rashi,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Rashi.setText(rashi_list[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });
        textview_blood.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MyProfile.this).setTitle(getResources().getString(R.string.Select_BloodGroup)).setAdapter(spinner_blood,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                textview_blood.setText(blood_list[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        Country.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MyProfile.this).setTitle(getResources().getString(R.string.Select_Country)).setAdapter(spinner_countries,
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
                MyProfile.this, android.R.layout.simple_spinner_dropdown_item,
                spinner_list);
        status.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MyProfile.this).setTitle(getResources().getString(R.string.Select_Status)).setAdapter(date_spinner,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                status.setText(spinner_list[which].toString());
                                String text = MyProfile.this.status.getText().toString().toLowerCase();
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


        dob.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MyProfile.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        statusdate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MyProfile.this, marriagedate, myCalendar
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

}
