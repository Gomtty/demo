package com.myoi.IO;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author myoi
 * @date 2021/12/18 - 11:18
 */
public class InetAddressTest {

    @Test
    public void test1() {
        try {
            InetAddress inet = InetAddress.getByName("192.168.1.2");
            System.out.println(inet);
            InetAddress inet1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getLocalHost();
            System.out.println(inet2);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
