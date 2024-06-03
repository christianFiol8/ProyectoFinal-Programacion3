package Controllers;

import Models.atributosStudent;
import Views.HomeView;
import Views.StudentView;

public class StudentController {

	public StudentView vista;
	
	public StudentController() {
		// TODO Auto-generated constructor stub
		
		vista = new StudentView();
	}
	
	public void alumnosRegistradosPanel() {
		
		vista.alumnosRegistradosPanel();
	}
	
	public void buscarIDPanel() {
		
		vista.buscarIDPanel();
	}
	
	public void buscarIDPanel3() {
		
		vista.buscarIDPanel3();
	}
	
public void buscarIDPanel4() {
		
		vista.buscarIDPanel4();
	}
	
	public void descargarInformacionAlumno() {
		vista.descargarInformacionAlumno(null, null);
	}
	
	public void crearAlumnoPanel() {
		vista.crearAlumnoPanel(new atributosStudent(null, null, null, null, null, null, null, null, null));
	}
	
	public void seleccionAvatar() {
		vista.seleccionAvatar(null);
	}
		
	public void alumnoCreadoPanel() {
		vista.alumnoCreadoPanel();
	}
	
	public void editarInformacionAlumno() {
		
		vista.editarInformacionAlumno(null, null);
	}
	
	public void cambiosGuardadosPanel() {
		
		vista.cambiosGuardadosPanel();
	}
	
	public void eliminarAlumnoPanel() {
		vista.eliminarAlumnoPanel(null, null);
	}
	
	public void confirmarEliminarPanel() {
		vista.confirmarEliminarPanel(null, null);
	}
	
	public void alumnoEliminadoPanel() {
		vista.alumnoEliminadoPanel();
	}
		
	
}
