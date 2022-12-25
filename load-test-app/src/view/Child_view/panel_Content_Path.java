package view.Child_view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import view.Child_view.*;
import event.ActionPath;

public class panel_Content_Path extends JPanel {
	private JTable table;
	
	

	public panel_Content_Path(panel_Content_Input_Path p){
		initcomponent(p);
	}

	public void initcomponent(panel_Content_Input_Path p) {
		this.setLayout(null);
		this.setSize(864, 406);
		this.setBackground(Color.LIGHT_GRAY);
		JPanel panelContent;
		panelContent = new JPanel();
		panelContent.setBackground(Color.LIGHT_GRAY);
		panelContent.setLayout(null);
		panelContent.setBounds(0, 0, 900, 406);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 81, 804, 304);
		panelContent.add(scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null }, },
				new String[] { "#Sample", "Success", "Timeout", "%Success" }));
		scrollPane.setViewportView(table);
		table.getModel();
		p.tableModel_1 = (DefaultTableModel) table.getModel();
		this.add(panelContent);
	}
}
