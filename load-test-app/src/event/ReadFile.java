package event;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFile {
   private static ArrayList<String> Ngay = new ArrayList<>();
   private static ArrayList<String> Status = new ArrayList<>();
    public static void main(String args[]) {

        String url = "E:\\logtest.txt";

        // Đọc dữ liệu từ File với BufferedReader
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;


        try {
            
            fileInputStream = new FileInputStream(url);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = bufferedReader.readLine();
            int dem =1;
            while (line != null) {
            	String[] arrofline = line.split(":",2);
            	if(arrofline[0].equals("Set-Cookie")) {
            		dem=4;
            	}
               System.out.println(line);
               System.out.println(dem+"");
               if(dem==2) {
            	   String[] arrOfStr= line.split("h",2);
                 	Ngay.add(arrOfStr[0]);
               }
               if(dem==4 && !arrofline[0].equals("Set-Cookie")) {
            	   String[] arrOfStr= line.split(" ",2);
            	   Status.add(arrOfStr[1]);
               }
               if(dem==14) {
            	   dem=0;
               }
//               String[] arrOfStr= line.split(":",2);
//               if(arrOfStr[0].equals("Date")) {
//               	Ngay.add(arrOfStr[1]);
//               }
                line = bufferedReader.readLine();
                dem++;
               
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName())
                            .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName())
                            .log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
                fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadFile.class.getName())
                                .log(Level.SEVERE, null, ex);
            }
        }
        
        
        for (String string : Ngay) {
			System.out.println(string);
			
		}
        for (String string : Status) {
			System.out.println(string);
			
		}
    }
}
