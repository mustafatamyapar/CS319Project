package com.CovidShark;

import org.apache.logging.log4j.message.ReusableMessage;

import java.util.List;

public class SwapRequest extends Notification {

    private String seat;
    private Student seatOwner;
    private Student requester;
    private RequestState requestState;
    private Course course;
    private Section section;

    enum RequestState {
        PENDING,
        ACCEPTED,
        REJECTED,
        CANCELLED
    }

    public SwapRequest(String seat, Student seatOwner, Student requester, Section section) {
        super(requester.getName() + "wants to have a swap for seat" + seat, "Swap Request", requester.getName());
        this.seat = seat;
        this.seatOwner = seatOwner;
        this.requester = requester;
        this.requestState = RequestState.PENDING;
        this.section = section;
    }

    public String getSeat() {
        return seat;
    }

    public Student getRequester() {return requester;}
    public Student getSeatOwner() {
        return seatOwner;
    }

    public Section getSection() {return section;}
    public RequestState getRequestState() {
        return requestState;
    }

    public void markAsDone() {
        requestState = RequestState.ACCEPTED;
    }
    public void markAsCancelled() {
        requestState = RequestState.CANCELLED;
    }
    public void markAsRejected() {
        requestState = RequestState.REJECTED;
    }

    public void notifyUser(Student student, SwapRequest request) {
        student.addNotification(this);
    }
    public void deleteFromStudent(Student student, int requestCode) {
        student.deleteNotification(requestCode);
    }
}
