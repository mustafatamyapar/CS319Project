package com.CovidShark.service;

import com.CovidShark.Course;
import com.CovidShark.Gym;
import com.CovidShark.HealthCenterStaff;
import com.CovidShark.Salon;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

/**
 * The GymService class.
 */
public class GymService {
    public static String saveSalonDetails(Salon salon) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("gym").document(salon.getSalonType()).set(salon);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static Salon getSalonDetails(String salonType) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("gym").document(salonType);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        Salon gymSalon = null;
        if (document.exists()) {
            // convert document to POJO
            gymSalon = document.toObject(Salon.class);
            System.out.println(gymSalon);
            return gymSalon;
        } else {
            System.out.println("No such salon!");
            return null;
        }
    }

    public static String updateGymSalon(Salon salon) throws InterruptedException, ExecutionException{

        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("gym").document(salon.getSalonType()).set(salon);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
