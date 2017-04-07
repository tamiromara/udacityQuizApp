package com.example.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String questionOne = "";
    String questionTwo = "";
    String questionThree = "";
    int correctCounter = 0;
    int incorrectCounter = 0;
    int emptyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {

        // Processing Question 1:
        CheckBox q1Answer1 = (CheckBox) findViewById(R.id.question_1_checkbox_1);
        CheckBox q1Answer2 = (CheckBox) findViewById(R.id.question_1_checkbox_2);
        CheckBox q1Answer3 = (CheckBox) findViewById(R.id.question_1_checkbox_3);
        CheckBox q1Answer4 = (CheckBox) findViewById(R.id.question_1_checkbox_4);
        CheckBox q1Answer5 = (CheckBox) findViewById(R.id.question_1_checkbox_5);
        // Determining the correct answer for Question 1:
        if (q1Answer1.isChecked() || q1Answer4.isChecked() || q1Answer5.isChecked() && (q1Answer2.isChecked() || q1Answer3.isChecked())) {
            questionOne = getString(R.string.incorrect_answer);
            incorrectCounter++;
        } else if (q1Answer2.isChecked() && q1Answer3.isChecked()) {
            questionOne = getString(R.string.correct_answer);
            correctCounter++;
        } else if (q1Answer2.isChecked() || q1Answer3.isChecked()) {
            questionOne = getString(R.string.incorrect_answer);
            incorrectCounter++;
        } else {
            questionOne = getString(R.string.empty_answer);
            emptyCounter++;
        }

        // Processing Question 2:
        RadioButton q2Answer1 = (RadioButton) findViewById(R.id.question_2_radio_1);
        RadioButton q2Answer2 = (RadioButton) findViewById(R.id.question_2_radio_2);
        RadioButton q2Answer3 = (RadioButton) findViewById(R.id.question_2_radio_3);
        // Determining the correct answer for Question 2:
        if (q2Answer1.isChecked()) {
            questionTwo = getString(R.string.correct_answer);
            correctCounter++;
        } else if (q2Answer2.isChecked() || q2Answer3.isChecked()) {
            questionTwo = getString(R.string.incorrect_answer);
            incorrectCounter++;
        } else {
            questionTwo = getString(R.string.empty_answer);
            emptyCounter++;
        }

        // Processing Question 3:
        RadioButton q3Answer1 = (RadioButton) findViewById(R.id.question_3_radio_1);
        RadioButton q3Answer2 = (RadioButton) findViewById(R.id.question_3_radio_2);
        RadioButton q3Answer3 = (RadioButton) findViewById(R.id.question_3_radio_3);
        // Determining the correct answer for Question 3:
        if (q3Answer2.isChecked()) {
            questionThree = getString(R.string.correct_answer);
            correctCounter++;
        } else if (q3Answer1.isChecked() || q3Answer3.isChecked()) {
            questionThree = getString(R.string.incorrect_answer);
            incorrectCounter++;
        } else {
            questionThree = getString(R.string.empty_answer);
            emptyCounter++;
        }

        // Processing Question 4:
        EditText studentAnswer = (EditText) findViewById(R.id.question_4_answer);
        String questionFourFilter = studentAnswer.getText().toString().toLowerCase();
        boolean textTest = questionFourFilter.equals("objects");
        Log.i("MainActivity", String.valueOf(textTest));

        if (textTest) {
            correctCounter++;
        } else if (questionFourFilter.isEmpty()) {
            emptyCounter++;
        } else {
            incorrectCounter++;

        }

        // Calling quiz report method:
        quizReportMessage();

        // Resetting the counters back to zero in case the user changes his answers.
        correctCounter = 0;
        incorrectCounter = 0;
        emptyCounter = 0;
    }

    /**
     * Constructs the final report layout.

     */
    private void quizReportMessage() {
        String finalReport = "You got: " + correctCounter + " correct answers out of 4.";
        Context context = getApplicationContext();
        CharSequence toastMessage = finalReport;
        int toastTimer = Toast.LENGTH_SHORT;
        Toast.makeText(context, toastMessage, toastTimer).show();
    }

}
