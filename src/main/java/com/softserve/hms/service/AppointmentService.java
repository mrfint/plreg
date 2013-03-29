package com.softserve.hms.service;

import com.softserve.hms.domain.Appointment;

import java.util.List;

public interface AppointmentService {
    public List<Appointment> findAll();
}
