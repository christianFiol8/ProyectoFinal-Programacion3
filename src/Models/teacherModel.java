package Models;
import java.lang.invoke.StringConcatFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;


import Views.AuthView;
import Views.TeacherView;


public class teacherModel {

	public static String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_db_test_32";
	public static String USER = "freedb_administrador_proyecto";
	public static String CLAVE = "jwTgdZDt7e%?2M8";
	AuthView view;
	PreparedStatement ps = null;
	ResultSet rs= null;

	public teacherModel() {
		// TODO Auto-generated constructor stub
	}


	public atributosTeacher buscarDocentes (String idDocente)
	{
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			Statement stmt=con.createStatement();

			//Con este se busca al docente
			ResultSet rs = stmt.executeQuery("SELECT * FROM `docentes` where idDocente = '"+idDocente+"'");

			while (rs.next()) {

				String apellidoPaterno = rs.getString("apellidoPaterno");
				String apellidoMaterno = rs.getString("apellidoMaterno");
				String nombre = rs.getString("nombres");
				String fechaDeNaciminto = rs.getString("fechaDeNacimiento");
				String correoElectronico = rs.getString("correoElectronico");
				String gradoDeEstudio = rs.getString("gradoDeEstudios");
				String telefono = rs.getString("telefono");

				//Crea un objeto en el cual va a guardar los datos
				atributosTeacher informacion = new atributosTeacher(idDocente, apellidoPaterno, apellidoMaterno, nombre, fechaDeNaciminto, correoElectronico, gradoDeEstudio, telefono);


				return informacion;

			}
		} catch (Exception e) {
			// TODO: handle exception

			JOptionPane.showMessageDialog(null,"No se encontro docente" );
		}

		return null;

	}
	public List<List> get() {
		List<List> datos = new ArrayList<>(); // Define el tipo de lista correctamente
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, CLAVE);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `docentes`");

			while (rs.next()) {
				// Obtén los datos de la fila actual
				String id = rs.getString(1);
				String nombre = rs.getString(2);

				String [] docentes = {id,nombre};
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

	public void añadirDocentes(String idDocentes,String apellidoPaterno,String apellidoMaterno, String nombres, 

			String fechaDeNacimineto, String correoElectronico,String gradoDeEstudios, String telefono ) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Aqui se añade al docente
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			ps =con.prepareStatement("INSERT INTO `docentes` Values(?,?,?,?,?,?,?,?)");
			ps.setString(1, idDocentes);
			ps.setString(2, apellidoPaterno);
			ps.setString(3, apellidoMaterno);
			ps.setString(4, nombres);
			ps.setString(5, fechaDeNacimineto);
			ps.setString(6, correoElectronico);
			ps.setString(7, gradoDeEstudios);
			ps.setString(8, telefono);

			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void editarDocentes (String idDocente,String apellidoPaterno,String apellidoMaterno, String nombres,	String fechaDeNacimiento, String correoElectronico,String gradoDeEstudios, String telefono ) {

		//Con este se busca al docente ya creado para editarlo
		String consulta = "UPDATE docentes SET apellidoPaterno = ?, apellidoMaterno = ?, nombres = ?,fechaDeNacimiento = ?, correoElectronico = ?, gradoDeEstudios = ?, telefono = ? WHERE idDocente = ?";

		try (Connection conexion = DriverManager.getConnection(URL, USER, CLAVE);
				PreparedStatement st = conexion.prepareStatement(consulta)) {

			st.setString(1, apellidoPaterno);
			st.setString(2, apellidoMaterno);
			st.setString(3, nombres);
			st.setString(4, fechaDeNacimiento);
			st.setString(5, correoElectronico);
			st.setString(6, gradoDeEstudios);
			st.setString(7, telefono);
			st.setString(8, idDocente);


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

	public void eliminarDocente (String idDocente) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			Statement stmt=con.createStatement();
			int rowsAffected = stmt.executeUpdate("DELETE FROM docentes WHERE idDocente = '" + idDocente + "';");;
			if (rowsAffected > 0) {

			} else {

			}

			con.close();

		} catch (Exception e) {
			// TODO: handle exception

			JOptionPane.showMessageDialog(null,"No se pudo eliminar");
		}

	}



}
