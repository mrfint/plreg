package com.softserve.hms.repository;

import com.softserve.hms.domain.User;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class SelectUsersByFName extends MappingSqlQuery<User> {
    private static final String SQL_SELECT_BY_FNAME = "select * from user where first_name = :first_name";

    public SelectUsersByFName(DataSource dataSource) {
        super(dataSource, SQL_SELECT_BY_FNAME);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
    }

    @Override
    protected User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setLogin(resultSet.getString("login"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        return user;
    }
}
