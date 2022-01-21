package com.myoi.reflection;

/**
 * @author myoi
 * @date 2021/12/20 - 9:21
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        ClothesFactory nike = new NikeFactory();
        ClothesFactory proxyClothesFactory = new ProxyClothesFactory(nike);
        proxyClothesFactory.produceClothes();
    }

}

interface ClothesFactory{
    void produceClothes();
}

class ProxyClothesFactory implements ClothesFactory{
    //通过构造器获取被代理对象
    private ClothesFactory factory;

    public ProxyClothesFactory(ClothesFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceClothes() {
        System.out.println("代理工厂的准备工作");
        factory.produceClothes();
        System.out.println("代理工厂的后续工作");
    }
}
class NikeFactory implements ClothesFactory{


    @Override
    public void produceClothes() {
        System.out.println("nike生产运动服");
    }
}
