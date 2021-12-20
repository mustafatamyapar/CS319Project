package com.CovidShark;

import java.util.Date;
import java.util.List;

public class HealthStatus {

    private String HESCode;
    private boolean covidStatus;
    private List<Vaccine> vaccinationInfo;
    private boolean quarantineStatus;
    private int quarantineDay;
    private Date quarantineEndDate;
    private boolean campusPermission;
    private List<PCR> PCRHistory;

    public void updateHESCode(String HESCode) {

    }

    public Date getQuarantineEndDate() {
        return quarantineEndDate;
    }

    public int getQuarantineDay() {
        return quarantineDay;
    }

    public String getHESCode() {
        return HESCode;
    }

    public List<PCR> getPCRHistory() {
        return PCRHistory;
    }

    public List<Vaccine> getVaccinationInfo() {
        return vaccinationInfo;
    }

    public boolean isCovid() {
        return covidStatus;
    }

    public boolean getQuarantineStatus() {
        return quarantineStatus;
    }

    public boolean getCampusPermission() {
        return campusPermission;
    }
}
