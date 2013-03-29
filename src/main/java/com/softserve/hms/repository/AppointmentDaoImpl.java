package com.softserve.hms.repository;

import com.softserve.hms.domain.Appointment;
import com.softserve.hms.domain.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
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
            = "SELECT LIMIT ?, ? * FROM appointment JOIN patient ON appointment.id = patient.id";
    private static final String PAGING_QUERY_HOSPITAL_FILTER
            = "SELECT LIMIT ?, ? * FROM appointment JOIN patient ON appointment.id = patient.id WHERE hospital = ?";
    private static final String PAGING_QUERY_DEPARTMENT_FILTER
            = "SELECT LIMIT ?, ? * FROM appointment JOIN patient ON appointment.id = patient.id WHERE department = ?";
    private static final String PAGING_QUERY_HOSPITAL_DEPARTMENT_FILTER
            = "SELECT LIMIT ?, ? * FROM appointment JOIN patient ON appointment.id = patient.id WHERE hospital = ? AND department = ?";

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
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

    private static final class AppointMantMapper implements RowMapper<Appointment> {

        //map for storing patients to reduce creation of duplicate instances
        final Map<Integer, Patient> patients = new HashMap<Integer, Patient>();

        @Override
        public Appointment mapRow(ResultSet resultSet, int i) throws SQLException {
            Integer patientId = resultSet.getInt("patient.id");
            Patient patient = patients.get(patientId);
            if (patient == null) {
                patient = new Patient();
                patient.setId(patientId);
                patient.setFirstName(resultSet.getString("patient.first_name"));
                patient.setLastName(resultSet.getString("patient.first_name"));
                patients.put(patientId, patient);
            }
            com.softserve.hms.domain.Appointment appointment = new com.softserve.hms.domain.Appointment();
            appointment.setId(resultSet.getInt("appointment.id"));
            appointment.setPatient(patient);
            appointment.setHospital(resultSet.getString("appointment.hospital"));
            return appointment;
        }
    }

    @Override
    public List<Appointment> getAppointments(String hospital, String department, long from, long pageSize) {
        if (hospital != null) {
            if (department != null) {
                return simpleJdbcTemplate.query(PAGING_QUERY_HOSPITAL_DEPARTMENT_FILTER, new AppointMantMapper(),
                        from, pageSize, hospital, department);
            }
            else return simpleJdbcTemplate.query(PAGING_QUERY_HOSPITAL_FILTER, new AppointMantMapper(),
                    from, pageSize, hospital);
        }
        else {
            if (department != null)
                return simpleJdbcTemplate.query(PAGING_QUERY_DEPARTMENT_FILTER, new AppointMantMapper(),
                        from, pageSize, department);
        }
        return simpleJdbcTemplate.query(PAGING_QUERY_NO_FILTER, new AppointMantMapper(), from, pageSize);
    }
}
