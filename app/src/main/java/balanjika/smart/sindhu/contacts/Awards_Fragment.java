package balanjika.smart.sindhu.contacts;

import java.io.IOException;
import java.util.ArrayList;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import balanjika.smart.sindhu.smartbalanjka.R;
import dbhelper.DBHelper;

public class Awards_Fragment extends ListFragment {

    public static Awards_Fragment newInstance(String string) {
        return null;
    }

    private View mView;

    Cursor c = null;
    ArrayList<KDListItems> KDList = new ArrayList<KDListItems>();
    private ListView lv;
    private AwardsListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv = getListView();
        lv.setTextFilterEnabled(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.awardslist, container, false);
        DBHelper myDbHelper = new DBHelper(getActivity());
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }

        try {
            myDbHelper.openDataBase();
        } catch (Exception sqle) {
        }
        c = myDbHelper.query(getResources().getString(R.string.table_Awards), null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                KDListItems contactListItems = new KDListItems();
                contactListItems.setyear(c.getString(0));
                contactListItems.setcbsename1(c.getString(1));
                contactListItems.setcbseparents1(c.getString(2));
                contactListItems.setcbsemark1(c.getString(3));
                contactListItems.setSection(c.getString(4));
                KDList.add(contactListItems);
            } while (c.moveToNext());
        }

        lv = (ListView) mView.findViewById(android.R.id.list);

        adapter = new AwardsListAdapter(getActivity(), KDList);
        lv.setAdapter(adapter);

        FloatingActionButton fab_addawards = (FloatingActionButton) mView.findViewById(R.id.fab_addawards);
        fab_addawards.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addAwardsevents();
            }
        });

        return mView;
    }


    @Override
    public void onResume() {
        Log.e("DEBUG", "onResume of BloodList");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("DEBUG", "OnPause of BloodList");
        super.onPause();
    }

    public void addAwardsevents(){
        Intent nextScreen = new Intent(getActivity().getApplicationContext(), NewAwardsEvents.class);
        startActivity(nextScreen);
    }
}
