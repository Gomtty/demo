package com.myoi.reflection;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author myoi
 * @date 2021/12/20 - 9:38
 */
interface Hello{
    String say(String juzi);
}
public class ProxyTest {

    @Test
    public void test4() {
        Function<Double,Long> fun= Math::round;
        System.out.println(fun.apply(1.1));
    }


    @Test
    public void test3() {
        Consumer<String> con= System.out::println;
        Consumer<String> con1= System.out::println;
        con1.accept("abc");

    }

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) getProxyInstance(superMan);
        proxyInstance.eat();
    }

    /**
     *
     * @param obj   被代理类对象
     * @return  代理类对象
     */
    public static Object getProxyInstance(Object obj) {
        ClassLoader classLoader = obj.getClass().getClassLoader();
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        MyInvocationHandler handler = new MyInvocationHandler(obj);
        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }

}
class MyInvocationHandler implements InvocationHandler{
    private Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象准备工作");
        Object returnVal = method.invoke(obj, args);
        System.out.println("代理对象后续工作");
        return returnVal;
    }
}

interface Human{

    void eat();

    String like(String... things);

}

class SuperMan implements Human{


    @Override
    public void eat() {
        System.out.println("超人吃东西");
    }

    @Override
    public String like(String... things) {
        return "超人喜欢吃"+ Arrays.toString(things);
    }
}
