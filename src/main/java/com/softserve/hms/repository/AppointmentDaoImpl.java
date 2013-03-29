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

    private static final String PAGING_QUERY_NO_FILTER
            = "SELECT LIMIT ?, ? * FROM appointment";
    private static final String PAGING_QUERY_HOSPITAL_FILTER
            = "SELECT LIMIT ?, ? * FROM appointment WHERE hospital = ?";
    private static final String PAGING_QUERY_DEPARTMENT_FILTER
            = "SELECT LIMIT ?, ? * FROM appointment WHERE department = ?";
    private static final String PAGING_QUERY_HOSPITAL_DEPARTMENT_FILTER
            = "SELECT LIMIT ?, ? * FROM appointment WHERE hospital = ? AND department = ?";

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

    @Override
    public List<Appointment> getAppointments(String hospital, String department, long from, long pageSize) {
        List args = new ArrayList();
        args.add(from);
        args.add(pageSize);
        //define query for filtering
        String sqlQuery = PAGING_QUERY_NO_FILTER;
        if (hospital != null) {
            args.add(hospital);
            if (department != null) {
                args.add(department);
                sqlQuery = PAGING_QUERY_HOSPITAL_DEPARTMENT_FILTER;
            }
            else sqlQuery = PAGING_QUERY_HOSPITAL_FILTER;
        }
        else {
            if (department != null) {
                args.add(department);
                sqlQuery = PAGING_QUERY_DEPARTMENT_FILTER;
            }
        }
        //get appointments.
        return jdbcTemplate.query(sqlQuery, args.toArray(),
                ParameterizedBeanPropertyRowMapper.newInstance(Appointment.class));
    }
}
