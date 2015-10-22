package balanjika.smart.sindhu.contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.ListFragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import balanjika.smart.sindhu.smartbalanjka.R;
import dbhelper.DBHelper;

public class BloodList_Fragment extends ListFragment{

    public static BloodList_Fragment newInstance(String string) {
        return null;
    }

    List<String[]> list = new ArrayList<String[]>();
    private View mView;
    private EditText textview_countries;
    private String[] countries_list;
    private ContactsListAdapter adapter;
    private ListView lv;
    private LinearLayout emptylayout;
    private TextView empty;
    int count = 0;
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
        mView = inflater.inflate(R.layout.bloodlist, container, false);
        countries_list = getResources().getStringArray(R.array.blood_list);
        textview_countries = (EditText) mView.findViewById(R.id.bloodlist);
        emptylayout = (LinearLayout) mView.findViewById(R.id.emptylayoutblood);
        empty = (TextView) mView.findViewById(R.id.emptyblood);
        empty.setVisibility(View.VISIBLE);
        emptylayout.setVisibility(View.VISIBLE);
        textview_countries.setInputType(InputType.TYPE_NULL);
        final ArrayAdapter<String> spinner_countries = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,countries_list);
        textview_countries.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity()).setTitle(getResources().getString(R.string.Select_BloodGroup)).setAdapter(spinner_countries, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        textview_countries.setText(countries_list[which].toString());
                        spinner_countries.getPosition(countries_list[which].toString());
                        String text = BloodList_Fragment.this.textview_countries.getText().toString().toLowerCase();
                        ArrayList<ContactListItems> contactList = new ArrayList<ContactListItems>();
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
                        c = myDbHelper.query(getResources().getString(R.string.table_Profile), null, null, null, null, null, null);
                        if (c.moveToFirst()) {
                            do {
                                count = 0;
                                if(c.getString(11).equalsIgnoreCase(text)) {
                                    count = count + 1;
                                    ContactListItems contactListItems = new ContactListItems();
                                    contactListItems.setName(c.getString(3));
                                    contactListItems.setNo(c.getString(0));
                                    contactListItems.setPhone(c.getString(10));
                                    contactList.add(contactListItems);
                                }
                            } while (c.moveToNext());
                        }
                        adapter = new ContactsListAdapter(getActivity(), contactList);
                        lv.setAdapter(adapter);
                        if (count == 0) {
                            empty.setVisibility(View.VISIBLE);
                            emptylayout.setVisibility(View.VISIBLE);
                        } else {
                            empty.setVisibility(View.GONE);
                            emptylayout.setVisibility(View.GONE);
                        }
                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                                Intent nextScreen = new Intent(getActivity(), Each_contact.class);
                                TextView defaultID = (TextView) arg1.findViewById(R.id.defaultID);
                                int id = Integer.parseInt(defaultID.getText().toString());
                                nextScreen.putExtra("new_variable_name", id);
                                startActivity(nextScreen);
                            }
                        });

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

}
