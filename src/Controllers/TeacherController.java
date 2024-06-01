package Controllers;

import Models.atributosTeacher;
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
		vista.descargarInformacionDocente(null, null);
	}

	public void crearDocentePanel() {
		vista.crearDocentePanel(new atributosTeacher(null, null, null, null, null, null, null, null));
	}

	public void seleccionAvatar() {
		vista.seleccionAvatar(null);
	}

	public void docenteCreadoPanel() {
		vista.docenteCreadoPanel();
	}

	/*public void editarInformacionDocente() {

		vista.editarInformacionDocente(null,null);
	}*/

	public void confirmarEditarDocente() {

		vista.confirmarEditarDocente(null, null);
	}

	public void confirmacionEditarPanel() {

		vista.confirmacionEditarPanel(null, null, null, null, null, null, null, null, null);
	}

	public void cambiosGuardadosPanel() {

		vista.cambiosGuardadosPanel();
	}

	public void eliminarDocentePanel() {
		vista.eliminarDocentePanel(null,null);
	}

	public void confirmarEliminarPanel() {
		vista.confirmarEliminarPanel(null,null);
	}

	public void docenteEliminadoPanel() {
		vista.docenteEliminadoPanel();
	}
}
