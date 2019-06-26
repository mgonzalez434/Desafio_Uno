package beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.JsonArray;

public class Periodos {
	String id="";
	String fechaCreacion="";
	String fechaFin="";
	JsonArray fechas = new JsonArray();
	ArrayList<String> fechasFaltantes = new ArrayList<String>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFechaInicio() {
		return fechaCreacion;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaCreacion = fechaInicio.replace("\"", "");
	}
	public String getFechaTermino() {
		return fechaFin;
	}
	public void setFechaTermino(String fechaTermino) {
		this.fechaFin = fechaTermino.replace("\"", "");
	}
	public JsonArray getRecibidas() {
		return fechas;
	}
	public void setRecibidas(JsonArray recibidas) {
		this.fechas = recibidas;
	}
	public ArrayList<String> getFaltantes() {
		return fechasFaltantes;
	}
	public void setFaltantes(ArrayList<Date> faltantes) {
		
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
		for(Date fecha:faltantes){
			fechasFaltantes.add(formateador.format(fecha));
		}
	}
	
	
}
