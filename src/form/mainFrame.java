package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class mainFrame extends JFrame {

	public JPanel contentPane;
	public JTextField NameField;
	public JTextField EmailField;
	public JTextField AgeField;
	public JTextField EmailSearchField;
	public JLabel nameSearch;
	public JLabel AgeSearch;
	public JLabel IDSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
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
	public mainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(23, 14, 70, 15);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(23, 41, 70, 15);
		contentPane.add(lblEmail);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(23, 68, 70, 15);
		contentPane.add(lblAge);
		
		NameField = new JTextField();
		NameField.setBounds(122, 10, 202, 19);
		contentPane.add(NameField);
		NameField.setColumns(10);
		
		EmailField = new JTextField();
		EmailField.setColumns(10);
		EmailField.setBounds(122, 37, 202, 19);
		contentPane.add(EmailField);
		
		AgeField = new JTextField();
		AgeField.setColumns(10);
		AgeField.setBounds(122, 64, 202, 19);
		contentPane.add(AgeField);
		
		JButton EnterButton = new JButton("Enter");
		EnterButton.setBounds(336, 26, 100, 30);
		contentPane.add(EnterButton);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(23, 145, 70, 15);
		contentPane.add(lblEmail_1);
		
		EmailSearchField = new JTextField();
		EmailSearchField.setColumns(10);
		EmailSearchField.setBounds(122, 143, 202, 19);
		contentPane.add(EmailSearchField);
		
		JButton SearchButton = new JButton("Search");
		SearchButton.setBounds(336, 140, 100, 30);
		contentPane.add(SearchButton);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(23, 187, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Age");
		lblNewLabel_1.setBounds(23, 214, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(23, 241, 70, 15);
		contentPane.add(lblId);
		
		nameSearch = new JLabel("");
		nameSearch.setBounds(122, 187, 192, 15);
		contentPane.add(nameSearch);
		
		AgeSearch = new JLabel("");
		AgeSearch.setBounds(122, 214, 192, 15);
		contentPane.add(AgeSearch);
		
		IDSearch = new JLabel("");
		IDSearch.setBounds(122, 241, 192, 15);
		contentPane.add(IDSearch);
		
		EnterButton.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Integer.parseInt(AgeField.getText());
					person p = new person(NameField.getText(), EmailField.getText(), Integer.parseInt(AgeField.getText()));
					
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "The Age must be A Valid Number", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				NameField.setText("");
				EmailField.setText("");
				AgeField.setText("");
				
				System.out.println("Entered frame");
				
			}
		});
		
		SearchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id = 1;
				while(true) {
					
					String namefile = Integer.toString(id);
					File filesearch = new File(namefile + ".txt");
					if (filesearch.exists()) {
						
						try {
							Scanner scan = new Scanner(filesearch);
							String name = scan.nextLine();
							String email = scan.nextLine();
							System.out.println("The Email is " + email);
							if (email.equals(EmailSearchField.getText())) {
								int age =  Integer.parseInt(scan.nextLine());
								System.out.println("Name = " + name);
								System.out.println("Age = " + age);
								System.out.println("ID = " + id);
								nameSearch.setText(name);
								AgeSearch.setText(Integer.toString(age));
								IDSearch.setText(Integer.toString(id));
								
								break;
							}
							else 
								id++;
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Not Found", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					}
					
				}
				
			}
			
		});
		
	}
	
}
