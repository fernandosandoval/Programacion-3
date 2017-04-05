// Utilizo para comparar los metodos de burbujeo y de mergesoft
// La cantidad de elementos del arreglo esta dada por la variable MAX1 (2000 elementos),
// MAX2 (20000 elementos)
// Para obtener un tiempo mas o menos "medible" hago un for de 1000 bucles en el cual
// creo el arreglo y lo ordeno con ambos metodos

package Ordenamiento;
import java.util.Date;

public class Sim {
	final static int MAX1 = 2000;
	final static int MAX2 = 10000;
	public static void main(String[] args) {
		
		//prueba de carga de arreglo de 2000 elementos y ordenamiento por ambos metodos
		
		Date start1 = new Date();
		for (int j=1; j<1000; j++){
	    	int [] Arreglo = cargarArreglo(MAX1);
	    	Burbuja.ordenar(Arreglo);
		    }
		Date end1 = new Date();
		long tiempo1 = end1.getTime() - start1.getTime();
		System.out.println("El tiempo promedio de ordenar por burbujeo con 2000 elementos es:"+tiempo1);
		
		Date start2 = new Date();
		for (int j=1; j<1000; j++){
	    	int [] Arreglo2 = cargarArreglo(MAX1);
	    	Mergesort.mergesort(Arreglo2, 0, MAX1-1);
		    }
		Date end2 = new Date();
		long tiempo2 = end2.getTime() - start2.getTime();
		System.out.println("El tiempo promedio de ordenar por Mergesort con 2000 elementos es: "+tiempo2);
		
		//prueba de carga de arreglo de 20000 elementos y ordenamiento por ambos metodos
	    
		Date start3 = new Date();
				for (int j=1; j<1000; j++){
			    	int [] Arreglo = cargarArreglo(MAX2);
			    	Burbuja.ordenar(Arreglo);
				    }
		Date end3 = new Date();
		long tiempo3 = end3.getTime() - start3.getTime();
		System.out.println("El tiempo promedio de ordenar por burbujeo con 10000 elementos es:"+tiempo1);
				
		Date start4 = new Date();
		for (int j=1; j<1000; j++){
	    	int [] Arreglo2 = cargarArreglo(MAX2);
			    	Mergesort.mergesort(Arreglo2, 0, MAX2-1);
				    }
				Date end4 = new Date();
				long tiempo4 = end4.getTime() - start4.getTime();
				System.out.println("El tiempo promedio de ordenar por Mergesort con 10000 elementos es: "+tiempo2);
	}
	
 public static int[] cargarArreglo(int k){
	    int Arreglo [];
		Arreglo = new int [k];
		for (int i=0; i<k; i++){
			Arreglo [i] = (int)(Math.random()*1000);
		}
		return Arreglo;
 }
	
}
