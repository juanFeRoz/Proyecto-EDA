/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author juanfelipe
 */
public class Grafo {

    private final int V;
    private int gasto;
    private final List<HashMap<Integer, Integer>> listaAdyacencia; // En la lista de adyacencia guardo el par vertice-peso en un hashmap

    public Grafo(int numeroVertices) {
        this.gasto = 0;
        this.V = numeroVertices;
        this.listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < numeroVertices; i++) {
            listaAdyacencia.add(new HashMap<>());
        }
    }

    public List<HashMap<Integer, Integer>> getListaAdyacencia() {
        return listaAdyacencia;
    }

    public int getV() {
        return V;
    }

    public int getGasto() {
        return gasto;
    }

    public void agregarArista(int u, int v, int costo) {

        gasto += costo;
        listaAdyacencia.get(u).put(v, costo);
        listaAdyacencia.get(v).put(u, costo);

    }

    public void imprimirGrafo() {
        for (int u = 0; u < V; u++) {
            System.out.println(u + ": ");
            for (Map.Entry<Integer, Integer> entry : listaAdyacencia.get(u).entrySet()) {
                Integer v = entry.getKey();
                Integer w = entry.getValue();
                System.out.print(v + "-" + w);
            }
        }

    }

}
