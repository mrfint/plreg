package com.softserve.hms.repository;

import com.softserve.hms.domain.User;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private final static String CREATE_USER_SQL = "INSERT INTO USER (login, password) VALUES (?,?)";

    private DataSource dataSource;
    private SelectAllUsers selectAllUsers;
    private SelectUsersByFName selectUsersByFName;
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllUsers = new SelectAllUsers(dataSource);
        this.selectUsersByFName = new SelectUsersByFName(dataSource);
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public List<User> findAll() {
        return selectAllUsers.execute();
    }

    @Override
    public List<User> findUserByFName(String name) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("first_name", name);
        return selectUsersByFName.executeByNamedParam(paramMap);
    }

    @Override
    public void createUser(User user) {
        simpleJdbcTemplate.update(CREATE_USER_SQL, user.getLogin(), user.getPassword());
    }
}
