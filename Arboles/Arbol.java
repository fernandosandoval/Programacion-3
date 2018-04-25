//package TP2;

public class Arbol {

	private class nodoArbol {
        private Arbol hd;
        private Arbol hi;
        private int dato;
 
        private void nodoArbol(){
            hd = null;
            hi = null;
            dato = 0;
        }
    }
 
    public nodoArbol raiz;
 
    public Arbol(){
        nodoArbol raiz = new nodoArbol();
    }
 
    public boolean isEmpty(){
        return (raiz == null);
    }
 
    public void insert(int a){
        if (isEmpty()) {
            nodoArbol nuevo = new nodoArbol();
            nuevo.dato = a;
            nuevo.hd = new Arbol();
            nuevo.hi = new Arbol();
            raiz = nuevo;
        }
        else {
            if (a > raiz.dato) {
                (raiz.hd).insert(a);
            }
            if (a < raiz.dato){
                (raiz.hi).insert(a);
            }
        }
    }
 
    public void preOrder(){
        if (!isEmpty()) {
            System.out.print( raiz.dato + ", "  );
            raiz.hi.preOrder();
            raiz.hd.preOrder();
        }
    }
 
    public void inOrder(){
        if (!isEmpty()) {
            raiz.hi.inOrder();
            System.out.print( raiz.dato + ", "  );
            raiz.hd.inOrder();
        }
    }
 
    public void posOrder(){
        if (!isEmpty()) {
            raiz.hd.posOrder();
            raiz.hi.posOrder();
            System.out.print( raiz.dato + ", "  );
 
        }
    }
 
    public Arbol find(int a){
    	Arbol aux = null;
        if (!isEmpty()) {
            if (a == raiz.dato) {
            return this;
            }
            else {
                if (a < raiz.dato) {
                   aux = raiz.hi.find(a);
                }
                else {
                   aux = raiz.hd.find(a);
                }
            }
        }
        return aux;
    }
 
    public boolean hasElem(int a){
    	while (!isEmpty()) {
            if (a < raiz.dato) {
            	return(raiz.hi.hasElem(a));
            }
            else if (a > raiz.dato) {
                    return(raiz.hd.hasElem(a));
                }
                else {
                	return true;
                }  
        }
    	return false;
    }
    
    
    public int findMin() {
        Arbol arbolActual = this;
        while( !arbolActual.raiz.hi.isEmpty() ) {
            arbolActual = arbolActual.raiz.hi;
        }
        int devuelvo= arbolActual.raiz.dato;
        arbolActual.raiz=null;
        return devuelvo;
    }
    
    public boolean isLeaf() {
        boolean hoja = false;
        if( (raiz.hi).isEmpty() && (raiz.hd).isEmpty() ) {
            hoja = true;
        }
        return hoja;
    }
 
    
    public void delete(int a) {
    	Arbol toDelete = find(a);
        if (!toDelete.isEmpty()) {
            if (toDelete.isLeaf()) {
            	toDelete.raiz = null;
            }
            else {
                if (!toDelete.raiz.hi.isEmpty() && !toDelete.raiz.hd.isEmpty()) {
                	toDelete.raiz.dato = toDelete.raiz.hd.findMin();
                }
                else {
                    if (toDelete.raiz.hi.isEmpty()) {
                    	toDelete.raiz = toDelete.raiz.hd.raiz;
                    }else{
                    	toDelete.raiz = toDelete.raiz.hi.raiz;
                    }
                }
            }
        }
    }
}
