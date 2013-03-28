package com.softserve.hms.domain;

public class Appointment {
    private Integer id;
    private Patient patient;
    private User user;
    private String hospital;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (!user.equals(that.user)) return false;
        if (!hospital.equals(that.hospital)) return false;
        if (!id.equals(that.id)) return false;
        if (!patient.equals(that.patient)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + patient.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + hospital.hashCode();
        return result;
    }
}
