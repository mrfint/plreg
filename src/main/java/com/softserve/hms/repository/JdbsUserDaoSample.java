package com.softserve.hms.repository;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbsUserDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/softserve/hms/spring/data.xml");
        context.refresh();

        UserDao doctorDao = context.getBean("userDao", UserDao.class);
        System.out.println(doctorDao.findPersonByFName("Joan").get(0).getId());
    }
}
