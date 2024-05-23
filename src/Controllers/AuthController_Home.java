package Controllers;

import Views.AuthView_HomeView;

public class AuthController_Home {
	
	public AuthView_HomeView vista;

	public AuthController_Home() {
		// TODO Auto-generated constructor stub
		
		vista = new AuthView_HomeView();
	}
	
	public void administrarPanel () {
		
		vista.administrarPanel();
	}
}
