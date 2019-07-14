

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("username");
		lblUser.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUser.setBounds(30, 38, 80, 57);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPassword.setBounds(30, 115, 150, 15);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(120, 58, 129, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 107, 129, 23);
		contentPane.add(passwordField);
		
		JButton btnSignIn = new JButton("Login");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().trim().equals("admin") && passwordField.getText().trim().equals("admin")) {
					adminpage page=new adminpage();
					page.setVisible(true);
					dispose();
				}
				else{JOptionPane.showMessageDialog(null,"incorrect username or password");}
				}
		});
		
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyPressed(final KeyEvent e)
			{
			   if(e.getKeyCode()==KeyEvent.VK_ENTER)
			   {
				   if(textField.getText().trim().equals("admin") && passwordField.getText().trim().equals("admin")) {
						adminpage page=new adminpage();
						page.setVisible(true);
						dispose();
					}
					else{JOptionPane.showMessageDialog(null,"incorrect username or password");}
					
			   }
			}
			});
		btnSignIn.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSignIn.setBounds(30, 168, 111, 23);
		contentPane.add(btnSignIn);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new resmap().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton.setBounds(171, 168, 111, 23);
		contentPane.add(btnNewButton);
		
		
	}
}