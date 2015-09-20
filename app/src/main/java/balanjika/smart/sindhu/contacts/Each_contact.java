package balanjika.smart.sindhu.contacts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import balanjika.smart.sindhu.smartbalanjka.R;

/**
 * Created by rajesh on 20-09-2015.
 */
public class Each_contact extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
