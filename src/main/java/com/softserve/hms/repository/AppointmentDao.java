package com.softserve.hms.repository;

import com.softserve.hms.domain.Appointment;

import java.util.List;

public interface AppointmentDao {
    List<Appointment> findAll();
}
