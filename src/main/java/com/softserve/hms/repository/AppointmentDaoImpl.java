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
import java.util.List;

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
        // Retrieve the list of all vets.
        appointments.addAll(this.jdbcTemplate.query(
                "SELECT * FROM appointment",
                ParameterizedBeanPropertyRowMapper.newInstance(Appointment.class)));

        // Retrieve the list of all possible specialties.
//        final List<Patient> specialties = this.jdbcTemplate.query(
//                "SELECT id, name FROM specialties",
//                ParameterizedBeanPropertyRowMapper.newInstance(Patient.class));

        // Build each vet's list of specialties.
//        for (Vet vet : vets) {
//            final List<Integer> vetSpecialtiesIds = this.jdbcTemplate.query(
//                    "SELECT specialty_id FROM vet_specialties WHERE vet_id=?",
//                    new ParameterizedRowMapper<Integer>() {
//                        @Override
//                        public Integer mapRow(ResultSet rs, int row) throws SQLException {
//                            return Integer.valueOf(rs.getInt(1));
//                        }
//                    },
//                    vet.getId().intValue());
//            for (int specialtyId : vetSpecialtiesIds) {
//                Specialty specialty = EntityUtils.getById(specialties, Specialty.class, specialtyId);
//                vet.addSpecialty(specialty);
//            }
//        }
        return appointments;
    }
}
