package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class SocketClass_v2 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello");
        System.out.println("Enter the web address: ");
        String server = sc.nextLine();
        Socket socket =null;
        socket = new Socket(server, 80);
        
        MyRunnable Runn1 = new MyRunnable();

        Thread receivingThread = new SocketClientHandlerReceive(socket, Runn1);
        Thread sendingThread = new SocketClientHandlerSend(server, Runn1);     
        receivingThread.start();
        sendingThread.start();
        
        while(true) {
            System.out.println("Press anny key to request ");
                sc.nextLine();
                Runn1.run = true;
            }
    }
    
}



