package src;

import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class SocketClass_v2 {
    // Client to Server 
    public static void main(String[] args) throws IOException, InterruptedException {
        // Take input from client
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello");
        System.out.println("Enter the web address: ");
        String server = sc.nextLine();
        Socket socket =null;
        socket = new Socket(server, 80);
        System.out.println("Socket created");
        
        MyRunnable Runn1 = new MyRunnable();

        Thread receivingThread = new SocketClientHandlerReceive(socket, Runn1);
        Thread sendingThread = new SocketClientHandlerSend(server, Runn1);     
        receivingThread.start();
        sendingThread.start();
        
        while(true) {
            System.out.println("Press Enter to send request. Press 'X' to close");
                String userInput = sc.nextLine();
                if (userInput.equalsIgnoreCase("X")) {
                    Runn1.shutdown = true;
                    Thread.sleep(1111);
                    sc.close();
                    System.exit(0);
                }
                else {
                System.out.println("Sending request now");
                Runn1.run = true;
                }
            }
    }
    
}



