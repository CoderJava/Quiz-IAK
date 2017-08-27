package com.iak.quiziak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Question3Activity extends AppCompatActivity {

    private TextView textViewNamaPenggunaQuestion3Activity;
    private RadioGroup radioGroupContainerAnswerQuestion3Activity;
    private Button buttonSubmitAnswerQuestion3Activity;

    private int totalJawabanBenar = 0;
    private int totalJawabanSalah = 0;
    private boolean isSelectedOne;
    private String namaPengguna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        isSelectedOne = false;
        initView();

        Bundle bundle = getIntent().getExtras();
        totalJawabanBenar = bundle.getInt("totalJawabanBenar", 0);
        totalJawabanSalah = bundle.getInt("totalJawabanSalah", 0);
        namaPengguna = bundle.getString("namaPengguna");

        buttonSubmitAnswerQuestion3Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (radioGroupContainerAnswerQuestion3Activity.getCheckedRadioButtonId()) {
                    case R.id.radio_button_answer_1_activity_question_3:
                        isSelectedOne = true;
                        totalJawabanSalah += 1;
                        break;
                    case R.id.radio_button_answer_2_activity_question_3:
                        isSelectedOne = true;
                        totalJawabanSalah += 1;
                        break;
                    case R.id.radio_button_answer_3_activity_question_3:
                        isSelectedOne = true;
                        totalJawabanBenar += 1;
                        break;
                    case R.id.radio_button_answer_4_activity_question_3:
                        isSelectedOne = true;
                        totalJawabanSalah += 1;
                        break;
                }

                if (isSelectedOne) {
                    Intent intentFinalScoreActivity = new Intent(Question3Activity.this, FinalScoreActivity.class);
                    intentFinalScoreActivity.putExtra("totalJawabanBenar", totalJawabanBenar);
                    intentFinalScoreActivity.putExtra("totalJawabanSalah", totalJawabanSalah);
                    intentFinalScoreActivity.putExtra("namaPengguna", namaPengguna);
                    startActivity(intentFinalScoreActivity);
                } else {
                    Toast.makeText(Question3Activity.this, "Anda belum memilih jawabannya", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    private void initView() {
        textViewNamaPenggunaQuestion3Activity = (TextView) findViewById(R.id.text_view_value_nama_pengguna_activity_question_3);
        radioGroupContainerAnswerQuestion3Activity = (RadioGroup) findViewById(R.id.radio_group_container_answer_activity_question_3);
        buttonSubmitAnswerQuestion3Activity = (Button) findViewById(R.id.button_submit_answer_activity_question_3);
    }
}
