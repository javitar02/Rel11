package ej8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import ej6.EntradaDiccionario;

public class Recetario {

	private HashMap<String, Receta> recetas;
	
	public Recetario() {
		recetas=new HashMap<String,Receta>();
	
	}
	
	public void annadirReceta( Receta nuevaReceta) throws RecetaException {
		if (!recetas.containsValue(nuevaReceta)) {
			throw new RecetaException("Error, receta no encontrada");
		}
		recetas.put(nuevaReceta.getNombreReceta(), nuevaReceta);
	}
	
	public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {
		ArrayList<Receta>arrayOrdenado=new ArrayList<Receta>();
		StringBuilder sb=new StringBuilder();
		
		for(Receta o:recetas.values()) {
			arrayOrdenado.add(o);
		}
		
		if(arrayOrdenado.size()==0) {
			throw new RecetaException("Error, no se encontro ninguna receta");
		}
		Collections.sort(arrayOrdenado);
		
		for(Receta e:arrayOrdenado) {
			sb.append(e);
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException{
		
	}
}
