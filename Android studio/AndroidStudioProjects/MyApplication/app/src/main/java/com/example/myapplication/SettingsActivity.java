package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent i =getIntent();
        String messageFromotherPage = i.getStringExtra("message");

        // Display the messageFromotherPage:
        TextView mytext= findViewById(R.id.childTextView);
        TextView text=(TextView) mytext;
        text.setText(messageFromotherPage);

    }
}