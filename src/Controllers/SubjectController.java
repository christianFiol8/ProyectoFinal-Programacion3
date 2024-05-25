package Controllers;

import Views.GroupView;
import Views.SubjectView;

public class SubjectController {

	public SubjectView vista;

	public SubjectController() {
		// TODO Auto-generated constructor stub
		
		vista = new SubjectView();
	}
	
	public void asignaturasRegistradasPanel() {
		vista.asignaturasRegistradasPanel();
	}
	public void detallesAsignaturaPanel() {
		vista.detallesAsignaturaPanel();

		
	}
	public void listaAlumnosPanel2() {
		vista.listaAlumnosPanel2();

		
	}
	
	public void seleccionarGrupo() {
		vista.seleccionarGrupo();

	}
	
	public void buscarAsignatura2() {
		vista.buscarAsignatura2();
	}
	public void buscarAsignatura() {
		vista.buscarAsignatura();

	}
	
	public void buscarAsignatura3() {
		vista.buscarAsignatura3();

	}
	
	public void editarGrupo() {
	vista.editarGrupo();
	}

	public void crearAsignatura() {
		vista.crearAsignatura();
	}
}
