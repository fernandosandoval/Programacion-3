package Mochila;

import java.util.Comparator;

// Uso el comparator para comparar los 2 objetos que le paso y determinar cual es mayor, menor o igual
// que el otro

public class ComparadorObjeto implements Comparator<Objeto>{

	public int compare(Objeto o1, Objeto o2) {
		return Float.compare(o2.getBeneficio(), o1.getBeneficio());
	}

}
