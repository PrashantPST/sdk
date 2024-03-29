package core;

import java.util.Hashtable;

class PrintDemo extends Hashtable {
    void printCount() {
        try {
            for(int i = 15; i > 0; i--) {
                System.out.println("Counter   ---   "  + i );
            }
        }
        catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
    }
}

class ThreadDemo extends Thread {

    private Thread t;
    private String threadName;
    private final PrintDemo  PD;

    ThreadDemo(String name,  PrintDemo pd) {
        threadName = name;
        PD = pd;
    }

    public void run() {
        synchronized(PD) {
            PD.printCount();
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class SynchronizationDemo {

    public static void main(String[] args) {

        PrintDemo PD = new PrintDemo();
        ThreadDemo T1 = new ThreadDemo( "Thread - 1 ", PD );
        ThreadDemo T2 = new ThreadDemo( "Thread - 2 ", PD );

        T1.start();
        T2.start();
    }
}