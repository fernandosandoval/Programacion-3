public class ListaVinculada {
	
	protected Nodo primero;
    int tamaño;
    
    public ListaVinculada () {
        primero=null;
        tamaño= 0;
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
        tamaño++;
    }
    
    public void extraerAdelante ()
    {
        if (primero!=null)
        {
            primero = primero.siguiente;
            tamaño--;
        }
        else
        {
        	System.out.println("Error, esta vacía");
        }
    }
    
    public int getTamaño(){
    	return tamaño;
    }
    
   
    
    public void imprimir() {
        if (primero==null) {
        	System.out.println("Está vacia, no contiene elementos");
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