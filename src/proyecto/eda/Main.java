/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.eda;

import java.util.HashMap;
import java.util.Map;
import logica.Grafo;
import logica.Puente;

/**
 *
 * @author juanfelipe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Grafo grafo = new Grafo(9);

        grafo.agregarArista(0, 1, 3);
        grafo.agregarArista(0, 2, 2);
        grafo.agregarArista(1, 2, 5);
        grafo.agregarArista(2, 3, 8);
        grafo.agregarArista(3, 4, 1);
        grafo.agregarArista(2, 5, 4);
        grafo.agregarArista(5, 6, 1);
        grafo.agregarArista(6, 7, 2);
        grafo.agregarArista(7, 8, 5);
        grafo.agregarArista(8, 5, 3);

        Puente puente = new Puente(grafo);
        HashMap<Integer, Integer> puentes = puente.encontrarPuentes();

        for (Map.Entry<Integer, Integer> entry : puentes.entrySet()) {
            int u = entry.getKey();
            int v = entry.getValue();

            System.out.printf("Puente entre los vertices %d y %d\n", u, v);
        }

    }

}
