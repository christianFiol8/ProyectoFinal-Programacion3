package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controllers.AuthController;
import Controllers.GroupController;
import Controllers.HomeController;
import Controllers.StudentController;
import Controllers.SubjectController;
import Controllers.TeacherController;

public class StudentView {

	private JFrame frame;
	public HomeController home;
	public GroupController group;
	public TeacherController teacher;
	public StudentController student;
	public SubjectController subject;
	public AuthController view;

	public StudentView() {
		// TODO Auto-generated constructor stub

		frame = new JFrame();
		frame.setVisible(false);
		frame.setBounds(400, 200, 790, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));		
	}
	
	public void alumnosRegistradosPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_16 = new JButton("Ver detalles");
		btnNewButton_16.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_16.setBounds(532, 20, 110, 21);
		btnNewButton_16.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_16.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				buscarIDPanel2();
			}
		});
		panel_1.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("Ver detalles");
		btnNewButton_17.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_17.setBounds(532, 77, 110, 21);
		btnNewButton_17.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_17.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				buscarIDPanel2();
			}
		});
		panel_1.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("Ver detalles");
		btnNewButton_18.setBounds(532, 140, 110, 21);
		btnNewButton_18.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_18.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_18.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();;
				buscarIDPanel2();
			}
		});
		panel_1.add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("Ver detalles");
		btnNewButton_19.setBounds(532, 193, 110, 21);
		btnNewButton_19.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_19.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_19.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				buscarIDPanel2();
			}
		});
		panel_1.add(btnNewButton_19);
		
		JLabel lblNewLabel_15 = new JLabel("Alumnos registrados");
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
				home.alumnoPanel();
			}
		});
		panel.add(btnNewButton_15);
	
		 
		
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void buscarIDPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_15 = new JLabel("No.Control");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(310, 130, 139, 30);
		panel.add(lblNewLabel_15);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(229, 194, 300, 30);
		textField_2.setBackground(Color.decode("#D9D9D9"));
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_14 = new JButton("Buscar alumno");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 274, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				descargarInformacionAlumno();
			}
		});
		panel.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(71, 79, 110, 30);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				home = new HomeController();
				home.alumnoPanel();
			}
		});
		panel.add(btnNewButton_15);
	
		 
		
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	public void buscarIDPanel2() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_15 = new JLabel("No.Control");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(310, 130, 139, 30);
		panel.add(lblNewLabel_15);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(229, 194, 300, 30);
		textField_2.setBackground(Color.decode("#D9D9D9"));
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_14 = new JButton("Buscar alumno");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 274, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				descargarInformacionAlumno2();
			}
		});
		panel.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(71, 79, 110, 30);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				alumnosRegistradosPanel();
			}
		});
		panel.add(btnNewButton_15);
	
		 
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void descargarInformacionAlumno() {
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
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_14);
	
		 
		
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	public void descargarInformacionAlumno2() {
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
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 384, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_14);
	
		 
		
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	

	
	
	
	
	

	
	
	
	
	
	public void crearAlumnoPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_23 = new JLabel("Avatar");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setBounds(486, 39, 131, 123);
		lblNewLabel_23.setOpaque(true);
		lblNewLabel_23.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(lblNewLabel_23);
		
		JButton btnNewButton_20 = new JButton("Elegir avatar");
		btnNewButton_20.setBounds(486, 185, 131, 25);
		btnNewButton_20.setOpaque(true);
		btnNewButton_20.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);

				frame.dispose();
				seleccionAvatar();
			}
		});
		panel_1.add(btnNewButton_20);
		
		JLabel lblNewLabel_15 = new JLabel("Crear Alumno");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_15.setBounds(59, 92, 118, 30);
		panel.add(lblNewLabel_15);
		
		JButton btnNewButton_14 = new JButton("Crear Alumno");
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
				crearAlumnoAvatarPanel();
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
				home.alumnoPanel();
			}
		});
		panel.add(btnNewButton_15);
	
		 
		
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void seleccionAvatar() {
		
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
		
		for (int i = 0; i <= 14; i++) {
			ImageIcon iconoAvatar = new ImageIcon(getClass().getResource(imagePaths[i]));
			RoundedButton button = new RoundedButton(iconoAvatar, Color.decode("#D9D9D9"));
			button.setPreferredSize(new Dimension(94, 94));
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
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
					frame.remove(panelseleccionAvatar);

					frame.dispose();
					crearAlumnoAvatarPanel();
				}
			});
			panelseleccionAvatar.add(btnNewButton_14);
		}	
		
		frame.add(panelseleccionAvatar);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void crearAlumnoAvatarPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		ImageIcon iconoAvatar = new ImageIcon(getClass().getResource("/Imagenes/Icono_Avatar_Chico.png"));
		JLabel lblNewLabel_23 = new JLabel(iconoAvatar);
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setBounds(486, 39, 131, 123);
		lblNewLabel_23.setOpaque(true);
		lblNewLabel_23.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(lblNewLabel_23);
		
		JButton btnNewButton_20 = new JButton("Cambiar avatar");
		btnNewButton_20.setBounds(486, 185, 131, 25);
		btnNewButton_20.setOpaque(true);
		btnNewButton_20.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);

				frame.dispose();
				seleccionAvatar();
			}
		});
		panel_1.add(btnNewButton_20);
		
		JLabel lblNewLabel_15 = new JLabel("Crear Alumno");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_15.setBounds(59, 92, 118, 30);
		panel.add(lblNewLabel_15);
		
		JButton btnNewButton_14 = new JButton("Crear Alumno");
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

				confirmarCrearPanel();
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
				crearAlumnoPanel();
			}
		});
		panel.add(btnNewButton_15);
	
		 
		
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}	

	public void confirmarCrearPanel() {
		
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
		
		JButton btnNewButton_7 = new JButton("No,volver");
		btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(Color.decode("#4A85A4"));
		btnNewButton_7.setBounds(34, 181, 167, 25);
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);

				frame.dispose();
				crearAlumnoAvatarPanel();
			}
		});
		panel_1.add(btnNewButton_7);
		
		JLabel lblNewLabel_24 = new JLabel("¿Esta seguro de que quiere crear a este alumno?");
		lblNewLabel_24.setFont(new Font("Inter", Font.BOLD, 11));
		lblNewLabel_24.setBounds(86, 157, 277, 13);
		panel_1.add(lblNewLabel_24);
		
		JButton btnNewButton_21 = new JButton("Si,estoy seguro");
		btnNewButton_21.setBackground(new Color(255, 255, 255));
		btnNewButton_21.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_21.setBounds(239, 183, 167, 25);
		btnNewButton_21.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);

				frame.dispose();
				alumnoCreadoPanel();
			}
		});
		panel_1.add(btnNewButton_21);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	public void alumnoCreadoPanel() {
		
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
		
		JLabel lblNewLabel_12 = new JLabel("Alumno creado con éxito");
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
				home.alumnoPanel();
			}
		});
		panel_1.add(btnNewButton_7);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void buscarIDPanel3() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_15 = new JLabel("No.Control");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(310, 130, 139, 30);
		panel.add(lblNewLabel_15);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(229, 194, 300, 30);
		textField_2.setBackground(Color.decode("#D9D9D9"));
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_14 = new JButton("Buscar alumno");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.decode("#4A85A4"));
		btnNewButton_14.setBounds(229, 274, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				editarInformacionAlumno();
			}
		});
		panel.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(71, 79, 110, 30);
		btnNewButton_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				home = new HomeController();
				home.alumnoPanel();
			}
		});
		panel.add(btnNewButton_15);
	
		
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	
	public void editarInformacionAlumno() {
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
		
		JButton btnNewButton_14 = new JButton("Editar información");
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

				confirmarEditarAlumno();
			}
		});
		panel.add(btnNewButton_14);
	
		 
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	public void confirmarEditarAlumno() {
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
		
		JButton btnNewButton_20 = new JButton("Cambiar avatar");
		btnNewButton_20.setBounds(486, 185, 131, 25);
		btnNewButton_20.setOpaque(true);
		btnNewButton_20.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();

				seleccionAvatar2();
			}
		});
		panel_1.add(btnNewButton_20);
		
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

				editarInformacionAlumno();
			}
		});
		panel.add(btnNewButton_15);
		
		JButton btnNewButton_14 = new JButton("Confirmar cambios");
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

				crearAlumnoAvatarPanel2();
			}
		});
		panel.add(btnNewButton_14);
	
		 
		
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	public void seleccionAvatar2() {
		
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
		
		for (int i = 0; i <= 14; i++) {
			ImageIcon iconoAvatar = new ImageIcon(getClass().getResource(imagePaths[i]));
			RoundedButton button = new RoundedButton(iconoAvatar, Color.decode("#D9D9D9"));
			button.setPreferredSize(new Dimension(94, 94));
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
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
					frame.remove(panelseleccionAvatar);

					frame.dispose();
					crearAlumnoAvatarPanel();
				}
			});
			panelseleccionAvatar.add(btnNewButton_14);
		}	
		
		frame.add(panelseleccionAvatar);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void crearAlumnoAvatarPanel2() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		ImageIcon iconoAvatar = new ImageIcon(getClass().getResource("/Imagenes/Icono_Avatar_Chico.png"));
		JLabel lblNewLabel_23 = new JLabel(iconoAvatar);
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setBounds(486, 39, 131, 123);
		lblNewLabel_23.setOpaque(true);
		lblNewLabel_23.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(lblNewLabel_23);
		
		JButton btnNewButton_20 = new JButton("Cambiar avatar");
		btnNewButton_20.setBounds(486, 185, 131, 25);
		btnNewButton_20.setOpaque(true);
		btnNewButton_20.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);

				frame.dispose();
				seleccionAvatar2();
			}
		});
		panel_1.add(btnNewButton_20);
		
		JLabel lblNewLabel_15 = new JLabel("Editar Alumno");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_15.setBounds(59, 92, 118, 30);
		panel.add(lblNewLabel_15);
		
		JButton btnNewButton_14 = new JButton("Confirmar cambios");
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

				confirmarCrearPanel();
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
				confirmarEditarAlumno();
			}
		});
		panel.add(btnNewButton_15);
	
		 
		
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}	

	
public void confirmacionEditarPanel() {
	
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
	
	JButton btnNewButton_7 = new JButton("No,volver");
	btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
	btnNewButton_7.setForeground(new Color(255, 255, 255));
	btnNewButton_7.setBackground(Color.decode("#4A85A4"));
	btnNewButton_7.setBounds(34, 181, 167, 25);
	btnNewButton_7.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.remove(panel);

			frame.dispose();
			crearAlumnoAvatarPanel2();
		}
	});
	panel_1.add(btnNewButton_7);
	
	JLabel lblNewLabel_24 = new JLabel("¿Esta seguro de que quiere editar a este alumno?");
	lblNewLabel_24.setFont(new Font("Inter", Font.BOLD, 11));
	lblNewLabel_24.setBounds(86, 157, 277, 13);
	panel_1.add(lblNewLabel_24);
	
	JButton btnNewButton_21 = new JButton("Si,estoy seguro");
	btnNewButton_21.setBackground(new Color(255, 255, 255));
	btnNewButton_21.setFont(new Font("Inter", Font.BOLD, 11));
	btnNewButton_21.setBounds(239, 183, 167, 25);
	btnNewButton_21.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.remove(panel);

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
	btnNewButton_7.setForeground(new Color(255, 255, 255));
	btnNewButton_7.setBackground(Color.decode("#4A85A4"));
	btnNewButton_7.setBounds(142, 182, 167, 25);
	btnNewButton_7.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();

			home = new HomeController();
			home.alumnoPanel();
		}
	});
	panel_1.add(btnNewButton_7);
	
	frame.add(panel);
	frame.setVisible(true);
	frame.repaint();
	frame.revalidate();
}
	
	
	
	
	
	
	
	
	
	













