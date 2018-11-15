import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Journals {
	
public void borrowJournals(String BorrowerName)throws IOException {
		
		Scanner sc = new Scanner(new FileReader("Journals.txt"));
		Scanner scn = new Scanner(new FileReader("Journalborrower.txt"));
		

        HashMap<String, String> Journals = new HashMap<String, String>();
        Map<String, List<String>> Journalborrower = new HashMap<String, List<String>>();
        ArrayList<String> JName = new ArrayList<String>();
        
        //BookBorrower.clear();
        
        while (sc.hasNextLine()) {
            String[] columns1 = sc.nextLine().split(" ");
            Journals.put(columns1[0], columns1[1]);
        }
        
        while (scn.hasNextLine()) {
            String[] columns2 = scn.nextLine().split(" ");
            JName.add(columns2[1]);
            Journalborrower.put(columns2[0],JName);
        }

        System.out.println(Journals);
        System.out.println(Journalborrower);
        
        List<String> JournalsAvailed = Journalborrower.get(BorrowerName);
        int JournalNos = JournalsAvailed.size();
        System.out.println(JournalsAvailed+"\n " +JournalNos);
        
        //Checking Maximum number of Books issued to the Borrower
        if(JournalNos < 5){
        System.out.println("Enter the Name Of the journal you want to borrow:");
        Scanner input=new Scanner(System.in);
        String JournalName=input.nextLine();
        
        Set<String> Keys=Journals.keySet();
        int Count;
        Count = 0;
        loops:
        for(String k: Keys){
          
        	//System.out.println(k);
        	//Checking if the Book exists
        	if(JournalName.equals(k))
        	{ Count++;
        	
        		//Checking if a copy of the Book is available
        		if(Integer.parseInt(Journals.get(JournalName))!=0)
        		{
              			Journals.replace(JournalName, Journals.get(JournalName), String.valueOf(Integer.parseInt(Journals.get(JournalName))-1));
              			JName.add(JournalName);
              			Journalborrower.put(BorrowerName,JName);
              			//System.out.println(Journalborrower);
              			//System.out.println(Journals);
              			System.out.println("Transaction successfull");
        		}else{
        		System.out.println("The Journal you selected is not available currently");
        		break loops;
        		}
        			
        	}
        	
        	}
        if(Count==0){
    		System.out.println("Enter a valid Journal Name");
        }
        
        //Journalborrower.clear();
        
    
        
        
        //System.out.println("Transaction Denied");
        	
        	
          
        //System.out.println(Books);
        
        FileWriter fw1 = new FileWriter("Journals.txt");
        PrintWriter pw1 = new PrintWriter(fw1);
        pw1.write("");
        pw1.flush(); 
        pw1.close();
        
        /*FileWriter fw2 = new FileWriter("BookBorrower.txt");
        PrintWriter pw2 = new PrintWriter(fw2);
        pw2.write("");
        pw2.flush(); 
        pw2.close();*/
        
        BufferedWriter writer1 = null;
        
        
        try {
            writer1 = new BufferedWriter(new FileWriter("Journals.txt"));
                       
               
        Iterator entries = Journals.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            //System.out.println("Key = " + key + ", Value = " + value);
            
          writer1.write(key + " " + value);
          writer1.newLine();
          
                    
        }
        }
        catch (IOException e) {
                System.err.println(e);
            } finally {
                if (writer1 != null) {
                    try {
                        writer1.close();
                        
                    } catch (IOException e) {
                        System.err.println(e);
                    }
                }
            }
        
        BufferedWriter writer2 = null;
        writer2 = new BufferedWriter(new FileWriter("Journalborrower.txt"));
        
        try {
        
        for(Map.Entry<String, List<String>> entry2 : Journalborrower.entrySet()) {
        	  String key2 = entry2.getKey();
        	  for (String value2 : entry2.getValue()) {
        		  //System.out.println(key2+value2);
        		  writer2.write(key2 + " " + value2);
                  writer2.newLine();
        	  }
        }
        	}
        catch (IOException e) {
            System.err.println(e);
        } finally {
            if (writer2 != null) {
                try {
                    writer2.close();
                    
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
        }
        else{
        	System.out.println("Sorry, You have reached your borrow limit!!");
        }
        
	}
	
	public void returnJournals(String BorrowerName) throws IOException{
		
		Scanner sc = new Scanner(new FileReader("Journals.txt"));
		Scanner scn = new Scanner(new FileReader("Journalborrower.txt"));
		

        HashMap<String, String> Journals = new HashMap<String, String>();
        Map<String, List<String>> Journalborrower = new HashMap<String, List<String>>();
        ArrayList<String> JName = new ArrayList<String>();
        
        //BookBorrower.clear();
        
        while (sc.hasNextLine()) {
            String[] columns1 = sc.nextLine().split(" ");
            Journals.put(columns1[0], columns1[1]);
        }
        
        while (scn.hasNextLine()) {
            String[] columns2 = scn.nextLine().split(" ");
            JName.add(columns2[1]);
            Journalborrower.put(columns2[0],JName);
        }

        System.out.println(Journals);
        System.out.println(Journalborrower);
        System.out.println("Enter the Name Of the Journal you want to Return:");
        Scanner input=new Scanner(System.in);
        String JournalName=input.nextLine();
        
        List<String> Keys=Journalborrower.get(BorrowerName);
        System.out.println(Keys);
        int Count;
        Count = 0;
        loops:
        	for (int i=0;i < Keys.size();i++){
          
        	//System.out.println(k);
        	
        	if(JournalName.equals(Keys.get(i)))
        	{ 
        		Count++;
        		
        	Journals.replace(JournalName, Journals.get(JournalName), String.valueOf(Integer.parseInt(Journals.get(JournalName))+1));
              			JName.remove(JournalName);
              			Journalborrower.put(BorrowerName,JName);
              			//System.out.println(BookBorrower);
              			//System.out.println(Books);
              			System.out.println("Transaction successfull");
        		        			
        	}
        	
        	}
        if(Count==0){
    		System.out.println("The Journal Name you have entered is not valid or borrowed by you, Please enter a valid Book Name");
        }
        
        //BookBorrower.clear();
        
    
        
        
        //System.out.println("Transaction Denied");
        	
        	
          
        //System.out.println(Books);
        
        FileWriter fw1 = new FileWriter("Journals.txt");
        PrintWriter pw1 = new PrintWriter(fw1);
        pw1.write("");
        pw1.flush(); 
        pw1.close();
        
        /*FileWriter fw2 = new FileWriter("BookBorrower.txt");
        PrintWriter pw2 = new PrintWriter(fw2);
        pw2.write("");
        pw2.flush(); 
        pw2.close();*/
        
        BufferedWriter writer1 = null;
        
        
        try {
            writer1 = new BufferedWriter(new FileWriter("Journals.txt"));
                       
               
        Iterator entries = Journals.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            //System.out.println("Key = " + key + ", Value = " + value);
            
          writer1.write(key + " " + value);
          writer1.newLine();
          
                    
        }
        }
        catch (IOException e) {
                System.err.println(e);
            } finally {
                if (writer1 != null) {
                    try {
                        writer1.close();
                        
                    } catch (IOException e) {
                        System.err.println(e);
                    }
                }
            }
        
        BufferedWriter writer2 = null;
        writer2 = new BufferedWriter(new FileWriter("Journalborrower.txt"));
        
        try {
        
        for(Map.Entry<String, List<String>> entry2 : Journalborrower.entrySet()) {
        	  String key2 = entry2.getKey();
        	  for (String value2 : entry2.getValue()) {
        		  //System.out.println(key2+value2);
        		  writer2.write(key2 + " " + value2);
                  writer2.newLine();
        	  }
        }
        	}
        catch (IOException e) {
            System.err.println(e);
        } finally {
            if (writer2 != null) {                
            	try {
                    writer2.close();
                    
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
        
	}
		
		
	
	public void checkJournalsAvailability(String JournalName) throws FileNotFoundException{
		
	
		Scanner sc = new Scanner(new FileReader("Journals.txt"));
	
		

        HashMap<String, String> Journals = new HashMap<String, String>();
      
        
        //BookBorrower.clear();
        
        while (sc.hasNextLine()) {
            String[] columns1 = sc.nextLine().split(" ");
            Journals.put(columns1[0], columns1[1]);
        }
        
       
        //System.out.println(Books);
        
        String Copies=Journals.get(JournalName);
        
        Set<String> Keys=Journals.keySet();
        int Count;
        Count = 0;
        
        for(String k: Keys){
          
        	//System.out.println(k);
        	//Checking if the Book exists
        if(JournalName.equals(k))
        		
        { Count++;
        
        if(Integer.parseInt(Copies) < 1){
        	System.out.println("The Journal is not availble");
               }
        else{
        	System.out.println("The Journal is available");
        }
        
        }
        }
        if(Count==0){
        	System.out.println("Please enter a valid Journal Name");
        }
        
        
        //System.out.println(Copies);
        
        
        
        
        
        }
		
		

}
