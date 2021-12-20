package com.CovidShark;

import java.util.Date;

public class PCR {

    private int PCRResult;
    private Date PCRDate;

    public PCR(int PCRResult, Date PCRDate) {
        this.PCRResult = PCRResult;
        this.PCRDate = PCRDate;
    }

    public Date getPCRDate() {
        return PCRDate;
    }

    public int getPCRResult() {
        return PCRResult;
    }

    public void setPCRResult(int PCRResult) {
        this.PCRResult = PCRResult;
    }
}
