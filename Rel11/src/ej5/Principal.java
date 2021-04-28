package ej5;

import java.util.ArrayList;
import java.util.LinkedList;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<String> arrayString=new ArrayList<String>();
		ArrayList<String> invertido;
		
		arrayString.add("Sevilla");
		arrayString.add("Cordoba");
		arrayString.add("Malaga");
		arrayString.add("Granada");
		
		invertido=reverse(arrayString);
		for (String cadena : invertido) {
			System.out.println(cadena);
		}
		
		ArrayList<Integer> arrayEnteros=new ArrayList<Integer>();
		ArrayList<Integer> invertidoEnteros;
		
		arrayEnteros.add(44);
		arrayEnteros.add(55);
		arrayEnteros.add(33);
		arrayEnteros.add(22);
		
		invertidoEnteros=reverse(arrayEnteros);
		for (int entero : invertidoEnteros) {
			System.out.println(entero);
		}
		
	}

	public static <T>  ArrayList<T> reverse ( ArrayList<T>  original){
		
		ArrayList<T> arrayListInvertido=new ArrayList<T>();
		T elemento;
		
		for(int i=original.size()-1; i >=0; i--) {
			elemento = original.get(i);
			
			arrayListInvertido.add(elemento);
		}
	
		
		
		return arrayListInvertido;
		
	}
	
	public static <T>  LinkedList<T> reverse ( LinkedList<T>  original){
		
		LinkedList<T> linkedListInvetido=new LinkedList<T>();

		for (T elemento : original) {
			linkedListInvetido.add(0, elemento);
		}
				
		
		return linkedListInvetido;
		
	}
}
