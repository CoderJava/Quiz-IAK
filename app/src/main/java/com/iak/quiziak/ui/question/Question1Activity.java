package com.iak.quiziak.ui.question;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.iak.quiziak.R;

public class Question1Activity extends AppCompatActivity {

    private RadioGroup radioGroupAnswerQuestion1Activity;
    private String username;
    private int totalRightAnswer;
    private int totalWrongAnswer;
    private boolean isSelectedAnswer;
    private boolean isRightAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        // Ambil nilai username yang dilemparkan dari HomeActivity bertipe String
        username = getIntent().getExtras().getString("username");

        // Inisialisasi nilai awal variable totalRightAnswer dan totalWrongAnswer
        totalRightAnswer = 0;
        totalWrongAnswer = 0;
        isSelectedAnswer = false;
        radioGroupAnswerQuestion1Activity = (RadioGroup) findViewById(R.id.radio_group_answer_activity_question1);
        radioGroupAnswerQuestion1Activity.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.radio_button_answer_a_activity_question1:
                        rightAnswer();
                        break;
                    case R.id.radio_button_answer_b_activity_question1:
                        wrongAnswer();
                        break;
                    case R.id.radio_button_answer_c_activity_question1:
                        wrongAnswer();
                        break;
                    case R.id.radio_button_answer_d_activity_question1:
                        wrongAnswer();
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_question_1_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_next_menu_question_1_activity:
                // Cek apakah si pengguna sudah memilih jawabannya
                if (!isSelectedAnswer) {
                    Toast.makeText(
                            Question1Activity.this,
                            "Pilih jawabannya dong",
                            Toast.LENGTH_LONG
                    ).show();
                    return true;
                }

                if (isRightAnswer) {
                    // Jika jawaban si pengguna benar maka, tambah 1 nilai ke variable
                    // totalRightAnswer
                    totalRightAnswer = totalRightAnswer + 1;
                } else {
                    // Jika jawaban si pengguna salah maa, tambah 1 nilai ke variable
                    // totalWrongAnswer
                    totalWrongAnswer = totalWrongAnswer + 1;
                }

                Intent intentQuestion2Activity = new Intent(
                        Question1Activity.this,
                        Question2Activity.class
                );

                // Kirim nilai variable username ke Question2Activity
                intentQuestion2Activity.putExtra("username", username);

                // Kirim nilai variable totalRightAnswer dan totalWrongAnswer
                // ke Question2Activity
                intentQuestion2Activity.putExtra("totalRightAnswer", totalRightAnswer);
                intentQuestion2Activity.putExtra("totalWrongAnswer", totalWrongAnswer);
                startActivity(intentQuestion2Activity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        // Si pengguna tidak bisa tekan tombol kembali atau kembali ke activity atau halaman sebelumnya
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
