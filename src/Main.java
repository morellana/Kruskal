
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauricio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Generador generador = new Generador();
        int nodos = 1000;
        float densidad = (float) 0.5;
        
        ArrayList<Arista> aristas = generador.generar(nodos, densidad);  // 1000 nodos con densidad 0.5 de aristas
        
        Kruskal kruskal = new Kruskal(aristas, nodos);
        
        long inicio = System.currentTimeMillis();
        ArrayList<Arista> cobertor = kruskal.arbolCobertorMinimo();
        long fin = System.currentTimeMillis();
        
        float sumaAristas = kruskal.sumarAristas(cobertor);
        
        System.out.println("tiempo: " + (fin-inicio) + " ms.");
        System.out.println("peso arbol cobertor: " + sumaAristas);
        
        
    }
    
}
