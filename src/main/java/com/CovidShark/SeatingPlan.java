package com.CovidShark;

import java.util.Objects;

/**
 * The SeatingPlan class.
 */
public class SeatingPlan {
    private int id;
    /**
     * The rowNum integer holds the row number.
     */
    private int rowNum;


    /**
     * The columnNum integer holds the column number.
     */
    private int columnNum;

    /**
     * The seats 2D array holds the student objects.
     */
    private Student[][] seats;

    /**
     * The columnRepresentation String array holds the columns.
     */
    private String[] columnRepresentation = {"A", "B", "C", "D", "E", "F", "G","H", "I","J","K","L","M","N","O","Q","R","S","T","U","V","Q","X","Y","Z"};

    public SeatingPlan(int rowNum, int columnNum){
        this.rowNum = rowNum;
        this.columnNum = columnNum;
        seats = new Student[rowNum][columnNum];
    }

    public SeatingPlan(){

    }

    /**
     * The getColumnNum() operation gets the column number.
     * @return the column number.
     */
    public int getColumnNum() {
        return columnNum;
    }

    /**
     * The getRowNum() operation gets the row number.
     * @return the row number.
     */
    public int getRowNum() {
        return rowNum;
    }

    /**
     * The getIndexColumn(String s) operation gets the index of column.
     * @return the index of the column if operation is successful, -1 otherwise.
     */
    private int getIndexColumn(String s){
        for (int i = 0; i < columnRepresentation.length; i++){
            if(columnRepresentation[i].equals(s))  {
                return i;
            }
        }
        return -1;
    }

    /**
     * The hasSeat(Student student) operation checks if a student has a seat.
     * @return true if the student with the seat is found, false otherwise.
     */
    public boolean hasSeat(Student student){
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < columnNum; j++) {
                if (seats[rowNum][columnNum] != null && Objects.equals(seats[rowNum][columnNum].getIdNumber(), student.getIdNumber()))
                    return true;
            }
        }
        // if the student could not been found
        return false;
    }

    /**
     * The getSeat(Student student) operation gets the seat of a student.
     * @return the seat if found, null otherwise.
     */
    public String getSeat(Student student) {
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < columnNum; j++) {
                if (seats[rowNum][columnNum] != null && Objects.equals(seats[rowNum][columnNum].getIdNumber(), student.getIdNumber()))
                    return String.valueOf(rowNum + 1) + "-" + columnRepresentation[columnNum];
            }
        }
        // if the student could not been found
        return null;
    }

    /**
     * The swapSeats(Student requester, Student recepient) operation swap seats between two students.
     * @return true if swap operation is successful, false otherwise.
     */
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * The getStudent(String seat) operation gets the student with a seat.
     * @return the seat if seat is not empty, null otherwise.
     */
    public Student getStudent(String seat) {
        if (!isEmpty(seat))  {
            int divider = seat.indexOf("-");
            return seats[Integer.parseInt(seat.substring(0 , divider))-1][getIndexColumn(seat.substring(divider + 1 , divider+2))];
        }
        else
            return null;
    }

    /**
     * The selectSeat(String seat, Student student) operation selects a seat.
     * @return true if seat is selected, false otherwise.
     */
    public boolean selectSeat(String seat, Student student) {
        if (isEmpty(seat)){
            int divider = seat.indexOf("-");
            seats[Integer.parseInt(seat.substring(0 , divider))-1][getIndexColumn(seat.substring(divider + 1 , divider+2))] = student;
            return true;
        }
        return false;
    }

    /**
     * The setSeat(String seat, Student student) operation sets the seat of a student.
     */
    public void setSeat(String seat, Student student) {
            int divider = seat.indexOf("-");
            seats[Integer.parseInt(seat.substring(0 , divider))-1][getIndexColumn(seat.substring(divider + 1 , divider+2))] = student;
    }

    /**
     * The isEmpty(String seat) operation checks if a seat is empty.
     * @return the seat if it is not empty.
     */
    public boolean isEmpty(String seat) {
        int divider = seat.indexOf("-");
        return seats[Integer.parseInt(seat.substring(0 , divider))-1][getIndexColumn(seat.substring(divider + 1 , divider+2))] == null;
    }

    /**
     * The freeSeat(Student student) operation frees a seat of a student.
     * @return true if seat is freed, false if the student with a seat is not found.
     */
    public boolean freeSeat(Student student) {
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < columnNum; j++) {
                if (seats[rowNum][columnNum] != null && Objects.equals(seats[rowNum][columnNum].getIdNumber(), student.getIdNumber())) {
                    seats[rowNum][columnNum] = null;
                    return true;
                }
            }
        }
        // if the student could not been found
        return false;
    }
}
