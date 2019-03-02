package com.jcorp.timetable;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Assignment extends AppCompatActivity {
    private final static String TAG = "Assignment";
    private DatabaseReference assignmentRef;
    private FirebaseDatabase mdatabase;
    //private ArrayList<String>  AssignmentList = new ArrayList<>();
    private ListView listviewAssignment;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        mdatabase = FirebaseDatabase.getInstance();
        assignmentRef = mdatabase.getReference();
        //assignmentRef = assignmentRef.child("Assignment");
        listviewAssignment = (ListView) findViewById(R.id.listviewassin);


        assignmentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            Assignmentview uInfo = new Assignmentview();
            uInfo.setDueDate(ds.child("Assignmentdata").getValue(Assignmentview.class).getDueDate());
            uInfo.setAssignmentnum(ds.child("Assignmentdata").getValue(Assignmentview.class).getAssignmentnum());
            uInfo.setSUBJECT(ds.child("Assignmentdata").getValue(Assignmentview.class).getSUBJECT());

            //display all the information

            Log.d(TAG, "showData: date " + uInfo.getDueDate());
            Log.d(TAG, "showData: subj: " + uInfo.getSUBJECT());
            Log.d(TAG, "showData: assinnum: " + uInfo.getAssignmentnum());

            ArrayList<String> array  = new ArrayList<>();
            array.add(uInfo.getSUBJECT());
            array.add(uInfo.getDueDate());
            array.add(uInfo.getAssignmentnum());
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.activity_list_item,array);
            listviewAssignment.setAdapter(adapter);
        }
    }

}
