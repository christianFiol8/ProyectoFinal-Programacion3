package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.table.DefaultTableModel;

import Controllers.AuthController;
import Controllers.GroupController;
import Controllers.HomeController;
import Controllers.StudentController;
import Controllers.SubjectController;
import Controllers.TeacherController;
import Models.AtributosGroup;
import Models.GroupModel;
import Models.StudentModel;
import Models.atributosStudent;
import Models.teacherModel;

public class GroupView {

	public HomeController home;
	public GroupController group;
	public TeacherController teacher;
	public StudentController student;
	public SubjectController subject;
	public AuthController view;
	DefaultTableModel tablaAlumnosPrevia;
	
	StudentModel model = new StudentModel();
	GroupModel control = new GroupModel();
	teacherModel metodos = new teacherModel();
	
	private JFrame frame;
	AtributosGroup grupo = new AtributosGroup("", "", "");
	ArrayList<String> array = new ArrayList<String>();
	
	
	public GroupView() {
		// TODO Auto-generated constructor stub

		frame = new JFrame();
		frame.setVisible(false);
		frame.setBounds(400, 200, 790, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));		
	}

	public void gruposRegistradosPanel() {
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
				buscarGrupo();
			}
		});
		panel.add(btnNewButton_14);

		List<List> datos = control.get();

		// Columnas de la tabla
		String[] columnNames = {"Nombre"};

		// Datos de la tabla
		Object[][] informacion = new Object[datos.size()][1];
		for (int i = 0; i < datos.size(); i++) {
			informacion[i][0] = datos.get(i).get(0);

		}

		// Crear el modelo de tabla con los datos obtenidos
		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		// Crear la tabla con el modelo
		JTable table = new JTable(tableModel);

		// Configuración de la tabla
		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(90);

		table.setBounds(59, 128, 652, 243);
		table.setRowHeight(50);

		scrollPane.setViewportView(table);

		frame.setVisible(true);

		JLabel lblNewLabel_15 = new JLabel("Grupos registrados");
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
				home.gruposPanel();
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void buscarGrupo() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 128, 652, 243);
		panel.add(scrollPane);		
		frame.getContentPane().add(panel);

		List<List> datos = control.get();

		// Columnas de la tabla
		String[] columnNames = {"Grupos"};

		// Datos de la tabla
		Object[][] informacion = new Object[datos.size()][1];
		for (int i = 0; i < datos.size(); i++) {
			String id = datos.get(i).get(0).toString();
			JButton button = new JButton(id);
			button.setBackground(Color.white);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String selectedId = id;
					System.out.println("ID seleccionado: " + selectedId);
					AtributosGroup detalles = control.datosDelGrupo(selectedId);
					frame.remove(panel);
					frame.dispose();
					listaAlumnosPanel(selectedId);
				}
			});
			informacion[i][0] = button;

		}

		// Crear el modelo de tabla con los datos obtenidos
		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		// Crear la tabla con el modelo
		JTable table = new JTable(tableModel);

		// Configuración de la tabla
		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(90);

		table.setBounds(59, 128, 652, 243);
		table.getColumnModel().getColumn(0).setCellRenderer(new RenderTabla());
		table.getColumnModel().getColumn(0).setCellEditor(new ButtonEditor());
		table.setRowHeight(50);
		table.setTableHeader(null);

		scrollPane.setViewportView(table);

		frame.setVisible(true);

		JLabel lblNewLabel_15 = new JLabel("Selecciona un grupo");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(269, 91, 282, 30);
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

				gruposRegistradosPanel();
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void buscarGrupo2() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 128, 652, 243);
		panel.add(scrollPane);		
		frame.getContentPane().add(panel);

		List<List> datos = control.get();

		// Columnas de la tabla
		String[] columnNames = {"Grupos"};

		// Datos de la tabla
		Object[][] informacion = new Object[datos.size()][1];
		for (int i = 0; i < datos.size(); i++) {
			String id = datos.get(i).get(0).toString();
			JButton button = new JButton(id);
			button.setBackground(Color.white);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String selectedId = id;
					System.out.println("ID seleccionado: " + selectedId);
					frame.remove(panel);
					frame.dispose();
					listaAlumnosPanel2(selectedId);
				}
			});
			informacion[i][0] = button;

		}

		// Crear el modelo de tabla con los datos obtenidos
		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		// Crear la tabla con el modelo
		JTable table = new JTable(tableModel);

		// Configuración de la tabla
		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(90);

		table.setBounds(59, 128, 652, 243);
		table.getColumnModel().getColumn(0).setCellRenderer(new RenderTabla());
		table.getColumnModel().getColumn(0).setCellEditor(new ButtonEditor());
		table.setRowHeight(50);
		table.setTableHeader(null);

		scrollPane.setViewportView(table);

		frame.setVisible(true);

		JLabel lblNewLabel_15 = new JLabel("Selecciona un grupo");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(269, 91, 282, 30);
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
				home.gruposPanel();
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void listaAlumnosPanel(String nombre) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 128, 414, 243);
		panel.add(scrollPane);		
		frame.getContentPane().add(panel);

		JLabel lblNewLabel_15 = new JLabel("Lista de alumnos");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(296, 90, 282, 30);
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
				buscarGrupo();
			}
		});
		panel.add(btnNewButton_15);

		List<List> datos = model.alumnosGrupo(nombre);

		// Columnas de la tabla
		String[] columnNames = {"Apellido Paterno", "Apellido Materno", "Nombre"};

		// Datos de la tabla
		Object[][] informacion = new Object[datos.size()][3];
		for (int i = 0; i < datos.size(); i++) {
			informacion[i][0] = datos.get(i).get(1);
			informacion[i][1] = datos.get(i).get(2);
			informacion[i][2] = datos.get(i).get(3);

		}

		// Crear el modelo de tabla con los datos obtenidos
		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		// Crear la tabla con el modelo
		JTable table = new JTable(tableModel);

		// Configuración de la tabla
		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);

		table.setBounds(184, 128, 414, 243);
		table.setRowHeight(50);

		scrollPane.setViewportView(table);

		frame.setVisible(true);

		JButton btnNewButton_14 = new JButton("Descargar Informacion");
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				control.datosGruposPDF(nombre);
			}
		});
		panel.add(btnNewButton_14);

		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}

	public void listaAlumnosPanel2(String grupo) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 128, 414, 243);
		panel.add(scrollPane);		
		frame.getContentPane().add(panel);

		JLabel lblNewLabel_15 = new JLabel("Lista de alumnos");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(296, 90, 282, 30);
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
				buscarGrupo2();
			}
		});
		panel.add(btnNewButton_15);

		List<List> datos = model.alumnosGrupo(grupo);

		// Columnas de la tabla
		String[] columnNames = {"Apellido Paterno", "Apellido Materno", "Nombre"};

		// Datos de la tabla
		Object[][] informacion = new Object[datos.size()][3];
		for (int i = 0; i < datos.size(); i++) {
			informacion[i][0] = datos.get(i).get(1);
			informacion[i][1] = datos.get(i).get(2);
			informacion[i][2] = datos.get(i).get(3);

		}

		// Crear el modelo de tabla con los datos obtenidos
		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		// Crear la tabla con el modelo
		JTable table = new JTable(tableModel);

		// Configuración de la tabla
		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);

		table.setBounds(184, 128, 414, 243);
		table.setRowHeight(50);

		scrollPane.setViewportView(table);

		frame.setVisible(true);

		JButton btnNewButton_14 = new JButton("Descargar Informacion");
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBounds(229, 384, 300, 30);
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				control.datosGruposPDF(grupo);
			}
		});
		panel.add(btnNewButton_14);

		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}





	public void crearGrupo(AtributosGroup atributos) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JTextField textField_11 = new JTextField();
		textField_11.setBounds(31, 78, 412, 19);
		textField_11.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_11);
		textField_11.setColumns(10);

		JTextField textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(31, 175, 412, 20);
		textField_12.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_12);

		JButton btnNewButton_25 = new JButton("Elegir letra del grupo");
		btnNewButton_25.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_25.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_25.setBounds(467, 130, 154, 21);
		btnNewButton_25.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				atributos.setNombre(textField_11.getText());
				atributos.setDocente(textField_12.getText());
				frame.remove(panel);
				frame.dispose();
				seleccionarLetras(atributos);
			}
		});
		panel_1.add(btnNewButton_25);

		JButton btnNewButton_26 = new JButton("Agregar alumno");
		btnNewButton_26.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_26.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_26.setBounds(467, 174, 154, 20);
		btnNewButton_26.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				atributos.setNombre(textField_11.getText());
				atributos.setDocente(textField_12.getText());
				agregarAlumno(atributos);
			}
		});
		panel_1.add(btnNewButton_26);

		JLabel lblNewLabel_28 = new JLabel("Nombre del grupo");
		lblNewLabel_28.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28.setBounds(31, 43, 155, 25);
		panel_1.add(lblNewLabel_28);

		JLabel lblNewLabel_28_1 = new JLabel("Docente de grupo");
		lblNewLabel_28_1.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28_1.setBounds(31, 140, 155, 25);
		panel_1.add(lblNewLabel_28_1);

		





		ImageIcon iconoDescargar = new ImageIcon(getClass().getResource(atributos.getLetraDeGrupo()));
		JLabel etiquetaAvatar = new JLabel(iconoDescargar);
		etiquetaAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAvatar.setBounds(467, 43, 154, 77);
		etiquetaAvatar.setOpaque(true);
		etiquetaAvatar.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(etiquetaAvatar);

		JLabel lblNewLabel_15 = new JLabel("Crear Grupo");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 18));
		lblNewLabel_15.setBounds(59, 90, 282, 30);
		panel.add(lblNewLabel_15);

		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(59, 50, 110, 25);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				home = new HomeController();
				home.gruposPanel();
			}
		});
		panel.add(btnNewButton_15);


		JButton btnNewButton_14 = new JButton("Crear Grupo");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(256, 381, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				if (textField_11.getText().isEmpty() || textField_12.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);

				} 
				else if (metodos.buscarDocentesgrupo(textField_12.getText())!= null)
				{
					String nombre = textField_11.getText();
					String docente = textField_12.getText();
					String avatar = atributos.getLetraDeGrupo();
					control.crearGrupo(nombre,docente,avatar);
					
					for (String idAlumno : array) {
						
						model.agregarGrupoAlumnos(nombre,idAlumno);
					}
	
					frame.remove(panel);
					frame.dispose();
					grupoCreadoPanel();
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Docente inexistente");

				}
	
			}
		});
		panel.add(btnNewButton_14);
		

		if (atributos!=null)
		{
			textField_11.setText(atributos.getNombre());
			textField_12.setText(atributos.getDocente());
		}


		metodoMenu(panel);

		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();


	}

	public void grupoCreadoPanel() {

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

		JLabel lblNewLabel_12 = new JLabel("Grupo creado con éxito");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(104, 130, 258, 21);
		panel_1.add(lblNewLabel_12);

		JButton btnNewButton_7 = new JButton("Volver a inicio");
		btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(Color.decode("#4A85A4"));
		btnNewButton_7.setBounds(142, 182, 167, 25);
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();

				home = new HomeController();
				home.gruposPanel();
			}
		});
		panel_1.add(btnNewButton_7);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void seleccionarLetras(AtributosGroup atributos) {
		JPanel panelseleccionAvatar = new JPanel();
		panelseleccionAvatar.setLayout(null);
		panelseleccionAvatar.setBackground(Color.decode("#C3E1F1"));

		JLabel lblNewLabel_13 = new JLabel("Selecciona la letra");
		lblNewLabel_13.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_13.setBounds(261, 32, 256, 30);
		panelseleccionAvatar.add(lblNewLabel_13);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 70, 536, 304);
		panelseleccionAvatar.add(scrollPane);		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#4A85A4"));
		panel_1.setLayout(new GridLayout(4, 3, 50, 40));
		panel_1.setBorder(new EmptyBorder(40, 60, 40, 60));
		scrollPane.setViewportView(panel_1);

		String[] imagePaths = {
				"/Imagenes/Icono_Letra_A.png",
				"/Imagenes/Icono_Letra_B.png",
				"/Imagenes/Icono_Letra_C.png",
				"/Imagenes/Icono_Letra_D.png",
				"/Imagenes/Icono_Letra_E.png",
				"/Imagenes/Icono_Letra_F.png",
				"/Imagenes/Icono_Letra_H.png",
				"/Imagenes/Icono_Letra_I.png",
				"/Imagenes/Icono_Letra_J.png",
				"/Imagenes/Icono_Letra_K.png",
				"/Imagenes/Icono_Letra_L.png",
		};
		final String[] selectedImagePath = new String[1];
		for (int i = 0; i <= 10; i++) {
			ImageIcon iconoAvatar = new ImageIcon(getClass().getResource(imagePaths[i]));
			RoundedButton button = new RoundedButton(iconoAvatar, Color.decode("#D9D9D9"));
			final String imagePath = imagePaths[i];
			button.setPreferredSize(new Dimension(94, 94));
			button.setBackground(Color.decode("#D9D9D9"));
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					selectedImagePath[0] = imagePath;
				}
			});
			panel_1.add(button);

			JButton btnNewButton_14 = new JButton("Guardar");
			btnNewButton_14.setForeground(new Color(255, 255, 255));
			btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
			btnNewButton_14.setBackground(Color.decode("#4A85A4"));
			btnNewButton_14.setBounds(229, 384, 300, 30);
			btnNewButton_14.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if (selectedImagePath[0] != null) {
		                atributos.setLetraDeGrupo(selectedImagePath[0]);
		                frame.remove(panelseleccionAvatar);
		                crearGrupo(atributos);
		                
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

	public void agregarAlumno(AtributosGroup atributos) {
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JLabel lblNewLabel_15 = new JLabel("Agregar alumno a grupo");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 18));
		lblNewLabel_15.setBounds(291, 89, 260, 30);
		panel.add(lblNewLabel_15);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 125, 450, 267);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_16 = new JLabel("No. Control");
		lblNewLabel_16.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_16.setBounds(159, 53, 186, 30);
		panel_1.add(lblNewLabel_16);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(80, 103, 300, 30);
		textField_2.setBackground(Color.decode("#D9D9D9"));
		/*textField_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				//descargarInformacionAlumno(panel);
			}
		});*/
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		//Donde guarda a los alumnos del grupo
		
		
		JButton btnNewButton_14 = new JButton("Agregar Alumno");
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setForeground(Color.white);
		btnNewButton_14.setBounds(80, 168, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				if (textField_2.getText().equals("")) {
				    JOptionPane.showMessageDialog(null, "Llenar campo");
				} else {
					
				    // Busca al alumno en la base de datos
					
				    atributosStudent alumno = model.buscarAlumno(textField_2.getText());
				    
				    // Verifica si el alumno fue encontrado
				    
				    if (alumno != null) {
				    	
				        // Si el alumno fue encontrado, procede con la siguiente operación
			    	
				    	array.add(alumno.getAlumnoId());
				    	
		
				    	JOptionPane.showMessageDialog(null, "Se ha agregado el alumno");
				    	
				        frame.remove(panel);
				        frame.dispose();
				        crearGrupo(atributos);
				        
				    } else {
				    	
				        // Si el alumno no fue encontrado, muestra una advertencia
				    	
				        JOptionPane.showMessageDialog(null, "El alumno no existe");
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
				crearGrupo(atributos);
			}
		});
		panel.add(btnNewButton_15);

		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}





	public void buscarGrupo3() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 128, 652, 243);
		panel.add(scrollPane);		
		frame.getContentPane().add(panel);

		List<List> datos = control.get();

		// Columnas de la tabla
		String[] columnNames = {"Grupos"};

		// Datos de la tabla
		Object[][] informacion = new Object[datos.size()][1];
		for (int i = 0; i < datos.size(); i++) {
			String id = datos.get(i).get(0).toString();
			JButton button = new JButton(id);
			button.setBackground(Color.white);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String selectedId = id;
					System.out.println("ID seleccionado: " + selectedId);
					
					AtributosGroup detalles = control.datosDelGrupo(selectedId);
						frame.remove(panel);						
						frame.dispose();
						editarGrupo(detalles);
					

				
				}
			});
			informacion[i][0] = button;

		}

		// Crear el modelo de tabla con los datos obtenidos
		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		// Crear la tabla con el modelo
		JTable table = new JTable(tableModel);

		// Configuración de la tabla
		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(90);

		table.setBounds(59, 128, 652, 243);
		table.getColumnModel().getColumn(0).setCellRenderer(new RenderTabla());
		table.getColumnModel().getColumn(0).setCellEditor(new ButtonEditor());
		table.setRowHeight(50);
		table.setTableHeader(null);

		scrollPane.setViewportView(table);

		frame.setVisible(true);

		JLabel lblNewLabel_15 = new JLabel("Selecciona un grupo");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(269, 91, 282, 30);
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
				home.gruposPanel();			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void editarGrupo(AtributosGroup atributos) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		String nombre = "";
		String docente = "";
		String avatar = "";
		
		if (atributos!=null)
		{
			nombre = atributos.getNombre();
			docente = atributos.getDocente();
			avatar= atributos.getLetraDeGrupo();
		}
	

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_28 = new JLabel("Nombre del grupo");
		lblNewLabel_28.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28.setBounds(31, 43, 155, 25);
		panel_1.add(lblNewLabel_28);

		JLabel lblNewLabel_28_1 = new JLabel("Docente de grupo");
		lblNewLabel_28_1.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28_1.setBounds(31, 140, 155, 25);
		panel_1.add(lblNewLabel_28_1);

		JTextField textField_11 = new JTextField(nombre);
		textField_11.setBounds(31, 78, 412, 19);
		textField_11.setBackground(Color.decode("#D9D9D9"));
		textField_11.setEditable(false);
		panel_1.add(textField_11);
		textField_11.setColumns(10);

		JTextField textField_12 = new JTextField(docente);
		textField_12.setColumns(10);
		textField_12.setBounds(31, 175, 412, 20);
		textField_12.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_12);


		ImageIcon iconoDescargar = new ImageIcon(getClass().getResource(avatar));
		JLabel etiquetaAvatar = new JLabel(iconoDescargar);
		etiquetaAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAvatar.setBounds(467, 43, 154, 77);
		etiquetaAvatar.setOpaque(true);
		etiquetaAvatar.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(etiquetaAvatar);

		JLabel lblNewLabel_15 = new JLabel("Editar Grupo");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 18));
		lblNewLabel_15.setBounds(59, 90, 282, 30);
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
				buscarGrupo3();
			}
		});
		panel.add(btnNewButton_15);


		JButton btnNewButton_14 = new JButton("Confirmar cambios");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(256, 381, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (textField_11.getText().isEmpty() || textField_12.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);

				} 
				else if (metodos.buscarDocentesgrupo(textField_12.getText())!= null)
				{
					String nombre = textField_11.getText();
					String docente = textField_12.getText();
					String avatar = atributos.getLetraDeGrupo();
					control.editarGrupo(nombre, docente, avatar);
					
					for (String idAlumno : array) {
						
						model.agregarGrupoAlumnos(nombre,idAlumno);
					}
	
					frame.remove(panel);
					frame.dispose();
					grupoEditadoPanel();
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Docente inexistente");

				}
				
				
				
			}
		});
		panel.add(btnNewButton_14);
		
		JButton btnNewButton_25 = new JButton("Cambiar letra");
		btnNewButton_25.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_25.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_25.setBounds(467, 130, 154, 21);
		btnNewButton_25.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				atributos.setDocente(textField_12.getText());
				
				frame.remove(panel);
				frame.dispose();
				seleccionarLetras2(atributos);
			}
		});
		panel_1.add(btnNewButton_25);

		JButton btnNewButton_26 = new JButton("Agregar alumno");
		btnNewButton_26.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_26.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_26.setBounds(467, 174, 154, 20);
		btnNewButton_26.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String grupo = textField_11.getText();
				// TODO Auto-generated method stub
				atributos.setDocente(textField_12.getText());
				frame.remove(panel);
				frame.dispose();
				agregarAlumno2(atributos,grupo);
			}
		});
		panel_1.add(btnNewButton_26);


		metodoMenu(panel);

		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void seleccionarLetras2(AtributosGroup atributos) {
		JPanel panelseleccionAvatar = new JPanel();
		panelseleccionAvatar.setLayout(null);
		panelseleccionAvatar.setBackground(Color.decode("#C3E1F1"));

		JLabel lblNewLabel_13 = new JLabel("Selecciona la letra");
		lblNewLabel_13.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_13.setBounds(261, 32, 256, 30);
		panelseleccionAvatar.add(lblNewLabel_13);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 70, 536, 304);
		panelseleccionAvatar.add(scrollPane);		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#4A85A4"));
		panel_1.setLayout(new GridLayout(4, 3, 50, 40));
		panel_1.setBorder(new EmptyBorder(40, 60, 40, 60));
		scrollPane.setViewportView(panel_1);

		String[] imagePaths = {
				"/Imagenes/Icono_Letra_A.png",
				"/Imagenes/Icono_Letra_B.png",
				"/Imagenes/Icono_Letra_C.png",
				"/Imagenes/Icono_Letra_D.png",
				"/Imagenes/Icono_Letra_E.png",
				"/Imagenes/Icono_Letra_F.png",
				"/Imagenes/Icono_Letra_H.png",
				"/Imagenes/Icono_Letra_I.png",
				"/Imagenes/Icono_Letra_J.png",
				"/Imagenes/Icono_Letra_K.png",
				"/Imagenes/Icono_Letra_L.png",
		};
		final String[] selectedImagePath = new String[1];

		for (int i = 0; i <= 9; i++) {
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
			btnNewButton_14.setForeground(new Color(255, 255, 255));
			btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
			btnNewButton_14.setBackground(Color.decode("#4A85A4"));
			btnNewButton_14.setBounds(229, 384, 300, 30);
			btnNewButton_14.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if (selectedImagePath[0] != null) {
		                atributos.setLetraDeGrupo(selectedImagePath[0]);
		                frame.remove(panelseleccionAvatar);
		                frame.dispose();
		                editarGrupo(atributos);
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

	public void agregarAlumno2(AtributosGroup atributos,String nombre) {
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JLabel lblNewLabel_15 = new JLabel("Agregar alumno a grupo");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 18));
		lblNewLabel_15.setBounds(290, 89, 258, 30);
		panel.add(lblNewLabel_15);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 125, 450, 267);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_16 = new JLabel("No. Control");
		lblNewLabel_16.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_16.setBounds(159, 53, 186, 30);
		panel_1.add(lblNewLabel_16);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(80, 103, 300, 30);
		textField_2.setBackground(Color.decode("#D9D9D9"));
		textField_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				descargarInformacionAlumno(panel);
			}
		});
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_14 = new JButton("Agregar Alumno");
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setForeground(Color.white);
		btnNewButton_14.setBounds(80, 168, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textField_2.getText().equals("")) {
				    JOptionPane.showMessageDialog(null, "Llenar campo");
				} else {
				    // Busca al alumno en la base de datos
				    atributosStudent alumno = model.buscarAlumno(textField_2.getText());
				    
				    // Verifica si el alumno fue encontrado
				    if (alumno != null) {
				    	
				    	array.add(alumno.getAlumnoId());
				        // Si el alumno fue encontrado, procede con la siguiente operación
				        frame.remove(panel);
				        frame.dispose();
				        editarGrupo(atributos);
				        
				    	
				        
				    } else {
				        // Si el alumno no fue encontrado, muestra una advertencia
				        JOptionPane.showMessageDialog(null, "El alumno no existe");
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
				editarGrupo(atributos);
			}
		});
		panel.add(btnNewButton_15);

		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}

	public void grupoEditadoPanel() {

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

		JLabel lblNewLabel_12 = new JLabel("Grupo editado con éxito");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(100, 130, 258, 21);
		panel_1.add(lblNewLabel_12);

		JButton btnNewButton_7 = new JButton("Volver a inicio");
		btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(Color.decode("#4A85A4"));
		btnNewButton_7.setBounds(142, 182, 167, 25);
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();

				home = new HomeController();
				home.gruposPanel();
			}
		});
		panel_1.add(btnNewButton_7);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}






	public void buscarGrupo4() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 128, 652, 243);
		panel.add(scrollPane);		
		frame.getContentPane().add(panel);

		List<List> datos = control.get();

		// Columnas de la tabla
		String[] columnNames = {"Grupos"};

		// Datos de la tabla
		Object[][] informacion = new Object[datos.size()][1];
		for (int i = 0; i < datos.size(); i++) {
			String id = datos.get(i).get(0).toString();
			JButton button = new JButton(id);
			button.setBackground(Color.white);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String selectedId = id;
					System.out.println("ID seleccionado: " + selectedId);
					AtributosGroup detalles = control.datosDelGrupo(selectedId);
					frame.remove(panel);
					frame.dispose();
					eliminarGrupo(detalles);
				}
			});
			informacion[i][0] = button;

		}

		// Crear el modelo de tabla con los datos obtenidos
		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		// Crear la tabla con el modelo
		JTable table = new JTable(tableModel);

		// Configuración de la tabla
		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(90);

		table.setBounds(59, 128, 652, 243);
		table.getColumnModel().getColumn(0).setCellRenderer(new RenderTabla());
		table.getColumnModel().getColumn(0).setCellEditor(new ButtonEditor());
		table.setRowHeight(50);
		table.setTableHeader(null);

		scrollPane.setViewportView(table);

		frame.setVisible(true);

		JLabel lblNewLabel_15 = new JLabel("Selecciona un grupo");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(269, 91, 282, 30);
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
				home.gruposPanel();			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}

	public void eliminarGrupo(AtributosGroup atributos) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		String nombre = "";
		String docente = "";
		String avatar = "";
		
		if (atributos!=null)
		{
			nombre = atributos.getNombre();
			docente = atributos.getDocente();
			avatar= atributos.getLetraDeGrupo();
		}

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_28 = new JLabel("Nombre del grupo");
		lblNewLabel_28.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28.setBounds(31, 43, 155, 25);
		panel_1.add(lblNewLabel_28);

		JLabel lblNewLabel_28_1 = new JLabel("Docente de grupo");
		lblNewLabel_28_1.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28_1.setBounds(31, 140, 155, 25);
		panel_1.add(lblNewLabel_28_1);


		JTextField textField_11 = new JTextField(nombre);
		textField_11.setBounds(31, 78, 412, 19);
		textField_11.setBackground(Color.decode("#D9D9D9"));
		textField_11.setFont(new Font("Inter", Font.BOLD, 13));
		textField_11.setBorder(null);
		textField_11.setOpaque(false);
		textField_11.setEditable(false);
		panel_1.add(textField_11);
		textField_11.setColumns(10);

		JTextField textField_12 = new JTextField(docente);
		textField_12.setColumns(10);
		textField_12.setBounds(31, 175, 412, 20);
		textField_12.setBackground(Color.decode("#D9D9D9"));
		textField_12.setFont(new Font("Inter", Font.BOLD, 13));
		textField_12.setBorder(null);
		textField_12.setOpaque(false);
		textField_12.setEditable(false);
		panel_1.add(textField_12);
		textField_12.setColumns(10);

		

		ImageIcon iconoDescargar = new ImageIcon(getClass().getResource(avatar));
		JLabel etiquetaAvatar = new JLabel(iconoDescargar);
		etiquetaAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAvatar.setBounds(467, 43, 154, 77);
		etiquetaAvatar.setOpaque(true);
		etiquetaAvatar.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(etiquetaAvatar);

		JLabel lblNewLabel_15 = new JLabel("Eliminar Grupo");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 18));
		lblNewLabel_15.setBounds(59, 90, 282, 30);
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
				buscarGrupo4();
			}
		});
		panel.add(btnNewButton_15);


		JButton btnNewButton_14 = new JButton("Eliminar Grupo");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(256, 381, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String idGrupo = textField_11.getText();
				frame.remove(panel);
				frame.dispose();
				confirmarEliminarPanel(atributos,idGrupo);
			}
		});
		panel.add(btnNewButton_14);


		metodoMenu(panel);

		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void confirmarEliminarPanel(AtributosGroup atributos, String nombre) {
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

				eliminarGrupo(atributos);
			}
		});
		panel_1.add(btnNewButton_7);

		JLabel lblNewLabel_24 = new JLabel("¿Esta seguro de que quiere eliminar a este grupo?");
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
				frame.remove(panel);
				frame.dispose();
				grupoEliminadoPanel(atributos);
				control.eliminarGrupo(nombre);


			}
		});
		panel_1.add(btnNewButton_21);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void grupoEliminadoPanel(AtributosGroup atributos) {

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

		JLabel lblNewLabel_12 = new JLabel("Grupo eliminado con éxito");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(100, 130, 300, 21);
		panel_1.add(lblNewLabel_12);

		JButton btnNewButton_7 = new JButton("Volver a inicio");
		btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(Color.decode("#4A85A4"));
		btnNewButton_7.setBounds(142, 182, 167, 25);
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();

				home = new HomeController();
				home.gruposPanel();
			}
		});
		panel_1.add(btnNewButton_7);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}




	public void descargarInformacionAlumno(JPanel panel) {


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 257, 670, 112);
		panel.add(scrollPane); 

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setPreferredSize(new Dimension(652, 243));

		panel_1.setLayout(null);

		scrollPane.setViewportView(panel_1);

		JLabel lblNewLabel_29 = new JLabel("Alumno:");
		lblNewLabel_29.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_29.setBounds(55, 224, 92, 25);
		panel.add(lblNewLabel_29);

		JLabel lblNewLabel_25 = new JLabel("Numero de Control");
		lblNewLabel_25.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25.setBounds(22, 9, 132, 13);
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
		lblNewLabel_25_3_1.setBounds(11, 130, 144, 13);
		panel_1.add(lblNewLabel_25_3_1);

		JLabel lblNewLabel_25_3_2 = new JLabel("Correo Electrónico");
		lblNewLabel_25_3_2.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_3_2.setBounds(24, 160, 144, 13);
		panel_1.add(lblNewLabel_25_3_2);

		JLabel lblNewLabel_25_3_3 = new JLabel("Grado del Alumno");
		lblNewLabel_25_3_3.setFont(new Font("Inter", Font.BOLD, 13));
		lblNewLabel_25_3_3.setBounds(31, 190, 144, 13);
		panel_1.add(lblNewLabel_25_3_3);

		JLabel lblNewLabel_25_3_4 = new JLabel("Teléfono");
		lblNewLabel_25_3_4.setBounds(89, 220, 144, 13);
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

		JLabel lblNewLabel_26 = new JLabel("Avatar de alumno");
		lblNewLabel_26.setFont(new Font("Inter", Font.BOLD, 11));
		lblNewLabel_26.setBounds(502, 16, 111, 13);
		panel_1.add(lblNewLabel_26);

		ImageIcon iconoDescargar = new ImageIcon(getClass().getResource("/Imagenes/Icono_Descargar.png"));
		JLabel etiquetaAvatar = new JLabel(iconoDescargar);
		etiquetaAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAvatar.setBounds(486, 39, 131, 123);
		etiquetaAvatar.setOpaque(true);
		etiquetaAvatar.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(etiquetaAvatar);


		frame.getContentPane().add(panel);
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

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Descargar Información");
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

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Consultar");
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

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Descargar Información");
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

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Consultar");
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

		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Descargar información");
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

		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Consultar");
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

		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Descargar información");
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

		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Consultar");
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
	




}
