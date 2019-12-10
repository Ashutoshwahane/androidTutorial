package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPlus, buttonMinus,
           buttonMulti, buttonDivide, buttonAns, buttonClr;
    EditText textView;
    float text1;
    Boolean plus=false, minus=false, multi=false, div=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonPlus = findViewById(R.id.btnPlus);
        buttonMinus = findViewById(R.id.btnMinus);
        buttonMulti = findViewById(R.id.btnMulti);
        buttonDivide = findViewById(R.id.btnDivide);
        buttonClr = findViewById(R.id.btnClr);
        buttonAns = findViewById(R.id.btnAns);
        textView = findViewById(R.id.tv);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMulti.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonAns.setOnClickListener(this);
        buttonClr.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Log.d("TAG","Clicked in btn"+v);
        switch (v.getId()){
            case R.id.btn0 : textView.setText("0");break;
            case R.id.btn1 : textView.setText("1");break;
            case R.id.btn2 : textView.setText("2");break;
            case R.id.btn3 : textView.setText("3");break;
            case R.id.btn4 : textView.setText("4");break;
            case R.id.btn5 : textView.setText("5");break;
            case R.id.btn6 : textView.setText("6");break;
            case R.id.btn7 : textView.setText("7");break;
            case R.id.btn8 : textView.setText("8");break;
            case R.id.btn9 : textView.setText("9");break;
            case R.id.btnPlus : {
                if (textView == null){
                    plus=false;
                    textView.setText("");break;
                }
                else{
                    text1 =Float.parseFloat(textView.getText().toString());
                    textView.setText("");
                    plus=true;break;
                }
            }
            case R.id.btnMinus : {
                if (textView == null){
                    minus=false;
                    textView.setText("");break;
                }
                else{
                    text1 =Float.parseFloat(textView.getText().toString());
                    textView.setText("");
                    minus=true;break;
                }
            }
            case R.id.btnMulti : {
                if (textView == null){
                    multi=false;
                    textView.setText("");break;
                }
                else{
                    text1 =Float.parseFloat(textView.getText().toString());
                    textView.setText("");
                    multi=true;break;
                }
            }
            case R.id.btnDivide : {
                if (textView == null){
                    div=false;
                    textView.setText("");break;
                }
                else{
                    text1 =Float.parseFloat(textView.getText().toString());
                    textView.setText("");
                    div=true;break;
                }
            }
            case R.id.btnAns : {

                if(plus){
                    textView.setText(String.valueOf(text1 + Float.parseFloat(textView.getText().toString())));
                }else if(minus){
                    textView.setText(String.valueOf(text1 - Float.parseFloat(textView.getText().toString())));
                }else if(multi){
                    textView.setText(String.valueOf(text1 * Float.parseFloat(textView.getText().toString())));
                }else if(div){
                    textView.setText(String.valueOf(text1 / Float.parseFloat(textView.getText().toString())));
                }
                break;

            }
            default : {
                textView.setText("");
                text1 = 0;
                break;
            }

        }
    }
}
