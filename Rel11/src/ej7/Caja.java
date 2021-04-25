package ej7;

import java.util.LinkedList;

public class Caja {

	private int numeroCaja;
	private boolean abierta;
	private LinkedList<Integer> cola;
	
	private static int ultimoNumero=0; 
	
	public Caja(int numeroCaja) throws MercadonaException {
		this.numeroCaja=numeroCaja;
		this.abierta=false;
		this.numeroCaja=numeroCaja;
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
	
	public void annadirCliente(int numCliente) {
		cola.add(numCliente);
	}
	
	
	
	
	
	
	
	
	
	
	
}
