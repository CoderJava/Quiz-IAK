package com.iak.quiziak.ui.question;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.iak.quiziak.R;

public class Question2Activity extends AppCompatActivity {

    private TextView textViewQuestion2Activity;
    private RadioGroup radioGroupAnswerQuestion2Activity;
    private RadioButton radioButtonAnswerAQuestion2Activity;
    private RadioButton radioButtonAnswerBQuestio2Activity;
    private RadioButton radioButtonAnswerCQuestion2Activity;
    private RadioButton radioButtonAnswerDQuestion2Activity;
    private String username;
    private int totalRightAnswer;
    private int totalWrongAnswer;
    private boolean isSelectedAnswer;
    private boolean isRightAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        // Ambil nilai yang dikirimkan dari halaman atau activity sebelumnya
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString("username");
            totalRightAnswer = bundle.getInt("totalRightAnswer");
            totalWrongAnswer = bundle.getInt("totalWrongAnswer");
        }

        // set nilai text ke view
        initViews();
    }

    private void initViews() {
        textViewQuestion2Activity = (TextView) findViewById(R.id.text_view_question_activity_question2);
        radioGroupAnswerQuestion2Activity = (RadioGroup) findViewById(R.id.radio_group_answer_activity_question2);
        radioButtonAnswerAQuestion2Activity = (RadioButton) findViewById(R.id.radio_button_answer_a_activity_question2);
        radioButtonAnswerBQuestio2Activity = (RadioButton) findViewById(R.id.radio_button_answer_b_activity_question2);
        radioButtonAnswerCQuestion2Activity = (RadioButton) findViewById(R.id.radio_button_answer_c_activity_question2);
        radioButtonAnswerDQuestion2Activity = (RadioButton) findViewById(R.id.radio_button_answer_d_activity_question2);

        textViewQuestion2Activity.setText("Soal\nManakah bahasa pemrograman berikut yang tidak bisa digunakan untuk membuat aplikasi Android?");
        radioButtonAnswerAQuestion2Activity.setText("Java");
        radioButtonAnswerBQuestio2Activity.setText("Kotlin");
        radioButtonAnswerCQuestion2Activity.setText("Flutter");
        radioButtonAnswerDQuestion2Activity.setText("Objective C");

        radioGroupAnswerQuestion2Activity.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.radio_button_answer_a_activity_question2:
                        wrongAnswer();
                        break;
                    case R.id.radio_button_answer_b_activity_question2:
                        wrongAnswer();
                        break;
                    case R.id.radio_button_answer_c_activity_question2:
                        wrongAnswer();
                        break;
                    case R.id.radio_button_answer_d_activity_question2:
                        rightAnswer();
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_question_2_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_next_menu_question_2_activity:
                // Cek apakah si pengguna sudah memilih jawabannya
                if (!isSelectedAnswer) {
                    Toast.makeText(
                            Question2Activity.this,
                            "Pilih jawabannya lah vroh",
                            Toast.LENGTH_LONG
                    ).show();
                    return true;
                }

                if (isRightAnswer) {
                    // Jika jawaban si pengguna benar maka, tambah 1 nilai variable totalRightAnswer
                    totalRightAnswer = totalRightAnswer + 1;
                } else {
                    // Jika jawaban si pengguna salah maka, tambah 1 nilai variable totalWrongAnswer
                    totalWrongAnswer = totalWrongAnswer + 1;
                }
                Intent intentFinalScoreActivity = new Intent(
                        Question2Activity.this,
                        FinalScoreActivity.class
                );

                // Kirimkan nilai username ke activity atau halaman berikutnya
                intentFinalScoreActivity.putExtra("username", username);

                // Kirimkan nilai totalRightAnswer ke activity atau halaman berikutnya
                intentFinalScoreActivity.putExtra("totalRightAnswer", totalRightAnswer);

                // Kirimkan nilai totalWrongAnswer ke activity atau halaman berikutnya
                intentFinalScoreActivity.putExtra("totalWrongAnswer", totalWrongAnswer);

                startActivity(intentFinalScoreActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void rightAnswer() {
        isSelectedAnswer = true;
        isRightAnswer = true;
    }

    private void wrongAnswer() {
        isSelectedAnswer = true;
        isRightAnswer = false;
    }
}
