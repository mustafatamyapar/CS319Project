package com.CovidShark.service;

import com.CovidShark.AdministrativeStaff;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

/**
 * The AdministrativeStaffService class.
 */
public class AdministrativeStaffService {
    public static String saveAdministrativeStaff(AdministrativeStaff staff) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("administrativeStaff").document(staff.getIdNumber()).set(staff);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static AdministrativeStaff getAdministrativeStaff(AdministrativeStaff staff) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("administrativeStaff").document(String.valueOf(staff));
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        AdministrativeStaff admin = null;
        if (document.exists()) {
            // convert document to POJO
            admin = document.toObject(AdministrativeStaff.class);
            System.out.println(admin);
            return admin;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }

    public static String updateAdministrativeStaff(AdministrativeStaff staff) throws InterruptedException, ExecutionException{

        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("administrativeStaff").document(staff.getIdNumber()).set(staff);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static String deleteAdministrativeStaff(AdministrativeStaff staff) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection("administrativeStaff").document(String.valueOf(staff)).delete();
        return "Deleted administrative staff " + staff;
    }

}
