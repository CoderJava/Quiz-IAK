package com.iak.quiziak.ui.question;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.iak.quiziak.R;

import java.util.ArrayList;

public class FinalScoreActivity extends AppCompatActivity {

    private TextView textViewScoreFinalScoreActivity;
    private TextView textViewUsernameFinalScoreActivity;
    private ImageView imageViewResultAnswer1FinalScoreActivity;
    private ImageView imageViewResultAnswer2FinalScoreActivity;

    private String username;
    private int totalRightAnswer;
    private int totalWrongAnswer;
    private ArrayList<Integer> listAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        // Ambil nilai username dari activity atau halaman sebelumnya
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString("username");
            totalRightAnswer = bundle.getInt("totalRightAnswer");
            totalWrongAnswer = bundle.getInt("totalWrongAnswer");
            listAnswer = bundle.getIntegerArrayList("listAnswer");
        }

        initViews();
    }

    private void initViews() {
        textViewScoreFinalScoreActivity = (TextView) findViewById(R.id.text_view_score_activity_final_score);
        textViewUsernameFinalScoreActivity = (TextView) findViewById(R.id.text_view_user_name_activity_final_score);
        imageViewResultAnswer1FinalScoreActivity = (ImageView) findViewById(R.id.image_view_result_answer_1_activity_final_score);
        imageViewResultAnswer2FinalScoreActivity = (ImageView) findViewById(R.id.image_view_result_answer_2_activity_final_score);

        int totalQuestion = totalRightAnswer + totalWrongAnswer;
        double finalScoreTemp = ((double) totalRightAnswer / totalQuestion) * 100;
        int finalScore = (int) Math.round(finalScoreTemp);
        String strFinalScore = "Score: " + finalScore;
        textViewScoreFinalScoreActivity.setText(strFinalScore);
        textViewUsernameFinalScoreActivity.setText(username);

        for (int a = 0; a < listAnswer.size(); a++) {
            int answerType = listAnswer.get(a);
            if (a == 0) {
                if (answerType == 0) {
                    // Untuk jawaban nomor 1 jika jawabannya salah
                    imageViewResultAnswer1FinalScoreActivity.setImageResource(
                            R.drawable.ic_add_red_24dp
                    );
                    imageViewResultAnswer1FinalScoreActivity.setRotation(45);
                } else {
                    // Untuk jawaban nomor 1 jika jawabannya benar
                    imageViewResultAnswer1FinalScoreActivity.setImageResource(
                            R.drawable.ic_check_green_24dp
                    );
                }
            } else if (a == 1) {
                if (answerType == 0) {
                    // Untuk jawaban nomor 2 jika jawabannya salah
                    imageViewResultAnswer2FinalScoreActivity.setImageResource(
                            R.drawable.ic_add_red_24dp
                    );
                    imageViewResultAnswer2FinalScoreActivity.setRotation(45);
                } else {
                    // Untuk jawaban nomor 2 jika jawabannya benar
                    imageViewResultAnswer2FinalScoreActivity.setImageResource(
                            R.drawable.ic_check_green_24dp
                    );
                }
            }
        }
    }
}
