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
    // HES Code operations
    public void setHESCode(String HESCode) {
        this.HESCode = HESCode;
    }
    public String getHESCode() {
        return HESCode;
    }

    // Covid status operations
    public void setCovidStatus(boolean covidStatus) {this.covidStatus = covidStatus;}
    public boolean isCovid() {
        return covidStatus;
    }

    // vaccinationInfo operations
    public List<Vaccine> getVaccinationInfo() {
        return vaccinationInfo;
    }
    public void setVaccinationInfo(List<Vaccine> vaccinationInfo) {
        this.vaccinationInfo = vaccinationInfo;
    }
    public void addNewVaccination(Vaccine vaccine) {
        vaccinationInfo.add(vaccine);
    }

    // quarantine operations
    public void startQuarantine(int day, Date endDate){
        quarantineStatus = true;
        quarantineDay = day;
        quarantineEndDate = endDate;
    }

    public void endQuarantine(){
        quarantineStatus = false;
        quarantineDay = 0;
        quarantineEndDate = null;
    }
    public Date getQuarantineEndDate() {
        return quarantineEndDate;
    }
    public int getQuarantineDay() {
        return quarantineDay;
    }
    public boolean isInQuarantine() {
        return quarantineStatus;
    }

    // PCRHistory operations
    public void setPCRHistory(List<PCR> PCRHistory) {
        this.PCRHistory = PCRHistory;
    }
    public List<PCR> getPCRHistory() {
        return PCRHistory;
    }
    public void addNewPCRTest(PCR pcrTest) {
       PCRHistory.add(pcrTest);
    }

    // campusPermission operations
    public boolean viewCampusPermission() {
        return campusPermission;
    }
    public void setCampusPermission(boolean campusPermission) {
        this.campusPermission = campusPermission;
    }

}
