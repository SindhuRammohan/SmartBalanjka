package balanjika.smart.sindhu.contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import balanjika.smart.sindhu.smartbalanjka.R;
import dbhelper.DBHelper;

public class healthtipList extends ActionBarActivity {
    ArrayList<HashMap<String, String>> contactList;
    private ListView lv;
    Cursor c=null;
    private healthAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.awardslist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        lv = (ListView) findViewById(android.R.id.list);



        ArrayList<HealthItems> HealthList = new ArrayList<HealthItems>();
        contactList.clear();
        DBHelper myDbHelper = new DBHelper(healthtipList.this);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }

        try {
            myDbHelper.openDataBase();
        } catch (Exception sqle) {
        }
        c = myDbHelper.query("Health", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                HealthItems contactListItems = new HealthItems();
                contactListItems.setTitle(c.getString(0));
                contactListItems.setIngredients(c.getString(1));
                contactListItems.setTime(c.getString(2));
                contactListItems.setDirection(c.getString(3));
                HealthList.add(contactListItems);
            } while (c.moveToNext());
        }

        adapter = new healthAdapter(healthtipList.this, HealthList);
        lv.setAdapter(adapter);
    }


}
