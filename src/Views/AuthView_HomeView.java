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
import javax.swing.SwingConstants;

import Controllers.AuthController_Home;

public class AuthView_HomeView {
	
	private JFrame frame;
	private AuthController_Home home;

	public AuthView_HomeView() {
		// TODO Auto-generated constructor stub

		frame = new JFrame();
		frame.setVisible(false);
		frame.setBounds(400, 200, 790, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));		
	}
	
	public void gruposPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_13 = new JLabel("Grupos");
		lblNewLabel_13.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_13.setBounds(344, 57, 164, 30);
		panel.add(lblNewLabel_13);
		
		ImageIcon iconoRegistrosAlumnos = new ImageIcon(getClass().getResource("/Imagenes/register.png"));
		JButton btnNewButton_8 = new JButton(iconoRegistrosAlumnos);
		btnNewButton_8.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_8.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_8.setBounds(30, 149, 116, 129);
		btnNewButton_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_8);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.decode("#4A85A4"));
		panel2.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		panel2.setBounds(30, 277, 116, 44);
		panel.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_21 = new JLabel("Consultar");
		lblNewLabel_21.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_21.setForeground(new Color(255, 255, 255));
		lblNewLabel_21.setBounds(30, 7, 70, 13);
		panel2.add(lblNewLabel_21);
		
		JLabel lblNewLabel_16 = new JLabel("Registros");
		lblNewLabel_16.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_16.setForeground(new Color(255, 255, 255));
		lblNewLabel_16.setBounds(30, 23, 70, 15);
		panel2.add(lblNewLabel_16);
		
		ImageIcon iconoDetallesAlumno = new ImageIcon(getClass().getResource("/Imagenes/file.png"));
		JButton btnNewButton_9 = new JButton(iconoDetallesAlumno);
		btnNewButton_9.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_9.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_9.setBounds(180, 149, 116, 129);
		btnNewButton_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_9);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.decode("#4A85A4"));
		panel3.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		panel3.setBounds(180, 277, 116, 44);
		panel3.setLayout(null);
		panel.add(panel3);
		
		JLabel lblNewLabel_17 = new JLabel("Detalles de");
		lblNewLabel_17.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_17.setForeground(new Color(255, 255, 255));
		lblNewLabel_17.setBounds(25, 7, 74, 13);
		panel3.add(lblNewLabel_17);
		
		JLabel lblNewLabel_22 = new JLabel("alumno");
		lblNewLabel_22.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_22.setForeground(new Color(255, 255, 255));
		lblNewLabel_22.setBounds(35, 23, 45, 13);
		panel3.add(lblNewLabel_22);
		
		ImageIcon iconoCrearAlumno = new ImageIcon(getClass().getResource("/Imagenes/add.png"));
		JButton btnNewButton_10 = new JButton(iconoCrearAlumno);
		btnNewButton_10.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_10.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_10.setBounds(330, 149, 116, 129);
		btnNewButton_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_10);
		
		JLabel lblNewLabel_18 = new JLabel("Crear");
		lblNewLabel_18.setForeground(new Color(255, 255, 255));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setOpaque(true);
		lblNewLabel_18.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_18.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_18.setBounds(330, 277, 116, 44);
		panel.add(lblNewLabel_18);
		
		ImageIcon iconoEditarAlumno = new ImageIcon(getClass().getResource("/Imagenes/pencil.png"));
		JButton btnNewButton_11 = new JButton(iconoEditarAlumno);
		btnNewButton_11.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_11.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_11.setBounds(480, 149, 116, 129);
		btnNewButton_11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_11);
		
		JLabel lblNewLabel_19 = new JLabel("Editar");
		lblNewLabel_19.setForeground(new Color(255, 255, 255));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setOpaque(true);
		lblNewLabel_19.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_19.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_19.setBounds(480, 277, 116, 44);
		panel.add(lblNewLabel_19);
		
		ImageIcon iconoEliminarAlumno = new ImageIcon(getClass().getResource("/Imagenes/delete.png"));
		JButton btnNewButton_12 = new JButton(iconoEliminarAlumno);
		btnNewButton_12.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_12.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_12.setBounds(630, 149, 116, 129);
		btnNewButton_12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_12);
	
		JLabel lblNewLabel_20 = new JLabel("Eliminar");
		lblNewLabel_20.setForeground(new Color(255, 255, 255));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setOpaque(true);
		lblNewLabel_20.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_20.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_20.setBounds(630, 277, 116, 44);
		panel.add(lblNewLabel_20);
		
		ImageIcon iconoCerrarSesion = new ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"));
		JButton btnNewButton_13 = new JButton("Cerrar Sesión", iconoCerrarSesion);
		btnNewButton_13.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_13.setBounds(615, 402, 150, 33);
		btnNewButton_13.setBorderPainted(false);
		btnNewButton_13.setContentAreaFilled(false);
		btnNewButton_13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_13);
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	public void alumnoPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_13 = new JLabel("Alumno");
		lblNewLabel_13.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_13.setBounds(342, 57, 164, 30);
		panel.add(lblNewLabel_13);
		
		ImageIcon iconoRegistrosAlumnos = new ImageIcon(getClass().getResource("/Imagenes/register.png"));
		JButton btnNewButton_8 = new JButton(iconoRegistrosAlumnos);
		btnNewButton_8.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_8.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_8.setBounds(30, 149, 116, 129);
		btnNewButton_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_8);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.decode("#4A85A4"));
		panel2.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		panel2.setBounds(30, 277, 116, 44);
		panel.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_21 = new JLabel("Consultar");
		lblNewLabel_21.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_21.setForeground(new Color(255, 255, 255));
		lblNewLabel_21.setBounds(30, 7, 70, 13);
		panel2.add(lblNewLabel_21);
		
		JLabel lblNewLabel_16 = new JLabel("Registros");
		lblNewLabel_16.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_16.setForeground(new Color(255, 255, 255));
		lblNewLabel_16.setBounds(30, 23, 70, 15);
		panel2.add(lblNewLabel_16);
		
		ImageIcon iconoDetallesAlumno = new ImageIcon(getClass().getResource("/Imagenes/file.png"));
		JButton btnNewButton_9 = new JButton(iconoDetallesAlumno);
		btnNewButton_9.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_9.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_9.setBounds(180, 149, 116, 129);
		btnNewButton_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_9);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.decode("#4A85A4"));
		panel3.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		panel3.setBounds(180, 277, 116, 44);
		panel3.setLayout(null);
		panel.add(panel3);
		
		JLabel lblNewLabel_17 = new JLabel("Detalles de");
		lblNewLabel_17.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_17.setForeground(new Color(255, 255, 255));
		lblNewLabel_17.setBounds(25, 7, 74, 13);
		panel3.add(lblNewLabel_17);
		
		JLabel lblNewLabel_22 = new JLabel("alumno");
		lblNewLabel_22.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_22.setForeground(new Color(255, 255, 255));
		lblNewLabel_22.setBounds(35, 23, 45, 13);
		panel3.add(lblNewLabel_22);
		
		ImageIcon iconoCrearAlumno = new ImageIcon(getClass().getResource("/Imagenes/user-add.png"));
		JButton btnNewButton_10 = new JButton(iconoCrearAlumno);
		btnNewButton_10.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_10.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_10.setBounds(330, 149, 116, 129);
		btnNewButton_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_10);
		
		JLabel lblNewLabel_18 = new JLabel("Crear");
		lblNewLabel_18.setForeground(new Color(255, 255, 255));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setOpaque(true);
		lblNewLabel_18.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_18.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_18.setBounds(330, 277, 116, 44);
		panel.add(lblNewLabel_18);
		
		ImageIcon iconoEditarAlumno = new ImageIcon(getClass().getResource("/Imagenes/pencil.png"));
		JButton btnNewButton_11 = new JButton(iconoEditarAlumno);
		btnNewButton_11.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_11.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_11.setBounds(480, 149, 116, 129);
		btnNewButton_11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_11);
		
		JLabel lblNewLabel_19 = new JLabel("Editar");
		lblNewLabel_19.setForeground(new Color(255, 255, 255));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setOpaque(true);
		lblNewLabel_19.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_19.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_19.setBounds(480, 277, 116, 44);
		panel.add(lblNewLabel_19);
		
		ImageIcon iconoEliminarAlumno = new ImageIcon(getClass().getResource("/Imagenes/delete.png"));
		JButton btnNewButton_12 = new JButton(iconoEliminarAlumno);
		btnNewButton_12.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_12.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_12.setBounds(630, 149, 116, 129);
		btnNewButton_12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_12);
	
		JLabel lblNewLabel_20 = new JLabel("Eliminar");
		lblNewLabel_20.setForeground(new Color(255, 255, 255));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setOpaque(true);
		lblNewLabel_20.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_20.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_20.setBounds(630, 277, 116, 44);
		panel.add(lblNewLabel_20);
		
		ImageIcon iconoCerrarSesion = new ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"));
		JButton btnNewButton_13 = new JButton("Cerrar Sesión", iconoCerrarSesion);
		btnNewButton_13.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_13.setBounds(615, 402, 150, 33);
		btnNewButton_13.setBorderPainted(false);
		btnNewButton_13.setContentAreaFilled(false);
		btnNewButton_13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_13);
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	public void docentePanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_13 = new JLabel("Docente");
		lblNewLabel_13.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_13.setBounds(336, 57, 164, 30);
		panel.add(lblNewLabel_13);
		
		ImageIcon iconoRegistrosAlumnos = new ImageIcon(getClass().getResource("/Imagenes/register.png"));
		JButton btnNewButton_8 = new JButton(iconoRegistrosAlumnos);
		btnNewButton_8.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_8.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_8.setBounds(30, 149, 116, 129);
		btnNewButton_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_8);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.decode("#4A85A4"));
		panel2.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		panel2.setBounds(30, 277, 116, 44);
		panel.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_21 = new JLabel("Consultar");
		lblNewLabel_21.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_21.setForeground(new Color(255, 255, 255));
		lblNewLabel_21.setBounds(30, 7, 70, 13);
		panel2.add(lblNewLabel_21);
		
		JLabel lblNewLabel_16 = new JLabel("Registros");
		lblNewLabel_16.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_16.setForeground(new Color(255, 255, 255));
		lblNewLabel_16.setBounds(30, 23, 70, 15);
		panel2.add(lblNewLabel_16);
		
		ImageIcon iconoDetallesAlumno = new ImageIcon(getClass().getResource("/Imagenes/file.png"));
		JButton btnNewButton_9 = new JButton(iconoDetallesAlumno);
		btnNewButton_9.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_9.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_9.setBounds(180, 149, 116, 129);
		btnNewButton_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_9);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.decode("#4A85A4"));
		panel3.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		panel3.setBounds(180, 277, 116, 44);
		panel3.setLayout(null);
		panel.add(panel3);
		
		JLabel lblNewLabel_17 = new JLabel("Detalles de");
		lblNewLabel_17.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_17.setForeground(new Color(255, 255, 255));
		lblNewLabel_17.setBounds(25, 7, 74, 13);
		panel3.add(lblNewLabel_17);
		
		JLabel lblNewLabel_22 = new JLabel("alumno");
		lblNewLabel_22.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_22.setForeground(new Color(255, 255, 255));
		lblNewLabel_22.setBounds(35, 23, 45, 13);
		panel3.add(lblNewLabel_22);
		
		ImageIcon iconoCrearAlumno = new ImageIcon(getClass().getResource("/Imagenes/round.png"));
		JButton btnNewButton_10 = new JButton(iconoCrearAlumno);
		btnNewButton_10.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_10.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_10.setBounds(330, 149, 116, 129);
		btnNewButton_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_10);
		
		JLabel lblNewLabel_18 = new JLabel("Crear");
		lblNewLabel_18.setForeground(new Color(255, 255, 255));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setOpaque(true);
		lblNewLabel_18.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_18.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_18.setBounds(330, 277, 116, 44);
		panel.add(lblNewLabel_18);
		
		ImageIcon iconoEditarAlumno = new ImageIcon(getClass().getResource("/Imagenes/pencil.png"));
		JButton btnNewButton_11 = new JButton(iconoEditarAlumno);
		btnNewButton_11.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_11.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_11.setBounds(480, 149, 116, 129);
		btnNewButton_11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_11);
		
		JLabel lblNewLabel_19 = new JLabel("Editar");
		lblNewLabel_19.setForeground(new Color(255, 255, 255));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setOpaque(true);
		lblNewLabel_19.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_19.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_19.setBounds(480, 277, 116, 44);
		panel.add(lblNewLabel_19);
		
		ImageIcon iconoEliminarAlumno = new ImageIcon(getClass().getResource("/Imagenes/delete.png"));
		JButton btnNewButton_12 = new JButton(iconoEliminarAlumno);
		btnNewButton_12.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_12.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_12.setBounds(630, 149, 116, 129);
		btnNewButton_12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_12);
	
		JLabel lblNewLabel_20 = new JLabel("Eliminar");
		lblNewLabel_20.setForeground(new Color(255, 255, 255));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setOpaque(true);
		lblNewLabel_20.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_20.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_20.setBounds(630, 277, 116, 44);
		panel.add(lblNewLabel_20);
		
		ImageIcon iconoCerrarSesion = new ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"));
		JButton btnNewButton_13 = new JButton("Cerrar Sesión", iconoCerrarSesion);
		btnNewButton_13.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_13.setBounds(615, 402, 150, 33);
		btnNewButton_13.setBorderPainted(false);
		btnNewButton_13.setContentAreaFilled(false);
		btnNewButton_13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_13);
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void asignaturasPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_13 = new JLabel("Asignaturas");
		lblNewLabel_13.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_13.setBounds(316, 57, 164, 30);
		panel.add(lblNewLabel_13);
		
		ImageIcon iconoRegistrosAlumnos = new ImageIcon(getClass().getResource("/Imagenes/register.png"));
		JButton btnNewButton_8 = new JButton(iconoRegistrosAlumnos);
		btnNewButton_8.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_8.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_8.setBounds(30, 149, 116, 129);
		btnNewButton_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_8);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.decode("#4A85A4"));
		panel2.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		panel2.setBounds(30, 277, 116, 44);
		panel.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_21 = new JLabel("Consultar");
		lblNewLabel_21.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_21.setForeground(new Color(255, 255, 255));
		lblNewLabel_21.setBounds(30, 7, 70, 13);
		panel2.add(lblNewLabel_21);
		
		JLabel lblNewLabel_16 = new JLabel("Registros");
		lblNewLabel_16.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_16.setForeground(new Color(255, 255, 255));
		lblNewLabel_16.setBounds(30, 23, 70, 15);
		panel2.add(lblNewLabel_16);
		
		ImageIcon iconoDetallesAlumno = new ImageIcon(getClass().getResource("/Imagenes/file.png"));
		JButton btnNewButton_9 = new JButton(iconoDetallesAlumno);
		btnNewButton_9.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_9.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_9.setBounds(180, 149, 116, 129);
		btnNewButton_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_9);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.decode("#4A85A4"));
		panel3.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		panel3.setBounds(180, 277, 116, 44);
		panel3.setLayout(null);
		panel.add(panel3);
		
		JLabel lblNewLabel_17 = new JLabel("Detalles de");
		lblNewLabel_17.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_17.setForeground(new Color(255, 255, 255));
		lblNewLabel_17.setBounds(25, 7, 74, 13);
		panel3.add(lblNewLabel_17);
		
		JLabel lblNewLabel_22 = new JLabel("alumno");
		lblNewLabel_22.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_22.setForeground(new Color(255, 255, 255));
		lblNewLabel_22.setBounds(35, 23, 45, 13);
		panel3.add(lblNewLabel_22);
		
		ImageIcon iconoCrearAlumno = new ImageIcon(getClass().getResource("/Imagenes/books.png"));
		JButton btnNewButton_10 = new JButton(iconoCrearAlumno);
		btnNewButton_10.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_10.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_10.setBounds(330, 149, 116, 129);
		btnNewButton_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_10);
		
		JLabel lblNewLabel_18 = new JLabel("Crear");
		lblNewLabel_18.setForeground(new Color(255, 255, 255));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setOpaque(true);
		lblNewLabel_18.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_18.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_18.setBounds(330, 277, 116, 44);
		panel.add(lblNewLabel_18);
		
		ImageIcon iconoEditarAlumno = new ImageIcon(getClass().getResource("/Imagenes/pencil.png"));
		JButton btnNewButton_11 = new JButton(iconoEditarAlumno);
		btnNewButton_11.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_11.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_11.setBounds(480, 149, 116, 129);
		btnNewButton_11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_11);
		
		JLabel lblNewLabel_19 = new JLabel("Editar");
		lblNewLabel_19.setForeground(new Color(255, 255, 255));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setOpaque(true);
		lblNewLabel_19.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_19.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_19.setBounds(480, 277, 116, 44);
		panel.add(lblNewLabel_19);
		
		ImageIcon iconoEliminarAlumno = new ImageIcon(getClass().getResource("/Imagenes/delete.png"));
		JButton btnNewButton_12 = new JButton(iconoEliminarAlumno);
		btnNewButton_12.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_12.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_12.setBounds(630, 149, 116, 129);
		btnNewButton_12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_12);
	
		JLabel lblNewLabel_20 = new JLabel("Eliminar");
		lblNewLabel_20.setForeground(new Color(255, 255, 255));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setOpaque(true);
		lblNewLabel_20.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_20.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_20.setBounds(630, 277, 116, 44);
		panel.add(lblNewLabel_20);
		
		ImageIcon iconoCerrarSesion = new ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"));
		JButton btnNewButton_13 = new JButton("Cerrar Sesión", iconoCerrarSesion);
		btnNewButton_13.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_13.setBounds(615, 402, 150, 33);
		btnNewButton_13.setBorderPainted(false);
		btnNewButton_13.setContentAreaFilled(false);
		btnNewButton_13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panel.add(btnNewButton_13);
		
		metodoMenu(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void administrarPanel() {
		JPanel panelAdministrar = new JPanel();
		panelAdministrar.setLayout(null);
		panelAdministrar.setBackground(Color.decode("#C3E1F1"));
		
		JLabel lblNewLabel_13 = new JLabel("Administrador");
		lblNewLabel_13.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_13.setBounds(312, 57, 183, 30);
		panelAdministrar.add(lblNewLabel_13);
		
		JButton btnNewButton_8 = new JButton();
		btnNewButton_8.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_8.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_8.setBounds(80, 149, 116, 129);
		btnNewButton_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panelAdministrar.add(btnNewButton_8);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.decode("#4A85A4"));
		panel2.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		panel2.setBounds(80, 277, 116, 44);
		panelAdministrar.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_21 = new JLabel("Grupos");
		lblNewLabel_21.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_21.setForeground(new Color(255, 255, 255));
		lblNewLabel_21.setBounds(37, 15, 70, 13);
		panel2.add(lblNewLabel_21);
		
		JButton btnNewButton_9 = new JButton();
		btnNewButton_9.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_9.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_9.setBounds(240, 149, 116, 129);
		btnNewButton_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panelAdministrar.add(btnNewButton_9);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.decode("#4A85A4"));
		panel3.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		panel3.setBounds(240, 277, 116, 44);
		panel3.setLayout(null);
		panelAdministrar.add(panel3);
		
		JLabel lblNewLabel_17 = new JLabel("Alumnos");
		lblNewLabel_17.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_17.setForeground(new Color(255, 255, 255));
		lblNewLabel_17.setBounds(33, 16, 74, 13);
		panel3.add(lblNewLabel_17);
		
		JButton btnNewButton_10 = new JButton();
		btnNewButton_10.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_10.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_10.setBounds(400, 149, 116, 129);
		btnNewButton_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panelAdministrar.add(btnNewButton_10);
		
		JLabel lblNewLabel_18 = new JLabel("Docentes");
		lblNewLabel_18.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_18.setForeground(new Color(255, 255, 255));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setOpaque(true);
		lblNewLabel_18.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_18.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_18.setBounds(400, 277, 116, 44);
		panelAdministrar.add(lblNewLabel_18);
		
		JButton btnNewButton_11 = new JButton();
		btnNewButton_11.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		btnNewButton_11.setBackground(Color.decode("#D9D9D9"));
		btnNewButton_11.setBounds(558, 149, 116, 129);
		btnNewButton_11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panelAdministrar.add(btnNewButton_11);
		
		JLabel lblNewLabel_19 = new JLabel("Asignaturas");
		lblNewLabel_19.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_19.setForeground(new Color(255, 255, 255));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setOpaque(true);
		lblNewLabel_19.setBackground(Color.decode("#4A85A4"));
		lblNewLabel_19.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		lblNewLabel_19.setBounds(558, 277, 116, 44);
		panelAdministrar.add(lblNewLabel_19);
				
		ImageIcon iconoCerrarSesion = new ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"));
		JButton btnNewButton_13 = new JButton("Cerrar Sesión", iconoCerrarSesion);
		btnNewButton_13.setFont(new Font("Inter", Font.BOLD, 11));
		btnNewButton_13.setBounds(615, 402, 150, 33);
		btnNewButton_13.setBorderPainted(false);
		btnNewButton_13.setContentAreaFilled(false);
		btnNewButton_13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panelAdministrar.add(btnNewButton_13);
		
		frame.add(panelAdministrar);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	public void metodoMenu(JPanel panel) {
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 932, 40);
		menuBar.setBackground(Color.decode("#4A85A4"));
		menuBar.setBorder(BorderFactory.createLineBorder(Color.decode("#4A85A4")));
		panel.add(menuBar);
        
		ImageIcon iconoControlEscolar = new ImageIcon(getClass().getResource("/Imagenes/school.png"));
	    JLabel controlEscolar = new JLabel("Control Escolar");
	    controlEscolar.setForeground(new Color(255, 255, 255));
	    controlEscolar.setFont(new Font("Inter", Font.BOLD, 12));
	    controlEscolar.setIcon(iconoControlEscolar);
	    
        menuBar.add(controlEscolar);
		
        menuBar.add(Box.createHorizontalStrut(35));
		
		ImageIcon iconoGrupos = new ImageIcon(getClass().getResource("/Imagenes/multiple-users-silhouette.png")); 
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
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Consultar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Crear");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Editar");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Eliminar");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Consultar");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Crear");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Editar");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Eliminar");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Consultar");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Crear");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Editar");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Eliminar");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_18);
		
		JMenuItem mntmNewMenuItem_19 = new JMenuItem("Editar");
		mntmNewMenuItem_19.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_19);
		
		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Eliminar");
		mntmNewMenuItem_20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_20);
	}



}
