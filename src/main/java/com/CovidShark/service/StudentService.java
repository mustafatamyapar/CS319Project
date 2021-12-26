package com.CovidShark.service;
import com.CovidShark.Student;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;


import java.util.concurrent.ExecutionException;

/**
 * The StudentService class.
 */
public class StudentService {

    public static String saveStudentDetails(Student aStudent) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("students").document(aStudent.getIdNumber()).set(aStudent);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static Student getStudentDetails(String idNumber) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("students").document(idNumber);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        Student aStudent = null;
        if (document.exists()) {
            // convert document to POJO
            aStudent = document.toObject(Student.class);
            System.out.println(aStudent);
            return aStudent;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }

    public static String updateStudentDetails(Student aStudent) throws InterruptedException, ExecutionException{

        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("students").document(aStudent.getIdNumber()).set(aStudent);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static String deleteStudent(String idNumber) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection("students").document(idNumber).delete();
        return "Deleted Student " + idNumber;
    }

}
