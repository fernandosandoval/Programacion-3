package TPE2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Grafo {
	protected Integer numV;
	protected Integer numA;
	List<Vertice>vertices;
	List<Arista>aristas;

	
	public Grafo() {
		this.vertices = new ArrayList<Vertice>();
		this.aristas = new ArrayList<Arista>();
		this.numA = 0;
		this.numV = 0;
	}

	public abstract boolean existArista(String _v1, String _v2);

	//Las aristas se añaden referenciando las etiquetas de los vertices existentes en el grafo
	public abstract boolean addArista(String _v1, String _v2, Integer _p);
	
	public Arista getArista(String _v1, String _v2) {
		for(Arista a  : this.aristas) {
			if(a.getVertice1().getEtiqueta().equals(_v1) && a.getVertice2().getEtiqueta().equals(_v2)){
				return a;
			}
			else if (a.getVertice2().getEtiqueta().equals(_v1) && a.getVertice1().getEtiqueta().equals(_v2)) {
				return a;
			}
		}
		return null;
	}
	
	//Agrega un vertice al grafo, (Data, etiqueta);
	public boolean addVertice(String _e) {
		//Si no existe el vertice lo agrego
		for(Vertice v : this.vertices) {
			if(v.getEtiqueta().equals(_e)) {
				return false;
			}
		}
		this.vertices.add(new Vertice(_e));
		numV++;
		return true;
	}

	//Añade una arista con el peso por defecto = 1
	public boolean addArista(String _v1, String _v2) {
		return this.addArista(_v1, _v2, 1);
	}
	

	//Retorna TRUE si la etiqueta esta contenida en la lista de vertices
	public boolean containsVertice(String _e) {
		for(Vertice v : this.vertices) {
			if(v.getEtiqueta().equals(_e)) {
				return true;
			}
		}
		return false;
	}

	//Retorna un vertice que contenga X etiqueta, si no existe lo crea
	protected Vertice getVertice(String _e) {
		for(Vertice v : this.vertices) {
			if(v.getEtiqueta().equals(_e)) {
				return v;
			}
		}
		return null;
	}
	
	//Comienza el recorrido DFS desde el inicio dado
	public List<String> DFS (String _e) {
		Vertice inicio = this.getVertice(_e);
		if(inicio==null) {
			List<String>error = new ArrayList<>();
			error.add("Vertice inexistente");
			return error;
		}
		Boolean[]visitados = new Boolean[this.vertices.size()];
		for(int i=0 ; i<visitados.length ; i++) {
			visitados[i] = false;
		}
		visitados[this.vertices.indexOf(inicio)] = true;
		System.out.println("Inicio recorrido del grafo partiendo del genero "+inicio.getEtiqueta());
		return DFS_Visitar(inicio, visitados);
	}
	
	private List<String> DFS_Visitar(Vertice _v, Boolean[] _vi){
		List<String>retorno = new ArrayList<String>();
		//Obtengo los vertices adyacentes al actual
		List<Vertice> adyacentes = _v.getAdyacentes();
		System.out.println("Determinando los pesos de las aristas entre " + _v.getEtiqueta()+ " y sus adyacentes" );
		for(Vertice Ve : adyacentes) {
			System.out.print(Ve.getEtiqueta() + "\t");
		}
		System.out.println();
		System.out.println("Visitados");
		int i = 1;
		for(Boolean b : _vi) {
			System.out.print(i + " " + b + "\t");
			i++;
		}
		System.out.println("\n");
		//Recorro la lista de adyacentes
		for(Vertice v : adyacentes) {
			if(!_vi[this.vertices.indexOf(v)]) {
				_vi[this.vertices.indexOf(v)] = true;
				retorno.addAll(DFS_Visitar(v, _vi));
			}
		}
		
		retorno.add(_v.getEtiqueta());
		
		return retorno;
	}
	
	//Metodo auxiliar para comenzar el recorrido BFS desde un vertice dado
	public List<String> BFS(String _e){
		Vertice inicio = this.getVertice(_e);
		if(inicio==null) {
			List<String>error = new ArrayList<>();
			error.add("Vertice inexistente");
			return error;
		}
		
		return BFS_Visitar(inicio);
	}
	
	//Comienza el recorrido BFS
	private List<String> BFS_Visitar(Vertice _v){
		List<String>retorno = new ArrayList<String>();
		Queue<Vertice>cola = new LinkedList<Vertice>();
		Boolean[]visitados = new Boolean[this.vertices.size()];
		for(int i = 0; i<visitados.length ; i++) {
			visitados[i] = false;
		}
		visitados[this.vertices.indexOf(_v)] = true;
		cola.add(_v);
		
		while(!cola.isEmpty()) {
			Vertice v_actual = cola.remove();
			retorno.add(v_actual.getEtiqueta());
			List<Vertice>adyacentes = v_actual.getAdyacentes();
			
			for(Vertice v_adyacente : adyacentes) {
				if(v_adyacente !=null && !visitados[this.vertices.indexOf(v_adyacente)]) {
					cola.add(v_adyacente);
					visitados[this.vertices.indexOf(v_adyacente)] = true;
				}
			}
		}
		
		return retorno;
		
	}
	
	//Comienza el recorrido DFS para busqueda por género desde un género pasado como parámetro
		public List<String> BXG (String _e) {
			Vertice inicio = this.getVertice(_e);
			Lista listaAristas = new Lista();
			if(inicio==null) {
				List<String>error = new ArrayList<>();
				error.add("Vertice inexistente");
				return error;
			}
			Boolean[]visitados = new Boolean[this.vertices.size()];
			for(int i=0 ; i<visitados.length ; i++) {
				visitados[i] = false;
			}
			visitados[this.vertices.indexOf(inicio)] = true;
			
			return BXG_Visitar(inicio, visitados, listaAristas);
		}
		
		private List<String> BXG_Visitar(Vertice _v, Boolean[] _vi, Lista listaAristas){
			List<String>retorno = new ArrayList<String>();
			//Obtengo los vertices adyacentes al actual
			List<Vertice> adyacentes = _v.getAdyacentes();
			System.out.println("Adyacentes de: " + _v.getEtiqueta());
			for(Vertice Ve : adyacentes) {
				System.out.print(Ve.getEtiqueta() + "\t");
				int pesoArista = (this.getArista(_v.getEtiqueta(), Ve.getEtiqueta()).getPeso());
				listaAristas.insert(this.getArista(_v.getEtiqueta(), Ve.getEtiqueta()));
				System.out.println("El peso entre "+_v.getEtiqueta()+" y "+Ve.getEtiqueta()+" es "+pesoArista);
			}
			System.out.println();
			//Recorro la lista de adyacentes
			for(Vertice v : adyacentes) {
				if(!_vi[this.vertices.indexOf(v)]) {
					_vi[this.vertices.indexOf(v)] = true;
					retorno.addAll(BXG_Visitar(v, _vi, listaAristas));
				}
			}
			
			retorno.add(_v.getEtiqueta());
//			System.out.println("Lista de aristas");
//			while (listaAristas.first!=null) {
//				System.out.println(listaAristas.getFirst().toString());
//			}
			return retorno;
		}
	
		//Metodo auxiliar para comenzar el recorrido BFS desde un género dado
		public void GBG(String _e){
			Vertice inicio = this.getVertice(_e);
			
			if(inicio.getEtiqueta()==null) {
				System.out.println("Vertice inexistente");
			}
			else {
				System.out.println("Los géneros que fueron buscados luego de buscar por el género "+inicio.getEtiqueta()+" son:");
                GBG_Visitar(inicio);
			}
			System.out.println();		
		}
		
		//Comienza el recorrido BFS
		private void GBG_Visitar(Vertice _v){
			List<String>retorno = new ArrayList<String>();
			Queue<Vertice>cola = new LinkedList<Vertice>();
			Boolean[]visitados = new Boolean[this.vertices.size()];
			for(int i = 0; i<visitados.length ; i++) {
				visitados[i] = false;
			}
			visitados[this.vertices.indexOf(_v)] = true;
			cola.add(_v);
			
			while(!cola.isEmpty()) {
				Vertice v_actual = cola.remove();
				retorno.add(v_actual.getEtiqueta());
				List<Vertice>adyacentes = v_actual.getAdyacentes();
				
				for(Vertice v_adyacente : adyacentes) {
					if(v_adyacente !=null && !visitados[this.vertices.indexOf(v_adyacente)]) {
						cola.add(v_adyacente);
						visitados[this.vertices.indexOf(v_adyacente)] = true;
					}
				}
			}
			for (String str : retorno) {
				System.out.println(str);
			}
				
		}
		
		//Comienza el recorrido DFS con deteccion de ciclo desde el inicio dado
		public void DFS_Ciclo (String _e) {
			System.out.println("Inicio búsqueda de generos afines a "+_e);
			Vertice inicio = this.getVertice(_e);
//										}
			Boolean[]visitados = new Boolean[this.vertices.size()];
			String[]estado = new String[this.vertices.size()];
			ArrayList<String> camino = new ArrayList<String>();
	        
			for(int i=0 ; i<visitados.length ; i++) {
				visitados[i] = false;
			}
			for(int i=0 ; i<estado.length ; i++) {
				estado[i] = "blanco";
			}
			ArrayList<String> afines = new ArrayList<String>();
			ArrayList<String> resultado = new ArrayList<String>();
			visitados[this.vertices.indexOf(inicio)] = true;
			estado[this.vertices.indexOf(inicio)] = "rojo";
			resultado.addAll(DFS_Ciclo_Visitar(inicio, visitados, estado, afines, camino));
			resultado.remove(_e);
			System.out.println("Los generos afines a "+_e+" son ");
			for (String s : resultado)
				System.out.print(s + "\t");
		}
		
		private ArrayList<String> DFS_Ciclo_Visitar(Vertice _v, Boolean[] _vi, String[] _est, ArrayList<String> _afin, ArrayList<String> _camino){
			List<String>retorno = new ArrayList<String>();
			//Obtengo los vertices adyacentes al actual
			List<Vertice> adyacentes = _v.getAdyacentes();
			//Recorro la lista de adyacentes
			for(Vertice v : adyacentes) {
				// si el vertice esta en el arreglo de visitados en false				
					if((!_vi[this.vertices.indexOf(v)]||(_est[this.vertices.indexOf(v)]).equals("rojo"))) {
					//lo pongo en true en visitados, pongo el estado en Amarillo y llamo a la funcion recursivamente con ese vertice
			
						if(_est[this.vertices.indexOf(v)].equals("rojo")) {		
				    		_camino.add(_v.getEtiqueta());
							for(String s : _camino) {
								if (!_afin.contains(s)) {
									_afin.add(s);
								}
							}	
						}	
						    	else { 	
						    		_vi[this.vertices.indexOf(v)] = true;
						    		_est[this.vertices.indexOf(v)] = "amarillo";
						    		_camino.add(_v.getEtiqueta());
						    		retorno.addAll(DFS_Ciclo_Visitar(v, _vi, _est, _afin, _camino));		
						    }
			       }
					_camino.remove(_v.getEtiqueta());
			}		
			_est[this.vertices.indexOf(_v)] = "negro";
			retorno.add(_v.getEtiqueta());
			return _afin;
		}
			
		
	public Integer numVertices() {
		return this.numV;
	}

	public Integer numAristas() {
		return this.numA;
	}
}
