package com.example.handballapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


//Allgemeine Information für Notifications: https://developer.android.com/develop/ui/views/notifications
public class ReminderBroadcast extends BroadcastReceiver {
    private static final String REMINDERID = "QUIZ_REMINDER";
    @Override
    public void onReceive(Context context, Intent intent) {
    createNotificationChannel(context);

    Intent notificationIntent = new Intent(context, MainActivity.class);
    PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

    Notification notification = new Notification.Builder(context, REMINDERID)
            .setContentTitle("Quiz Erinnerung")
            .setContentText("Zeit das Quiz zu spielen!")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentIntent(contentIntent)
            .build();
    }
}