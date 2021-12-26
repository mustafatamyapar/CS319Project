package com.CovidShark.service;

import com.CovidShark.BaseUser;
import com.CovidShark.Instructor;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

/**
 * The InstructorService class.
 */
public class InstructorService {

    public static String saveInstructorDetails(Instructor instructor) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("instructors").document(instructor.getIdNumber()).set(instructor);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static Instructor getInstructorDetails(String idNumber) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("instructors").document(idNumber);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        Instructor instructor = null;
        if (document.exists()) {
            // convert document to POJO
            instructor = document.toObject(Instructor.class);
            System.out.println(instructor);
            return instructor;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }

    public static String updateInstructorDetails(Instructor instructor) throws InterruptedException, ExecutionException{

        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("instructors").document(instructor.getIdNumber()).set(instructor);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static String deleteInstructor(String idNumber) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection("instructors").document(idNumber).delete();
        return "Deleted User " + idNumber;
    }

}
