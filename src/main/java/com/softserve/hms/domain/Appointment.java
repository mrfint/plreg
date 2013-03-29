package com.softserve.hms.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Appointment {
    private Integer id;
    private Patient patient;
    private String hospital;
    private Date appointDate;
    private String appointType;
    private String location;
    private Date dob;
    private String phone;
    private String mrn;
    private String pcn;
    private String resource;

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

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Date getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(Date appointDate) {
        this.appointDate = appointDate;
    }

    public String getAppointType() {
        return appointType;
    }

    public void setAppointType(String appointType) {
        this.appointType = appointType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMrn() {
        return mrn;
    }

    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    public String getPcn() {
        return pcn;
    }

    public void setPcn(String pcn) {
        this.pcn = pcn;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (appointDate != null ? !appointDate.equals(that.appointDate) : that.appointDate != null) return false;
        if (appointType != null ? !appointType.equals(that.appointType) : that.appointType != null) return false;
        if (dob != null ? !dob.equals(that.dob) : that.dob != null) return false;
        if (hospital != null ? !hospital.equals(that.hospital) : that.hospital != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (mrn != null ? !mrn.equals(that.mrn) : that.mrn != null) return false;
        if (patient != null ? !patient.equals(that.patient) : that.patient != null) return false;
        if (pcn != null ? !pcn.equals(that.pcn) : that.pcn != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (resource != null ? !resource.equals(that.resource) : that.resource != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + (hospital != null ? hospital.hashCode() : 0);
        result = 31 * result + (appointDate != null ? appointDate.hashCode() : 0);
        result = 31 * result + (appointType != null ? appointType.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (mrn != null ? mrn.hashCode() : 0);
        result = 31 * result + (pcn != null ? pcn.hashCode() : 0);
        result = 31 * result + (resource != null ? resource.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patient=" + patient +
                ", hospital='" + hospital + '\'' +
                ", appointDate=" + appointDate +
                ", appointType='" + appointType + '\'' +
                ", location='" + location + '\'' +
                ", dob=" + dob +
                ", phone='" + phone + '\'' +
                ", mrn='" + mrn + '\'' +
                ", pcn='" + pcn + '\'' +
                ", resource='" + resource + '\'' +
                '}';
    }
}
