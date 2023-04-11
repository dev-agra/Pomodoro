package com.agrahari.calendarpomodoro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Clock extends AppCompatActivity {


    int seconds = 0;
    int value = 0;
    public static final String number = "Value";
    public static final String myPref = "pref";
    public static final String mintAchive = "mints";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        TextView timer;
        CountDownTimer countDownTimer;
        timer = findViewById(R.id.timer);

        Button start, end, home, again;
        start = findViewById(R.id.start);
        end = findViewById(R.id.End);
        home = findViewById(R.id.home);
        again = findViewById(R.id.agine);
        Intent intent = getIntent();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        value = intent.getIntExtra(number, -1);
        if (value != -1) {
            timer.setText(value + " : 00");
            seconds = value * 60 * 1000;
        }

        countDownTimer = new CountDownTimer(seconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                final String text = "0" + millisUntilFinished / 1000 / 60 + " : 0" + millisUntilFinished / 1000 % 60;
                if (millisUntilFinished / 1000 % 60 <= 9 && millisUntilFinished / 1000 / 60 <= 9) // seconds <10 && mints<10
                    timer.setText(text);

                else if (millisUntilFinished / 1000 / 60 <= 9)// if mints<10
                {
                    if (millisUntilFinished / 1000 % 60 <= 9)
                        timer.setText(text);
                    else
                        timer.setText("0" + millisUntilFinished / 1000 / 60 + " : " + String.valueOf(millisUntilFinished / 1000 % 60));
                } else if (millisUntilFinished / 1000 / 60 >= 10) {
                    if (millisUntilFinished / 1000 % 60 <= 9)
                        timer.setText(millisUntilFinished / 1000 / 60 + " : 0" + String.valueOf(millisUntilFinished / 1000 % 60));
                    else
                        timer.setText(millisUntilFinished / 1000 / 60 + " : " + String.valueOf(millisUntilFinished / 1000 % 60));
                }
            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onFinish() {
                timer.setText("Finished");
                SharedPreferences preferences = getSharedPreferences(myPref, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                int lastValue = preferences.getInt(mintAchive, -1);
                if (lastValue != -1) ;
                {
                    lastValue += value;
                }
                editor.putInt(mintAchive, lastValue);
                editor.commit();
                end.setVisibility(View.GONE);
                home.setVisibility(View.VISIBLE);
                again.setVisibility(View.VISIBLE);
                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Clock.this, Home.class));
                        finish();
                    }
                });
                again.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View v) {
                        timer.setText(value + ": 00");
                        home.setVisibility(View.GONE);
                        again.setVisibility(View.GONE);
                        start.setVisibility(View.VISIBLE);
                    }
                });


                NotificationCompat.Builder builder = new NotificationCompat.Builder(Clock.this, "channel")
                        .setContentTitle("Pomodoro")
                        .setSmallIcon(R.mipmap.screenicon)
                        .setContentText("You Finished Your Task")
                        .setPriority(NotificationManagerCompat.IMPORTANCE_HIGH);

                NotificationManagerCompat manager = NotificationManagerCompat.from(Clock.this);
                manager.notify(1, builder.build());
            }
        };

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
                start.setVisibility(View.GONE);
                end.setVisibility(View.VISIBLE);
            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Clock.this)
                        .setMessage("Exit From Task")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                countDownTimer.cancel();
                                timer.setText(value + " : 00");
                                end.setVisibility(View.GONE);
                                start.setVisibility(View.VISIBLE);
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.create().show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(Clock.this, Home.class));
        finish();
    }
}