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

        String url = "E:\\1.txt";

        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;

        int count=0;
        try {
            
            fileInputStream = new FileInputStream(url);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = bufferedReader.readLine();
            int dem =0;
            while (line != null) {
            	if(line.contains("==")) {
                           dem=1;
            	}
               if(dem==2 && line.contains("HTTP")) {
            	   String[] arrOfStr= line.split(" ",2);
            	   Status.add(arrOfStr[1]);
            	   count++;
               }
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
        System.out.println( count +"");
    }
}