public void buscarIDPanel4() {
	JPanel panel = new JPanel();
	panel.setLayout(null);
	panel.setBackground(Color.decode("#C3E1F1"));
	
	JLabel lblNewLabel_15 = new JLabel("No.Control");
	lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
	lblNewLabel_15.setBounds(310, 130, 139, 30);
	panel.add(lblNewLabel_15);
	
	JTextField textField_2 = new JTextField();
	textField_2.setBounds(229, 194, 300, 30);
	textField_2.setBackground(Color.decode("#D9D9D9"));
	panel.add(textField_2);
	textField_2.setColumns(10);
	
	JButton btnNewButton_14 = new JButton("Buscar alumno");
	btnNewButton_14.setForeground(new Color(255, 255, 255));
	btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
	btnNewButton_14.setBackground(Color.decode("#4A85A4"));
	btnNewButton_14.setBounds(229, 274, 300, 30);
	btnNewButton_14.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.remove(panel);
			frame.dispose();

			eliminarAlumnoPanel();
		}
	});
	panel.add(btnNewButton_14);
	
	JButton btnNewButton_15 = new JButton("Volver");
	btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
	btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
	btnNewButton_15.setBounds(71, 79, 110, 30);
	btnNewButton_15.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.remove(panel);
			frame.dispose();

			home = new HomeController();
			home.alumnoPanel();
		}
	});
	panel.add(btnNewButton_15);

	 
	
	
	metodoMenu(panel);
	
	frame.add(panel);
	frame.setVisible(true);
	frame.repaint();
	frame.revalidate();
}



