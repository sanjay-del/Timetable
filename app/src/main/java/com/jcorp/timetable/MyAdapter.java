package com.jcorp.timetable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Assignmentview> assignmentviews;

    public MyAdapter(Context c, ArrayList<Assignmentview> as){
        context = c;
        assignmentviews = as;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.assinfo,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.subj.setText(assignmentviews.get(i).getSubject());
        myViewHolder.date.setText(assignmentviews.get(i).getDuedate());
        myViewHolder.assinnum.setText(assignmentviews.get(i).getAssignmentnum());



    }

    @Override
    public int getItemCount() {
        return assignmentviews.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView subj,date, assinnum;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            subj = (TextView) itemView.findViewById(R.id.subj);
            date = (TextView) itemView.findViewById(R.id.date);
            assinnum = (TextView) itemView.findViewById(R.id.assinnum);

        }
    }
}
