package com.francisco.javier;

public class Monitor {
    private char[] contenedor = null;
    private int tope = 0;
    private boolean lleno = false;
    private boolean vacio = true;

    public Monitor(int capacidad)
    {
        contenedor = new char[capacidad];
    }

    public synchronized void poner(char c) throws Exception
    {
    // mientras el contenedor este lleno me bloqueo para darle la
    // posibilidad al consumidor de consumir algun caracter
        while( lleno )
        {
            wait();
        }
        // seccion critica
        contenedor[++tope] = c;
        vacio = false;
        lleno = tope>=contenedor.length;
        notifyAll();
    }
    public synchronized char sacar() throws Exception {
        // mientras el contenedor este vacio me bloqueo para darle la
        // posibilidad al productor de producir algun caracter
        while (vacio) {
            wait();
        }
        // seccion critica
        char c = contenedor[--tope];
        lleno = false;
        vacio = tope <= 0;
        notifyAll();
        return c;
    }
}
