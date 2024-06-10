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
		List<List> datos = new ArrayList<>(); 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, CLAVE);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `Grupos`");

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

    public List<List> getMateriasPorGrupo(String grupo) {
        List<List> datos = new ArrayList<>(); 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, CLAVE);
            String consulta = "SELECT idMateria FROM tiraDeMaterias WHERE idGrupo = ?";
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.setString(1, grupo);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
              
                String materia = rs.getString("idMateria"); 
                
                System.out.println("Materia encontrada: " + materia); 
                
                List<String> info = Arrays.asList(materia);
                datos.add(info);
            }
            con.close();
            return datos; 
        } catch (Exception e) {
            e.printStackTrace(); 
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
	
	public void eliminarGrupoMateria (String nombre)
	{
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USER,CLAVE);
			Statement stmt=con.createStatement();
			int rowsAffected = stmt.executeUpdate("DELETE FROM tiraDeMaterias WHERE idGrupo = '" + nombre + "';");;
			if (rowsAffected > 0) {

			} else {

			}

			con.close();

		} catch (Exception e) {
			// TODO: handle exception

			JOptionPane.showMessageDialog(null,"No se pudo eliminar");
		}
		
	}
	
	public void eliminarDelAlumno (String nombre)
	{
		String consulta = "UPDATE alumnos SET Grupo = ? WHERE Grupo = ?";

		try (Connection conexion = DriverManager.getConnection(URL, USER, CLAVE);
				PreparedStatement st = conexion.prepareStatement(consulta)) {

			st.setString(1, "");
			st.setString(2, nombre);



			int filasAfectadas = st.executeUpdate();
			if (filasAfectadas > 0) {

			} else {
				JOptionPane.showMessageDialog(null, "No se elimno del alumno el grupo");
			}

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "No paso la consulta");
		}
	}
	
	public void datosGruposPDF(String grupo) {
	    try {
	        List<List> alumnos = estudiante.alumnosGrupo(grupo);
	        AtributosGroup info = datosDelGrupo(grupo);
	        List<List> materias = getMateriasPorGrupo(grupo);

	        if (alumnos == null || alumnos.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "No se encontraron datos de alumnos para el grupo.");
	            return;
	        }

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

	            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);

	            PdfPTable table = new PdfPTable(4);
	            table.setWidthPercentage(100);
	            table.setSpacingBefore(10f);
	            table.setSpacingAfter(10f);

	            PdfPCell cell2 = new PdfPCell(new Phrase("Apellido Paterno", font));
	            table.addCell(cell2);
	            cell2 = new PdfPCell(new Phrase("Apellido Materno", font));
	            table.addCell(cell2);
	            cell2 = new PdfPCell(new Phrase("Nombre", font));
	            table.addCell(cell2);
	            cell2 = new PdfPCell(new Phrase("No. Control", font));
	            table.addCell(cell2);

	            font = FontFactory.getFont(FontFactory.HELVETICA, 8);
	            for (List<String> alumno : alumnos) {
	                table.addCell(new PdfPCell(new Phrase(alumno.get(1), font)));
	                table.addCell(new PdfPCell(new Phrase(alumno.get(2), font)));
	                table.addCell(new PdfPCell(new Phrase(alumno.get(3), font)));
	                table.addCell(new PdfPCell(new Phrase(alumno.get(0), font)));
	            }

	            document.add(table);

	            PdfPTable docenteTable = new PdfPTable(1);
	            docenteTable.setWidthPercentage(30);
	            docenteTable.setSpacingBefore(5f);
	            docenteTable.setSpacingAfter(5f);

	            font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
	            PdfPCell docenteHeader = new PdfPCell(new Phrase("Docente del grupo", font));
	            docenteHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
	            docenteTable.addCell(docenteHeader);

	            font = FontFactory.getFont(FontFactory.HELVETICA, 10);
	            PdfPCell docenteCell = new PdfPCell(new Phrase(info.getDocente(), font));
	            docenteCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            docenteTable.addCell(docenteCell);

	            document.add(docenteTable);

	            PdfPTable letraGrupoTable = new PdfPTable(1);
	            letraGrupoTable.setWidthPercentage(10);
	            letraGrupoTable.setSpacingBefore(5f);
	            letraGrupoTable.setSpacingAfter(5f);

	            PdfPCell letraGrupoHeader = new PdfPCell(new Phrase("Letra del Grupo", font));
	            letraGrupoHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
	            letraGrupoTable.addCell(letraGrupoHeader);
	            
	            PdfPTable materiasTable = new PdfPTable(1);
	            materiasTable.setWidthPercentage(50);
	            materiasTable.setSpacingBefore(10f);
	            materiasTable.setSpacingAfter(10f);

	            
	            PdfPCell cell = new PdfPCell(new Phrase("Materias", font));
	            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            materiasTable.addCell(cell);

	            font = FontFactory.getFont(FontFactory.HELVETICA, 8);
	            for (List<String> materia : materias) {
	                materiasTable.addCell(new PdfPCell(new Phrase(materia.get(0), font)));
	            }

	            document.add(materiasTable);


	            try {
	                Image groupImage = Image.getInstance(getClass().getResource(info.getLetraDeGrupo()));
	                groupImage.scaleToFit(50, 50);
	                PdfPCell imageCell = new PdfPCell(groupImage, true);
	                imageCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                letraGrupoTable.addCell(imageCell);
	            } catch (Exception e) {
	                PdfPCell emptyCell = new PdfPCell(new Phrase("Imagen no disponible", font));
	                emptyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                letraGrupoTable.addCell(emptyCell);
	            }

	            document.add(letraGrupoTable);

	            document.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "No se generó el PDF.");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "No se generó el PDF.");
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
