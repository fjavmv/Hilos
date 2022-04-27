package com.francisco.javier;

public class HiloPrioridad {

    public static void main(String[] args) {

        MiHiloPrioridad t1 = new MiHiloPrioridad("Pablo");
        MiHiloPrioridad t2 = new MiHiloPrioridad("Pedro");
        MiHiloPrioridad t3 = new MiHiloPrioridad("Mario");


        t1.setPriority(10);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);

        System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);
        System.out.println(Thread.MIN_PRIORITY);


        t1.start();
        t2.start();
        t3.start();
    }

    static class MiHiloPrioridad extends Thread
    {
        String nom;
        public MiHiloPrioridad(String nom)
        {
            this.nom = nom;
        }

        @Override
        public void run()
        {
            for(int i=0; i< 5; i++ )
            {
                System.out.println( nom +" - "+ i);
                MiHiloPrioridad.yield();

                /*
                 *  El método yield() simplemente le avisa al scheduler que le puede pasar el control a otro proceso, y el proceso que invoca yield() podríamos decir que se queda en pausa,
                 *  pero no termina su ejecución; eventualmente el control regresará ese proceso y continuará su ejecución.
                 *
                 */

            }
        }
    }
}
