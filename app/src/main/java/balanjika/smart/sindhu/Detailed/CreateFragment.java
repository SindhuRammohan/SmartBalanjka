package balanjika.smart.sindhu.Detailed;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import balanjika.smart.sindhu.contacts.BloodList;
import balanjika.smart.sindhu.contacts.Contacts;
import balanjika.smart.sindhu.contacts.MatrimonyList;
import balanjika.smart.sindhu.contacts.healthtipList;
import balanjika.smart.sindhu.contacts.kdList;
import balanjika.smart.sindhu.smartbalanjka.R;
import balanjika.smart.sindhu.smartbalanjka.SharPref;

public class CreateFragment extends Fragment {

    private SharPref sharpref;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homescreen, container, false);
        sharpref = SharPref.getInstance(getActivity());
        LinearLayout history = (LinearLayout) rootView.findViewById(R.id.history_layout);
        Button history_Button = (Button) rootView.findViewById(R.id.history);
        TextView history_text = (TextView) rootView.findViewById(R.id.history_text);
        history_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),History.class);
                startActivity(nextScreen);
            }
        });
        history_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),History.class);
                startActivity(nextScreen);
            }
        });
        // Listening to button event
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),History.class);
                startActivity(nextScreen);

            }
        });

        LinearLayout contactus = (LinearLayout) rootView.findViewById(R.id.contactus_layout);
        Button contactus_Button = (Button) rootView.findViewById(R.id.contactus);
        TextView contactus_text = (TextView) rootView.findViewById(R.id.contactus_text);
        // Listening to button event
        contactus_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),Contactus.class);
                startActivity(nextScreen);
            }
        });
        contactus_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),Contactus.class);
                startActivity(nextScreen);
            }
        });
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),Contactus.class);
                startActivity(nextScreen);

            }
        });

        LinearLayout book = (LinearLayout) rootView.findViewById(R.id.book_layout);
        Button book_Button = (Button) rootView.findViewById(R.id.book);
        TextView bookname = (TextView) rootView.findViewById(R.id.bookname);
        // Listening to button event
        book_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),book.class);
                startActivity(nextScreen);
            }
        });
        bookname.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),book.class);
                startActivity(nextScreen);
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),book.class);
                startActivity(nextScreen);

            }
        });



        LinearLayout Contacts_layout = (LinearLayout) rootView.findViewById(R.id.Contacts_layout);
        Button Contacts_Button = (Button) rootView.findViewById(R.id.Contacts);
        TextView Contacts_text = (TextView) rootView.findViewById(R.id.Contacts_text);
        // Listening to button event
        Contacts_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),Contacts.class);
                startActivity(nextScreen);
            }
        });
        Contacts_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),Contacts.class);
                startActivity(nextScreen);
            }
        });
        Contacts_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),Contacts.class);
                startActivity(nextScreen);

            }
        });

        LinearLayout matrimony_layout = (LinearLayout) rootView.findViewById(R.id.matrimony_layout);
        Button matrimony_Button = (Button) rootView.findViewById(R.id.matrimony_head);
        TextView matrimony_text = (TextView) rootView.findViewById(R.id.matrimony_text);
        // Listening to button event
        matrimony_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),MatrimonyList.class);
                startActivity(nextScreen);
            }
        });
        matrimony_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),MatrimonyList.class);
                startActivity(nextScreen);
            }
        });
        matrimony_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),MatrimonyList.class);
                startActivity(nextScreen);

            }
        });


        LinearLayout blood_layout = (LinearLayout) rootView.findViewById(R.id.blood_layout);
        Button blood_Button = (Button) rootView.findViewById(R.id.blood);
        TextView blood_text = (TextView) rootView.findViewById(R.id.blood_text);
        // Listening to button event
        blood_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),BloodList.class);
                startActivity(nextScreen);
            }
        });
        blood_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),BloodList.class);
                startActivity(nextScreen);
            }
        });
        blood_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),BloodList.class);
                startActivity(nextScreen);

            }
        });

        LinearLayout kd_layout = (LinearLayout) rootView.findViewById(R.id.kd_layout);
        Button kd_Button = (Button) rootView.findViewById(R.id.kd);
        TextView kdtext = (TextView) rootView.findViewById(R.id.kdtext);
        // Listening to button event
        kd_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),kdList.class);
                startActivity(nextScreen);
            }
        });
        kdtext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),kdList.class);
                startActivity(nextScreen);
            }
        });
        kd_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),kdList.class);
                startActivity(nextScreen);

            }
        });


        LinearLayout health_layout = (LinearLayout) rootView.findViewById(R.id.health_layout);
        Button health_Button = (Button) rootView.findViewById(R.id.health);
        TextView healthtext = (TextView) rootView.findViewById(R.id.healthtext);
        // Listening to button event
        health_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),healthtipList.class);
                startActivity(nextScreen);
            }
        });
        healthtext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),healthtipList.class);
                startActivity(nextScreen);
            }
        });
        health_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getActivity().getApplicationContext(), healthtipList.class);
                startActivity(nextScreen);

            }
        });


        TextView myname = (TextView) rootView.findViewById(R.id.myname);
        myname.setText(getResources().getString(R.string.welcome) + " " + sharpref.getUsername());
        myname.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity().getApplicationContext(), ViewProfile.class);
                startActivity(nextScreen);
            }
        });



        return rootView;
    }
}