package com.francisco.javier;

public class HiloCedeCPU {

    /**
     * En el siguiente programa, definimos una inner class (CLASE INTERNA) que extiende a Thread en cuyo
     * método run ejecutamos un for que itera 5 veces. Por cada iteración mostramos el nú-
     * mero de iteración y el nombre (que se recibe como parámetro del constructor) y cedemos
     * (con el método yield) el procesador al próximo thread que espera en la cola de listos.
     * Luego, en el método main, instanciamos y ejecutamos dos instancias de MiHilo.
     * */

    public static void main(String[] args) {
        MiHilo t1 = new MiHilo("Pablo");
        MiHilo t2 = new MiHilo("Pedro");
        MiHilo t3 = new MiHilo("Mario");
        t1.start();
        t2.start();
        t3.start();
    }

    static class MiHilo extends Thread
    {
        String nom;
        public MiHilo(String nom)
        {
            this.nom = nom;
        }

        @Override
        public void run()
        {
            for(int i=0; i< 5; i++ )
            {
                System.out.println( nom +" - "+ i);
                MiHilo.yield();

                /*
                 *  El método yield() simplemente le avisa al scheduler que le puede pasar el
                 * control a otro proceso,
                 * y el proceso que invoca yield() podríamos decir que se queda en pausa,
                 *  pero no termina su ejecución; eventualmente el control regresará ese
                 * proceso y continuará su ejecución.
                 *
                 */

            }
        }
    }
}
