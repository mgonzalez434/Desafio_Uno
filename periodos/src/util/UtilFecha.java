package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.text.ParseException;

public class UtilFecha {

	public ArrayList <Date> calculoFecha(String fechaCreacion, String fechaFin, JsonArray fechas){

		ArrayList <Date> fechasArray=this.arregloFechas(fechaCreacion, fechaFin);
		
		for (int i = 0; i < fechas.size(); i++) {
		    JsonElement object = fechas.get(i);
		    String fechaAux=object.toString();
		    Date fecha = this.parseFecha(fechaAux);
		    fechasArray.remove(fecha);
		}
		return fechasArray; 
	}


	public Date parseFecha(String fecha)
	{
		fecha=fecha.replaceAll("\"", "");
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(fecha);
		} 
		catch (ParseException ex) 
		{
			System.out.println(ex);
		}
		return fechaDate;
	}
	public int parseFechaAnno(Date fecha)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		return Integer.parseInt(dateFormat.format(fecha));
	}
	public int parseFechaMes(Date fecha)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
		return Integer.parseInt(dateFormat.format(fecha));
	}
	public ArrayList <Date>  arregloFechas(String fechaCreacion, String fechaFin){		

		ArrayList <Date> fechasArray= new ArrayList<Date>();

		Date fechaC = this.parseFecha(fechaCreacion);
		Date fechaF = this.parseFecha(fechaFin);

		int annoC = this.parseFechaAnno(fechaC);
		int annoF = this.parseFechaAnno(fechaF);

		int mesC = this.parseFechaMes(fechaC);
		int mesF = this.parseFechaMes(fechaF);

		for(int i=annoC;i<=annoF;i++){
			if(i==annoF){
				for(int z=0;z<=mesF;z++){
					String mes= Integer.toString(z);
					String fechaAux=i+"-"+mes+"-"+"01";
					fechasArray.add(this.parseFecha(fechaAux));
				}
			}else{
				for(int z=mesC;z<13;z++){
					String mes= Integer.toString(z);
					String fechaAux=i+"-"+mes+"-"+"01";
					fechasArray.add(this.parseFecha(fechaAux));
				}
				mesC=01;
			}

		}
		return fechasArray;
	}

}

