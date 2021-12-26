package com.CovidShark.service;

import com.CovidShark.BaseUser;
import com.CovidShark.VisitedRoom;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class RoomHistoryService {
    public static String saveRoomDetails(VisitedRoom room) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("roomHistory").document(room.getRoomName()).set(room);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static VisitedRoom getRoomDetails(VisitedRoom room) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("roomHistory").document(room.getRoomName());

        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        VisitedRoom vis = new VisitedRoom();
        if (document.exists()) {
            // convert document to POJO
            vis = document.toObject(VisitedRoom.class);
            System.out.println(vis);
            return vis;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }

    public static String updateRoomDetails(VisitedRoom room) throws InterruptedException, ExecutionException{

        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("roomHistory").document(room.getRoomName()).set(room);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static String deleteRoom(String roomName) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection("roomHistory").document(roomName).delete();
        return "Deleted User " + roomName;
    }
}
