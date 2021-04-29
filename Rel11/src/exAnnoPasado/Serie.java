package exAnnoPasado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Serie implements Comparable<Serie>{
	private static final int ANNO_MINIMO = 1900;
	private String nombreSerie;
	private int anno;
	private Genero genero;
	private ArrayList<Temporada> temporadas;
	
	
	public Serie(String nombreSerie, int anno, Genero genero) throws SerieException {
		super();
		this.nombreSerie = nombreSerie;
		setAnno(anno);
		this.genero = genero;
		temporadas=new ArrayList<Temporada>();
	}
	/*
	Añade una nueva temporada. Se le pasará la temporada y se añadirá al final. 
	Debe comprobar que no existe un temporada con ese nombre en cuyo caso saltará la excepción.
	*/


	public void annadirTemporada(Temporada temporada) throws SerieException {
		
		if(!temporadas.contains(temporada)) {
			throw new SerieException("Error, temporada ya añadida");
		}
		temporadas.add(temporadas.size()-1,temporada);
		
	}
	
	/*
	 * Devuelve un listado de las temporadas de una serie ordenadas
	 *  de mayor a menor por nota media. De cada temporada se mostrará el nombre, número de capítulos y nota media
	 */
	public String listadoTemporadasPorNotaMedia() throws SerieException {
		ArrayList<Temporada>copia=new ArrayList<Temporada>(temporadas);
		StringBuilder sb=new StringBuilder();
		
		if(copia.size()==0) {
			throw new SerieException("Error, no se encuentra ninguna temporada");
		}
		
		for (Temporada temporada : copia) {
			copia.add(temporada);
		}
		Collections.sort(copia);
		
		for (Temporada temporada : copia) {
			sb.append(temporada.getNombreTemporada()+ " con "+temporada.getCapitulos()+" capitulos y cuya nota media es"+temporada.getNotaMedia());;
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	/*Devuelve un listado de las temporadas de una serie ordenadas de menor a mayor por número de capítulos.
	 *  De cada temporada se mostrará el nombre, número de capítulos y nota media.
	 */
	
	public String listadoTemporadasPorNumeroDeCapitulos() throws SerieException {
	ArrayList<Temporada>aux=new ArrayList<Temporada>();
		
		for (Temporada temporada : temporadas) {
			{
				aux.add(temporada);
			}
		}
		
		if(aux.size()==0) {
			throw new SerieException("Error, no se encontro ninguna serie");
		}
		
		Collections.sort(aux,new Comparator<Temporada>() {

			@Override
			public int compare(Temporada o1, Temporada o2) {
				
				return Integer.compare(o1.numCapitulos(),o2.numCapitulos());
			}
			
		});
		
		StringBuilder sb=new StringBuilder();
		
		for (Temporada temp: aux) {
			sb.append(temp);
			sb.append("\n");
			
		}
		
		return sb.toString();
	}

	public String getNombreSerie() {
		return nombreSerie;
	}


	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}


	public int getAnno() {
		return anno;
	}


	public void setAnno(int anno) throws SerieException {
		if ( anno < ANNO_MINIMO) {
			throw new SerieException("Anno incorrecto");
		}
		this.anno = anno;
	}


	public Genero getTema() {
		return genero;
	}


	public void setTema(Genero genero) {
		this.genero = genero;
	}
	
	public int numeroTemporadas() {
		return temporadas.size();
	}


	public String toString() {
		return  "Serie " + nombreSerie + " Anno " + anno + " Tema " + genero + "Numero temporadadas " + numeroTemporadas();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreSerie == null) ? 0 : nombreSerie.hashCode());
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
		Serie other = (Serie) obj;
		if (nombreSerie == null) {
			if (other.nombreSerie != null)
				return false;
		} else if (!nombreSerie.equals(other.nombreSerie))
			return false;
		return true;
	}
	@Override
	public int compareTo(Serie o) {
	
		return Integer.compare(this.numeroTemporadas(), o.numeroTemporadas());
	}


	
	
	
	
	
}
