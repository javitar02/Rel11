package ej8;

import java.util.HashSet;
import java.util.LinkedList;

public class Receta implements Comparable <Receta>{
	private String nombreReceta;
	private int minutosDePreparacion;
	private HashSet<Ingrediente> ingredientes;
	private LinkedList<String> pasos;
	
	public Receta(String nombreReceta, int minutosPreparacion) throws RecetaException {
		this.nombreReceta = nombreReceta.toUpperCase();
		setMinutosDePreparacion(minutosPreparacion);
		ingredientes=new HashSet<Ingrediente>();
		pasos=new LinkedList<String>();
	}

	public int getMinutosDePreparacion() {
		return minutosDePreparacion;
	}

	public void setMinutosDePreparacion(int minutosDePreparacion) throws RecetaException {
		if (minutosDePreparacion <=0) {
			throw new RecetaException("Minutos incorrectos");
		}
		this.minutosDePreparacion = minutosDePreparacion;
	}

	public String getNombreReceta() {
		return nombreReceta;
	}
	
	public void annadirPasoAlFinal(String paso) {
		pasos.add(paso.toUpperCase());
	}

	public void annadirIngrediente(Ingrediente ingredienteNuevo) {
		int cantidadNueva=ingredienteNuevo.getCantidad();
		if(ingredientes.contains(ingredienteNuevo)) {
			cantidadNueva++;
			ingredienteNuevo.setCantidad(cantidadNueva);
		}
		ingredientes.add(ingredienteNuevo);
	}
	
	public boolean necesitaIngrediente(String nombreIngrediente) {
		boolean necesario=false;
		
		if(pasos.contains(nombreIngrediente)) {
			necesario=true;
		}
		
		return necesario;
	}
	
	public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException{
		if(!ingredientes.contains(ingredienteABorrar)) {
			throw new RecetaException("Error, ingrediente no encontrado ");
		}
		ingredientes.remove(ingredienteABorrar);
		if(pasos.contains(ingredienteABorrar.getNombreIngrediente())) {
			pasos.remove(ingredienteABorrar.getNombreIngrediente());
		}
	}
	

	public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException{
		if(!pasos.contains(pasoExistente)) {
			throw new RecetaException("Error, no se encuentra el paso ");
		}
			int pos=pasos.indexOf(pasoExistente);
			pasos.add(pos, pasoNuevo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreReceta == null) ? 0 : nombreReceta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receta other = (Receta) obj;
		if (nombreReceta == null) {
			if (other.nombreReceta != null)
				return false;
		} else if (!nombreReceta.equals(other.nombreReceta))
			return false;
		return true;
	}

	@Override
	public int compareTo(Receta o) {
		
		return this.nombreReceta.compareTo(o.getNombreReceta());
	}
	
	
	
}
