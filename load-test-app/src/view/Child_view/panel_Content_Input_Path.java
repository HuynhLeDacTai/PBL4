package view.Child_view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import event.ReadFile;
import event.SendActionMethod;

public class panel_Content_Input_Path extends JPanel {
	private String txtPath;
	private JTable table;
	public panel_Content_Input_Path()
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
		
	    JLabel lblNewLabel_1_1 = new JLabel("Input Path (Log File Of Intruder) :");
	    lblNewLabel_1_1.setBounds(89, 11, 300, 27);
	    lblNewLabel_1_1.setForeground(SystemColor.BLACK);
	    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	    panelContent.add(lblNewLabel_1_1);
	    
	    JTextField txtPathLogFile= new JTextField();
	    txtPathLogFile.setBounds(333, 13, 268, 27);
	    txtPathLogFile.setForeground(Color.WHITE);
		panelContent.add(txtPathLogFile);
		txtPathLogFile.setBackground(new Color(69, 73, 74));
		txtPathLogFile.setColumns(10);
		
		JButton btnOK= new JButton("OK");
		btnOK.setBounds(650, 6, 95, 40);
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOK.setBackground(new Color(176, 224, 230));
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtPath = txtPathLogFile.getText();
				new ReadFile(txtPath);
			}
		});
//		btnOK.setActionCommand(CREATE_REQUEST);
		panelContent.add(btnOK);
	    
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 51, 804, 304);
		panelContent.add(scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null }, },
				new String[] { "Label", "#Sample", "Average", "Min", "Max", "Error%", "Through", "KB/sec" }));
		scrollPane.setViewportView(table);
		table.getModel();
//		p.tableModel = (DefaultTableModel) table.getModel();	
		
		
		this.add(panelContent);
	}
}
