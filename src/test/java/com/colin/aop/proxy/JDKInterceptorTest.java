package com.colin.aop.proxy;

import com.colin.aop.proxy.impl.PersonDaoImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class JDKInterceptorTest {
    @Test
    public void test(){
        //被代理对象应该是提供好的，或者可以通过某种方法获取到的。
        PersonDao target = new PersonDaoImpl();
        //事务对象，是我们自己定义的，我们要添加的代码写在这个对象的方法中。
        Transaction transaction = new Transaction();

        JDKInterceptor jdkInterceptor = new JDKInterceptor(target, transaction);
        //获取一个代理对象的实例
        PersonDao proxyObject = (PersonDao)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), jdkInterceptor);
        //返回的代理对象必须是接口类，不可以是实现类
        //PersonDaoImpl proxyObject = (PersonDaoImpl) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), jdkInterceptor);
        //使用代理对象来调用被代理对象方法
        proxyObject.selectPerson();
        proxyObject.deletePerson();
        proxyObject.insertPerson();
        proxyObject.updatePerson();
    }
}