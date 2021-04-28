package ej7_2;

import java.util.Scanner;

public class Principal {
	private static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) throws MercadonaException {
		Mercadona mercadona=new Mercadona(6);
		int opc;
	
		
		do {
			opc=mostrarMenu();
			tratarMenu( opc, mercadona);
		}while (opc!= 5);

	}

	private static int mostrarMenu() {
		int opcion;
		
		System.out.println("BIENVENIDO AL MENU");
		System.out.println("1.Abrir caja");
		System.out.println("2.Cerrar caja");
		System.out.println("3.Nuevo cliente");
		System.out.println("4.Atender nuevo cliente");
		System.out.println("5.Salir");
		
		System.out.println("Introduce una opcion entre 1 y 5: ");
		opcion=Integer.parseInt(teclado.nextLine());
		
		return opcion;
	}
	
	
	
	private static void tratarMenu(int opc, Mercadona mercadona) throws MercadonaException {
		int numCaja;
		switch (opc) {
		case 1:
			numCaja=solicitarNumeroCaja();
			mercadona.abrirCaja(numCaja);
			break;
		case 2:
			numCaja=solicitarNumeroCaja();
			mercadona.cerrarCaja(numCaja);
			break;
		case 3:
			mercadona.annadirCliente();
			break;
		case 4:
			numCaja=solicitarNumeroCaja();
			mercadona.atenderCliente(numCaja);
			break;
		}
	}

	private static int solicitarNumeroCaja() {
		int numCaja;
		
		System.out.println("Introduce un numero entre 1 y "+Mercadona.NUM_CAJAS);
		numCaja=Integer.parseInt(teclado.nextLine());
		
		return numCaja;
	}
	}
