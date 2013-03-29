package com.softserve.hms.repository;

import com.softserve.hms.domain.Appointment;

import java.util.List;

public interface AppointmentDao {
    List<Appointment> findAll();

    /**
     * Get one appointments page.
     * @param hospital - hospital filter or null if there is no filter.
     * @param department  - department filter or null if there is no filter.
     * @param from  - first row number, 0 based.
     * @param pageSize - page size, set 0 to get all appointments after from number.
     * @return list of the appointments for a single page.
     */
    List<Appointment> getAppointments(String hospital, String department, long from, long pageSize);
}
