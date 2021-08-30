package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClientHandlerReceive extends Thread {
    private MyRunnable runn1;
    // Constructor
    public SocketClientHandlerReceive(Socket s, MyRunnable runn1)
    {
        this.runn1 = runn1;    
    }

    public void run() {
        while(!runn1.shutdown) {
        try {
            if (runn1.s == null) {
                Thread.sleep(1111);
                continue;
            }
            // Connect to the server
            BufferedReader in = new BufferedReader( new InputStreamReader( runn1.s.getInputStream() ) );
            
            // Read input of webaddress
            String line = in.readLine();
            while (line != null) {
              System.out.println( line );
              line = in.readLine();
            }
            } 
        catch (InterruptedException e) {
            System.out.println("Receiving thread is closed");
          } catch (IOException e) {
            e.printStackTrace();
        }
        }
        System.out.println("Gracefully closing receiving thread");
    }
    }

