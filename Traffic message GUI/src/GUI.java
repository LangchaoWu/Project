
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class GUI extends JFrame {
	static String line1;
	static String line2;
	static String line3;
	
	public GUI(){
	
		setTitle( "Overhead message board");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,400);
		setLayout(new GridLayout(1,2));
		JPanel panel1 =new JPanel();
		JPanel panel2 = new JPanel();
		add(panel1);
		add(panel2);
		panel1.setLayout(new FlowLayout());
		JLabel Label=new JLabel();
		Label.setText("input text here:");
		
		JButton button=new JButton("submit");
		
		panel1.add(Label);
		JTextArea textArea=new JTextArea(10,20);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setVisible(true);
		textArea.requestFocus();
		panel1.add(textArea);
		panel1.add(button);
		
		
		
		
		JTextField textF=new JTextField();	
		textF.setHorizontalAlignment(JTextField.CENTER);
		textF.setFont(new Font("Arial",Font.BOLD,36));
		textF.setBackground(Color.BLACK);
		textF.setForeground(Color.YELLOW);
		textF.setDocument(new Limit(20));
		
        JTextField textF1=new JTextField();
        textF1.setHorizontalAlignment(JTextField.CENTER);
        textF1.setFont(new Font("Arial",Font.BOLD,36));
        textF1.setDocument(new Limit(20));
		textF1.setBackground(Color.BLACK);
		textF1.setForeground(Color.YELLOW);
		
		
        JTextField textF2=new JTextField();
        textF2.setHorizontalAlignment(JTextField.CENTER);
        textF2.setFont(new Font("Arial",Font.BOLD,36));
        textF2.setDocument(new Limit(20));
		textF2.setBackground(Color.BLACK);
		textF2.setForeground(Color.YELLOW);
		
		
		panel2.setLayout(new GridLayout(3,1));
		panel2.add(textF);
		panel2.add(textF1);
		panel2.add(textF2);
		
		
	
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button) {
					int num = textArea.getLineCount();
					String[] lines = textArea.getText().split("\n"); 
				
					if(num==1) {
						 line2=lines[0];
					}
					if(num==2) {
						 line1=lines[0];
						 line2=lines[1];
					}
					if(num >=3) {
						 line1=lines[0];
						 line2=lines[1];
						 line3=lines[2];
					}											
					if(line1 == null) {
						textF.setText(" ");
					}else textF.setText(line1);
					if(line2 == null) {
						textF1.setText(" ");
					}else textF1.setText(line2);
					if(line3 == null) {
						textF2.setText(" ");
					}else textF2.setText(line3);
					
					textArea.requestFocus();
					
				}
			}
			
		});
		
		
		
		textF.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if( e.getKeyCode() ==   KeyEvent.VK_ESCAPE) {
					textF.setText("");
					textF1.setText("");
					textF2.setText("");
					line1="";
					line2="";
					line3="";
					textArea.setText("");
					
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		textF1.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if( e.getKeyCode() ==   KeyEvent.VK_ESCAPE) {
					textF.setText("");
					textF1.setText("");
					textF2.setText("");
					line1="";
					line2="";
					line3="";
					textArea.setText("");
					
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		textF2.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if( e.getKeyCode() ==   KeyEvent.VK_ESCAPE) {
					textF.setText("");
					textF1.setText("");
					textF2.setText("");
					line1="";
					line2="";
					line3="";
					textArea.setText("");
					
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		textArea.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if( e.getKeyCode() ==   KeyEvent.VK_ESCAPE) {
					textF.setText("");
					textF1.setText("");
					textF2.setText("");
					line1="";
					line2="";
					line3="";
					textArea.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
	
		
		setVisible(true);
	}
	
	

	public static void main(String[] agrs) {
		GUI gui= new GUI();
	}

	
	
	}

