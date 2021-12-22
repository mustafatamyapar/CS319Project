package com.CovidShark.service;
import com.CovidShark.HealthCenterStaff;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;


import java.util.concurrent.ExecutionException;

public class HealthCenterStaffService {
    public static String saveHealthCenterStaffDetails(HealthCenterStaff aHCStaff) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("healthCenterStaff").document(aHCStaff.getIdNumber()).set(aHCStaff);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static HealthCenterStaff getHealthCenterStaffDetails(String idNumber) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("healthCenterStaff").document(idNumber);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        HealthCenterStaff aStudent = null;
        if (document.exists()) {
            // convert document to POJO
            aStudent = document.toObject(HealthCenterStaff.class);
            System.out.println(aStudent);
            return aStudent;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }

    public static String updateHealthCenterStaffDetails(HealthCenterStaff aHCStaff) throws InterruptedException, ExecutionException{

        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("healthCenterStaff").document(aHCStaff.getIdNumber()).set(aHCStaff);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static String deleteHealthCenterStaff(String idNumber) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection("healthCenterStaff").document(idNumber).delete();
        return "Deleted Health Center Staff " + idNumber;
    }
}
