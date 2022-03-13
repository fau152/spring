package com.colin.aop.proxy.impl;

import com.colin.aop.proxy.PersonDao;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void selectPerson() {
        System.out.println("selectPerson()");
    }

    @Override
    public void insertPerson() {
        System.out.println("insertPerson()");
    }

    @Override
    public void deletePerson() {
        System.out.println("deletePerson()");
    }

    @Override
    public void updatePerson() {
        System.out.println("updatePerson()");
    }
}
