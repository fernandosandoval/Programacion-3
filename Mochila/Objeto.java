package Mochila;
public class Objeto{
	
	private float peso;
	private int valor;
	private float beneficio;
	
	public Objeto (float p, int v){
		peso = p;
		valor = v;
		beneficio = (float) valor / peso;
	}

	
	public float getPeso() {
		return peso;
	}


	public int getValor() {
		return valor;
	}
	
	public float getBeneficio(){
		return beneficio;
	}
}