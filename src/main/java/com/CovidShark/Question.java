package com.CovidShark;

import java.util.List;

/**
 * The Question class.
 */
public class Question {

    /**
     * The questionNum integer holds a question number.
     */
    private int questionNum;

    /**
     * The question String holds a question.
     */
    private String question;

    /**
     * The point integer holds a point.
     */
    private int point;

    /**
     * The isAnswered boolean holds the value of if a question is answered or not.
     */
    boolean isAnswered;

    public Question(int questionNum, String question) {
        this.questionNum = questionNum;
        this.question = question;
        isAnswered = false;
        point = -1;
    }

    /**
     * The isAnswered() operation checks if a question is answered or not.
     * @return the status of the question: answered or not.
     */
    public boolean isAnswered() {
        return isAnswered;
    }

    /**
     * The getQuestionNum() operation gets the number of a question.
     * @return the number of a question.
     */
    public int getQuestionNum() {
        return questionNum;
    }

    /**
     * The getQuestion() operation gets the question.
     * @return the question.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * The answer(boolean choice) operation gets the answer.
     */
    public void answer(boolean choice) {
        if (choice) {
            point = 1;
        }
        else {
            point = 0;
        }
        isAnswered = true;
    }

    /**
     * The getPoint() operation gets the point.
     * @return the point.
     */
    public int getPoint() {
        return point;
    }

    /**
     * The resetQuestionStatus() operation resets the status of a question to start again.
     */
    public void resetQuestionStatus() {
        point = -1;
        isAnswered = false;
    }
}
