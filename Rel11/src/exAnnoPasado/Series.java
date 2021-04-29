package exAnnoPasado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class Series  {

	private HashMap<String, Serie> mapSeries;
	
	public Series() {
		mapSeries=new HashMap<String, Serie>();
	}
	
	public void annadirSerie(Serie serie) throws SerieException {
		if (mapSeries.containsKey(serie.getNombreSerie())) {
			throw new SerieException("Ya existe esa serie");
		}
		mapSeries.put(serie.getNombreSerie(), serie);
	}
	
	/*Devuelve el número de temporadas que tiene la serie que se pasa por parámetro. Si no existe la serie saltará la excepción.
	 * 
	 */
	
	public int numeroDeTemporadasDeUnaSerie(String nombreSerie) throws SerieException{
		Serie serie=mapSeries.get(nombreSerie);
		int numTemp=0;
		
		if(serie==null) {
			throw new SerieException("Error, serie no encontrada con el nombre "+nombreSerie);
		}else {
			numTemp=serie.numeroTemporadas();
		}
		
		return numTemp;
	}
	
	
	
	/** Modifica el tema de una serie. Si no se encuentra la serie o ya tenía ese tema saltará la excepción. 
	 * 
	 * @param nombreSerie
	 * @param nuevoTema
	 * @throws SerieException
	 */
	public void modificarGenero( String nombreSerie, Genero nuevoGenero) throws SerieException {
	
		
		if(mapSeries.get(nombreSerie).getTema().equals(nuevoGenero)) {
			throw new SerieException("Error, no se puede cambiar al genero que tenia antes");
		}
		
		if(!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("Error, no se encuentra la serie");
		}
		
		//SI SE HACE CON UNA VARIABLE INTERNA NO CAMBIA A LA SERIE DEL HASHMAP SI NO A LA
		//VARIABLE DEL METODO SOLO
		mapSeries.get(nombreSerie).setTema(nuevoGenero);
		
	}
	/* Devolverá un listado ordenado de forma creciente por el año de la serie. 
	 * Para cada serie se mostrará su nombre, año y número de temporadas. 
	 * Si no hay ninguna serie de ese tema saltará la excepción. (1,5 ptos)
	 */
	public  String listadoOrdenadoSeriesDeUnGenero( Genero Genero)  throws SerieException {
		ArrayList<Serie>aux=new ArrayList<Serie>();
		
		for (Serie serie : mapSeries.values()) {
			if(serie.getTema().equals(Genero)) {
				aux.add(serie);
			}
		}
		
		if(aux.size()==0) {
			throw new SerieException("Error, no se encontro ninguna serie");
		}
		
		Collections.sort(aux,new Comparator<Serie>() {

			@Override
			public int compare(Serie o1, Serie o2) {
				
				return Integer.compare(o1.getAnno(),o2.getAnno());
			}
			
		});
		
		StringBuilder sb=new StringBuilder();
		
		for (Serie serie2: aux) {
			sb.append(serie2);
			sb.append("\n");
			
		}
		
		return sb.toString();
	}
	
	
}
