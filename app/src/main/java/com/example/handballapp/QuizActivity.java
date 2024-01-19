package com.example.handballapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


//Allgemeine Übersicht Aktuator Informationsbeschaffung --> https://www.geeksforgeeks.org/how-to-vibrate-a-device-programmatically-in-android/
public class QuizActivity extends AppCompatActivity {
    private TextView questionTextView;
    private Button trueButton, falseButton, cancelButton;
    private String[] questions = {"Die Kadetten Schaffhausen haben 13 Meistertitel in ihrer Geschichte", "Der Rekordspieler von Pfadi Winterthur heißt: Jae-Wong Kang", "Kriens Luzern hat keinen bedeutenden Schweizer Spieler im Kader!", "Die Kadetten haben als Heimtrikot die Farbe Rot!", "Pfadi Winterthur ist für die starke Nachwuchsförderung bekannt!", "Kriens-Luzern spielt in der Saalsporthalle!"};
    private boolean[] answers = {true, true, false, false, true, false};
    private int currentQuestion = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        questionTextView = findViewById(R.id.questionTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        cancelButton = findViewById(R.id.cancelButton);

        showQuestion();

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void showQuestion() {
        if (currentQuestion < questions.length) {
            questionTextView.setText(questions[currentQuestion]);
        } else {
            showResult();
        }
    }

    private void checkAnswer(boolean userAnswer) {
        if (userAnswer == answers[currentQuestion]) {
            score++;
        }
        currentQuestion++;
        showQuestion();
    }

    private void showResult() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SwissHandball Info Quiz Ergebnis:");
        builder.setMessage("Sie haben " + score + " von " + questions.length + " Fragen richtig beantwortet");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

        Aktuator vibratorAktuator = new VibrationsAktuator(this);
        vibratorAktuator.start();
    }
}
