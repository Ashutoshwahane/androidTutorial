package com.example.multiscreenactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String msg = "com.example.multiscreenactivity.msg";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void jumpTo(View view){

        Intent intent = new Intent(this, NextScreen.class);

        EditText editText1 = findViewById(R.id.et1);
        EditText editText2 = findViewById(R.id.et2);

        String message = editText1.getText().toString() + " , " + editText2.getText().toString();
        intent.putExtra(msg, message);
        startActivity(intent);

    }
}
