package balanjika.smart.sindhu.Detailed;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import balanjika.smart.sindhu.smartbalanjka.R;

public class CreateFragment extends Fragment {
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homescreen, container, false);
        return rootView;
    }




}