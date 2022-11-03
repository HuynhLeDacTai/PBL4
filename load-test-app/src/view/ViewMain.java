package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ViewMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6963395289124774341L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMain frame = new ViewMain();
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
	public ViewMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOAD TEST APP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(10, 5, 909, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.setBounds(756, 224, 95, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Port number");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(711, 176, 89, 24);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(806, 173, 95, 27);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(344, 173, 333, 27);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Server Name or IP:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(200, 171, 143, 27);
		contentPane.add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(101, 173, 80, 27);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Protocol:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(27, 171, 64, 27);
		contentPane.add(lblNewLabel_1_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(144, 231, 584, 27);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Request :");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(63, 231, 64, 27);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(63, 294, 788, 258);
		contentPane.add(textArea);
		
		JLabel lblgiYu = new JLabel("*G\u1EEDi 1 y\u00EAu c\u1EA7u v\u1EC1 server");
		lblgiYu.setHorizontalAlignment(SwingConstants.CENTER);
		lblgiYu.setForeground(Color.ORANGE);
		lblgiYu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblgiYu.setBounds(10, 55, 909, 43);
		contentPane.add(lblgiYu);
	}
}