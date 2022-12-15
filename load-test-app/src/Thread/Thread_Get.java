package Thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

import view.*;

public class Thread_Get implements Runnable {
	Get g;

	public Thread_Get(Get g) {
		this.g = g;
	}

	public void run() {
		long start = 0;
		long start2 = 0;
		long finish = 0;
		long finish2 = 0;

		int len;
		String status = "";

		String result = new String();
		StringBuilder body = new StringBuilder();
		StringBuilder header = new StringBuilder();
		try {
			URL url = new URL(g.servername.getText() + g.path.getText());
			HttpURLConnection httpUrlConnect = (HttpURLConnection) url.openConnection();
//   			httpUrlConnect.setConnectTimeout(1000);
			httpUrlConnect.setRequestMethod("GET");
			start = System.currentTimeMillis();
//			d = new Date();
//			kq = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
			httpUrlConnect.connect();

			if (httpUrlConnect.getResponseCode() == 200) {
				status = httpUrlConnect.getResponseMessage();
				try (BufferedReader reader = new BufferedReader(
						new InputStreamReader(httpUrlConnect.getInputStream()))) {
					for (String line; (line = reader.readLine()) != null;) {
						body.append(line);
						// System.out.println(line);

					}
				}

				Map<String, List<String>> headerFields = httpUrlConnect.getHeaderFields();

				Set<String> headerFieldsSet = headerFields.keySet();
				Iterator<String> hearerFieldsIter = headerFieldsSet.iterator();

				while (hearerFieldsIter.hasNext()) {

					String headerFieldKey = hearerFieldsIter.next();
					List<String> headerFieldValue = headerFields.get(headerFieldKey);

					StringBuilder sb = new StringBuilder();
					for (String value : headerFieldValue) {
						sb.append(value);
						sb.append("");
					}
					String s = headerFieldKey + "=" + sb.toString();
					header.append(s);

				}
			}

			if (httpUrlConnect.getResponseCode() == 404) {
				g.Error++;

			}

//			/////////

		} catch (Exception e) {

		} finally {
			finish = System.currentTimeMillis();
		}
		result = ((finish - start) + "");

		int Byte_reponse = header.length() + body.length();
//		DefaultTableModel tableModel;
//		g.table.getModel();
//	   
//		tableModel = (DefaultTableModel) g.table.getModel();
		g.tableModel.addRow(new Object[] { g.dem++, g.kq, "HTTP request", result + "ms", status, Byte_reponse });
		g.reponsetime.add(Integer.parseInt(result));
		g.Byte.add(header.length() + body.length());

	}
}
