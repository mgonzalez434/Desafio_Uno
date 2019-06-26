package util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import beans.Periodos;

public class UtilBuffer {

	public void generarDocumento(String id, JsonArray recibidas,ArrayList<Date> faltantes, String fechaI, String fechaT){
		Periodos periodo = new Periodos();
		periodo.setId(id);
		periodo.setFechaInicio(fechaI);
		periodo.setFechaTermino(fechaT);
		periodo.setRecibidas(recibidas);
		periodo.setFaltantes(faltantes);
		
		Gson gson = new Gson();

		String json = gson.toJson(periodo);
		this.escribirFichero(json);
	}

    public void escribirFichero(String json)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/ficheroPeriodos.json");
            pw = new PrintWriter(fichero);

                pw.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }

}
