package src;

import java.io.PrintStream;
import java.net.Socket;

public class SocketClientHandlerSend extends Thread {
    private String path;
    private MyRunnable runn1;
    private String server;

    // Constructor
    public SocketClientHandlerSend(String server, MyRunnable runn1)
    {
        this.runn1 = runn1;
        this.server = server;
    }

    public void run() {
        while(true) {
        try {
            // Connect to the server
            while (runn1.run == false) {
                Thread.sleep(1111);
                System.out.println("Waiting for instructions!!!");
                
            }   
            System.out.println("Got a trigger.."); 
            Socket s = new Socket(server, 80);
            runn1.s = s;
            PrintStream out = new PrintStream( s.getOutputStream() );
            System.out.println(out);
  
            out.println("GET / HTTP/1.0");
            out.println();
            runn1.run = false;   
            } 
        catch (Exception e) {
            e.printStackTrace();
          }
        }
    }
    
}
