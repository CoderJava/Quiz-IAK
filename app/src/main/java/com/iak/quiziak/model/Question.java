package com.iak.quiziak.model;

/**
 * Created by yudisetiawan on 11/26/17.
 */

public class Question {

    private int number;
    private String title;
    private boolean isEverOpened;
    private boolean isRightAnswer;

    public Question(int number, String title, boolean isEverOpened, boolean isRightAnswer) {
        this.number = number;
        this.title = title;
        this.isEverOpened = isEverOpened;
        this.isRightAnswer = isRightAnswer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isEverOpened() {
        return isEverOpened;
    }

    public void setEverOpened(boolean everOpened) {
        isEverOpened = everOpened;
    }

    public boolean isRightAnswer() {
        return isRightAnswer;
    }

    public void setRightAnswer(boolean rightAnswer) {
        isRightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", isRightAnswer=" + isRightAnswer +
                '}';
    }
}
