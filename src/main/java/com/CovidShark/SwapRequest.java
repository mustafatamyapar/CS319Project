package main.java.com.CovidShark;

public class SwapRequest {

    private String seat;
    private Student seatOwner;
    private Student requester;
    private int requestCode;
    private int requestState;
    private Course course;
    private Section section;
    private boolean notDone;

    public String getSeat() {
        return seat;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public Student getRequester() {

        return requester;
    }

    public Section getSection() {

        return section;
    }

    public Student getSeatOwner() {
        return seatOwner;
    }

    public int getRequestState() {
        return requestState;
    }

    public Course getCourse(String courseCode) {
        return course;
    }

    public void notifyUser(Student student, SwapRequest request) {

    }

    public void markAsDone() {

    }

    public void deleteFromStudent(Student student, int requestCode) {

    }
}
