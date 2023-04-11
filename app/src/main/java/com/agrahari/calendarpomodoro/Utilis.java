package com.agrahari.calendarpomodoro;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

class Utils {

    private  static  Utils instance;
    private  static final ArrayList<String> quotes=new ArrayList<>();

    private Utils() {
        quotes.add("The secret to getting ahead is getting started");
        quotes.add("The beginning is always now");
        quotes.add("Nothing is impossible, the word itself says “I’m possible”");
        quotes.add("None of us is as smart as all of us");
        quotes.add("Be yourself  everyone else is already taken");
        quotes.add("We accept the love we think we deserve");
        quotes.add("All Great Achievements Require Time");
    }

    public static Utils getInstance() {
        if(instance==null)
            instance=new Utils();

        return instance;
    }

    public String getData()
    {
        Calendar calendar=Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy");
        return simpleDateFormat.format(calendar.getTime());
    }

    public static ArrayList<String> getQuotes() {
        return quotes;
    }


}

