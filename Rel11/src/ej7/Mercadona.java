package ej7;
public class Mercadona {
	private static final int NUM_CAJAS = 20;
	
	private Caja[]cajas;
	
	public Mercadona(Caja[] cajas) {
		cajas=new Caja[NUM_CAJAS];
		Caja caja = null;
		for (int i = 0; i < cajas.length; i++) {
			cajas[i]=caja;
		}
	}
	
	
	public void abrirCaja(int numCaja)throws MercadonaException {
		int i;
		boolean abierta=false;
		
		
		for (i = 0; i < cajas.length; i++) {
			abierta=cajas[i].isAbierta();
			
			if(abierta) {
				throw new MercadonaException("Error, la caja ya estaba abierta");
			}
			abierta=true;
		}
	}
	
	public void cerrarCaja(int numCaja)throws MercadonaException {
		boolean cerrada=false;
		
		for (int i = 0; i < cajas.length; i++) {
			if(cajas[i].getNumeroCaja()!=numCaja) {
				throw new MercadonaException("Error, caja no encontrada");
			}
			if(cerrada) {
				throw new MercadonaException("Error, ya esta cerrada esta caja");
			}
			if(cajas[i].)
		}
		
		
		
	}
	
	public void nuevoCliente(){
		int idCliente=(int) (Math.random()*100);
		int numCaja=0;
		Caja siguiente;
		int menor=Integer.MAX_VALUE;
		
		for (int i = 0; i < cajas.length; i++) {
			if(cajas[i].getNumeroCaja()<menor) {
				menor=i;
			}
			if(cajas[i].getNumeroCaja()==menor) {
				
			}
		}
		System.out.println("Es usted el cliente "+idCliente+ " y debe ir a la caja"+numCaja);
	}
	
	public void atenderCliente(int numCaja) throws MercadonaException{
		int j;
		
		for ( j = 0; j < cajas.length; j++) {
			if (cajas[j].isAbierta()==false || cajas[j].) {
				throw new MercadonaException("Error, no esta abierta la caja "+cajas[j].getNumeroCaja());
			}
			
		}
		
	}
	
	
	
}

