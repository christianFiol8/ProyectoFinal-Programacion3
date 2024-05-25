package Controllers;

import Views.StudentView;
import Views.TeacherView;

public class TeacherController {

public TeacherView vista;
	
	public TeacherController() {
		// TODO Auto-generated constructor stub
		
		vista = new TeacherView();
	}
	
public void docenteRegistradosPanel() {
		
		vista.docentesRegistradosPanel();
	}
	
	public void buscarIDPanel2() {
		
		vista.buscarIDPanel2();
	}
	
	public void buscarIDPanel3() {
		
		vista.buscarIDPanel3();
	}
	
public void buscarIDPanel4() {
		
		vista.buscarIDPanel4();
	}
	
	public void descargarInformacionDocente() {
		vista.descargarInformacionDocente();
	}
	
	public void crearDocentePanel() {
		vista.crearDocentePanel();
	}
	
	public void seleccionAvatar() {
		vista.seleccionAvatar();
	}
	
	public void crearDocenteAvatarPanel() {
		
		vista.crearDocenteAvatarPanel();
	}
	
	public void confirmarCrearPanel() {
		
		vista.confirmarCrearPanel();
	}
		
	public void docenteCreadoPanel() {
		vista.docenteCreadoPanel();
	}
	
	public void editarInformacionDocente() {
		
		vista.editarInformacionDocente();
	}
	
	public void confirmarEditarDocente() {
		
		vista.confirmarEditarDocente();
	}
	
	public void confirmacionEditarPanel() {
		
		vista.confirmacionEditarPanel();
	}
	
	public void cambiosGuardadosPanel() {
		
		vista.cambiosGuardadosPanel();
	}
	
	public void eliminarDocentePanel() {
		vista.eliminarDocentePanel();
	}
	
	public void confirmarEliminarPanel() {
		vista.confirmarEliminarPanel();
	}
	
	public void docenteEliminadoPanel() {
		vista.docenteEliminadoPanel();
	}
}
