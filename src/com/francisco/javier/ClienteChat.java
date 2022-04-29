package com.francisco.javier;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteChat {
    private Socket socket;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner entradaKey = new Scanner(System.in);
    final String FINALIZAR = "salir()";

    public void establecerConexion(String ip, int puerto) {
        try {
            socket = new Socket(ip, puerto);
            mostrarTexto("Conectado a :" + socket.getInetAddress().getHostName());
        } catch (Exception e) {
            mostrarTexto("Error al establecer conexión: " + e.getMessage());
            System.exit(0);
        }
    }

    public static void mostrarTexto(String s) {
        System.out.println(s);
    }

    public void abrirFlujos() {
        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en los flujos de entrada");
        }
    }

    public void enviar(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("IOException on enviar");
        }
    }

    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socket.close();
            mostrarTexto("Conexión terminada");
        } catch (IOException e) {
            mostrarTexto("IOException al cerrar conexión");
        }finally{
            System.exit(0);
        }
    }

    public void ejecutarConexion(String ip, int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    establecerConexion(ip, puerto);
                    abrirFlujos();
                    recibirDatos();
                } finally {
                    cerrarConexion();
                }
            }
        });
        hilo.start();
    }

    public void recibirDatos() {
        String st;
        try {
            do {
                st = bufferDeEntrada.readUTF();
                mostrarTexto("\nServidor: " + st);
                System.out.print("\nCliente: ");
            } while (!st.equals(FINALIZAR));
        } catch (IOException e) {}
    }

    public void escribirDatos() {
        String entrada;
        while (true) {
            System.out.print("Cliente: ");
            entrada = entradaKey.nextLine();
            if(entrada.length() > 0)
                enviar(entrada);
        }
    }

    public static void main(String[] argumentos) {
        int puerto;
        String ip;
        ClienteChat cliente = new ClienteChat();
        Scanner escanner = new Scanner(System.in);

        mostrarTexto("Ingresa la IP por default [localhost]: ");
        ip = escanner.nextLine();
        if (ip.length() <= 0) ip = "localhost";

        mostrarTexto("Puerto: Ingresa el puerto de conexión por defecto ");
        puerto = escanner.nextInt();
        cliente.ejecutarConexion(ip, puerto);
        cliente.escribirDatos();
    }
}
