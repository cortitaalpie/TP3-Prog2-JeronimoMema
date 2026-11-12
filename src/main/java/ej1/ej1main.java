package ej1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

/*Usando ArayList escriba un programa que permita hacer altas, bajas, búsqueda y recorridos

en una lista de enteros

en una lista de objetos Alumno (cree la clase)*/

public class ej1main {

    public static void main(String[] args) {

        ArrayList<Integer> ints = new ArrayList<>();
        ArrayList<Alumno> alumnos = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int nro = 1;

        String nombre;
        double nota = 0.0;

        System.out.println("Ingrese numeros o 0 para terminar");

        while (nro != 0) {

            nro = Integer.valueOf(sc.nextLine());
            ints.add(nro);
        }

        System.out.println("==ARRAY DE INTS==\n");

        for (Integer numero : ints) {
            System.out.print(numero + " ");
        }

        System.out.println("\ningrese nombre y notas de 4 alumnos, se eliminaran los que tangan 0 de nota");

        for (int i = 0; i < 4; i++) {
            nombre = sc.nextLine();
            nota = Double.valueOf(sc.nextLine());

            alumnos.add(new Alumno(nombre, nota));
        }

        System.out.println("\nEliminando alumnos con nota 0...");
        Iterator<Alumno> it = alumnos.iterator();
        while (it.hasNext()) {
            Alumno elemento = it.next();
            if (elemento.getNota() == 0) {
                it.remove();
            }
        }

        System.out.println("==ARRAY DE ALUMNOS==\n");

        for (Alumno elemen : alumnos) {

            System.out.println("==============\n");
            System.out.print("NOMBRE: " + elemen.getNombre() + "\n");
            System.out.println("NOTA: " + elemen.getNota() + "\n");
            System.out.println("==============\n");
        }

        System.out.println("== BÚSQUEDA DE ALUMNO ==");
        System.out.println("Ingrese el nombre del alumno a buscar:");
        String nombreBuscado = sc.nextLine();
        boolean encontrado = false;

        for (Alumno elemen : alumnos) {
            if (elemen.getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("¡Alumno encontrado! Nota: " + elemen.getNota());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El alumno no está en la lista.");
        }
    }
}
