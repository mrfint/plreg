/* Copyright Homeaway, Inc 2005-2013. All Rights Reserved.
 * No unauthorized use of this software.
 */
package com.softserve.hms.service;

import com.softserve.hms.domain.Appointment;
import com.softserve.hms.repository.AppointmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Appointment service implementation.
 *
 * @author aborovyk
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public List<Appointment> findAll() {
        return appointmentDao.findAll();
    }
}
