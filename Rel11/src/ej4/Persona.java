package ej4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Stream;

public abstract class Persona {
	
	private static final int EDAD_MINIMA = 12;
	
	// Atributos
	private String dni;
	private String nombre;
	private int edad;
	private LinkedList<Mensaje> mensajes;
	
	// Constructor
	public Persona(String dni,String nombre,int edad) throws IESException {
		this.dni=dni;
		this.nombre = nombre;
		mensajes=new LinkedList<Mensaje>();
		setEdad(edad);
	}

	// Métodos get y set
	public int getEdad() {
		return edad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	private void setEdad(int edad) throws IESException {
		if (edad < EDAD_MINIMA)
			throw new IESException("La edad minima es de" + EDAD_MINIMA);
		this.edad = edad;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
		
	public void enviarCorreo(String msg, Persona personaDestinatario) throws IESException{
		
		Mensaje mensaje=new Mensaje(this, msg);
		
		// Añadir a la primera posición, para que el primer mensaje sea el más reciente
		personaDestinatario.mensajes.add(0,mensaje);
	}
	
	public String mostrarMensajes() throws IESException{
		StringBuilder cadenaMensajes=new StringBuilder();
		int numeroMensaje=1;
		
		
		if (mensajes.size()== 0)
			throw new IESException("No tiene mensajes en su buzon");
		
		//Solución con lambda
		
//		mensajes.stream()
//		.sorted((mensaje1,mensaje2)-> 
//			  {return mensaje1.getHora().compareTo( mensaje2.getHora());})
//		.forEach(mensaje -> {cadenaMensajes.append(mensaje + "\n");});
		
		//Ya están ordenados por hora
		for( Mensaje mensaje: mensajes) {
			cadenaMensajes.append(numeroMensaje + " " + mensaje + "\n");
			numeroMensaje++;
		}
			

		return cadenaMensajes.toString();
	}
	
	/**
	 * 
	 * @param numeroMensaje De 1 en adelante
	 * @throws IESException 
	 */
	public void borrarMensaje( int numeroMensaje) throws IESException{
		
		if (numeroMensaje <= 0 || numeroMensaje > mensajes.size()){
			throw new IESException("No existe el mensaje " + numeroMensaje + " .No se puede borrar");
		}
		
		mensajes.remove(numeroMensaje-1);
		
	}
	
	
	public String mostrarMensajesOrdenadosPorRemitente()throws IESException{
		StringBuilder cadenaMensajes=new StringBuilder();
		
		
		if (mensajes.size()== 0)
			throw new IESException("No tiene mensajes en su buzon");
		
		ArrayList<Mensaje> mensajesOrdenados=new ArrayList<Mensaje>( mensajes);
		Collections.sort(mensajes);
		for (Mensaje mensaje:mensajes) {
			cadenaMensajes.append(mensaje + "\n");
		}
		
		//Solución con lambda
//		mensajes.stream()
//		.sorted((mensaje1,mensaje2)-> 
//			  {return mensaje1.getRemitente().getNombre().compareTo( mensaje2.getRemitente().getNombre());})
//		.forEach(mensaje -> {cadenaMensajes.append(mensaje + "\n");});
	
		return cadenaMensajes.toString();
	}	
	
	
	public String buscarMensajesConTexto( String texto) throws IESException{
		
		
		StringBuilder cadenaMensajes=new StringBuilder();
		
		//Solución con lambda
		
//		Stream<Mensaje> streamMensajes= mensajes.stream();
//		
//		streamMensajes
//		.filter(mensaje -> mensaje.getTexto().contains(texto))
//		.forEach(mensaje -> {cadenaMensajes.append(mensaje + "\n");});
		
		
		for (Mensaje mensaje: mensajes) {
			if ( mensaje.getTexto().contains(texto)) {
				cadenaMensajes.append(mensaje + "\n");
			}
		}

		
		if (cadenaMensajes.length() ==0){
			throw new IESException("No hay mensajes con el texto" + texto);
		}
		
		return cadenaMensajes.toString();
	}
}
