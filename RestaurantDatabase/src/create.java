

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class create extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	ArrayList<String> array = new ArrayList<String>();
	public boolean flag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					create frame = new create();
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
	public create() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("new name");
		lblNewLabel.setBounds(20, 6, 79, 16);
		contentPane.add(lblNewLabel);
		
		text1 = new JTextField();
		text1.setBounds(104, 1, 130, 26);
		contentPane.add(text1);
		text1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("address");
		lblNewLabel_1.setBounds(20, 50, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		text2 = new JTextField();
		text2.setBounds(104, 45, 31, 26);
		contentPane.add(text2);
		text2.setColumns(10);
		
		text3 = new JTextField();
		text3.setBounds(147, 45, 31, 26);
		contentPane.add(text3);
		text3.setColumns(10);
		
		JButton btnNewButton = new JButton("←back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new adminpage().setVisible(true);
				
			}
		});
		btnNewButton.setBounds(327, 6, 117, 29);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 94, 245, 269);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnCreate = new JButton("create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=true;
				try {
					BufferedReader br = new BufferedReader(new FileReader("resname.txt"));
					
					 while (br.ready()) {
			                array.add(br.readLine());
			            }
			            br.close();
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        }
				
				
				for(int i=0;i<array.size();i++) {
					String[] str=array.get(i).split(",");
					if(str[1].equals(text2.getText()) && str[2].equals(text3.getText())) {
						JOptionPane.showMessageDialog(null,"adress already exists!");
						flag=false;
						
					}
					
				}
				
				if(flag) {
				Writer output;
				try {
					output = new BufferedWriter(new FileWriter("resname.txt", true));
					output.append(text1.getText()+","+text2.getText()+","+text3.getText());
					output.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				File f = new File(text1.getText()+ ".txt"); 
				if(f.exists() && f.isFile()) {
					dispose();
				}
				else {
				File file = null;
		        FileWriter out=null;
		        try {
		            file = new File(text1.getText()+ ".txt");
		            out = new FileWriter(file);     
		            out.write(textArea.getText());
		            out.close();
		        } catch (FileNotFoundException e1) {
		            e1.printStackTrace();
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
				}
		        dispose();
			}
			dispose();
			new create().setVisible(true);;
			}
			
			
			
		});
		btnCreate.setBounds(267, 322, 117, 29);
		contentPane.add(btnCreate);
		
		JLabel lblMenu = new JLabel("menu");
		lblMenu.setBounds(6, 78, 61, 16);
		contentPane.add(lblMenu);
	}
}