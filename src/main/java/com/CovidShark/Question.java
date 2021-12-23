package com.CovidShark;

import java.util.List;

public class Question {
    private int questionNum;
    private String question;
    private int point;
    boolean isAnswered;
    //private List<String> choices;
    //private int selectedChoice;


    public Question(int questionNum, String question) {
        this.questionNum = questionNum;
        this.question = question;
        isAnswered = false;
        point = -1;
        //this.choices = choices;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public String getQuestion() {
        return question;
    }

    public void answer(boolean choice) {
        if (choice) {
            point = 1;
        }
        else {
            point = 0;
        }
        isAnswered = true;
    }

    public int getPoint() {
        return point;
    }

    public void resetQuestionStatus() {
        point = -1;
        isAnswered = false;
    }
}
