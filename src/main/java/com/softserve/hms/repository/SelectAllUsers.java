package com.softserve.hms.repository;

import com.softserve.hms.domain.User;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllUsers extends MappingSqlQuery<User> {
    private static final String SQL_SELECT_ALL_USERS = "select * from user";

    public SelectAllUsers(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_USERS);
    }

    @Override
    protected User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
//        user.setLogin(resultSet.getString("login"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        return user;
    }
}
