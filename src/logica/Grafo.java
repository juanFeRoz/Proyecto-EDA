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

    private final int numeroVertices;
    private int gasto;
    private final int presupuesto;
    private final List<HashMap<Integer, Integer>> listaAdyacencia; // En la lista de adyacencia guardo el par vertice-peso en un hashmap

    public Grafo(int numeroVertices, int presupuesto) {
        this.gasto = 0;
        this.numeroVertices = numeroVertices;
        this.presupuesto = presupuesto;
        this.listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < numeroVertices; i++) {
            listaAdyacencia.add(new HashMap<>());
        }
    }

    public List<HashMap<Integer, Integer>> getListaAdyacencia() {
        return listaAdyacencia;
    }

    public int getNumeroVertices() {
        return numeroVertices;
    }

    public void agregarArista(int u, int v, int costo) throws Exception {
        gasto += costo;

        if (gasto >= presupuesto) {
            throw new Exception("Se ha excedido el presupuesto");
        } else {
            listaAdyacencia.get(u).put(v, costo);
            listaAdyacencia.get(v).put(u, costo);
        }

    }

}
