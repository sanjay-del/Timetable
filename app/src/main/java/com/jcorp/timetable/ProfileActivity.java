package com.jcorp.timetable;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ProfileActivity";


    private FirebaseAuth firebaseAuth;
    private TextView something;
    private Button logout;
    private Button update,post;
    private EditText sub,date,num,notice;


    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sub = (EditText) findViewById(R.id.asubject);
        date = (EditText) findViewById(R.id.adate);
        num = (EditText) findViewById(R.id.anum);
        logout = (Button) findViewById(R.id.logout);
        update = (Button) findViewById(R.id.updateAssi);
        post = (Button) findViewById(R.id.post);
        notice = (EditText) findViewById(R.id.notice);




        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this, MainActivity2.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();
        something = (TextView) findViewById(R.id.something);

        something.setText("Welcome  " + user.getEmail());

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object value = dataSnapshot.getValue();
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                //("Failed to alter database.");
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.d(TAG, "onClick: Attempting to add object to database.");
                String subject = sub.getText().toString();
                String duedate = date.getText().toString();
                String assnum = num.getText().toString();
                if (!subject.equals("")&& !duedate.equals("") && !assnum.equals("")) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    String userId = user.getUid();
                    myRef.child("AssignmentData").child(userId).child(subject).child("subject").setValue("Subject  "+subject);
                    myRef.child("AssignmentData").child(userId).child(subject).child("duedate").setValue("Duedate  "+duedate);
                    myRef.child("AssignmentData").child(userId).child(subject).child("assignmentnum").setValue("Assignmentnum  "+assnum);

                    Toast.makeText(getApplicationContext(),"Adding items to database...",Toast.LENGTH_SHORT).show();
                    //reset the text
                    sub.setText("");
                    date.setText("");
                    num.setText("");
                }
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = notice.getText().toString();
                if(!note.equals("")){
                    FirebaseUser user = mAuth.getCurrentUser();
                    String userId = user.getUid();
                    myRef.child("Notice").setValue(note);
                    Toast.makeText(getApplicationContext(),"Posting Notice",Toast.LENGTH_SHORT).show();
                    //reset the text
                    notice.setText("");

                }
            }
        });


        logout.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v == logout)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

    }
}
