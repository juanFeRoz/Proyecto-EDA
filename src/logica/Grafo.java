/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanfelipe
 */
public class Grafo {

    private final int V;
    private final List<ArrayList<Integer>> listaAdyacencia;

    public Grafo(int numeroVertices) {
        this.V = numeroVertices;
        this.listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < numeroVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    public List<ArrayList<Integer>> getListaAdyacencia() {
        return listaAdyacencia;
    }

    public int getV() {
        return V;
    }

    public void agregarArista(int u, int v) {
        listaAdyacencia.get(u).add(v);
        listaAdyacencia.get(v).add(u);
    }

}
