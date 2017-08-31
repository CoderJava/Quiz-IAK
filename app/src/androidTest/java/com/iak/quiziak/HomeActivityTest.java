package com.iak.quiziak;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by root on 31/08/17.
 */

@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {

    /**
     * Setup rule
     */
    @Rule
    public ActivityTestRule<HomeActivity> activityTestRule = new ActivityTestRule<HomeActivity>(
            HomeActivity.class
    );

    /**
     *
     * Input name success
     */
    @Test
    public void inputNameSuccessTest() throws InterruptedException {
        onView(withId(R.id.edit_text_nama_pengguna_activity_home))
                .perform(typeText("kolonel"))
                .perform(ViewActions.closeSoftKeyboard());
        Thread.sleep(1000 * 3);
        onView(withId(R.id.button_submit_nama_pengguna_activity_home))
                .perform(click());
        Thread.sleep(1000 * 3);
    }

    /**
     *
     * Show toast message validation input name
     */
    @Test
    public void validationInputNameTest() throws InterruptedException {
        onView(withId(R.id.button_submit_nama_pengguna_activity_home))
                .perform(click());
        Thread.sleep(1000 * 5);
    }

    /**
     *
     * Input name and answer question with final score 100
     */
    @Test
    public void inputNameAndQuestionWithRightAllAnswerTest() throws InterruptedException {
        // input nama
        onView(withId(R.id.edit_text_nama_pengguna_activity_home))
                .perform(typeText("kolonel"))
                .perform(ViewActions.closeSoftKeyboard());
        Thread.sleep(1000 * 3);

        // klik button submit nama
        onView(withId(R.id.button_submit_nama_pengguna_activity_home))
                .perform(click());
        Thread.sleep(1000 * 3);

        // pilih jawabannya question 1
        onView(withId(R.id.radio_button_answer_2_activity_question_1))
                .perform(click());
        Thread.sleep(1000 * 3);

        // klik button submit answer 1
        onView(withId(R.id.button_submit_answer_activity_question_1))
                .perform(click());
        Thread.sleep(1000 * 3);

        // pilih jawabannya question 2
        onView(withId(R.id.radio_button_answer_1_activity_question_2))
                .perform(click());
        Thread.sleep(1000 * 3);

        // klik button submit answer 2
        onView(withId(R.id.button_submit_answer_activity_question_2))
                .perform(click());
        Thread.sleep(1000 * 3);

        // pilih jawabannya question 3
        onView(withId(R.id.radio_button_answer_3_activity_question_3))
                .perform(click());
        Thread.sleep(1000 * 3);

        // klik button submit answer 3
        onView(withId(R.id.button_submit_answer_activity_question_3))
                .perform(click());
        Thread.sleep(1000 * 3);
    }

    /**
     *
     * Input name and question with wrong all answer
     */
    @Test
    public void inputNameAndQuestionWithWrongAllAnswerTest() throws InterruptedException {
        // Input name
        onView(withId(R.id.edit_text_nama_pengguna_activity_home))
                .perform(typeText("kolonel"))
                .perform(ViewActions.closeSoftKeyboard());
        Thread.sleep(1000 * 3);

        // Klik button submit nama pengguna
        onView(withId(R.id.button_submit_nama_pengguna_activity_home))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Pilih jawaban question 1
        onView(withId(R.id.radio_button_answer_4_activity_question_1))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Klik button submit answer question 1
        onView(withId(R.id.button_submit_answer_activity_question_1))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Pilih jawaban question 2
        onView(withId(R.id.radio_button_answer_4_activity_question_2))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Klik button submit answer question 2
        onView(withId(R.id.button_submit_answer_activity_question_2))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Pilih jawaban question 3
        onView(withId(R.id.radio_button_answer_1_activity_question_3))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Klik button submit answer question 3
        onView(withId(R.id.button_submit_answer_activity_question_3))
                .perform(click());
        Thread.sleep(1000 * 3);
    }

    /**
     *
     * Input name and question with feature try again
     */
    @Test
    public void inputNameAndQuestionWithTryAgain() throws InterruptedException {
        // Input nama pengguna
        onView(withId(R.id.edit_text_nama_pengguna_activity_home))
                .perform(typeText("kolonel"))
                .perform(ViewActions.closeSoftKeyboard());
        Thread.sleep(1000 * 3);

        // Klik button submit nama pengguna
        onView(withId(R.id.button_submit_nama_pengguna_activity_home))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Pilih jawaban question 1
        onView(withId(R.id.radio_button_answer_1_activity_question_1))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Klik button submit answer question 1
        onView(withId(R.id.button_submit_answer_activity_question_1))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Pilih jawaban question 2
        onView(withId(R.id.radio_button_answer_1_activity_question_2))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Klik button submit answer question 2
        onView(withId(R.id.button_submit_answer_activity_question_2))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Pilih jawaban question 3
        onView(withId(R.id.radio_button_answer_2_activity_question_3))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Klik jawaban submit answer question 3
        onView(withId(R.id.button_submit_answer_activity_question_3))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Klik button try again
        onView(withId(R.id.button_try_again_activity_final_score))
                .perform(click());
        Thread.sleep(1000 * 3);
    }

    /**
     *
     * Input name and answer with feature on back press when final score
     */
    @Test
    public void inputNameAndQuestionWithFeatureOnBackPressWhenFinalScore() throws InterruptedException {
        // input nama pengguna
        onView(withId(R.id.edit_text_nama_pengguna_activity_home))
                .perform(typeText("kolonel"))
                .perform(ViewActions.closeSoftKeyboard());
        Thread.sleep(1000 * 3);

        // klik button submit nama pengguna
        onView(withId(R.id.button_submit_nama_pengguna_activity_home))
                .perform(click());
        Thread.sleep(1000 * 3);

        // pilih jawaban question 1
        onView(withId(R.id.radio_button_answer_2_activity_question_1))
                .perform(click());
        Thread.sleep(1000 * 3);

        // klik button jawaban 1
        onView(withId(R.id.button_submit_answer_activity_question_1))
                .perform(click());
        Thread.sleep(1000 * 3);

        // pilih jawaban question 2
        onView(withId(R.id.radio_button_answer_3_activity_question_2))
                .perform(click());
        Thread.sleep(1000 * 3);

        // klik button jawaban 2
        onView(withId(R.id.button_submit_answer_activity_question_2))
                .perform(click());
        Thread.sleep(1000 * 3);

        // pilih jawaban question 3
        onView(withId(R.id.radio_button_answer_3_activity_question_3))
                .perform(click());
        Thread.sleep(1000 * 3);

        // klik button jawaban 3
        onView(withId(R.id.button_submit_answer_activity_question_3))
                .perform(click());
        Thread.sleep(1000 * 3);

        // klik button try again
        onView(withId(R.id.button_try_again_activity_final_score))
                .perform(click());
        Thread.sleep(1000 * 3);

        // klik button back
        onView(isRoot())
                .perform(pressBack());
        Thread.sleep(1000 * 3);
    }

    /**
     *
     * Input answer without choose answer
     */
    @Test
    public void validatonInputAnswerWithoutChooseAnswer() throws InterruptedException {
        // input nama pengguna
        onView(withId(R.id.edit_text_nama_pengguna_activity_home))
                .perform(typeText("kolonel"))
                .perform(ViewActions.closeSoftKeyboard());
        Thread.sleep(1000 * 3);

        // klik button submit nama pengguna
        onView(withId(R.id.button_submit_nama_pengguna_activity_home))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Klik button answer 1
        onView(withId(R.id.button_submit_answer_activity_question_1))
                .perform(click());
        Thread.sleep(1000 * 3);

        // Klik button answer 1
        onView(withId(R.id.button_submit_answer_activity_question_1))
                .perform(click());
        Thread.sleep(1000 * 3);
    }

}