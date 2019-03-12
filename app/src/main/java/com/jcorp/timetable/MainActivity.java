package com.jcorp.timetable;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    public Button login;
    public Button routine, pot;
    EditText msg;
    TextView board;
    DatabaseReference myRef;
    //DatabaseReference dref;
    public Button assignment;
    public void init(){
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy =  new Intent(MainActivity.this, MainActivity2.class);
                startActivity(toy);
            }
        });


    }

    public  void assin(){
        assignment = (Button)findViewById(R.id.assignment);
        assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pop = new Intent(MainActivity.this, Assignment.class);
                startActivity(pop);
            }
        });
    }
public void start(){
        routine = (Button)findViewById(R.id.routine);
        routine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yot = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(yot);
            }

        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //final DatabaseReference myRef = database.getReference().child("Notice");
        board = (TextView)findViewById(R.id.poster);
        //String messg = msg.getText().toString();


        //myRef.setValue(messg);
        myRef = FirebaseDatabase.getInstance().getReference("Notice");
        /*pot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messg = msg.getText().toString();
                myRef.setValue(messg);
               // myRef.setValue(messg);
                msg.setText("");
            }
        });*/
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String notice = dataSnapshot.getValue(String.class);
                //notice.setTextSize(15);
                board.setText("NoticeBoard  :: \n\t\t\t\t\t" + notice);
                //Toast.makeText(getApplicationContext(),  notice, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        init();
        start();
        assin();

    }

}
