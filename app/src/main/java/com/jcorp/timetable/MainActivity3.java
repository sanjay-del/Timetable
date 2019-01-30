package com.jcorp.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewDatabase;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
public class MainActivity3 extends AppCompatActivity {

    public Button submit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        submit =(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, viewdatabase.class);
                startActivity(intent);
            }
        });


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity3.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(MainActivity3.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sem));


        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mySpinner.setAdapter(myAdapter);
        mySpinner1.setAdapter(myAdapter1);




    }
}
