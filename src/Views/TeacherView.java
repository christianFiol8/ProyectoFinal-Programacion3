package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import Controllers.AuthController;
import Controllers.GroupController;
import Controllers.HomeController;

import Controllers.StudentController;
import Controllers.SubjectController;
import Controllers.TeacherController;
import Models.atributosTeacher;
import Models.teacherModel;


public class TeacherView {

	private JFrame frame;
	public HomeController home;
	public StudentController student;
	public TeacherController teacher;
	public GroupController group;
	public SubjectController subject;
	public AuthController view;


	teacherModel model = new teacherModel();
	atributosTeacher texto = new atributosTeacher("", "", "", "", "", "", "", "","");
	public TeacherView() {
		// TODO Auto-generated constructor stub

		frame = new JFrame();
		frame.setVisible(false);
		frame.setBounds(400, 200, 790, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));		
	}

	public void docentesRegistradosPanel() {

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 128, 652, 243);
		panel.add(scrollPane);		
		frame.getContentPane().add(panel);


		JButton btnNewButton_14 = new JButton("Ver detalles");
		btnNewButton_14.setForeground(Color.white);
		btnNewButton_14.setOpaque(true);
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(236, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);
				frame.dispose();
				buscarIDPanel();
			}
		});
		panel.add(btnNewButton_14);

		List<List> datos = model.get();

		// Columnas de la tabla
		String[] columnNames = {"Apellido Paterno", "Apellido Materno", "Nombre(s)", "ID"};

		// Datos de la tabla
		Object[][] informacion = new Object[datos.size()][4];
		for (int i = 0; i < datos.size(); i++) {
			informacion[i][0] = datos.get(i).get(1);
			informacion[i][1] = datos.get(i).get(2);
			informacion[i][2] = datos.get(i).get(3);
			informacion[i][3] = datos.get(i).get(0);

		}

		// Crear el modelo de tabla con los datos obtenidos
		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		// Crear la tabla con el modelo
		JTable table = new JTable(tableModel);

		// Configuración de la tabla

		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.setFont(new Font("Inter", Font.BOLD, 13));
		table.setBounds(59, 128, 652, 243);
		table.setRowHeight(50);

		scrollPane.setViewportView(table);

		frame.setVisible(true);

		JLabel lblNewLabel_15 = new JLabel("Docentes registrados");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_15.setBounds(59, 92, 186, 30);		
		panel.add(lblNewLabel_15);

		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(59, 50, 110, 25);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				home = new HomeController();
				home.docentePanel();
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	//Con este lo busca de la tabla
	public void buscarIDPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 97, 450, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_15 = new JLabel("ID_Docente");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(155, 63, 139, 30);
		panel_1.add(lblNewLabel_15);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(80, 113, 300, 30);
		textField_2.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JTextField[] caracteres2TextFields = {textField_2};
		agregarFiltroNumerosATextFields(caracteres2TextFields, 10);

		JButton btnNewButton_14 = new JButton("Buscar docente");
		btnNewButton_14.setForeground(Color.white);
		btnNewButton_14.setOpaque(true);
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(80, 178, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los datos");
				} else {
					atributosTeacher idTexto = model.buscarDocentes(textField_2.getText());

					if (idTexto != null) {
						frame.remove(panel);
						frame.dispose();
						descargarInformacionDocente(idTexto.getDocentesId(), idTexto);
					} else {
						JOptionPane.showMessageDialog(null, "No encontrado");
					}
				}

			}
		});
		panel_1.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(59, 50, 110, 25);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				docentesRegistradosPanel();
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	//Con este lo consulta del ver datos
	public void buscarIDPanel2() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 97, 450, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_15 = new JLabel("ID_Docente");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(155, 63, 139, 30);
		panel_1.add(lblNewLabel_15);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(80, 113, 300, 30);
		textField_2.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JTextField[] caracteres2TextFields = {textField_2};
		agregarFiltroNumerosATextFields(caracteres2TextFields, 10);

		JButton btnNewButton_14 = new JButton("Buscar docente");
		btnNewButton_14.setForeground(Color.white);
		btnNewButton_14.setOpaque(true);
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(80, 178, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub


				if (textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los datos");
				} else {

					atributosTeacher idTexto = model.buscarDocentes(textField_2.getText());

					if (idTexto != null) {
						String buscar = textField_2.getText();

						frame.remove(panel);
						frame.dispose();
						descargarInformacionDocente2(idTexto.getDocentesId(), idTexto);
					} else {
						JOptionPane.showMessageDialog(null, "No encontrado");
					}
				}


			}
		});
		panel_1.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(59, 50, 110, 25);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				home = new HomeController();
				home.docentePanel();
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	//Este es desde la tabla, para ver a uno 
	public void descargarInformacionDocente(String idtexto, atributosTeacher atributos) {

		String idDocente = "";
		String apellidoPaterno = "";
		String apellidoMaterno = "";
		String nombre = "";
		String fechaDeNacimiento = "";
		String correoElectronico = "";
		String gradoDeEstudio = "";
		String telefono = "";
		String avatar = "";

		// Obtener los datos del objeto atributosTeacher si no es nulo
		if (atributos != null) {
			idDocente = atributos.getDocentesId();
			apellidoPaterno = atributos.getApellidoPaterno();
			apellidoMaterno = atributos.getApellidoMaterno();
			nombre = atributos.getNombre();
			fechaDeNacimiento = atributos.getNacimiento();
			correoElectronico = atributos.getEmail();
			gradoDeEstudio = atributos.getEstudios();
			telefono = atributos.getTelefono();
			avatar = atributos.getAvatar();
		}

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);


		JLabel lblNewLabel_15 = new JLabel("Descargar Información");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_15.setBounds(59, 92, 186, 30);		
		panel.add(lblNewLabel_15);

		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(59, 50, 110, 25);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				buscarIDPanel();
			}
		});
		panel.add(btnNewButton_15);

		JButton btnNewButton_14 = new JButton("Descargar Información");
		btnNewButton_14.setForeground(Color.white);
		btnNewButton_14.setOpaque(true);
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.generarPDFDatos(idtexto);
			}
		});
		panel.add(btnNewButton_14);

		JLabel lblNewLabel_25 = new JLabel("ID_docente");
		lblNewLabel_25.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25.setBounds(71, 10, 90, 13);
		panel_1.add(lblNewLabel_25);

		JLabel lblNewLabel_25_1 = new JLabel("Apellido Paterno");
		lblNewLabel_25_1.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_1.setBounds(38, 40, 144, 13);
		panel_1.add(lblNewLabel_25_1);

		JLabel lblNewLabel_25_2 = new JLabel("Apellido Materno");
		lblNewLabel_25_2.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_2.setBounds(36, 70, 144, 13);
		panel_1.add(lblNewLabel_25_2);

		JLabel lblNewLabel_25_3 = new JLabel("Nombre(s)");
		lblNewLabel_25_3.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_3.setBounds(76, 100, 144, 13);
		panel_1.add(lblNewLabel_25_3);

		JLabel lblNewLabel_25_3_1 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_25_3_1.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_3_1.setBounds(10, 130, 144, 13);
		panel_1.add(lblNewLabel_25_3_1);

		JLabel lblNewLabel_25_3_2 = new JLabel("Correo Electrónico");
		lblNewLabel_25_3_2.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_3_2.setBounds(24, 160, 144, 13);
		panel_1.add(lblNewLabel_25_3_2);

		JLabel lblNewLabel_25_3_3 = new JLabel("Grado de estudios");
		lblNewLabel_25_3_3.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_3_3.setBounds(25, 190, 144, 13);
		panel_1.add(lblNewLabel_25_3_3);

		JLabel lblNewLabel_25_3_4 = new JLabel("Teléfono");
		lblNewLabel_25_3_4.setBounds(87, 220, 144, 13);
		panel_1.add(lblNewLabel_25_3_4);
		lblNewLabel_25_3_4.setFont(new Font("Inter", Font.PLAIN, 13));

		JTextField textField_3 = new JTextField(idDocente);
		textField_3.setBounds(153, 7, 290, 19);
		textField_3.setBackground(Color.decode("#D9D9D9"));
		textField_3.setFont(new Font("Inter", Font.BOLD, 13));
		textField_3.setBorder(null);
		textField_3.setOpaque(false);
		textField_3.setEditable(false); // No editable
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JTextField textField_4 = new JTextField(apellidoPaterno);
		textField_4.setBounds(153, 37, 290, 19);
		textField_4.setBackground(Color.decode("#D9D9D9"));
		textField_4.setFont(new Font("Inter", Font.BOLD, 13));
		textField_4.setBorder(null);
		textField_4.setOpaque(false);
		textField_4.setEditable(false); // No editable
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		JTextField textField_5 = new JTextField(apellidoMaterno);
		textField_5.setBounds(153, 67, 290, 19);
		textField_5.setBackground(Color.decode("#D9D9D9"));
		textField_5.setFont(new Font("Inter", Font.BOLD, 13));
		textField_5.setBorder(null);
		textField_5.setOpaque(false);
		textField_5.setEditable(false); // No editable
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		JTextField textField_6 = new JTextField(nombre);
		textField_6.setBounds(153, 97, 290, 19);
		textField_6.setBackground(Color.decode("#D9D9D9"));
		textField_6.setFont(new Font("Inter", Font.BOLD, 13));
		textField_6.setBorder(null);
		textField_6.setOpaque(false);
		textField_6.setEditable(false); // No editable
		panel_1.add(textField_6);
		textField_6.setColumns(10);

		JTextField textField_7 = new JTextField(fechaDeNacimiento);
		textField_7.setBounds(153, 127, 290, 19);
		textField_7.setBackground(Color.decode("#D9D9D9"));
		textField_7.setFont(new Font("Inter", Font.BOLD, 13));
		textField_7.setBorder(null);
		textField_7.setOpaque(false);
		textField_7.setEditable(false); // No editable
		panel_1.add(textField_7);
		textField_7.setColumns(10);

		JTextField textField_8 = new JTextField(correoElectronico);
		textField_8.setBounds(153, 157, 290, 19);
		textField_8.setBackground(Color.decode("#D9D9D9"));
		textField_8.setFont(new Font("Inter", Font.BOLD, 13));
		textField_8.setBorder(null);
		textField_8.setOpaque(false);
		textField_8.setEditable(false); // No editable
		panel_1.add(textField_8);
		textField_8.setColumns(10);

		JTextField textField_9 = new JTextField(gradoDeEstudio);
		textField_9.setColumns(10);
		textField_9.setBounds(153, 187, 290, 19);
		textField_9.setBackground(Color.decode("#D9D9D9"));
		textField_9.setFont(new Font("Inter", Font.BOLD, 13));
		textField_9.setBorder(null);
		textField_9.setOpaque(false);
		textField_9.setEditable(false); // No editable
		panel_1.add(textField_9);

		JTextField textField_10 = new JTextField(telefono);
		textField_10.setColumns(10);
		textField_10.setBounds(153, 217, 290, 19);
		textField_10.setBackground(Color.decode("#D9D9D9"));
		textField_10.setFont(new Font("Inter", Font.BOLD, 13));
		textField_10.setBorder(null);
		textField_10.setOpaque(false);
		textField_10.setEditable(false); // No editable
		panel_1.add(textField_10);

		JLabel lblNewLabel_26 = new JLabel("Avatar de docente");
		lblNewLabel_26.setFont(new Font("Inter", Font.BOLD, 11));
		lblNewLabel_26.setBounds(502, 16, 111, 13);
		panel_1.add(lblNewLabel_26);

		ImageIcon iconoDescargar = new ImageIcon(getClass().getResource(avatar));
		JLabel etiquetaAvatar = new JLabel(iconoDescargar);
		etiquetaAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAvatar.setBounds(486, 39, 131, 123);
		etiquetaAvatar.setOpaque(true);
		etiquetaAvatar.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(etiquetaAvatar);

		JButton btnNewButton_20 = new JButton("Generar Credencial");
		btnNewButton_20.setBounds(477, 185, 151, 25);
		btnNewButton_20.setOpaque(true);
		btnNewButton_20.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				model.generarCredencial(idtexto);

			}
		});
		panel_1.add(btnNewButton_20);

		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void descargarInformacionDocente2(String idtexto, atributosTeacher atributos) {

		String idDocente = "";
		String apellidoPaterno = "";
		String apellidoMaterno = "";
		String nombre = "";
		String fechaDeNacimiento = "";
		String correoElectronico = "";
		String gradoDeEstudio = "";
		String telefono = "";
		String avatar = "";

		// Obtener los datos del objeto atributosTeacher si no es nulo
		if (atributos != null) {
			idDocente = atributos.getDocentesId();
			apellidoPaterno = atributos.getApellidoPaterno();
			apellidoMaterno = atributos.getApellidoMaterno();
			nombre = atributos.getNombre();
			fechaDeNacimiento = atributos.getNacimiento();
			correoElectronico = atributos.getEmail();
			gradoDeEstudio = atributos.getEstudios();
			telefono = atributos.getTelefono();
			avatar = atributos.getAvatar();
		}
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_15 = new JLabel("Descargar Información");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_15.setBounds(59, 92, 186, 30);		
		panel.add(lblNewLabel_15);

		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(59, 50, 110, 25);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				buscarIDPanel2();
			}
		});
		panel.add(btnNewButton_15);

		JButton btnNewButton_14 = new JButton("Descargar Información");
		btnNewButton_14.setForeground(Color.white);
		btnNewButton_14.setOpaque(true);
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				model.generarPDFDatos(idtexto);

			}
		});
		panel.add(btnNewButton_14);

		JLabel lblNewLabel_25 = new JLabel("ID_docente");
		lblNewLabel_25.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25.setBounds(71, 10, 90, 13);
		panel_1.add(lblNewLabel_25);

		JLabel lblNewLabel_25_1 = new JLabel("Apellido Paterno");
		lblNewLabel_25_1.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_1.setBounds(38, 40, 144, 13);
		panel_1.add(lblNewLabel_25_1);

		JLabel lblNewLabel_25_2 = new JLabel("Apellido Materno");
		lblNewLabel_25_2.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_2.setBounds(36, 70, 144, 13);
		panel_1.add(lblNewLabel_25_2);

		JLabel lblNewLabel_25_3 = new JLabel("Nombre(s)");
		lblNewLabel_25_3.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_3.setBounds(76, 100, 144, 13);
		panel_1.add(lblNewLabel_25_3);

		JLabel lblNewLabel_25_3_1 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_25_3_1.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_3_1.setBounds(10, 130, 144, 13);
		panel_1.add(lblNewLabel_25_3_1);

		JLabel lblNewLabel_25_3_2 = new JLabel("Correo Electrónico");
		lblNewLabel_25_3_2.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_3_2.setBounds(24, 160, 144, 13);
		panel_1.add(lblNewLabel_25_3_2);

		JLabel lblNewLabel_25_3_3 = new JLabel("Grado de estudios");
		lblNewLabel_25_3_3.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_3_3.setBounds(25, 190, 144, 13);
		panel_1.add(lblNewLabel_25_3_3);

		JLabel lblNewLabel_25_3_4 = new JLabel("Teléfono");
		lblNewLabel_25_3_4.setBounds(87, 220, 144, 13);
		panel_1.add(lblNewLabel_25_3_4);
		lblNewLabel_25_3_4.setFont(new Font("Inter", Font.PLAIN, 13));

		JTextField textField_3 = new JTextField(idDocente);
		textField_3.setBounds(153, 7, 290, 19);
		textField_3.setBackground(Color.decode("#D9D9D9"));
		textField_3.setFont(new Font("Inter", Font.BOLD, 13));
		textField_3.setBorder(null);
		textField_3.setOpaque(false);
		textField_3.setEditable(false); // No editable
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JTextField textField_4 = new JTextField(apellidoPaterno);
		textField_4.setBounds(153, 37, 290, 19);
		textField_4.setBackground(Color.decode("#D9D9D9"));
		textField_4.setFont(new Font("Inter", Font.BOLD, 13));
		textField_4.setBorder(null);
		textField_4.setOpaque(false);
		textField_4.setEditable(false); // No editable
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		JTextField textField_5 = new JTextField(apellidoMaterno);
		textField_5.setBounds(153, 67, 290, 19);
		textField_5.setBackground(Color.decode("#D9D9D9"));
		textField_5.setFont(new Font("Inter", Font.BOLD, 13));
		textField_5.setBorder(null);
		textField_5.setOpaque(false);
		textField_5.setEditable(false); // No editable
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		JTextField textField_6 = new JTextField(nombre);
		textField_6.setBounds(153, 97, 290, 19);
		textField_6.setBackground(Color.decode("#D9D9D9"));
		textField_6.setFont(new Font("Inter", Font.BOLD, 13));
		textField_6.setBorder(null);
		textField_6.setOpaque(false);
		textField_6.setEditable(false); // No editable
		panel_1.add(textField_6);
		textField_6.setColumns(10);

		JTextField textField_7 = new JTextField(fechaDeNacimiento);
		textField_7.setBounds(153, 127, 290, 19);
		textField_7.setBackground(Color.decode("#D9D9D9"));
		textField_7.setFont(new Font("Inter", Font.BOLD, 13));
		textField_7.setBorder(null);
		textField_7.setOpaque(false);
		textField_7.setEditable(false); // No editable
		panel_1.add(textField_7);
		textField_7.setColumns(10);

		JTextField textField_8 = new JTextField(correoElectronico);
		textField_8.setBounds(153, 157, 290, 19);
		textField_8.setBackground(Color.decode("#D9D9D9"));
		textField_8.setFont(new Font("Inter", Font.BOLD, 13));
		textField_8.setBorder(null);
		textField_8.setOpaque(false);
		textField_8.setEditable(false); // No editable
		panel_1.add(textField_8);
		textField_8.setColumns(10);

		JTextField textField_9 = new JTextField(gradoDeEstudio);
		textField_9.setColumns(10);
		textField_9.setBounds(153, 187, 290, 19);
		textField_9.setBackground(Color.decode("#D9D9D9"));
		textField_9.setFont(new Font("Inter", Font.BOLD, 13));
		textField_9.setBorder(null);
		textField_9.setOpaque(false);
		textField_9.setEditable(false); // No editable
		panel_1.add(textField_9);

		JTextField textField_10 = new JTextField(telefono);
		textField_10.setColumns(10);
		textField_10.setBounds(153, 217, 290, 19);
		textField_10.setBackground(Color.decode("#D9D9D9"));
		textField_10.setFont(new Font("Inter", Font.BOLD, 13));
		textField_10.setBorder(null);
		textField_10.setOpaque(false);
		textField_10.setEditable(false); // No editable
		panel_1.add(textField_10);

		JButton btnNewButton_20 = new JButton("Generar Credencial");
		btnNewButton_20.setBounds(477, 185, 151, 25);
		btnNewButton_20.setOpaque(true);
		btnNewButton_20.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				model.generarCredencial(idtexto);
			}
		});
		panel_1.add(btnNewButton_20);

		JLabel lblNewLabel_26 = new JLabel("Avatar de docente");
		lblNewLabel_26.setFont(new Font("Inter", Font.BOLD, 11));
		lblNewLabel_26.setBounds(502, 16, 111, 13);
		panel_1.add(lblNewLabel_26);

		ImageIcon iconoDescargar = new ImageIcon(getClass().getResource(avatar));
		JLabel etiquetaAvatar = new JLabel(iconoDescargar);
		etiquetaAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAvatar.setBounds(486, 39, 131, 123);
		etiquetaAvatar.setOpaque(true);
		etiquetaAvatar.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(etiquetaAvatar);

		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void crearDocentePanel(atributosTeacher atributos) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);


		ImageIcon iconoDescargar = new ImageIcon(getClass().getResource(atributos.getAvatar()));
		JLabel etiquetaAvatar = new JLabel(iconoDescargar);
		etiquetaAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAvatar.setBounds(486, 39, 131, 123);
		etiquetaAvatar.setOpaque(true);
		etiquetaAvatar.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(etiquetaAvatar);

		JLabel lblNewLabel_25 = new JLabel("ID_docente");
		lblNewLabel_25.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25.setBounds(72, 10, 90, 13);
		panel_1.add(lblNewLabel_25);

		JLabel lblNewLabel_25_1 = new JLabel("Apellido Paterno");
		lblNewLabel_25_1.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_1.setBounds(38, 40, 144, 13);
		panel_1.add(lblNewLabel_25_1);

		JLabel lblNewLabel_25_2 = new JLabel("Apellido Materno");
		lblNewLabel_25_2.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_2.setBounds(36, 70, 144, 13);
		panel_1.add(lblNewLabel_25_2);

		JLabel lblNewLabel_25_3 = new JLabel("Nombre(s)");
		lblNewLabel_25_3.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_3.setBounds(79, 100, 144, 13);
		panel_1.add(lblNewLabel_25_3);

		JLabel lblNewLabel_25_3_1 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_25_3_1.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_3_1.setBounds(10, 130, 144, 13);
		panel_1.add(lblNewLabel_25_3_1);

		JLabel lblNewLabel_25_3_2 = new JLabel("Correo Electrónico");
		lblNewLabel_25_3_2.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_3_2.setBounds(24, 160, 144, 13);
		panel_1.add(lblNewLabel_25_3_2);

		JLabel lblNewLabel_25_3_3 = new JLabel("Grado de estudios");
		lblNewLabel_25_3_3.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_3_3.setBounds(25, 190, 144, 13);
		panel_1.add(lblNewLabel_25_3_3);

		JLabel lblNewLabel_25_3_4 = new JLabel("Teléfono");
		lblNewLabel_25_3_4.setBounds(87, 220, 144, 13);
		panel_1.add(lblNewLabel_25_3_4);
		lblNewLabel_25_3_4.setFont(new Font("Inter", Font.BOLD, 13));

		JTextField textField_3 = new JTextField();
		textField_3.setBounds(153, 7, 290, 19);
		textField_3.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JTextField textField_4 = new JTextField();
		textField_4.setBounds(153, 37, 290, 19);
		textField_4.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		JTextField textField_5 = new JTextField();
		textField_5.setBounds(153, 67, 290, 19);
		textField_5.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		JTextField textField_6 = new JTextField();
		textField_6.setBounds(153, 97, 290, 19);
		textField_6.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_6);
		textField_6.setColumns(10);

		JTextField textField_7 = new JTextField();
		textField_7.setBounds(153, 127, 290, 19);
		textField_7.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_7);
		textField_7.setColumns(10);

		JTextField textField_8 = new JTextField();
		textField_8.setBounds(153, 157, 290, 19);
		textField_8.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_8);
		textField_8.setColumns(10);

		JTextField textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(153, 187, 290, 19);
		textField_9.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_9);

		JTextField textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(153, 217, 290, 19);
		textField_10.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_10);

		JButton btnNewButton_20 = new JButton("Elegir avatar");
		btnNewButton_20.setBounds(486, 185, 131, 25);
		btnNewButton_20.setOpaque(true);
		btnNewButton_20.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				atributos.setDocentesId(textField_3.getText());
				atributos.setApellidoPaterno(textField_4.getText());
				atributos.setApellidoMaterno(textField_5.getText());
				atributos.setNombre(textField_6.getText()); 
				atributos.setNacimiento(textField_7.getText()); 
				atributos.setEmail(textField_8.getText()); 
				atributos.setEstudios(textField_9.getText()); 
				atributos.setTelefono(textField_10.getText());
				frame.remove(panel);

				frame.dispose();
				seleccionAvatar(atributos);
			}
		});
		panel_1.add(btnNewButton_20);

		JLabel lblNewLabel_26 = new JLabel("Avatar de docente");
		lblNewLabel_26.setFont(new Font("Inter", Font.BOLD, 11));
		lblNewLabel_26.setBounds(502, 16, 111, 13);
		panel_1.add(lblNewLabel_26);

		JLabel lblNewLabel_15 = new JLabel("Crear Docente");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_15.setBounds(59, 92, 118, 30);
		panel.add(lblNewLabel_15);
		
		ImageIcon iconoDetallesMini = new ImageIcon(getClass().getResource("/Imagenes/Signo_Detalles.png"));

		JButton btnNewButton_29 = new JButton(iconoDetallesMini);
		btnNewButton_29.setBounds(449, 157, 24, 19);
		btnNewButton_29.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Formato de correo electrónico: Ejemplo: usuario@gmail.com");
			}
		});
		panel_1.add(btnNewButton_29);
		
		JButton btnNewButton_29_1 = new JButton(iconoDetallesMini);
		btnNewButton_29_1.setBounds(449, 127, 24, 19);
		btnNewButton_29_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Formato de fecha de cumpleaños: Ejemplo: dd/mm/aaaa");
			}
		});
		panel_1.add(btnNewButton_29_1);
		
		JButton btnNewButton_14 = new JButton("Crear Docente");
		btnNewButton_14.setForeground(Color.white);
		btnNewButton_14.setOpaque(true);
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(236, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JTextField[] textFields = {textField_3, textField_4, textField_5, textField_6, textField_7, textField_8, textField_9, textField_10};

				for (JTextField textField : textFields) {
					if (textField.getText().isEmpty()) {
						textField.setBorder(BorderFactory.createLineBorder(Color.red, 2));

					} else {
						textField.setBorder(BorderFactory.createLineBorder(Color.green, 2));
					}
				}

				
				
				if (textField_3.getText().isEmpty() || textField_4.getText().isEmpty() || 
						textField_5.getText().isEmpty() || textField_6.getText().isEmpty() || 
						textField_7.getText().isEmpty() || textField_8.getText().isEmpty() || 
						textField_9.getText().isEmpty() || textField_10.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!esCorreoValido(textField_8.getText())||!esFechaValida(textField_7.getText())) 
				{
					textField_7.setBorder(BorderFactory.createLineBorder(Color.red, 2));
					textField_8.setBorder(BorderFactory.createLineBorder(Color.red, 2));
					JOptionPane.showMessageDialog(null, "Formato de correo electrónico o fecha de nacimiento incorrecto");
						
				}else {
					
					String idDocente = textField_3.getText();
					String apellidoPaterno = textField_4.getText();
					String apellidoMaterno = textField_5.getText();
					String nombre = textField_6.getText();
					String fechaDeNacimiento = textField_7.getText();
					String correoElectronico = textField_8.getText();
					String grado = textField_9.getText();
					String Telefono = textField_10.getText();
					String avatar = atributos.getAvatar();
					model.añadirDocentes(idDocente,apellidoPaterno,apellidoMaterno,nombre,fechaDeNacimiento,correoElectronico,grado,Telefono,avatar);
					// Proceder con la edición si todos los campos están llenos
					frame.remove(panel);
					frame.dispose();
					docenteCreadoPanel();
				}

			}
		});
		panel.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(59, 50, 110, 25);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);

				frame.dispose();
				home = new HomeController();
				home.docentePanel();
			}
		});
		panel.add(btnNewButton_15);

		JTextField[] numerosTextFields = {textField_3, textField_10};
		agregarFiltroNumerosATextFields(numerosTextFields, 10);

		JTextField[] letrasTextFields = {textField_4, textField_5, textField_6, textField_9};
		agregarFiltroLetrasATextFields(letrasTextFields, 40);

		JTextField[] caracteresTextFields = {textField_7 };
		agregarLimiteCaracteresATextFields(caracteresTextFields, 20);

		JTextField[] caracteres2TextFields = {textField_8};
		agregarLimiteCaracteresATextFields(caracteres2TextFields, 40);

		if (atributos!=null)
		{
			textField_3.setText(atributos.getDocentesId());
			textField_4.setText(atributos.getApellidoPaterno());
			textField_5.setText(atributos.getApellidoMaterno());
			textField_6.setText(atributos.getNombre());
			textField_7.setText(atributos.getNacimiento());
			textField_8.setText(atributos.getEmail());
			textField_9.setText(atributos.getEstudios());
			textField_10.setText(atributos.getTelefono());

		}


		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	private boolean esCorreoValido(String correo) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{3,3})$");
		Matcher mather = pattern.matcher(correo);
		return mather.find();
	}
	
	private boolean esFechaValida(String fecha) {
		Pattern pattern = Pattern.compile("^([0-2][0-9]|(3)[0-1])/((0)[0-9]|(1)[0-2])/((19|20)\\d\\d)$");
		Matcher mather = pattern.matcher(fecha);
		return mather.find();
	}
	
	public void seleccionAvatar(atributosTeacher atributos) {


		JPanel panelseleccionAvatar = new JPanel();
		panelseleccionAvatar.setLayout(null);
		panelseleccionAvatar.setBackground(Color.decode("#C3E1F1"));

		JLabel lblNewLabel_13 = new JLabel("Selecciona tu avatar");
		lblNewLabel_13.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_13.setBounds(259, 32, 256, 30);
		panelseleccionAvatar.add(lblNewLabel_13);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 70, 536, 304);
		panelseleccionAvatar.add(scrollPane);		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#4A85A4"));
		panel_1.setLayout(new GridLayout(5, 3, 50, 40));
		panel_1.setBorder(new EmptyBorder(40, 60, 40, 60));
		scrollPane.setViewportView(panel_1);

		String[] imagePaths = {
				"/Imagenes/Icono_Avatar_Hacker.png",
				"/Imagenes/Icono_Avatar_Panda.png",
				"/Imagenes/Icono_Avatar_Gallina.png",
				"/Imagenes/Icono_Avatar_Chico.png",
				"/Imagenes/Icono_Avatar_Chico_2.png",
				"/Imagenes/Icono_Avatar_Dinosaurio.png",
				"/Imagenes/Icono_Avatar_Hombre.png",
				"/Imagenes/Icono_Avatar_Mujer.png",
				"/Imagenes/Icono_Avatar_Oso.png",
				"/Imagenes/Icono_Avatar_Astronauta.png",
				"/Imagenes/Icono_Avatar_Lobo_Marino.png",
				"/Imagenes/Icono_Avatar_Robot.png",
				"/Imagenes/Icono_Avatar_Zorro.png",
				"/Imagenes/Icono_Avatar_Bot.png",
				"/Imagenes/Icono_Avatar_Gato.png"
		};

		final String[] selectedImagePath = new String[1];

		for (int i = 0; i <= 14; i++) {
			ImageIcon iconoAvatar = new ImageIcon(getClass().getResource(imagePaths[i]));
			RoundedButton button = new RoundedButton(iconoAvatar, Color.decode("#D9D9D9"));
			final String imagePath = imagePaths[i];
			button.setPreferredSize(new Dimension(94, 94));
			
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					System.out.println(imagePath);

					// TODO Auto-generated method stub
					 selectedImagePath[0] = imagePath;
				}
			});
			panel_1.add(button);

			JButton btnNewButton_14 = new JButton("Guardar");
			btnNewButton_14.setForeground(Color.white);
			btnNewButton_14.setOpaque(true);
			btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
			btnNewButton_14.setBackground(Color.decode("#4A85A4"));
			btnNewButton_14.setBounds(229, 384, 300, 30);
			btnNewButton_14.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					if (selectedImagePath[0] != null) {
		                atributos.setAvatar(selectedImagePath[0]);
		                frame.remove(panelseleccionAvatar);
		                frame.dispose();
		                crearDocentePanel(atributos);
		            } else {
		                JOptionPane.showMessageDialog(frame, "Por favor, seleccione un avatar.", "Error", JOptionPane.ERROR_MESSAGE);
		            }


				}
			});
			panelseleccionAvatar.add(btnNewButton_14);
		}	

		frame.add(panelseleccionAvatar);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}


	public void docenteCreadoPanel() {

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 67, 450, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);

		ImageIcon iconoPregunta = new ImageIcon(getClass().getResource("/Imagenes/like.png"));
		JLabel lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setIcon(iconoPregunta);
		lblNewLabel_14.setBounds(190, 44, 70, 70);
		panel_1.add(lblNewLabel_14);

		JLabel lblNewLabel_12 = new JLabel("Docente creado con éxito");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(96, 140, 300, 21);
		panel_1.add(lblNewLabel_12);

		JButton btnNewButton_7 = new JButton("Volver a inicio");
		btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_7.setForeground(Color.white);
		btnNewButton_7.setOpaque(true);
		btnNewButton_7.setBackground(Color.decode("#4A85A4"));
		btnNewButton_7.setBounds(142, 192, 167, 25);
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();

				home = new HomeController();
				home.docentePanel();
			}
		});
		panel_1.add(btnNewButton_7);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	//Con este edita la informacion

	public void buscarIDPanel3() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 97, 450, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_15 = new JLabel("ID_Docente");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(155, 63, 139, 30);
		panel_1.add(lblNewLabel_15);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(80, 113, 300, 30);
		textField_2.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JTextField[] caracteres2TextFields = {textField_2};
		agregarFiltroNumerosATextFields(caracteres2TextFields, 10);

		JButton btnNewButton_14 = new JButton("Buscar docente");
		btnNewButton_14.setForeground(Color.white);
		btnNewButton_14.setOpaque(true);
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(80, 178, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los datos");
				} else {
					atributosTeacher idTexto = model.buscarDocentes(textField_2.getText());

					if (idTexto != null) {
						frame.remove(panel);
						frame.dispose();
						confirmarEditarDocente(idTexto.getDocentesId(), idTexto);
					} else {
						JOptionPane.showMessageDialog(null, "No encontrado");
					}
				}

			}
		});
		panel_1.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(59, 50, 110, 25);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				home = new HomeController();
				home.docentePanel();
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	//Con este confirma los cambios del usuario a editar

	public void confirmarEditarDocente(String idtexto, atributosTeacher atributos) {

		String idDocente = "";
		String apellidoPaterno = "";
		String apellidoMaterno = "";
		String nombre = "";
		String fechaDeNacimiento = "";
		String correoElectronico = "";
		String gradoDeEstudio = "";
		String telefono = "";
		String avatar = "";

		// Obtener los datos del objeto atributosTeacher si no es nulo
		if (atributos != null) {
			idDocente = atributos.getDocentesId();
			apellidoPaterno = atributos.getApellidoPaterno();
			apellidoMaterno = atributos.getApellidoMaterno();
			nombre = atributos.getNombre();
			fechaDeNacimiento = atributos.getNacimiento();
			correoElectronico = atributos.getEmail();
			gradoDeEstudio = atributos.getEstudios();
			telefono = atributos.getTelefono();
			avatar = atributos.getAvatar();
		}

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_15 = new JLabel("Editar información");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_15.setBounds(59, 92, 186, 30);		
		panel.add(lblNewLabel_15);


		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(59, 50, 110, 25);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				buscarIDPanel3();
			}
		});
		panel.add(btnNewButton_15);

		JLabel lblNewLabel_25 = new JLabel("ID_docente");
		lblNewLabel_25.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25.setBounds(72, 10, 90, 13);
		panel_1.add(lblNewLabel_25);

		JLabel lblNewLabel_25_1 = new JLabel("Apellido Paterno");
		lblNewLabel_25_1.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_1.setBounds(38, 40, 144, 13);
		panel_1.add(lblNewLabel_25_1);

		JLabel lblNewLabel_25_2 = new JLabel("Apellido Materno");
		lblNewLabel_25_2.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_2.setBounds(36, 70, 144, 13);
		panel_1.add(lblNewLabel_25_2);

		JLabel lblNewLabel_25_3 = new JLabel("Nombre(s)");
		lblNewLabel_25_3.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_3.setBounds(79, 100, 144, 13);
		panel_1.add(lblNewLabel_25_3);

		JLabel lblNewLabel_25_3_1 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_25_3_1.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_3_1.setBounds(10, 130, 144, 13);
		panel_1.add(lblNewLabel_25_3_1);

		JLabel lblNewLabel_25_3_2 = new JLabel("Correo Electrónico");
		lblNewLabel_25_3_2.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_3_2.setBounds(24, 160, 144, 13);
		panel_1.add(lblNewLabel_25_3_2);

		JLabel lblNewLabel_25_3_3 = new JLabel("Grado de estudios");
		lblNewLabel_25_3_3.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_3_3.setBounds(25, 190, 144, 13);
		panel_1.add(lblNewLabel_25_3_3);

		JLabel lblNewLabel_25_3_4 = new JLabel("Teléfono");
		lblNewLabel_25_3_4.setBounds(87, 220, 144, 13);
		panel_1.add(lblNewLabel_25_3_4);
		lblNewLabel_25_3_4.setFont(new Font("Inter", Font.BOLD, 13));

		JTextField textField_3 = new JTextField(idtexto);
		textField_3.setEditable(false);
		textField_3.setBounds(153, 7, 290, 19);
		textField_3.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JTextField textField_4 = new JTextField(apellidoPaterno);
		textField_4.setBounds(153, 37, 290, 19);
		textField_4.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		JTextField textField_5 = new JTextField(apellidoMaterno);
		textField_5.setBounds(153, 67, 290, 19);
		textField_5.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		JTextField textField_6 = new JTextField(nombre);
		textField_6.setBounds(153, 97, 290, 19);
		textField_6.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_6);
		textField_6.setColumns(10);

		JTextField textField_7 = new JTextField(fechaDeNacimiento);
		textField_7.setBounds(153, 127, 290, 19);
		textField_7.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_7);
		textField_7.setColumns(10);

		JTextField textField_8 = new JTextField(correoElectronico);
		textField_8.setBounds(153, 157, 290, 19);
		textField_8.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_8);
		textField_8.setColumns(10);

		JTextField textField_9 = new JTextField(gradoDeEstudio);
		textField_9.setColumns(10);
		textField_9.setBounds(153, 187, 290, 19);
		textField_9.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_9);

		JTextField textField_10 = new JTextField(telefono);
		textField_10.setColumns(10);
		textField_10.setBounds(153, 217, 290, 19);
		textField_10.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_10);

		JButton btnNewButton_20 = new JButton("Cambiar avatar");
		btnNewButton_20.setBounds(486, 185, 131, 25);
		btnNewButton_20.setOpaque(true);
		btnNewButton_20.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				atributos.setDocentesId(textField_3.getText());
				atributos.setApellidoPaterno(textField_4.getText());
				atributos.setApellidoMaterno(textField_5.getText());
				atributos.setNombre(textField_6.getText()); 
				atributos.setNacimiento(textField_7.getText()); 
				atributos.setEmail(textField_8.getText()); 
				atributos.setEstudios(textField_9.getText()); 
				atributos.setTelefono(textField_10.getText());
				frame.remove(panel);
				frame.dispose();
				

				seleccionAvatar2(idtexto,atributos);
			}
		});
		panel_1.add(btnNewButton_20);
		
		JLabel lblNewLabel_26 = new JLabel("Avatar de docente");
		lblNewLabel_26.setFont(new Font("Inter", Font.BOLD, 11));
		lblNewLabel_26.setBounds(502, 16, 111, 13);
		panel_1.add(lblNewLabel_26);

		ImageIcon iconoDescargar = new ImageIcon(getClass().getResource(avatar));
		JLabel etiquetaAvatar = new JLabel(iconoDescargar);
		etiquetaAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAvatar.setBounds(486, 39, 131, 123);
		etiquetaAvatar.setOpaque(true);
		etiquetaAvatar.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(etiquetaAvatar);
		
		ImageIcon iconoDetallesMini = new ImageIcon(getClass().getResource("/Imagenes/Signo_Detalles.png"));

		JButton btnNewButton_29 = new JButton(iconoDetallesMini);
		btnNewButton_29.setBounds(449, 157, 24, 19);
		btnNewButton_29.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Formato de correo electrónico: Ejemplo: usuario@gmail.com");
			}
		});
		panel_1.add(btnNewButton_29);
		
		JButton btnNewButton_29_1 = new JButton(iconoDetallesMini);
		btnNewButton_29_1.setBounds(449, 127, 24, 19);
		btnNewButton_29_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Formato de fecha de cumpleaños: Ejemplo: dd/mm/aaaa");
			}
		});
		panel_1.add(btnNewButton_29_1);

		JButton btnNewButton_14 = new JButton("Confirmar cambios");
		btnNewButton_14.setForeground(Color.white);
		btnNewButton_14.setOpaque(true);
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JTextField[] textFields = {textField_4, textField_5, textField_6, textField_7, textField_8, textField_9, textField_10};

				for (JTextField textField : textFields) {
					if (textField.getText().isEmpty()) {
						textField.setBorder(BorderFactory.createLineBorder(Color.red, 2));

					} else {
						textField.setBorder(BorderFactory.createLineBorder(Color.green, 2));
					}
				}

				if (textField_3.getText().isEmpty() || textField_4.getText().isEmpty() || 
						textField_5.getText().isEmpty() || textField_6.getText().isEmpty() || 
						textField_7.getText().isEmpty() || textField_8.getText().isEmpty() || 
						textField_9.getText().isEmpty() || textField_10.getText().isEmpty()) {


					JOptionPane.showMessageDialog(frame, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!esCorreoValido(textField_8.getText())||!esFechaValida(textField_7.getText())) 
				{
					textField_7.setBorder(BorderFactory.createLineBorder(Color.red, 2));
					textField_8.setBorder(BorderFactory.createLineBorder(Color.red, 2));
					JOptionPane.showMessageDialog(null, "Formato de correo electrónico o fecha de nacimiento incorrecto");
						
				}else {
					String idTexto = textField_3.getText();
					String apellidoPaterno = textField_4.getText();
					String apellidoMaterno = textField_5.getText();
					String nombre = textField_6.getText();
					String fechaDeNacimiento = textField_7.getText();
					String correoElectronico = textField_8.getText();
					String grado = textField_9.getText();
					String telefono = textField_10.getText();
					String avatar = atributos.getAvatar();
					// Proceder con la edición si todos los campos están llenos
					frame.remove(panel);
					frame.dispose();
					model.editarDocentes(idTexto, apellidoPaterno, apellidoMaterno, nombre, fechaDeNacimiento, correoElectronico, grado, telefono,avatar);
					cambiosGuardadosPanel();
				}


			}
		});

		JTextField[] numerosTextFields = {textField_3, textField_10};
		agregarFiltroNumerosATextFields(numerosTextFields, 10);

		JTextField[] letrasTextFields = {textField_4, textField_5, textField_6, textField_9};
		agregarFiltroLetrasATextFields(letrasTextFields, 40);

		JTextField[] caracteresTextFields = {textField_7 };
		agregarLimiteCaracteresATextFields(caracteresTextFields, 20);

		JTextField[] caracteres2TextFields = {textField_8};
		agregarLimiteCaracteresATextFields(caracteres2TextFields, 40);

		panel.add(btnNewButton_14);
		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void seleccionAvatar2(String idTetxto, atributosTeacher atributos) {

		JPanel panelseleccionAvatar = new JPanel();
		panelseleccionAvatar.setLayout(null);
		panelseleccionAvatar.setBackground(Color.decode("#C3E1F1"));

		JLabel lblNewLabel_13 = new JLabel("Selecciona tu avatar");
		lblNewLabel_13.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_13.setBounds(259, 32, 256, 30);
		panelseleccionAvatar.add(lblNewLabel_13);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 70, 536, 304);
		panelseleccionAvatar.add(scrollPane);		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#4A85A4"));
		panel_1.setLayout(new GridLayout(5, 3, 50, 40));
		panel_1.setBorder(new EmptyBorder(40, 60, 40, 60));
		scrollPane.setViewportView(panel_1);

		String[] imagePaths = {
				"/Imagenes/Icono_Avatar_Hacker.png",
				"/Imagenes/Icono_Avatar_Panda.png",
				"/Imagenes/Icono_Avatar_Gallina.png",
				"/Imagenes/Icono_Avatar_Chico.png",
				"/Imagenes/Icono_Avatar_Chico_2.png",
				"/Imagenes/Icono_Avatar_Dinosaurio.png",
				"/Imagenes/Icono_Avatar_Hombre.png",
				"/Imagenes/Icono_Avatar_Mujer.png",
				"/Imagenes/Icono_Avatar_Oso.png",
				"/Imagenes/Icono_Avatar_Astronauta.png",
				"/Imagenes/Icono_Avatar_Lobo_Marino.png",
				"/Imagenes/Icono_Avatar_Robot.png",
				"/Imagenes/Icono_Avatar_Zorro.png",
				"/Imagenes/Icono_Avatar_Bot.png",
				"/Imagenes/Icono_Avatar_Gato.png"
		};
		final String[] selectedImagePath = new String[1];

		for (int i = 0; i <= 14; i++) {
			ImageIcon iconoAvatar = new ImageIcon(getClass().getResource(imagePaths[i]));

			RoundedButton button = new RoundedButton(iconoAvatar, Color.decode("#D9D9D9"));
			final String imagePath = imagePaths[i];
			button.setPreferredSize(new Dimension(94, 94));
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 selectedImagePath[0] = imagePath;
				}
			});
			panel_1.add(button);

			JButton btnNewButton_14 = new JButton("Guardar");
			btnNewButton_14.setForeground(Color.white);
			btnNewButton_14.setOpaque(true);
			btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
			btnNewButton_14.setBackground(Color.decode("#4A85A4"));
			btnNewButton_14.setBounds(229, 384, 300, 30);
			btnNewButton_14.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if (selectedImagePath[0] != null) {
		                atributos.setAvatar(selectedImagePath[0]);
		                frame.remove(panelseleccionAvatar);
		                frame.dispose();
						confirmarEditarDocente(idTetxto,atributos);
		            } else {
		                JOptionPane.showMessageDialog(frame, "Por favor, seleccione un avatar.", "Error", JOptionPane.ERROR_MESSAGE);
		            }

				}
			});
			panelseleccionAvatar.add(btnNewButton_14);
		}	

		frame.add(panelseleccionAvatar);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}



	//Aqui se tiene que guardar los datos para editar 

	public void confirmacionEditarPanel(String idTexto, atributosTeacher atributos, String apellidoPaterno, String apellidoMaterno, String nombre, 
			String fechaDeNacimiento, String correoElectronico,String Grado, String telefono) {

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 67, 450, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_12 = new JLabel("Por favor, confirme");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(128, 126, 209, 21);
		panel_1.add(lblNewLabel_12);

		ImageIcon iconoDescargar = new ImageIcon(getClass().getResource("/Imagenes/Icono_Advertencia.png"));
		JLabel lblNewLabel_27 = new JLabel(iconoDescargar);
		lblNewLabel_27.setBounds(189, 40, 70, 70);
		panel_1.add(lblNewLabel_27);

		JButton btnNewButton_7 = new JButton("No,volver");
		btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_7.setForeground(Color.white);
		btnNewButton_7.setOpaque(true);
		btnNewButton_7.setBackground(Color.decode("#4A85A4"));
		btnNewButton_7.setBounds(38, 200, 167, 25);
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);

				frame.dispose();
				confirmarEditarDocente(idTexto,atributos);
			}
		});
		panel_1.add(btnNewButton_7);

		JLabel lblNewLabel_24 = new JLabel("¿Esta seguro de que quiere editar a este docente?");
		lblNewLabel_24.setFont(new Font("Inter", Font.BOLD, 11));
		lblNewLabel_24.setBounds(86, 157, 300, 13);
		panel_1.add(lblNewLabel_24);

		JButton btnNewButton_21 = new JButton("Si,estoy seguro");
		btnNewButton_7.setOpaque(true);
		btnNewButton_21.setBackground(new Color(255, 255, 255));
		btnNewButton_21.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_21.setBorder(BorderFactory.createLineBorder(Color.decode("#4A85A4") , 2));
		btnNewButton_21.setBounds(242, 200, 167, 25);
		btnNewButton_21.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				model.editarDocentes(idTexto, apellidoPaterno, apellidoMaterno, nombre, fechaDeNacimiento, correoElectronico, Grado, telefono,null);
				frame.dispose();
				cambiosGuardadosPanel();
			}
		});
		panel_1.add(btnNewButton_21);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void cambiosGuardadosPanel() {

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 67, 450, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);

		ImageIcon iconoPregunta = new ImageIcon(getClass().getResource("/Imagenes/checked (2).png"));
		JLabel lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setIcon(iconoPregunta);
		lblNewLabel_14.setBounds(193, 34, 70, 70);
		panel_1.add(lblNewLabel_14);

		JLabel lblNewLabel_12 = new JLabel("Cambios guardados");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(125, 130, 284, 25);
		panel_1.add(lblNewLabel_12);

		JButton btnNewButton_7 = new JButton("Volver a inicio");
		btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_7.setForeground(Color.white);
		btnNewButton_7.setOpaque(true);
		btnNewButton_7.setBackground(Color.decode("#4A85A4"));
		btnNewButton_7.setBounds(142, 182, 167, 25);
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();

				home = new HomeController();
				home.docentePanel();
			}
		});
		panel_1.add(btnNewButton_7);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	//Este es para eliminar los docentes

	public void buscarIDPanel4() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 97, 450, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_15 = new JLabel("ID_Docente");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(155, 63, 139, 30);
		panel_1.add(lblNewLabel_15);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(80, 113, 300, 30);
		textField_2.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JTextField[] caracteres2TextFields = {textField_2};
		agregarFiltroNumerosATextFields(caracteres2TextFields, 10);

		JButton btnNewButton_14 = new JButton("Buscar docente");
		btnNewButton_14.setForeground(Color.white);
		btnNewButton_14.setOpaque(true);
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(80, 178, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub



				if (textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los datos");
				} else {
					atributosTeacher idTexto = model.buscarDocentes(textField_2.getText());

					if (idTexto != null) {
						frame.remove(panel);
						frame.dispose();
						eliminarDocentePanel(idTexto.getDocentesId(), idTexto);
					} else {
						JOptionPane.showMessageDialog(null, "No encontrado");
					}
				}


			}
		});
		panel_1.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(59, 50, 110, 25);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				home = new HomeController();
				home.docentePanel();
			}
		});
		panel.add(btnNewButton_15);

		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}


	public void eliminarDocentePanel(String idtexto, atributosTeacher atributos) {


		String idDocente = "";
		String apellidoPaterno = "";
		String apellidoMaterno = "";
		String nombre = "";
		String fechaDeNacimiento = "";
		String correoElectronico = "";
		String gradoDeEstudio = "";
		String telefono = "";
		String avatar = "";

		// Obtener los datos del objeto atributosTeacher si no es nulo
		if (atributos != null) {
			idDocente = atributos.getDocentesId();
			apellidoPaterno = atributos.getApellidoPaterno();
			apellidoMaterno = atributos.getApellidoMaterno();
			nombre = atributos.getNombre();
			fechaDeNacimiento = atributos.getNacimiento();
			correoElectronico = atributos.getEmail();
			gradoDeEstudio = atributos.getEstudios();
			telefono = atributos.getTelefono();
			avatar = atributos.getAvatar();
		}


		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_26 = new JLabel("Avatar de docente");
		lblNewLabel_26.setFont(new Font("Inter", Font.BOLD, 11));
		lblNewLabel_26.setBounds(502, 16, 111, 13);
		panel_1.add(lblNewLabel_26);

		ImageIcon iconoDescargar = new ImageIcon(getClass().getResource(avatar));
		JLabel etiquetaAvatar = new JLabel(iconoDescargar);
		etiquetaAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAvatar.setBounds(486, 39, 131, 123);
		etiquetaAvatar.setOpaque(true);
		etiquetaAvatar.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(etiquetaAvatar);

		JLabel lblNewLabel_15 = new JLabel("Eliminar Docente");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_15.setBounds(59, 92, 158, 30);
		panel.add(lblNewLabel_15);

		JButton btnNewButton_14 = new JButton("Eliminar Docente");
		btnNewButton_14.setForeground(Color.white);
		btnNewButton_14.setOpaque(true);
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				confirmarEliminarPanel(idtexto,atributos);
			}
		});
		panel.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setOpaque(true);
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(59, 50, 110, 25);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				buscarIDPanel4();
			}
		});
		panel.add(btnNewButton_15);

		JLabel lblNewLabel_25 = new JLabel("ID_docente");
		lblNewLabel_25.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25.setBounds(71, 10, 90, 13);
		panel_1.add(lblNewLabel_25);

		JLabel lblNewLabel_25_1 = new JLabel("Apellido Paterno");
		lblNewLabel_25_1.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_1.setBounds(38, 40, 144, 13);
		panel_1.add(lblNewLabel_25_1);

		JLabel lblNewLabel_25_2 = new JLabel("Apellido Materno");
		lblNewLabel_25_2.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_2.setBounds(36, 70, 144, 13);
		panel_1.add(lblNewLabel_25_2);

		JLabel lblNewLabel_25_3 = new JLabel("Nombre(s)");
		lblNewLabel_25_3.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_3.setBounds(76, 100, 144, 13);
		panel_1.add(lblNewLabel_25_3);

		JLabel lblNewLabel_25_3_1 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_25_3_1.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_3_1.setBounds(10, 130, 144, 13);
		panel_1.add(lblNewLabel_25_3_1);

		JLabel lblNewLabel_25_3_2 = new JLabel("Correo Electrónico");
		lblNewLabel_25_3_2.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_3_2.setBounds(24, 160, 144, 13);
		panel_1.add(lblNewLabel_25_3_2);

		JLabel lblNewLabel_25_3_3 = new JLabel("Grado de estudios");
		lblNewLabel_25_3_3.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_25_3_3.setBounds(25, 190, 144, 13);
		panel_1.add(lblNewLabel_25_3_3);

		JLabel lblNewLabel_25_3_4 = new JLabel("Teléfono");
		lblNewLabel_25_3_4.setBounds(87, 220, 144, 13);
		panel_1.add(lblNewLabel_25_3_4);
		lblNewLabel_25_3_4.setFont(new Font("Inter", Font.PLAIN, 13));

		JTextField textField_3 = new JTextField(idDocente);
		textField_3.setBounds(153, 7, 290, 19);
		textField_3.setBackground(Color.decode("#D9D9D9"));
		textField_3.setFont(new Font("Inter", Font.BOLD, 13));
		textField_3.setBorder(null);
		textField_3.setOpaque(false);
		textField_3.setEditable(false); // No editable
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JTextField textField_4 = new JTextField(apellidoPaterno);
		textField_4.setBounds(153, 37, 290, 19);
		textField_4.setBackground(Color.decode("#D9D9D9"));
		textField_4.setFont(new Font("Inter", Font.BOLD, 13));
		textField_4.setBorder(null);
		textField_4.setOpaque(false);
		textField_4.setEditable(false); // No editable
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		JTextField textField_5 = new JTextField(apellidoMaterno);
		textField_5.setBounds(153, 67, 290, 19);
		textField_5.setBackground(Color.decode("#D9D9D9"));
		textField_5.setFont(new Font("Inter", Font.BOLD, 13));
		textField_5.setBorder(null);
		textField_5.setOpaque(false);
		textField_5.setEditable(false); // No editable
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		JTextField textField_6 = new JTextField(nombre);
		textField_6.setBounds(153, 97, 290, 19);
		textField_6.setBackground(Color.decode("#D9D9D9"));
		textField_6.setFont(new Font("Inter", Font.BOLD, 13));
		textField_6.setBorder(null);
		textField_6.setOpaque(false);
		textField_6.setEditable(false); // No editable
		panel_1.add(textField_6);
		textField_6.setColumns(10);

		JTextField textField_7 = new JTextField(fechaDeNacimiento);
		textField_7.setBounds(153, 127, 290, 19);
		textField_7.setBackground(Color.decode("#D9D9D9"));
		textField_7.setFont(new Font("Inter", Font.BOLD, 13));
		textField_7.setBorder(null);
		textField_7.setOpaque(false);
		textField_7.setEditable(false); // No editable
		panel_1.add(textField_7);
		textField_7.setColumns(10);

		JTextField textField_8 = new JTextField(correoElectronico);
		textField_8.setBounds(153, 157, 290, 19);
		textField_8.setBackground(Color.decode("#D9D9D9"));
		textField_8.setFont(new Font("Inter", Font.BOLD, 13));
		textField_8.setBorder(null);
		textField_8.setOpaque(false);
		textField_8.setEditable(false); // No editable
		panel_1.add(textField_8);
		textField_8.setColumns(10);

		JTextField textField_9 = new JTextField(gradoDeEstudio);
		textField_9.setColumns(10);
		textField_9.setBounds(153, 187, 290, 19);
		textField_9.setBackground(Color.decode("#D9D9D9"));
		textField_9.setFont(new Font("Inter", Font.BOLD, 13));
		textField_9.setBorder(null);
		textField_9.setOpaque(false);
		textField_9.setEditable(false); // No editable
		panel_1.add(textField_9);

		JTextField textField_10 = new JTextField(telefono);
		textField_10.setColumns(10);
		textField_10.setBounds(153, 217, 290, 19);
		textField_10.setBackground(Color.decode("#D9D9D9"));
		textField_10.setFont(new Font("Inter", Font.BOLD, 13));
		textField_10.setBorder(null);
		textField_10.setOpaque(false);
		textField_10.setEditable(false); // No editable
		panel_1.add(textField_10);

		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void confirmarEliminarPanel(String idtexto, atributosTeacher atributos) {

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 67, 450, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_12 = new JLabel("Por favor, confirme");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(128, 126, 209, 21);
		panel_1.add(lblNewLabel_12);

		ImageIcon iconoDescargar = new ImageIcon(getClass().getResource("/Imagenes/Icono_Advertencia.png"));
		JLabel lblNewLabel_27 = new JLabel(iconoDescargar);
		lblNewLabel_27.setBounds(189, 40, 70, 70);
		panel_1.add(lblNewLabel_27);

		JButton btnNewButton_7 = new JButton("No,volver");
		btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_7.setForeground(Color.white);
		btnNewButton_7.setOpaque(true);
		btnNewButton_7.setBackground(Color.decode("#4A85A4"));
		btnNewButton_7.setBounds(38, 200, 167, 25);
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				eliminarDocentePanel(idtexto,atributos);
			}
		});
		panel_1.add(btnNewButton_7);

		JLabel lblNewLabel_24 = new JLabel("¿Esta seguro de que quiere eliminar a este docente?");
		lblNewLabel_24.setFont(new Font("Inter", Font.BOLD, 11));
		lblNewLabel_24.setBounds(84, 157, 300, 13);
		panel_1.add(lblNewLabel_24);

		JButton btnNewButton_21 = new JButton("Si,estoy seguro");
		btnNewButton_7.setOpaque(true);
		btnNewButton_21.setBackground(new Color(255, 255, 255));
		btnNewButton_21.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_21.setBorder(BorderFactory.createLineBorder(Color.decode("#4A85A4") , 2));
		btnNewButton_21.setBounds(242, 200, 167, 25);
		btnNewButton_21.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub




				model.eliminarDocente(idtexto);
				frame.remove(panel);
				frame.dispose();
				docenteEliminadoPanel();


			}
		});
		panel_1.add(btnNewButton_21);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void docenteEliminadoPanel() {

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 67, 450, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);

		ImageIcon iconoPregunta = new ImageIcon(getClass().getResource("/Imagenes/like.png"));
		JLabel lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setIcon(iconoPregunta);
		lblNewLabel_14.setBounds(190, 34, 70, 70);
		panel_1.add(lblNewLabel_14);

		JLabel lblNewLabel_12 = new JLabel("Docente eliminado con éxito");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(82, 130, 300, 21);
		panel_1.add(lblNewLabel_12);

		JButton btnNewButton_7 = new JButton("Volver a inicio");
		btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_7.setForeground(Color.white);
		btnNewButton_7.setOpaque(true);
		btnNewButton_7.setBackground(Color.decode("#4A85A4"));
		btnNewButton_7.setBounds(142, 182, 167, 25);
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();

				home = new HomeController();
				home.docentePanel();
			}
		});
		panel_1.add(btnNewButton_7);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void ConfirmarCerrarSesionPanel(JPanel panelCopia) {

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 67, 450, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);

		ImageIcon iconoPregunta = new ImageIcon(getClass().getResource("/Imagenes/logout.png"));
		JLabel lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setIcon(iconoPregunta);
		lblNewLabel_14.setBounds(190, 34, 70, 70);
		panel_1.add(lblNewLabel_14);

		JLabel lblNewLabel_10 = new JLabel("¡Vuelve pronto!");
		lblNewLabel_10.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_10.setBounds(148, 123, 163, 25);
		panel_1.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("¿Seguro que quieres cerrar sesión?");
		lblNewLabel_11.setFont(new Font("Inter", Font.BOLD, 11));
		lblNewLabel_11.setBounds(124, 163, 194, 13);
		panel_1.add(lblNewLabel_11);

		JButton btnNewButton_5 = new JButton("No,volver");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_5.setBackground(Color.decode("#4A85A4"));
		btnNewButton_5.setBounds(46, 217, 163, 25);
		btnNewButton_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				frame.add(panelCopia);
				frame.setVisible(true);
				frame.repaint();
				frame.revalidate();
			}
		});
		panel_1.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Si,cerrar sesión");
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_6.setBounds(225, 217, 163, 25);
		btnNewButton_6.setBorder(BorderFactory.createLineBorder(Color.decode("#4A85A4") , 2));
		btnNewButton_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				cerrarSesionPanel();

			}
		});
		panel_1.add(btnNewButton_6);


		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void cerrarSesionPanel() {

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 67, 450, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);

		ImageIcon iconoPregunta = new ImageIcon(getClass().getResource("/Imagenes/like.png"));
		JLabel lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setIcon(iconoPregunta);
		lblNewLabel_14.setBounds(190, 34, 70, 70);
		panel_1.add(lblNewLabel_14);

		JLabel lblNewLabel_12 = new JLabel("Usted cerró sesión");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(128, 130, 200, 21);
		panel_1.add(lblNewLabel_12);

		JButton btnNewButton_7 = new JButton("Volver a inicio de sesión");
		btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(Color.decode("#4A85A4"));
		btnNewButton_7.setBounds(142, 182, 167, 25);
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				view = new AuthController();
				view.login();

			}
		});

		panel_1.add(btnNewButton_7);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void metodoMenu(JPanel panel) {
		JPanel panelCopia;
		panelCopia = panel;

		ImageIcon iconoCerrarSesion = new ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"));
		JButton btnNewButton_13 = new JButton("Cerrar Sesión", iconoCerrarSesion);
		btnNewButton_13.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_13.setBounds(615, 402, 167, 35);
		btnNewButton_13.setBorderPainted(false);
		btnNewButton_13.setContentAreaFilled(false);
		btnNewButton_13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				ConfirmarCerrarSesionPanel(panelCopia);
			}
		});
		panel.add(btnNewButton_13);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 932, 40);
		menuBar.setBackground(Color.decode("#4A85A4"));
		menuBar.setBorder(BorderFactory.createLineBorder(Color.decode("#4A85A4")));
		panel.add(menuBar);

		ImageIcon iconoControlEscolar = new ImageIcon(getClass().getResource("/Imagenes/Icono_Control_Escolar.png"));
		JLabel controlEscolar = new JLabel("Control Escolar");
		controlEscolar.setForeground(new Color(255, 255, 255));
		controlEscolar.setFont(new Font("Inter", Font.BOLD, 12));
		controlEscolar.setIcon(iconoControlEscolar);

		menuBar.add(controlEscolar);

		menuBar.add(Box.createHorizontalStrut(35));

		ImageIcon iconoGrupos = new ImageIcon(getClass().getResource("/Imagenes/Icono_Grupos.png")); 
		JMenu mnNewMenu = new JMenu("Grupos");
		mnNewMenu.setIcon(iconoGrupos);
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setFont(new Font("Inter", Font.BOLD, 12));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consultar registros");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				group = new GroupController();
				group.gruposRegistradosPanel();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Detalles");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				group = new GroupController();
				group.buscarGrupo2();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Crear");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				group = new GroupController();
				group.crearGrupo();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Editar");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				group = new GroupController();
				group.buscarGrupo3();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Eliminar");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				group = new GroupController();
				group.buscarGrupo4();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);

		menuBar.add(Box.createHorizontalStrut(12));

		ImageIcon iconoAlumnos = new ImageIcon(getClass().getResource("/Imagenes/student-with-graduation-cap.png")); 
		JMenu mnNewMenu_1 = new JMenu("Alumnos");
		mnNewMenu_1.setIcon(iconoAlumnos);
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		mnNewMenu_1.setFont(new Font("Inter", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Consultar registros");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				student = new StudentController();
				student.alumnosRegistradosPanel();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Detalles");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				student = new StudentController();
				student.buscarIDPanel();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Crear");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				student = new StudentController();
				student.crearAlumnoPanel();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_8);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Editar");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				student = new StudentController();
				student.buscarIDPanel3();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_9);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Eliminar");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				student = new StudentController();
				student.buscarIDPanel4();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_10);

		menuBar.add(Box.createHorizontalStrut(12));

		ImageIcon iconoDocentes = new ImageIcon(getClass().getResource("/Imagenes/school (1).png")); 
		JMenu mnNewMenu_2 = new JMenu("Docentes");
		mnNewMenu_2.setIcon(iconoDocentes);
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		mnNewMenu_2.setFont(new Font("Inter", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Consultar registros");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				teacher = new TeacherController();
				teacher.docenteRegistradosPanel();			
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_11);

		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Detalles");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				teacher = new TeacherController();
				teacher.buscarIDPanel2();		
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_12);

		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Crear");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				teacher = new TeacherController();
				teacher.crearDocentePanel();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_13);

		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Editar");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				teacher = new TeacherController();
				teacher.buscarIDPanel3();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_14);

		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Eliminar");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				teacher = new TeacherController();
				teacher.buscarIDPanel4();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_15);

		menuBar.add(Box.createHorizontalStrut(12));

		ImageIcon iconoAsignaturas = new ImageIcon(getClass().getResource("/Imagenes/educacion.png")); 
		JMenu mnNewMenu_3 = new JMenu("Asignaturas");
		mnNewMenu_3.setIcon(iconoAsignaturas);
		mnNewMenu_3.setForeground(new Color(255, 255, 255));
		mnNewMenu_3.setFont(new Font("Inter", Font.BOLD, 12));
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Consultar registros");
		mntmNewMenuItem_16.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				subject = new SubjectController();
				subject.asignaturasRegistradasPanel();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_16);

		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Detalles");
		mntmNewMenuItem_17.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				subject = new SubjectController();
				subject.buscarAsignatura4();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_17);

		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Crear");
		mntmNewMenuItem_18.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				subject = new SubjectController();
				subject.crearAsignatura();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_18);

		JMenuItem mntmNewMenuItem_19 = new JMenuItem("Editar");
		mntmNewMenuItem_19.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				subject = new SubjectController();
				subject.buscarAsignatura2();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_19);

		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Eliminar");
		mntmNewMenuItem_20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				subject = new SubjectController();
				subject.buscarAsignatura3();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_20);

	}

	private void limitarEntradaANumeros(KeyEvent evt, JTextField textField, int longitud) {
		// TODO Auto-generated method stub
		char key = evt.getKeyChar();

		boolean esNumero = Character.isDigit(key);

		boolean esBorrarOEnviar = key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER;

		if (!esNumero && !esBorrarOEnviar) {
			evt.consume();

			JOptionPane.showMessageDialog(null, "Solo números", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}


		if (textField.getText().length() >= longitud) {
			evt.consume();
		}
	}

	private void agregarFiltroNumerosATextFields(JTextField[] textFields, int longitud) {
		for (JTextField textField : textFields) {
			textField.addKeyListener((KeyListener) new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					limitarEntradaANumeros(evt, textField, longitud);
				}
			});
		}
	}

	private void limitarEntradaALetras(KeyEvent evt, JTextField textField, int longitud) {
		int key = evt.getKeyChar();

		boolean mayusculas = key >= 65 && key <= 90;
		boolean minusculas = key >= 97 && key <= 122;
		boolean espacio = key == 32;
		boolean esBorrarOEnviar = key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER;

		if (!(minusculas || mayusculas || espacio|| esBorrarOEnviar))
		{
			evt.consume();
			JOptionPane.showMessageDialog(null, "Solo letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}

		if (textField.getText().length() >= longitud) {
			evt.consume();
		}
	}

	private void agregarFiltroLetrasATextFields(JTextField[] textFields, int longitud) {
		for (JTextField textField : textFields) {
			textField.addKeyListener((KeyListener) new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					limitarEntradaALetras(evt, textField, longitud);
				}
			});
		}
	}

	private void limitarEntradaCaracteres(KeyEvent evt, JTextField textField, int longitudMaxima) {

		if (textField.getText().length() >= longitudMaxima) {
			evt.consume();
		}
	}

	private void agregarLimiteCaracteresATextFields(JTextField[] textFields, int longitud) {
		for (JTextField textField : textFields) {
			textField.addKeyListener((KeyListener) new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					limitarEntradaCaracteres(evt, textField, longitud);
				}
			});
		}
	}

}

class RenderTabla extends DefaultTableCellRenderer{


	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		setHorizontalAlignment(SwingConstants.CENTER);
		if(value instanceof JButton) {
			return (JButton) value;
		}
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}



class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
	private JButton button;
	private String text;

	public ButtonEditor() {
		button = new JButton();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if (value instanceof JButton) {
			button = (JButton) value;
			text = button.getText();
		} else {
			button.setText(value.toString());
			text = value.toString();
		}
		return button;
	}

	@Override
	public Object getCellEditorValue() {
		return button;
	}
}
