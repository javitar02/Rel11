package ej3;

import java.time.LocalDate;
import java.util.*;

public class Historial {
	private ArrayList<VisitaPaginaWeb> historial;

	public Historial() {
		this.historial = new ArrayList<VisitaPaginaWeb>();
	}

	/**
	 * Añade una nueva entrada al historial
	 * @param visitaWeb
	 * @throws VisitaPaginaWebException Si la fecha hora
	 * de la nueva entrada es anterior a la última entrada
	 */
	public void annadirNuevaVisitaPaginaWeb(VisitaPaginaWeb visitaWeb) throws VisitaPaginaWebException {

		if (!esPosibleInsertarVisita(visitaWeb)) {
			throw new VisitaPaginaWebException("No puedes introducir una pagina con una fecha anterior a la ultima");
		}
		
		historial.add(visitaWeb);


	}

	/**
	 * 
	 * @param nueva
	 * @return true si la nueva visita tiene fecha posterior
	 * a la última y por tanto puede insertarse en el historial
	 * false en caso contrario
	 */
	private boolean esPosibleInsertarVisita(VisitaPaginaWeb nueva) {
		boolean correcto = true;
		VisitaPaginaWeb ultima;

		ultima = ultimaEntrada();
		if (ultima !=null){
			System.out.println("Resultado" + nueva.compareTo(ultima));
			if (nueva.compareTo(ultima) <= 0){
				correcto = false;
			}
		}

		return correcto;

	}

	/**
	 * Devuelve la última entrada de la coleccion
	 * @return null si la colección esta vacía y la
	 * ultima entrada en caso contrario
	 */
	private VisitaPaginaWeb ultimaEntrada() {
		int posicionUltimo;
		VisitaPaginaWeb ultima = null;

		posicionUltimo = historial.size() - 1;
		if (posicionUltimo >= 0) {
			ultima = historial.get(posicionUltimo);
		}
		return ultima;

	}
	
	
	
	
	
	

	public String consultarHistorialPorDia(LocalDate fecha) {

		StringBuilder sbHistorialPorDia = new StringBuilder();
		VisitaPaginaWeb paginaWeb;
		boolean impresionTerminada = false;
		int resultadoComparacion;

		Iterator<VisitaPaginaWeb> it = historial.iterator();

		while (it.hasNext() && !impresionTerminada) {
			paginaWeb = it.next();
			// Convierto el LocalDateTime en LocalDate para compararlo con la
			// fecha
			resultadoComparacion = paginaWeb.getFechaHora().toLocalDate().
					compareTo(fecha);
			if (resultadoComparacion == 0) {
				sbHistorialPorDia.append(paginaWeb + "\n");
			} else {
				if (resultadoComparacion >0) // si la fecha por la que
												// voy es mayor que la
												// que estoy buscando,
												// es que ya he
												// terminado. Esto busca la
												// eficiencia.
					impresionTerminada = true;
			}
		}

		if (sbHistorialPorDia.length() == 0)
			sbHistorialPorDia.append("No hay registros para el día " + fecha);

		return sbHistorialPorDia.toString();

	}

	public String toString() {
		StringBuilder historialCompleto = new StringBuilder();

		for (VisitaPaginaWeb pagina: historial) {
			historialCompleto.append(pagina + "\n");
		}
		
		if (historialCompleto.length() == 0)
			historialCompleto.append("Historial vacío");

		return historialCompleto.toString();
	}

	public void borrarHistorial() {

		historial.clear();

	}

}
