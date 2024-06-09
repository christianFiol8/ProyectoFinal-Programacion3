package Models;

public class atributosSubject {

	public String nombre, docente, descripcion;
	
	
	public atributosSubject(String nombre, String docente, String descripcion) {
		// TODO Auto-generated constructor stub
		
		this.nombre=nombre;
		this.docente=docente;
		this.descripcion=descripcion;
		
		
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


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	
	

}
