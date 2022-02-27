package com.example.activitycodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_PARAGRAPH = "com.android.twoactivity.extra.PARAGRAPH";
    public static final String EXTRA_HEADING= "com.android.twoactivity.extra.HEADING";

    Button firstButton, secondButton, thirdButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstButton = findViewById(R.id.first_button);
        secondButton = findViewById(R.id.second_button);
        thirdButton = findViewById(R.id.third_button);

        firstButton.setOnClickListener(this);
        secondButton.setOnClickListener(this);
        thirdButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int elementId = view.getId();
        String requiredHeading = "";
        String requiredParagraph = "";

        switch(elementId){
            case R.id.first_button:
                requiredHeading = getString(R.string.text_one);
                requiredParagraph = getString(R.string.first_paragraph);
                break;

            case R.id.second_button:
                requiredHeading = getString(R.string.text_two);
                requiredParagraph = getString(R.string.second_paragraph);
                break;

            case R.id.third_button:
                requiredHeading = getString(R.string.text_three);
                requiredParagraph = getString(R.string.third_paragraph);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + elementId);
        }

        Log.i("Paragraph", requiredParagraph);

        Intent intent = new Intent(this, SecondActivity.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_HEADING, requiredHeading);
        extras.putString(EXTRA_PARAGRAPH, requiredParagraph);

        intent.putExtras(extras);
        startActivity(intent);
    }
}