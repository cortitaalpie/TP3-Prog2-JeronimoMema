package ej3;

import java.io.*;
import java.util.Scanner;

/*Escribir un programa que ingrese un string y la ruta correspondiente a un archivo de texto y emita un mensaje indicando si dicho string está o no en el archivo. Por ejemplo en el archivo se encuentra el texto “Hoy es viernes y esta soleado”, el usuario ingresa el texto “viernes” y la respuesta del programa debe ser que se encuentra el texto en el archivo.

 */

public class ej3main {

    public static void main(String[] args){

        String ruta;
        String palabra;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa la ruta del archivo a buscar:");
        ruta = sc.nextLine();
        System.out.println("ingrese la string a buscar");
        palabra = sc.nextLine();

        File arch = new File(ruta);

        FileReader read = null;
        BufferedReader buff = null;

        try{

            read = new FileReader(arch);
            buff = new BufferedReader(read);

            boolean encontrado = false;
            String linea = "";

            while (linea != null && !encontrado) {
                linea = buff.readLine();

                if (linea != null && linea.contains(palabra)){
                    encontrado = true;
                    System.out.println("La string se encuntra en el archivo");
                }
            }

        }catch (FileNotFoundException e){

            System.out.println(e.getMessage());

        }catch (IOException e){

            System.out.println(e.getMessage());

        }finally {
            try {
                if (buff != null) buff.close();
                if (read != null) read.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el archivo");
            }
        }
    }
}
