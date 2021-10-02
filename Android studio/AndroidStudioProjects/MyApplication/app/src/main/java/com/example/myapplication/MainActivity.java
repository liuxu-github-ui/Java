package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MainPage");


    }

    public void changeButtonText (View v){
        /*
       v.setEnabled(false);
       //Log.d("sucess","disabled");
        Button button = (Button) v;
        button.setText("Button disabled");

        TextView mytext= findViewById(R.id.textView);
        TextView text=(TextView) mytext;

        text.setText("Change!");


         */
    }

    public void userinputText(View v){

        Intent i = new Intent(this, SettingsActivity.class);
        i.putExtra("message","dummy");
        startActivity(i);

    }
}