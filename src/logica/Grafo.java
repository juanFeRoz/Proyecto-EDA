/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.LinkedList;

/**
 *
 * @author juanfelipe
 */
public class Grafo {

    public int OrdenDescubrimiento; // Representa el orden en que DFS descubre un vertice
    public int numeroVertices;
    public LinkedList[] listaAdyacencia;

    public Grafo(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.listaAdyacencia = new LinkedList[numeroVertices];

        for (int i = 0; i < numeroVertices; i++) {
            listaAdyacencia[i] = new LinkedList<>();
        }
    }

    public void agregarArista(int u, int v, int peso) {
        // Se crean dos aristas simetricas para que el grafo sea no dirigido
        Arista arista1 = new Arista(u, v, peso);
        Arista arista2 = new Arista(v, u, peso);

        listaAdyacencia[u].add(arista1);
        listaAdyacencia[v].add(arista2);
    }

    public void imprimirGrafo() {
        for (int i = 0; i < numeroVertices; i++) {
            LinkedList<Arista> lista = listaAdyacencia[i];
            for (int j = 0; j < lista.size(); j++) {
                System.out.println("El vertice " + i + " esta conectado con " + lista.get(j).v + " con un peso de "
                        + lista.get(j).peso);
            }
        }
    }
}
