package com.CovidShark;

import java.util.List;

public class Question {

    private String question;
    private List<String> choices;
    private int selectedChoice;
    private int point;

    public Question(String question, List<String> choices) {
        this.question = question;
        this.choices = choices;
    }

    public void answer(boolean choice) {
        if (choice) {
            point = 1;
        }
        else {
            point = 0;
        }
    }

    public int getPoint() {
        return point;
    }
}
