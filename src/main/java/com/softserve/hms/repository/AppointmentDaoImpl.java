package com.softserve.hms.repository;

import com.softserve.hms.domain.Appointment;
import com.softserve.hms.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("appointmentDao")
public class AppointmentDaoImpl implements AppointmentDao {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

//    @Autowired
//    public AppointmentDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Appointment> findAll() {
        List<Appointment> appointments = new ArrayList<Appointment>();
        // Retrieve the list of all appointments.
        appointments.addAll(this.jdbcTemplate.query(
                "SELECT * FROM appointment",
                ParameterizedBeanPropertyRowMapper.newInstance(Appointment.class)));

        // Retrieve the list of all possible patients.
        List<Patient> patients = this.jdbcTemplate.query(
                "SELECT * FROM patient",
                ParameterizedBeanPropertyRowMapper.newInstance(Patient.class));

        Map<Integer, Patient> map = new HashMap<Integer,Patient>();
        for(Patient patient: patients){
            map.put(patient.getId(), patient);
        }

        for(Appointment appointment: appointments){
            appointment.setPatient(map.get(appointment.getPatientId()));
        }

        return appointments;
    }
}
