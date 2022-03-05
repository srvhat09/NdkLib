package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.example.javawrapper.nativecall;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Native Call
        nativecall nc = new nativecall();
        // Example of a call to a native method
        TextView tv;
        tv = findViewById(R.id.sample_text);
        tv.setText(nc.getdata());
    }
}