package com.CovidShark.service;

import com.CovidShark.SeatingPlan;
import com.CovidShark.VisitedRoom;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class SeatingPlanService {

    public static String saveSeatPlan(SeatingPlan seat) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("seatingPlan").document(String.valueOf(seat.getId())).set(seat);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static SeatingPlan getSeatDetails(SeatingPlan seat) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("seatingPlan").document(String.valueOf(seat.getId()));

        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        SeatingPlan seat2 = new SeatingPlan();
        if (document.exists()) {
            // convert document to POJO
            seat2 = document.toObject(SeatingPlan.class);
            System.out.println(seat2);
            return seat2;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }

    public static String updateSeatDetails(SeatingPlan seat) throws InterruptedException, ExecutionException{

        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("seatingPlan").document(String.valueOf(seat.getId())).set(seat);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static String deleteSeatPlan(int id) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection("seatingPlan").document(String.valueOf(id)).delete();
        return "Deleted Plan " + id;
    }

}
