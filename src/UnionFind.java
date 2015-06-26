/*
 * Estructura para manejar los subconjuntos de nodos
 */

/**
 *
 * @author mauricio
 */
public class UnionFind {
    
    private int[] representantes;
    private int[] contador;
    
    public UnionFind(int n){ // n: cantidad de nodos
        this.representantes = new int[n];
        this.contador = new int[n];
        for (int i=0; i<n; i++){
            this.representantes[i] = i;  // al inicio cada nodo es representado por si mismo
            this.contador[i] = 1;        // al inicio se representa solo a si mismo
        }
    }
    
    /**
     * Dado un indice, retona el indice del nodo por el cual es representado
     * Recursivo para llegar al nodo que tiene mayor representatividad
     */
    public int find(int id){
        if (this.representantes[id] == id) return id;
        int r = find(this.representantes[id]);
        this.representantes[id] = r;
        return r;
    }
    
    public void union(int id1, int id2){
        int rep1 = find(id1);
        int rep2 = find(id2);
        if (rep1 == rep2)   // los componentes ya están conectados
            return;
        if (this.contador[rep1] >= this.contador[rep2]){  // rep1 representa a mas nodos que rep2
            this.representantes[rep2] = rep1;             // representante de rep2 pasa a ser rep1
            this.contador[rep1] += this.contador[rep2];   // rep1 aumenta a sus representados
        } else {
            this.representantes[rep1] = rep2;
            this.contador[rep2] += this.contador[rep1];
        }
    }

    public void print(){
        System.out.println("representantes");
        for (int i=0; i<representantes.length; i++) {
            System.out.print(representantes[i] + " ");
        }
        System.out.println();
    }
            
}
