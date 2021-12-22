package com.CovidShark.service;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;


import com.CovidShark.BaseUser;

import java.util.concurrent.ExecutionException;

public class UserSignupService {


    public static String saveUserDetails(BaseUser baseUser) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("baseUsers").document(baseUser.getName()).set(baseUser);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static BaseUser getUserDetails(String name) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("baseUsers").document(name);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        BaseUser BaseUser = null;
        if (document.exists()) {
            // convert document to POJO
            BaseUser = document.toObject(BaseUser.class);
            System.out.println(BaseUser);
            return BaseUser;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }

    public static String updateUserDetails(BaseUser baseUser) throws InterruptedException, ExecutionException{

        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("baseUsers").document(baseUser.getName()).set(baseUser);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static String deleteUser(String name) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection("baseUsers").document(name).delete();
        return "Deleted User " + name;
    }

}
