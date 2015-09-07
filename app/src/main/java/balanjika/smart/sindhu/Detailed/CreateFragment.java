package balanjika.smart.sindhu.Detailed;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import balanjika.smart.sindhu.smartbalanjka.R;

public class CreateFragment extends Fragment {
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homescreen, container, false);

        LinearLayout history = (LinearLayout) rootView.findViewById(R.id.history_layout);
        // Listening to button event
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),History.class);
                // Sending data to another Activity
                startActivity(nextScreen);

            }
        });

        LinearLayout contactus = (LinearLayout) rootView.findViewById(R.id.contactus_layout);
        // Listening to button event
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),Contactus.class);
                // Sending data to another Activity
                startActivity(nextScreen);

            }
        });

        LinearLayout book = (LinearLayout) rootView.findViewById(R.id.book_layout);
        // Listening to button event
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getActivity().getApplicationContext(),book.class);
                // Sending data to another Activity
                startActivity(nextScreen);

            }
        });


        return rootView;
    }
}