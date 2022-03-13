package com.colin.aop.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibInterceptor implements MethodInterceptor {
    //被代理对象，因为其可以是任一对象，所以是Object类型
    Object target;
    //事务对象，这个对象由开发者自定义
    Transaction transaction;

    public CGLibInterceptor(Object target, Transaction transaction) {
        this.target = target;
        this.transaction = transaction;
    }

    //创建代理对象实例
    public Object createProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(target.getClass());
        return enhancer.create();
    }

    /**
     * @param o 代理对象实例
     * @param method 代理对象实例中调用接口方法的Method实例
     * @param objects 代理对象调用的方法的参数的对象数组
     * @param methodProxy 通过它可以调用父类的方法
     * @return 无返回值则返回null
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //并不是所有的方法都要切入（例如select操作不需要增加事务），所以在添加事务之前可以进行筛选
        String methodName = method.getName();

        if(methodName.startsWith("delete") ||
        methodName.startsWith("update") ||
        methodName.startsWith("insert")){
            transaction.openTransaction();
            method.invoke(target, objects); //相当于被代理类的方法被调用
            transaction.comitTransaction();
        } else {
            method.invoke(target, objects);
        }

        return null;
    }
}
