package com.example.handballapp;

import android.content.Context;
import android.os.Vibrator;

public class VibrationsAktuator implements Aktuator {
    private Context context;

    public VibrationsAktuator(Context context) {
        this.context = context;
    }

    @Override
    public void start() {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator != null) {
            vibrator.vibrate(500);
        }
    }
}
