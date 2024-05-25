package Controllers;

import Views.GroupView;
import Views.HomeView;

public class GroupController {

	public GroupView vista;

	public GroupController() {
		// TODO Auto-generated constructor stub
		
		vista = new GroupView();
	}
	
	public void agregarAlumno() {
		vista.agregarAlumno();
	}
	
	public void gruposRegistradosPanel() {
		vista.gruposRegistradosPanel();
	}
	public void listaAlumnosPanel() {
		vista.listaAlumnosPanel();

		
	}
	public void listaAlumnosPanel2() {
		vista.listaAlumnosPanel2();

		
	}
	
	public void seleccionarLetras() {
		vista.seleccionarLetras();

	}
	
	public void buscarGrupo2() {
		vista.buscarGrupo2();
	}
	public void buscarGrupo() {
		vista.buscarGrupo();

	}
	
	public void buscarGrupo3() {
		vista.buscarGrupo3();
	}
	public void editarGrupo() {
	vista.editarGrupo();
	}

	public void crearGrupo() {
		vista.crearGrupo();
	}
	public void buscarGrupo4() {
		vista.buscarGrupo4();
	}
}
