package com.colin.aop.proxy;

public class StaticProxy implements PersonDao{
    //被代理对象实例
    private PersonDao personDao;
    //事务类对象实例
    private Transaction transaction;

    //这两个对象必须实例化，所以添加构造函数
    public StaticProxy(PersonDao personDao, Transaction transaction) {
        this.personDao = personDao;
        this.transaction = transaction;
    }

    @Override
    public void selectPerson() {
        transaction.openTransaction();
        personDao.selectPerson();
        transaction.comitTransaction();
    }

    @Override
    public void insertPerson() {
        transaction.openTransaction();
        personDao.insertPerson();
        transaction.comitTransaction();
    }

    @Override
    public void deletePerson() {
        transaction.openTransaction();
        personDao.deletePerson();
        transaction.comitTransaction();
    }

    @Override
    public void updatePerson() {
        transaction.openTransaction();
        personDao.updatePerson();
        transaction.comitTransaction();
    }
}
