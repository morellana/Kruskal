
import java.util.ArrayList;
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro
 */
public class Heap {
    private ArrayList<Arista> aristas;
    
    public Heap() {
        aristas = new ArrayList<Arista>();
    }
         
    private void siftUp() {
        int k = aristas.size() - 1;
        while (k > 0) {
            int p = (k-1)/2;
            Arista arista = aristas.get(k);
            Arista padre = aristas.get(p);
            if (arista.getPeso() > padre.getPeso()) {
                // swap
                aristas.set(k, padre);
                aristas.set(p, arista);
                 
                // move up one level
                k = p;
            } else {
                break;
            }
        }
    }
     
    public void insert(Arista item) {
        aristas.add(item);
        siftUp();
    }
     
    private void siftDown() {
        int k = 0;
        int l = 2*k+1;
        while (l < aristas.size()) {
            int max=l, r=l+1;
            if (r < aristas.size()) { // there is a right child
                if (aristas.get(r).getPeso() > aristas.get(l).getPeso()) {
                    max++;
                }
            }
            if (aristas.get(k).getPeso() < aristas.get(max).getPeso()) {
                    // switch
                    Arista temp = aristas.get(k);
                    aristas.set(k, aristas.get(max));
                    aristas.set(max, temp);
                    k = max;
                    l = 2*k+1;
            } else {
                break;
            }
        }
    }
     
    public Arista delete() 
    throws NoSuchElementException {
        if (aristas.size() == 0) {
            throw new NoSuchElementException();
        }
        if (aristas.size() == 1) {
            return aristas.remove(0);
        }
        Arista hold = aristas.get(0);
        aristas.set(0, aristas.remove(aristas.size()-1));
        siftDown();
        return hold;
    }
 
    public int size() {
        return aristas.size();
    }
     
    public boolean isEmpty() {
        return aristas.isEmpty();
         
    }
     
    public String toString() {
        return aristas.toString();
    }
}
