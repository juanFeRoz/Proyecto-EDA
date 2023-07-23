/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.eda;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import logica.Grafo;
import logica.Puente;
import logica.PuntoArticulacion;
import presentacion.Ventana;

/**
 *
 * @author juanfelipe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Grafo grafo = new Grafo(9, 100);
        Ventana ventana = new Ventana();
        DefaultListModel<String> elementosListaPuentes = new DefaultListModel<>();
        JList<String> listaOutputPuentes = new JList<>(elementosListaPuentes);
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
        List<Integer> puentes = puente.encontrarPuentes();

        PuntoArticulacion puntoArticulacion = new PuntoArticulacion(grafo);
        boolean[] puntosArticulacion = puntoArticulacion.encontrarPuntosArticulacion();

        for (int i = 0; i < puentes.size() / 2; i++) {
            int u = puentes.get(2 * i);
            int v = puentes.get(2 * i + 1);
            String output = String.format("Puente entre vertices %d y %d\n", u, v);
            elementosListaPuentes.addElement(output);
        }

        for (int i = 0; i < puntosArticulacion.length; i++) {
            if (puntosArticulacion[i]) {
                String output = String.format("El vertice %d es un punto de articulacion\n", i);
                elementosListaPuentes.addElement(output);
            }
        }

        ventana.add(listaOutputPuentes);

    }

}
