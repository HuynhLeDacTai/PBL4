package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import view.*;
import Thread.Thread_Post;

public class SendActionPostMethod implements ActionListener {
	Post p;
	Thread_Post t;

	public SendActionPostMethod(Post p) {
		this.p = p;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(p.CREATE_REQUEST)) {
			p.howManyThreads = Integer.parseInt(p.requestNum.getText());
			p.tableModel.setRowCount(0);
			p.dem = 1;
			p.count_request += 1;
		}
		try {
			p.thread = new Thread[p.howManyThreads];

			for (int i = 0; i < p.thread.length; i++) {
				t = new Thread_Post(p);
				p.thread[i] = new Thread(t);

			}

			for (int i = 0; i < p.thread.length; ++i) {
				p.thread[i].start();
				if (i == 0) {
					p.Starttime = System.currentTimeMillis();
				}
				if (i == p.thread.length - 1) {
					p.Endtime = System.currentTimeMillis();
				}
				final long timestamp = new Date().getTime();
				p.kq = GetDate(timestamp);
				p.thread[i].sleep(2000);
				// kq = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();

			}
		} catch (Exception ex) {
			// TODO: handle exception
		}
		p.through = (p.howManyThreads
				/ Double.parseDouble((p.Endtime + p.reponsetime.get(p.reponsetime.size() - 1) - p.Starttime) + ""))
				* 60000;
		DefaultTableModel tableModel2;
		p.table2.getModel();
		tableModel2 = (DefaultTableModel) p.table2.getModel();
		tableModel2.addRow(new Object[] { "HTTP request " + p.count_request, p.howManyThreads,
				p.df.format(TB(p.reponsetime)), Min(p.reponsetime), Max(p.reponsetime), p.Error,
				p.df.format(p.through) + "/min", p.df.format(TB(p.Byte) / 1024) });
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
