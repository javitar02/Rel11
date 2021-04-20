package ej6;

import java.util.*;

public class Diccionario {

	//Atributos
	private HashMap<String, EntradaDiccionario> entradas;

	public Diccionario() {
		
		this.entradas = new HashMap<String, EntradaDiccionario>();
	}
	
	public void annadirPalabra(String palabra, String significado) {
		
		EntradaDiccionario entradaRecogida = this.entradas.get(palabra);
		EntradaDiccionario entradaNueva;
		
		//Significa que estaba esta entrada
		if(entradaRecogida != null) {
			entradaRecogida.annadirSignificado(significado);
		}else {
			//Significa que no esta la palabra
			entradaNueva = new EntradaDiccionario(palabra, significado);
			this.entradas.put(palabra, entradaNueva);
		}
		
	}
	
	
	public String buscarPalabra(String palabraABuscar) throws DiccionarioException {
		EntradaDiccionario entradaEncontrada;
		entradaEncontrada=entradas.get(palabraABuscar);
		if(entradaEncontrada==null) {
			throw new DiccionarioException("No se encuentra la palabra");
		}
		return entradaEncontrada.toString();
	}
	
	public void borrarPalabra(String palabraABorrar) throws DiccionarioException {
		EntradaDiccionario entradaBorrada;
		entradaBorrada=entradas.remove(palabraABorrar);
		if ( entradaBorrada==null)
			throw new DiccionarioException("No se ha encontrado la palabra " + palabraABorrar);
		
		
	}
	
	public String listadoDePalabrasQueEmpiezanPor(String comienzo) throws DiccionarioException {
		
		ArrayList<EntradaDiccionario> arrayEntradas=
				new ArrayList<EntradaDiccionario> ( );
		StringBuilder sb=new StringBuilder();
		
		for (EntradaDiccionario entradaDiccionario : entradas.values()) {
			if ( entradaDiccionario.getPalabra().startsWith(comienzo)) {
				arrayEntradas.add(entradaDiccionario);
			}	
		}
		
		if ( arrayEntradas.isEmpty()) {
			throw new DiccionarioException("No existen entradas que empiecen por " + comienzo);
		}
		
		Collections.sort(arrayEntradas);
		
		for (EntradaDiccionario entradaDiccionario : arrayEntradas) {
			sb.append(entradaDiccionario);
			sb.append("\n");
			
		}
		
		return sb.toString();
		
		
		
	}
}
