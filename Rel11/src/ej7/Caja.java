package ej7;
import java.util.LinkedList;


public class Caja{

	private int numeroCaja;
	private boolean estaAbierta;
	private LinkedList<Integer>colaCliente;
	
	public Caja(int numeroCaja) {

		this.numeroCaja=numeroCaja;
		estaAbierta=false;
		colaCliente=new LinkedList<Integer>();
	}

	public int getNumeroCaja() {
		return numeroCaja;
	}

	public boolean isEstaAbierta() {
		return estaAbierta;
	}

	private void setEstaAbierta(boolean estaAbierta) {
		this.estaAbierta = estaAbierta;
	}
	
	public void abrirCaja() throws CajaException {
		
		if ( estaAbierta) {
			throw new CajaException("La caja ya está abierta");
		}
		estaAbierta=true;
	}

	public void cerrarCaja() throws CajaException {
		
		if ( !estaAbierta) {
			throw new CajaException("La caja ya está cerrada");
		}
		if (colaCliente.size() > 0) { 
			throw new CajaException("No se puede cerrar esta caja porque tiene clientes");
		}
		estaAbierta=false;
	}
	
	public int tamannoColaCliente(){
		
		return colaCliente.size();
	}
	
	public void agregarNuevoClienteCaja(Integer cliente) throws CajaException{
	
		//Si la caja está cerrada no se puede
		if ( !estaAbierta) {
			throw new CajaException("No se puede agregar el cliente porque la caja está cerrada");
		}
		//Lo añade al final
		colaCliente.add(cliente);
	}
	/**
	 * Borra de la cola el cliente que se atiende
	 * @return El número de cliente que se atiende
	 * @throws CajaException
	 */
	public Integer atenderCliente() throws CajaException {
		
		Integer cliente;
		if ( !estaAbierta) {
			throw new CajaException("No se puede atender porque la está vacía");
		}
		if ( colaCliente.isEmpty()) {
			throw new CajaException("No se puede atender porque no hay clientes");
		}
		
		cliente= colaCliente.get(0); // getFist
		colaCliente.remove(0); //removeFist
		
	
//		//También valdría int clienteAtendido = colaCliente.remove();
		
		return cliente;
		
	}

	@Override
	public String toString() {
		return "Caja [numeroCaja=" + numeroCaja + ", estaAbierta=" + estaAbierta + "]";
	}
	
	

	

	
	
	
	
	
}
