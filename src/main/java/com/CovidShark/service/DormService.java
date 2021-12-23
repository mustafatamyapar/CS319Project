package com.CovidShark.service;

import com.CovidShark.Dormitory;
import com.CovidShark.Gym;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class DormService {
    public static String saveDormDetails(Dormitory dormitory) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("dorm").document(Integer.toString(dormitory.getDormNumber())).set(dormitory);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static Dormitory getDormDetails(int dormNumber) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("dorm").document(String.valueOf(dormNumber));
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        Dormitory dormitory = null;
        if (document.exists()) {
            // convert document to POJO
            dormitory = document.toObject(Dormitory.class);
            System.out.println(dormitory);
            return dormitory;
        } else {
            System.out.println("No such dorm!");
            return null;
        }
    }

    public static String updateDormDetails(Dormitory dormitory) throws InterruptedException, ExecutionException{

        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("dorm").document(Integer.toString(dormitory.getDormNumber())).set(dormitory);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
