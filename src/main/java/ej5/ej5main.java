package ej5;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*Se desea diseñar un programa para registrar y persistir en archivos la información de las reservas de una empresa dedicada al alquiler de automóviles, teniendo en cuenta que:

De cada cliente se desean almacenar su DNI, nombre y apellido, dirección y teléfono. Además dos clientes se diferencian por un código único.

Un determinado cliente puede tener en un momento dado hechas varias reservas.

Una reserva la realiza un único cliente pero puede involucrar varios autos.

Es importante registrar la fecha de inicio y final de la reserva, el precio del alquiler de cada uno de los autos, el precio total de la reserva y un indicador de si el auto o los autos han sido entregados.

De cada auto se requiere la matricula, la marca, el modelo, el color y las plazas (cantidad de personas que puede transportar).*/

public class ej5main {

    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Auto> autos = new ArrayList<>();
        ArrayList<Reserva> reservas = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String archClientes = "clientes.dat";
        String archAutos = "autos.dat";
        String archReservas = "reservas.dat";

        try {
            FileInputStream f = new FileInputStream(archClientes);
            ObjectInputStream ist = new ObjectInputStream(f);
            clientes = (ArrayList<Cliente>) ist.readObject();
            ist.close();
        } catch (FileNotFoundException e) {
            System.out.println("No hay clientes guardados. Se inicia una lista nueva.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los clientes.");
        }

        try {
            FileInputStream f = new FileInputStream(archAutos);
            ObjectInputStream ist = new ObjectInputStream(f);
            autos = (ArrayList<Auto>) ist.readObject();
            ist.close();
        } catch (FileNotFoundException e) {
            System.out.println("No hay autos guardados. Se inicia una lista nueva.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los autos.");
        }

        try {
            FileInputStream f = new FileInputStream(archReservas);
            ObjectInputStream ist = new ObjectInputStream(f);
            reservas = (ArrayList<Reserva>) ist.readObject();
            ist.close();
        } catch (FileNotFoundException e) {
            System.out.println("No hay reservas guardadas. Se inicia una lista nueva.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las reservas.");
        }

        int opcion = 0;
        int ultimoCodigo = clientes.size();

