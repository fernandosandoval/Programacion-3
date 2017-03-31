public class Sim {
	public static void main(String[] ar) {
        Pila pila1=new Pila();
        pila1.apilar(34);
        pila1.apilar(23);
        pila1.apilar(55);
        pila1.mostrar();
        System.out.println("El tope de la pila es: "+pila1.verTope());
        pila1.desapilar();
        pila1.mostrar();        
        System.out.println("El tope de la pila es: "+pila1.verTope());
        pila1.desapilar();
        pila1.mostrar();        
        System.out.println("El tope de la pila es: "+pila1.verTope());
        pila1.desapilar();
        pila1.mostrar();  
	}
}
