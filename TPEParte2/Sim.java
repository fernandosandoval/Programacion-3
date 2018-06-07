package TPE2;

public class Sim {

	public static void main(String[] args) {
		Grafo g1 = new GrafoNoDirigido();
		g1 = CSVReader.graphLoader("c:/users/El Ente/Desktop/DataSets/dataset3.csv");
		g1.BXG("viajes",10);
		g1.GBG("viajes");
		g1.DFS_Ciclo("viajes");
	}
}
