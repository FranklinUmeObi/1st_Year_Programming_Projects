import java.io.*;
import java.util.Scanner;
public class ReadAndWrite 
{

	public static void main(String[] args) throws Exception
	{
		// BufferedOutputputStream: write bytes

		// We are writing the textual information in the
		// BufferedOutputStream object which is connected
		// to the FileOutputStream object
		FileOutputStream fout = new FileOutputStream("out.txt");    
		BufferedOutputStream bout = new BufferedOutputStream(fout);

		String s = "Welcome to Java";    
		byte b[] = s.getBytes();

		bout.write(b);    
		bout.flush();    
		bout.close();    
		fout.close();

		System.out.println("success");    

		//--------------------------------------------------------------------------------------------		
		//FileWriter \Example
		// Unlike FileOutputStream class, you do not need
		// to convert a string into a byte array
		try
		{    
			FileWriter fw = new FileWriter("out.txt");    
			fw.write("Welcome to Java");    
			fw.close();    
		}catch(Exception e){System.out.println(e);}

		System.out.println("Success...");    

		//--------------------------------------------------------------------------------------------
		//Buffered Reader Example
		FileReader fr = new FileReader("out.txt");    
		BufferedReader br = new BufferedReader(fr);    

		int i;    
		while((i=br.read())!=-1)
		{  
			System.out.print((char)i);  
		}

		br.close();    
		fr.close();    
		//--------------------------------------------------------------------------------------------
	}       

	// Write example
	public static void toDocument(FileWriter writer) throws Exception
	{

		BufferedWriter buffer = new BufferedWriter(writer);  	
		InputStreamReader r = new InputStreamReader(System.in);    
		BufferedReader br = new BufferedReader(r);   

		Scanner input = new Scanner(System.in);
		System.out.print("Enter next word: ");

		String word;
		while ((word = br.readLine()) != null && !(word.equals("done")))
		{ 
			buffer.write(word);
			buffer.write(" ");
			System.out.print("Enter next word: ");
		}
		buffer.close();

		// this next part should be in main
		//public static void main(String[] args) throws Exception
		//  {
		//FileWriter writer = new FileWriter(args[0]);  
		//   void toDocument(writer);
		//  }
	}


	//DirList example
	public static void ls(String dir) throws Exception
	{
		File f = new File(dir);  
		String filenames[] = f.list();  

		for(String filename:filenames)
		{  
			System.out.println(filename);  
		} 
		//this next part should be in main
		//public static void main(String[] args) throws Exception
		//{  
		//System.out.print("Enter name of directory: ");
		//Scanner input = new Scanner(System.in);
		//String dirName = input.next();
		//ls(dirName);
		// }  
	}

}
