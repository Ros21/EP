package com.example.android.engineeringpaathshala;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Roshan on 10/20/2016.
 */
public class CourseActivity6 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sixth_sem_layout);
        Button btn_dc = (Button) findViewById(R.id.dc);
        btn_dc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseActivity6.this,NotesActivity.class);
                startActivity(intent);
            }
        });
    }}
