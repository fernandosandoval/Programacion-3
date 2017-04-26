package Mochila;

public class Sim {
      public static void main(String[] args){
		
		final int NUM_OBJETOS = 10;
		final float CAPACIDAD = 30;
		
		Objeto[] objetos = new Objeto[NUM_OBJETOS];
		float[] pesos = {5, 2, 3, 1, 3, 3, 10, 6, 2, 4};
		int[] valores = {8, 5, 8, 3, 6, 9, 12, 8, 4, 10};
		
		
		for(int i = 0; i < NUM_OBJETOS; i++){
			objetos[i] = new Objeto(pesos[i], valores[i]);
		}
		
		Mochila m = new Mochila(CAPACIDAD);
		
	
		m.cargarMochila(objetos);
      }
}      