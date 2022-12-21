package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ThreadFactory;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import event.*;
import Thread.Thread_Get;
public class Get extends JFrame {
	DataInputStream dis;
	DataOutputStream dos;
	Socket soc;
	public static int howManyThreads = 0;
	public static Thread thread[];
	public JPanel contentPane;
	public JTextField requestNum;
	public JTextField servername;
	public JTextField atrri;
	public JTextField path;
	public JTextArea textArea;
	public JButton Send;
	public JTable table;
	public JTable table2;
	public DefaultTableModel tableModel;
	public static int dem = 1;
	public static int count_request=0;
	public String kq = "";
	public Date d;
	public long Endtime;
	public long Starttime;
	public double through = 0;
	public List<Integer> reponsetime = new ArrayList<>();
	public static int Error = 0;
	public static final String CREATE_REQUEST = "CREATE_REQUEST";
	public List<Integer> Byte = new ArrayList<>();
	public DecimalFormat df = new DecimalFormat("#.##");

	public static void main(String[] args) {
		new Get();

	}

	/**
	 * 
	 */
	public Get() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("LOAD TEST APP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(300, 5, 909, 43);
		contentPane.add(lblNewLabel);

		Send = new JButton("SEND");
		//Send.addActionListener(new SendActionGetMethod(this));
		Send.setActionCommand(CREATE_REQUEST);
		Send.setBounds(1100, 224, 95, 40);
		contentPane.add(Send);
		

		JLabel lblNewLabel_1_1 = new JLabel("Number request");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(1100, 176, 200, 24);
		contentPane.add(lblNewLabel_1_1);

		requestNum = new JTextField();
		requestNum.setColumns(10);
		requestNum.setBounds(1230, 173, 95, 27);
		contentPane.add(requestNum);

		servername = new JTextField();
		servername.setColumns(10);
		servername.setBounds(450, 173, 600, 27);
		contentPane.add(servername);

		JLabel lblNewLabel_1_2 = new JLabel("Server Name or IP:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(300, 171, 143, 27);
		contentPane.add(lblNewLabel_1_2);

//		atrri = new JTextField();
//		atrri.setColumns(10);
//		atrri.setBounds(101, 173, 80, 27);
//		contentPane.add(atrri);
//
//		JLabel lblNewLabel_1_2_1 = new JLabel("Protocol:");
//		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		lblNewLabel_1_2_1.setBounds(27, 171, 64, 27);
//		contentPane.add(lblNewLabel_1_2_1);

		path = new JTextField();
		path.setColumns(10);
		path.setBounds(450, 231, 600, 27);
		contentPane.add(path);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Request :");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(300, 231, 64, 27);
		contentPane.add(lblNewLabel_1_2_1_1);

		// textArea = new JTextArea();
//			textArea.setBounds(63, 294, 788, 258);
//			contentPane.add(textArea);

		JLabel lblgiYu = new JLabel("*G\u1EEDi 1 y\u00EAu c\u1EA7u v\u1EC1 server");
		lblgiYu.setHorizontalAlignment(SwingConstants.CENTER);
		lblgiYu.setForeground(Color.ORANGE);
		lblgiYu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblgiYu.setBounds(300, 55, 909, 43);
		contentPane.add(lblgiYu);
		
		//tao table 1
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 304, 700, 200);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "Sample#", "Start time", "Label", "Sample time(ms)", "Status", "Byte" }));
		scrollPane.setViewportView(table);
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		//tao table 2
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(750, 304, 700, 200);
		contentPane.add(scrollPane2);
		table2 = new JTable();
		table2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null }, },
				new String[] { "Label", "#Sample", "Average", "Min", "Max", "Error%", "Through", "KB/sec" }));
		scrollPane2.setViewportView(table2);
		this.setVisible(true);
		d = new Date();


//		try {
//			thread = new Thread[howManyThreads];
//
//			for (int i = 0; i < thread.length; i++) {
//
//				thread[i] = new Thread(this);
//
//			}
//
//			for (int i = 0; i < thread.length; ++i) {
//				thread[i].start();
//				if (i == 0) {
//					Starttime = System.currentTimeMillis();
//				}
//				if (i == thread.length - 1) {
//					Endtime = System.currentTimeMillis();
//				}
//				final long timestamp = new Date().getTime();
//				kq=GetDate(timestamp);
//				thread[i].sleep(2000);
//				//kq = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
//				
//				
//
//			}
//		} catch (Exception ex) {
//			// TODO: handle exception
//		}
		

	}

