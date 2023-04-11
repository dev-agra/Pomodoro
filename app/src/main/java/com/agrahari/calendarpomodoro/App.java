package com.agrahari.calendarpomodoro;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.core.app.NotificationManagerCompat;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }
    private void createNotificationChannel(){
        NotificationChannel channel = new NotificationChannel("channel", "Channel!", NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription("The Channel is Very Important");

        NotificationManager manager=getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);


    }

}
