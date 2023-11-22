package com.example.myfirstproject;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_fragment,container,false);
        aboutHeadingStyle(view);
        return view;
    }

    void aboutHeadingStyle(View view)
    {
        textView = view.findViewById(R.id.about_heading);
        textView.setText(Html.fromHtml("<font color = #030D45>WE ARE</font> <font color = #FF6F00> THE LEADER </font> <font color = #030D45 >IN CODING</font>"));
    }
}
