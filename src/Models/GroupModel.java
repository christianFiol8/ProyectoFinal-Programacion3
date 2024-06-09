package Models;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Flow.Publisher;
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

import javax.swing.JOptionPane;

public class GroupModel {
	
	public static String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_db_test_32";
	public static String USER = "freedb_administrador_proyecto";
	public static String CLAVE = "jwTgdZDt7e%?2M8";
	StudentModel estudiante = new StudentModel();
	PreparedStatement ps = null;
	ResultSet rs= null;

	public GroupModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void crearGrupo (String nombre,String docente,String letra)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			ps =con.prepareStatement("INSERT INTO `Grupos` Values(?,?,?,?)");
			ps.setString(1, nombre);
			ps.setString(2, docente);
			ps.setString(3, letra);
			ps.setString(4,"");

			ps.executeUpdate();
			
			StudentModel grupo = new StudentModel();
			
	
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

	
	public void asigrnarMateria (String materia, String grupo) {
		
		String consulta = "UPDATE Grupos SET materia =? WHERE Nombre =?";

		try (Connection conexion = DriverManager.getConnection(URL, USER, CLAVE);
				PreparedStatement st = conexion.prepareStatement(consulta)) {

			st.setString(1, grupo);
			st.setString(2, materia);

			int filasAfectadas = st.executeUpdate();
			if (filasAfectadas > 0) {

			} else {
				JOptionPane.showMessageDialog(null, "No se agrego a un grupo");
			}

		} catch (Exception e) {
			// TODO: handle exception
			
		}
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
				


				//Crea un objeto en el cual va a guardar los datos
				AtributosGroup informacion = new AtributosGroup(nombres,Docente,letra);


				return informacion;

			}

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	
	public void editarGrupo (String Nombre,String Docente,String Letra ) {

		//Con este se busca al docente ya creado para editarlo
		String consulta = "UPDATE Grupos SET Docente = ?, Letra = ? WHERE Nombre = ?";

		try (Connection conexion = DriverManager.getConnection(URL, USER, CLAVE);
				PreparedStatement st = conexion.prepareStatement(consulta)) {

			st.setString(1, Docente);
			st.setString(2, Letra);
			st.setString(3, Nombre);


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
	
	public void datosGruposPDF(String grupo) {
		
		try {
			
		
		        List<List> datos = estudiante.alumnosGrupo(grupo);

		        if (datos == null || datos.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "No se encontraron datos de alumnos para el grupo.");
		            return;
		        }

		        // Tamaño de credencial (8.5 x 11 pulgadas)
		        Rectangle pageSize = new Rectangle(8.5f * 72, 11f * 72);
		        Document document = new Document(pageSize);

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
		            
		            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
		            Paragraph title = new Paragraph("Grupo: " + grupo, titleFont);
		            title.setAlignment(Element.ALIGN_CENTER);
		            document.add(title);

		            // Crear la tabla con 3 columnas para los datos de los estudiantes
		            PdfPTable table = new PdfPTable(4);
		            table.setWidthPercentage(100);
		            table.setSpacingBefore(10f);
		            table.setSpacingAfter(10f);

		            // Encabezados de la tabla
		            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
		            PdfPCell cell = new PdfPCell(new Phrase("Apellido Paterno", font));
		            table.addCell(cell);
		            cell = new PdfPCell(new Phrase("Apellido Materno", font));
		            table.addCell(cell);
		            cell = new PdfPCell(new Phrase("Nombre", font));
		            table.addCell(cell);
		            cell = new PdfPCell(new Phrase("No. Control", font));
		            table.addCell(cell);

		            // Datos de la tabla
		            font = FontFactory.getFont(FontFactory.HELVETICA, 8);
		            for (List<String> alumno : datos) {
		                table.addCell(new PdfPCell(new Phrase(alumno.get(1), font)));
		                table.addCell(new PdfPCell(new Phrase(alumno.get(2), font)));
		                table.addCell(new PdfPCell(new Phrase(alumno.get(3), font)));
		                table.addCell(new PdfPCell(new Phrase(alumno.get(0), font)));
		            }

		            // Agregar la tabla al documento
		            document.add(table);

		            // Cerrar el documento
		            document.close();

		        } catch (Exception e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "No se generó el PDF.");
		        }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public ArrayList<String> tiraDeMaterias (String asignatura)
	{
		ArrayList<String>materias = new ArrayList<String>();
		
		try {
			
			String consulta = "SELECT idGrupo FROM tiraDeMaterias WHERE IdMateria = '"+asignatura+"';";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, CLAVE);
			PreparedStatement st = con.prepareStatement(consulta);
			ResultSet rs = st.executeQuery();
			
			while (rs.next())
			{
				materias.add(rs.getString("idGrupo"));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return materias;
		
		
	}
	
}
