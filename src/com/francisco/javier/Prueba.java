package com.francisco.javier;

public class Prueba {
    public static void main(String[] args) {
        /**
         * Instanciamos un monitor que controlará el acceso a
         * un array con una capacidad de 3 caracteres.
         */
        Monitor m = new Monitor(3);
        Productor p = new Productor(m,6,2000);
        Consumidor c = new Consumidor(m,6,4000);

        p.start();
        c.start();

    }
}
