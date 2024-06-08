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
	
	public void buscarAsignatura2() {
		vista.buscarAsignatura2();
	}
	
	public void buscarAsignatura() {
		vista.buscarAsignatura();

	}
	
	public void buscarAsignatura3() {
		vista.buscarAsignatura3();

	}
	
	public void buscarAsignatura4() {
	vista.buscarAsignatura4();
	}

	public void crearAsignatura() {
		vista.crearAsignatura();
	}
}
