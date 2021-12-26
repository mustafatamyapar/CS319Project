package com.CovidShark;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Form class.
 */
public class Form {

    /**
     * The questions list holds question objects.
     */
    private List<Question> questions;

    /**
     * The symptomNumber integer holds the symptom numbers.
     */
    private int symptomNumber;
    /**
     * The formDate is a LocalDate which is built-in date of Java.
     */
    private String formDate;
    private String id;
    private static int formCode = 0;

    public Form(String formDate) {
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

        LocalDate lD = LocalDate.now() ;
        this.formDate = lD.toString();

        System.out.println(lD);
        System.out.println(formDate);

        symptomNumber = 0;

        id = String.valueOf(formCode++);


    }

    public Form(){

    }

    public void addQuestions(){
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

        LocalDate lD = LocalDate.now() ;
        this.formDate = lD.toString();

        System.out.println(lD);
        System.out.println(formDate);

        id = String.valueOf(formCode++);


    }

    public String getId() {
        return id;
    }


    /**
     * The getFormDate() operation gets the date of a form.
     * @return the date of a form.
     */
    public LocalDate getFormDate() {

        return LocalDate.now();
       //return LocalDate.parse(formDate);
    }

    /**
     * The setFormDate(LocalDate formDate) operation sets the date of a form.
     */
    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    /**
     * The answerQuestion(boolean answer, int questionNum) operation answers a question.
     */
    public void answerQuestion(boolean answer, int questionNum){
        if ( questionNum < questions.size()){
            questions.get(questionNum-1).answer(answer);
        }
    }

    /**
     * The getSymptomNumber() operation gets a symptom number.
     * @return the symptom number if all the questions of a form are answered, -1 otherwise.
     */
    public int getSymptomNumber() {
        if (answeredAll()){
            for (int i = 0; i < questions.size(); i++){
                symptomNumber = symptomNumber + questions.get(i).getPoint();
            }
            return symptomNumber;
        }
        return -1;
    }

    /**
     * The answeredAll() operation checks if all the questions of a form are answered.
     * @return true if all the questions of a form are answered, false otherwise.
     */
    public boolean answeredAll(){
        for (int i = 0; i < questions.size(); i++){
            if (questions.get(i).isAnswered())
                return false;
        }
            return true;
    }

    /**
     * The resetForm() operation resets the form daily because it will be filled every day.
     */
    // to daily reset the form
    public void resetForm(){
        for (int i = 0; i < questions.size(); i++)
            questions.get(i).resetQuestionStatus();
    }
}
