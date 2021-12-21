package com.CovidShark;

import java.util.ArrayList;
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

    public HealthStatus(String HESCode) {
        this.HESCode = HESCode;
        this.covidStatus = false;
        this.vaccinationInfo = null;
        this.quarantineStatus = false;
        this.quarantineDay = 0;
        this.quarantineEndDate = null;
        this.campusPermission = false;
        this.PCRHistory = new ArrayList<PCR>();
    }

    public void updateHESCode(String HESCode, BaseUser user) {
        user.getHealthStatus().setHESCode(HESCode);
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

    public void setHESCode(String HESCode) {
        this.HESCode = HESCode;

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

    public void setCampusPermission(boolean campusPermission) {
        this.campusPermission = campusPermission;
    }

    public void setCovidStatus(boolean covidStatus) {
        this.covidStatus = covidStatus;
    }

    public void setPCRHistory(List<PCR> PCRHistory) {
        this.PCRHistory = PCRHistory;
    }

    public void setQuarantineDay(int quarantineDay) {
        this.quarantineDay = quarantineDay;
    }

    public void setQuarantineEndDate(Date quarantineEndDate) {
        this.quarantineEndDate = quarantineEndDate;
    }

    public void setQuarantineStatus(boolean quarantineStatus) {
        this.quarantineStatus = quarantineStatus;
    }

    public void setVaccinationInfo(List<Vaccine> vaccinationInfo) {
        this.vaccinationInfo = vaccinationInfo;
    }

    public void addPCRHistory(PCR p) {
        PCRHistory.add(p);
    }
}
