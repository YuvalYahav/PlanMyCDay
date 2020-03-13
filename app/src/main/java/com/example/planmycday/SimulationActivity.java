package com.example.planmycday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SimulationActivity extends AppCompatActivity {
    Button  btninfo, btnplan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);

        btninfo=(Button)findViewById(R.id.batInfo);
        btnplan=(Button)findViewById(R.id.batCal);

        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInfo=new Intent(SimulationActivity.this, InformationActivity.class );
                startActivity(intentInfo);
            }
        });

        btnplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInfo=new Intent(SimulationActivity.this, PlanningActivity.class );
                startActivity(intentInfo);
            }
        });



    }
}
