package com.example.planmycday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
Button btnstart, btninfo, btnplan, btnsimu;
RadioGroup radiogroup;
RadioButton radioButton;

EditText num;
User user;

    private FirebaseDatabase database;
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btninfo = (Button) findViewById(R.id.batInfo);
        btnsimu = (Button) findViewById(R.id.batSimu);
        btnplan = (Button) findViewById(R.id.batCal);

        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInfo = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(intentInfo);
            }
        });

        btnplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInfo = new Intent(MainActivity.this, PlanningActivity.class);
                startActivity(intentInfo);
            }
        });

        btnsimu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInfo = new Intent(MainActivity.this, SimulationActivity.class);
                startActivity(intentInfo);
            }
        });


        num = (EditText) findViewById(R.id.yearsCD);
        btnstart = (Button) findViewById(R.id.batStart);

        user = new User();

        database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference().child("User");

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numa = Integer.parseInt(num.getText().toString().trim());
                user.setNum(numa);
                myRef.push().setValue(user);
            }
        });

        radiogroup = findViewById(R.id.radioGroup);
    }
        public void checkButton(View v){
            int radioID=radiogroup.getCheckedRadioButtonId();
            radioButton=findViewById(radioID);

        }



}
