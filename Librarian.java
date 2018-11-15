import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Librarian {

	public void updateCatalog(String memberID) throws IOException {
		
	System.out.println("1.Update User Details\n2.Update Book Details\n3.Update Journal details\n\nPlease enter your choice:");
	Scanner sc = new Scanner(System.in);
	String Choice= sc.nextLine();
	
	switch(Integer.parseInt(Choice)){
	
	case 1:
		
		System.out.println("1.Add User\n2.Delete User\n3.Edit User\n\nEnter your choice:");
		Scanner scn = new Scanner(System.in);
		
		String Ch= scn.nextLine();
		
		
			Scanner scan = new Scanner(new FileReader("UserData.txt"));
			
			HashMap<String, String> UserDetails = new HashMap<String, String>();
	      
	        
	        while (scan.hasNextLine()) {
	            String[] columns1 = scan.nextLine().split(" ");
	            UserDetails.put(columns1[0], columns1[1]);
	        }
	        
	        if(Integer.parseInt(Ch) == 1)
	        {	
	        System.out.println("Enter the UserName:");
	        Scanner sc1 = new Scanner(System.in);
	        String UserName=sc1.nextLine();
	        System.out.println("Enter the Membership Type:");
	        Scanner sc2 = new Scanner(System.in);
	        String MemType=sc2.nextLine();
	        
	        UserDetails.put(UserName, MemType);
	        
	        }else if(Integer.parseInt(Ch) == 2){
	        	
	        	System.out.println("Enter the UserName:");
		        Scanner sc1 = new Scanner(System.in);
		        String UserName=sc1.nextLine();
		        
		        
		        UserDetails.remove(UserName);
	        	
	        }else if(Integer.parseInt(Ch) == 3){
	        	
	        	System.out.println("Enter the UserName:");
		        Scanner sc1 = new Scanner(System.in);
		        String UserName=sc1.nextLine();
		        System.out.println("Enter the New Membership Type:");
		        Scanner sc2 = new Scanner(System.in);
		        String MemType=sc2.nextLine();
		        
		        UserDetails.replace(UserName, MemType);
	        }else{
	        	System.out.println("Invalid choice");
	        }
	        
	        	
	        FileWriter fw1 = new FileWriter("UserData.txt");
	        PrintWriter pw1 = new PrintWriter(fw1);
	        pw1.write("");
	        pw1.flush(); 
	        pw1.close();
	        
	        BufferedWriter writer1 = null;
	        
	        
	        try {
	            writer1 = new BufferedWriter(new FileWriter("UserData.txt"));
	                       
	               
	        Iterator entries = UserDetails.entrySet().iterator();
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
		break;
		
	case 2:
		
		
		System.out.println("1.Add book\n2.Delete book\n3.update no.of copies\n\nEnter your choice:");
		Scanner scn2 = new Scanner(System.in);
		
		String Chc= scn2.nextLine();
		
		
			Scanner scan2 = new Scanner(new FileReader("Books.txt"));
			
			HashMap<String, String> bookDetails = new HashMap<String, String>();
	      
	        
	        while (scan2.hasNextLine()) {
	            String[] columns1 = scan2.nextLine().split(" ");
	            bookDetails.put(columns1[0], columns1[1]);
	        }
	        
	        if(Integer.parseInt(Chc) == 1)
	        {	
	        System.out.println("Enter the bookName:");
	        Scanner sc1 = new Scanner(System.in);
	        String bookName=sc1.nextLine();
	        System.out.println("Enter the no.of copies:");
	        Scanner sc2 = new Scanner(System.in);
	        String numbofcopies=sc2.nextLine();
	        
	        bookDetails.put(bookName, numbofcopies);
	        
	        }else if(Integer.parseInt(Chc) == 2){
	        	
	        	System.out.println("Enter the bookName:");
		        Scanner sc1 = new Scanner(System.in);
		        String bookName=sc1.nextLine();
		        
		        bookDetails.remove(bookName);
	        	
	        }else if(Integer.parseInt(Chc) == 3){
	        	
	        	System.out.println("Enter the bookName:");
		        Scanner sc1 = new Scanner(System.in);
		        String bookName=sc1.nextLine();
		        System.out.println("Enter the no.of copies :");
		        Scanner sc2 = new Scanner(System.in);
		        String numbofcopies=sc2.nextLine();
		        
		        bookDetails.replace(bookName,numbofcopies );
	        }else{
	        	System.out.println("Invalid choice");
	        }
	        
	        	
	        FileWriter fw2 = new FileWriter("Books.txt");
	        PrintWriter pw2 = new PrintWriter(fw2);
	        pw2.write("");
	        pw2.flush(); 
	        pw2.close();
	        
	        BufferedWriter writer2 = null;
	        
	        
	        try {
	            writer2 = new BufferedWriter(new FileWriter("Books.txt"));
	                       
	               
	        Iterator entries = bookDetails.entrySet().iterator();
	        while (entries.hasNext()) {
	            Map.Entry entry = (Map.Entry) entries.next();
	            String key = (String)entry.getKey();
	            String value = (String)entry.getValue();
	            //System.out.println("Key = " + key + ", Value = " + value);
	            
	          writer2.write(key + " " + value);
	          writer2.newLine();
	          
	                    
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
		
		break;
		
	case 3:

		System.out.println("1.Add journal\n2.Delete journal\n3.update no.of copies\n\nEnter your choice:");
		Scanner scn3 = new Scanner(System.in);
		
		String Cho= scn3.nextLine();
		
		
			Scanner scan3 = new Scanner(new FileReader("Journals.txt"));
			
			HashMap<String, String> journalDetails = new HashMap<String, String>();
	      
	        
	        while (scan3.hasNextLine()) {
	            String[] columns1 = scan3.nextLine().split(" ");
	            journalDetails.put(columns1[0], columns1[1]);
	        }
	        
	        if(Integer.parseInt(Cho) == 1)
	        {	
	        System.out.println("Enter the journalName:");
	        Scanner sc1 = new Scanner(System.in);
	        String journalName=sc1.nextLine();
	        System.out.println("Enter the no.of copies:");
	        Scanner sc2 = new Scanner(System.in);
	        String numbofcopies=sc2.nextLine();
	        
	        journalDetails.put(journalName, numbofcopies);
	        
	        }else if(Integer.parseInt(Cho) == 2){
	        	
	        	System.out.println("Enter the journalName:");
		        Scanner sc1 = new Scanner(System.in);
		        String journalName=sc1.nextLine();
		        
		        journalDetails.remove(journalName);
	        	
	        }else if(Integer.parseInt(Cho) == 3){
	        	
	        	System.out.println("Enter the journalName:");
		        Scanner sc1 = new Scanner(System.in);
		        String journalName=sc1.nextLine();
		        System.out.println("Enter the no.of copies :");
		        Scanner sc2 = new Scanner(System.in);
		        String numbofcopies=sc2.nextLine();
		        
		        journalDetails.replace(journalName,numbofcopies );
	        }else{
	        	System.out.println("Invalid choice");
	        }
	        
	        	
	        FileWriter fw3 = new FileWriter("Journals.txt");
	        PrintWriter pw3 = new PrintWriter(fw3);
	        pw3.write("");
	        pw3.flush(); 
	        pw3.close();
	        
	        BufferedWriter writer3 = null;
	        
	        
	        try {
	            writer3 = new BufferedWriter(new FileWriter("Journals.txt"));
	                       
	               
	        Iterator entries = journalDetails.entrySet().iterator();
	        while (entries.hasNext()) {
	            Map.Entry entry = (Map.Entry) entries.next();
	            String key = (String)entry.getKey();
	            String value = (String)entry.getValue();
	            //System.out.println("Key = " + key + ", Value = " + value);
	            
	          writer3.write(key + " " + value);
	          writer3.newLine();
	          
	                    
	        }
	        }
	        catch (IOException e) {
	                System.err.println(e);
	            } finally {
	                if (writer3 != null) {
	                    try {
	                        writer3.close();
	                        
	                    } catch (IOException e) {
	                        System.err.println(e);
	                    }
	                }
	            
	       
	        
	        
	        
		}
		
		break;
		
	}
	}
	

	}

