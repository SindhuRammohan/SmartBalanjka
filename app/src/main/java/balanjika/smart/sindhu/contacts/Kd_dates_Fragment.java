package balanjika.smart.sindhu.contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import balanjika.smart.sindhu.smartbalanjka.R;
import dbhelper.DBHelper;

public class Kd_dates_Fragment extends ListFragment {

    public static Kd_dates_Fragment newInstance(String string) {
        return null;
    }

    List<String[]> list = new ArrayList<String[]>();
    private View mView;
    private EditText textview_countries;
    private String[] countries_list;
    JSONArray contacts = null;
    Cursor c=null;
    private ProgressDialog pDialog;
    ArrayList<HashMap<String, String>> contactList;
    private ListView lv;
    private LinearLayout emptylayout;
    private TextView empty;
    private KDAdapter adapter;
    int count = 0;
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
        mView = inflater.inflate(R.layout.kdlist, container, false);
        countries_list = getResources().getStringArray(R.array.kd_list);
        textview_countries = (EditText) mView.findViewById(R.id.kdeditlist);
        emptylayout = (LinearLayout) mView.findViewById(R.id.emptylayout);
        empty = (TextView) mView.findViewById(R.id.empty);

        FloatingActionButton fab_addkd = (FloatingActionButton) mView.findViewById(R.id.fab_addkd);
        fab_addkd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addkdevents();
            }
        });

        empty.setVisibility(View.VISIBLE);
        emptylayout.setVisibility(View.VISIBLE);
        textview_countries.setInputType(InputType.TYPE_NULL);
        contactList = new ArrayList<HashMap<String, String>>();
        final ArrayAdapter<String> spinner_countries = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,countries_list);
        textview_countries.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                contactList.clear();
                new AlertDialog.Builder(getActivity()).setTitle(getResources().getString(R.string.event_type)).setAdapter(spinner_countries, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textview_countries.setText(countries_list[which].toString());
                        spinner_countries.getPosition(countries_list[which].toString());
                        String text = Kd_dates_Fragment.this.textview_countries.getText().toString().toLowerCase();
                        ArrayList<KDItems> contactList = new ArrayList<KDItems>();
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
                        c = myDbHelper.query(getResources().getString(R.string.table_kd), null, null, null, null, null, null);
                        if (c.moveToFirst()) {
                            do {
                                count = 0;
                                if (c.getString(0).equalsIgnoreCase(text)) {
                                    count = count + 1;
                                    KDItems contactListItems = new KDItems();
                                    contactListItems.setVenue(c.getString(1));
                                    contactListItems.setDate(c.getString(2));
                                    contactListItems.setTime(c.getString(3));
                                    contactListItems.setContact(c.getString(6));
                                    contactListItems.setSpecification(c.getString(4));
                                    contactListItems.setothers(c.getString(5));
                                    contactList.add(contactListItems);
                                }
                            } while (c.moveToNext());
                        }

                        lv = (ListView) mView.findViewById(android.R.id.list);
                        adapter = new KDAdapter(getActivity(), contactList);
                        lv.setAdapter(adapter);
                        if (count == 0) {
                            empty.setVisibility(View.VISIBLE);
                            emptylayout.setVisibility(View.VISIBLE);
                        } else {
                            empty.setVisibility(View.GONE);
                            emptylayout.setVisibility(View.GONE);
                        }
                        dialog.dismiss();
                    }
                }).create().show();
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

    public void addkdevents(){
        Intent nextScreen = new Intent(getActivity().getApplicationContext(), NewKDEvents.class);
        startActivity(nextScreen);
    }
}