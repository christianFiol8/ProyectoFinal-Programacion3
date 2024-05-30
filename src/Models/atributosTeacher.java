package Models;

public class atributosTeacher {
	
	private String docentesId, apellidoPaterno,  apellidoMaterno,  nombre,  nacimiento,  email,  estudios,  telefono;

	public atributosTeacher(String docentesId, String apellidoPaterno, String apellidoMaterno, String nombre, String nacimiento, String email, String estudios, String telefono) {
		// TODO Auto-generated constructor stub
		
		this.docentesId=docentesId;
		this.apellidoPaterno=apellidoPaterno;
		this.apellidoMaterno=apellidoMaterno;
		this.nombre=nombre;
		this.nacimiento=nacimiento;
		this.email=email;
		this.estudios=estudios;
		this.telefono=telefono;
	}

	public String getDocentesId() {
		return docentesId;
	}

	public void setDocentesId(String docentesId) {
		this.docentesId = docentesId;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstudios() {
		return estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
