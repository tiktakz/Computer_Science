package Networking;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TcpIpServer2 implements Runnable {
    ServerSocket serverSocket;
    Thread[] threadArr;

    public static void main(String[] args) {
        TcpIpServer2 server = new TcpIpServer2(5); // 5 Threads Server
        server.start();
    }

    public TcpIpServer2(int num) {
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "Server is Ready");
            threadArr = new Thread[num];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        for (int i=0; i< threadArr.length; i++) {
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }

    public void run() {
        while (true) {
            try {
                System.out.println(getTime() + "Waiting for Connection");

                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + " Request Connection");

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF("Test Message SENT");
                System.out.println(getTime() + "Message Sent");

                dos.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static String getTime() {
        String name = Thread.currentThread().getName();
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date()) + name ;
    }
}
