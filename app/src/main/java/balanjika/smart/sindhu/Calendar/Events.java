package balanjika.smart.sindhu.Calendar;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import balanjika.smart.sindhu.smartbalanjka.R;
import dbhelper.DBHelper;

@SuppressLint("SimpleDateFormat")
public class Events extends AppCompatActivity {
    Cursor c=null;
    private CaldroidFragment caldroidFragment;
    int month;
    int dob;
    int count = 0;
    String birthday_list = "";
    String string_month,string_dob;
    private void setCustomResourceForDates() {
        Calendar cal = Calendar.getInstance();

        DBHelper myDbHelper = new DBHelper(Events.this);
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
                for (int i = 1900; i <= 2100; i++) {
                    string_month = c.getString(29);
                    string_dob = c.getString(28);
                    month = Integer.parseInt(string_month) - 1;
                    dob = Integer.parseInt(string_dob);
                    cal.set(i, month, dob);
                    Date blueDate = cal.getTime();
                    if (caldroidFragment != null) {
                        caldroidFragment.setBackgroundResourceForDate(R.color.blue, blueDate);
                        caldroidFragment.setTextColorForDate(R.color.white, blueDate);
                    }
                }
            } while (c.moveToNext());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendarevent);
        final SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
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
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int month_set = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                count = 0;
                if (c.moveToFirst()) {
                    do {
                        string_month = c.getString(29);
                        string_dob = c.getString(28);
                        month = Integer.parseInt(string_month) - 1;
                        dob = Integer.parseInt(string_dob);
                        if(month_set == month && day == dob){
                            count = count + 1;
                            birthday_list = birthday_list + c.getString(3);
                        }
                    } while (c.moveToNext());
                }
                if(count > 0){
                    showDialog();
//                    CustomDialogClassCalender cdd = new CustomDialogClassCalender(Events.this);
//                    cdd.show();
                    count = 0;
                    birthday_list = "";
                }
            }
            public void showDialog(){
//                AlertDialog.Builder builder = new AlertDialog.Builder(Events.this);
//                AlertDialog dialog = builder.create();
//                dialog.setIcon(R.drawable.birthday);
//                dialog.setTitle(getResources().getString(R.string.happybirthday));
//                dialog.setMessage(birthday_list);
//                dialog.setButton(getResources().getString(R.string.ok), listenerAccept);
//                dialog.setCancelable(false);
//                dialog.show();

                final Dialog dialog = new Dialog(Events.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_dialog_calendar);
//                dialog.setTitle(getResources().getString(R.string.happybirthday));
                TextView text = (TextView) dialog.findViewById(R.id.txt_dia_birth);
                text.setText(getResources().getString(R.string.happybirthday) + " " +birthday_list + "!!!");
                ImageView image = (ImageView) dialog.findViewById(R.id.imageView_birth);
                image.setImageResource(R.drawable.birthday);

                Button dialogButton = (Button) dialog.findViewById(R.id.birth_btn_ok);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
            DialogInterface.OnClickListener listenerAccept = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            };

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