package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
						registroPanel();
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

		JTextField textField3 = new JTextField();
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

}
