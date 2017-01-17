package com.example.android.engineeringpaathshala;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SemesterActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sem_layout);
        Button btn_4sem= (Button) findViewById(R.id.fourth_sem);
        btn_4sem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SemesterActivity.this,CourseActivity4.class);
                startActivity(intent);
            }
        });
        Button btn_6sem= (Button) findViewById(R.id.sixth_sem);
        btn_6sem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SemesterActivity.this,CourseActivity6.class);
                startActivity(intent);
            }
        });
    }
}
