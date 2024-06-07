package Models;

public class AtributosGroup {
	
	private String nombre, docente, letraDeGrupo,alumnos;

	public AtributosGroup(String nombre,String docente, String letraDeGrupo,String alumnos) {
		// TODO Auto-generated constructor stub
		this.nombre=nombre;
		this.docente=docente;
		this.letraDeGrupo=letraDeGrupo;
		this.alumnos=alumnos;
		
	}

	public String getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(String alumnos) {
		this.alumnos = alumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public String getLetraDeGrupo() {
		return letraDeGrupo;
	}

	public void setLetraDeGrupo(String letraDeGrupo) {
		this.letraDeGrupo = letraDeGrupo;
	}

}
