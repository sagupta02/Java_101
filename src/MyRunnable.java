package src;

import java.net.Socket;

public class MyRunnable implements Runnable {
    boolean run = false;
    Socket s = null;
    boolean shutdown = false;
    public MyRunnable() {
        run = false;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
}

