package com.CovidShark;

import java.util.Date;

/**
 * The PCR class.
 */
public class PCR {

    /**
     * The PCRResult integer holds the PCR result.
     */
    private int PCRResult;

    /**
     * The PCRDate is a Date which is a built-in library of Java.
     */
    private Date PCRDate;

    public PCR(int PCRResult, Date PCRDate) {
        this.PCRResult = PCRResult;
        this.PCRDate = PCRDate;
    }

    /**
     * The getPCRDate() operation gets the PCR date of a user.
     * @return the PCR date.
     */
    public Date getPCRDate() {
        return PCRDate;
    }

    /**
     * The getPCRResult() operation gets the PCR result of a user.
     * @return the PCR result.
     */
    public int getPCRResult() {
        return PCRResult;
    }

    /**
     * The setPCRResult(int PCRResult) sets the PCR result of a user.
     */
    public void setPCRResult(int PCRResult) {
        this.PCRResult = PCRResult;
    }
}
