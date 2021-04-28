package ej7_2;

import java.util.LinkedList;

public class Caja {

	private int numeroCaja;
	private boolean abierta;
	private LinkedList<Integer> cola;
	
	private static int ultimoNumero=0; 
	
	public Caja(int numeroCaja) throws MercadonaException {
		ultimoNumero++;
		numeroCaja=ultimoNumero;
		this.abierta=false;
		cola=new LinkedList<Integer>();
		
	}

	public int getNumeroCaja() {
		return numeroCaja;
	}

	public boolean isAbierta() {
		return abierta;
	}

	public void setAbierta(boolean abierta) {
		this.abierta = abierta;
	}

	public static int getUltimoNumero() {
		return ultimoNumero;
	}

	public static void setUltimoNumero(int ultimoNumero) {
		Caja.ultimoNumero = ultimoNumero;
	}
	
	public int clienteAtendido() {
		return numeroCaja;
	}
	
	public int numClientesEsperando() {
		return cola.size();
	}
	
	public void annadirNuevoCliente (Integer cliente) throws MercadonaException{		
		cola.add(cliente);
	}	
}
