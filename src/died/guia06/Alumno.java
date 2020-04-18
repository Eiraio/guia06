package died.guia06;

import java.util.List;


public class Alumno extends Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public Alumno(String nombre, Integer nroLibreta, List<Curso> cursando, List<Curso> aprobados) {
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = cursando;
		this.aprobados = aprobados;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public int creditosObtenidos() {
		return 1;
	}

	public void aprobar(Curso c) {
		//
	}

	public void inscripcionAceptada(Curso c) {
		//
	}

	public Boolean equals(Alumno alumno){
		if(this.nroLibreta == alumno.nroLibreta) return true;
		return false;
	}

	@Override
	public int compareTo(Alumno a){
		return (int) (this.nombre.compareTo(a.getNombre()));
	}



}