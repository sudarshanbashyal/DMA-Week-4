package com.example.activitycodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView paragraph, heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        paragraph = findViewById(R.id.pragraph_text);
        heading = findViewById(R.id.pragraph_heading);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String paragraphText = extras.getString(MainActivity.EXTRA_PARAGRAPH);
        String headingText = extras.getString(MainActivity.EXTRA_HEADING);

        heading.setText(headingText);
        paragraph.setText(paragraphText);
    }
}