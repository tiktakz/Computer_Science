package Networking;
import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class TcpIpServer {
    static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }


    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + " Server is Ready");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                System.out.println(getTime() + " Waiting for Connection");
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + " request connection");

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF("Test Message");
                System.out.println(getTime() + " Message sent");

                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