//	public void actionPerformed(ActionEvent e) {
//		if(e.getActionCommand().equals(CREATE_REQUEST)) {
//			howManyThreads=Integer.parseInt(requestNum.getText());
//		}
//		try {
//			thread = new Thread[howManyThreads];
//
//			for (int i = 0; i < thread.length; i++) {
//
//				thread[i] = new Thread(this);
//
//			}
//
//			for (int i = 0; i < thread.length; ++i) {
//				thread[i].start();
//				if (i == 0) {
//					Starttime = System.currentTimeMillis();
//				}
//				if (i == thread.length - 1) {
//					Endtime = System.currentTimeMillis();
//				}
//				final long timestamp = new Date().getTime();
//				kq=GetDate(timestamp);
//				thread[i].sleep(2000);
//				//kq = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
//				
//				
//
//			}
//		} catch (Exception ex) {
//			// TODO: handle exception
//		}
//		through = (howManyThreads
//				/ Double.parseDouble((Endtime + reponsetime.get(reponsetime.size() - 1) - Starttime) + "")) * 60000;
//		DefaultTableModel tableModel2;
//		table2.getModel();
//		tableModel2 = (DefaultTableModel) table2.getModel();
//		tableModel2.addRow(new Object[] { "HTTP request", howManyThreads, df.format(TB(reponsetime)), Min(reponsetime),
//				Max(reponsetime), Error, df.format(through) + "/min", df.format(TB(Byte) / 1024) });
//	}
    
//	public void run() {
//		long start = 0;
//		long start2 = 0;
//		long finish = 0;
//		long finish2 = 0;
//		
//		int len;
//		String status = "";
//		
//		String result = new String();
//		StringBuilder body = new StringBuilder();
//		StringBuilder header = new StringBuilder();
//		try {
//			URL url = new URL(servername.getText() + path.getText());
//			HttpURLConnection httpUrlConnect = (HttpURLConnection) url.openConnection();
////   			httpUrlConnect.setConnectTimeout(1000);
//			httpUrlConnect.setRequestMethod("GET");
//			start = System.currentTimeMillis();
////			d = new Date();
////			kq = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
//			httpUrlConnect.connect();
//			
//			if (httpUrlConnect.getResponseCode() == 200) {
//				status = httpUrlConnect.getResponseMessage();
//				try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpUrlConnect.getInputStream()))) {
//					for (String line; (line = reader.readLine()) != null;) {
//						body.append(line);
//						//System.out.println(line);
//						
//					}
//				}
//				
//				Map<String, List<String>> headerFields = httpUrlConnect.getHeaderFields();
//
//				Set<String> headerFieldsSet = headerFields.keySet();
//				Iterator<String> hearerFieldsIter = headerFieldsSet.iterator();
//				 
//				while (hearerFieldsIter.hasNext()) {
//				     
//				     String headerFieldKey = hearerFieldsIter.next();
//				     List<String> headerFieldValue = headerFields.get(headerFieldKey);
//				      
//				     StringBuilder sb = new StringBuilder();
//				     for (String value : headerFieldValue) {
//				         sb.append(value);
//				         sb.append("");
//				    }
//				      String s=headerFieldKey + "=" + sb.toString();
//				      header.append(s);
//	   
//				}
//			}
//			
//			if (httpUrlConnect.getResponseCode() == 404) {
//				Error++;
//
//			}
//			
////			/////////
//			
//			
//
//		} catch (Exception e) {
//
//		}
//		finally {
//			finish = System.currentTimeMillis();
//		}
//		result = ((finish - start) + "");
//		
//		int Byte_reponse =header.length() + body.length();
//		DefaultTableModel tableModel;
//		table.getModel();
//		tableModel = (DefaultTableModel) table.getModel();
//		tableModel.addRow(new Object[] {dem++ , kq, "HTTP request", result+"ms", status,Byte_reponse });
//		reponsetime.add(Integer.parseInt(result));
//		Byte.add(header.length() + body.length());
//
//
//		
//
//	}
public void setTable(int dem ,String kq ,String result, String status ,int Byte ) {

	}
//	public String GetDate(long date) {
// 
//
//
//	// with java.util.Date/Calendar api
//	final Calendar cal = Calendar.getInstance();
//	cal.setTimeInMillis(date);
//	
//	
//	// and here's how to get the String representation
//	final String timeString =
//	    new SimpleDateFormat("HH:mm:ss:SSS").format(cal.getTime());
////	System.out.println(minutes);
//	//System.out.println(timeString);
// return timeString;
//		 
//		
//	}
//	public double TB(List<Integer> l) {
//
//		double giatri = 0, sum = 0;
//		for (Integer value : l) {
//			sum += value;
//		}
//		giatri = sum / l.size();
//		return giatri;
//	}
//
//	public static int Min(List<Integer> l) {
//		int min = l.get(0);
//		for (int i = 0; i < l.size(); i++) {
//			if (l.get(i) < min) {
//				min = l.get(i);
//			}
//		}
//		return min;
//	}
//
//	public static int Max(List<Integer> l) {
//		int max = l.get(0);
//		for (int i = 0; i < l.size(); i++) {
//			if (l.get(i) > max) {
//				max = l.get(i);
//			}
//		}
//		return max;
//	}
};
