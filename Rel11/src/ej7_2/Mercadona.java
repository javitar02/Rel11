package ej7_2;

import java.util.ArrayList;

public class Mercadona {
	public static final int NUM_CAJAS = 10;
	
	private ArrayList<Caja> cajas;
	private int numeroAsignadoCliente;
	
	public Mercadona() throws MercadonaException {
		cajas=new ArrayList<>();
		
		for (Caja caja : cajas) {
			cajas.add(caja);
		}
	}
	
	
	public void abrirCaja(Caja caja)throws MercadonaException {
		
		if(cajas.contains(caja.isAbierta()==true)) {
			
		}
		
		
	}
	
	public void cerrarCaja(int numCaja)throws MercadonaException {

	}
	
	public String annadirCliente() throws MercadonaException{
		Integer cliente=numeroAsignadoCliente;
		numeroAsignadoCliente++;
		int cajaConMenosClientes=-1;
		int minimoPersonas=Integer.MAX_VALUE;
		
		if(cajaConMenosClientes==-1) {
			throw new MercadonaException("Error, todas las cajas estan cerradas. Espere a que se abra una");
		}
		
		for (int i = 0; i < cajas.length; i++) {
			if(cajas[i].isAbierta()==false) {
				throw new MercadonaException("Error, todas las cajas estan cerradas");
			}
		}
		
		for (int i = 0; i < cajas.length; i++) {
			if(cajas[i].isAbierta()==true && cajas[i].numClientesEsperando()<minimoPersonas) {
				minimoPersonas=cajas[i].numClientesEsperando();
				cajaConMenosClientes=i;
			}
		}
		cajas[cajaConMenosClientes].annadirNuevoCliente(cliente);
		return "Es usted el cliente "+cliente+ "y debe de ir a la caja "+cajaConMenosClientes;
	}
	
	public void atenderCliente(int numCaja) throws MercadonaException{
		int j;
		
		for ( j = 0; j < cajas.length; j++) {
			if (cajas[j].isAbierta()==false) {
				throw new MercadonaException("Error, no esta abierta la caja "+cajas[j].getNumeroCaja());
			}
			
		}
		
	}
	
	
}

