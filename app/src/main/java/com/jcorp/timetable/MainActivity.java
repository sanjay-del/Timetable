package com.jcorp.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import com.google.firebase.FirebaseApp;


public class MainActivity extends AppCompatActivity {

    public Button login;
    public Button routine;
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

        init();
        start();
        assin();

    }

}
