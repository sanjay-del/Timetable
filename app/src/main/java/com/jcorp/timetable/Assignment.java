package com.jcorp.timetable;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Assignment extends AppCompatActivity {
    private final static String TAG = "Assignment";
    DatabaseReference assignmentRef;
    RecyclerView recyclerView;
    ArrayList<Assignmentview> list;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        recyclerView = (RecyclerView)findViewById(R.id.myRecylcer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<Assignmentview>();

        assignmentRef = FirebaseDatabase.getInstance().getReference().child("AssignmentData");

        assignmentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Assignmentview as = dataSnapshot1.getValue(Assignmentview.class);
                    list.add(as);



                }
                adapter = new MyAdapter(Assignment.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Something wrong", Toast.LENGTH_SHORT).show();

            }
        });


    }




}
