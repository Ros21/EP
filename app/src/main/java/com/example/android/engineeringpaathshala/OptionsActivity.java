package com.example.android.engineeringpaathshala;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Roshan on 10/26/2016.
 */
public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_layout);

        findViewById(R.id.discussionforumid).setOnClickListener(this);
        findViewById(R.id.fileuploadid).setOnClickListener(this);
        findViewById(R.id.studymaterialid).setOnClickListener(this);
        findViewById(R.id.feedbackid).setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.fileuploadid:
                Intent i = new Intent(OptionsActivity.this, FireAppActivity.class);
                startActivity(i);
                break;

            case R.id.studymaterialid:
                Intent intent = new Intent(OptionsActivity.this, SemesterActivity.class);
                startActivity(intent);
                break;

            case R.id.feedbackid:
                Intent in = new Intent(OptionsActivity.this, FeedbackActivity.class);
                startActivity(in);
                break;

           case R.id.discussionforumid:
                break;
        }
    }
}