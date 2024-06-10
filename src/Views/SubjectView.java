package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
import Models.SubjectModel;
import Models.atributosStudent;
import Models.atributosSubject;
import Models.teacherModel;

public class SubjectView {

	private JFrame frame;
	public HomeController home;
	public StudentController student;
	public TeacherController teacher;
	public SubjectController subject;
	public GroupController group;
	StudentModel model = new StudentModel();
	GroupModel control = new GroupModel();
	SubjectModel medidor = new SubjectModel();
	ArrayList<String> array = new ArrayList<String>();
	teacherModel metodos = new teacherModel();
	public AuthController view;

	public SubjectView() {
		// TODO Auto-generated constructor stub

		frame = new JFrame();
		frame.setVisible(false);
		frame.setBounds(400, 200, 790, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));		
	}
	
	
	
	public void asignaturasRegistradasPanel() {
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
				buscarAsignatura();
			}
		});
		panel.add(btnNewButton_14);

		List<List> datos = medidor.get();

		String[] columnNames = {"Nombre"};

		// Datos de la tabla
		Object[][] informacion = new Object[datos.size()][1];
		for (int i = 0; i < datos.size(); i++) {
			informacion[i][0] = datos.get(i).get(0);

		}

		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		JTable table = new JTable(tableModel);

		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(90);

		table.setBounds(59, 128, 652, 243);
		table.setRowHeight(50);
		table.setFont(new Font("Inter", Font.BOLD, 13));
		scrollPane.setViewportView(table);

		frame.setVisible(true);

		JLabel lblNewLabel_15 = new JLabel("Asignaturas registradas");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_15.setBounds(59, 92, 206, 30);		
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
				home.asignaturasPanel();
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	
	}

	public void buscarAsignatura() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 128, 652, 243);
		panel.add(scrollPane);		
		frame.getContentPane().add(panel);

		List<List> datos = medidor.get();

		String[] columnNames = {"Grupos"};

		Object[][] informacion = new Object[datos.size()][1];
		for (int i = 0; i < datos.size(); i++) {
			String id = datos.get(i).get(0).toString();
			JButton button = new JButton(id);
			button.setBackground(Color.white);
			button.setFont(new Font("Inter", Font.BOLD, 13));
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String selectedId = id;
					System.out.println("ID seleccionado: " + selectedId);
					atributosSubject detalle = medidor.datosMateria(selectedId);
					frame.remove(panel);
					frame.dispose();
					detallesAsignatura(detalle);
				}
			});
			informacion[i][0] = button;

		}

		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		JTable table = new JTable(tableModel);

		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(90);

		table.setBounds(59, 128, 652, 243);
		table.getColumnModel().getColumn(0).setCellRenderer(new RenderTabla());
		table.getColumnModel().getColumn(0).setCellEditor(new ButtonEditor());
		table.setRowHeight(50);
		table.setTableHeader(null);

		scrollPane.setViewportView(table);

		frame.setVisible(true);

		JLabel lblNewLabel_15 = new JLabel("Seleccionar asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(265, 91, 282, 30);
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

				asignaturasRegistradasPanel();
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
		
	}

	public void detallesAsignatura(atributosSubject atributos) {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		String nombre = "";
		String docente = "";
		String descripcion = "";
		
		if (atributos!=null)
		{
			nombre = atributos.getNombre();
			docente = atributos.getDocente();
			descripcion= atributos.getDescripcion();
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(139, 128, 502, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_28 = new JLabel("Docente");
		lblNewLabel_28.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28.setBounds(46, 10, 155, 25);
		panel_1.add(lblNewLabel_28);
		
		JLabel lblNewLabel_28_1 = new JLabel("Descripción");
		lblNewLabel_28_1.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28_1.setBounds(46, 70, 155, 25);
		panel_1.add(lblNewLabel_28_1);
		
		JTextField textField_11 = new JTextField(docente);
		textField_11.setBounds(46, 40, 412, 19);
		textField_11.setEditable(false);
		textField_11.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		JTextArea textField_12 = new JTextArea(descripcion);
		textField_12.setColumns(10);
		textField_12.setBounds(46, 100, 412, 133);
		textField_12.setEditable(false);
		textField_12.setLineWrap(true);
	    textField_12.setWrapStyleWord(true);
		textField_12.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_12);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(46, 105, 5, 22);
		panel_1.add(textArea);
		frame.getContentPane().add(panel);		
		
		ImageIcon iconoDescargar = new ImageIcon(getClass().getResource("/Imagenes/Icono_Descargar.png"));
		
		JLabel lblNewLabel_15 = new JLabel("Detalles de asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 18));
		lblNewLabel_15.setBounds(289, 90, 282, 30);
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
				buscarAsignatura();
			}
		});
		panel.add(btnNewButton_15);
		
		
		JButton btnNewButton_14 = new JButton("Ver grupos con asignatura");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				buscarGrupo(atributos);
			}
		});
		panel.add(btnNewButton_14);


		metodoMenu(panel);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
			
	}
	
	public void buscarGrupo(atributosSubject atributos) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 128, 652, 243);
		panel.add(scrollPane);		
		frame.getContentPane().add(panel);

		ArrayList<String> datos = control.tiraDeMaterias(atributos.getNombre());

		String[] columnNames = {"Grupos"};

		Object[][] informacion = new Object[datos.size()][1];
		for (int i = 0; i < datos.size(); i++) {
			String id = datos.get(i).toString();
			JButton button = new JButton(id);
			button.setBackground(Color.white);
			button.setFont(new Font("Inter", Font.BOLD, 13));
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String selectedId = id;
					System.out.println("ID seleccionado: " + selectedId);
					
					frame.remove(panel);
					frame.dispose();
					listaAlumnosPanel(atributos,selectedId);
				}
			});
			informacion[i][0] = button;

		}

		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		JTable table = new JTable(tableModel);

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

				detallesAsignatura(atributos);
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
		
	}
	
	public void aisgnaturaInexistente() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 67, 450, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		ImageIcon iconoPregunta = new ImageIcon(getClass().getResource("/Imagenes/Icono_Cerrar.png"));
		JLabel lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setIcon(iconoPregunta);
		lblNewLabel_14.setBounds(182, 27, 84, 84);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_12 = new JLabel("Este grupo no lleva esta asignatura");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(51, 130, 352, 21);
		panel_1.add(lblNewLabel_12);
		
		JButton btnNewButton_7 = new JButton("Volver a selección de grupo");
		btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(Color.decode("#4A85A4"));
		btnNewButton_7.setBounds(127, 182, 197, 25);
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				buscarGrupo(null);
			}
		});
		panel_1.add(btnNewButton_7);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void listaAlumnosPanel(atributosSubject atributos,String grupo) {
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
				buscarGrupo(atributos);
			}
		});
		panel.add(btnNewButton_15);

		List<List> datos = model.alumnosGrupo(grupo);

		String[] columnNames = {"Apellido Paterno", "Apellido Materno", "Nombre"};

		Object[][] informacion = new Object[datos.size()][3];
		for (int i = 0; i < datos.size(); i++) {
			informacion[i][0] = datos.get(i).get(1);
			informacion[i][1] = datos.get(i).get(2);
			informacion[i][2] = datos.get(i).get(3);

		}

		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		JTable table = new JTable(tableModel);

		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.setFont(new Font("Inter", Font.BOLD, 13));
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
	
	
	
	
	
	
	
	public void buscarAsignatura4() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 128, 652, 243);
		panel.add(scrollPane);		
		frame.getContentPane().add(panel);

		List<List> datos = medidor.get();

		String[] columnNames = {"Grupos"};

		Object[][] informacion = new Object[datos.size()][1];
		for (int i = 0; i < datos.size(); i++) {
			String id = datos.get(i).get(0).toString();
			JButton button = new JButton(id);
			button.setFont(new Font("Inter", Font.BOLD, 13));
			button.setBackground(Color.white);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String selectedId = id;
					System.out.println("ID seleccionado: " + selectedId);
					atributosSubject detalle = medidor.datosMateria(selectedId);
					frame.remove(panel);
					frame.dispose();
					detallesAsignatura2(detalle);
				}
			});
			informacion[i][0] = button;

		}

		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		JTable table = new JTable(tableModel);

		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(90);

		table.setBounds(59, 128, 652, 243);
		table.getColumnModel().getColumn(0).setCellRenderer(new RenderTabla());
		table.getColumnModel().getColumn(0).setCellEditor(new ButtonEditor());
		table.setRowHeight(50);
		table.setTableHeader(null);

		scrollPane.setViewportView(table);

		frame.setVisible(true);

		JLabel lblNewLabel_15 = new JLabel("Seleccionar asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(265, 91, 282, 30);
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
				home.asignaturasPanel();
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
		
	}

	public void detallesAsignatura2(atributosSubject atributos) {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		String nombre = "";
		String docente = "";
		String descripcion = "";
		
		if (atributos!=null)
		{
			nombre = atributos.getNombre();
			docente = atributos.getDocente();
			descripcion= atributos.getDescripcion();
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(139, 128, 502, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_28 = new JLabel("Docente");
		lblNewLabel_28.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28.setBounds(46, 10, 155, 25);
		panel_1.add(lblNewLabel_28);
		
		JLabel lblNewLabel_28_1 = new JLabel("Descripción");
		lblNewLabel_28_1.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28_1.setBounds(46, 70, 155, 25);
		panel_1.add(lblNewLabel_28_1);
		
		JTextField textField_11 = new JTextField(docente);
		textField_11.setBounds(46, 40, 412, 19);
		textField_11.setEditable(false);
		textField_11.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		JTextArea textField_12 = new JTextArea(descripcion);
		textField_12.setColumns(10);
		textField_12.setBounds(46, 100, 412, 133);
		textField_12.setEditable(false);
		textField_12.setLineWrap(true);
	    textField_12.setWrapStyleWord(true);
		textField_12.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_12);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(46, 105, 5, 22);
		panel_1.add(textArea);
		frame.getContentPane().add(panel);		
		
		ImageIcon iconoDescargar = new ImageIcon(getClass().getResource("/Imagenes/Icono_Descargar.png"));
		
		JLabel lblNewLabel_15 = new JLabel("Detalles de asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 18));
		lblNewLabel_15.setBounds(289, 90, 282, 30);
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
				buscarAsignatura4();
			}
		});
		panel.add(btnNewButton_15);
		
		
		JButton btnNewButton_14 = new JButton("Ver grupos con asignatura");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				buscarGrupo2(atributos);
			}
		});
		panel.add(btnNewButton_14);


		metodoMenu(panel);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
			
	}

	public void buscarGrupo2(atributosSubject atributos) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 128, 652, 243);
		panel.add(scrollPane);		
		frame.getContentPane().add(panel);

		ArrayList<String> datos = control.tiraDeMaterias(atributos.getNombre());

		String[] columnNames = {"Grupos"};

		Object[][] informacion = new Object[datos.size()][1];
		for (int i = 0; i < datos.size(); i++) {
			String id = datos.get(i).toString();
			JButton button = new JButton(id);
			button.setFont(new Font("Inter", Font.BOLD, 13));
			button.setBackground(Color.white);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String selectedId = id;
					System.out.println("ID seleccionado: " + selectedId);
					frame.remove(panel);
					frame.dispose();
					listaAlumnosPanel2(atributos, selectedId);
				
				}
			});
			informacion[i][0] = button;

		}

		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		JTable table = new JTable(tableModel);

		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(90);

		table.setBounds(59, 128, 652, 243);
		table.getColumnModel().getColumn(0).setCellRenderer(new RenderTabla());
		table.getColumnModel().getColumn(0).setCellEditor(new ButtonEditor());
		table.setRowHeight(50);
		table.setFont(new Font("Inter", Font.BOLD, 13));
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

				detallesAsignatura2(atributos);
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
		
	}

	public void aisgnaturaInexistente2(atributosSubject atributos) {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 67, 450, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		ImageIcon iconoPregunta = new ImageIcon(getClass().getResource("/Imagenes/Icono_Cerrar.png"));
		JLabel lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setIcon(iconoPregunta);
		lblNewLabel_14.setBounds(182, 27, 84, 84);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_12 = new JLabel("Este grupo no lleva esta asignatura");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(51, 130, 352, 21);
		panel_1.add(lblNewLabel_12);
		
		JButton btnNewButton_7 = new JButton("Volver a selección de grupo");
		btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(Color.decode("#4A85A4"));
		btnNewButton_7.setBounds(127, 182, 197, 25);
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();

				frame.remove(panel);
				frame.dispose();
				buscarGrupo2(atributos);
			}
		});
		panel_1.add(btnNewButton_7);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	public void listaAlumnosPanel2(atributosSubject atributos, String nombre) {
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
				buscarGrupo2(atributos);
			}
		});
		panel.add(btnNewButton_15);

		List<List> datos = model.alumnosGrupo(nombre);

		String[] columnNames = {"Apellido Paterno", "Apellido Materno", "Nombre"};

		Object[][] informacion = new Object[datos.size()][3];
		for (int i = 0; i < datos.size(); i++) {
			informacion[i][0] = datos.get(i).get(1);
			informacion[i][1] = datos.get(i).get(2);
			informacion[i][2] = datos.get(i).get(3);

		}

		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		JTable table = new JTable(tableModel);

		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.setFont(new Font("Inter", Font.BOLD, 13));
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

	
	
	public void crearAsignatura(atributosSubject atributos) {
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
		textField_11.setBounds(31, 83, 345, 19);
		textField_11.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_11);
		textField_11.setColumns(10);

		JTextField textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(31, 173, 345, 19);
		textField_12.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_12);
		
		JTextArea areaT = new JTextArea();
		areaT.setLineWrap(true);
		areaT.setWrapStyleWord(true);
		areaT.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_12);
		areaT.setBounds(412, 76, 209, 80);
		panel_1.add(areaT);		

		JButton btnNewButton_26 = new JButton("Agregar grupo");
		btnNewButton_26.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_26.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_26.setBounds(412, 173, 209, 19);
		btnNewButton_26.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				atributos.setNombre(textField_11.getText());
				atributos.setDocente(textField_12.getText());
				atributos.setDescripcion(areaT.getText());
				frame.remove(panel);
				frame.dispose();
				agregarGrupo(atributos);
			
				
			}
		});
		panel_1.add(btnNewButton_26);

		JLabel lblNewLabel_28 = new JLabel("Nombre de la asigatura");
		lblNewLabel_28.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28.setBounds(31, 44, 209, 25);
		panel_1.add(lblNewLabel_28);

		JLabel lblNewLabel_28_1 = new JLabel("Docente asignado (Nombre)");
		lblNewLabel_28_1.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28_1.setBounds(31, 134, 270, 25);
		panel_1.add(lblNewLabel_28_1);

		JLabel lblNewLabel_28_1_1 = new JLabel("Descripcion");
		lblNewLabel_28_1_1.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28_1_1.setBounds(412, 41, 141, 25);
		panel_1.add(lblNewLabel_28_1_1);


		JLabel lblNewLabel_15 = new JLabel("Crear asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 18));
		lblNewLabel_15.setBounds(300, 86, 282, 30);
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
				home.asignaturasPanel();				
			}
		});
		panel.add(btnNewButton_15);


		JButton btnNewButton_14 = new JButton("Crear asignatura");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(236, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
				// TODO Auto-generated method stub
	
				JTextField[] textFields = {textField_11, textField_12};

				for (JTextField textField : textFields) {
					if (textField.getText().isEmpty()) {
						textField.setBorder(BorderFactory.createLineBorder(Color.red, 2));

					} else {
						textField.setBorder(BorderFactory.createLineBorder(Color.green, 2));
					}
				}
				
				if (areaT.getText().isEmpty()) {
					areaT.setBorder(BorderFactory.createLineBorder(Color.red, 2));

				} else {
					areaT.setBorder(BorderFactory.createLineBorder(Color.green, 2));
				}
				
				if (textField_11.getText().isEmpty() || textField_12.getText().isEmpty() || areaT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
				} 
				
				else if (metodos.buscarDocentesgrupo(textField_12.getText())!= null)
				{
					String nombre = textField_11.getText();
					String docente = textField_12.getText();
					String descripcion = areaT.getText();
					
					medidor.crearAsignatura(nombre, docente, descripcion);
					
					for (String asignarGrupo : array) {
						
						control.asigrnarMateria(asignarGrupo, nombre);
					}
					
					frame.remove(panel);
					frame.dispose();
					asignaturaCreadaPanel();
				}
				else{
					textField_12.setBorder(BorderFactory.createLineBorder(Color.red, 2));
					JOptionPane.showMessageDialog(null, "Docente inexistente");

	
				}
			}
		});
		panel.add(btnNewButton_14);
		
		JTextField[] letrasTextFields = {textField_11, textField_12};
		agregarFiltroLetrasATextFields(letrasTextFields, 40);
		
		JTextArea[] logitudTextArea = {areaT};
		agregarLimiteCaracteresATextArea(logitudTextArea, 160);

		if (atributos!=null)
		{
			textField_11.setText(atributos.getNombre());
			textField_12.setText(atributos.getDocente());
			areaT.setText(atributos.getDescripcion());
		}


		metodoMenu(panel);

		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void agregarGrupo(atributosSubject atributos) {	
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JLabel lblNewLabel_15 = new JLabel("Agregar asignatura a grupo");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 18));
		lblNewLabel_15.setBounds(282, 89, 269, 30);
		panel.add(lblNewLabel_15);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 125, 450, 267);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_16 = new JLabel("Nombre de grupo");
		lblNewLabel_16.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_16.setBounds(125, 53, 224, 30);
		panel_1.add(lblNewLabel_16);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(80, 103, 300, 30);
		textField_2.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_2);
		textField_2.setColumns(10);		
		
		JButton btnNewButton_14 = new JButton("Agregar grupo");
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
					
					
				    AtributosGroup grupo = control.datosDelGrupo(textField_2.getText());
				    
				    
				    if (grupo != null) {
				    	
				    	JOptionPane.showMessageDialog(null, "Se ha agregado el grupo");
				    	
				    	medidor.asignarGrupoMateria(textField_2.getText(), atributos.getNombre());
				    	array.add(grupo.getNombre());	    	
						frame.remove(panel);
						frame.dispose();
						crearAsignatura(atributos);
						System.out.println("Se ha guardado el grupo en la materia");
				        
				    } else {
				    	
				        JOptionPane.showMessageDialog(null, "El grupo no existe");
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
				crearAsignatura(atributos);
			}
		});
		panel.add(btnNewButton_15);
		
		JTextField[] letrasTextFields = {textField_2};
		agregarFiltroLetrasATextFields(letrasTextFields, 50);

		metodoMenu(panel);

		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}
	
	public void asignaturaCreadaPanel() {
		
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
		
		JLabel lblNewLabel_12 = new JLabel("Asignatura creada con éxito");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(90, 130, 298, 21);
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
				home.asignaturasPanel();
			}
		});
		panel_1.add(btnNewButton_7);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	
	
	
	
	
	
	
	public void buscarAsignatura2(atributosSubject atributos) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 128, 652, 243);
		panel.add(scrollPane);		
		frame.getContentPane().add(panel);

		List<List> datos = medidor.get();

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
					atributosSubject detalle = medidor.datosMateria(selectedId);
					frame.remove(panel);
					frame.dispose();
					EditarAsignaturaPanel(detalle);
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

		JLabel lblNewLabel_15 = new JLabel("Seleccionar asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(265, 91, 282, 30);
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
				home.asignaturasPanel();
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void EditarAsignaturaPanel(atributosSubject atributos) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		
		String nombre = "";
		String docente = "";
		String descripcion = "";
		
		if (atributos!=null)
		{
			nombre = atributos.getNombre();
			docente = atributos.getDocente();
			descripcion= atributos.getDescripcion();
		}
		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextField textField_11 = new JTextField(nombre);
		textField_11.setBounds(31, 83, 345, 19);
		textField_11.setEditable(false);
		textField_11.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_11);
		textField_11.setColumns(10);

		JTextField textField_12 = new JTextField(docente);
		textField_12.setColumns(10);
		textField_12.setBounds(31, 173, 345, 19);
		textField_12.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_12);
		
		JTextArea areaT = new JTextArea(descripcion);
		areaT.setLineWrap(true);
		areaT.setWrapStyleWord(true);
		areaT.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_12);
		areaT.setBounds(412, 76, 209, 80);
		panel_1.add(areaT);	

		JButton btnNewButton_26 = new JButton("Agregar grupo");
		btnNewButton_26.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_26.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_26.setBounds(412, 173, 209, 19);
		btnNewButton_26.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				atributos.setNombre(textField_11.getText());
				atributos.setDocente(textField_12.getText());
				atributos.setDescripcion(areaT.getText());
				frame.remove(panel);
				frame.dispose();
				agregarGrupo2(atributos);
			
				
			}
		});
		panel_1.add(btnNewButton_26);

		JLabel lblNewLabel_28 = new JLabel("Nombre de la asignatura");
		lblNewLabel_28.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28.setBounds(31, 44, 209, 25);
		panel_1.add(lblNewLabel_28);

		JLabel lblNewLabel_28_1 = new JLabel("Docente asignado (Nombre)");
		lblNewLabel_28_1.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28_1.setBounds(31, 134, 270, 25);
		panel_1.add(lblNewLabel_28_1);

		JLabel lblNewLabel_28_1_1 = new JLabel("Descripcion");
		lblNewLabel_28_1_1.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_28_1_1.setBounds(412, 41, 141, 25);
		panel_1.add(lblNewLabel_28_1_1);	

		JLabel lblNewLabel_15 = new JLabel("Editar asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 18));
		lblNewLabel_15.setBounds(300, 90, 282, 30);
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
				buscarAsignatura2(atributos);				
			}
		});
		panel.add(btnNewButton_15);

		JTextField[] letrasTextFields = {textField_11, textField_12};
		agregarFiltroLetrasATextFields(letrasTextFields, 40);
		
		JTextArea[] logitudTextArea = {areaT};
		agregarLimiteCaracteresATextArea(logitudTextArea, 160);
		
		JButton btnNewButton_14 = new JButton("Editar asignatura");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				

				
					if (textField_12.getText().isEmpty()) {
						textField_12.setBorder(BorderFactory.createLineBorder(Color.red, 2));

					} else {
						textField_12.setBorder(BorderFactory.createLineBorder(Color.green, 2));
					}
				
				if (areaT.getText().isEmpty()) {
					areaT.setBorder(BorderFactory.createLineBorder(Color.red, 2));

				} else {
					areaT.setBorder(BorderFactory.createLineBorder(Color.green, 2));
				}
				
				if (textField_11.getText().isEmpty() || textField_12.getText().isEmpty() || areaT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);

				} 
				else if (metodos.buscarDocentesgrupo(textField_12.getText())!= null)
				{
					String nombre = textField_11.getText();
					String docente = textField_12.getText();
					String descripcion = areaT.getText();
					System.out.println(nombre);
					System.out.println(docente);
					System.out.println(descripcion);
					
					medidor.editarAsignatura(nombre, docente, descripcion);
					
					for (String asignarGrupo : array) {
						
						control.asigrnarMateria(asignarGrupo, nombre);
					}
					
					frame.remove(panel);
					frame.dispose();
					grupoEditadoPanel();
					
				}
				
				else{
					textField_12.setBorder(BorderFactory.createLineBorder(Color.red, 2));
					JOptionPane.showMessageDialog(null, "Docente inexistente");
	
				}

			}
		});
		
		
		if (atributos!=null)
		{
			textField_11.setText(atributos.getNombre());
			textField_12.setText(atributos.getDocente());
			areaT.setText(atributos.getDescripcion());
		}

		panel.add(btnNewButton_14);
		
		metodoMenu(panel);

		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}

	public void agregarGrupo2(atributosSubject atributos) {	
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JLabel lblNewLabel_15 = new JLabel("Agregar asignatura a grupo");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 18));
		lblNewLabel_15.setBounds(282, 89, 269, 30);
		panel.add(lblNewLabel_15);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 125, 450, 267);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_16 = new JLabel("Nombre de grupo");
		lblNewLabel_16.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_16.setBounds(125, 53, 224, 30);
		panel_1.add(lblNewLabel_16);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(80, 103, 300, 30);
		textField_2.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_14 = new JButton("Agregar grupo");
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
								
				    AtributosGroup grupo = control.datosDelGrupo(textField_2.getText());
	    
				    if (grupo != null) {
				    	medidor.asignarGrupoMateria(textField_2.getText(), atributos.getNombre());
				    	JOptionPane.showMessageDialog(null, "Se ha agregado el grupo");
				    	array.add(grupo.getNombre());	    	
						frame.remove(panel);
						frame.dispose();
						EditarAsignaturaPanel(atributos);
						System.out.println("Se ha guardado el grupo en la materia");
				        
				    } else {
				    	
				        JOptionPane.showMessageDialog(null, "El grupo no existe");
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
				EditarAsignaturaPanel(atributos);
			}
		});
		panel.add(btnNewButton_15);
		
		JTextField[] letrasTextFields = {textField_2};
		agregarFiltroLetrasATextFields(letrasTextFields, 50);

		metodoMenu(panel);

		frame.getContentPane().add(panel);
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
		
		JLabel lblNewLabel_12 = new JLabel("Asignatura editada con éxito");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(82, 130, 308, 21);
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
				home.asignaturasPanel();
			}
		});
		panel_1.add(btnNewButton_7);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	
	
	
	
	public void buscarAsignatura3() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 128, 652, 243);
		panel.add(scrollPane);		
		frame.getContentPane().add(panel);

		List<List> datos = medidor.get();

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
					atributosSubject detalle = medidor.datosMateria(selectedId);
					frame.remove(panel);
					frame.dispose();
					eliminarPanel(detalle);
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

		JLabel lblNewLabel_15 = new JLabel("Seleccionar asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(265, 91, 282, 30);
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
				home.asignaturasPanel();
			}
		});
		panel.add(btnNewButton_15);




		metodoMenu(panel);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void eliminarPanel(atributosSubject atributos) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		String nombre = "";
		String docente = "";
		String descripcion = "";
		
		if (atributos!=null)
		{
			nombre = atributos.getNombre();
			docente = atributos.getDocente();
			descripcion= atributos.getDescripcion();
		}
		
		System.out.println(nombre);
		System.out.println(docente);
		System.out.println(descripcion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_28 = new JLabel("Nombre");
		lblNewLabel_28.setFont(new Font("Inter", Font.PLAIN, 16));
		lblNewLabel_28.setBounds(28, 10, 155, 25);
		panel_1.add(lblNewLabel_28);
		
		JLabel lblNewLabel_28_1 = new JLabel("Descripción");
		lblNewLabel_28_1.setFont(new Font("Inter", Font.PLAIN, 16));
		lblNewLabel_28_1.setBounds(412, 10, 155, 25);
		panel_1.add(lblNewLabel_28_1);
		
		JTextField textField_11 = new JTextField(nombre);
		textField_11.setBounds(28, 40, 303, 19);
		textField_11.setEditable(false);
		textField_11.setFont(new Font("Inter", Font.BOLD, 13));

		textField_11.setBorder(null);
		textField_11.setOpaque(false);
		textField_11.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		JTextField textField_12 = new JTextField(docente);
		textField_12.setColumns(10);
		textField_12.setBounds(28, 98, 303, 19);
		textField_12.setEditable(false);
		textField_12.setFont(new Font("Inter", Font.BOLD, 13));
		textField_12.setBorder(null);
		textField_12.setOpaque(false);
		textField_12.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_12);
		
				
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 160, 370, 70);
		panel_1.add(scrollPane);		
		frame.getContentPane().add(panel);

		ArrayList<String> datos = control.tiraDeMaterias(atributos.getNombre());

		String[] columnNames = {"Nombre"};

		Object[][] informacion = new Object[datos.size()][1];
		for (int i = 0; i < datos.size(); i++) {
			informacion[i][0] = datos.get(i);
			//informacion[i][1] = datos.get(i).get(2);
			//informacion[i][2] = datos.get(i).get(3);

		}

		DefaultTableModel tableModel = new DefaultTableModel(informacion, columnNames);

		JTable table = new JTable(tableModel);

		// Configuración de la tabla
		table.setDefaultRenderer(Object.class, new RenderTabla());
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		//table.getColumnModel().getColumn(1).setPreferredWidth(80);
		//table.getColumnModel().getColumn(2).setPreferredWidth(100);        
		table.setBounds(31, 160, 370, 70);
		table.setFont(new Font("Inter", Font.BOLD, 13));
		table.setRowHeight(20);

		scrollPane.setViewportView(table);

		frame.setVisible(true);
		
		JLabel lblNewLabel_28_22 = new JLabel("Docente");
		lblNewLabel_28_22.setFont(new Font("Inter", Font.PLAIN, 16));
		lblNewLabel_28_22.setBounds(28, 69, 155, 25);
		panel_1.add(lblNewLabel_28_22);
		
		JTextArea areaT = new JTextArea(descripcion);
		areaT.setLineWrap(true);
		areaT.setWrapStyleWord(true);
		areaT.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_12);
		areaT.setFont(new Font("Inter", Font.BOLD, 13));
		areaT.setBorder(null);
		areaT.setOpaque(false);
		areaT.setBounds(412, 37, 209, 80);
		panel_1.add(areaT);		
		
		JLabel lblNewLabel_28_2_1 = new JLabel("Lista de grupos");
		lblNewLabel_28_2_1.setFont(new Font("Inter", Font.PLAIN, 16));
		lblNewLabel_28_2_1.setBounds(28, 127, 155, 25);
		panel_1.add(lblNewLabel_28_2_1);
		
		
		JLabel lblNewLabel_15 = new JLabel("Eliminar asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 18));
		lblNewLabel_15.setBounds(300, 90, 282, 30);
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
				buscarAsignatura3();
			}
		});
		panel.add(btnNewButton_15);
		
		JButton btnNewButton_14 = new JButton("Eliminar asignatura");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				confirmarEliminarPanel(atributos);
			}
		});
		panel.add(btnNewButton_14);


		metodoMenu(panel);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}
	
	public void confirmarEliminarPanel(atributosSubject atributos) {

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

				eliminarPanel(atributos);
			}
		});
		panel_1.add(btnNewButton_7);

		JLabel lblNewLabel_24 = new JLabel("¿Esta seguro de que quiere eliminar esta asignatura?");
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
				medidor.eliminarAsignatura(atributos.getNombre());
				medidor.eliminarMateriaLista(atributos.getNombre());
				frame.remove(panel);
				frame.dispose();
				asignaturaEliminadaPanel();
				


			}
		});
		panel_1.add(btnNewButton_21);

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	public void asignaturaEliminadaPanel() {
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

		JLabel lblNewLabel_12 = new JLabel("Asignatura eliminada con éxito");
		lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel_12.setBounds(70, 130, 310, 21);
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
				home.asignaturasPanel();
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

	private void limitarEntradaCaracteres(KeyEvent evt, JTextArea textField, int longitudMaxima) {

		if (textField.getText().length() >= longitudMaxima) {
			evt.consume();
		}
	}

	private void agregarLimiteCaracteresATextArea(JTextArea[] textAreas, int longitud) {
		for (JTextArea textArea : textAreas) {
			textArea.addKeyListener((KeyListener) new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					limitarEntradaCaracteres(evt, textArea, longitud);
				}
			});
		}
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



	
	
	
}
