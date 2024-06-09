package Models;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.invoke.StringConcatFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
				String avatar = rs.getString("Avatar");

				//Crea un objeto en el cual va a guardar los datos
				atributosTeacher informacion = new atributosTeacher(idDocente, apellidoPaterno, apellidoMaterno, nombre, fechaDeNaciminto, correoElectronico, gradoDeEstudio, telefono,avatar);


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

	
	public atributosTeacher buscarDocentesgrupo (String idDocente)
	{
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			Statement stmt=con.createStatement();

			//Con este se busca al docente
			ResultSet rs = stmt.executeQuery("SELECT * FROM `docentes` where nombres = '"+idDocente+"'");

			while (rs.next()) {

				String apellidoPaterno = rs.getString("apellidoPaterno");
				String apellidoMaterno = rs.getString("apellidoMaterno");
				String nombre = rs.getString("nombres");
				String fechaDeNaciminto = rs.getString("fechaDeNacimiento");
				String correoElectronico = rs.getString("correoElectronico");
				String gradoDeEstudio = rs.getString("gradoDeEstudios");
				String telefono = rs.getString("telefono");
				String avatar = rs.getString("Avatar");

				//Crea un objeto en el cual va a guardar los datos
				atributosTeacher informacion = new atributosTeacher(idDocente, apellidoPaterno, apellidoMaterno, nombre, fechaDeNaciminto, correoElectronico, gradoDeEstudio, telefono,avatar);


				return informacion;

			}
		} catch (Exception e) {
			// TODO: handle exception

			JOptionPane.showMessageDialog(null,"No se encontro docente" );
		}

		return null;

	}
	
	public void generarPDFDatos(String idDocentes) {


	    atributosTeacher alumno = buscarDocentes(idDocentes);

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

	        Paragraph title = new Paragraph("Información del docente", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));
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
	        table.addCell(createCell("ID del docente", headerFont));
	        table.addCell(createCell(alumno.getDocentesId(), dataFont));

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

	
	public void generarCredencial (String idDocentes)
	{
	    atributosTeacher docente = buscarDocentes(idDocentes);

	    if (docente == null) {
	        JOptionPane.showMessageDialog(null, "No se encontraron datos del docente.");
	        return;
	    }

	    // Tamaño de credencial (3.37 x 2.13 pulgadas)
	    Rectangle credencialSize = new Rectangle(3.37f * 72, 2.13f * 72);
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
	        PdfWriter.getInstance(document, new FileOutputStream(chooser.getSelectedFile() + ".pdf"));
	        document.open();

	        // Crear una tabla con una sola columna para centrar el contenido
	        PdfPTable table = new PdfPTable(1);
	        table.setWidthPercentage(100);

	        // Agrega la imagen del avatar
	        try {
	            Image avatarImage = Image.getInstance(getClass().getResource(docente.getAvatar()));
	            avatarImage.scaleToFit(72, 72); // Ajusta el tamaño de la imagen (1 inch = 72 points)
	            avatarImage.setAlignment(Element.ALIGN_CENTER);
	            PdfPCell imageCell = new PdfPCell(avatarImage, true);
	            imageCell.setBorder(Rectangle.NO_BORDER);
	            imageCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(imageCell);
	        } catch (Exception e) {
	            System.err.println("Error al cargar la imagen del avatar: " + e.getMessage());
	        }

	        // Agrega el nombre y los apellidos
	        Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	        Paragraph nombreCompleto = new Paragraph(docente.getNombre() + " " + docente.getApellidoPaterno() + " " + docente.getApellidoMaterno(), font);
	        nombreCompleto.setAlignment(Element.ALIGN_CENTER);
	        PdfPCell textCell = new PdfPCell(nombreCompleto);
	        textCell.setBorder(Rectangle.NO_BORDER);
	        textCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        textCell.setVerticalAlignment(Element.ALIGN_TOP);
	        table.addCell(textCell);

	        // Agrega la tabla al documento
	        document.add(table);

	        // Cierra el documento
	        document.close();

	    } catch (FileNotFoundException | DocumentException e) {
	        e.printStackTrace();
	        System.out.println("No se generó");
	    }
	}


	public void añadirDocentes(String idDocentes,String apellidoPaterno,String apellidoMaterno, String nombres, 

			String fechaDeNacimineto, String correoElectronico,String gradoDeEstudios, String telefono,String avatar ) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Aqui se añade al docente
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			ps =con.prepareStatement("INSERT INTO `docentes` Values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, idDocentes);
			ps.setString(2, apellidoPaterno);
			ps.setString(3, apellidoMaterno);
			ps.setString(4, nombres);
			ps.setString(5, fechaDeNacimineto);
			ps.setString(6, correoElectronico);
			ps.setString(7, gradoDeEstudios);
			ps.setString(8, telefono);
			ps.setString(9, avatar);

			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void editarDocentes (String idDocente,String apellidoPaterno,String apellidoMaterno, String nombres,	String fechaDeNacimiento, String correoElectronico,String gradoDeEstudios, String telefono,String avatar ) {

		//Con este se busca al docente ya creado para editarlo
		String consulta = "UPDATE docentes SET apellidoPaterno = ?, apellidoMaterno = ?, nombres = ?,fechaDeNacimiento = ?, correoElectronico = ?, gradoDeEstudios = ?, telefono = ?, Avatar =? WHERE idDocente = ?";

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
			st.setString(9, idDocente);



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
