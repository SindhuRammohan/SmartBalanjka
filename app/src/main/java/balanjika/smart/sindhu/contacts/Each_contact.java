package balanjika.smart.sindhu.contacts;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import balanjika.smart.sindhu.smartbalanjka.R;
import dbhelper.DBHelper;

public class Each_contact extends ActionBarActivity{
    private int temp = 0;
    Cursor c=null;

    private TextView view_name;
    private TextView view_address;
    private TextView phone_number;
    private TextView bloodgrouptext;
    private TextView DOB;
    private TextView Social;
    private TextView Nakthara;
    private TextView Notes;
    private TextView Qualification;
    private TextView Qccupation;
    private TextView Age;
    private TextView Height;
    private TextView About;
    private TextView Rashi;
    private TextView mail_id;
    private TextView Marital;
    private TextView Maritaldate;
    private TextView Gender;
    private ImageButton Phoneimg;
    private ImageButton mailimg;
    private ImageButton sms;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Intent intent = getIntent();
            temp = intent.getIntExtra("new_variable_name",0);
        }

        view_name = (TextView) findViewById(R.id.view_name);
        view_address = (TextView) findViewById(R.id.view_address);
        phone_number = (TextView) findViewById(R.id.phone_number);
        Marital = (TextView) findViewById(R.id.Marital);
        Maritaldate = (TextView) findViewById(R.id.Maritaldate);
        bloodgrouptext = (TextView) findViewById(R.id.bloodgrouptext);
        DOB = (TextView) findViewById(R.id.DOBview);
        Gender = (TextView) findViewById(R.id.Genderview);
        Social = (TextView) findViewById(R.id.Social);
        Notes = (TextView) findViewById(R.id.Notesview);
        Rashi = (TextView) findViewById(R.id.Rashiview);
        Nakthara = (TextView) findViewById(R.id.Naktharaview);
        Qualification = (TextView) findViewById(R.id.Qualificationview);
        Qccupation = (TextView) findViewById(R.id.Qccupation);
        Age = (TextView) findViewById(R.id.Age);
        Height = (TextView) findViewById(R.id.Heightandweight);
        About = (TextView) findViewById(R.id.Aboutview);
        mail_id=(TextView) findViewById(R.id.Mail_number);

        DBHelper myDbHelper = new DBHelper(Each_contact.this);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }

        try {
            myDbHelper.openDataBase();
        } catch (Exception sqle) {
        }


        c = myDbHelper.query(getResources().getString(R.string.table_Profile), null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                if (c.getString(0).equalsIgnoreCase(Integer.toString(temp))) {
                    view_name.setText(c.getString(3));
                    view_address.setText(c.getString(6)+","+"\n"+c.getString(7)+","+"\n"+c.getString(8)+","+"\n"+c.getString(9)+".");
                    phone_number.setText(c.getString(10));
                    Marital .setText(c.getString(13));
                    Maritaldate.setText(c.getString(14));
                    bloodgrouptext .setText(c.getString(11));
                    Gender.setText(c.getString(5    ));
                    DOB .setText(c.getString(12));
                    Social .setText(c.getString(15));
                    Notes.setText(c.getString(16) +","+ "\n" + c.getString(17) +","+ "\n" + c.getString(18)+".");
                    Rashi .setText(c.getString(20));
                    Nakthara .setText(c.getString(21));
                    Qualification.setText(c.getString(22));
                    Qccupation.setText(c.getString(23));
//                    Age .setText(c.getString(28));
                    Height.setText(c.getString(24)+" , "+c.getString(25));
                    About.setText(c.getString(26));
                    mail_id.setText(c.getString(1));
                }

            } while (c.moveToNext());
        }


        mailimg= (ImageButton) findViewById(R.id.mailimg);
        mailimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] recipients = { mail_id.getText().toString() };
                Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                // prompts email clients only
                email.setType("message/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL, recipients);
                try {
                    // the user can choose the email client
                    startActivity(Intent.createChooser(email,
                            getResources().getString(R.string.choose_email)));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Each_contact.this,  getResources().getString(R.string.No_email),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
       final String smsNumber = phone_number.getText().toString();
        sms= (ImageButton) findViewById(R.id.sms);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:" + smsNumber);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(intent);
            }
        });

        Phoneimg = (ImageButton) findViewById(R.id.Phone);
        Phoneimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + smsNumber));
                startActivity(callIntent);
            }
        });
    }

}
