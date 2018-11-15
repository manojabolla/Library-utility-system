
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

//import com.google.common.collect.ArrayListMultimap;
//import com.google.common.collect.Multimap;


public class Books {

	public void borrowBooks(String BorrowerName)throws IOException {
		
		Scanner sc = new Scanner(new FileReader("Books.txt"));
		Scanner scn = new Scanner(new FileReader("BookBorrower.txt"));
		

        HashMap<String, String> Books = new HashMap<String, String>();
        Map<String, List<String>> BookBorrower = new HashMap<String, List<String>>();
        ArrayList<String> BName = new ArrayList<String>();
        
        //BookBorrower.clear();
        
        while (sc.hasNextLine()) {
            String[] columns1 = sc.nextLine().split(" ");
            Books.put(columns1[0], columns1[1]);
        }
        
        while (scn.hasNextLine()) {
            String[] columns2 = scn.nextLine().split(" ");
            BName.add(columns2[1]);
            BookBorrower.put(columns2[0],BName);
        }

        System.out.println(Books);
        System.out.println(BookBorrower);
        
        List<String> BooksAvailed = BookBorrower.get(BorrowerName);
        int BookNos = BooksAvailed.size();
        System.out.println(BooksAvailed+"\n " +BookNos);
        
        //Checking Maximum number of Books issued to the Borrower
        if(BookNos < 5){
        System.out.println("Enter the Name Of the Book you want to borrow:");
        Scanner input=new Scanner(System.in);
        String BookName=input.nextLine();
        
        Set<String> Keys=Books.keySet();
        int Count;
        Count = 0;
        loops:
        for(String k: Keys){
          
        	//System.out.println(k);
        	//Checking if the Book exists
        	if(BookName.equals(k))
        	{ Count++;
        	
        		//Checking if a copy of the Book is available
        		if(Integer.parseInt(Books.get(BookName))!=0)
        		{
              			Books.replace(BookName, Books.get(BookName), String.valueOf(Integer.parseInt(Books.get(BookName))-1));
              			BName.add(BookName);
              			BookBorrower.put(BorrowerName,BName);
              			//System.out.println(BookBorrower);
              			//System.out.println(Books);
              			System.out.println("Transaction successfull");
        		}else{
        		System.out.println("The Book you selected is not available currently");
        		break loops;
        		}
        			
        	}
        	
        	}
        if(Count==0){
    		System.out.println("Enter a valid Book Name");
        }
        
        //BookBorrower.clear();
        
    
        
        
        //System.out.println("Transaction Denied");
        	
        	
          
        //System.out.println(Books);
        
        FileWriter fw1 = new FileWriter("Books.txt");
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
            writer1 = new BufferedWriter(new FileWriter("Books.txt"));
                       
               
        Iterator entries = Books.entrySet().iterator();
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
        writer2 = new BufferedWriter(new FileWriter("BookBorrower.txt"));
        
        try {
        
        for(Map.Entry<String, List<String>> entry2 : BookBorrower.entrySet()) {
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
	
	public void returnBook(String BorrowerName) throws IOException{
		
		Scanner sc = new Scanner(new FileReader("Books.txt"));
		Scanner scn = new Scanner(new FileReader("BookBorrower.txt"));
		

        HashMap<String, String> Books = new HashMap<String, String>();
        Map<String, List<String>> BookBorrower = new HashMap<String, List<String>>();
        ArrayList<String> BName = new ArrayList<String>();
        
        //BookBorrower.clear();
        
        while (sc.hasNextLine()) {
            String[] columns1 = sc.nextLine().split(" ");
            Books.put(columns1[0], columns1[1]);
        }
        
        while (scn.hasNextLine()) {
            String[] columns2 = scn.nextLine().split(" ");
            BName.add(columns2[1]);
            BookBorrower.put(columns2[0],BName);
        }

        System.out.println(Books);
        System.out.println(BookBorrower);
        System.out.println("Enter the Name Of the Book you want to Return:");
        Scanner input=new Scanner(System.in);
        String BookName=input.nextLine();
        
        List<String> Keys=BookBorrower.get(BorrowerName);
        System.out.println(Keys);
        int Count;
        Count = 0;
        loops:
        	for (int i=0;i < Keys.size();i++){
          
        	//System.out.println(k);
        	
        	if(BookName.equals(Keys.get(i)))
        	{ Count++;
        		
              			Books.replace(BookName, Books.get(BookName), String.valueOf(Integer.parseInt(Books.get(BookName))+1));
              			BName.remove(BookName);
              			BookBorrower.put(BorrowerName,BName);
              			//System.out.println(BookBorrower);
              			//System.out.println(Books);
              			System.out.println("Transaction successfull");
        		        			
        	}
        	
        	}
        if(Count==0){
    		System.out.println("The BookName you have entered is not valid or borrowed by you!! Please enter a valid Book Name");
        }
        
        //BookBorrower.clear();
        
    
        
        
        //System.out.println("Transaction Denied");
        	
        	
          
        //System.out.println(Books);
        
        FileWriter fw1 = new FileWriter("Books.txt");
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
            writer1 = new BufferedWriter(new FileWriter("Books.txt"));
                       
               
        Iterator entries = Books.entrySet().iterator();
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
        writer2 = new BufferedWriter(new FileWriter("BookBorrower.txt"));
        
        try {
        
        for(Map.Entry<String, List<String>> entry2 : BookBorrower.entrySet()) {
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
		
		
	
	public void checkBooksAvailability(String bookName) throws FileNotFoundException{
		
	
		Scanner sc = new Scanner(new FileReader("Books.txt"));
	
		

        HashMap<String, String> Books = new HashMap<String, String>();
      
        
        //BookBorrower.clear();
        
        while (sc.hasNextLine()) {
            String[] columns1 = sc.nextLine().split(" ");
            Books.put(columns1[0], columns1[1]);
        }
        
       
        //System.out.println(Books);
        
        String Copies=Books.get(bookName);
        
        Set<String> Keys=Books.keySet();
        int Count;
        Count = 0;
        
        for(String k: Keys){
          
        	//System.out.println(k);
        	//Checking if the Book exists
        if(bookName.equals(k))
        		
        { Count++;
        
        if(Integer.parseInt(Copies) < 1){
        	System.out.println("The Book is not availble");
               }
        else{
        	System.out.println("The Book is available");
        }
        
        }
        }
        if(Count==0){
        	System.out.println("Please enter a valid Book Name");
        }
        
        
        //System.out.println(Copies);
        
        
        
        
        
        }
		
		
	}

