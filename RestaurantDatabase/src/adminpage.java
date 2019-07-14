
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.io.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class adminpage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	ArrayList<String> array = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminpage frame = new adminpage();
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
	public adminpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Collections.sort(names);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(404, 7, 240, 341);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(15, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 7, 384, 447);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 364, 437);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("resname.txt"));
			
			 while (br.ready()) {
	                array.add(br.readLine());
	            }
	            br.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		
		
		JRadioButton []b=new JRadioButton[array.size()];
		
		for(int i=0;i<array.size();i++) {
			
			
			b[i]=new JRadioButton(array.get(i));
			buttonGroup.add(b[i]);
			panel.add(b[i]);
		}
		/*JRadioButton []b=new JRadioButton[resmap.names.size()];
		
		for(int i=0;i<resmap.names.size();i++) {
			b[i]=new JRadioButton(resmap.names.get(i));
			buttonGroup.add(b[i]);
			panel.add(b[i]);
		}*/

		JButton btnNewButton = new JButton("delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "Are you  sure to delete?", "comfirm", JOptionPane.YES_NO_OPTION); 
				if (n == JOptionPane.YES_OPTION) { 
					JOptionPane.showMessageDialog(new JFrame(),"deleted");
				} else if (n == JOptionPane.NO_OPTION) { 
					JOptionPane.showMessageDialog(new JFrame(),"canceled");}

				for(int i=0;i<array.size();i++) {
					if(b[i].isSelected()) {
						array.remove(i);	
					}
				}
				File file = null;
		        FileWriter out=null;
		        try {
		            file = new File("resname.txt");
		            out = new FileWriter(file); 
		            for(int i=0;i<array.size();i++) {
		            	 out.write(array.get(i));
		            	 out.write("\r\n");         		           
		            }
		            out.close();
		        } catch (FileNotFoundException e1) {
		            e1.printStackTrace();
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		        
		        dispose();	
			}
		});
		btnNewButton.setBounds(509, 397, 106, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<array.size();i++) {
					if(b[i].isSelected()) {
						String name=array.get(i);
						String[] str=name.split(",");
						File file = null;
				        FileWriter out=null;
				        try {
				            file = new File(str[0]+ ".txt");
				            out = new FileWriter(file);     
				            out.write(textArea.getText());
				            out.close();
				        } catch (FileNotFoundException e1) {
				            e1.printStackTrace();
				        } catch (IOException e1) {
				            e1.printStackTrace();
				        }
					}
				}
			}
		});
		btnNewButton_1.setBounds(510, 358, 100, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("edit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<array.size();i++) {
					if(b[i].isSelected()) {
						String name=array.get(i);
						String[] str=name.split(",");
						
						try {
							textArea.read(new FileReader(str[0]+".txt"), str[0]+".txt");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton_2.setBounds(405, 360, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("create");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				create newRes=new create();
				newRes.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(404, 397, 93, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("←back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new resmap().setVisible(true);
			}
		});
		btnNewButton_4.setBounds(519, 437, 117, 29);
		contentPane.add(btnNewButton_4);
		
		
	}
}