package TP1;

public class Sim {
	
	/*  Ejercicio 5 del TP1 de Programacion 3 de TUDAI
	 * 
	 *  Autor: Fernando Sandoval
	 *  
	 *  Corregido Metodo para generar listas
	 *  (dos metodos independientes, uno para listas ordenadas
	 *  y otro para listas desordenadas)
	 *  
	 *  
	 */

	public static void main(String[] Args) {
		Lista li1 = new Lista();
		Lista li2 = new Lista();
		Lista li4 = new Lista();
		Lista li5 = new Lista();
		System.out.println("Lista desordenada 1");
		li1.insert(4);                           
		li1.insert(9);
		li1.insert(8);
		li1.insert(2);
		li1.insert(6);
		li1.insert(3);
		li1.print();
		System.out.println("Lista desordenada 2");
		li2.insert(9);
		li2.insert(7);
		li2.insert(8);
		li2.insert(1);
		li2.insert(5);
		li2.insert(3);
		li2.insert(4);
		li2.print();
		System.out.println("Lista resultado 3 (ordenada)");
		li1.generateList(li1,li2);
		System.out.println("Lista ordenada 4");
		li4.orderedInsert(4);                           
		li4.orderedInsert(9);
		li4.orderedInsert(8);
		li4.orderedInsert(2);
		li4.orderedInsert(6);
		li4.orderedInsert(3);
		li4.print();
		System.out.println("Lista ordenada 5");
		li5.orderedInsert(9);
		li5.orderedInsert(7);
		li5.orderedInsert(8);
		li5.orderedInsert(1);
		li5.orderedInsert(5);
		li5.orderedInsert(3);
		li5.orderedInsert(4);
		li5.print();
		System.out.println("Lista resultado 6 (ordenada)");
		li4.generateOrderedList(li4,li5); 		
			
}
	
}	

