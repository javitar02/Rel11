package exAñoPasado;

public class Principal {

	public static void main(String[] args) {
		
		
		try {
			Series netflix=new Series();
			
			Serie serie1=new Serie("BREAKING BAD",2000, Genero.INTRIGA);
			Temporada temporada1=new Temporada("Temporada 1");
			temporada1.annadirCapitulo("El primero");
			temporada1.annadirCapitulo("el segundo");
			
			Temporada temporada2=new Temporada("Temporada 2");
			temporada1.annadirCapitulo("El primero de la segunda");
			temporada1.annadirCapitulo("el segundo de la segunda");
			
			serie1.annadirTemporada(temporada1);
			serie1.annadirTemporada(temporada2);
			
			Serie serie2=new Serie("Friends",2000, Genero.COMEDIA);
			
			netflix.annadirSerie(serie1);
			netflix.annadirSerie(serie2);
			
			
			
		} catch (SerieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