        do {
            System.out.println("\n======= ALQUILER DE AUTOS =======");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar auto");
            System.out.println("3. Realizar reserva");
            System.out.println("4. Marcar reserva como entregada");
            System.out.println("5. Mostrar clientes");
            System.out.println("6. Mostrar autos");
            System.out.println("7. Mostrar reservas");
            System.out.println("8. Salir y guardar");
            System.out.print("Elija una opcion: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    ultimoCodigo++;
                    System.out.print("DNI: ");
                    int dni = Integer.parseInt(sc.nextLine());
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Direccion: ");
                    String direccion = sc.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = sc.nextLine();

                    Cliente nuevoCliente = new Cliente(ultimoCodigo, dni, nombre, apellido, direccion, telefono);
                    clientes.add(nuevoCliente);
                    System.out.println("Cliente registrado con codigo " + ultimoCodigo);
                    break;

                case 2:
                    System.out.print("Matricula: ");
                    String matricula = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Color: ");
                    String color = sc.nextLine();
                    System.out.print("Plazas: ");
                    int plazas = Integer.parseInt(sc.nextLine());

                    autos.add(new Auto(matricula, marca, modelo, color, plazas));
                    System.out.println("Auto registrado.");
                    break;

                case 3:
                    System.out.print("Ingrese el codigo del cliente: ");
                    int codigoBuscado = Integer.parseInt(sc.nextLine());
                    Cliente clienteEncontrado = null;

                    for (Cliente c : clientes) {
                        if (c.getCodigo() == codigoBuscado) {
                            clienteEncontrado = c;
                        }
                    }

                    if (clienteEncontrado == null) {
                        System.out.println("No existe un cliente con ese codigo.");
                        break;
                    }

                    System.out.print("Fecha de inicio: ");
                    String fechaInicio = sc.nextLine();
                    System.out.print("Fecha de fin: ");
                    String fechaFin = sc.nextLine();

                    Reserva nuevaReserva = new Reserva(clienteEncontrado, fechaInicio, fechaFin);

                    boolean seguirAgregando = true;
                    while (seguirAgregando) {
                        System.out.print("Ingrese la matricula del auto a reservar: ");
                        String matriculaAuto = sc.nextLine();
                        Auto autoEncontrado = null;

                        for (Auto a : autos) {
                            if (a.getMatricula().equalsIgnoreCase(matriculaAuto)) {
                                autoEncontrado = a;
                            }
                        }

                        if (autoEncontrado == null) {
                            System.out.println("No existe un auto con esa matricula.");
                        } else {
                            System.out.print("Precio del alquiler para este auto: ");
                            double precio = Double.parseDouble(sc.nextLine());
                            nuevaReserva.agregarAuto(autoEncontrado, precio);
                        }

                        System.out.print("¿Desea agregar otro auto a la reserva? (s/n): ");
                        seguirAgregando = sc.nextLine().equalsIgnoreCase("s");
                    }

                    reservas.add(nuevaReserva);
                    System.out.println("Reserva registrada. Precio total: " + nuevaReserva.getPrecioTotal());
                    break;

                case 4:
                    System.out.print("Ingrese el codigo del cliente de la reserva a entregar: ");
                    int codigoEntrega = Integer.parseInt(sc.nextLine());
                    boolean entregada = false;

                    for (Reserva r : reservas) {
                        if (r.getCliente().getCodigo() == codigoEntrega && !r.isEntregado()) {
                            r.setEntregado(true);
                            entregada = true;
                            System.out.println("Reserva marcada como entregada.");
                        }
                    }
                    if (!entregada) {
                        System.out.println("No se encontro una reserva pendiente para ese cliente.");
                    }
                    break;

                case 5:
                    System.out.println("\n=== LISTA DE CLIENTES ===");
                    for (Cliente c : clientes) {
                        System.out.println(c.getCodigo() + " - " + c.getNombre() + " " + c.getApellido() + " | DNI: " + c.getDni() + " | Tel: " + c.getTelefono());
                    }
                    break;

                case 6:
                    System.out.println("\n=== LISTA DE AUTOS ===");
                    for (Auto a : autos) {
                        System.out.println(a.getMatricula() + " - " + a.getMarca() + " " + a.getModelo() + " | Color: " + a.getColor() + " | Plazas: " + a.getPlazas());
                    }
                    break;

                case 7:
                    System.out.println("\n=== LISTA DE RESERVAS ===");
                    for (Reserva r : reservas) {
                        System.out.println("Cliente: " + r.getCliente().getNombre() + " " + r.getCliente().getApellido());
                        System.out.println("Desde: " + r.getFechaInicio() + " Hasta: " + r.getFechaFin());
                        for (Auto a : r.getAutos()) {
                            System.out.println("  Auto: " + a.getMatricula() + " " + a.getMarca());
                        }
                        System.out.println("Precio total: " + r.getPrecioTotal() + " | Entregado: " + r.isEntregado());
                        System.out.println("-----------------------------");
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
            FileOutputStream f1 = new FileOutputStream(archClientes);
            ObjectOutputStream ost1 = new ObjectOutputStream(f1);
            ost1.writeObject(clientes);
            ost1.close();

            FileOutputStream f2 = new FileOutputStream(archAutos);
            ObjectOutputStream ost2 = new ObjectOutputStream(f2);
            ost2.writeObject(autos);
            ost2.close();

            FileOutputStream f3 = new FileOutputStream(archReservas);
            ObjectOutputStream ost3 = new ObjectOutputStream(f3);
            ost3.writeObject(reservas);
            ost3.close();

            System.out.println("Los datos se guardaron correctamente. ¡Hasta luego!");

        } catch (IOException e) {
            System.out.println("Ocurrio un error al guardar los archivos: " + e.getMessage());
        }
    }
}
