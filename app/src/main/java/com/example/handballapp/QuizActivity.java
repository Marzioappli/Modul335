package com.example.handballapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity{
    private TextView questionTextView;
    private Button trueButton, falseButton;
    private String[] questions = {"Die Kadetten Schaffhausen haben 13 Meistertitel in ihrer Geschicht", "Der Rekordspieler von Pfadi Winterthur heisst: Jae-Wong Kang", "Kriens Luzern hat keinen bedeutenden Schweizer Spieler im Kader!"};
    private boolean[] answers = {true, true, false};
    private int currentQuestion = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        questionTextView = findViewById(R.id.questionTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);

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
    }
    private void showQuestion() {
        if (currentQuestion < questions.length){
            questionTextView.setText(questions[currentQuestion]);
        }else {
            showResult();
        }
    }
    private void checkAnswer(boolean userAnswer) {
        if (userAnswer == answers[currentQuestion]) {
            score++;
        }
    }
    private void showResult(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SwissHandball Info Quiz Ergebniss:");
        builder.setMessage("Sie haben" + score + "von" + questions.length + "Fragen richtig beantwortet");
    }
}