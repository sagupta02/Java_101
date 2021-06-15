package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SocketClientHandlerReceive extends Thread {
    private String path;
    private MyRunnable runn1;

    // Constructor
    public SocketClientHandlerReceive(Socket s, MyRunnable runn1)
    {
        this.runn1 = runn1;    
    }

    public void run() {
        while(true) {
        try {
            if (runn1.s == null) {
                Thread.sleep(1111);
                continue;
            }
            // Connect to the server
            BufferedReader in = new BufferedReader( new InputStreamReader( runn1.s.getInputStream() ) );
            
            
            String line = in.readLine();
            while (line != null) {
              System.out.println( line );
              line = in.readLine();
            }
            Thread.sleep(1111);
            System.out.println("Reading again .......");
            } 
        catch (Exception e) {
            e.printStackTrace();
          }
        }
    }
    
}


/* 

Add functions to close the threads 
If X , close the thread , set shutdown = true and wait for 11 ms 
If anything else , continue to read data
Cleanup the code*/

/* Next week:
- Creating our own server */