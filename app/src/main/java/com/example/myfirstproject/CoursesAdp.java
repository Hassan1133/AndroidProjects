package com.example.myfirstproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoursesAdp extends RecyclerView.Adapter<CoursesAdp.Holder>{

    Context context;
    List<Courses> coursesList;

    public CoursesAdp(Context context, List<Courses> coursesList) {
        this.context = context;
        this.coursesList = coursesList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Courses courses = coursesList.get(position);
        holder.main_img.setImageResource(courses.getMainImg());
        holder.icon.setImageResource(courses.getIcon());
        holder.heading.setText(courses.getHeading());
        holder.details.setText(courses.getDetails());
    }

    @Override
    public int getItemCount() {
        return coursesList.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        ImageView main_img, icon;
        TextView heading, details;

        public Holder(@NonNull View itemView) {
            super(itemView);

            main_img = itemView.findViewById(R.id.main_card_img);
            icon = itemView.findViewById(R.id.card_icon);
            heading = itemView.findViewById(R.id.card_heading);
            details = itemView.findViewById(R.id.card_text);

        }
    }
}
