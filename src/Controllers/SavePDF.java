package Controllers;

import java.awt.Desktop;
import java.io.File;
import java.security.PublicKey;
import java.util.ArrayList;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.annot.Pdf3DAnnotation;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import Models.atributosTeacher;
import Models.teacherModel;

public class SavePDF {

	private teacherModel informacionDocente;
	private JFileChooser select;
	private File archivo;
	private teacherModel model = new teacherModel();



	public SavePDF() {

		select = new JFileChooser();
	}

	public void generarPDF(String idDocentes)
	{
		JFileChooser documento = new JFileChooser();
		//SELECCIONA LA CARPETA
		documento.setFileSelectionMode(JFileChooser.FILES_ONLY);
		//NO INTERACTUE CON OTROS TIPOS DE ARCHIVOS
		documento.setAcceptAllFileFilterUsed(false);
		//aqui crea el nombre y tipo y le da el nombre al archivo
		FileNameExtensionFilter pdf = new FileNameExtensionFilter("Documento PDF", "pdf");

		documento.addChoosableFileFilter(pdf);
		//tipo
		documento.setFileFilter(pdf);

		//Si ya no quiere crearlo


		int respuesta = documento.showDialog(null, "Documento creado");

		if (respuesta==documento.CANCEL_OPTION)
		{
			JOptionPane.showMessageDialog(null,"Documento no creado");
		}

		atributosTeacher atributos = model.buscarDocentes(idDocentes);
		
		datosGuardadosPDF(documento, atributos);

	}

	public void datosGuardadosPDF (JFileChooser documento,atributosTeacher atributos) {

		try (PdfDocument datos = new PdfDocument(new PdfWriter(documento.getSelectedFile()));
				Document doc = new Document(datos,PageSize.LETTER.rotate()))
		{

			//Es el tamaño de las columnas
			float [] columnas = {4,4,4,4,4,4,4,4};

			//Creando la tabla
			Table tabla = new Table(UnitValue.createPercentArray(columnas)).useAllAvailableWidth();

		
			//Creando las celdas
			Cell celdas = new Cell(1,8)

					.setFontSize(14)//Tamaño de letra
					.setFontColor(DeviceGray.BLACK)//Color de letra
					.setBackgroundColor(new DeviceRgb(25, 223, 217));//Color del encabezado

			//TITULO	
			celdas.add(new Paragraph("Informacion del docente"));
			tabla.addHeaderCell(celdas);

			//Solo se puede poner la infromacion una vez
			for (int i =0; i<2; i++)
			{
				Cell[] cuadros = new Cell[] {
						new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph("Docente ID")),
						new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph("Apellido Paterno")),
						new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph("Apellido Materno")),
						new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph("Nombres")),
						new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph("Fecha de nacimiento")),
						new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph("Correo Electronico")),
						new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph("Grados de estudios")),
						new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph("Telefono"))
				};

			}
			tabla.addCell( new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph(atributos.getDocentesId())));
			tabla.addCell( new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph(atributos.getApellidoPaterno())));
			tabla.addCell( new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph(atributos.getApellidoMaterno())));
			tabla.addCell( new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph(atributos.getNombre())));
			tabla.addCell( new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph(atributos.getNacimiento())));
			tabla.addCell( new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph(atributos.getEmail())));
			tabla.addCell( new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph(atributos.getEstudios())));
			tabla.addCell( new Cell().setTextAlignment(TextAlignment.CENTER).setBorderTop(new SolidBorder(2f)).add(new Paragraph(atributos.getTelefono())));

			doc.add(tabla);

			if(Desktop.isDesktopSupported()) {
				try {
					Desktop.getDesktop().open(select.getSelectedFile());
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo");
				}
			}

		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se pudo exportar el PDF");
		}

	} 
}


