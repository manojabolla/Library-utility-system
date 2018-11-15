import java.io.IOException;
import java.util.Scanner;

public class Home {

	private static Scanner input;
	

	public static void main(String[] args) throws IOException{
		
				
		String MemberType=new String();
		
		System.out.println("Please choose your Membership Type");
		System.out.println("1. Librarian: LB\n2. Staff Member: SM\n3. Library Member: LM");
		input = new Scanner(System.in);
	    System.out.print("Enter the Member Code: ");
	    String Choice = input.next();
	    System.out.println(Choice);
	    
	   
		   switch (Choice){
		   
		   case "LB":
			   MemberType="LIBRARIAN";
			   break;
			   
		   case "SM":
			   MemberType="Staff Member";
			   break;
			   
		   case "LM":
			   MemberType="Library Member";
			   
		   default:
			   break;
		   
		   }
		   
		   System.out.println(MemberType);
		   
		   Librarian lb=new Librarian();
		 // lb.updateCatalog("LM001");
		   
		   Books b=new Books();
		  // b.borrowBooks("LM001");
		  // b.returnBook("LM001");
		   //b.checkBooksAvailability("Book2");
		   
		   Journals j=new Journals();
		   
			//j.borrowJournals("LM001");
		  // j.returnJournals("LM001");
		  j.checkJournalsAvailability("J001");
		   
		   //Librarian lb=new Librarian();
		   //lb.updateCatalog("LB001");
		   
	
	}
}
