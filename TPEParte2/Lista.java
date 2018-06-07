package TPE2;


public class Lista{
	
	protected Nodo first;
	protected Nodo aux;
	protected int size;
	public Lista(){
		aux = null;
		first = null;
		size = 0;
	}
	
	public void insert(Arista A) {
		Nodo temp = new Nodo(A, null);
		temp.setNext(first);
		first = temp;
		size++;
	}
	
	
	public void orderedInsert(Arista A) {
		Nodo temp = new Nodo(A, null);
		Arista aux = temp.getInfo();
		Nodo puntero = first;	
		if((isEmpty())||(aux.getPeso() > first.info.getPeso())) {	
			temp.setNext(first);
			first = temp;
			size++;
		}
		else {
				while ((puntero.next != null)&&((puntero.next.compareTo(aux))!=1)) {     // mientras que A sea igual o mayor a first.next, avanzo
					puntero = puntero.next;
				}
		        temp.setNext(puntero.next);              // en este punto, A es menor o igual a first, entonces
		        puntero.setNext(temp);		           // agrego A en la lista
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
	
	public Nodo getFirst() {
		return first;
	}
	
	public Nodo getAux() {
		return aux;
	}
	
	public Nodo getNext() {
		return aux.getNext();
	}
	
	public void setNext() {
		this.aux = aux.getNext();
	}
	
	
	public boolean isEmpty() {
		return (first == null);
	}
	
}
