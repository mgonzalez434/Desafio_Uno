package util;

import java.util.ArrayList;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UtilJson {
	
	UtilFecha utilFechas = new UtilFecha();
	UtilBuffer utilBuffer = new UtilBuffer();
	
	public void process(String msg){
		JsonParser parser = new JsonParser();
		JsonElement datos = parser.parse(msg);
		JsonObject jobject = datos.getAsJsonObject();
		
		JsonElement id = jobject.get("id");
		JsonElement fechaCreacion = jobject.get("fechaCreacion");
		JsonElement fechaFin = jobject.get("fechaFin");
		JsonArray arrayFechas = jobject.getAsJsonArray("fechas");
		
		ArrayList<Date> fechasArrayFaltantes = utilFechas.calculoFecha(fechaCreacion.toString(), fechaFin.toString(), arrayFechas);
		
		utilBuffer.generarDocumento(id.toString(),arrayFechas, fechasArrayFaltantes, fechaCreacion.toString(), fechaFin.toString());

	}
	

		

}
