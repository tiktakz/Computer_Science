package Networking;
import java.net.*;
import java.io.*;

public class TcpIpClient {
    public static void main(String[] args) {
        try {
            String serverIp = "192.168.219.100";
            System.out.println("Connecting to IP " + serverIp);
            Socket socket = new Socket(serverIp, 7777);
            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);
            sender.start();
            receiver.start();

            //InputStream in = socket.getInputStream();
            //DataInputStream dis = new DataInputStream(in);

            //System.out.println("Received message from Server " + dis.readUTF());
            //System.out.println("Finish Connection");

            //dis.close();
            //socket.close();
            System.out.println("Connection End");
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
