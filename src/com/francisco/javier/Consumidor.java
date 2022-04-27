package com.francisco.javier;

import static java.lang.Thread.sleep;

public class Consumidor extends Thread {
    private Monitor monitor;
    private int n;
    private int sleep;

    public Consumidor(Monitor b, int n, int s)
    {
        this.monitor = b;
        this.n = n;
        this.sleep = s;
    }

    @Override
    public void run()
    {
        try
        {
            char c;
            for(int i=0; i<n; i++)
            {
                c = monitor.sacar();
                System.out.println("Consumi: " + c);
                sleep((int)(Math.random() * sleep));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
