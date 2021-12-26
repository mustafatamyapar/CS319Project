package com.CovidShark;

import java.util.Date;

/**
 * The Vaccine class.
 */
public class Vaccine {

    /**
     * The vaccineType object holds the vaccine type.
     */
    private VaccineType vaccineType;

    /**
     * The vaccinationDate is a Date which is a built-in library of Java.
     */
    private Date vaccinationDate;

    public Vaccine(VaccineType vaccineType, Date vaccinationDate) {
        this.vaccineType = vaccineType;
        this.vaccinationDate = vaccinationDate;
    }

    /**
     * The vaccine type enum holds the 3 vaccine types.
     */
    enum VaccineType {
        SPUTNIK,
        BIONTECH,
        SINOVAC
    }

    /**
     * The getVaccinationDate() operation gets the vaccination date.
     * @return the vaccination date.
     */
    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    /**
     * The getVaccineType() operation gets the vaccine type.
     * @return the vaccine type.
     */
    public VaccineType getVaccineType() {
        return vaccineType;
    }
}
