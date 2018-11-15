import java.io.*;
import java.util.*;


public class FileHandling {

	public static void FileIO(String[] args) throws IOException {
		
		
		Scanner sc = new Scanner(new FileReader("Books.txt"));

        HashMap<String, String> map = new HashMap<String, String>();

        while (sc.hasNextLine()) {
            String[] columns = sc.nextLine().split(" ");
            map.put(columns[0], columns[1]);
        }

        System.out.println(map);
        
        map.replace("1", "rahul", "sawant");
        
        
        System.out.println(map);
        
        FileWriter fw = new FileWriter("Books.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.write("");
        pw.flush(); 
        pw.close();
        
        BufferedWriter writer = null;
        
        try {
            writer = new BufferedWriter(new FileWriter("Books.txt"));
            
        
        
        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            System.out.println("Key = " + key + ", Value = " + value);
            
          writer.write(key + " " + value);
          writer.newLine();
          
        }
        }
        catch (IOException e) {
                System.err.println(e);
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        System.err.println(e);
                    }
                }
            }
	}
            
            
          

     
}
    
	

