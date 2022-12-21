package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.tree.DefaultTreeModel;

import view.Child_view.panel_Content_Create_Http_Request;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6963395289124774341L;
	private JPanel contentPane;
	private JTextField txtPort;
	private JTextField txtServerName;
	private JTextField txtProtocol;
	private JTextField txtPath;
	private JTable table;
	private JTree tree;
	private JLabel selectedLabel;
	private JPanel panel_mainView;
	JPanel panel_main;
	JPanel Create_Http_Request;
	JPanel Summary_Report;
	JPanel View_Result_In_Table;
	private JPanel panel_main_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public void CreateNode(DefaultMutableTreeNode top)
	{
		DefaultMutableTreeNode category = null;
		DefaultMutableTreeNode book = null;
	}
	public void CreateTree()
	{
		tree = new JTree();
		//create the root node
		DefaultMutableTreeNode TestPlan = new DefaultMutableTreeNode("Test Plan");
		//create the child node
		DefaultMutableTreeNode TestByCode = new DefaultMutableTreeNode("Test By HTTP Request Coding");
			TestByCode.add(new DefaultMutableTreeNode("Create HTTP Request"));
			TestByCode.add(new DefaultMutableTreeNode("Summary Report"));
			TestByCode.add(new DefaultMutableTreeNode("View Results in Table"));
		DefaultMutableTreeNode TestByBurpSuite = new DefaultMutableTreeNode("Test By Burp Suite");
			TestByBurpSuite.add(new DefaultMutableTreeNode("Create HTTP Request"));
			TestByBurpSuite.add(new DefaultMutableTreeNode("Summary Report"));
			TestByBurpSuite.add(new DefaultMutableTreeNode("View Results in Table"));
			
		TestPlan.add(TestByCode);
		TestPlan.add(TestByBurpSuite);
		tree.setModel(new DefaultTreeModel(TestPlan));
		
//		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
//            @Override
//            public void valueChanged(TreeSelectionEvent e) {
//                selectedLabel.setText(e.getPath().toString());
//                String path = e.getPath().toString();
//                
//            	PanelMain panel=new PanelMain();
//            	panel.setBounds(10, 140, 864, 406);
//            	
//                panel_Content_Create_Http_Request a = new panel_Content_Create_Http_Request();
//                a.setBounds(10, 140, 864, 406);
//            	panel_main.add(a);
//            	
//            	a.setVisible(false);
//                //Test By HTTP Request Coding
//                if(path.equals("[Test Plan, Test By HTTP Request Coding, Create HTTP Request]"))
//                {
//                	panel_mainView.setVisible(true);
//                	panel_main_2.setVisible(false);
////                	panel_mainView.setBackground(Color.RED);
//                	
////                	Component[] components = panel_mainView.getComponents();
////                	for (int i = 0; i < components.length; i++) {
////
//////                	    if(components[i].getClass().getName().toString().equals("javax.swing.JTextField")){
////                	        components[i].setVisible(false);
//////                	    }
////                	}
////                	
//                	
//                	
//
//                	panel_main.add(panel);
////                	panel_2.add(panel); 
//                	System.out.println("ok"); 
//                } 
//                else if (path.equals("[Test Plan, Test By HTTP Request Coding, Summary Report]"))
//                {
//                	a.setVisible(true);
//                	panel.setVisible(false);
//                }
//                else if (path.equals("[Test Plan, Test By HTTP Request Coding, View Results in Table]"))
//                {
//                	System.out.println(1);
//                }
//                //Test By Burp Suite
//                else if (path.equals("[Test Plan, Test By Burp Suite, Create HTTP Request]"))
//                {
//                	System.out.println(1);
//                }
//                else if (path.equals("[Test Plan, Test By Burp Suite, Summary Report]"))
//                {
//                	System.out.println(1);
//                }
//                else if (path.equals("[Test Plan, Test By Burp Suite, View Results in Table]"))
//                {
//                	System.out.println(1);
//                }
//                else 
//                	System.out.println(0);
//            } 
//        });

//		tree.setModel(new DefaultTreeModel(
//			new DefaultMutableTreeNode("Test Plan") {
//				{
//					DefaultMutableTreeNode node_1;
//					node_1 = new DefaultMutableTreeNode("Test By HTTP Request Coding");
//						node_1.add(new DefaultMutableTreeNode("Create HTTP Request "));
//						node_1.add(new DefaultMutableTreeNode("Summary Report"));
//						node_1.add(new DefaultMutableTreeNode("View Results in Table"));
//					add(node_1);
//					DefaultMutableTreeNode node_2;
//					node_2 = new DefaultMutableTreeNode("Test By Burp Suite");
//						node_2.add(new DefaultMutableTreeNode("Create HTTP Request "));
//						node_2.add(new DefaultMutableTreeNode("Summary Report"));
//						node_2.add(new DefaultMutableTreeNode("View Results in Table"));
//					add(node_2);
//				}
//			}
//		));
		
//		ImageIcon SettingIcon = new ImageIcon("images/setting.png");
//		if (SettingIcon != null) {
//		    DefaultTreeCellRenderer renderer = 
//		        new DefaultTreeCellRenderer();
//		    renderer.setLeafIcon(SettingIcon);
//		    tree.setCellRenderer(renderer);
//		}
		
	}
	public GUI() {
		setTitle("LOAD TEST ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1151, 618);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 63, 65));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		CreateTree();

		tree.setBackground(Color.LIGHT_GRAY);
		tree.setBounds(10, 11, 221, 557);
		contentPane.add(tree);
		
		panel_main = new JPanel();
		panel_main.setBounds(241, 11, 884, 557);
		contentPane.add(panel_main);
		panel_main.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 864, 118);
		panel_main.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOAD TEST APP");
		lblNewLabel.setBounds(227, 11, 382, 85);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(123, 104, 238));
		lblNewLabel.setFont(new Font("Vladimir Script", Font.BOLD, 30));
		
		selectedLabel = new JLabel("New label");
		selectedLabel.setBounds(23, 65, 629, 42);
		panel.add(selectedLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(254, 83, 339, 24);
		panel.add(progressBar);
//		int i = 0;
//		while(i <= 100)
//		{
//			i++;
//			progressBar.setValue(i);
//			try {
//				Thread.sleep(150);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
		
		panel_mainView = new JPanel();
		panel_mainView.setBackground(Color.BLACK);
		panel_mainView.setBounds(10, 140, 864, 406);
		panel_main.add(panel_mainView);
		panel_mainView.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Protocol :");
		lblNewLabel_1_2_1.setBounds(10, 11, 89, 27);
		panel_mainView.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		txtProtocol = new JTextField();
		txtProtocol.setForeground(Color.WHITE);
		txtProtocol.setBounds(88, 13, 80, 27);
		panel_mainView.add(txtProtocol);
		txtProtocol.setBackground(new Color(69, 73, 74));
		txtProtocol.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Server Name or IP:");
		lblNewLabel_1_2.setBounds(189, 11, 143, 27);
		panel_mainView.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		txtServerName = new JTextField();
		txtServerName.setBounds(333, 13, 268, 27);
		panel_mainView.add(txtServerName);
		txtServerName.setBackground(new Color(69, 73, 74));
		txtServerName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Port number");
		lblNewLabel_1_1.setBounds(611, 14, 89, 24);
		panel_mainView.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		txtPort = new JTextField();
		txtPort.setBounds(706, 11, 95, 27);
		panel_mainView.add(txtPort);
		txtPort.setBackground(new Color(69, 73, 74));
		txtPort.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Path :");
		lblNewLabel_1_2_1_1.setBounds(58, 71, 55, 27);
		panel_mainView.add(lblNewLabel_1_2_1_1);
		lblNewLabel_1_2_1_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		txtPath = new JTextField();
		txtPath.setBounds(133, 71, 513, 27);
		panel_mainView.add(txtPath);
		txtPath.setBackground(new Color(69, 73, 74));
		txtPath.setColumns(10);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.setBounds(706, 64, 95, 40);
		panel_mainView.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(176, 224, 230));
		
		table = new JTable();
		table.setBounds(81, 137, 690, 207);
		panel_mainView.add(table);
		table.setBorder(null);
		table.setBackground(new Color(69, 73, 74));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"GET", "POST"}));
		comboBox.setBounds(28, 107, 85, 22);
		panel_mainView.add(comboBox);
		
		panel_main_2 = new JPanel();
		panel_main_2.setBounds(411, 140, 724, 406);
		panel_main_2.setBackground(Color.LIGHT_GRAY);
		panel_main_2.setBounds(10, 140, 864, 406);
//		panel_mainView.add(panel_main_2);
//		panel_main_2.add(panel_mainView);
		panel_main.add(panel_main_2);
		panel_main_2.setLayout(null);
		panel_mainView.setVisible(true);
	}
}