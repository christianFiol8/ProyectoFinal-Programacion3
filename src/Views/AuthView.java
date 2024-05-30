package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Models.AuthModel;

public class AuthView {

	private JFrame frame;
	private AuthModel model = new AuthModel();

	public AuthView() {
		// TODO Auto-generated constructor stub

		frame = new JFrame();
		frame.setVisible(false);
		frame.setBounds(400, 200, 790, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));		
	}

	public void loginPanel() {

		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBackground(Color.decode("#C3E1F1"));

		JLabel lblNewLabel = new JLabel("CONTROL ESCOLAR");
		lblNewLabel.setFont(new Font("Inter", Font.BOLD, 32));
		lblNewLabel.setBounds(222, 10, 353, 43);
		loginPanel.add(lblNewLabel);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 255, 255));
		panel2.setOpaque(true);
		panel2.setBounds(83, 63, 310, 292);
		panel2.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		panel2.setLayout(null);
		loginPanel.add(panel2);

		JLabel lblNewLabel_1 = new JLabel("Inicio de Sesión");
		lblNewLabel_1.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_1.setBounds(17, 20, 135, 20);
		panel2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_2.setBounds(17, 56, 62, 13);
		panel2.add(lblNewLabel_2);


		JTextField textField = new JTextField();
		textField.setBackground(Color.decode("#D9D9D9"));
		textField.setBounds(17, 79, 276, 25);
		panel2.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Contraseña:");
		lblNewLabel_3.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_3.setBounds(17, 120, 82, 13);
		panel2.add(lblNewLabel_3);

		JPasswordField textField2 = new JPasswordField();
		textField2.setBackground(Color.decode("#D9D9D9"));
		textField2.setBounds(17, 142, 276, 25);
		panel2.add(textField2);
		textField2.setColumns(10);

		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Inter", Font.BOLD, 10));
		btnNewButton.setBounds(17, 189, 276, 25);
		btnNewButton.setBackground(Color.decode("#4A85A4"));
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (textField.getText().equals("") || textField2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los datos faltantes");
				} else {
					if (model.iniciarSesion(textField.getText(), textField2.getText())) {
						frame.remove(loginPanel);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
					}
				}
			}
		});
		panel2.add(btnNewButton);

		JCheckBox chckbxNewCheckBox = new JCheckBox();
		chckbxNewCheckBox.setFont(new Font("Inter", Font.BOLD, 10));
		chckbxNewCheckBox.setText("Recordarme");
		chckbxNewCheckBox.setBounds(14, 238, 97, 21);
		chckbxNewCheckBox.setOpaque(false);
		panel2.add(chckbxNewCheckBox);

		JButton btnNewButton_1 = new JButton("¿Olvidaste tu contraseña?");
		btnNewButton_1.setFont(new Font("Inter", Font.BOLD, 10));
		btnNewButton_1.setBounds(140, 237, 173, 21);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				frame.remove(loginPanel);
				recuperarContraseñaPanel();

			}});
		panel2.add(btnNewButton_1);

		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.decode("#4A85A4"));
		panel3.setBounds(392, 63, 310, 292);
		panel3.setOpaque(true);
		panel3.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		loginPanel.add(panel3);
		panel3.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Bienvenido al Inicio de Sesión");
		lblNewLabel_4.setFont(new Font("Inter", Font.BOLD, 19));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(10, 100, 300, 31);
		panel3.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("¿No tienes cuenta?");
		lblNewLabel_5.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(98, 135, 130, 18);
		panel3.add(lblNewLabel_5);

		JButton btnNewButton_2 = new JButton("Registrarse");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Inter", Font.BOLD, 12));
		btnNewButton_2.setBounds(98, 168, 110, 23);
		btnNewButton_2.setBorder(BorderFactory.createLineBorder(Color.white , 2));
		btnNewButton_2.setBackground(Color.decode("#4A85A4"));
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				frame.remove(loginPanel);
				registroPanel();

			}});
		panel3.add(btnNewButton_2);

		frame.add(loginPanel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void registroPanel() {
		JPanel panelRegistro = new JPanel();
		panelRegistro.setLayout(null);
		panelRegistro.setBackground(Color.decode("#C3E1F1"));

		JLabel lblNewLabel = new JLabel("CONTROL ESCOLAR");
		lblNewLabel.setFont(new Font("Inter", Font.BOLD, 32));
		lblNewLabel.setBounds(222, 10, 353, 43);
		panelRegistro.add(lblNewLabel);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 255, 255));
		panel2.setOpaque(true);
		panel2.setBounds(83, 63, 310, 292);
		panel2.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		panelRegistro.add(panel2);
		panel2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Crear cuenta");
		lblNewLabel_1.setFont(new Font("Inter", Font.BOLD, 16));
		lblNewLabel_1.setBounds(17, 20, 135, 20);
		panel2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_2.setBounds(17, 50, 62, 13);
		panel2.add(lblNewLabel_2);

		JTextField textField = new JTextField();
		textField.setBackground(Color.decode("#D9D9D9"));
		textField.setBounds(17, 71, 276, 25);
		panel2.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Correo:");
		lblNewLabel_6.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_6.setBounds(17, 108, 51, 13);
		panel2.add(lblNewLabel_6);

		JTextField textField2 = new JTextField();
		textField2.setBackground(Color.decode("#D9D9D9"));
		textField2.setBounds(17, 129, 276, 25);
		panel2.add(textField2);
		textField2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Contraseña:");
		lblNewLabel_3.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_3.setBounds(17, 166, 82, 13);
		panel2.add(lblNewLabel_3);

		JPasswordField textField3 = new JPasswordField();
		textField3.setBackground(Color.decode("#D9D9D9"));
		textField3.setBounds(17, 187, 276, 25);
		panel2.add(textField3);
		textField3.setColumns(10);

		JCheckBox chckbxNewCheckBox = new JCheckBox();
		chckbxNewCheckBox.setFont(new Font("Inter", Font.BOLD, 10));
		chckbxNewCheckBox.setText("Acepto los términos y condiciones");
		chckbxNewCheckBox.setBounds(47, 217, 207, 21);
		chckbxNewCheckBox.setOpaque(false);
		panel2.add(chckbxNewCheckBox);

		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Inter", Font.BOLD, 10));
		btnNewButton.setBounds(17, 244, 276, 25);
		btnNewButton.setBackground(Color.decode("#4A85A4"));
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (textField.getText().equals("") || textField2.getText().equals("") || textField3.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Ingrese los datos");
				}

				else if (!chckbxNewCheckBox.isSelected() ){

					JOptionPane.showMessageDialog(null, "Debes aceptar los términos y condiciones");
				}
				else 
				{
					model.anadirUsuario(textField.getText(), textField2.getText(), textField3.getText());
					textField.setText("");
					textField2.setText("");
					textField3.setText("");
					//JOptionPane.showMessageDialog(null, "Usuario creado");
					frame.remove(panelRegistro);
					seleccionAvatar();
				}			

			}
		});
		panel2.add(btnNewButton);

		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.decode("#4A85A4"));
		panel3.setBounds(392, 63, 310, 292);
		panel3.setOpaque(true);
		panel3.setBorder(BorderFactory.createLineBorder(Color.black , 2));
		panelRegistro.add(panel3);
		panel3.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Bienvenido al Registro");
		lblNewLabel_4.setFont(new Font("Inter", Font.BOLD, 24));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(20, 100, 300, 31);
		panel3.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("¿Ya tienes cuenta?");
		lblNewLabel_5.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(98, 135, 130, 18);
		panel3.add(lblNewLabel_5);

		JButton btnNewButton_2 = new JButton("Iniciar sesión");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Inter", Font.BOLD, 12));
		btnNewButton_2.setBounds(98, 168, 110, 23);
		btnNewButton_2.setBorder(BorderFactory.createLineBorder(Color.white , 2));
		btnNewButton_2.setBackground(Color.decode("#4A85A4"));
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				frame.remove(panelRegistro);
				loginPanel();

			}});
		panel3.add(btnNewButton_2);

		frame.add(panelRegistro);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}

	public void recuperarContraseñaPanel() {
		
		JPanel panelRecuperarContraseña = new JPanel();
		panelRecuperarContraseña.setLayout(null);
		panelRecuperarContraseña.setBackground(Color.decode("#C3E1F1"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black , 1));
		panel_1.setBounds(170, 67, 450, 295);
		panelRecuperarContraseña.add(panel_1);
		panel_1.setLayout(null);
		
		ImageIcon iconoPregunta = new ImageIcon(getClass().getResource("/Imagenes/Icono_Pregunta.png"));
		JLabel lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setIcon(iconoPregunta);
		lblNewLabel_14.setBounds(190, 15, 70, 70);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_8 = new JLabel("No te preocupes, es posible recuperarla");
		lblNewLabel_8.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_8.setBounds(111, 119, 246, 13);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("¿Olvidaste tu contraseña?");
		lblNewLabel_7.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_7.setBounds(145, 97, 162, 13);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Email");
		lblNewLabel_9.setFont(new Font("Inter", Font.BOLD, 12));
		lblNewLabel_9.setBounds(53, 156, 60, 13);
		panel_1.add(lblNewLabel_9);
		
		JButton btnNewButton_3 = new JButton("RECUPERAR CONTRASEÑA");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Inter", Font.BOLD, 12));
		btnNewButton_3.setBounds(53, 217, 345, 25);
		btnNewButton_3.setBackground(Color.decode("#4A85A4"));
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});

		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Olvídalo,la he recordado");
		btnNewButton_4.setFont(new Font("Inter", Font.BOLD, 10));
		btnNewButton_4.setBounds(142, 254, 181, 21);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				frame.remove(panelRecuperarContraseña);
				loginPanel();

			}});
		panel_1.add(btnNewButton_4);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(53, 176, 345, 23);
		textField_1.setBackground(Color.decode("#D9D9D9"));
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		frame.add(panelRecuperarContraseña);
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
					frame.remove(panelseleccionAvatar);
					loginPanel();
				}
			});
			panel_1.add(button);
		}	
		
		frame.add(panelseleccionAvatar);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	
}


class RoundedButton extends JButton {

    private Color backgroundColor;

    public RoundedButton(ImageIcon icon, String text, Color backgroundColor) {
        super(text);
        setIcon(icon);
        this.backgroundColor = backgroundColor;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
    
    public RoundedButton(String text, Color backgroundColor) {
        super(text);
        this.backgroundColor = backgroundColor;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
    
    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
    
    public RoundedButton(ImageIcon icon, Color backgroundColor) {
        setIcon(icon);
        this.backgroundColor = backgroundColor;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
    
    public RoundedButton(ImageIcon icon) {
        setIcon(icon);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
    
    public RoundedButton(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(Color.decode("#b7cfe5"));
        } else {
            g2.setColor(backgroundColor);
        }

        g2.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
        g2.dispose();
    }
}


