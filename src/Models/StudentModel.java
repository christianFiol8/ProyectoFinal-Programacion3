package Models;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class StudentModel {


	public static String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_db_test_32";
	public static String USER = "freedb_administrador_proyecto";
	public static String CLAVE = "jwTgdZDt7e%?2M8";
	PreparedStatement ps = null;
	ResultSet rs= null;

	public StudentModel() {
		// TODO Auto-generated constructor stub
	}

	public void añadirAlumno (String idAlumno,String apellidoPaterno,String apellidoMaterno, String nombres, 

			String fechaDeNacimineto, String correoElectronico,String gradoDelAlumno, String telefono, String avatar )
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Aqui se añade al docente
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			ps =con.prepareStatement("INSERT INTO `alumnos` Values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, idAlumno);
			ps.setString(2, apellidoPaterno);
			ps.setString(3, apellidoMaterno);
			ps.setString(4, nombres);
			ps.setString(5, fechaDeNacimineto);
			ps.setString(6, correoElectronico);
			ps.setString(7, gradoDelAlumno);
			ps.setString(8, telefono);
			ps.setString(9, avatar);
			ps.setString(10, "");

			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void agregarGrupoAlumnos (String Grupo, String alumnos)
	{
		
		String consulta = "UPDATE alumnos SET Grupo =? WHERE id =?";

		try (Connection conexion = DriverManager.getConnection(URL, USER, CLAVE);
				PreparedStatement st = conexion.prepareStatement(consulta)) {

			st.setString(1, Grupo);
			st.setString(2, alumnos);

			int filasAfectadas = st.executeUpdate();
			if (filasAfectadas > 0) {

			} else {
				JOptionPane.showMessageDialog(null, "No se agrego a un grupo");
			}

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
			ResultSet rs = stmt.executeQuery("SELECT * FROM `alumnos`");

			while (rs.next()) {
				// Obtén los datos de la fila actual
				String id = rs.getString(1);
				String nombre = rs.getString(2);
				String apellidoPaterno = rs.getString(3);
				String apellidoMaterno = rs.getString(4);

				String [] docentes = {id,nombre,apellidoPaterno,apellidoMaterno};
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
	
	public List<List> alumnosGrupo(String grupo) {
		List<List> datos = new ArrayList<>(); // Define el tipo de lista correctamente
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, CLAVE);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `alumnos` WHERE Grupo = '" + grupo + "';");

			while (rs.next()) {
				// Obtén los datos de la fila actual

				String id = rs.getString(1);
				String nombre = rs.getString(2);
				String apellidoPaterno = rs.getString(3);
				String apellidoMaterno = rs.getString(4);

				String [] docentes = {id,nombre,apellidoPaterno,apellidoMaterno};
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
	
	

	public atributosStudent buscarAlumno (String idAlumno)
	{
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			Statement stmt=con.createStatement();

			//Con este se busca al docente
			ResultSet rs = stmt.executeQuery("SELECT * FROM `alumnos` where id = '"+idAlumno+"'");

			while (rs.next()) {

				String apellidoPaterno = rs.getString("apellidoPaterno");
				String apellidoMaterno = rs.getString("apellidoMaterno");
				String nombre = rs.getString("nombres");
				String fechaDeNaciminto = rs.getString("fechaDeNacimiento");
				String correoElectronico = rs.getString("correoElectronico");
				String gradoDeEstudio = rs.getString("gradoDelAlumno");
				String telefono = rs.getString("telefono");
				String avatar = rs.getString("Avatar");
				String grupo = rs.getString("Grupo");

				//Crea un objeto en el cual va a guardar los datos
				atributosStudent informacion = new atributosStudent(idAlumno, apellidoPaterno, apellidoMaterno, nombre, fechaDeNaciminto, correoElectronico, gradoDeEstudio, telefono,avatar,grupo);


				return informacion;

			}
		} catch (Exception e) {
			// TODO: handle exception

			JOptionPane.showMessageDialog(null,"No se encontro docente" );
		}

		return null;
	}


	public void editarAlumno (String id,String apellidoPaterno,String apellidoMaterno, String nombres,String fechaDeNacimiento, String correoElectronico,String gradoDeEstudios, String telefono,String avatar ) {

		//Con este se busca al docente ya creado para editarlo
		String consulta = "UPDATE alumnos SET apellidoPaterno = ?, apellidoMaterno = ?, nombres = ?,fechaDeNacimiento = ?, correoElectronico = ?, gradoDelAlumno = ?, telefono = ?, Avatar = ? WHERE id = ?";

		try (Connection conexion = DriverManager.getConnection(URL, USER, CLAVE);
				PreparedStatement st = conexion.prepareStatement(consulta)) {

			st.setString(1, apellidoPaterno);
			st.setString(2, apellidoMaterno);
			st.setString(3, nombres);
			st.setString(4, fechaDeNacimiento);
			st.setString(5, correoElectronico);
			st.setString(6, gradoDeEstudios);
			st.setString(7, telefono);
			st.setString(8, avatar);
			st.setString(9, id);


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

	public void eliminarAlumno (String id) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			Statement stmt=con.createStatement();
			int rowsAffected = stmt.executeUpdate("DELETE FROM alumnos WHERE id = '" + id + "';");;
			if (rowsAffected > 0) {

			} else {

			}

			con.close();

		} catch (Exception e) {
			// TODO: handle exception

			JOptionPane.showMessageDialog(null,"No se pudo eliminar");
		}

	}

	public void generarPDFDatos(String id) {

	    atributosStudent alumno = buscarAlumno(id);

	    if (alumno == null) {
	        JOptionPane.showMessageDialog(null, "No se encontraron datos del alumno.");
	        return;
	    }

	    Document document = new Document(PageSize.A4.rotate());
	    JFileChooser chooser = new JFileChooser();
	    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);
	    FileNameExtensionFilter pdfs = new FileNameExtensionFilter("Documentos PDF", "pdf");
	    chooser.addChoosableFileFilter(pdfs);
	    chooser.setFileFilter(pdfs);

	    if (JFileChooser.CANCEL_OPTION == chooser.showDialog(null, "Generar PDF")) {
	        JOptionPane.showMessageDialog(null, "No se generó el PDF.");
	        return;
	    }

	    try {
	        PdfWriter.getInstance(document, new FileOutputStream(chooser.getSelectedFile() + ".pdf"));
	        document.open();

	        Paragraph title = new Paragraph("Información del alumno", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));
	        title.setSpacingBefore(20); // Espacio antes del título
	        title.setSpacingAfter(20);
	        title.setAlignment(Element.ALIGN_CENTER);
	        document.add(title);

	        // Crea la tabla con 2 columnas
	        PdfPTable table = new PdfPTable(2);
	        table.setWidthPercentage(100);

	        // Agrega filas a la tabla utilizando los datos obtenidos de alumno
	        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
	        Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 20);

	        // Agregar celda de encabezado y datos para cada campo
	        table.addCell(createCell("ID del Alumno", headerFont));
	        table.addCell(createCell(alumno.getAlumnoId(), dataFont));

	        table.addCell(createCell("Apellido paterno", headerFont));
	        table.addCell(createCell(alumno.getApellidoPaterno(), dataFont));

	        table.addCell(createCell("Apellido materno", headerFont));
	        table.addCell(createCell(alumno.getApellidoMaterno(), dataFont));

	        table.addCell(createCell("Nombre", headerFont));
	        table.addCell(createCell(alumno.getNombre(), dataFont));

	        table.addCell(createCell("Fecha de nacimiento", headerFont));
	        table.addCell(createCell(alumno.getNacimiento(), dataFont));

	        table.addCell(createCell("Correo electrónico", headerFont));
	        table.addCell(createCell(alumno.getEmail(), dataFont));

	        table.addCell(createCell("Grado académico", headerFont));
	        table.addCell(createCell(alumno.getEstudios(), dataFont));

	        table.addCell(createCell("Teléfono", headerFont));
	        table.addCell(createCell(alumno.getTelefono(), dataFont));

	        table.addCell(createCell("Grupo", headerFont));
	        table.addCell(createCell(alumno.getGrupo(), dataFont)); // Agregar grupo

	        // Agrega la tabla al documento
	        document.add(table);

	        // Cierra el documento
	        document.close();

	    } catch (FileNotFoundException | DocumentException e) {
	        e.printStackTrace();
	        System.out.println("No se generó el PDF.");
	    }
	}

	private PdfPCell createCell(String text, Font font) {
	    PdfPCell cell = new PdfPCell(new Phrase(text, font));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    return cell;
	}

	public void generarCredencial (String id)
	{
		atributosStudent alumno = buscarAlumno(id);

		if (alumno == null) {
		    JOptionPane.showMessageDialog(null, "No se encontraron datos del alumno.");
		    return;
		}

		// Tamaño de credencial (3.37 x 2.13 pulgadas)
		Rectangle credencialSize = new Rectangle(8.56f * 28.35f, 5.41f * 28.35f);
		Document document = new Document(credencialSize);

		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter pdfs = new FileNameExtensionFilter("Documentos PDF", "pdf");
		chooser.addChoosableFileFilter(pdfs);
		chooser.setFileFilter(pdfs);

		if (JFileChooser.CANCEL_OPTION == chooser.showDialog(null, "Generar PDF")) {
		    JOptionPane.showMessageDialog(null, "No se generó el PDF.");
		    return;
		}

		try {
		    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(chooser.getSelectedFile() + ".pdf"));
		    document.open();

		    // Crear un Phrase para los datos del estudiante
		    Font font = FontFactory.getFont(FontFactory.HELVETICA, 7); // Tamaño de fuente
		    Phrase studentInfo = new Phrase();
		    studentInfo.add(new Chunk("Apellido Paterno: ", font));
		    studentInfo.add(new Chunk(""+alumno.getApellidoPaterno(), font));
		    studentInfo.add(Chunk.NEWLINE);
		    studentInfo.add(new Chunk("Apellido Materno: ", font));
		    studentInfo.add(new Chunk(""+alumno.getApellidoMaterno(), font));
		    studentInfo.add(Chunk.NEWLINE);
		    studentInfo.add(new Chunk("Nombre: ", font));
		    studentInfo.add(new Chunk(""+alumno.getNombre(), font));
		    studentInfo.add(Chunk.NEWLINE);
		    studentInfo.add(new Chunk("Número de Control: " + id, font));

		    // Agregar el Phrase al documento
		    document.add(studentInfo);

		    // Agregar la imagen del avatar
		    try {
		        Image avatarImage = Image.getInstance(getClass().getResource(alumno.getAvatar()));
		        avatarImage.scaleToFit(20, 20); // Ajusta el tamaño de la imagen (más pequeña)
		        document.add(avatarImage);
		    } catch (Exception e) {
		        System.err.println("Error al cargar la imagen del avatar: " + e.getMessage());
		    }

		    // Cierra el documento
		    document.close();


		} catch (FileNotFoundException | DocumentException e) {
		    e.printStackTrace();
		    System.out.println("No se generó");
		}
	}

}


