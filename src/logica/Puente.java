/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author juanfelipe
 */
public class Puente {

    // Cuando se hace un DFS se va asignando a cada vertice un id
    // segun el orden en que se visitan
    private int id;
    // low es un array que guarda el valor del id mas bajo alcanzable
    // desde ese vertice cuando se hace un DFS
    private int[] low, ids;
    private boolean[] visitado;
    private Grafo grafo;

    public Puente(Grafo grafo) {
        // Evalua si el grafo es valido
        if (grafo.getListaAdyacencia() == null || grafo.getV() <= 0 || grafo.getListaAdyacencia().size() != grafo.getV()) {
            throw new IllegalArgumentException();
        }
        this.grafo = grafo;
    }

    /*
    Devuelve una lista de pares de vertices que forman un puente.
    La lista siempre sera de longitud para y los indices (2*i, 2*i+1)
    forman un par. Por ejemplo, los vertices los indices (0, 1)
    forman un par que representa un puente.
     */
    public List<Integer> encontrarPuentes() {
        id = 0;
        low = new int[grafo.getV()];
        ids = new int[grafo.getV()];
        visitado = new boolean[grafo.getV()];

        List<Integer> puentes = new ArrayList<>();

        // Encuentra los puentes en el grafo en todos los componentes conectados
        for (int i = 0; i < grafo.getV(); i++) {
            if (!visitado[i]) {
                dfs(i, -1, puentes);
            }
        }

        return puentes;
    }

    // u representa el vertice actual y v sus vertices vecinos
    private void dfs(int u, int padre, List<Integer> puentes) {
        visitado[u] = true;
        low[u] = ids[u] = id++;

        // Se necesita usar Map.Entry para iterar por el hash map que representa la arista
        for (Map.Entry<Integer, Integer> entry : grafo.getListaAdyacencia().get(u).entrySet()) {
            int v = entry.getKey();

            if (v == padre) {
                continue;
            }

            if (!visitado[v]) {
                dfs(v, u, puentes);
                low[u] = Math.min(low[u], low[v]);
                if (ids[u] < low[v]) {
                    puentes.add(u);
                    puentes.add(v);
                }
            } else {
                low[u] = Math.min(low[u], ids[v]);
            }
        }
    }

}
