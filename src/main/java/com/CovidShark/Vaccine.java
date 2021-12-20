package com.CovidShark;

import java.util.Date;

public class Vaccine {

    private VaccineType vaccineType;
    private Date vaccinationDate;

    public Vaccine(VaccineType vaccineType, Date vaccinationDate) {
        this.vaccineType = vaccineType;
        this.vaccinationDate = vaccinationDate;
    }

    enum VaccineType {
        SPUTNIK,
        BIONTECH,
        SINOVAC
    }

    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }
}
