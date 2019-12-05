  package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

  public class MainActivity extends AppCompatActivity {

    public void btnClick(View view){
        EditText dollaramount =(EditText) findViewById(R.id.dollaramount);
        String dollar = dollaramount.getText().toString();
        Double doubleDollar = Double.parseDouble(dollar);
        Double doubleInr = 70.71 * doubleDollar;
        String toast = "= " + doubleInr.toString() + " Rupees";
        Toast.makeText(this,toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
