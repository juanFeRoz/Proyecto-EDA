/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author juanfelipe
 */
public class Arista {

    // Una arista une dos vertices u y v
    public int u;
    public int v;

    // Cada arista tiene un peso asociado
    public int peso;

    public Arista(int u, int v, int peso) {
        this.u = u;
        this.v = v;
        this.peso = peso;
    }

}
