package com.softserve.hms.domain;

public class Doctor extends Person{

    private String specialization;

    @Override
    public boolean equals(Object o) {

        Doctor doctor = (Doctor) o;
        if (super.equals(o)&&
                specialization.equals(doctor.specialization)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode() + specialization.hashCode();
        return result;
    }
}
