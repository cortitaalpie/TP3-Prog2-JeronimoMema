package ej6;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*Se desea diseñar un programa que registre, y persista en archivos, libros (técnicos y novelas) para una librería y permita buscarlos, venderlos y verificar su stock.

Las novelas se clasifican como de ciencia ficción, romance, misterio, juveniles y policiales. Los libros técnicos se clasifican como de ingeniería, ciencias naturales o ciencias sociales.

Cada libro tiene un título, uno o más autores, una editorial, un año de edición y formato (tapas duras o edición económica). Los libros tienen además un código ISBN y capítulos, los que tratan una o más materias (en los técnicos) o es una simple división (en las novelas).

La librería obtiene los libros por medio de proveedores que representan a una o más editoriales. De cada libro se tiene un stock (que puede ser cero). Al venderse un libro, el stock se actualiza. Si un cliente requiere un libro cuyo stock es cero, se puede realizar un encargo por parte del cliente. Esto significa que se pide el libro a un proveedor de la editorial del libro.*/

public class ej6main {

    public static void main(String[] args) {

        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Proveedor> proveedores = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String archLibros = "libros.dat";
        String archProveedores = "proveedores.dat";

        try {
            FileInputStream f = new FileInputStream(archLibros);
            ObjectInputStream ist = new ObjectInputStream(f);
            libros = (ArrayList<Libro>) ist.readObject();
            ist.close();
        } catch (FileNotFoundException e) {
            System.out.println("No hay libros guardados. Se inicia una lista nueva.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los libros.");
        }

        try {
            FileInputStream f = new FileInputStream(archProveedores);
            ObjectInputStream ist = new ObjectInputStream(f);
            proveedores = (ArrayList<Proveedor>) ist.readObject();
            ist.close();
        } catch (FileNotFoundException e) {
            System.out.println("No hay proveedores guardados. Se inicia una lista nueva.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los proveedores.");
        }

        int opcion = 0;

        do {
            System.out.println("\n======= LIBRERIA =======");
            System.out.println("1. Registrar novela");
            System.out.println("2. Registrar libro tecnico");
            System.out.println("3. Registrar proveedor");
            System.out.println("4. Buscar libro");
            System.out.println("5. Vender libro");
            System.out.println("6. Verificar stock");
            System.out.println("7. Mostrar todos los libros");
            System.out.println("8. Salir y guardar");
            System.out.print("Elija una opcion: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                case 2:
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    ArrayList<String> autores = new ArrayList<>();
                    boolean seguirAutor = true;
                    while (seguirAutor) {
                        System.out.print("Ingrese un autor: ");
                        autores.add(sc.nextLine());
                        System.out.print("¿Desea agregar otro autor? (s/n): ");
                        seguirAutor = sc.nextLine().equalsIgnoreCase("s");
                    }

                    System.out.print("Editorial: ");
                    String editorial = sc.nextLine();
                    System.out.print("Año de edicion: ");
                    int anio = Integer.parseInt(sc.nextLine());
                    System.out.print("Formato (tapa dura / economica): ");
                    String formato = sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Stock inicial: ");
                    int stock = Integer.parseInt(sc.nextLine());

                    Libro nuevoLibro;
                    if (opcion == 1) {
                        System.out.print("Clasificacion (ciencia ficcion / romance / misterio / juveniles / policiales): ");
                        String clasificacion = sc.nextLine();
                        nuevoLibro = new Novela(titulo, autores, editorial, anio, formato, isbn, stock, clasificacion);
                    } else {
                        System.out.print("Area (ingenieria / ciencias naturales / ciencias sociales): ");
                        String area = sc.nextLine();
                        nuevoLibro = new Tecnico(titulo, autores, editorial, anio, formato, isbn, stock, area);
                    }

                    boolean seguirCapitulo = true;
                    while (seguirCapitulo) {
                        System.out.print("Ingrese un capitulo: ");
                        nuevoLibro.agregarCapitulo(sc.nextLine());
                        System.out.print("¿Desea agregar otro capitulo? (s/n): ");
                        seguirCapitulo = sc.nextLine().equalsIgnoreCase("s");
                    }

                    libros.add(nuevoLibro);
                    System.out.println("Libro registrado con exito.");
                    break;

                case 3:
                    System.out.print("Nombre del proveedor: ");
                    String nombreProv = sc.nextLine();

                    ArrayList<String> editoriales = new ArrayList<>();
                    boolean seguirEditorial = true;
                    while (seguirEditorial) {
                        System.out.print("Ingrese una editorial que representa: ");
                        editoriales.add(sc.nextLine());
                        System.out.print("¿Desea agregar otra editorial? (s/n): ");
                        seguirEditorial = sc.nextLine().equalsIgnoreCase("s");
                    }

                    proveedores.add(new Proveedor(nombreProv, editoriales));
                    System.out.println("Proveedor registrado.");
                    break;

                case 4:
                    System.out.print("Ingrese el titulo o ISBN a buscar: ");
                    String buscado = sc.nextLine();
                    boolean encontrado = false;

                    for (Libro l : libros) {
                        if (l.getTitulo().equalsIgnoreCase(buscado) || l.getIsbn().equalsIgnoreCase(buscado)) {
                            System.out.println("\n-- Libro encontrado --");
                            System.out.println("Titulo: " + l.getTitulo() + " | ISBN: " + l.getIsbn());
                            System.out.println("Editorial: " + l.getEditorial() + " | Año: " + l.getAnioEdicion() + " | Formato: " + l.getFormato());
                            System.out.println("Clasificacion: " + l.getClasificacion() + " | Stock: " + l.getStock());
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontro el libro.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el ISBN del libro a vender: ");
                    String isbnVender = sc.nextLine();
                    boolean vendido = false;

                    for (Libro l : libros) {
                        if (l.getIsbn().equalsIgnoreCase(isbnVender)) {
                            vendido = true;
                            if (l.vender()) {
                                System.out.println("Venta realizada. Stock restante: " + l.getStock());
                            } else {
                                System.out.println("Sin stock. Se realiza un encargo a un proveedor de la editorial " + l.getEditorial());
                                boolean hayProveedor = false;
                                for (Proveedor p : proveedores) {
                                    if (p.representaEditorial(l.getEditorial())) {
                                        System.out.println("Encargo realizado al proveedor: " + p.getNombre());
                                        hayProveedor = true;
                                    }
                                }
                                if (!hayProveedor) {
                                    System.out.println("No hay un proveedor registrado para esa editorial.");
                                }
                            }
                        }
                    }
                    if (!vendido) {
                        System.out.println("No se encontro un libro con ese ISBN.");
                    }
                    break;

                case 6:
                    System.out.print("Ingrese el ISBN del libro a verificar: ");
                    String isbnStock = sc.nextLine();
                    boolean hallado = false;

                    for (Libro l : libros) {
                        if (l.getIsbn().equalsIgnoreCase(isbnStock)) {
                            System.out.println("Stock disponible: " + l.getStock());
                            hallado = true;
                        }
                    }
                    if (!hallado) {
                        System.out.println("No se encontro un libro con ese ISBN.");
                    }
                    break;

                case 7:
                    System.out.println("\n=== LISTA DE LIBROS ===");
                    for (Libro l : libros) {
                        System.out.println(l.getTitulo() + " (" + l.getClasificacion() + ") - Stock: " + l.getStock());
                    }
                    break;

                case 8:
                    System.out.println("Guardando datos...");
                    break;

                default:
                    System.out.println("Opcion incorrecta. Por favor ingrese un numero del 1 al 8.");
                    break;
            }

        } while (opcion != 8);

        try {
            FileOutputStream f1 = new FileOutputStream(archLibros);
            ObjectOutputStream ost1 = new ObjectOutputStream(f1);
            ost1.writeObject(libros);
            ost1.close();

            FileOutputStream f2 = new FileOutputStream(archProveedores);
            ObjectOutputStream ost2 = new ObjectOutputStream(f2);
            ost2.writeObject(proveedores);
            ost2.close();

            System.out.println("Los datos se guardaron correctamente. ¡Hasta luego!");

        } catch (IOException e) {
            System.out.println("Ocurrio un error al guardar los archivos: " + e.getMessage());
        }
    }
}
