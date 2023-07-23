/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.eda;

import java.io.IOException;
import java.util.List;
import static logica.GeneradorGrafo.leerArchivoTxt;
import logica.Grafo;
import logica.Puente;
import logica.PuntoArticulacion;

/**
 *
 * @author juanfelipe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // Generar el grafo de topología de anillo a partir del archivo anillo.txt
            Grafo grafoAnillo = leerArchivoTxt("anillo.txt");

            // Encontrar los puentes y puntos de articulacion del grafo tipo anillo
            Puente encontrarPuentesGrafoAnillo = new Puente(grafoAnillo);
            List<Integer> puentesGrafoAnillo = encontrarPuentesGrafoAnillo.encontrarPuentes();

            PuntoArticulacion encontrarPuntosArticulacionGrafoAnillo = new PuntoArticulacion(grafoAnillo);
            boolean[] puntosArticulacionGrafoAnillo = encontrarPuntosArticulacionGrafoAnillo.encontrarPuntosArticulacion();

            System.out.println("Vulnerabilidades Grafo Anillo: ");

            for (int i = 0; i < puentesGrafoAnillo.size() / 2; i++) {
                int u = puentesGrafoAnillo.get(2 * i);
                int v = puentesGrafoAnillo.get(2 * i + 1);
                System.out.printf("Puente entre vertices %d y %d\n", u, v);
            }

            for (int i = 0; i < puntosArticulacionGrafoAnillo.length; i++) {
                if (puntosArticulacionGrafoAnillo[i]) {
                    System.out.printf("El vertice %d es un punto de articulacion\n", i);
                }
            }

            // Generar el grafo de topología de estrella a partir del archivo estrella.txt
            Grafo grafoEstrella = leerArchivoTxt("estrella.txt");

            // Encontrar los puentes y puntos de articulacion del grafo tipo estrella
            Puente encontrarPuentesGrafoEstrella = new Puente(grafoEstrella);
            List<Integer> puentesGrafoEstrella = encontrarPuentesGrafoEstrella.encontrarPuentes();

            PuntoArticulacion encontrarPuntosArticulacionGrafoEstrella = new PuntoArticulacion(grafoEstrella);
            boolean[] puntosArticulacionGrafoEstrella = encontrarPuntosArticulacionGrafoEstrella.encontrarPuntosArticulacion();

            System.out.println("");
            System.out.println("Vulnerabilidades Grafo Estrella: ");

            for (int i = 0; i < puentesGrafoEstrella.size() / 2; i++) {
                int u = puentesGrafoEstrella.get(2 * i);
                int v = puentesGrafoEstrella.get(2 * i + 1);
                System.out.printf("Puente entre vertices %d y %d\n", u, v);
            }

            for (int i = 0; i < puntosArticulacionGrafoEstrella.length; i++) {
                if (puntosArticulacionGrafoEstrella[i]) {
                    System.out.printf("El vertice %d es un punto de articulacion\n", i);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}
