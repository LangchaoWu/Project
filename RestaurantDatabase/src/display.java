

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class display extends JFrame {

	
	

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	ArrayList<String> array = new ArrayList<String>();
	ArrayList<String> sort = new ArrayList<String>();
	ArrayList<String> temp = new ArrayList<String>();
	ArrayList<Double> array2 = new ArrayList<Double>();
	List<resname> array3 = new ArrayList<resname>();
	
	/**
	 * Launch the application.
	 */
	
	public static double getDistance(double x1,double y1,double x2,double y2){
		double d = (x2-x1)*(x2-x1) - (y2-y1)*(y2-y1);
		
		double number = Math.abs(d);
		return Math.sqrt(number);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					display frame = new display();
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
	public display() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Collections.sort(names);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(404, 7, 240, 341);
		contentPane.add(scrollPane_1);
		
		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(new GridLayout(15, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 7, 384, 447);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 364, 437);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
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
		
	/*	for(int i=0;i<resmap.names.size();i++) {
			b[i]=new JRadioButton(resmap.names.get(i));
			buttonGroup.add(b[i]);
			panel.add(b[i]);
		}
*/
		JButton btnNewButton = new JButton("sort by name");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File file = null;
		        FileWriter out=null;
		        try {
		            file = new File("resname.txt");
		            out = new FileWriter(file);  
		            Collections.sort(array);
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
				display newsort=new display();
				
				newsort.setVisible(true);
				
				
				
			}
		});
		btnNewButton.setBounds(509, 397, 106, 28);
		contentPane.add(btnNewButton);
		
		//array2.add(resmap.xy[0]);
		//array2.add(resmap.xy[1]);
		
		
		JButton btnNewButton_1 = new JButton("sort by distance");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				try {
					array2.add(resmap.xy[0]);
					array2.add(resmap.xy[1]);
					BufferedReader br = new BufferedReader(new FileReader("resname.txt"));
					
					 while (br.ready()) {
			               String[] each=br.readLine().split(",");
			               resname res=new resname();
			               res.setName(each[0]);
			               res.setX(each[1]);
			               res.setY(each[2]);
			               if(each[1].isBlank()) {
			            	   each[1]="0";
			               }
			               if(each[2].isBlank()) {
			            	   each[2]="0";
			               }
			               res.setDistance(getDistance(array2.get(0),array2.get(1),Double.parseDouble(each[1]),Double.parseDouble(each[2])));
			               array3.add(res);
			            }
			            br.close();
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        }
				
				Comparator<resname> c = new Comparator<resname>() {

					@Override
					public int compare(resname res1, resname res2) {
						if(res1.getDistance()>res2.getDistance()) {
							return 1;
						}
						if(res1.getDistance()<res2.getDistance()) {
							return -1;
						}
						return 0;
						
					}
				};
				Collections.sort(array3,c);
				/*for(int i=0;i<array3.size();i++) {
					System.out.println(array3.get(i).getName());
				}*/
				File file = null;
		        FileWriter out=null;
				 try {
			            file = new File("resname.txt");
			            out = new FileWriter(file);  
			          
			            for(int i=0;i<array3.size();i++) {
			            	 out.write(array3.get(i).getName()+","+array3.get(i).getX() +"," +array3.get(i).getY());
			            	 out.write("\r\n");
			            	
			           
			            }
			            out.close();
			        } catch (FileNotFoundException e1) {
			            e1.printStackTrace();
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        }	
				 dispose();
				 display newsort=new display();
					
				 newsort.setVisible(true);

				
					
				
				
				
			}
		});
		btnNewButton_1.setBounds(499, 358, 129, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("menu");
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
		btnNewButton_2.setBounds(396, 358, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("←back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new resmap().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(511, 437, 117, 29);
		contentPane.add(btnNewButton_3);
		
		
	
		
	
	}
}