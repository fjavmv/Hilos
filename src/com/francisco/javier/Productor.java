package com.francisco.javier;

/**
 * En este ejemplo tenemos dos hilos: uno (el productor) produce caracteres y
 * los mete en un array. El otro (el consumidor)
 * toma caracteres del array (del mismo array que utiliza el productor) y los
 * muestra por pantalla.
 */

public class Productor extends Thread{

    private Monitor monitor;
    private int n;
    private int sleep;

    //Constructor
    public Productor(Monitor b, int n, int s) {
        // el monitor
        this.monitor = b;
        // cuantos caracteres debe producir
        this.n = n;
        // cuanto tiempo dormir entre caracter y caracter
        this.sleep = s;
    }

    @Override
    public void run()
    {
        try
        {
            char c;
            for(int i=0; i<n; i++) {
                c = (char) ('A' + i);
                monitor.poner(c);
                System.out.println("Produje: " + c);
                sleep((int) (Math.random() * sleep));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
