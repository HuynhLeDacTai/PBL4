package view.Child_view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import event.SendActionMethod;

public class panel_Content_Create_Http_Request extends JPanel {
	public static final String CREATE_REQUEST = "CREATE_REQUEST";
	public JTextField txtServerName;
	public JTextField txtPath;
	public JLabel Announce ;
	public JComboBox cbbMethod;
	public DefaultTableModel tableModel;
	public DefaultTableModel tableModel2;
	public static int howManyThreads = 0;
	public static Thread thread[];
	public JTextField requestNum;
	public JButton btnSend;
	public static int dem = 1;
	public static int index;
	
	public static int count_request=0;
	public String kq = "";
	public Date d;
	public long Endtime;
	public long Starttime;
	public double through = 0;
	public List<Integer> reponsetime = new ArrayList<>();
	public static int Error = 0;
	public List<Integer> Byte = new ArrayList<>();
	public DecimalFormat df = new DecimalFormat("#.##");
	private JProgressBar progressBar;
	public panel_Content_Create_Http_Request()
	{
		initcomponent();
	}
	public void initcomponent(){
		this.setLayout(null);
		this.setSize(864, 406);
		this.setBackground(Color.LIGHT_GRAY);
		
		JPanel panelContent;
		panelContent=new JPanel();
		panelContent.setBackground(Color.LIGHT_GRAY);
		panelContent.setLayout(null);
		panelContent.setBounds(0,0, 864, 406);

	    JLabel lblNewLabel_1_2 = new JLabel("Server Name or IP:");
		lblNewLabel_1_2.setBounds(189, 11, 143, 27);
		lblNewLabel_1_2.setForeground(SystemColor.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panelContent.add(lblNewLabel_1_2);
		
		 txtServerName = new JTextField();
		txtServerName.setBounds(333, 13, 268, 27);
		txtServerName.setForeground(Color.WHITE);
		panelContent.add(txtServerName);
		txtServerName.setBackground(new Color(69, 73, 74));
		txtServerName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Number request");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1.setBounds(189, 75, 200, 24);
		panelContent.add(lblNewLabel_1_1);
		
		requestNum = new JTextField();
		requestNum.setForeground(Color.WHITE);
		requestNum.setColumns(10);
		requestNum.setBounds(333, 77, 95, 27);
		requestNum.setBackground(new Color(69, 73, 74));
		panelContent.add(requestNum);
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Method ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_2_1.setBounds(189, 140, 200, 24);
		panelContent.add(lblNewLabel_1_2_1);

		
		String[] options = {"GET", "POST"};
		cbbMethod = new JComboBox(options);
		cbbMethod.setBounds(333, 140, 85, 22);
		panelContent.add(cbbMethod);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Path ");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_2_2.setBounds(189, 205, 200, 24);
		panelContent.add(lblNewLabel_1_2_2);
		
		 txtPath = new JTextField();
		txtPath.setForeground(Color.WHITE);
		txtPath.setColumns(10);
		txtPath.setBounds(333, 205, 268, 27);
		txtPath.setBackground(new Color(69, 73, 74));
		panelContent.add(txtPath);
		
		btnSend = new JButton("SEND");
		btnSend.setBounds(385, 275, 95, 40);
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSend.setBackground(new Color(176, 224, 230));
		btnSend.addActionListener(new SendActionMethod(this));
	    btnSend.setActionCommand(CREATE_REQUEST);
		panelContent.add(btnSend);
		
		Announce = new JLabel();
		Announce.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		Announce.setForeground(Color.RED);
		Announce.setBounds(300, 250, 300, 24);
		panelContent.add(Announce);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(268, 353, 339, 24);
		panelContent.add(progressBar);
		this.add(panelContent);
	}
	public void Process()
	{
		int i = 0;
		while(i <= 100)
		{
			i++;
			progressBar.setValue(i);
			try {
				Thread.sleep(150);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
