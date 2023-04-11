package com.agrahari.calendarpomodoro;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Tasks extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton b1;
    RadioButton b2;
    RadioButton b3;
    RadioButton b4;
    RadioButton b5;
    RadioButton b6;
    RadioButton b7;
    RadioButton b8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskmain);

        radioGroup = (RadioGroup) findViewById(R.id.radiogrp);
        b1 = (RadioButton) findViewById(R.id.radioButton4);
        b2 = (RadioButton) findViewById(R.id.radioButton5);
        b3 = (RadioButton) findViewById(R.id.radioButton6);
        b4 = (RadioButton) findViewById(R.id.radioButton7);
        b5 = (RadioButton) findViewById(R.id.radioButton8);
        b6 = (RadioButton) findViewById(R.id.radioButton9);
        b7 = (RadioButton) findViewById(R.id.radioButton10);
        b8 = (RadioButton) findViewById(R.id.radioButton11);

    }

}
