package Practicos;

public class Sim {
	
	/*  Ejercicio 5 del TP1 de Programacion 3 de TUDAI
	 * 
	 *  Autor: Fernando Sandoval
	 *  
	 *  
	 *  
	 *  
	 *  
	 */

	public static void main(String[] Args) {
		Lista li1 = new Lista();
		Lista li2 = new Lista();
		System.out.println("Lista ordenada");
		li1.orderedInsert(4);                           
		li1.orderedInsert(9);
		li1.orderedInsert(8);
		li1.orderedInsert(2);
		li1.orderedInsert(6);
		li1.orderedInsert(3);
		li1.print();
		System.out.println("Lista desordenada");
		li2.insert(9);
		li2.insert(7);
		li2.insert(8);
		li2.insert(1);
		li2.insert(5);
		li2.insert(3);
		li2.print();
		System.out.println("Lista resultado (ordenada)");
		li1.generateList(li1,li2);
			
}
	
}	

