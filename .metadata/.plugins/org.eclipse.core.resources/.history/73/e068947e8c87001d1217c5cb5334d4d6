package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Thread.Thread_Get;
import Thread.Thread_Post;
import view.Child_view.panel_Content_Create_Http_Request;

public class SendActionMethod implements ActionListener {
	panel_Content_Create_Http_Request g;

	public SendActionMethod(panel_Content_Create_Http_Request g) {
		this.g = g;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(g.CREATE_REQUEST)) {
			   if(g.txtPath.getText() !="" && checkNumber(g.requestNum.getText()) && g.txtServerName.getText()!="") {
				   g.howManyThreads = Integer.parseInt(g.requestNum.getText());
					g.tableModel.setRowCount(0);
					g.dem = 1;
					g.count_request += 1;
					g.Announce.setText("");
				
				try {
					g.thread = new Thread[g.howManyThreads];

					
		           if(g.cbbMethod.getSelectedIndex()==0) {
		        	   for (int i = 0; i < g.thread.length; i++) {
		   				g.thread[i] = new Thread(new Thread_Get(g));
		   			}
		           }
		           else {
		        	   for (int i = 0; i < g.thread.length; i++) {
		      				g.thread[i] = new Thread(new Thread_Post(g));
		      			}
		           }

					for (int i = 0; i < g.thread.length; ++i) {
						g.index=i;
						g.thread[i].start();
						if (i == 0) {
							g.Starttime = System.currentTimeMillis();
						}
						if (i == g.thread.length - 1) {
							g.Endtime = System.currentTimeMillis();
						}
						final long timestamp = new Date().getTime();
						g.kq = GetDate(timestamp);
						g.thread[i].sleep(200);

					}
				} catch (Exception ex) {
					// TODO: handle exception
				}
				g.through = (g.howManyThreads
						/ Double.parseDouble((g.Endtime + g.reponsetime.get(g.reponsetime.size() - 1) - g.Starttime) + ""))
						* 1000;
				g.tableModel2.addRow(new Object[] { "HTTP request " + g.count_request, g.howManyThreads,
						g.df.format(TB(g.reponsetime)), Min(g.reponsetime), Max(g.reponsetime), g.df.format(Double.valueOf(g.Error)/g.howManyThreads),
						g.df.format(g.through) + "/sec", g.df.format(TB(g.Byte) / 1024) });
			   }
			   else {
				   g.Announce.setText("Vui long kiem tra lai thong tin da nhap");
			   }
		}
	}
	

	public String GetDate(long date) {

		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date);
		final String timeString = new SimpleDateFormat("HH:mm:ss:SSS").format(cal.getTime());
		return timeString;

	}

	public double TB(List<Integer> l) {

		double giatri = 0, sum = 0;
		for (Integer value : l) {
			sum += value;
		}
		giatri = sum / l.size();
		return giatri;
	}

	public static int Min(List<Integer> l) {
		int min = l.get(0);
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i) < min) {
				min = l.get(i);
			}
		}
		return min;
	}

	public static int Max(List<Integer> l) {
		int max = l.get(0);
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i) > max) {
				max = l.get(i);
			}
		}
		return max;
	}
	public static boolean checkNumber(String txt) {
		return txt.matches("-?\\d+(\\.\\d+)?");
	}
}
