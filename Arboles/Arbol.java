//package TP2;

public class Arbol {

	private class Nodo{
		private Integer dato;
		private Arbol hijoIzq;
		private Arbol hijoDer;
		
		protected Nodo() {
			dato = null;
			hijoIzq = null;
			hijoDer = null;
		}
		
		private Arbol getHijoIzq() {
			return this.hijoIzq;
		}
		
		private Arbol getHijoDer() {
			return this.hijoDer;
		}
		
		private int getDato() {
			return this.dato;
		}
		
		private void setDato(int dato) {
			this.dato = dato;
		}
	}
	
	private Nodo raiz;
	
    public Arbol() {
    	raiz = new Nodo();
    }
	
	public Arbol(int n) {
         raiz.setDato(n);
         setHijoDer();
         setHijoIzq();
	}
 
    public boolean isEmpty(){
        return (raiz.dato == null);
    }
    
    public Nodo getRoot() {
    	return raiz;
    }
    
    public Arbol getHijoIzq() {
    	return raiz.getHijoIzq();
    }
    
    public Arbol getHijoDer() {
    	return raiz.getHijoDer(); 
    }
    
    public void setHijoIzq() {
    	raiz.hijoIzq = null;
    }
    
    public void setHijoDer() {
    	raiz.hijoDer = null;
    }
 
    public void insert(int a){
        if (isEmpty()) {
            Nodo nuevo = new Nodo();
            nuevo.dato = a;
            nuevo.hijoIzq = new Arbol();
            nuevo.hijoDer = new Arbol();
            raiz = nuevo;
        }
        else {
            if (a > raiz.getDato()) {
                (raiz.getHijoDer()).insert(a);
            }
            if (a < raiz.getDato()){
                (raiz.getHijoIzq()).insert(a);
            }
        }
    }
 
    public void preOrder(){
        if (!isEmpty()) {
            System.out.print( raiz.getDato() + ", "  );
            raiz.getHijoIzq().preOrder();
            raiz.getHijoDer().preOrder();
        }
    }
 
    public void inOrder(){
        if (!isEmpty()) {
            raiz.getHijoIzq().inOrder();
            System.out.print( raiz.getDato() + ", "  );
            raiz.getHijoDer().inOrder();
        }
    }
 
    public void posOrder(){
        if (!isEmpty()) {
            raiz.getHijoDer().posOrder();
            raiz.getHijoIzq().posOrder();
            System.out.print( raiz.getDato() + ", "  );
 
        }
    }
 
    public Arbol find(int a){
    	Arbol aux = null;
        if (!isEmpty()) {
            if (a == raiz.getDato()) {
            return this;
            }
            else {
                if (a < raiz.getDato()) {
                   aux = this.raiz.getHijoIzq().find(a);
                }
                else {
                   aux = this.raiz.getHijoDer().find(a);
                }
            }
        }
        return aux;
    }
 
    public boolean hasElem(int a){
    	while (!isEmpty()) {
            if (a < this.raiz.getDato()) {
            	return(this.raiz.getHijoIzq().hasElem(a));
            }
            else if (a > raiz.getDato()) {
                    return(this.raiz.getHijoDer().hasElem(a));
                }
                else {
                	return true;
                }  
        }
    	return false;
    }
    
    
    public int findMin() {
        Arbol arbolActual = this;
        while( !arbolActual.getHijoIzq().isEmpty() ) {
            arbolActual = arbolActual.getHijoIzq();
        }
        int devuelvo= arbolActual.raiz.getDato();
        arbolActual.raiz=null;
        return devuelvo;
    }
    
    public boolean isLeaf() {
        boolean hoja = false;
        if( (this.getHijoIzq()).isEmpty() && (this.getHijoDer()).isEmpty() ) {
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
                if (!toDelete.getHijoIzq().isEmpty() && !toDelete.getHijoDer().isEmpty()) {
                	toDelete.raiz.dato = toDelete.getHijoDer().findMin();
                }
                else {
                    if (toDelete.getHijoIzq().isEmpty()) {
                    	toDelete.raiz = toDelete.getHijoDer().raiz;
                    }else{
                    	toDelete.raiz = toDelete.getHijoIzq().raiz;
                    }
                }
            }
        }
    }
}
