package com.example.handballapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "handballAppChannel";
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button kadettenbutton = findViewById(R.id.kadettenbutton);
        kadettenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KadettenActivity.class);
                startActivity(intent);
            }
        });

        Button pfadiButton = findViewById(R.id.pfadiwinterthur);
        pfadiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PfadiActivity.class);
                startActivity(intent);
            }
        });

        Button kriensButton = findViewById(R.id.kriensluzern);
        kriensButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KriensActivity.class);
                startActivity(intent);
            }
        });

        Button quizbutton = findViewById(R.id.quizbutton);
        quizbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
        //Mithilfe von Vorlage (offengestellt in Moodle) Notification gelöst.
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "SwisssHandball Info Kanal";
            String description = "SwisssHandball Info Notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }
        sendNotification();
    }

    private void sendNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.btn_star_big_on)
                .setContentTitle("Quiz Reminder")
                .setContentText("Spielen Sie nun das Quiz!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificationManager.notify(0, builder.build());
    }
}
