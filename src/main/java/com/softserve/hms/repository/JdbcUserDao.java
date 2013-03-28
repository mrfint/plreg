package com.softserve.hms.repository;

import com.softserve.hms.domain.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("userDao")
public class JdbcUserDao implements UserDao {

    private DataSource dataSource;
    private SelectAllUsers selectAllUsers;
    private SelectUsersByFName selectUsersByFName;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllUsers = new SelectAllUsers(dataSource);
        this.selectUsersByFName = new SelectUsersByFName(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public String findFirsNameById(Integer id) {
        return null;
    }

    public List<User> findAll() {
        return selectAllUsers.execute();
    }

    public List<User> findPersonByFName(String name) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("first_name", name);
        return selectUsersByFName.executeByNamedParam(paramMap);
    }
}
