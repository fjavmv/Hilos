package com.francisco.javier;

public class HiloRunnable implements Runnable {

    private String nombre;

    public HiloRunnable(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            int x = (int)(Math.random()*5000);
            Thread.sleep(x);
            System.out.println("Soy: "+nombre+" ("+ x +")");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /*
    * Ahora la clase HoloRunnable no extiende a Thread, pero implementa la interface
    * Runnable de la que sobrescribe el método run. Luego, en el main instanciamos tres
    * thread en cuyos constructores pasamos como argumento instancias de HiloRunnable
    * (es decir: instancias de Runnable).
    *
    * */
    public static void main(String[] args) {
        HiloRunnable hr = new HiloRunnable("Dolores");
        Thread t1 = new Thread(hr);
        Thread t2 = new Thread(new HiloRunnable("Pablo"));
        Thread t3 = new Thread(new HiloRunnable("Juan"));
        t1.start();
        t2.start();
        t3.start();
    }

}