public void eliminarAlumnoPanel() {
	JPanel panel = new JPanel();
	panel.setLayout(null);
	panel.setBackground(Color.decode("#C3E1F1"));
	
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(new Color(255, 255, 255));
	panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
	panel_1.setBounds(59, 128, 652, 243);
	panel.add(panel_1);
	panel_1.setLayout(null);
	
	JLabel lblNewLabel_23 = new JLabel("Avatar");
	lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_23.setBounds(486, 39, 131, 123);
	lblNewLabel_23.setOpaque(true);
	lblNewLabel_23.setBackground(Color.decode("#D9D9D9"));
	panel_1.add(lblNewLabel_23);
	
	
	JLabel lblNewLabel_15 = new JLabel("Eliminar Alumno");
	lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 16));
	lblNewLabel_15.setBounds(59, 92, 118, 30);
	panel.add(lblNewLabel_15);
	
	JButton btnNewButton_14 = new JButton("Eliminar Alumno");
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
			confirmarEliminarPanel();
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

			buscarIDPanel4();
		}
	});
	panel.add(btnNewButton_15);

	 
	
	metodoMenu(panel);
	
	frame.add(panel);
	frame.setVisible(true);
	frame.repaint();
	frame.revalidate();
}

public void confirmarEliminarPanel() {
	
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
	
	JButton btnNewButton_7 = new JButton("No,volver");
	btnNewButton_7.setFont(new Font("Inter", Font.BOLD, 11));
	btnNewButton_7.setForeground(new Color(255, 255, 255));
	btnNewButton_7.setBackground(Color.decode("#4A85A4"));
	btnNewButton_7.setBounds(34, 181, 167, 25);
	btnNewButton_7.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.remove(panel);
			frame.dispose();

			eliminarAlumnoPanel();
		}
	});
	panel_1.add(btnNewButton_7);
	
	JLabel lblNewLabel_24 = new JLabel("¿Esta seguro de que quiere eliminar a este alumno?");
	lblNewLabel_24.setFont(new Font("Inter", Font.BOLD, 11));
	lblNewLabel_24.setBounds(86, 157, 277, 13);
	panel_1.add(lblNewLabel_24);
	
	JButton btnNewButton_21 = new JButton("Si,estoy seguro");
	btnNewButton_21.setBackground(new Color(255, 255, 255));
	btnNewButton_21.setFont(new Font("Inter", Font.BOLD, 11));
	btnNewButton_21.setBounds(239, 183, 167, 25);
	btnNewButton_21.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.remove(panel);
			frame.dispose();

			alumnoEliminadoPanel();
		}
	});
	panel_1.add(btnNewButton_21);
	
	frame.add(panel);
	frame.setVisible(true);
	frame.repaint();
	frame.revalidate();
}

public void alumnoEliminadoPanel() {
	
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
	
	JLabel lblNewLabel_12 = new JLabel("Alumno eliminado con éxito");
	lblNewLabel_12.setFont(new Font("Inter", Font.BOLD, 20));
	lblNewLabel_12.setBounds(80, 130, 350, 21);
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
			home.alumnoPanel();
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
				student.editarInformacionAlumno();
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
				student.eliminarAlumnoPanel();
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
				teacher.editarInformacionDocente();
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
				teacher.eliminarDocentePanel();
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
