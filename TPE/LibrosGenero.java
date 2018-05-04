package TPE;

import java.util.ArrayList;
import java.util.List;

public class LibrosGenero implements Comparable<LibrosGenero>{
       private String genero;
       private ArrayList<String> listaLibros;
 
       
	public LibrosGenero(String dato) {
	    this.genero = dato;
	    this.listaLibros = new ArrayList<String>();
	}
	
	public LibrosGenero(String dato, ArrayList<String> lista) {
		this.genero = dato;   
		this.listaLibros = lista;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public ArrayList<String> getListaLibros() {
	    return this.listaLibros;	
	}
	
	
	public void setListaLibros(ArrayList<String> listaLibros) {
		this.listaLibros = listaLibros;
	}
	
	public void insertLibro(String libro) {
		if (!this.listaLibros.contains(libro)){
		this.listaLibros.add(libro);
		}
	}
	
	

	@Override
	public int compareTo(LibrosGenero l) {
		int res = this.genero.compareTo(l.getGenero());
		return res;
	}

}
