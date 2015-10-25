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

public class New_HealthTips  extends ActionBarActivity {

    private EditText title;
    private EditText newhealthIngredients;
    private EditText newdirections;
    private Button addrecipe;
    private SharPref sharpref;
    NetworkStateReceiver checkInternet = new NetworkStateReceiver();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_healthtips);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        sharpref = SharPref.getInstance(this);
        title = (EditText) findViewById(R.id.newhealthtitle);
        newhealthIngredients = (EditText) findViewById(R.id.newhealthIngredients);
        newdirections = (EditText) findViewById(R.id.newdirections);
        addrecipe = (Button) findViewById(R.id.addrecipe);



        addrecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(title.getText().toString().equalsIgnoreCase("") ||
                        newhealthIngredients.getText().toString().equalsIgnoreCase("") ||
                        newdirections.getText().toString().equalsIgnoreCase(""))) {
                    title.setText("");
                    newhealthIngredients.setText("");
                    newdirections.setText("");

                    String toEmails = getResources().getString(R.string.my_username);
                    List<String> toEmailList = Arrays.asList(toEmails
                            .split("\\s*,\\s*"));
                    if(checkInternet.isOnline(getApplicationContext())) {
                    new SendMailTask(New_HealthTips.this).execute(sharpref.getTempMailUsername(),
                            sharpref.getTempMailPassword(), toEmailList,
                            getResources().getString(R.string.healthHeader) + " " +
                            title.getText().toString(),
                            getResources().getString(R.string.healthaccount_content) + " " +
                            newhealthIngredients.getText().toString() + "\n" +
                                    newdirections.getText().toString());
                    } else {
                        Toast.makeText(New_HealthTips.this,getResources().getString(R.string.internet_connect_toast),Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(New_HealthTips.this, getResources().getString(R.string.correct_Details_toast), Toast.LENGTH_LONG).show();
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
