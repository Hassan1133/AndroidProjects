package com.example.myfirstproject;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    ViewFlipper viewFlipper;
    List<Courses> coursesList;
    CoursesAdp adp;
    RecyclerView recyclerView;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment,container,false);
        recyclerTextColor(view);
        initialize(view);
        initializeRecycler(view);
        coursesListData();
        return view;
    }

    void recyclerTextColor(View view)
    {
        textView = view.findViewById(R.id.recycler_heading);
        textView.setText(Html.fromHtml("<font color = #030D45>WE PROVIDE</font> <font color = #FF6F00> BEST </font> <font color = #030D45 >YOUTUBE CHANNELS</font>"));
    }

    void initialize(View view)
    {
        viewFlipper = view.findViewById(R.id.flipper);
        int img[] = {R.drawable.android,R.drawable.web,R.drawable.flutter,R.drawable.dart,R.drawable.java,R.drawable.php,R.drawable.javascript,R.drawable.cplus,R.drawable.python};

        for (int i = 0; i<img.length; i++)
        {
            showSliderImage(img[i]);
        }
    }

    void showSliderImage(int img)
    {
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(img);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getActivity(),android.R.anim.slide_out_right);
    }

    void initializeRecycler(View view)
    {
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
    }

    void coursesListData()
    {
        coursesList = new ArrayList<Courses>();

        Courses android = new Courses(R.drawable.android_img,R.drawable.android_logo,"ANDROID DEVELOPMENT","Duo dolore et diam sed ipsum stet amet duo diam. Rebum amet ut amet sed erat sed sed amet magna elitr amet kasd diam duo");
        Courses web = new Courses(R.drawable.web_img,R.drawable.logo_nav,"WEB DEVELOPMENT","Duo dolore et diam sed ipsum stet amet duo diam. Rebum amet ut amet sed erat sed sed amet magna elitr amet kasd diam duo");
        Courses dart = new Courses(R.drawable.dart_img,R.drawable.dart_logo,"DART","Duo dolore et diam sed ipsum stet amet duo diam. Rebum amet ut amet sed erat sed sed amet magna elitr amet kasd diam duo");
        Courses flutter = new Courses(R.drawable.flutter_img,R.drawable.flutter_logo,"FLUTTER","Duo dolore et diam sed ipsum stet amet duo diam. Rebum amet ut amet sed erat sed sed amet magna elitr amet kasd diam duo");
        Courses java = new Courses(R.drawable.java_img,R.drawable.java_logo,"JAVA","Duo dolore et diam sed ipsum stet amet duo diam. Rebum amet ut amet sed erat sed sed amet magna elitr amet kasd diam duo");
        Courses javascript = new Courses(R.drawable.javascript_img,R.drawable.javascript_logo,"JAVASCRIPT","Duo dolore et diam sed ipsum stet amet duo diam. Rebum amet ut amet sed erat sed sed amet magna elitr amet kasd diam duo");
        Courses php = new Courses(R.drawable.php_img,R.drawable.php_logo,"PHP","Duo dolore et diam sed ipsum stet amet duo diam. Rebum amet ut amet sed erat sed sed amet magna elitr amet kasd diam duo");
        Courses python = new Courses(R.drawable.python_img,R.drawable.python_logo,"PYTHON","Duo dolore et diam sed ipsum stet amet duo diam. Rebum amet ut amet sed erat sed sed amet magna elitr amet kasd diam duo");

        coursesList.add(android);
        coursesList.add(web);
        coursesList.add(dart);
        coursesList.add(flutter);
        coursesList.add(java);
        coursesList.add(javascript);
        coursesList.add(php);
        coursesList.add(python);

        adp = new CoursesAdp(getActivity(),coursesList);
        recyclerView.setAdapter(adp);
    }
}
