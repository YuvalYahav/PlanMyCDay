package com.example.planmycday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlanningActivity extends AppCompatActivity {
    Button  btninfo, btnsimu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
        btninfo=(Button)findViewById(R.id.batInfo);
        btnsimu=(Button)findViewById(R.id.batSimu);

        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInfo=new Intent(PlanningActivity.this, InformationActivity.class );
                startActivity(intentInfo);
            }
        });


        btnsimu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInfo=new Intent(PlanningActivity.this, SimulationActivity.class );
                startActivity(intentInfo);
            }
        });


    }

}
