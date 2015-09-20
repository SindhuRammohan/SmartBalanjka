package balanjika.smart.sindhu.Detailed;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import balanjika.smart.sindhu.contacts.Contacts;
import balanjika.smart.sindhu.smartbalanjka.R;

public class CreateFragment extends Fragment {
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homescreen, container, false);

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


        return rootView;
    }
}