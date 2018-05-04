package TPE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sim {

	public static void main(String[] args) {
        
		Lista resultList20 = new Lista();
		ArrayList<String> booksList20 = new ArrayList<String>();
		Lista resultList1000 = new Lista();
		ArrayList<String> booksList1000 = new ArrayList<String>();
		Lista resultList100000 = new Lista();
		ArrayList<String> booksList100000 = new ArrayList<String>();
		Lista resultListUnMillon = new Lista();
		ArrayList<String> booksListUnMillon = new ArrayList<String>();
		
//      inicio carga para 20 elementos
        
        Timer time = new Timer();
		time.start();        
		resultList20 = CSVReader.listLoader("c:/users/El Ente/workspace/programacion3/2018/src/TPE/dataset1.csv");
        resultList20.print();
        String genero = "";
        System.out.println("Ingrese el genero a buscar:");
        Scanner sc = new Scanner (System.in);
        genero = sc.nextLine ();
        booksList20 = Buscador.agregarLibroXGenero(resultList20, genero);
        System.out.println("Los libros del género "+genero+" son");
        Buscador.mostrarLista(booksList20);
        System.out.println();
        CSVWritter.listWriter(booksList20,"salida20.csv");
        double tiempo20 = time.stop(); 
        System.out.println("El tiempo empleado para una lista de 20 libros fue de "+tiempo20+" milisegundos");
        System.out.println();
        System.out.println();
        System.out.println();
        sc.close();
        
//      inicio carga para 1000 elementos		
		
      
		time.start();        
		resultList1000 = CSVReader.listLoader("c:/users/El Ente/workspace/programacion3/2018/src/TPE/dataset2.csv");
        resultList1000.print();
        booksList1000 = Buscador.agregarLibroXGenero(resultList1000, genero);
        System.out.println("Los libros del género "+genero+" son");
        Buscador.mostrarLista(booksList1000);
        System.out.println();
        CSVWritter.listWriter(booksList1000,"salida1000.csv");
        double tiempo1000 = time.stop(); 
        System.out.println("El tiempo empleado para una lista de 20 libros fue de "+tiempo20+" milisegundos");
        System.out.println();
        System.out.println();
        System.out.println();
                
//      inicio carga para 100000 elementos		
		
        time.start();        
		resultList100000 = CSVReader.listLoader("c:/users/El Ente/workspace/programacion3/2018/src/TPE/dataset3.csv");
        resultList100000.print();
        booksList100000 = Buscador.agregarLibroXGenero(resultList100000, genero);
        System.out.println("Los libros del género "+genero+" son");
        Buscador.mostrarLista(booksList100000);
        System.out.println();
        CSVWritter.listWriter(booksList100000,"salida100000.csv");
        double tiempo100000 = time.stop(); 
        System.out.println("El tiempo empleado para una lista de 20 libros fue de "+tiempo20+" milisegundos");
        System.out.println();
        System.out.println();
        System.out.println();
                 
//      inicio carga para 1000000 elementos		
		
        time.start();        
		resultListUnMillon = CSVReader.listLoader("c:/users/El Ente/workspace/programacion3/2018/src/TPE/dataset3.csv");
        resultListUnMillon.print();
        booksListUnMillon = Buscador.agregarLibroXGenero(resultList20, genero);
        System.out.println("Los libros del género "+genero+" son");
        Buscador.mostrarLista(booksList20);
        System.out.println();
        CSVWritter.listWriter(booksList20,"salidaUnMillon.csv");
        double tiempoUnMillon = time.stop(); 
        System.out.println("El tiempo empleado para una lista de 20 libros fue de "+tiempo20+" milisegundos");
        System.out.println();
        System.out.println();
        System.out.println();
                
        
//      resumen de los tiempos obtenidos
        
        System.out.println("Los tiempos empleados para cada una de las cargas fueron");
        System.out.println("Carga de 20 libros: "+tiempo20+" milisegundos");
        System.out.println("Carga de 1000 libros: "+tiempo1000+" milisegundos");
        System.out.println("Carga de 100000 libros: "+tiempo100000+" milisegundos");
        System.out.println("Carga de 1000000 de libros: "+tiempoUnMillon+" milisegundos");
	}
	
}	
