package died.guia06;

import java.util.List;


public class Alumno extends Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public String getNombre() {
		return nombre;
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