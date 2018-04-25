//package TP2;

public class Sim {
	

	/*  Ejercicio 6 del TP2 de Programacion 3 de TUDAI
	 * 
	 *  Autor: Fernando Sandoval
	 *  
	 *  Se utiliza un arbol de enteros en lugar de objetos para mayor simplicidad en la implementación
	 *  Se implementan los metodos solicitados en la clase Arbol (insert y hasElem)
	 *  
	 */

	public static void main(String[] args) {
		Arbol ar1 = new Arbol();
		ar1.insert(5);
		ar1.insert(2);
		ar1.insert(7);
		ar1.insert(1);
		ar1.insert(9);
		ar1.preOrder();
		if(ar1.hasElem(1))
			System.out.println("El numero 1 está en el arbol");
		  else
			System.out.println("El numero 1 no está en el arbol");
		if(ar1.hasElem(8))
			System.out.println("El numero 8 está en el arbol");
		  else
			System.out.println("El numero 8 no está en el arbol");
		if(ar1.hasElem(5))
			System.out.println("El numero 5 está en el arbol");
		  else
			System.out.println("El numero 5 no está en el arbol");
	}

}
