package com.iak.quiziak.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iak.quiziak.R;
import com.iak.quiziak.ui.question.DashboardQuestionActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNamaPenggunaHomeActivity;
    private Button buttonSubmitNamaPenggunaHomeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editTextNamaPenggunaHomeActivity = (EditText) findViewById(R.id.edit_text_nama_pengguna_activity_home);
        buttonSubmitNamaPenggunaHomeActivity = (Button) findViewById(R.id.button_submit_nama_pengguna_activity_home);
        buttonSubmitNamaPenggunaHomeActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_submit_nama_pengguna_activity_home:
                // ketika button ditekan maka, operasi masuk ke sini
                String namaPengguna = editTextNamaPenggunaHomeActivity.getText().toString().trim();
                if (namaPengguna.isEmpty() || TextUtils.isEmpty(namaPengguna)) {
                    // nama pengguna belum di isi
                    Toast.makeText(HomeActivity.this, "Isi nama lah coy", Toast.LENGTH_LONG)
                            .show();
                } else {
                    // nama pengguna sudah di isi
                    SharedPreferences sharedPreferencesUserStorage = getSharedPreferences("UserStorage", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editorUserStorage = sharedPreferencesUserStorage.edit();
                    editorUserStorage.putString("username", namaPengguna);
                    editorUserStorage.apply();
                    Intent intentDashboardQuestionActivity = new Intent(
                            HomeActivity.this,
                            DashboardQuestionActivity.class
                    );
                    startActivity(intentDashboardQuestionActivity);
                }
                break;
            default:
                /** nothing to do in here */
        }
    }
}
