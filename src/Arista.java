
import java.util.Collections;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauricio
 */
public class Arista implements Comparable<Arista>{
    
    private int idNodoInicio;
    private int idNodoFin;
    private float peso;

    public Arista(int idNodoInicio, int idNodoFin, float peso) {
        this.idNodoInicio = idNodoInicio;
        this.idNodoFin = idNodoFin;
        this.peso = peso;
    }

    @Override
    public int compareTo(Arista t) {
       if (this.peso > t.getPeso())  return 1;
       if (this.peso < t.getPeso())  return -1;
       return 0;
    }
    
    public float getPeso(){
        return this.peso;
    }

    public int getIdNodoInicio() {
        return idNodoInicio;
    }

    public int getIdNodoFin() {
        return idNodoFin;
    }

    void imprimir() {
        System.out.printf("%d ----- %d  con largo %.5f\n", idNodoInicio, idNodoFin, this.peso);
    }
    
    
            
}
