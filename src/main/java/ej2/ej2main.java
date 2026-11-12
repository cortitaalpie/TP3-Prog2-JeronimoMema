package ej2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*¿Qué es un iterador? (iterator). Muestre cómo se usa, haciendo altas, bajas, recorridos y búsquedas en listas implementadas con ArrayList.*/

public class ej2main {

    public static void main(String[] args) {

        ArrayList<Integer> nros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int nro = 1;

        System.out.println("Ingrese nros o 0 para terminar\n");

        while (nro != 0) {
            nro = Integer.valueOf(sc.nextLine());
            nros.add(nro);
        }

        System.out.println("Ingresa un numero a buscar para remover");

        nro = Integer.valueOf(sc.nextLine());

        boolean encontrado = false;
        Iterator<Integer> it = nros.iterator();

        while (it.hasNext() && !encontrado) {

            Integer elemento = it.next();

            if (elemento == nro) {
                System.out.println("elemento encontrado");
                it.remove();
                encontrado = true;
            }
        }
    }

}
