package com.example.android.engineeringpaathshala;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.engineeringpaathshala.ButtonContainer.ButtonValue;

/**
 * Created by Roshan on 10/20/2016.
 */
public class NotesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_layout);
        Button btn_syll = (Button) findViewById(R.id.syllabus);
        btn_syll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonValue.buttonClicked = 1;
               callIntent();

//                String url = "https://drive.google.com/file/d/0B9N4HvlxCb1zZjlPWEJWRXZZSEk/view";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);

            }
        });

        Button btn_notes = (Button) findViewById(R.id.notes);
        btn_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonValue.buttonClicked = 2;
               callIntent();
//                String url = "https://drive.google.com/open?id=0B9N4HvlxCb1zTzU1cUh6RjFaWnM";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);

            }
        });
    }
    private void callIntent(){
        Intent intent = new Intent(NotesActivity.this, WebViewActivity.class);
        startActivity(intent);
    }
}