package Practicos;

public class Lista{
	
	protected Nodo first;
	protected int size;
	public Lista(){
		first = null;
		size = 0;
	}
	
	public void insert(Object O) {
		Nodo temp = new Nodo(O, null);
		temp.setNext(first);
		first = temp;
		size++;
	}
	
	public void orderedInsert(Object O) {
		Nodo temp = new Nodo(O, null);
		Object aux = temp.getInfo();
		if(isEmpty()) {	
			first = temp;
			first.next = null;
			System.out.println(first.info);
			size++;
		}
		else {
				while ((first.next != null)&&((first.next.compareTo(aux))!=1))     // mientras que O sea igual o mayor a first.next, avanzo
					first = first.next;
		        temp.setNext(first.next);              // en este punto, O es menor o igual a first, entonces
		        first.setNext(temp);		           // agrego O en la lista
		        
		     }
	}
	
	
	public void extract() {
		if (first!= null) {
			first = first.getNext();
		    size--;	
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("La lista está vacía");
		}
		else {
			Nodo aux = first;
			System.out.print("|");
			while (aux != null) {
				System.out.print(aux.getInfo()+"|");
				aux = aux.getNext();
			}
		}
		System.out.println();
	}
	
	public Object getFirst() {
		return first.getInfo();
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void generateList(Lista l1, Lista l2) {
		 System.out.println("entro a generate");
		 Lista li3 = new Lista();
		 Nodo aux1 = l1.first;
		 Nodo aux2 = l2.first;
	   	 while (aux1 != null) {
	   		 System.out.println(aux1.info);
	   		while (aux2 != null) {
	   			System.out.println(aux2.info);
	   			 if (aux1.info.equals(aux2.info)) {
	   				 System.out.println("Agrego a lista "+aux1.info);	 
	   				 li3.orderedInsert(aux1.info);
	   			 }
	   			 aux2 = aux2.next;
	   	   		 }
	   		aux2 = l2.first;
	   		aux1 = aux1.next;
	   	 }
	li3.print();   	 
	}
	
}
