public class Pila {
	
	protected ListaVinculada elementoPila;
	   
	
	public Pila(){
		this.elementoPila = new ListaVinculada();
	}

	public void apilar(int i){
        this.elementoPila.insertarAdelante(i);		
	}

    public void desapilar(){
    	this.elementoPila.extraerAdelante();
    }
    
	public boolean estaVacia(){
    	if (this.elementoPila.getTamaño()==0){
    			return true;
    	}
    	else return false;
    }
    public int verTope(){
    	if (!estaVacia()){
    	   return this.elementoPila.getPrimero();
    	}
    	else
    	   return -1;	
    }
    
    public void mostrar(){
    	this.elementoPila.imprimir();
    }
}    