package com.myoi.IO;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author myoi
 * @date 2021/12/18 - 12:24
 */
public class SocketTest {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket(InetAddress.getByName("192.168.1.2"), 9090);
            os = socket.getOutputStream();
            String inputFile = "783676.jpg";
            fis = new FileInputStream(new File(inputFile));
            byte[] bytes = new byte[1024];
            int len;
            System.out.println("Client开始发送图片");
            while ((len = fis.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            socket.shutdownOutput();
            System.out.println("Client发送图片完成");
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            System.out.println("client准备接收消息");
            while ((len = is.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            String Ofile = "hello.jpg";
            fos = new FileOutputStream(new File(Ofile));
            System.out.println("来自" + socket.getInetAddress() + ":" + socket.getPort());
            byte[] bytes = new byte[1024];
            int len;
            System.out.println("server开始接收图片");
            while ((len = is.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            System.out.println("server图片接收完成");
            os = socket.getOutputStream();
            os.write("接收成功".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void Client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("192.168.1.2");
            socket = new Socket(inet, 8889);
            os = socket.getOutputStream();
            os.write("你好啊我很好".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void Server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            serverSocket = new ServerSocket(8889);
            socket = serverSocket.accept();
            System.out.println("来自" + socket.getInetAddress() + ":" + socket.getPort());
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int len;
            while ((len = is.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
