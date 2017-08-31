package com.iak.quiziak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Question1Activity extends AppCompatActivity {

    private TextView textViewNamaPenggunaQuestion1Activity;
    private RadioGroup radioGroupContainerAnswerQuestion1Activity;
    private RadioButton radioButtonAnswer1Question1Activity;
    private RadioButton radioButtonAnswer2Question1Activity;
    private RadioButton radioButtonAnswer3Question1Activity;
    private RadioButton radioButtonAnswer4Question1Activity;
    private Button buttonSubmitAnswerQuestion1Activity;

    // variable untuk menyimpan nilai jawaban yang benar atau salah
    private int totalJawabanBenar = 0;
    private int totalJawabanSalah = 0;

    // variable untuk mengetahui apakah pengguna sudah memilih jawaban atau belum
    private boolean isSelectedOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        initView();
        isSelectedOne = false;

        // ambil nilai dari intent sebelumnya
        Bundle bundle = getIntent().getExtras();
        final String namaPengguna = bundle.getString("namaPengguna", "");

        // set text nama pengguna ke TextView
        textViewNamaPenggunaQuestion1Activity.setText(namaPengguna);

        // listener untuk button submit jawaban
        buttonSubmitAnswerQuestion1Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ambil RadioButton yang terpilih
                switch (radioGroupContainerAnswerQuestion1Activity.getCheckedRadioButtonId()) {
                    case R.id.radio_button_answer_1_activity_question_1:
                        // radio button answer 1 status checked
                        totalJawabanSalah += 1;
                        isSelectedOne = true;
                        break;
                    case R.id.radio_button_answer_2_activity_question_1:
                        // radio button answer 2 status checked
                        // jawaban benar
                        totalJawabanBenar += 1;
                        isSelectedOne = true;
                        break;
                    case R.id.radio_button_answer_3_activity_question_1:
                        // radio button answer 3 status checked
                        totalJawabanSalah += 1;
                        isSelectedOne = true;
                        break;
                    case R.id.radio_button_answer_4_activity_question_1:
                        // radio button answer 4 status checked
                        totalJawabanSalah += 1;
                        isSelectedOne = true;
                        break;
                }

                // ketika button ditekan maka, operasi masuk ke sini
                if (isSelectedOne) {
                    // pengguna sudah memilih jawaban dari ke empat radio button yang ada
                    // dan kirimkan data namaPengguna, totalJawabanBenar, dan totalJawabanSalah
                    // agar bisa dihitung final score nya berapa
                    Intent intentQuestion2Activity = new Intent(Question1Activity.this, Question2Activity.class);
                    intentQuestion2Activity.putExtra("namaPengguna", namaPengguna);
                    intentQuestion2Activity.putExtra("totalJawabanBenar", totalJawabanBenar);
                    intentQuestion2Activity.putExtra("totalJawabanSalah", totalJawabanSalah);
                    startActivity(intentQuestion2Activity);
                } else {
                    // pengguna belum memilih jawaban dari ke empat radio button yang ada
                    Toast.makeText(Question1Activity.this, "Anda belum memilih jawabannya", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // contoh prosedur method
    private void initView() {
        textViewNamaPenggunaQuestion1Activity = (TextView) findViewById(R.id.text_view_value_nama_pengguna_activity_question_1);
        radioGroupContainerAnswerQuestion1Activity = (RadioGroup) findViewById(R.id.radio_group_container_answer_activity_question_1);
        radioButtonAnswer1Question1Activity = (RadioButton) findViewById(R.id.radio_button_answer_1_activity_question_1);
        radioButtonAnswer2Question1Activity = (RadioButton) findViewById(R.id.radio_button_answer_2_activity_question_1);
        radioButtonAnswer3Question1Activity = (RadioButton) findViewById(R.id.radio_button_answer_3_activity_question_1);
        radioButtonAnswer4Question1Activity = (RadioButton) findViewById(R.id.radio_button_answer_4_activity_question_1);
        buttonSubmitAnswerQuestion1Activity = (Button) findViewById(R.id.button_submit_answer_activity_question_1);
    }

    // contoh fungsi method
    private int jumlah(int nilaiA, int nilaiB) {
        return nilaiA + nilaiB;
    }
}
