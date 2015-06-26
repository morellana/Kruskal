/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauricio
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Generador {

    public Nodo[] nodos;
    public float[][] matriz;
    public float densidad;
    
    public Generador() {
    }
    
    /*
    Genera nodos en posiciones aleatorias del plano
    y establece aristas segun densidad
    */
    public void generarGrafo() {
        Random r = new Random();
        // generar nodos con coordenadas aleatorias en el plano
        for (int i = 0; i < this.nodos.length; i++) {
            Nodo s = new Nodo();
            s.x = r.nextFloat();
            s.y = r.nextFloat();
            this.nodos[i] = s;       
        }
        int arcos = (int)(this.densidad * this.nodos.length * (this.nodos.length - 1)/2);
        
        // establecer conexiones entre nodos
        for (int j = 0; j < arcos; j++) {
            int nodo1 = r.nextInt(this.nodos.length);
            int nodo2 = r.nextInt(this.nodos.length);
            if(nodo1==nodo2 || matriz[nodo1][nodo2]!= 0) { // nodos distintos y que no hayan sido conectados previamente
                j--;
            }
            else {
                float peso = calcular(nodos[nodo1],nodos[nodo2]);
                this.matriz[nodo1][nodo2] = peso;
                this.matriz[nodo2][nodo1] = peso;
            }             
        }
        
        // asegurar que el grafo sea convexo
        for (int i = 0; i < this.nodos.length-1; i++) {
                if(this.matriz[i][i+1] == 0) {
                    float peso = calcular(nodos[i],nodos[i+1]);
                    this.matriz[i][i+1] = peso;
                    this.matriz[i+1][i] = peso;
                }            
        }
   
        // for (int i = 0; i < nodos.length; i++) {
        //     for (int j = 0; j < nodos.length; j++) {
        //         System.out.printf("%.2f ", matriz[i][j]);
        //     }
        //     System.out.println("");
        // }
        
    }

    private float calcular(Nodo nodo, Nodo nodo0) {
       double distancia = Math.pow((nodo.x - nodo0.x), 2) + Math.pow((nodo.y - nodo0.y), 2);
       double peso = Math.sqrt(distancia);
       return (float)peso;
    }
    
    /**
     * Convierte la matriz de adyacencia en una lista de aristas
     * Arista: idInicio, idFin, peso
     */
    public ArrayList<Arista> getListaAristas(){
        ArrayList<Arista> listaAristas = new ArrayList<>();
        int fila = 0;
        int columna = 1;
        while (fila < this.nodos.length-1){
            while (columna < this.nodos.length){
                if (matriz[fila][columna] != (float)0){
                    //System.out.println("creada arista con largo " + matriz[fila][columna]);
                listaAristas.add(new Arista(fila, columna, this.matriz[fila][columna]));
                }
                columna++;
            }
            fila += 1;
            columna = fila+1;
            
        }
        return listaAristas;
    }

    ArrayList<Arista> generar(int cantidadNodos, float densidad) {
        this.matriz = new float[cantidadNodos][cantidadNodos];
        this.densidad = densidad;
        this.nodos = new Nodo[cantidadNodos];
        
        this.generarGrafo();
        
        return getListaAristas();
    }
    

 }
