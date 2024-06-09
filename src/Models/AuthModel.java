package Models;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import com.itextpdf.text.Document;
import Views.AuthView;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.View;



import Controllers.HomeController;



public class AuthModel {


	public static String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_db_test_32";
	public static String USER = "freedb_administrador_proyecto";
	public static String CLAVE = "jwTgdZDt7e%?2M8";
	AuthView view;
	PreparedStatement ps = null;
	ResultSet rs= null;	
	public HomeController home;
	public AuthModel() {
		// TODO Auto-generated constructor stub
	}


	public boolean iniciarSesion (String usuario, String contraseña) {

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `UsuariosRegistrados` WHERE Usuarios = '"+usuario+"' AND Contraseña = '"+contraseña+"'; ");

			while (rs.next()) {

				home = new HomeController();

			
				home.administrarPanel();
				return true;
			}
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Conxeion fallida");
		}
		return false;
	}



	public void anadirUsuario (String usuario, String correoElectronico, String contraseña)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			ps =con.prepareStatement("INSERT INTO `UsuariosRegistrados` Values(?,?,?)");

			ps.setString(1, usuario);
			ps.setString(2, correoElectronico);
			ps.setString(3, contraseña);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro completado");
		}

		catch (Exception e) {
			// TODO: handle exception

			JOptionPane.showMessageDialog(null, "Conexion fallida");
		}
	}




}
