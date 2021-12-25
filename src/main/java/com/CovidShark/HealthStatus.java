package com.CovidShark;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The HealthStatus class.
 */
public class HealthStatus {

    /**
     * The HESCode string holds the HES code of a user.
     */
    private String HESCode;

    /**
     * The covidStatus boolean holds the covid status of a user.
     */
    private boolean covidStatus;

    /**
     * The vaccinationInfo list holds the vaccine info of a user.
     */
    private List<Vaccine> vaccinationInfo;

    /**
     * The quarantineStatus boolean holds the quarantine status of a user.
     */
    private boolean quarantineStatus;

    /**
     * The quarantineDay integer holds the number of quarantine days.
     */
    private int quarantineDay;

    /**
     * The quarantineEndDate is a Date which is a built-in library of Java.
     */
    private Date quarantineEndDate;

    /**
     * The campusPermission boolean holds the campus permission of a user.
     * If it is false, it means that the user cannot enter the campus.
     */
    private boolean campusPermission;

    /**
     * The PCRHistory list holds the PCR results of a user.
     */
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

    /**
     * The setHESCode(String HESCode) operation sets the HES code of a user.
     */
    public void setHESCode(String HESCode) {
        this.HESCode = HESCode;
    }

    /**
     * The getHESCode() operation gets the HES code of a user.
     * @return the HES code.
     */
    public String getHESCode() {
        return HESCode;
    }

    // Covid status operations

    /**
     * The setCovidStatus(boolean covidStatus) sets the covid status of a user.
     */
    public void setCovidStatus(boolean covidStatus) {this.covidStatus = covidStatus;}
    public boolean isCovid() {
        return covidStatus;
    }

    /**
     * The getVaccinationInfo() gets the vaccination information of a user.
     * @return the vaccine information of a user in a list.
     */
    // vaccinationInfo operations
    public List<Vaccine> getVaccinationInfo() {
        return vaccinationInfo;
    }

    /**
     * The setVaccinationInfo(List<Vaccine> vaccinationInfo) operation sets the vaccination information of a student.
     */
    public void setVaccinationInfo(List<Vaccine> vaccinationInfo) {
        this.vaccinationInfo = vaccinationInfo;
    }

    /**
     * The addNewVaccination(Vaccine vaccine) operation adds enw vaccination to the vaccination information.
     */
    public void addNewVaccination(Vaccine vaccine) {
        vaccinationInfo.add(vaccine);
    }

    // quarantine operations

    /**
     * The startQuarantine(int day, Date endDate) operation starts the quarantine of a user.
     */
    public void startQuarantine(int day, Date endDate){
        quarantineStatus = true;
        quarantineDay = day;
        quarantineEndDate = endDate;
    }

    /**
     * The endQuarantine() ends the quarantine of a user.
     */
    public void endQuarantine(){
        quarantineStatus = false;
        quarantineDay = 0;
        quarantineEndDate = null;
    }

    /**
     * The getQuarantineEndDate() operation gets the end date of quarantine of a user.
     * @return the quarantine end date.
     */
    public Date getQuarantineEndDate() {
        return quarantineEndDate;
    }

    /**
     * The getQuarantineDay() operation gets the quarantine day of a user.
     * @return the number of quarantine days.
     */
    public int getQuarantineDay() {
        return quarantineDay;
    }

    /**
     * The isInQuarantine() operation checks if a user is in quarantine or not.
     * @return the quarantine status.
     */
    public boolean isInQuarantine() {
        return quarantineStatus;
    }

    // PCRHistory operations

    /**
     * The setPCRHistory(list<PCR> PCRHistory) operation sets the PCR history of a user.
     */
    public void setPCRHistory(List<PCR> PCRHistory) {
        this.PCRHistory = PCRHistory;
    }

    /**
     * The getPCRHistory() operation gets the PCR history of a user.
     * @return the list of PCR results.
     */
    public List<PCR> getPCRHistory() {
        return PCRHistory;
    }

    /**
     * The addNewPCRTest(PCR pcrTest) operation adds a new PCR test to the PCR history.
     */
    public void addNewPCRTest(PCR pcrTest) {
       PCRHistory.add(pcrTest);
    }

    // campusPermission operations

    /**
     * The viewCampusPermission() operation checks if a user is allowed to enter campus or not.
     * @return the campus permission.
     */
    public boolean viewCampusPermission() {
        return campusPermission;
    }

    /**
     * The setCampusPermission(boolean campusPermission) operation sets the campus permission of a user.
     */
    public void setCampusPermission(boolean campusPermission) {
        this.campusPermission = campusPermission;
    }
}
