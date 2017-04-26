package Mochila;
import java.util.Arrays;

public class Mochila {
	
	private float capacidad;
	
	public Mochila(float c){
		capacidad = c;
	}
	
	
	protected void cargarMochila(Objeto[] objetos){
		
		Arrays.sort(objetos, new ComparadorObjeto());
		
		float pesoMochila = 0; 
		float valorMochila = 0;
		float valorObjetos = 0;
		
		int i = 0, j = 0;
		int[] solucion = new int[objetos.length];
		
		while (j < objetos.length){
			valorObjetos += (float)objetos[j].getValor();
			j++;
		}
		
		while((i < objetos.length) && (pesoMochila + objetos[i].getPeso() <= capacidad)){
			pesoMochila += (float)objetos[i].getPeso();
			valorMochila += (float)objetos[i].getValor();
			solucion[i] = i;
			i++;
		}
		
		System.out.println("Cantidad de objetos a poner en la mochila: "+ objetos.length);
		System.out.println("Valor de la suma de los objetos: "+ valorObjetos);
		System.out.println("Capacidad de la mochila: " + capacidad);
		System.out.println("Peso de la mochila luego de cargarla: " + pesoMochila);
		System.out.println("Valor de la mochila luego de cargarla: " + valorMochila);
		System.out.print("Número de objetos en la mochila: " +i);
	}
}	