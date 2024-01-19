package com.example.handballapp;

import android.content.Context;
import android.os.Vibrator;

public class VibrationsAktuator implements Aktuator {
    private Context context;

    public VibrationsAktuator(Context context) {
        this.context = context;
    }
// Hilfe für Zeit der Vibration --> https://stackoverflow.com/questions/13950338/how-to-make-an-android-device-vibrate-with-different-frequency
    @Override
    public void start() {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator != null) {
            vibrator.vibrate(500);
        }
    }
}
