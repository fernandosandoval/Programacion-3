package TP1;



public class Lista{
	
	protected Nodo first;
	protected Nodo aux;
	protected int size;
	public Lista(){
		aux = null;
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
		Nodo puntero = first;	
		if((isEmpty())||((int)aux < (int)first.info)) {	
			temp.setNext(first);
			first = temp;
			size++;
		}
		else {
				while ((puntero.next != null)&&((puntero.next.compareTo(aux))!=1)) {     // mientras que O sea igual o mayor a first.next, avanzo
					puntero = puntero.next;
				}
		        temp.setNext(puntero.next);              // en este punto, O es menor o igual a first, entonces
		        puntero.setNext(temp);		           // agrego O en la lista
		     }
	}
	
	public void insertAtLast(Object O) {
		Nodo temp = new Nodo (O, null);
		if (isEmpty()) {
			first = temp;
		}
		else {
			Nodo puntero = first;
			while(puntero.getNext()!=null) {
				puntero = puntero.getNext();
			}
			puntero.setNext(temp);
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
		 Lista li3 = new Lista();
		 Nodo aux1 = l1.first;
		 Nodo aux2 = l2.first;
	   	 while (aux1 != null) {
	   		while (aux2 != null) {
	   			 if (aux1.info.equals(aux2.info)) {
	   				 li3.orderedInsert(aux1.info);
	   			 }
	   			 aux2 = aux2.next;
	   	   		 }
	   		aux2 = l2.first;
	   		aux1 = aux1.next;
	   	 }
	li3.print();   	 
	}
	
	public void generateOrderedList(Lista l1, Lista l2) {     //cuando las listas ya estan ordenadas
		 Lista li3 = new Lista();
		 Nodo aux1 = l1.first;
		 Nodo aux2 = l2.first;
	   	 while (aux1 != null) {
	   		while (aux2 != null) {
	   			 if (aux1.info.equals(aux2.info)) {
	   				 li3.insertAtLast(aux1.info);
	   			 }
	   			 aux2 = aux2.next;
	   	   		 }
	   		aux2 = l2.first;
	   		aux1 = aux1.next;
	   	 }
	li3.print();   	 
	}
	
}
