package com.example.planmycday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class InformationActivity extends AppCompatActivity {
Button  btnplan, btnsimu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        btnsimu=(Button)findViewById(R.id.batSimu);
        btnplan=(Button)findViewById(R.id.batCal);


        btnplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInfo=new Intent(InformationActivity.this, PlanningActivity.class );
                startActivity(intentInfo);
            }
        });

        btnsimu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInfo=new Intent(InformationActivity.this, SimulationActivity.class );
                startActivity(intentInfo);
            }
        });

    }
}
