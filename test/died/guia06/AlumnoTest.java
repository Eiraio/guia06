package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class AlumnoTest {

	Curso matematica = new Curso(1,"Matemática",2,3,null,20,0);

	@Test
	void testCreditosObtenidos() {
		Alumno alumno = new Alumno("Manuel", 1234,null, (List<Curso>) matematica);
		Integer obtenido = alumno.creditosObtenidos();
		Integer esperado = 20;
		assertEquals(obtenido,esperado);
	}

	@Test
	void testAprobar() {
		Alumno alumno = new Alumno("Manuel", 1234,(List<Curso>) matematica, null);
		alumno.aprobar(matematica);
		assertTrue(alumno.getAprobados().contains(matematica) && !alumno.getCursando().contains(matematica));
	}

	@Test
	void testInscripcionAceptada() {
		Curso matematica2 = new Curso(2,"Matemática 02",1,3,null,20,20);
		Alumno alumno = new Alumno("Manuel", 1234,null, (List<Curso>) matematica);
		alumno.inscripcionAceptada(matematica2);
		assertTrue(alumno.getCursando().contains(matematica2));
	}

	@Test
	void testInscripcionRechazada() {
		Curso matematica3 = new Curso(2,"Matemática 02",1,3,null,20,40);
		Alumno alumno = new Alumno("Manuel", 1234,null, (List<Curso>) matematica);
		alumno.inscripcionAceptada(matematica3);
		assertFalse(alumno.getCursando().contains(matematica3));
	}

}
