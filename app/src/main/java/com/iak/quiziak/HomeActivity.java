package com.iak.quiziak;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private EditText editTextNamaPenggunaHomeActivity;
    private Button buttonSubmitNamaPenggunaHomeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editTextNamaPenggunaHomeActivity = (EditText) findViewById(R.id.edit_text_nama_pengguna_activity_home);
        buttonSubmitNamaPenggunaHomeActivity = (Button) findViewById(R.id.button_submit_nama_pengguna_activity_home);
        buttonSubmitNamaPenggunaHomeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ketika button ditekan maka, operasi masuk ke sini
                String namaPengguna = editTextNamaPenggunaHomeActivity.getText().toString();
                if (namaPengguna.isEmpty()) {
                    // nama pengguna belum di isi
                    Toast.makeText(HomeActivity.this, "Isi nama lah coy", Toast.LENGTH_LONG)
                            .show();
                } else {
                    // nama pengguna sudah di isi
                    Intent intentQuestion1Activity = new Intent(HomeActivity.this, Question1Activity.class);
                    intentQuestion1Activity.putExtra("namaPengguna", namaPengguna);
                    startActivity(intentQuestion1Activity);

                    /*Bundle bundle = new Bundle();
                    bundle.putString("namaPengguna", namaPengguna);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        // os android jelly bean keatas
                        startActivity(intentQuestion1Activity, bundle);
                    } else {
                        // os android jelly bean kebawah
                        startActivity(intentQuestion1Activity);
                    }*/
                }
            }
        });
    }
}
