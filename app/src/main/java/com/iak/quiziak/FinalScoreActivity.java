package com.iak.quiziak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalScoreActivity extends AppCompatActivity {

    private TextView textViewNamaPenggunaFinalScoreActivity;
    private TextView textViewValueScoreFinalScoreActivity;
    private Button buttonTryAgainFinalScoreActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        textViewNamaPenggunaFinalScoreActivity = (TextView) findViewById(R.id.text_view_value_nama_pengguna_activity_final_score);
        textViewValueScoreFinalScoreActivity = (TextView) findViewById(R.id.text_view_value_score_activity_final_score);
        buttonTryAgainFinalScoreActivity = (Button) findViewById(R.id.button_try_again_activity_final_score);

        Bundle bundle = getIntent().getExtras();
        final String namaPengguna = bundle.getString("namaPengguna");
        int totalJawabanBenar = bundle.getInt("totalJawabanBenar", 0);
        int totalJawabanSalah = bundle.getInt("totalJawabanSalah", 0);

        // rumus: finalScore = ((totalJawabanBenar / (totalSoal)) * 100)
        int totalSoal = totalJawabanBenar + totalJawabanSalah;
        double finalScore = ((double) totalJawabanBenar / totalSoal) * 100;
        int intFinalScore = (int) Math.round(finalScore);

        textViewNamaPenggunaFinalScoreActivity.setText(namaPengguna);
        textViewValueScoreFinalScoreActivity.setText("" + intFinalScore);

        buttonTryAgainFinalScoreActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentQuestion1Activity = new Intent(FinalScoreActivity.this, Question1Activity.class);
                intentQuestion1Activity.putExtra("namaPengguna", namaPengguna);
                intentQuestion1Activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentQuestion1Activity);

                // pop stack FinalScore
                /*finish();*/
            }
        });
    }
}
