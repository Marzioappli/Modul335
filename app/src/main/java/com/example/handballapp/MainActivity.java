package com.example.handballapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
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
        setQuizReminder();
    }

    private void setQuizReminder() {
        Intent alarmintent = new Intent(this, ReminderBroadcast.class);
        int intentFlags = PendingIntent.FLAG_IMMUTABLE;
        PendingIntent alarmpendingIntent = PendingIntent.getBroadcast(this,0, alarmintent, intentFlags);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long interval = 1000 * 60 * 2;
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, alarmpendingIntent);
    }
}


