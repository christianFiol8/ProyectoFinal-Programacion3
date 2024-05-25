package Controllers;

import javax.swing.JPanel;

import Views.HomeView;

public class HomeController {
	
	public HomeView vista;

	public HomeController() {
		// TODO Auto-generated constructor stub
		
		vista = new HomeView();
	}
	
	public void administrarPanel () {
		
		vista.administrarPanel();
	}
	
	public void alumnoPanel() {
		vista.alumnoPanel();
	}
	
	public void gruposPanel() {
		vista.gruposPanel();
	}
	
	public void asignaturasPanel() {
		vista.asignaturasPanel();
	}
	
	public void docentePanel() {
		vista.docentePanel();
	}
	
	public void metodoMenu(JPanel panel) {
		 vista.metodoMenu(panel);
		
	}
	
	
}
