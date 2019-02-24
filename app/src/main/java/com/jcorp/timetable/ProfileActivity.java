package com.jcorp.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private TextView something;
    private Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this, MainActivity2.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();
        something = (TextView) findViewById(R.id.something);

        something.setText("Welcome" + user.getEmail());
        logout = (Button) findViewById(R.id.logout);

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
