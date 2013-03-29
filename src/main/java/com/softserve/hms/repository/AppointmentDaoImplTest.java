package com.softserve.hms.repository;

import com.softserve.hms.domain.Appointment;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppointmentDaoImplTest {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/softserve/hms/spring/data.xml");
        context.refresh();

        AppointmentDao appointmentDao = context.getBean("appointmentDao", AppointmentDao.class);
        for(Appointment o : appointmentDao.findAll()){
            System.out.println(o);
        }
    }
}

