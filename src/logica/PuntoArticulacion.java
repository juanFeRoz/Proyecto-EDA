/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Map;

/**
 *
 * @author juanfelipe
 */
public class PuntoArticulacion {

    // Cuando se hace un DFS se va asignando a cada vertice un id
    // segun el orden en que se visitan
    private int id;
    // Sirve para determinar si la raiz en el DFS es un punto de articulacion
    private int numeroAristasIncidentesVerticeRaiz;

    // low es un array que guarda el valor del id mas bajo alcanzable
    // desde ese vertice cuando se hace un DFS
    private int[] low, ids;

    private boolean[] visitado, esPuntoArticulacion;
    private Grafo grafo;

    public PuntoArticulacion(Grafo grafo) {
        // Evalua si el grafo es valido
        if (grafo.getListaAdyacencia() == null || grafo.getNumeroVertices() <= 0 || grafo.getListaAdyacencia().size() != grafo.getNumeroVertices()) {
            throw new IllegalArgumentException();
        }
        this.grafo = grafo;
    }

    public boolean[] encontrarPuntosArticulacion() {
        id = 0;
        low = new int[grafo.getNumeroVertices()];
        ids = new int[grafo.getNumeroVertices()];
        visitado = new boolean[grafo.getNumeroVertices()];
        esPuntoArticulacion = new boolean[grafo.getNumeroVertices()];

        // Encuentra los puentes en el grafo en todos los componentes conectados
        for (int i = 0; i < grafo.getNumeroVertices(); i++) {
            if (!visitado[i]) {
                numeroAristasIncidentesVerticeRaiz = 0;
                dfs(i, i, -1);
                esPuntoArticulacion[i] = (numeroAristasIncidentesVerticeRaiz > 1);
            }
        }

        return esPuntoArticulacion;
    }

    // u representa el vertice actual y v sus vertices vecinos
    private void dfs(int raiz, int u, int padre) {
        if (padre == raiz) {
            numeroAristasIncidentesVerticeRaiz++;
        }

        visitado[u] = true;
        low[u] = ids[u] = id++;

        // Se necesita usar Map.Entry para iterar por el hash map que representa la arista
        for (Map.Entry<Integer, Integer> entry : grafo.getListaAdyacencia().get(u).entrySet()) {
            int v = entry.getKey();

            if (v == padre) {
                continue;
            }

            if (!visitado[v]) {
                dfs(raiz, v, u);
                low[u] = Math.min(low[u], low[v]);
                if (ids[u] <= low[v]) {
                    esPuntoArticulacion[u] = true;
                }
            } else {
                low[u] = Math.min(low[u], ids[v]);
            }
        }
    }
}
