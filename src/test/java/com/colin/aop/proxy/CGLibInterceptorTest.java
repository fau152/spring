package com.colin.aop.proxy;

import com.colin.aop.proxy.impl.PersonDaoImpl;
import org.junit.Test;


public class CGLibInterceptorTest {
    @Test
    public void test() {
        //被代理对象应该是提供好的，或者可以通过某种方法获取到的。
        PersonDao target = new PersonDaoImpl();
        //事务对象，是我们自己定义的，我们要添加的代码写在这个对象的方法中。
        Transaction transaction = new Transaction();

        CGLibInterceptor cgLibInterceptor = new CGLibInterceptor(target, transaction);
        //获取代理对象
        PersonDaoImpl proxyObject = (PersonDaoImpl) cgLibInterceptor.createProxy();
        proxyObject.selectPerson();
        proxyObject.deletePerson();
        proxyObject.insertPerson();
        proxyObject.updatePerson();
    }
}