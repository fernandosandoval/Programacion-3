package TPE2;

public class Sim {

	public static void main(String[] args) {
		Grafo g1 = new GrafoNoDirigido();
		//aqui va el path al archivo csv. para cargar los datos en memoria 
		//Por favor, ingrese aqu� el path a su archivo local
		Timer time = new Timer();
		g1 = CSVReader.graphLoader("c:/users/El Ente/Desktop/DataSets/dataset4.csv");
		double tiempo1 = time.stop(); 
        System.out.println("El tiempo empleado para la carga fue de "+tiempo1+" milisegundos");
        time.start();
		// aqui se resuelve al primer servicio con el metodo BXG 
		// (Busqueda por g�nero) con los par�metros "Nombre del genero A" (String) y 
		// n�mero N (int) de g�neros m�s buscados
		g1.BXG("viajes",10);
		// aqui se resuelve el segundo servicio llamando al m�todo GBG
		// (g�neros luego de buscar por un g�nero) con el par�metro "G�nero A" (String)
		g1.GBG("viajes");
		// por �ltimo resolvemos el tercer servicio (grafo con g�neros afines)
		// con el m�todo DFS_Ciclo que tiene como par�metro el g�nero inicial (String)
		g1.DFS_Ciclo("viajes");
        double tiempo2 = time.stop();
        System.out.println();
        System.out.println("El tiempo empleado para resolver los servicios fue de "+tiempo2+" milisegundos");
	}
}
