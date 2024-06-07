package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Flow.Publisher;

import javax.swing.JOptionPane;

public class GroupModel {
	
	public static String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_db_test_32";
	public static String USER = "freedb_administrador_proyecto";
	public static String CLAVE = "jwTgdZDt7e%?2M8";
	PreparedStatement ps = null;
	ResultSet rs= null;

	public GroupModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void crearGrupo (String nombre,String docente,String letra, String alumnos)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			ps =con.prepareStatement("INSERT INTO `Grupos` Values(?,?,?,?)");
			ps.setString(1, nombre);
			ps.setString(2, docente);
			ps.setString(3, letra);
			ps.setString(4, alumnos);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<List> get() {
		List<List> datos = new ArrayList<>(); // Define el tipo de lista correctamente
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, CLAVE);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `Grupos`");

			while (rs.next()) {
				// Obtén los datos de la fila actual
				String id = rs.getString(1);

				String [] docentes = {id};
				List<String> info = Arrays.asList(docentes);	
				datos.add(info);
			}
			con.close();
			return datos; // Devuelve la lista de datos

		} catch (Exception e) {
			e.printStackTrace(); // Maneja adecuadamente las excepciones
		}
		return null;
	}

	
	public AtributosGroup datosDelGrupo(String nombre) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			Statement stmt=con.createStatement();

			//Con este se busca al docente
			ResultSet rs = stmt.executeQuery("SELECT * FROM `Grupos` where Nombre = '"+nombre+"'");
			
			while (rs.next()) {


				String nombres = rs.getString("Nombre");
				String Docente = rs.getString("Docente");
				String letra = rs.getString("Letra");
				String alumno = rs.getString("Alumnos");


				//Crea un objeto en el cual va a guardar los datos
				AtributosGroup informacion = new AtributosGroup(nombre,Docente,letra,alumno);


				return informacion;

			}

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	
	public void editarGrupo (String Nombre,String Docente,String Letra, String Alumno ) {

		//Con este se busca al docente ya creado para editarlo
		String consulta = "UPDATE Grupos SET Docente = ?, Letra = ?, Alumnos = ? WHERE Nombre = ?";

		try (Connection conexion = DriverManager.getConnection(URL, USER, CLAVE);
				PreparedStatement st = conexion.prepareStatement(consulta)) {

			st.setString(1, Docente);
			st.setString(2, Letra);
			st.setString(3, Alumno);
			st.setString(4, Nombre);


			int filasAfectadas = st.executeUpdate();
			if (filasAfectadas > 0) {

			} else {
				JOptionPane.showMessageDialog(null, "No se encontró el docente con el ID especificado.");
			}

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "No se edito nada");
		}

	}
	
	public void eliminarGrupo (String nombre) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			Statement stmt=con.createStatement();
			int rowsAffected = stmt.executeUpdate("DELETE FROM Grupos WHERE Nombre = '" + nombre + "';");;
			if (rowsAffected > 0) {

			} else {

			}

			con.close();

		} catch (Exception e) {
			// TODO: handle exception

			JOptionPane.showMessageDialog(null,"No se pudo eliminar");
		}

	}
	
	public void añadirAlumno()
	{
		
	}
	
	
	
}
