package ej4;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*Se desea diseñar un programa que permita manipular una agenda mediante serialización-deserialización. Cada registro de la agenda cuenta con nombre, apellido, teléfono de linea, teléfono móvil, teléfono del trabajo, email y un campo que indique de donde conozco a la persona (trabajo, universidad, boliche…). Deberá contar con un menú para registrar, eliminar, buscar un registro y para mostrar todos.*/

public class ej4main {

    public static void main(String[] args) {

        ArrayList<contacto> agenda = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = "agenda.dat";

        try {
            FileInputStream f = new FileInputStream(nombreArchivo);
            ObjectInputStream ist = new ObjectInputStream(f);

            agenda = (ArrayList<contacto>) ist.readObject();
            ist.close();

            System.out.println("Agenda cargada con exito. Contactos guardados: " + agenda.size());

        } catch (FileNotFoundException e) {
            System.out.println("No hay agenda previa en el disco. Se iniciara una nueva.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar la agenda.");
        }

        int opcion = 0;

        do {
            System.out.println("\n======= MI AGENDA =======");
            System.out.println("1. Registrar contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Mostrar todos los contactos");
            System.out.println("5. Salir y Guardar");
            System.out.print("Elija una opcion: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Telefono movil (numeros): ");
                    int telef = Integer.parseInt(sc.nextLine());
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Telefono de linea (numeros): ");
                    int telfonolinea = Integer.parseInt(sc.nextLine());
                    System.out.print("Telefono del trabajo (numeros): ");
                    int telfonotrabajo = Integer.parseInt(sc.nextLine());
                    System.out.print("Email: ");
                    String mail = sc.nextLine();
                    System.out.print("De donde lo conoce: ");
                    String relacion = sc.nextLine();

                    contacto nuevo = new contacto(nombre, telef, apellido, telfonolinea, telfonotrabajo, mail, relacion);
                    agenda.add(nuevo);
                    System.out.println("¡Contacto registrado exitosamente!");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre exacto del contacto a eliminar: ");
                    String nombreBorrar = sc.nextLine();
                    boolean borrado = false;

                    Iterator<contacto> it = agenda.iterator();
                    while(it.hasNext()) {
                        contacto actual = it.next();
                        if(actual.getNombre().equalsIgnoreCase(nombreBorrar)) {
                            it.remove();
                            borrado = true;
                            System.out.println("Contacto eliminado.");
                        }
                    }
                    if(!borrado) {
                        System.out.println("No se encontro ningun contacto con ese nombre.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    String nombreBuscar = sc.nextLine();
                    boolean encontrado = false;

                    for(contacto c : agenda) {
                        if(c.getNombre().equalsIgnoreCase(nombreBuscar)) {
                            System.out.println("\n-- Contacto Encontrado --");
                            System.out.println("Nombre: " + c.getNombre() + " " + c.getApellido());
                            System.out.println("Movil: " + c.getTelef() + " | Linea: " + c.getTelfonolinea() + " | Trabajo: " + c.getTelfonotrabajo());
                            System.out.println("Email: " + c.getMail() + " | Relacion: " + c.getRelacion());
                            encontrado = true;
                        }
                    }
                    if(!encontrado) {
                        System.out.println("No se encontro el contacto en la agenda.");
                    }
                    break;

                case 4:
                    System.out.println("\n=== LISTA COMPLETA DE CONTACTOS ===");
                    if(agenda.isEmpty()) {
                        System.out.println("La agenda esta vacia.");
                    } else {
                        for(contacto c : agenda) {
                            System.out.println("- " + c.getNombre() + " " + c.getApellido() + " (" + c.getRelacion() + ")");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Guardando datos...");
                    break;

                default:
                    System.out.println("Opcion incorrecta. Por favor ingrese un numero del 1 al 5.");
                    break;
            }

        } while (opcion != 5);

        try {
            FileOutputStream f = new FileOutputStream(nombreArchivo);
            ObjectOutputStream ost = new ObjectOutputStream(f);

            ost.writeObject(agenda);
            ost.flush();
            ost.close();

            System.out.println("La agenda se guardo correctamente. ¡Hasta luego!");

        } catch (IOException e) {
            System.out.println("Ocurrio un error al guardar el archivo: " + e.getMessage());
        }
    }
}