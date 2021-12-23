package com.CovidShark;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Form {

    private List<Question> questions;
    private int symptomNumber;

    public Form() {
        // questions will be hard-coded!!!
        this.questions = new ArrayList<Question>();
        questions.add( new Question(1, "Fever"));
        questions.add( new Question(2, "Cough"));
        questions.add( new Question(3, "Difficulty In Breathing"));
        questions.add( new Question(4, "Throat Ache"));
        questions.add( new Question(5, "Headache"));
        questions.add( new Question(6, "Muscle Pain"));
        questions.add( new Question(7, "Chest/Back Pain"));
        questions.add( new Question(8, "Loss of Taste/Smell"));
        questions.add( new Question(9, "Diarrhea"));
        questions.add( new Question(10, "Has anyone been diagnosed with Covid in your home?"));
        questions.add( new Question(11, "Has anyone been diagnosed with Covid in your neighbour?"));

        symptomNumber = 0;
    }

    public void answerQuestion(boolean answer, int questionNum){
        if ( questionNum < questions.size()){
            questions.get(questionNum-1).answer(answer);
        }
    }

    public int getSymptomNumber() {
        if (answeredAll()){
            for (int i = 0; i < questions.size(); i++){
                symptomNumber = symptomNumber + questions.get(i).getPoint();
            }
            return symptomNumber;
        }
        return -1;
    }

    public boolean answeredAll(){
        for (int i = 0; i < questions.size(); i++){
            if (questions.get(i).isAnswered())
                return false;
        }
            return true;
    }

    // to daily reset the form
    public void resetForm(){
        for (int i = 0; i < questions.size(); i++)
            questions.get(i).resetQuestionStatus();
    }
}
