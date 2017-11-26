package com.iak.quiziak.ui.question.dashboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.iak.quiziak.R;

public class DashboardQuestionActivity extends AppCompatActivity {

    private TextView textViewScoreDashboardQuestionActivity;
    private TextView textViewUsernameDashboardQuestionActivity;
    private RecyclerView recyclerViewDataQuestionDashboardQuestionActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_question);

        initToolbar();
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupUserProfile();
        setupAdapterQuestion();
    }

    private void setupAdapterQuestion() {
        recyclerViewDataQuestionDashboardQuestionActivity.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupUserProfile() {
        SharedPreferences sharedPreferencesUserStorage = getSharedPreferences("UserStorage", Context.MODE_PRIVATE);
        String username = sharedPreferencesUserStorage
                .getString("username", "unknown");
        textViewUsernameDashboardQuestionActivity.setText(username);

        int score = sharedPreferencesUserStorage.getInt("score", 0);
        String strScore = "Score: " + score;
        textViewScoreDashboardQuestionActivity.setText(strScore);
    }

    private void initViews() {
        textViewScoreDashboardQuestionActivity = (TextView) findViewById(R.id.text_view_score_activity_dashoard_question);
        textViewUsernameDashboardQuestionActivity = (TextView) findViewById(R.id.text_view_user_name_activity_dashboard_question);
        recyclerViewDataQuestionDashboardQuestionActivity = (RecyclerView) findViewById(R.id.recycler_view_data_question_activity_dashboard_question);
    }

    private void initToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Dashboard Question");
        }
    }
}
