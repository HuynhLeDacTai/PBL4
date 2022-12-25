package Thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import view.Child_view.panel_Content_Create_Http_Request;

public class Thread_Get implements Runnable {
	panel_Content_Create_Http_Request g;

	public Thread_Get(panel_Content_Create_Http_Request g) {
		this.g = g;
	}

	public void run() {
		long index =g.index;
		long start = 0;
		long finish = 0;


		int len;
		String status = "";

		String result = new String();
		StringBuilder body = new StringBuilder();
		StringBuilder header = new StringBuilder();
		try {
			URL url = new URL(g.txtServerName.getText() + g.txtPath.getText());
			start = System.currentTimeMillis();
			HttpURLConnection httpUrlConnect = (HttpURLConnection) url.openConnection();
			httpUrlConnect.setRequestMethod("GET");
			httpUrlConnect.connect();

			if (httpUrlConnect.getResponseCode() == 200) {
				finish = System.currentTimeMillis();
				status = httpUrlConnect.getResponseMessage();
				try (BufferedReader reader = new BufferedReader(
						new InputStreamReader(httpUrlConnect.getInputStream()))) {
					for (String line; (line = reader.readLine()) != null;) {
						body.append(line);
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
		}
		result = ((finish - start) + "");

		int Byte_reponse = header.length() + body.length();
	    g.tableModel.addRow(new Object[] { index, g.kq, "HTTP request", result + "ms", status, Byte_reponse });
		g.reponsetime.add(Integer.parseInt(result));
		g.Byte.add(header.length() + body.length());

	}
}
