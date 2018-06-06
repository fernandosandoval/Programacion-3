package TPE2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CSVReader {

    protected static Grafo graphLoader(String csvFile) {
        Grafo g= new GrafoDirigido();
        String line = "";
        String cvsSplitBy = ",";
        System.out.println("Leyendo datos del archivo .csv");
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        line = br.readLine();		                                                            // salteo el encabezado
            while ((line = br.readLine()) != null) {						                    // mientras haya lineas para leer en el csv		
                String[] generos = line.split(cvsSplitBy);       
                System.out.print(generos[0]+"->");
                if (!g.containsVertice(generos[0])){		                                    
                	// si el primer genero no esta en el grafo, lo agrego
                       g.addVertice(generos[0]);
                }
            	// para cada uno de los siguientes generos
                for (int i=1; i < generos.length; i++) {                                        
                	System.out.print(generos[i]+" ");
                	// si el genero actual no esta en el grafo, lo agrego
                	if ((!g.containsVertice(generos[i]))){                                      
                		g.addVertice(generos[i]);
                		g.addArista(generos[i-1], generos[i], 1);
                	}	    	
                	    else {
                	      // si ambos estan en el grafo, me fijo si hay arista entre ellos	
                	      if (g.existArista(generos[i-1],generos[i])) {
                	    	  int peso = g.getArista(generos[i-1],generos[i]).getPeso();
                	    	  g.getArista(generos[i-1],generos[i]).setPeso(peso+1);
                	      }
                	      else {
                	      // creo una arista nueva
                	    	 g.addArista(generos[i-1], generos[i], 1); 
                	      }
                	    	  
                     	}
              
                		
                 }
                System.out.println();                                                                               
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return g;
    }
    
    
}
