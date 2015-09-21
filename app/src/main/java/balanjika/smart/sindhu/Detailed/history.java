package balanjika.smart.sindhu.Detailed;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import balanjika.smart.sindhu.contacts.Contacts;
import balanjika.smart.sindhu.smartbalanjka.R;

/**
 * Created by rajesh on 07-09-2015.
 */
public class History extends ActionBarActivity {

    private TextView history_contentmore;
    private TextView history_contactsmore;
    private TextView history_kdmore;
    private TextView Donar_contentmore;
    private TextView history_matrimonymore;
    private TextView history_eventsmore;
    private TextView history_bookmore;
    private TextView history_healthmore;
    private TextView history_helpmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        history_contentmore = (TextView) findViewById(R.id.history_contentmore);
        history_contactsmore = (TextView) findViewById(R.id.history_contactsmore);
        Donar_contentmore = (TextView) findViewById(R.id.Donar_contentmore);
        history_kdmore = (TextView) findViewById(R.id.history_kdmore);
        history_eventsmore = (TextView) findViewById(R.id.history_eventsmore);
        history_matrimonymore = (TextView) findViewById(R.id.history_matrimonymore);
        history_bookmore = (TextView) findViewById(R.id.history_bookmore);
        history_healthmore = (TextView) findViewById(R.id.history_healthmore);
        history_helpmore = (TextView) findViewById(R.id.history_helpmore);

        history_helpmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), Contactus.class);
                startActivity(nextScreen);
            }
        });

        history_bookmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), book.class);
                startActivity(nextScreen);
            }
        });

        history_contentmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("http://www.youthbalanjika.com/"));
                startActivity(myWebLink);
            }
        });


        history_contactsmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), Contacts.class);
        startActivity(nextScreen);
    }
});
        
    }
}
