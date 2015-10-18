package balanjika.smart.sindhu.contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import balanjika.smart.sindhu.smartbalanjka.R;
import dbhelper.DBHelper;

public class ICEList_Fragment extends ListFragment {

    public static ICEList_Fragment newInstance(String string) {
        // TODO Auto-generated method stub
        return null;
    }

    List<String[]> list = new ArrayList<String[]>();
    private View mView;
    ArrayList<HashMap<String, String>> contactList;
    private ICEContactsListAdapter adapter;
    private ListView lv;
    Cursor c=null;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.contacts, container, false);
        contactList = new ArrayList<HashMap<String, String>>();

        ArrayList<ICEContactListItems> contactList = new ArrayList<ICEContactListItems>();
        contactList.clear();
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
        c = myDbHelper.query(getResources().getString(R.string.table_ICE), null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                ICEContactListItems ICEcontactListItems = new ICEContactListItems();
                ICEcontactListItems.setName(c.getString(0));
                ICEcontactListItems.setPhone(c.getString(1));
                contactList.add(ICEcontactListItems);
            } while (c.moveToNext());
        }
        lv = (ListView) mView.findViewById(android.R.id.list);
        adapter = new ICEContactsListAdapter(getActivity(), contactList);
        lv.setAdapter(adapter);
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
}

