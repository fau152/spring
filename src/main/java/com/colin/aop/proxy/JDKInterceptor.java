package com.colin.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInterceptor implements InvocationHandler {
    //被代理对象，因为其可以是任一对象，所以是Object类型
    private Object target;
    //事务对象，这个对象由开发者自定义
    private Transaction transaction;

    public JDKInterceptor(Object target, Transaction transaction) {
        this.target = target;
        this.transaction = transaction;
    }

    /**
     * @param proxy 目标对象的代理类实例
     * @param method 对应于在代理类实例上调用接口方法的Method实例（反射的方式调用）
     * @param args 传入代理类实例的方法参数值的对象数组
     * @return 方法的返回值，没有返回值则为null
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //并不是所有的方法都要切入（例如select操作不需要增加事务），所以在添加事务之前可以进行筛选
        String methodName = method.getName();

        if(methodName.startsWith("delete") ||
        methodName.startsWith("update") ||
        methodName.startsWith("insert")){
            transaction.openTransaction();
            method.invoke(target, args); //相当于被代理类的方法被调用
            transaction.comitTransaction();
        } else {
            method.invoke(target, args);
        }

        return null;
    }
}
