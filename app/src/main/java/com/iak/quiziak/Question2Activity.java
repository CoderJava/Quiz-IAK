package com.iak.quiziak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Question2Activity extends AppCompatActivity {

    private TextView textViewNamaPenggunaQuestion2Activity;
    private RadioGroup radioGroupContainerAnswerQuestion2Activity;
    private Button buttonSubmitAnswerQuestion2Activity;

    // variable untuk menyimpan nilai total jawaban benar dan salah
    private int totalJawabanBenar = 0;
    private int totalJawabanSalah = 0;

    // variable untuk mengetahui apakah pengguna sudah memilih jawaban dari keempat radio button yang ada
    private boolean isSelectedOne;

    // variable untuk menyimpan namaPengguna
    private String namaPengguna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        isSelectedOne = false;
        initView();

        // ambil nilai totalJawabanBenar, totalJawabanSalah, dan namaPengguna
        Bundle bundle = getIntent().getExtras();
        totalJawabanBenar = bundle.getInt("totalJawabanBenar", 0);
        totalJawabanSalah = bundle.getInt("totalJawabanSalah", 0);
        namaPengguna = bundle.getString("namaPengguna");

        // set nilai namaPengguna ke TextView nama pengguna
        textViewNamaPenggunaQuestion2Activity.setText(namaPengguna);

        // listener button submit answer
        buttonSubmitAnswerQuestion2Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ketika button ditekan maka, operasi masuk kesini
                switch (radioGroupContainerAnswerQuestion2Activity.getCheckedRadioButtonId()) {
                    case R.id.radio_button_answer_1_activity_question_2:
                        isSelectedOne = true;
                        totalJawabanBenar += 1;
                        break;
                    case R.id.radio_button_answer_2_activity_question_2:
                        isSelectedOne = true;
                        totalJawabanSalah += 1;
                        break;
                    case R.id.radio_button_answer_3_activity_question_2:
                        isSelectedOne = true;
                        totalJawabanSalah += 1;
                        break;
                    case R.id.radio_button_answer_4_activity_question_2:
                        isSelectedOne = true;
                        totalJawabanSalah += 1;
                        break;
                }

                // validasi apakah pengguna sudah memilih dari keempat jawaban yang tersedia
                if (isSelectedOne) {
                    Intent intentQuestion3Activity = new Intent(Question2Activity.this, Question3Activity.class);
                    intentQuestion3Activity.putExtra("namaPengguna", namaPengguna);
                    intentQuestion3Activity.putExtra("totalJawabanBenar", totalJawabanBenar);
                    intentQuestion3Activity.putExtra("totalJawabanSalah", totalJawabanSalah);
                    startActivity(intentQuestion3Activity);
                } else {
                    // pengguna belum memilih jawaban yang tersedia
                    Toast.makeText(Question2Activity.this, "Anda belum memilih jawaban", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    private void initView() {
        textViewNamaPenggunaQuestion2Activity = (TextView) findViewById(R.id.text_view_value_nama_pengguna_activity_question_2);
        radioGroupContainerAnswerQuestion2Activity = (RadioGroup) findViewById(R.id.radio_group_container_answer_activity_question_2);
        buttonSubmitAnswerQuestion2Activity = (Button) findViewById(R.id.button_submit_answer_activity_question_2);
    }
}
