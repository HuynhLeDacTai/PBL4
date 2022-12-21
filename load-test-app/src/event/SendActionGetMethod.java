package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import view.*;
import view.Child_view.panel_Content_Create_Http_Request;
import Thread.Thread_Get;

public class SendActionGetMethod implements ActionListener {
	Get g;
	Thread_Get t;

	public SendActionGetMethod(Get g) {
		this.g = g;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(g.CREATE_REQUEST)) {
			g.howManyThreads = Integer.parseInt(g.requestNum.getText());
			g.tableModel.setRowCount(0);
			g.dem = 1;
			g.count_request += 1;
		}
		try {
			g.thread = new Thread[g.howManyThreads];

			for (int i = 0; i < g.thread.length; i++) {
				t = new Thread_Get(g);

				g.thread[i] = new Thread(t);

			}

			for (int i = 0; i < g.thread.length; ++i) {
				g.thread[i].start();
				if (i == 0) {
					g.Starttime = System.currentTimeMillis();
				}
				if (i == g.thread.length - 1) {
					g.Endtime = System.currentTimeMillis();
				}
				final long timestamp = new Date().getTime();
				g.kq = GetDate(timestamp);
				g.thread[i].sleep(2000);
				// kq = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();

			}
		} catch (Exception ex) {
			// TODO: handle exception
		}
		g.through = (g.howManyThreads
				/ Double.parseDouble((g.Endtime + g.reponsetime.get(g.reponsetime.size() - 1) - g.Starttime) + ""))
				* 60000;
		DefaultTableModel tableModel2;
		g.table2.getModel();
		tableModel2 = (DefaultTableModel) g.table2.getModel();
		tableModel2.addRow(new Object[] { "HTTP request " + g.count_request, g.howManyThreads,
				g.df.format(TB(g.reponsetime)), Min(g.reponsetime), Max(g.reponsetime), g.Error,
				g.df.format(g.through) + "/min", g.df.format(TB(g.Byte) / 1024) });
	}

	public String GetDate(long date) {

		// with java.util.Date/Calendar api
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date);

		// and here's how to get the String representation
		final String timeString = new SimpleDateFormat("HH:mm:ss:SSS").format(cal.getTime());
//	System.out.println(minutes);
		// System.out.println(timeString);
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
}
