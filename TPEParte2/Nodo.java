package TPE2;

public class Nodo
{
    protected Arista info;
    protected Nodo next;
    
    
    public Nodo() {
    	this.info = null;
    	this.next = null;
    }
    
    public Nodo(Arista A, Nodo N) {
    	setInfo(A);
        setNext(N);
    }
    
    public void setInfo(Arista A) {
    	this.info = A;
    }
    
    public void setNext(Nodo N) {
    	this.next = N;
    }
    
    public Arista getInfo() {
    	return this.info;
    }
    
    public Nodo getNext() {
    	return this.next;
    }
    
    public int compareTo(Arista A){
		 
        int estado=-1;
        if(this.info.getPeso().equals(A.getPeso())){
            //Las aristas son iguales
            estado = 0;
        }else if(this.info.getPeso() < A.getPeso()){
            //El objeto A es mayor que el B pasado por parametro
            estado = 1;
        }
        return estado;
    }    
}
