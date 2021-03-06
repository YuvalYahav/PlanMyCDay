package com.example.planmycday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CreateBehavior extends AppCompatActivity {
   private Button btninfo, btnplan;
   private Spinner spinner;

    ValueEventListener listener;
   // ArrayAdapter<String> adapter;
    //ArrayList<String> spinnerDataList;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_behavior);

        btninfo = (Button) findViewById(R.id.batInfo);
        btnplan = (Button) findViewById(R.id.batCal);

        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInfo = new Intent(CreateBehavior.this, InformationActivity.class);
                startActivity(intentInfo);
            }
        });

        btnplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInfo = new Intent(CreateBehavior.this, PlanningActivity.class);
                startActivity(intentInfo);
            }
        });

        reference= FirebaseDatabase.getInstance().getReference().child("Try");


        spinner=(Spinner) findViewById(R.id.spinner);
        final ArrayList<String> list=new ArrayList<>();
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        listener=reference.addValueEventListener(new ValueEventListener() {
             @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot item : dataSnapshot.getChildren()) {
                list.add(item.getValue().toString());
            }
            adapter.notifyDataSetChanged();
        }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String itemvalue=parent.getItemAtPosition(position).toString();
                Toast.makeText(CreateBehavior.this, "Selected "+itemvalue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });





         // spinner=findViewById(R.id.spinner);
        //ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.numbers, android)
        //spinnerDataList = new ArrayList<>();
        //reference= FirebaseDatabase.getInstance().getReference().child("Try");
        //adapter=new ArrayAdapter<String>(CreateBehavior.this, android.R.layout.simple_spinner_dropdown_item,spinnerDataList);


        //retrieveData();
        // spinner.setAdapter(adapter);
    }

   // public void retrieveData(){
     //   listener=reference.addValueEventListener(new ValueEventListener() {
        //    @Override
       //     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
         //       for(DataSnapshot item:dataSnapshot.getChildren()){
           //         spinnerDataList.add(item.getValue().toString());
             //   }
          //      adapter.notifyDataSetChanged();
            //}

            //@Override
            //public void onCancelled(@NonNull DatabaseError databaseError) {

            //}
        //});
    //}
}
