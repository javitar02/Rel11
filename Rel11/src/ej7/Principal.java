package ej7;

import java.util.Scanner;

public class Principal {
	private static Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
		Mercadona mercadona=new Mercadona();
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
	
	
	
	private static void tratarMenu(int opc, Mercadona mercadona) {

		switch (opc) {
		case 1:
			
			break;
		case 2:
			
			
			
			break;
		case 3:
			
			
			
			break;
		case 4:
			
			break;
		}
	}
	}
