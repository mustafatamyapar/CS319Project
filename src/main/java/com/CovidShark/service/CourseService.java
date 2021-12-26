package com.CovidShark.service;
import com.CovidShark.Course;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;


import java.util.concurrent.ExecutionException;


/**
 * The CourseService class.
 */
public class CourseService {



    public static String saveCourseDetails(Course aCourse) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Courses").document(aCourse.getCourseCode()).set(aCourse);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static Course getCourseDetails(String courseCode) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("Courses").document(courseCode);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        Course aCourse = null;
        if (document.exists()) {
            // convert document to POJO
            aCourse = document.toObject(Course.class);
            System.out.println(aCourse);
            return aCourse;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }

    public static String updateCourseDetails(Course aCourse) throws InterruptedException, ExecutionException{

        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("Courses").document(aCourse.getCourseCode()).set(aCourse);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static String deleteCourse(String courseCode) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection("Courses").document(courseCode).delete();
        return "Deleted Course " + courseCode;
    }



}
