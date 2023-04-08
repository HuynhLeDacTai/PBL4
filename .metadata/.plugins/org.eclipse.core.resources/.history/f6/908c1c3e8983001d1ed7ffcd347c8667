package Thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

import view.*;
import view.Child_view.panel_Content_Create_Http_Request;

public class Thread_Post implements Runnable {
	panel_Content_Create_Http_Request p;

	public Thread_Post(panel_Content_Create_Http_Request p) {
		this.p = p;
	}

	public void run() {
		long index =p.index;
		long start = 0;
		long finish = 0;

		int len;
		String status = "";

		String result = new String();
		StringBuilder body = new StringBuilder();
		StringBuilder header = new StringBuilder();
		try {
			URL url = new URL(p.txtServerName.getText());
			start = System.currentTimeMillis();
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setDoOutput(true);
			OutputStream os = con.getOutputStream();
			os.write(p.txtPath.getText().getBytes());
			os.flush();
			os.close();
		

			if (con.getResponseCode() == 200) {
				finish = System.currentTimeMillis();
				status = con.getResponseMessage();
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					body.append(inputLine);

				}
				in.close();

				Map<String, List<String>> headerFields = con.getHeaderFields();

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

			if (con.getResponseCode() == 404) {
				p.Error++;
			}

//			/////////

		} catch (Exception e) {

		} finally {
		
		}
		result = ((finish - start) + "");

		int Byte_reponse = header.length() + body.length();
		p.tableModel.addRow(new Object[] { index, p.kq, "HTTP request", result + "ms", status, Byte_reponse });
		p.reponsetime.add(Integer.parseInt(result));
		p.Byte.add(header.length() + body.length());
//		System.out.println(body.toString());
//		System.out.println(header.toString());

	}
}
