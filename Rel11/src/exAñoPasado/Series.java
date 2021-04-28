package exA�oPasado;
import java.util.HashMap;

public class Series {

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
		if(!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("Error, serie no encontrada con el nombre "+nombreSerie);
		}
		
		return mapSeries.value;
	}
	
	
	
	/** Modifica el tema de una serie. Si no se encuentra la serie o ya tenía ese tema saltará la excepción. 
	 * 
	 * @param nombreSerie
	 * @param nuevoTema
	 * @throws SerieException
	 */
	public void modificarTema( String nombreSerie, Tema nuevoTema) throws SerieException {
		if(!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("Error, ")
		}
		
		
	}
	/* Devolverá un listado ordenado de forma creciente por el año de la serie. 
	 * Para cada serie se mostrará su nombre, año y número de temporadas. 
	 * Si no hay ninguna serie de ese tema saltará la excepción. (1,5 ptos)
	 */
	public  String listadoOrdenadoSeriesDeUnTema( Tema tema)  throws SerieException {
		return null;
	}
	
	
}
