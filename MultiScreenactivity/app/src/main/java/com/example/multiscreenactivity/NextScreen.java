package com.example.multiscreenactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_screen);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.msg);

        TextView textView = findViewById(R.id.nstv1);
        textView.setText(message);
    }
}
