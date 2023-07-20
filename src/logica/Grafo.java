/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author juanfelipe
 */
public class Grafo {

    private final int V;
    private final List<HashMap<Integer, Integer>> listaAdyacencia; // En la lista de adyacencia guardo el par vertice-peso en un hashmap

    public Grafo(int V) {
        this.V = V;
        this.listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            listaAdyacencia.add(new HashMap<>());
        }
    }

    public List<HashMap<Integer, Integer>> getListaAdyacencia() {
        return listaAdyacencia;
    }

    public int getV() {
        return V;
    }

    public void agregarArista(int u, int v, int w) {
        listaAdyacencia.get(u).put(v, w);
        listaAdyacencia.get(v).put(u, w);
    }

}
