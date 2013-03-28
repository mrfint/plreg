/* Copyright Homeaway, Inc 2005-2013. All Rights Reserved.
 * No unauthorized use of this software.
 */
package com.softserve.hms.service;

import com.softserve.hms.domain.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Appointment service implementation.
 *
 * @author aborovyk
 */
@Service
public class AppointmentService {

    public List<Appointment> getAppointments(String hospital, String department, int page) {
        return null;
    }

    public int getAppointmentPages(String hospital, String department) {
        return 0;
    }
}
