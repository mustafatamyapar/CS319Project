package com.CovidShark;

import java.util.Date;
import java.util.List;

public class Form {

    private List<Question> questions;
    private int symptomNumber;
    private Date date;

    public Form(List<Question> questions, int symptomNumber, Date date) {
        this.questions = questions;
        this.symptomNumber = symptomNumber;
        this.date = date;
    }

    public int getSymptomNumber() {
        return symptomNumber;
    }
}
