package Views;

import java.awt.BorderLayout;
import java.awt.Color;
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

import Controllers.AuthController;
import Controllers.GroupController;
import Controllers.HomeController;
import Controllers.StudentController;
import Controllers.SubjectController;
import Controllers.TeacherController;

public class SubjectView {

	private JFrame frame;
	public HomeController home;
	public StudentController student;
	public TeacherController teacher;
	public SubjectController subject;
	public GroupController group;
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
				buscarAsignatura();
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
				buscarAsignatura();
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
				frame.dispose();
				buscarAsignatura();
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
				detallesAsignaturaPanel();
			}
		});
		panel_1.add(btnNewButton_19);
		
		JLabel lblNewLabel_15 = new JLabel("Asignaturas registradas");
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
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_15 = new JLabel("Selecciona una asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(269, 91, 282, 30);
		panel.add(lblNewLabel_15);
		
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
				asignaturasRegistradasPanel();
			}
		});
		panel.add(btnNewButton_15);
	
		 
		
		
		metodoMenu(panel);
		
		JButton btnNewButton_22 = new JButton("A");
		btnNewButton_22.setFont(new Font("Inter", Font.BOLD, 25));
		btnNewButton_22.setBounds(217, 199, 85, 68);
		btnNewButton_22.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				detallesAsignaturaPanel();
			}
		});
		panel.add(btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("B");
		btnNewButton_23.setFont(new Font("Inter", Font.BOLD, 25));
		btnNewButton_23.setBounds(339, 199, 85, 68);
		btnNewButton_23.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				detallesAsignaturaPanel();
			}
		});
		panel.add(btnNewButton_23);
		
		JButton btnNewButton_24 = new JButton("C");
		btnNewButton_24.setFont(new Font("Inter", Font.BOLD, 25));
		btnNewButton_24.setBounds(466, 199, 85, 68);
		btnNewButton_24.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				detallesAsignaturaPanel();
			}
		});
		panel.add(btnNewButton_24);
		
metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	
	public void buscarAsignatura2() {
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_15 = new JLabel("Selecciona una asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(269, 91, 282, 30);
		panel.add(lblNewLabel_15);
		
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
				home.asignaturasPanel();
			}
		});
		panel.add(btnNewButton_15);
	
		 
		
		
		metodoMenu(panel);
		
		JButton btnNewButton_22 = new JButton("A");
		btnNewButton_22.setFont(new Font("Inter", Font.BOLD, 25));
		btnNewButton_22.setBounds(217, 199, 85, 68);
		btnNewButton_22.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				EditarAsignaturaPanel();
			}
		});
		panel.add(btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("B");
		btnNewButton_23.setFont(new Font("Inter", Font.BOLD, 25));
		btnNewButton_23.setBounds(339, 199, 85, 68);
		btnNewButton_23.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				EditarAsignaturaPanel();
			}
		});
		panel.add(btnNewButton_23);
		
		JButton btnNewButton_24 = new JButton("C");
		btnNewButton_24.setFont(new Font("Inter", Font.BOLD, 25));
		btnNewButton_24.setBounds(466, 199, 85, 68);
		btnNewButton_24.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				EditarAsignaturaPanel();
			}
		});
		panel.add(btnNewButton_24);
		
metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void buscarAsignatura3() {
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_15 = new JLabel("Selecciona una asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(269, 91, 282, 30);
		panel.add(lblNewLabel_15);
		
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
				home.asignaturasPanel();
			}
		});
		panel.add(btnNewButton_15);
	
		 
		
		
		metodoMenu(panel);
		
		JButton btnNewButton_22 = new JButton("A");
		btnNewButton_22.setFont(new Font("Inter", Font.BOLD, 25));
		btnNewButton_22.setBounds(217, 199, 85, 68);
		btnNewButton_22.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				confirmarEliminarPanel();
			}
		});
		panel.add(btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("B");
		btnNewButton_23.setFont(new Font("Inter", Font.BOLD, 25));
		btnNewButton_23.setBounds(339, 199, 85, 68);
		btnNewButton_23.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				confirmarEliminarPanel();
			}
		});
		panel.add(btnNewButton_23);
		
		JButton btnNewButton_24 = new JButton("C");
		btnNewButton_24.setFont(new Font("Inter", Font.BOLD, 25));
		btnNewButton_24.setBounds(466, 199, 85, 68);
		btnNewButton_24.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				confirmarEliminarPanel();
			}
		});
		panel.add(btnNewButton_24);
		
metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}


	public void EditarAsignaturaPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_15 = new JLabel("Editar asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(296, 90, 282, 30);
		panel.add(lblNewLabel_15);
		
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
				buscarAsignatura2();
			}
		});
		panel.add(btnNewButton_15);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(204, 128, 374, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_14 = new JButton("Editar datos");
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBounds(256, 381, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				ConfirmarCambiosPanel();
			}
		});
		panel.add(btnNewButton_14);
		

metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}

	public void ConfirmarCambiosPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_15 = new JLabel("Editar datos");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(296, 90, 282, 30);
		panel.add(lblNewLabel_15);
		
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
				EditarAsignaturaPanel();
			}
		});
		panel.add(btnNewButton_15);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(204, 128, 374, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_14 = new JButton("Confirmar Cambios");
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBounds(256, 381, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				cambiosGuardadosPanel();
			}
		});
		panel.add(btnNewButton_14);
		

metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}

	
	public void listaAlumnosPanel2() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_15 = new JLabel("Asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(296, 90, 282, 30);
		panel.add(lblNewLabel_15);
		
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
				buscarAsignatura2();
			}
		});
		panel.add(btnNewButton_15);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(204, 128, 374, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_14 = new JButton("Confirmar cambios");
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBounds(256, 381, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				buscarAsignatura2();
			}
		});
		panel.add(btnNewButton_14);

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
				buscarAsignatura3();
			}
		});
		panel_1.add(btnNewButton_7);
		
		JLabel lblNewLabel_24 = new JLabel("¿Esta seguro de que quiere eliminar a esta asignatura?");
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
		
		ImageIcon iconoPregunta = new ImageIcon(getClass().getResource("/Imagenes/checked (2).png"));
		JLabel lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setIcon(iconoPregunta);
		lblNewLabel_14.setBounds(193, 34, 70, 70);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_12 = new JLabel("Asignatura eliminada con éxito");
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
				home.asignaturasPanel();
			}
		});
		panel_1.add(btnNewButton_7);
		
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
		
		JLabel lblNewLabel_12 = new JLabel("Grupo editado");
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
				home.asignaturasPanel();
			}
		});
		panel_1.add(btnNewButton_7);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void verListaPanel() {
		
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
		
		JLabel lblNewLabel_12 = new JLabel("Este grupo  lleva esta asignatura");
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
				home.asignaturasPanel();
			}
		});
		panel_1.add(btnNewButton_7);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	
	public void detallesAsignaturaPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_15 = new JLabel("Detalles de asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(296, 90, 282, 30);
		panel.add(lblNewLabel_15);
		
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
				buscarAsignatura();
			}
		});
		panel.add(btnNewButton_15);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(204, 128, 374, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_14 = new JButton("Ver grupos con asignatura");
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBounds(256, 381, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				seleccionarGrupo();
			}
		});
		panel.add(btnNewButton_14);
		

metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}

	
	public void seleccionarGrupo() {
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_13 = new JLabel("Seleccionar grupo ");
		lblNewLabel_13.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_13.setBounds(276, 31, 256, 30);
		panel.add(lblNewLabel_13);
		
		JButton btnNewButton_14 = new JButton("Elegir");
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBounds(256, 381, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				verListaPanel();
			}
		});
		panel.add(btnNewButton_14);
		
		JButton btnNewButton_27 = new JButton("A");
		btnNewButton_27.setFont(new Font("Inter", Font.BOLD, 25));
		btnNewButton_27.setBounds(122, 81, 94, 74);
		panel.add(btnNewButton_27);
		
		JButton btnNewButton_28 = new JButton("B");
		btnNewButton_28.setFont(new Font("Inter", Font.BOLD, 25));
		btnNewButton_28.setBounds(256, 81, 94, 74);
		panel.add(btnNewButton_28);
		
		JButton btnNewButton_28_1 = new JButton("C");
		btnNewButton_28_1.setFont(new Font("Inter", Font.BOLD, 25));
		btnNewButton_28_1.setBounds(387, 81, 94, 74);
		panel.add(btnNewButton_28_1);
		
		JButton btnNewButton_28_1_1 = new JButton("D");
		btnNewButton_28_1_1.setFont(new Font("Inter", Font.BOLD, 25));
		btnNewButton_28_1_1.setBounds(519, 81, 94, 74);
		panel.add(btnNewButton_28_1_1);


metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
			
	}
	
	

	/*public void agregarAlumno() {
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_15 = new JLabel("Agregar alumno a un grupo");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(254, 89, 333, 30);
		panel.add(lblNewLabel_15);
		
		JButton btnNewButton_14 = new JButton("Agregar Alumno");
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBounds(256, 381, 300, 30);
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
				crearGrupo();
			}
		});
		panel.add(btnNewButton_15);
		
metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}*/
	
	public void crearAsignatura() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("Crear Asignatura");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(296, 90, 282, 30);
		panel.add(lblNewLabel_15);
		
		JButton btnNewButton_15 = new JButton("Volver");
		btnNewButton_15.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_15.setBounds(71, 79, 110, 30);
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
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 255));
		panel_16.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_16.setBounds(204, 128, 374, 243);
		panel_16.add(panel_1);
		panel_16.setLayout(null);
		
		JButton btnNewButton_14 = new JButton("Crear Asignatura");
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBounds(256, 381, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				asignaturaCreadaPanel();
			}
		});
		panel.add(btnNewButton_14);


metodoMenu(panel);
		
		frame.add(panel);
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
				home.asignaturasPanel();
			}
		});
		panel_1.add(btnNewButton_7);
		
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
		
		JLabel lblNewLabel_12 = new JLabel("Grupo creado con éxito");
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
				home.asignaturasPanel();
			}
		});
		panel_1.add(btnNewButton_7);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}


	public void editarGrupo() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(59, 128, 652, 243);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel_15 = new JLabel("Grupo");
		lblNewLabel_15.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_15.setBounds(296, 90, 282, 30);
		panel.add(lblNewLabel_15);
		
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
				grupoEditadoPanel();
			}
		});
		
		panel.add(btnNewButton_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 255));
		panel_16.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_16.setBounds(204, 128, 374, 243);
		panel_16.add(panel_1);
		panel_16.setLayout(null);
		
		JButton btnNewButton_14 = new JButton("Confirmar cambios");
		btnNewButton_14.setFont(new Font("Inter", Font.BOLD, 16));
		btnNewButton_14.setBounds(256, 381, 300, 30);
		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(panel);
				frame.dispose();
				grupoEditadoPanel();
			}
		});
		panel.add(btnNewButton_14);


metodoMenu(panel);
		
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
