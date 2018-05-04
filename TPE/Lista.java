package TPE;

import java.util.ArrayList;

public class Lista{
	
	protected Node first;
	protected Node aux;
	protected int size;
	public Lista(){
		aux = null;
		first = null;
		size = 0;
	}
	
	public void insert(LibrosGenero l) {
		Node temp = new Node(l, null);
		temp.setNext(first);
		first = temp;
		size++;
	}
	
	public void insertGenre(String genero) {
		LibrosGenero temp = new LibrosGenero(genero);
		this.insert(temp);
	}
	
	public Node findGenre(String generoAComparar) {
		Node puntero = first;
		while(puntero != null) {
			if (puntero.getInfo().getGenero().equals(generoAComparar)) {
				return puntero;
			}
			puntero = puntero.getNext();
		}
		return null;
	} 
	
	public void insertBook(String genero, String libro) {
		Node aux = findGenre(genero);
		aux.getInfo().insertLibro(libro);
	}
	
	public void orderedInsert(LibrosGenero l) {
		Node temp = new Node(l, null);
		LibrosGenero aux = temp.getInfo();
		Node puntero = first;
		int nuevoEsMayor = aux.getGenero().compareTo(first.getInfo().getGenero());
		if((isEmpty()) || nuevoEsMayor == 1) {	
			temp.setNext(first);
			first = temp;
			size++;
		}
		else {
				while ((puntero.getNext() != null)&&
					  ((puntero.getNext().getInfo().getGenero().compareTo(aux.getGenero()))!=1)) {     // mientras que O sea igual o mayor a first.next, avanzo
					puntero = puntero.getNext();
				}
		        temp.setNext(puntero.getNext());                                                       // en este punto, O es menor o igual a first, entonces
		        puntero.setNext(temp);		                                                           // agrego O en la lista
		     }
	}
	
	public void insertAtLast(LibrosGenero l) {
		Node temp = new Node (l, null);
		if (isEmpty()) {
			first = temp;
		}
		else {
			Node puntero = first;
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
			Node aux = first;
			while (aux != null) {
				System.out.println("Genero: "+aux.getInfo().getGenero()+" ");
				ArrayList<String> libros = aux.getInfo().getListaLibros();
				System.out.print("Libros: ");
				for (int i=0; i < libros.size(); i++)
				    System.out.print(libros.get(i)+" ");
				System.out.println();
				aux = aux.getNext();
			}
		}
		System.out.println();
	}
	
	public LibrosGenero getFirstInfo() {
		return first.getInfo();
	}
	
	public Node getFirst() {
		return first;
	}
	
	public Node getNext() {
		aux = aux.getNext();
		return aux;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void generateList(Lista l1, Lista l2) {
		 Lista li3 = new Lista();
		 Node aux1 = l1.first;
		 Node aux2 = l2.first;
	   	 while (aux1 != null) {
	   		while (aux2 != null) {
	   			 if (aux1.getInfo().equals(aux2.getInfo())) {
	   				 li3.orderedInsert(aux1.getInfo());
	   			 }
	   			 aux2 = aux2.getNext();
	   	   		 }
	   		aux2 = l2.first;
	   		aux1 = aux1.getNext();
	   	 }
	li3.print();   	 
	}
	
	public boolean hasElem(String generoAComparar) {
		Node puntero = first;
		while(puntero.getNext()!=null) {
			if (puntero.getInfo().getGenero().equals(generoAComparar)) {
				return true;
			}
			puntero = puntero.getNext();
		}
		return false;
	}
	
}	
