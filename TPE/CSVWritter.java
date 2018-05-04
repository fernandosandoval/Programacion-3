package TPE;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWritter {

	public static void listWriter(ArrayList<String> genreList, String salida) {
		BufferedWriter bw = null;
		try {
			File file = new File("c:/users/El Ente/Desktop/"+salida);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			for (int index = 0; index < genreList.size(); index++) {
				String contenidoLinea1 = genreList.get(index);
				bw.write(contenidoLinea1);
				bw.newLine();
			}
		

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
					System.out.println("El archivo "+salida+" se ha creado exitosamente");
				}
					
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
	}

}
