package com.francisco.javier;

import jdk.jshell.spi.ExecutionControl;

public class HiloTest extends Thread {

    /**
     * @author F. Javier M. V.
     * @version 0.1
    * */

    private String nombre;

    public HiloTest(String nombre){
        this.nombre = nombre;
    }

    //Sobreescribimos el método run
    @Override
    public void run(){
        try {
            int x = (int)(Math.random()*5000);
            Thread.sleep(x);
            System.out.println("Soy: "+nombre+" ("+ x +")");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        /*Los objetos instanciados se ejecutand de manera concurrente
         * Invocando sobre cada objeto el método start este a su vez invoca
         * al método run
         * La salida obtenida será aleatoria dependiendo del tiempo que duerma
         * cada hilo en milisegundos
         * ¿Qué sucederá si en lugar de invocar al método start invocamos directamente al
         * método run?
         * */
        HiloTest t1 = new HiloTest("Pedro");
        HiloTest t2 = new HiloTest("Pablo");
        HiloTest t3 = new HiloTest("Juan");
        t1.start();
        t2.start();
        t3.start();
        // esperamos por la finalizacion de los tres hilos
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final del programa !");

    }
}
