package balanjika.smart.sindhu.contacts;

import java.io.IOException;
import java.util.ArrayList;
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

public class Awards_Fragment extends ListFragment {

    public static Awards_Fragment newInstance(String string) {
        // TODO Auto-generated method stub
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
        c = myDbHelper.query("Awards", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                KDListItems contactListItems = new KDListItems();
                contactListItems.setyear(c.getString(0));
                contactListItems.setcbsename1(c.getString(1));
                contactListItems.setcbseparents1(c.getString(2));
                contactListItems.setcbsemark1(c.getString(3));
                contactListItems.setcbsename2(c.getString(4));
                contactListItems.setcbseparents2(c.getString(5));
                contactListItems.setcbsemark2(c.getString(6));
                contactListItems.setcbsename3(c.getString(7));
                contactListItems.setcbseparents3(c.getString(8));
                contactListItems.setcbsemark3(c.getString(9));
                contactListItems.settw_name1(c.getString(10));
                contactListItems.settw_parents1(c.getString(11));
                contactListItems.settw_mark1(c.getString(12));
                contactListItems.settw_name2(c.getString(13));
                contactListItems.settw_parents2(c.getString(14));
                contactListItems.settw_mark2(c.getString(15));
                contactListItems.settw_name3(c.getString(16));
                contactListItems.settw_parents3(c.getString(17));
                contactListItems.settw_mark3(c.getString(18));
                contactListItems.sette_name1(c.getString(19));
                contactListItems.sette_parents1(c.getString(20));
                contactListItems.sette_mark1(c.getString(21));
                contactListItems.sette_name2(c.getString(22));
                contactListItems.sette_parents2(c.getString(23));
                contactListItems.sette_mark2(c.getString(24));
                contactListItems.sette_name3(c.getString(25));
                contactListItems.sette_parents3(c.getString(26));
                contactListItems.sette_mark3(c.getString(27));
                KDList.add(contactListItems);
            } while (c.moveToNext());
        }

        lv = (ListView) mView.findViewById(android.R.id.list);

        adapter = new AwardsListAdapter(getActivity(), KDList);
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
