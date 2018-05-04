package TPE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    protected static Lista listLoader(String csvFile) {
    	Lista listaGeneros= new Lista();
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        line = br.readLine();                                                                   // salteo el encabezado
            while ((line = br.readLine()) != null) {						                    // mientras haya lineas para leer en el csv		
                String[] items = line.split(cvsSplitBy);
                String tituloLibro = items[0];
                
                String[] generos = items[3].split(" ");
                
                for (int i=0; i < generos.length; i++) {                                        // para cada uno de los generos
                	System.out.println(generos[i]);
                	System.out.println(tituloLibro);
                	if ((listaGeneros.isEmpty() || !(listaGeneros.hasElem((generos[i])) ))) {   // si la lista de generos esta vacia o si el genero no esta en la lista, agrego el genero
                		listaGeneros.insertGenre(generos[i]);                                   // agrego el genero a la lista
                        listaGeneros.insertBook(generos[i],tituloLibro);                        // agrego el libro a la lista de este genero
                	}
                	else                                                                        // el genero ya esta en la lista
                		listaGeneros.insertBook(generos[i], tituloLibro);
                }
                                                                                                // aumento en uno el indice para la siguiente iteracion del while
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaGeneros;
    }
    
    
}
