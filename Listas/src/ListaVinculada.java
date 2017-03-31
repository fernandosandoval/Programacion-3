public class ListaVinculada {
	
	protected Nodo primero;
    int tama�o;
    
    public ListaVinculada () {
        primero=null;
        tama�o= 0;
    }
    
    public void insertarAdelante(int i) {
    	Nodo nuevo;
        nuevo = new Nodo();
        nuevo.info = i;
        if (primero==null)
        {
            nuevo.siguiente = null;
            primero = nuevo;
        }
        else
        {
            nuevo.siguiente = primero;
            primero = nuevo;
        }
        tama�o++;
    }
    
    public void extraerAdelante ()
    {
        if (primero!=null)
        {
            primero = primero.siguiente;
            tama�o--;
        }
        else
        {
        	System.out.println("Error, esta vac�a");
        }
    }
    
    public int getTama�o(){
    	return tama�o;
    }
    
   
    
    public void imprimir() {
        if (primero==null) {
        	System.out.println("Est� vacia, no contiene elementos");
        }
        else{
    	Nodo aux=primero;
        System.out.print("|");
        while (aux!=null) {
            System.out.print(aux.info+"|");
            aux=aux.siguiente;
        }
        System.out.println();
        }
    }
    
    public int getPrimero(){
    	return primero.info;
    }
}    