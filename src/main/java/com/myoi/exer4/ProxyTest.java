package com.myoi.exer4;

/**
 * @author myoi
 * @date 2021/12/8 - 15:39
 */
public class ProxyTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }

}

interface Network{
    void browse();
}

class Server implements Network{
    @Override
    public void browse() {
        System.out.println("真实的上网");
    }
}

class ProxyServer implements Network{
    private Network network;//需要被代理的对象

    public ProxyServer(Network network) {//构造器初始化对象
        this.network=network;
    }

    public void check() {
        System.out.println("上网前的校验");
    }

    @Override
    public void browse() {
        check();
        network.browse();
    }
}