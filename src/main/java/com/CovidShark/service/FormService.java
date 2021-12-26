package com.CovidShark.service;

import com.CovidShark.BaseUser;
import com.CovidShark.Form;
import com.CovidShark.Question;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

public class FormService {
    public static String getFormDate(String id) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("forms").document(id);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        Form form1 = new Form();
        form1.addQuestions();
        if (document.exists()) {
            // convert document to POJO
            form1 = document.toObject(Form.class);
            System.out.println(form1);
            return String.valueOf(form1.getFormDate());
        } else {
            System.out.println("No such form!");
            return null;
        }
    }

    //public static void answerQuestion(boolean answer, int questionNo, Question question) throws ExecutionException, InterruptedException {
    //    if (questionNo < )
    //}

}
