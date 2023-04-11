package com.agrahari.calendarpomodoro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGoCalendar = (Button) findViewById(R.id.btnGoCalendar);
        Button btnGoPomodoro = (Button) findViewById(R.id.btnGoPomodoro);
        Button btnGoTasks = (Button) findViewById(R.id.btnGoTasks);


        btnGoCalendar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent1);
            }
        });
        btnGoPomodoro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(MainActivity.this, Home.class);
                startActivity(intent2);
            }
        });
        btnGoTasks.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent3 = new Intent(MainActivity.this, Tasks.class);
                startActivity(intent3);
            }
        });
    }
}