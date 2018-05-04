package TPE;                       

import java.util.List;
import java.util.ArrayList;


public class Buscador {
	
		
	protected static void mostrarLista(ArrayList<String> lista) {
		for (int index = 0; index < lista.size(); index++) {
        	System.out.print(lista.get(index)+" ");
        }
		System.out.println();
	}

		
	protected static ArrayList<String> agregarLibroXGenero(Lista lista, String genero) {
		ArrayList<String> genreList = new ArrayList<String>();
		Node aux = lista.getFirst();
		while (aux != null) {
			if (aux.getInfo().getGenero().equals(genero)) {
				genreList = aux.getInfo().getListaLibros();
			}
			
			aux = aux.getNext();
		}    
        return genreList;
	}
	
	
}
