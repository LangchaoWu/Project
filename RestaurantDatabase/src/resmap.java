
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class resmap extends JFrame {
	
	public static double[] xy=new double[2];
	public static ArrayList<String> names =new ArrayList<String>();
	private JTextField text1;
	private JTextField text2;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				    resmap frame = new resmap();
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
	public resmap() {
		setSize(423,202);
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("what is your address\uFF1A");
		lblNewLabel.setBounds(20, 10, 136, 34);
		getContentPane().add(lblNewLabel);
		
		text1 = new JTextField();
		text1.setBounds(166, 17, 25, 21);
		getContentPane().add(text1);
		text1.setColumns(10);
		
		text2 = new JTextField();
		text2.setBounds(198, 17, 25, 21);
		getContentPane().add(text2);
		text2.setColumns(10);
		
		text1.setText("");
		text2.setText("");
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			/*	if(text1.getText().isEmpty() || text2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"please enter address!");
					new resmap().setVisible(true);
				}*/
				if(text1.getText().isBlank()) {
					xy[0]=0;
				}else {xy[0]=Double.parseDouble(text1.getText());}
				if(text2.getText().isBlank()) {
						xy[1]=0;
					}
				else {xy[1]=Double.parseDouble(text2.getText());
					}
				display show=new display();
				show.setVisible(true);
			}
		});
		btnSearch.setBounds(233, 16, 80, 23);
		getContentPane().add(btnSearch);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.setBounds(20, 56, 93, 23);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin rmap=new admin();
				rmap.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(btnAdmin);
	}
}
