package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

    private Integer id;
    private String nombre;
    private Integer cicloLectivo;
    private Integer cupo;
    private List<Alumno> inscriptos;
    private Integer creditos;
    private Integer creditosRequeridos;

    private Registro log;

    public Curso() {
        super();
        this.inscriptos = new ArrayList<Alumno>();
        this.log = new Registro();
    }

    public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo, List<Alumno> inscriptos, Integer creditos, Integer creditosRequeridos) {
        this.id = id;
        this.nombre = nombre;
        this.cicloLectivo = cicloLectivo;
        this.cupo = cupo;
        this.inscriptos = inscriptos;
        this.creditos = creditos;
        this.creditosRequeridos = creditosRequeridos;
    }

    /**
     * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
     * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
     * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
     * de cursos en los que el alumno está inscripto.
     *
     * Para poder inscribirse un alumno debe
     * 		a) tener como minimo los creditos necesarios
     *      b) tener cupo disponibles
     *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
     * @param a
     * @return
     */
    public Boolean inscribir(Alumno a) {
        try{
            log.registrar(this, "inscribir ",a.toString());
        } catch (IOException){
            System.out.println("Error en el log al inscribir");
        }
        return false;
    }


    /**
     * imprime los inscriptos en orden alfabetico
     */
    public void imprimirInscriptosAlfabeticamente() {
        try {
            log.registrar(this, "imprimir listado", this.inscriptos.size() + " registros ");
        } catch (IOException){
            System.out.println("Error en el registro");
        }
        Collections.sort(this.inscriptos);
        for(int i=0; i<this.inscriptos.size(); i++) {
            System.out.println(this.inscriptos.get(i).toString());
        }

    }
    /**
     * imprime los inscriptos por número de libreta
     */
    public void imprimirInscriptosNroLibreta() {
        try {
            log.registrar(this, "imprimir listado", this.inscriptos.size() + " registros ");
        } catch (IOException){
            System.out.println("Error en el registro");
        }
        Collections.sort(this.inscriptos,
                new Comparator<Alumno>() {
                    @Override
                    public int compare(Alumno alumno1, Alumno alumno2) {
                        return alumno2.getNroLibreta() - (alumno1.getNroLibreta());
                    }
                }
        );
        for(int i=0; i<this.inscriptos.size(); i++) {
            System.out.println(this.inscriptos.get(i).toString());
        }
    }

    /**
     * imprime los inscriptos por cantidad de créditos obtenidos
     */
    public void imprimirInscriptosCreditos() {
        try {
            log.registrar(this, "imprimir listado", this.inscriptos.size() + " registros ");
        } catch (IOException){
            System.out.println("Error en el registro");
        }
        Collections.sort(this.inscriptos,
                new Comparator<Alumno>() {
                    @Override
                    public int compare(Alumno alumno1, Alumno alumno2) {
                        return alumno2.creditosObtenidos() - (alumno1.creditosObtenidos());
                    }
                }
        );
        for(int i=0; i<this.inscriptos.size(); i++) {
            System.out.println(this.inscriptos.get(i).toString());
        }
    }

}