package ej2;
public class PrincipalParaInteger {

	public static void main(String[] args) {
		Equipo<Integer> equipo1, equipo2, equipo3, equipoFusionado, equipoInterseccion;

		try {
			equipo1 = new Equipo<Integer>("Equipo 1");
			equipo2 = new Equipo<Integer>("Equipo 2");
			equipo3 = new Equipo<Integer>("Equipo 3");

			equipo1 = crearEquipo1(equipo1);
			equipo2 = crearEquipo2(equipo2);
			equipo3 = crearEquipo3(equipo3);

			equipo1.borrarMiembro(new Integer(1));

			System.out.println(equipo1);
			System.out.println(equipo2);
			System.out.println(equipo3);

			equipoFusionado = equipo1.fusionDeEquipos(equipo2, "Equipo 1 unido 2");

			equipoInterseccion = equipo3.intersecionDeEquipos(equipo2, "Equipo 3 intersecci�n 2");

			System.out.println(equipoFusionado);
			System.out.println(equipoInterseccion);
		} catch (EquipoException e) {
			System.out.println(e.getMessage());
		}

	}

	private static Equipo<Integer> crearEquipo1(Equipo<Integer> equipo1) {
		Integer nuevoEntero;
		try {
			nuevoEntero = new Integer(1);
			equipo1.insertarMiembro(nuevoEntero);

			nuevoEntero = new Integer(2);
			equipo1.insertarMiembro(nuevoEntero);
			nuevoEntero = new Integer(3);
			equipo1.insertarMiembro(nuevoEntero);
			nuevoEntero = new Integer(4);
			equipo1.insertarMiembro(nuevoEntero);

			// Este no va a entrar
			nuevoEntero = new Integer(1);
			equipo1.insertarMiembro(nuevoEntero);
		} catch (EquipoException e) {
			System.out.println(e.getMessage());
		}

		return equipo1;
	}

	private static Equipo<Integer> crearEquipo2(Equipo<Integer> equipo2) {
		Integer nuevoEntero;
		try {
			nuevoEntero = new Integer(5);
			equipo2.insertarMiembro(nuevoEntero);

			nuevoEntero = new Integer(6);
			equipo2.insertarMiembro(nuevoEntero);
			nuevoEntero = new Integer(4);
			equipo2.insertarMiembro(nuevoEntero);
			nuevoEntero = new Integer(3);
			equipo2.insertarMiembro(nuevoEntero);

			
		} catch (EquipoException e) {
			System.out.println(e.getMessage());
		}
		return equipo2;
	}

	private static Equipo<Integer> crearEquipo3(Equipo<Integer> equipo3) {
		
			Integer nuevoEntero;
			try {
				nuevoEntero = new Integer(6);
				equipo3.insertarMiembro(nuevoEntero);

				nuevoEntero = new Integer(12);
				equipo3.insertarMiembro(nuevoEntero);
				nuevoEntero = new Integer(13);
				equipo3.insertarMiembro(nuevoEntero);
				nuevoEntero = new Integer(4);
				equipo3.insertarMiembro(nuevoEntero);

				
			} catch (EquipoException e) {
				System.out.println(e.getMessage());
			}

		return equipo3;
	}

}
