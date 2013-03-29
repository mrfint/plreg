package com.softserve.hms.rest;

import com.softserve.hms.domain.Appointment;
import com.softserve.hms.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppointmentsRestController {

    @Autowired
    AppointmentService appointmentService;

    @RequestMapping(value="/rest/appointments", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }
}
