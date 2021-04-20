package ej2;
public class PrincipalParaAlumno {

	public static void main(String[] args) {
		Equipo<Alumno> equipo1, equipo2, equipo3, equipoFusionado, equipoInterseccion;

		try {
			equipo1 = new Equipo<Alumno>("Equipo 1");
			equipo2 = new Equipo<Alumno>("Equipo 2");
			equipo3 = new Equipo<Alumno>("Equipo 3");

			equipo1 = crearEquipo1(equipo1);
			equipo2 = crearEquipo2(equipo2);
			equipo3 = crearEquipo3(equipo3);

			equipo1.borrarMiembro(new Alumno("1", "cualquiera"));

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

	private static Equipo<Alumno> crearEquipo1(Equipo<Alumno> equipo1) {
		Alumno nuevoAlumno;
		try {
			nuevoAlumno = new Alumno("1", "a");
			equipo1.insertarMiembro(nuevoAlumno);

			nuevoAlumno = new Alumno("2", "b");
			equipo1.insertarMiembro(nuevoAlumno);
			nuevoAlumno = new Alumno("3", "c");
			equipo1.insertarMiembro(nuevoAlumno);
			nuevoAlumno = new Alumno("4", "d");
			equipo1.insertarMiembro(nuevoAlumno);

			// Este no va a entrar
			nuevoAlumno = new Alumno("1", "Otro a");
			equipo1.insertarMiembro(nuevoAlumno);
		} catch (EquipoException e) {
			System.out.println(e.getMessage());
		}

		return equipo1;
	}

	private static Equipo<Alumno> crearEquipo2(Equipo<Alumno> equipo2) {
		Alumno nuevoAlumno;
		try {
			nuevoAlumno = new Alumno("5", "Alumno 5");
			equipo2.insertarMiembro(nuevoAlumno);
			nuevoAlumno = new Alumno("6", "Alumno 6");
			equipo2.insertarMiembro(nuevoAlumno);
			nuevoAlumno = new Alumno("4", "d");
			equipo2.insertarMiembro(nuevoAlumno);
			nuevoAlumno = new Alumno("3", "c");
			equipo2.insertarMiembro(nuevoAlumno);
		} catch (EquipoException e) {
			System.out.println(e.getMessage());
		}
		return equipo2;
	}

	private static Equipo<Alumno> crearEquipo3(Equipo<Alumno> equipo3) {
		Alumno nuevoAlumno;
		try {
			nuevoAlumno = new Alumno("6", "Alumno 6");
			equipo3.insertarMiembro(nuevoAlumno);
			nuevoAlumno = new Alumno("12", "Alumno 12");
			equipo3.insertarMiembro(nuevoAlumno);
			nuevoAlumno = new Alumno("13", "Alumno 13");
			equipo3.insertarMiembro(nuevoAlumno);
			nuevoAlumno = new Alumno("4", "d");
			equipo3.insertarMiembro(nuevoAlumno);
		} catch (EquipoException e) {
			System.out.println(e.getMessage());
		}

		return equipo3;
	}

}
