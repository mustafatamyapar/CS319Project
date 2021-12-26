package com.CovidShark;

import org.apache.logging.log4j.message.ReusableMessage;

import java.util.List;

/**
 * The SwapRequest class extends the Notification class.
 */
public class SwapRequest extends Notification {

    /**
     * The seat String holds the seat.
     */
    private String seat;

    /**
     * The seatOwner object holds the seat owner student.
     */
    private Student seatOwner;

    /**
     * The requester object holds the requester student.
     */
    private Student requester;

    /**
     * The requestState object holds the request state.
     */
    private RequestState requestState;

    /**
     * The section object holds the section.
     */
    private Section section;

    /**
     * The RequestState enum has 4 request states.
     */
    enum RequestState {
        PENDING,
        ACCEPTED,
        REJECTED,
        CANCELLED
    }

    public SwapRequest(String msg, String seat, Student seatOwner, Student requester, Section section) {
        super(msg, "Swap Request", requester.getName());
        this.seat = seat;
        this.seatOwner = seatOwner;
        this.requester = requester;
        this.requestState = RequestState.PENDING;
        this.section = section;
    }

    /**
     * The getSeat() operation gets the seat of a student.
     * @return the seat.
     */
    public String getSeat() {
        return seat;
    }

    /**
     * The getRequester() operation gets the requester student.
     * @return the requester.
     */
    public Student getRequester() {return requester;}

    /**
     * The getSeatOwner() operation gets the seat owner student.
     * @return the seat owner.
     */
    public Student getSeatOwner() {
        return seatOwner;
    }

    /**
     * The getSection() operation gets the section.
     * @return the section.
     */
    public Section getSection() {return section;}

    /**
     * The getRequestState() operation gets the request state.
     * @return the request state.
     */
    public RequestState getRequestState() {
        return requestState;
    }

    /**
     * The markAsAccepted() operation marks a request as accepted.
     */
    public void markAsAccepted() {
        requestState = RequestState.ACCEPTED;
    }

    /**
     * The markAsCancelled() operation marks a request as cancelled.
     */
    public void markAsCancelled() {
        requestState = RequestState.CANCELLED;
    }

    /**
     * The markAsRejected() operation marks a request as rejected.
     */
    public void markAsRejected() {
        requestState = RequestState.REJECTED;
    }

    /**
     * The notifyUser(Student student, SwapRequest request) operation notifies a user about the swap.
     */
    /*
    public void notifyUser(Student student, SwapRequest request) {
        student.createSwapRequest(this);
    }

    public void deleteFromStudent(Student student, int requestCode) {

        student.deleteSwapRequest(requestCode);
    }
    */
}
