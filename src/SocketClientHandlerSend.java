package src;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

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
        while(!runn1.shutdown) {
        try {
            // This will keep waiting until a key is pressed
            while (runn1.run == false) {
                Thread.sleep(1111);
                System.out.println("...");
                if(runn1.shutdown == true) {
                    break;
                }    
            }
            if(runn1.shutdown == true) {
                break;
            }
            // The below code will execute on any key press from user   
            System.out.println("Got a trigger.."); 
            Socket s = new Socket(server, 80);
            runn1.s = s;
            PrintStream out = new PrintStream( s.getOutputStream() );
            System.out.println(out);
  
            out.println("GET / HTTP/1.0");
            out.println();
            runn1.run = false;   
            } 
        catch (InterruptedException e) {
            System.out.println("Sending Thread is closed");
          } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        System.out.println("Gracefully closing sending thread");
    }
   
}
