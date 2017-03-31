
public class Nodo {
	protected int info;
	protected Nodo siguiente;

	public Nodo() {
		this.info = -1;
		this.siguiente = null;
	}
	
	public Nodo(int i,Nodo n){
		setInfo(i);
		setSiguiente(n);
	}
	
	public void setInfo(int i){
		this.info = i;
		
	}
	
	public int getInfo(){
		return info;	
	}	
	
	public void setSiguiente (Nodo n){
		this.siguiente = n;
	}
	
	public Nodo getSiguiente (){
		return siguiente;
	}
	
	

	
	
	
}
