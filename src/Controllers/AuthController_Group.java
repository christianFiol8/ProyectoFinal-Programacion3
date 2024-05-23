package Controllers;

import Views.AuthView_GroupView;
import Views.AuthView_HomeView;

public class AuthController_Group {

	public AuthView_GroupView vista;

	public AuthController_Group() {
		// TODO Auto-generated constructor stub
		
		vista = new AuthView_GroupView();
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
