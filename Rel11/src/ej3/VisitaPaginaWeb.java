package ej3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class VisitaPaginaWeb implements Comparable<VisitaPaginaWeb> {
	
	private String direccion;
	
	private LocalDateTime fechaHora;

	public VisitaPaginaWeb(String direccion) throws VisitaPaginaWebException {

		this.direccion=direccion;
		fechaHora = LocalDateTime.now();
	}

	


	public String getDireccion() {
		return direccion;
	}

	
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
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
		VisitaPaginaWeb other = (VisitaPaginaWeb) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		return true;
	}




	public int compareTo(VisitaPaginaWeb otro) {
		
		return this.getFechaHora().compareTo(otro.getFechaHora());
	}

	@Override
	public String toString() {
		DateTimeFormatter df = 
				DateTimeFormatter.ofPattern("dd/MM/uuuu hh:mm");
		
		return "PaginaWeb: " + direccion + " visitada en "  + df.format(fechaHora);
	}

}
