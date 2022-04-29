package com.francisco.javier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FilesEjemplo {
    public static void main(String[] args) throws IOException {
        Scanner ficheroScanner = new Scanner(System.in);
        System.out.println("Nombre del fichero que se desea crear");
        String nombre = ficheroScanner.next();
        crearFichero(nombre);
        escribirDatos(nombre);
    }

    public static void crearFichero(String nombreFichero) throws IOException{
        File fichero = new File("C:\\Users\\Latitude\\Desktop\\MATERIALCLASESUNSIJ\\"+nombreFichero+".txt");
        try{

            if(fichero.exists()) {
                if (fichero.createNewFile()) {
                    System.out.println("Se ha creado el fichero" + nombreFichero);
                } else {
                    System.out.println("No fue posible crear el fichero" + nombreFichero);
                }
            }
            else
            {
                System.out.println("El fichero ya existe");
            }
            }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void escribirDatos(String nombreFichero) throws IOException {

    }

    public static void leerDatos(){

    }
}
