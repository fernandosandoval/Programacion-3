package TPE2;

public class Sim {

	public static void main(String[] args) {
		Grafo g1 = new GrafoNoDirigido();
		//aqui va el path al archivo csv. para cargar los datos en memoria 
		//Por favor, ingrese aquí el path a su archivo local
		g1 = CSVReader.graphLoader("c:/users/El Ente/Desktop/DataSets/dataset3.csv");
		// aqui se resuelve al primer servicio con el metodo BXG 
		// (Busqueda por género) con los parámetros "Nombre del genero A" (String) y 
		// número N (int) de géneros más buscados
		g1.BXG("viajes",10);
		// aqui se resuelve el segundo servicio llamando al método GBG
		// (géneros luego de buscar por un género) con el parámetro "Género A" (String)
		g1.GBG("viajes");
		// por último resolvemos el tercer servicio (grafo con géneros afines)
		// con el método DFS_Ciclo que tiene como parámetro el género inicial (String)
		g1.DFS_Ciclo("viajes");
	}
}
