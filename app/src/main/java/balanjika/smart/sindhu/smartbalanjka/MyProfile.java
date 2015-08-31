package balanjika.smart.sindhu.smartbalanjka;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import Mail.SendMailTask;

public class MyProfile extends Activity implements View.OnClickListener {




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
    private String[] blood_list = { "A+", "A-", "B+", "B-", "O+", "O-",
            "AB+", "AB-" };
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
    private EditText my;
    private EditText textview_countries;
    private EditText editText8;
    private EditText status;
    private EditText question;
    private EditText answer;
    private EditText statusdate;
    private Button matrimony;
    private TextView myName;
    private TextView MailId;
    private Button save;
    private String mailid;
    private int temp;

    private ProgressDialog pDialog;
    private String gmail_username_text;
    private String gmail_password_text;
    private String username_text;
    private String password_text;

    private SharPref sharpref;



    String whole_content;
    int type = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_details);

        sharpref = SharPref.getInstance(this);
//
//        ActionBar bar = getActionBar();
//        getActionBar();
//
//
//        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#81BEF7")));
//        bar.setHomeButtonEnabled(true);
        mailid = getResources().getString(R.string.mailid);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Intent intent = getIntent();
            gmail_username_text = intent.getStringExtra("gmail_username_text");
            gmail_password_text = intent.getStringExtra("gmail_password_text");
            username_text = intent.getStringExtra("username_text");
            password_text = intent.getStringExtra("password_text");
        }






        my = (EditText) findViewById(R.id.name);

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
                if(!(my.getText().toString().equalsIgnoreCase("") ||
                        address.getText().toString().equalsIgnoreCase("")||
                        City.getText().toString().equalsIgnoreCase("")||
                        District.getText().toString().equalsIgnoreCase("")||
                        Country.getText().toString().equalsIgnoreCase("")||
                        phone.getText().toString().equalsIgnoreCase("")||
                        textview_countries.getText().toString().equalsIgnoreCase("")||
                        editText8.getText().toString().equalsIgnoreCase("")||
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
                                    my.getText().toString() +
                                    address.getText().toString()
                                    +City.getText().toString()
                                    +District.getText().toString()
                                    +Country.getText().toString()
                                    +phone.getText().toString()
                                    +textview_countries.getText().toString()
                                    +editText8.getText().toString()
                                    +status.getText().toString()
                                    +statusdate.getText().toString()
                                    + Mail.getText().toString()
                                    +About.getText().toString()
                                    +question.getText().toString()
                                    + answer.getText().toString()
                                    + type);
                    Intent in = new Intent(MyProfile.this, LogIn.class);
                    startActivity(in);
            }
            }


        });

        unregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(my.getText().toString().equalsIgnoreCase("") ||
                        address.getText().toString().equalsIgnoreCase("")||
                        City.getText().toString().equalsIgnoreCase("")||
                        District.getText().toString().equalsIgnoreCase("")||
                        Country.getText().toString().equalsIgnoreCase("")||
                        phone.getText().toString().equalsIgnoreCase("")||
                        textview_countries.getText().toString().equalsIgnoreCase("")||
                        editText8.getText().toString().equalsIgnoreCase("")||
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
                                    my.getText().toString() +
                                    address.getText().toString()
                                    +City.getText().toString()
                                    +District.getText().toString()
                                    +Country.getText().toString()
                                    +phone.getText().toString()
                                    +textview_countries.getText().toString()
                                    +editText8.getText().toString()
                                    +status.getText().toString()
                                    +statusdate.getText().toString()
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

        textview_countries = (EditText) findViewById(R.id.Blood);
        editText8 = (EditText) findViewById(R.id.DOB);
        textview_countries.setInputType(InputType.TYPE_NULL); // To hide the
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
        my.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MyProfile.this)

                        .setTitle("Select Gender")

                        .setAdapter(spinner_Gender,
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {

                                        my
                                                .setText(gender_list[which]
                                                        .toString());

                                        dialog.dismiss();

                                    }

                                }).create().show();

            }

        });
        Nakthara.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MyProfile.this)

                        .setTitle("Select Nakthara")

                        .setAdapter(spinner_nakthara,
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {

                                        Nakthara
                                                .setText(nakthara_list[which]
                                                        .toString());

                                        dialog.dismiss();

                                    }

                                }).create().show();

            }

        });
        Rashi.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MyProfile.this)

                        .setTitle("Select Rashi")

                        .setAdapter(spinner_rashi,
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {

                                        Rashi
                                                .setText(rashi_list[which]
                                                        .toString());

                                        dialog.dismiss();

                                    }

                                }).create().show();

            }

        });
        textview_countries.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MyProfile.this)

                        .setTitle("Select BloodGroup")

                        .setAdapter(spinner_blood,
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {

                                        textview_countries
                                                .setText(blood_list[which]
                                                        .toString());

                                        dialog.dismiss();

                                    }

                                }).create().show();

            }

        });




        Country.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MyProfile.this)

                        .setTitle("Select Country")

                        .setAdapter(spinner_countries,
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {

                                        Country
                                                .setText(countries_list[which]
                                                        .toString());

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

                new AlertDialog.Builder(MyProfile.this)

                        .setTitle("Select Status")

                        .setAdapter(date_spinner,
                                new DialogInterface.OnClickListener() {



                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {

                                        status
                                                .setText(spinner_list[which]
                                                        .toString());
                                        String text = MyProfile.this.status.getText().toString().toLowerCase();

//										Toast.makeText(newprofile.this,"blood"+text,Toast.LENGTH_SHORT).show();
                                        if(text.compareTo("married")==0)

                                        {
                                            statusdate.setVisibility(View.VISIBLE);
                                        }
                                        else
                                        {
                                            statusdate.setVisibility(View.GONE);
                                        }
                                        dialog.dismiss();

                                    }

                                }).create().show();

            }

        });






        editText8.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MyProfile.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        statusdate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MyProfile.this, marriagedate, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};

