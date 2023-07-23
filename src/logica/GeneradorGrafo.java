/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author juanfelipe
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GeneradorGrafo {

    public static Grafo leerArchivoTxt(String rutaArchivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

        String linea = br.readLine();
        String[] lineaDividida = linea.split(";");
        int numVertices = Integer.parseInt(lineaDividida[0]);

        Grafo grafo = new Grafo(numVertices);

        for (int i = 1; i < lineaDividida.length; i++) {
            String[] vertices = lineaDividida[i].split("-");
            int u = Integer.parseInt(vertices[0]);
            int v = Integer.parseInt(vertices[1]);
            int w = 854939; // Peso de conexión entre nodos (valor fijo según la descripción), esta en pesos colombianos

            grafo.agregarArista(u, v, w);
        }

        br.close();
        return grafo;
    }

}
