import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBookStore 
{
	public static int ISBN_INDEX = 0;
	public static int TITLE_INDEX = 1;
	public static int AUTHOR_INDEX = 2;
	public static int PUBLISHER_INDEX = 3;
	public static int PUBLISHER_YEAR_INDEX = 4;
	public static int QUANTITY_INDEX = 5;
	public static int PRICE_INDEX = 6;
	
	public static void main(String[] args) 
	{
		ArrayList<Book> bookList = new ArrayList<Book>();
		try {
			FileReader fileReader = new FileReader("C:\\eclipse-workspace\\ETest3Revision\\src\\books.txt");// Enter the entire path of the file if needed
			BufferedReader bufferedReader = new BufferedReader(fileReader);  
			boolean endOfFile = false;
	        while(!endOfFile)
	        {
	        	String bookLine = bufferedReader.readLine();
	        	if (bookLine != null) 
	        	{
	        		String[] bookData = bookLine.split(", ");
	        		String isbn = bookData[ISBN_INDEX];
	        		String title = bookData[TITLE_INDEX];
	        		String author = bookData[AUTHOR_INDEX];
	        		String publisher = bookData[PUBLISHER_INDEX];
	        		int publishYear = Integer.parseInt (bookData[PUBLISHER_YEAR_INDEX]);
	        		int quantity = Integer.parseInt (bookData[QUANTITY_INDEX]);
	        		double price = Double.parseDouble (bookData[PRICE_INDEX]);
	        		Book book = new Book(isbn, title, author, publisher, publishYear, quantity, price);
	        		bookList.add(book);

	        	} 
	        	else 
	        	{
	        		endOfFile = true;
	        	}
	        }
	        
	        bufferedReader.close();    
	        fileReader.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		printBookDetails(bookList);
		purchaseBook(bookList);
	}

	public static void printBookDetails(ArrayList<Book> bookList)
	{
		for(int i = 0 ; i < bookList.size() ; i++)
		{
			System.out.println(bookList.get(i).toString()); 
		}
		
	}
	public static Book getBook (ArrayList<Book> bookList, String title)
	{
		int rightIndex = 0 ;
		for(int i = 0 ; i < bookList.size() ; i++)
		{
			if(bookList.get(i).getTitle() == title) rightIndex = i ;
		}
		return bookList.get(rightIndex) ;
	}
	public static void topUpCard(ChargeCard card, double amount)
	{
		card.topUpFunds(amount);
	}
	public static void purchaseBook(ArrayList<Book> bookList)
	{
		
		
		boolean finished = false;
		ChargeCard creditCard = new ChargeCard() ;
		Scanner scan = new Scanner(System.in) ; 
		System.out.println("\nHow much is in your wallet, good sir? :");
		Double funds = scan.nextDouble() ;
		if (funds <= 0)
		{
			System.out.println("You are broke my good sir");
			finished = true ;
		}
		if(!finished)
		{
			String response = "" ;
			String junk = scan.nextLine();
			topUpCard(creditCard, funds) ;
			do
			{
				System.out.println("What is the title of the book you are looking to purchase my good sir? :");
				String bookWanted = scan.nextLine();
				Book theBook = getBook(bookList, bookWanted) ;
				if(theBook.getQuantity() >= 1 && theBook.getPrice() < creditCard.getFunds())
				{
					creditCard.removeFunds(theBook.getPrice()) ;
					theBook.setQuantity(theBook.getQuantity() - 1) ;
					System.out.println("Would you like to buy another book my good sir? If not please enter quit.");
					response = scan.nextLine();
					if(response == "quit") finished = true ;
				}
				else System.out.println("There is a problem with this transaction");
				
			}while(!finished) ;
			
		}
		System.out.println("GoodBye");
		
		
		
	}
	
	
	
	
	
	
	
}