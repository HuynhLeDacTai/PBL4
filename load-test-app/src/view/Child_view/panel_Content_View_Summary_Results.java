package view.Child_view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panel_Content_View_Summary_Results extends JPanel{
	private JTable table;
	public panel_Content_View_Summary_Results(panel_Content_Create_Http_Request p)
	{
		initcomponent(p);
	}
	public void initcomponent(panel_Content_Create_Http_Request p){
		this.setLayout(null);
		this.setSize(864, 406);
		this.setBackground(Color.LIGHT_GRAY);

		JPanel panelContent;
		panelContent=new JPanel();
		panelContent.setBackground(Color.LIGHT_GRAY);
		panelContent.setLayout(null);
		panelContent.setBounds(0,0, 864, 406);

		JLabel lblNewLabel_1_2 = new JLabel("Summary Report");
		lblNewLabel_1_2.setBounds(30, 11, 200, 27);
		lblNewLabel_1_2.setForeground(SystemColor.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panelContent.add(lblNewLabel_1_2);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 51, 804, 304);
		panelContent.add(scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null }, },
				new String[] { "Label", "#Sample", "Average", "Min", "Max", "Error%", "Throughput", "KB/sec" }));
		scrollPane.setViewportView(table);
		table.getModel();
		p.tableModel2 = (DefaultTableModel) table.getModel();		
		this.add(panelContent);
	}
}
