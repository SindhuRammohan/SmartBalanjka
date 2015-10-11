package balanjika.smart.sindhu.Calendar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;
import java.util.Calendar;
import java.util.Date;
import balanjika.smart.sindhu.smartbalanjka.R;

@SuppressLint("SimpleDateFormat")
public class Events extends AppCompatActivity {
    private boolean undo = false;
    private CaldroidFragment caldroidFragment;

    private void setCustomResourceForDates() {
        Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.DECEMBER, 16);
        Date greenDate = cal.getTime();
        if (caldroidFragment != null) {
            caldroidFragment.setBackgroundResourceForDate(R.color.blue, greenDate);
            caldroidFragment.setTextColorForDate(R.color.white, greenDate);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendarevent);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        caldroidFragment = new CaldroidFragment();
        if (savedInstanceState != null) {
            caldroidFragment.restoreStatesFromKey(savedInstanceState, "CALDROID_SAVED_STATE");
        }
        else {
            Bundle args = new Bundle();
            Calendar cal = Calendar.getInstance();
            args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
            args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
            args.putBoolean(CaldroidFragment.ENABLE_SWIPE, true);
            args.putBoolean(CaldroidFragment.SIX_WEEKS_IN_CALENDAR, true);
            caldroidFragment.setArguments(args);
        }

        setCustomResourceForDates();
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendar1, caldroidFragment);
        t.commit();
        final CaldroidListener listener = new CaldroidListener() {
            @Override
            public void onSelectDate(Date date, View view) {
            }

            @Override
            public void onChangeMonth(int month, int year) {
            }

            @Override
            public void onLongClickDate(Date date, View view) {
            }

            @Override
            public void onCaldroidViewCreated() {
                if (caldroidFragment.getLeftArrowButton() != null) {
                }
            }
        };
        caldroidFragment.setCaldroidListener(listener);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        if (caldroidFragment != null) {
            caldroidFragment.saveStatesToKey(outState, "CALDROID_SAVED_STATE");
        }
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