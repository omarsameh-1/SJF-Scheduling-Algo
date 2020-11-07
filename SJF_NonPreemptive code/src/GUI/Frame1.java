package GUI;

import processQueue.ProcessQueue;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import node.Node;
import javax.swing.JTextArea;
public class Frame1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final static String newline = "\n";
	private final static String newtab = "\t";
	private Double id;
	private Double at;
	private Double bt;
	
	
	
	ProcessQueue a =new ProcessQueue();
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Process ID :");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 43, 133, 28);
		frame.getContentPane().add(lblNewLabel);
		
	
		JLabel lblEnterTheFollowing = new JLabel("- Enter the following information for a process -");
		lblEnterTheFollowing.setForeground(new Color(0, 0, 153));
		lblEnterTheFollowing.setFont(new Font("Verdana", Font.BOLD, 15));
		lblEnterTheFollowing.setBounds(145, 0, 399, 28);
		frame.getContentPane().add(lblEnterTheFollowing);
		
		JLabel lblArrivaltime = new JLabel("ArrivalTime :");
		lblArrivaltime.setFont(new Font("Verdana", Font.BOLD, 15));
		lblArrivaltime.setBounds(25, 88, 133, 28);
		frame.getContentPane().add(lblArrivaltime);
		
		JLabel lblBursttime = new JLabel("BurstTime :");
		lblBursttime.setFont(new Font("Verdana", Font.BOLD, 15));
		lblBursttime.setBounds(25, 128, 133, 28);
		frame.getContentPane().add(lblBursttime);
		
		textField = new JTextField();
		textField.setBounds(145, 40, 60, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 85, 60, 37);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(145, 125, 60, 37);
		frame.getContentPane().add(textField_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(30, 144, 255));
		textArea.setBackground(new Color(0, 0, 51));
		textArea.setEnabled(false);
		frame.getContentPane().add(textArea);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					try{	
						id=Double.parseDouble(textField.getText());
						at=Double.parseDouble(textField_1.getText());
						bt=Double.parseDouble(textField_2.getText());
						if(id <0 || at<0 || bt<0) {
							JOptionPane.showMessageDialog(null, "Only positive numbers allowed !");
						}
						
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Only numeric data allowed !");
					}	textArea.setText(null);
						textArea.setBounds(0, 0, 0, 0);
						a.enqueue(id, at, bt);
						
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});
		btnInsert.setBackground(new Color(0, 153, 255));
		btnInsert.setForeground(Color.BLACK);
		btnInsert.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnInsert.setBounds(244, 86, 89, 37);
		frame.getContentPane().add(btnInsert);
		
		
		
		JLabel lblAveragewt = new JLabel("AverageTAT:");
		lblAveragewt.setForeground(new Color(153, 0, 0));
		frame.getContentPane().add(lblAveragewt);
		
		JLabel lblAveragewtrt = new JLabel("AverageWT=RT:");
		lblAveragewtrt.setForeground(new Color(153, 0, 0));
		frame.getContentPane().add(lblAveragewtrt);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(0, 191, 255));
		textField_3.setBackground(new Color(0, 0, 128));
		textField_3.setEnabled(false);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(0, 191, 255));
		textField_4.setBackground(new Color(0, 0, 128));
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		frame.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNumberOfProcesses = new JLabel("Number of Processes :");
		lblNumberOfProcesses.setForeground(new Color(153, 0, 0));
		frame.getContentPane().add(lblNumberOfProcesses);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 191, 255));
		textField_5.setBackground(new Color(0, 0, 128));
		textField_5.setEnabled(false);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		
		JMenu mnDisplay = new JMenu("Display");
		mnTools.add(mnDisplay);
		
		JMenuItem mntmAveragewa = new JMenuItem("AverageWaitingTime");
		mntmAveragewa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!a.isEmpty())
					{
				lblNewLabel_1.setBounds(360, 63, 0, 70);
				lblAveragewtrt.setBounds(380, 106, 99, 16);
				textField_4.setBounds(485, 100, 76, 28);
				textField_4.setText(Double.toString(a.avgWaitingTime(a.getFront())));
				}else {
					JOptionPane.showMessageDialog(null, "Please Enter the information first !");
				}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		mnDisplay.add(mntmAveragewa);
		
		JMenuItem mntmAverageturnaroundtime = new JMenuItem("AverageTurnAroundTime");
		mntmAverageturnaroundtime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if (!a.isEmpty())
					{
					lblNewLabel_1.setBounds(360, 63, 0, 70);
					lblAveragewt.setBounds(380, 70, 89, 16);
					textField_3.setBounds(464, 64, 67, 28);
					textField_3.setText(Double.toString(a.avgTurnAroundTime(a.getFront())));
					}else {
						JOptionPane.showMessageDialog(null, "Please Enter the information first !");
					}
					}catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		mnDisplay.add(mntmAverageturnaroundtime);
		
		JSeparator separator_3 = new JSeparator();
		mnDisplay.add(separator_3);
		
		JMenuItem mntmAllProcessInformation = new JMenuItem("All process information");
		mntmAllProcessInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Node q= new Node();
					q = a.getFront();
					if (!a.isEmpty())
					{
					textArea.setBounds(64, 190, 560, 42*a.displaySize()+1);
					
					textArea.append(" Process ID" + " | " + "ArrivalTime" + " | " + "BusrtTime" + " | "+ "CompletionTime" + " | "
								+ "TurnArouTime" + " | "+"  WaitingTime"+newline);
	        
					textArea.append(" _____________________________________________________________________________"+newline);
					while(q != null){
	         
					textArea.append(" " + q.getID() + newtab + q.getArrivalTime() + newtab+ q.getBurstTime() + newtab+q.getCompletionTime()+
							newtab	+ q.getTurnAroundTime() + newtab + q.getWaitingTime()+newline);
						textArea.append(" ");
	            
					textArea.append("______________________________________________________________________________"+newline);
					q = q.getnext();
					}
					}else {
						JOptionPane.showMessageDialog(null, "Please Enter the information first !");
					}
					
					}catch(Exception e1) {
						e1.printStackTrace();

					}
	        
			}
		});
		mnDisplay.add(mntmAllProcessInformation);
		
		JSeparator separator_1 = new JSeparator();
		mnDisplay.add(separator_1);
		
		JMenuItem mntmNumberOfProcesses = new JMenuItem("Number of processes");
		mntmNumberOfProcesses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				lblNewLabel_1.setBounds(360, 63, 0, 70);
				lblNumberOfProcesses.setBounds(382, 135, 142, 16);
				textField_5.setBounds(531, 129, 55, 28);
				textField_5.setText(Integer.toString(a.displaySize()));
			}catch(Exception e1) {
				e1.printStackTrace();

			}
				}
		});
		mnDisplay.add(mntmNumberOfProcesses);
		
		JSeparator separator = new JSeparator();
		mnTools.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				System.exit(JFrame.EXIT_ON_CLOSE);
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem mntmAllowedNumberOf = new JMenuItem("Allowed Number of processes");
		mntmAllowedNumberOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You can enter unlimited numbers of processes !");
			}
		});
		mnTools.add(mntmAllowedNumberOf);
		
		JSeparator separator_2 = new JSeparator();
		mnTools.add(separator_2);
		mnTools.add(mntmExit);
		
		
		
		
		
		
	}
}
