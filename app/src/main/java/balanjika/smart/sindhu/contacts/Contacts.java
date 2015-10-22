package balanjika.smart.sindhu.contacts;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;
import balanjika.smart.sindhu.smartbalanjka.R;
import dbhelper.DBHelper;

public class Contacts extends ActionBarActivity {
    private ListView lv;
    Cursor c=null;
    private ContactsListAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        lv = (ListView) findViewById(android.R.id.list);



        ArrayList<ContactListItems> contactList = new ArrayList<ContactListItems>();
        contactList.clear();
        DBHelper myDbHelper = new DBHelper(Contacts.this);
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
                ContactListItems contactListItems = new ContactListItems();
                contactListItems.setName(c.getString(3));
                contactListItems.setNo(c.getString(0));
                contactListItems.setPhone(c.getString(10));
                contactList.add(contactListItems);
            } while (c.moveToNext());
        }

        adapter = new ContactsListAdapter(Contacts.this, contactList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
                Intent nextScreen = new Intent(Contacts.this,Each_contact.class);
                TextView defaultID = (TextView) arg1.findViewById(R.id.defaultID);
                int id = Integer.parseInt(defaultID.getText().toString());
                nextScreen.putExtra("new_variable_name",id );
                startActivity(nextScreen);
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
