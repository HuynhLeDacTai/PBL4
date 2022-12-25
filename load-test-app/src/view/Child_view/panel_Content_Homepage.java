package view.Child_view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panel_Content_Homepage extends JPanel {
	private JLabel lblNewLabel_1;
	public panel_Content_Homepage()
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
		lblNewLabel_1 = new JLabel("WELCOME TO OUR APP!!!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 39));
		lblNewLabel_1.setBounds(37, 125, 2000, 171);
		panelContent.add(lblNewLabel_1);
		this.add(panelContent);
	}
}
