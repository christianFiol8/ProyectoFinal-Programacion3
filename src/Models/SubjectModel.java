package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class SubjectModel {
	
	public static String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_db_test_32";
	public static String USER = "freedb_administrador_proyecto";
	public static String CLAVE = "jwTgdZDt7e%?2M8";
	PreparedStatement ps = null;
	ResultSet rs= null;

	public SubjectModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void crearAsignatura(String nombre,String docente,String descripcion)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			ps =con.prepareStatement("INSERT INTO `asignaturas` Values(?,?,?)");
			
			ps.setString(1, nombre);
			ps.setString(2, docente);
			ps.setString(3, descripcion);
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public atributosSubject datosMateria (String nombre) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			Statement stmt=con.createStatement();

			//Con este se busca al docente
			ResultSet rs = stmt.executeQuery("SELECT * FROM `asignaturas` where Nombre = '"+nombre+"'");
			
			while (rs.next()) {


				String nombres = rs.getString("Nombre");
				String Docente = rs.getString("Docente");
				String letra = rs.getString("Descripcion");
				


				//Crea un objeto en el cual va a guardar los datos
				atributosSubject informacion = new atributosSubject(nombres,Docente,letra);


				return informacion;

			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		return null;
	}

	
	public List<List> get() {
		List<List> datos = new ArrayList<>(); 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, CLAVE);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `asignaturas`");

			while (rs.next()) {
				
				String id = rs.getString(1);

				String [] docentes = {id};
				List<String> info = Arrays.asList(docentes);	
				datos.add(info);
			}
			con.close();
			return datos; 

		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return null;
	}

	public void eliminarAsignatura (String nombre)
	{
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			Statement stmt=con.createStatement();
			int rowsAffected = stmt.executeUpdate("DELETE FROM asignaturas WHERE Nombre = '" + nombre + "';");;
			if (rowsAffected > 0) {

			} else {

			}

			con.close();

		} catch (Exception e) {
			// TODO: handle exception

			JOptionPane.showMessageDialog(null,"No se pudo eliminar");
		}
	}
	
	public void editarAsignatura (String Nombre,String Docente,String Descripcion ) {

		String consulta = "UPDATE asignaturas SET Docente = ?, Descripcion = ? WHERE Nombre = ?";

		try (Connection conexion = DriverManager.getConnection(URL, USER, CLAVE);
				PreparedStatement st = conexion.prepareStatement(consulta)) {

			st.setString(1, Docente);
			st.setString(2, Descripcion);
			st.setString(3, Nombre);
		

			int filasAfectadas = st.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("Paso la consulta");

			} else {
				JOptionPane.showMessageDialog(null, "No se encontró el docente con el ID especificado.");
			}

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "No se edito nada");
		}

	}

	public void eliminarMateriaLista (String nombre)
	{
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			Statement stmt=con.createStatement();
			int rowsAffected = stmt.executeUpdate("DELETE FROM tiraDeMaterias WHERE idMateria = '" + nombre + "';");;
			if (rowsAffected > 0) {

			} else {

			}

			con.close();

		} catch (Exception e) {
			// TODO: handle exception

			JOptionPane.showMessageDialog(null,"No se pudo eliminar");
		}
		
	}
	
	public List<List> asignaturaGrupo(String grupo) {
		List<List> datos = new ArrayList<>(); 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, CLAVE);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `Grupos` WHERE materia = '" + grupo + "';");

			while (rs.next()) {
				

				String id = rs.getString(1);
				

				String [] docentes = {id};
				List<String> info = Arrays.asList(docentes);	
				datos.add(info);
			}
			con.close();
			return datos; 

		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return null;
	}

	public void asignarGrupoMateria(String grupo, String materia)
	{
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			ps =con.prepareStatement("INSERT INTO `tiraDeMaterias` Values(?,?)");

			ps.setString(1, grupo);
			ps.setString(2, materia);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

}