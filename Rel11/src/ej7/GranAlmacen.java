package ej7;

import java.util.Arrays;

public class GranAlmacen {

	private static final int MAXIMO_DE_CAJAS = 20;
	private static int numeroDeClientes=1;
	private Caja cajas[];
	
	
	public GranAlmacen() {
		
		cajas=new Caja[MAXIMO_DE_CAJAS];
		
		
		inicializarCajas();
	}

	private void inicializarCajas() {
		
		int i;
		
		for (i=0; i<cajas.length; i++){
			cajas[i]=new Caja((i+1));
		}
	}
	
	
	
	public void abrirCaja(int numeroCaja) throws CajaException{
		
		if ( numeroCaja <= 0 || numeroCaja > MAXIMO_DE_CAJAS  ) {
			throw new CajaException("No existe la caja " + numeroCaja);
		}
			
		cajas[numeroCaja-1].abrirCaja();
			
		
	}
	
	public void cerrarCaja(int numeroCaja) throws CajaException{
		if ( numeroCaja <= 0 || numeroCaja > MAXIMO_DE_CAJAS  ) {
			throw new CajaException("No existe la caja " + numeroCaja);
		}
			
		cajas[numeroCaja-1].cerrarCaja();
	
	}
	
	public String nuevoCliente() throws CajaException{
		int cajaDondeSeAtendera;
		
		cajaDondeSeAtendera=cajaMenosCliente();
		
		cajas[cajaDondeSeAtendera].agregarNuevoClienteCaja(numeroDeClientes);
		String info="Es usted el cliente " + numeroDeClientes+  " y se le atender� en la caja " +
				(cajaDondeSeAtendera +1);
		
		numeroDeClientes++;
		return info;
		
	}

	public int atenderCliente(int numeroCaja) throws CajaException{
		if ( numeroCaja <= 0 || numeroCaja > MAXIMO_DE_CAJAS  ) {
			throw new CajaException("No existe la caja " + numeroCaja);
		}
		
		return cajas[numeroCaja-1].atenderCliente();
		
		
	}
	
	

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < cajas.length; i++) {
			if ( cajas[i].isEstaAbierta()) {
				sb.append("Caja " + (i+1) + " tiene tantos clientes esperando " + cajas[i].tamannoColaCliente());
			}
		}
		
		return sb.toString();
	}

	/** 
	 * 
	 * @return Devuelve el número de caja que tiene menos clientes
	 * @throws CajaException Si todas las cajas están cerradas
	 */
	
	private int cajaMenosCliente() throws CajaException {
		int menorNumeroClientes=Integer.MAX_VALUE;
        int cajaConMenosClientes =0;
        boolean abierta=false;

        for (int i = 0; i < cajas.length; i++) {
            if(cajas[i].isEstaAbierta()) {
                abierta=true;
                if(cajas[i].tamannoColaCliente()<menorNumeroClientes) {
                    menorNumeroClientes=cajas[i].tamannoColaCliente();
                    cajaConMenosClientes=i;
                }
            }
        }
        if(!abierta) {
            throw new CajaException("Error.No hay cajas abiertas");
        }
        return cajaConMenosClientes;
	}

	
}
