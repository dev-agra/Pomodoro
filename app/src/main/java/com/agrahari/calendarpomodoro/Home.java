package com.agrahari.calendarpomodoro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    Intent intent;
    public static final String number="Value";
    public static final String LastIndex="Index";
    public static  final String myPref="pref";
    public static final String Day="day";
    public static final String mintAchive="mints";
    SharedPreferences Preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        intent=new Intent(Home.this,Clock.class);
        Preferences=getSharedPreferences(myPref,MODE_PRIVATE);

        TextView Slider=findViewById(R.id.textslide);
        TextView today=findViewById(R.id.today);
        TextView mints=findViewById(R.id.mints);
        today.setText(Utils.getInstance().getData());


        int i=Preferences.getInt(LastIndex,-1);
        if(i==-1)
        {
            // first time when you open app
            SharedPreferences.Editor editor;
            editor = Preferences.edit();
            editor.putInt(LastIndex,0);
            editor.putString(Day,Utils.getInstance().getData());
            editor.putInt(mintAchive,0);
            today.setText(Utils.getInstance().getData());
            editor.apply();
        }
        else{

            if(i== Utils.getQuotes().size())
                i=0;

            Slider.setText(Utils.getQuotes().get(i));
            i++;
            SharedPreferences.Editor editor=Preferences.edit();
            editor.putInt(LastIndex,i);
            editor.apply();
        }

        int achivements=Preferences.getInt(mintAchive,-1);

        if(achivements!=-1)
        {
            if(Preferences.getString(Day,"").equals(Utils.getInstance().getData()))
            {
                // same day
                mints.setText(achivements+" M");
            }
            else {
                // second day
                SharedPreferences.Editor editor;
                editor = Preferences.edit();
                editor.putString(Day,Utils.getInstance().getData());
                editor.putInt(mintAchive,0);
                editor.apply();
            }
        }
    }


    // on click button
    public void TewntyFive(View view)
    {
        intent.putExtra(number,5);
        startActivity(intent);
    }
    public void ThrityFive(View view)
    {
        intent.putExtra(number,15);
        startActivity(intent);

    }
    public void Hour(View view)
    {
        intent.putExtra(number,25);
        startActivity(intent);

    }
}
