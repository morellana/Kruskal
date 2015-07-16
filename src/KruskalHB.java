
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro
 */
public class KruskalHB {
    private ArrayList<Arista> aristas;
    private int cantidadNodos;
    private Heap heap;
    
    KruskalHB(ArrayList<Arista> aristas, int cantidadNodos){
        this.aristas = aristas;
        this.heap = new Heap();
        this.cantidadNodos = cantidadNodos;
    }
    
    public ArrayList<Arista> arbolCobertorMinimo(){
        UnionFind C = new UnionFind(this.cantidadNodos);
        ArrayList<Arista> mst = new ArrayList<>();
        //Collections.sort(aristas); // aristas ordenadas ascendentemente
        for(int i=0;i<aristas.size();i++)
        {
            heap.insert(aristas.get(i));
        }
        
        while (mst.size() < cantidadNodos-1){
            Arista a = heap.delete();
            if (C.find(a.getIdNodoInicio()) != C.find(a.getIdNodoFin())){
                mst.add(a);
                C.union(a.getIdNodoInicio(), a.getIdNodoFin());
            }
        }
        return mst;
    }
    
    public static float sumarAristas(ArrayList<Arista> cobertor) {
        float pesoTotal = (float)0;
        for (Arista arista : cobertor){
            pesoTotal += arista.getPeso();
        }
        return pesoTotal;
    }
    
    
    
}
