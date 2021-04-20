package ej2;
import java.util.*;

public class Equipo<T> {
	
	private String nombreEquipo;
	private HashSet<T> conjuntoMiembros;

	public Equipo(String nombre) {

		setNombreEquipo(nombre);
		conjuntoMiembros = new HashSet<T>();
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	
	
	public void insertarMiembro(T nuevoMiembro) throws EquipoException {

		
		if (conjuntoMiembros.contains(nuevoMiembro))
			throw new EquipoException("Ese miembro ya está en el equipo");

		conjuntoMiembros.add(nuevoMiembro);
	}

	public void borrarMiembro(T miembroABorrar) throws EquipoException {

		if (!conjuntoMiembros.contains(miembroABorrar))
			throw new EquipoException("No se puede borrar. Ese miembro no está en el equipo");
		conjuntoMiembros.remove(miembroABorrar);
	}
	
	public T buscarMiembro(T miembroBuscado){
		
		T miembroEncontrado=null;
		boolean encontrado =false;
		T miembro;
		
		Iterator<T> iterator= conjuntoMiembros.iterator();
		while(iterator.hasNext() && !encontrado){
			
			miembro=iterator.next();
			if(miembro.equals(miembroBuscado)){
				miembroEncontrado=miembro;
				encontrado=true;
			}		
		}
		return miembroEncontrado;
	}
	

	/**
	 * Devuelve una cadena con el listado de los Alumnos
	 * 
	 * @return Cadena con el listado de Alumnos
	 */
	public String listadoDeMiembros() {
		StringBuilder cadena = new StringBuilder(conjuntoMiembros.size() * 20);

		for (T a : conjuntoMiembros) {

			cadena.append(a + "\n");
		}
		return cadena.toString();
	}

	/**
	 * Une mi equipo con otro, devolviendo el nuevo equipo creado
	 * 
	 * @param otro
	 *            Otro equipo que se va a unir
	 * @param nombre
	 *            Nombre del nuevo equipo
	 * @return nuevo equipo resultado de unir los dos anteriores
	 */
	public Equipo<T> fusionDeEquipos(Equipo<T> otro, String nombre) {
		Equipo<T> nuevoEquipo;

		nuevoEquipo = new Equipo<T>(nombre);

		for (T a : conjuntoMiembros) {
			try {
				nuevoEquipo.insertarMiembro(a);
			} catch (EquipoException e) {
				// No se va a dar
			}
		}
		for (T a : otro.conjuntoMiembros) {
			try {
				nuevoEquipo.insertarMiembro(a);
			} catch (EquipoException e) {
				//Si se da, es que está ya en el conjunto 
				// no hay que hacer nada
			}
		}

		return nuevoEquipo;

	}

	/**
	 * Crea un nuevo equipo con los elementos que est�n en los dos equipos (this
	 * y otro)
	 * 
	 * @param otro
	 *            Otro equipo
	 * @param nombre
	 *            Nombre del nuevo equipo intersecci�n
	 * @return Equipo resultado de la interseccion
	 */
	public Equipo<T> intersecionDeEquipos(Equipo<T> otro, String nombre) {
		Equipo<T> nuevoEquipo;

		nuevoEquipo = new Equipo<T>(nombre);

		for (T a : conjuntoMiembros) {

			if (otro.conjuntoMiembros.contains(a)) {

				try {
					nuevoEquipo.insertarMiembro(a);
				} catch (EquipoException e) {
					// Nunca se va a dar
				}

			}
		}

		return nuevoEquipo;

	}

	@Override
	public String toString() {
		return "Nombre Equipo: " + nombreEquipo + "\nMiembros:\n" + listadoDeMiembros();
	}
	

}