//        try {
//            InputStreamReader csvStreamReader = new InputStreamReader(
//                    this.getAssets().open(
//                            "Category.csv"));
//
//            @SuppressWarnings("resource")
//            CSVReader reader = new CSVReader(csvStreamReader);
//            for (;;) {
//                next = reader.readNext();
//                if (next != null) {
//                    list.add(next);
//                } else {
//                    break;
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        if(temp>0)
        {
            my.setText(list.get(temp)[1]);

            address.setText(list.get(temp)[3]);
            City.setText(list.get(temp)[4]);
            District.setText(list.get(temp)[5]);
            Country.setText(list.get(temp)[6]);
            phone.setText(list.get(temp)[8]);
            textview_countries.setText(list.get(temp)[9]);
            editText8.setText(list.get(temp)[2]);
            status.setText(list.get(temp)[21]);
            statusdate.setText(list.get(temp)[22]);
            Mail.setText(list.get(temp)[10]);
            About.setText(list.get(temp)[11]);
            if(list.get(temp)[13]!="")
            {
                linear.setVisibility(View.VISIBLE);
                matrimony.setVisibility(View.GONE);
                save.setVisibility(View.GONE);
            }
            Rashi.setText(list.get(temp)[12]);
            Nakthara.setText(list.get(temp)[13]);
            Qualification.setText(list.get(temp)[17]);

            Work.setText(list.get(temp)[16]);
            Height.setText(list.get(temp)[14]);
            Weight.setText(list.get(temp)[15]);



            Notes.setText(list.get(temp)[18]);

        }




    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };

    private void updateLabel() {

        String myFormat = "MM/dd/yy"; // In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editText8.setText(sdf.format(myCalendar.getTime()));
    }
    DatePickerDialog.OnDateSetListener marriagedate = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
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

        // TODO Auto-generated method stub

    }
//    private class save_content extends AsyncTask<Void, Void, Void> {
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            pDialog = new ProgressDialog(MyProfile.this);
//            pDialog.setMessage("Please wait...");
//            pDialog.setCancelable(false);
//            pDialog.show();
//        }
//
////        @Override
////        protected Void doInBackground(Void... arg0) {
////            ServiceHandler sh = new ServiceHandler();
////            String jsonStr = sh.makeServiceCall(categoty_url_insert, ServiceHandler.GET);
////            Log.d("Response: ", "> " + jsonStr);
//////			if (jsonStr != null) {
//////				try {
//////					contacts = new JSONArray(jsonStr);
//////					for (int i = 0; i < contacts.length(); i++) {
//////						JSONObject c = contacts.getJSONObject(i);
//////						String id = c.getString(TAG_ID);
//////						Log.d("TAG_ID: ", "> " + c.getString(TAG_NAME));
//////						String name = c.getString(TAG_NAME);
//////						HashMap<String, String> contact = new HashMap<String, String>();
//////						contact.put(TAG_ID, id);
//////						contact.put(TAG_NAME, name);
//////						contactList.add(contact);
//////					}
//////				} catch (JSONException e) {
//////					e.printStackTrace();
//////				}
//////			} else {
//////				Log.e("ServiceHandler", "Couldn't get any data from the url");
//////			}
////            return null;
////        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            super.onPostExecute(result);
//            if (pDialog.isShowing())
//                pDialog.dismiss();
//
//        }
//    }
//
////	@Override
////	public boolean onMenuItemSelected(int featureId, MenuItem item) {
////
////		int itemId = item.getItemId();
////		switch (itemId) {
////		case android.R.id.home:
////			super.onBackPressed();
////			break;
////
////
////		}
////
////		return true;
////	}
//
//
//
////	@Override
////	public void onBackPressed() {
////		super.onBackPressed();
//	}
}
