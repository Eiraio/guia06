package died.guia06;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CursoTest {

    ArrayList<Alumno> vaciaAlumnos = new ArrayList<>();
    Curso matematica = new Curso(1,"Matemática",2,3,vaciaAlumnos,20,0);
    ArrayList<Curso> vacia = new ArrayList<>();
    ArrayList<Curso> llena = new ArrayList<>();

    @Test
    void inscribirPositivoTest() {
        llena.add(matematica);
        Alumno alumno = new Alumno("Manuel", 1234,vacia, llena);
        Curso matematica2 = new Curso(2,"Matemática 02",1,3,vaciaAlumnos,20,20);
        Boolean retorna = matematica2.inscribir(alumno);
        assertTrue(matematica2.getInscriptos().contains(alumno) && alumno.getCursando().contains(matematica2) && retorna);
    }

    @Test
    void inscribirNegativoTest() {
        llena.add(matematica);
        Alumno alumno = new Alumno("Manuel", 1234,vacia, llena);
        Curso matematica3 = new Curso(2,"Matemática 02",1,3,vaciaAlumnos,20,40);
        Boolean retorna = matematica3.inscribir(alumno);
        assertFalse(matematica3.getInscriptos().contains(alumno) || alumno.getCursando().contains(matematica3) || retorna);


    }

    @Test
    void imprimirInscriptosAlfabeticamenteTest() {
        Alumno alumno1 = new Alumno("Manuel", 3,vacia, llena);
        Alumno alumno2 = new Alumno("María", 4,vacia, llena);
        Alumno alumno3 = new Alumno("Juan", 2,vacia, llena);

        matematica.inscribir(alumno1);
        matematica.inscribir(alumno2);
        matematica.inscribir(alumno3);

        matematica.imprimirInscriptosAlfabeticamente();

    }

    @Test
    void imprimirInscriptosNroLibretaTest() {
        Alumno alumno1 = new Alumno("Manuel", 3,vacia, llena);
        Alumno alumno2 = new Alumno("María", 4,vacia, llena);
        Alumno alumno3 = new Alumno("Juan", 2,vacia, llena);

        matematica.inscribir(alumno1);
        matematica.inscribir(alumno2);
        matematica.inscribir(alumno3);

        matematica.imprimirInscriptosNroLibreta();
    }


    @Test
    void imprimirInscriptosCreditosTest() {

        Curso lengua = new Curso(4,"Lengua",2,3,vaciaAlumnos,10,0);
        Curso ciencias = new Curso(5,"Ciencias",2,3,vaciaAlumnos,30,0);

        Alumno alumno1 = new Alumno("Manuel", 3,vacia, llena);
        ArrayList<Curso> llena2 = new ArrayList<>();
        llena2.add(lengua);
        llena2.add(matematica);
        Alumno alumno2 = new Alumno("María", 4,vacia, llena2);
        ArrayList<Curso> llena3 = new ArrayList<>();
        llena3.add(lengua);
        llena3.add(matematica);
        llena3.add(ciencias);
        Alumno alumno3 = new Alumno("Juan", 2,vacia, llena3);

        matematica.inscribir(alumno1);
        matematica.inscribir(alumno3);
        matematica.inscribir(alumno2);

        matematica.imprimirInscriptosCreditos();
    }
}