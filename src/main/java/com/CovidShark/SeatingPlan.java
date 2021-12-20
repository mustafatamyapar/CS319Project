package main.java.com.CovidShark;
import main.java.com.CovidShark.Student;
public class SeatingPlan {

    private int rowNum;
    private int columnNum;
    private Student[][] seats;
    private char[] columnRepresentation = "ABCDEFGHIJKLMNOQRSTUVQXYZ".toCharArray();
    public SeatingPlan(int rowNum, int columnNum){
        Student[][] seats = new Student[rowNum][columnNum];
    }
    public int getColumnNum() {
        return columnNum;
    }

    public int getRowNum() {
        return rowNum;
    }


    private int getIndexColumn(String s){
        for (int i = 0; i < columnRepresentation.length; i++){
            if(columnRepresentation.equals(s))  {
                return i;
            }
        }
        return -1;
    }

    public boolean hasSeat(Student student){
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < columnNum; j++) {
                if (seats[rowNum][columnNum] != null && seats[rowNum][columnNum].getIdNumber() == student.getIdNumber() )
                    return true;
            }
        }
        // if the student could not been found
        return false;
    }

    public String getSeat(Student student) {
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < columnNum; j++) {
                if (seats[rowNum][columnNum] != null && seats[rowNum][columnNum].getIdNumber() == student.getIdNumber() )
                    return String.valueOf(rowNum + 1) + "-" + columnRepresentation[columnNum];
            }
        }
        // if the student could not been found
        return null;
    }

    public boolean swapSeats(Student requester, Student recepient) {
        if (hasSeat(requester) && hasSeat(recepient)){
            String seat1 = getSeat(requester);
            String seat2 = getSeat(requester);
            setSeat(seat1, recepient);
            setSeat(seat2, requester);
            return true;
        }
        else
            return false;
    }

    public Student getStudent(String seat) {
        if (!isEmpty(seat))  {
            int divider = seat.indexOf("-");
            return seats[Integer.parseInt(seat.substring(0 , divider))-1][getIndexColumn(seat.substring(divider + 1 , divider+2))];
        }
        else
            return null;
    }

    public boolean selectSeat(String seat, Student student) {
        if (isEmpty(seat)){
            int divider = seat.indexOf("-");
            seats[Integer.parseInt(seat.substring(0 , divider))-1][getIndexColumn(seat.substring(divider + 1 , divider+2))] = student;
            return true;
        }
        return false;
    }


    public void setSeat(String seat, Student student) {
            int divider = seat.indexOf("-");
            seats[Integer.parseInt(seat.substring(0 , divider))-1][getIndexColumn(seat.substring(divider + 1 , divider+2))] = student;
    }

    public boolean isEmpty(String seat) {
        int divider = seat.indexOf("-");
        return seats[Integer.parseInt(seat.substring(0 , divider))-1][getIndexColumn(seat.substring(divider + 1 , divider+2))] == null;
    }

    public boolean freeSeat(Student student) {
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < columnNum; j++) {
                if (seats[rowNum][columnNum] != null && seats[rowNum][columnNum].getIdNumber() == student.getIdNumber() ) {
                    seats[rowNum][columnNum] = null;
                    return true;
                }
            }
        }
        // if the student could not been found
        return false;
    }
}
