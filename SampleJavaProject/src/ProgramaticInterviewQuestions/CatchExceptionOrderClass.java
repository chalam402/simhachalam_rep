package ProgramaticInterviewQuestions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchExceptionOrderClass {
	public static void main(String[] args) {
		/*try{
			  //do something
			}catch(FileNotFoundException npe){

			}catch(IOException nfe){

			}catch(Exception exp){

			}*/
		
		    FileInputStream fis = null;
		    try
		    {
		      fis = new FileInputStream("abc.txt");
		    }
		    catch(FileNotFoundException e)
		    {
		      System.out.println("The source file does not exist. " + e);
		    }          
		     
		    int k;
		    try
		    {
		      while(( k = fis.read() ) != -1)
		      {
		        System.out.print((char)k);
		      }
		      fis.close();
		    }
		    catch(IOException e)
		    {
		      System.out.println("Some IO problem. " + e);
		    }          
	}
}
/*
     public FileInputStream(String) throws FileNotFoundException;          // a constructor
     public URL(String) throws MalformedURLException;                      // a constructor
     
     public native int read() throws java.io.IOException;
     public void close() throws java.io.IOException;
     
     Following is the hierarchy.
     Object –> Throwable –> Exception –> IOException –> FileNotFoundException
     
     import java.io.*;
	public class Demo
	{
	  public static void main(String args[])
	  {
	    FileInputStream fis = null;
	    try
	    {
	      fis = new FileInputStream("abc.txt");
	    }
	    catch(FileNotFoundException e)
	    {
	      System.out.println("The source file does not exist. " + e);
	    }          
	     
	    int k;
	    try
	    {
	      while(( k = fis.read() ) != -1)
	      {
	        System.out.print((char)k);
	      }
	      fis.close();
	    }
	    catch(IOException e)
	    {
	      System.out.println("Some IO problem. " + e);
	    }          
	  }
	}
	
Why the FileInputStream constructor throws FileNotFoundException?
Ans) fis = new FileInputStream("abc.txt"); //JVM based checking
	The job of FileInputStream constructor is to open the file abc.txt in read mode. The programmer opens the file and goes on writing some file manipulation code. Writing such code is waste when the file does not exist at all. The wise job is first check whether the file exist or not and then proceed on writing the code. This warning is notified by the Java through FileNotFoundException. As this is a checked exception, it must be handled by the programmer else program does not compile; here it is handled with try-catch block.

Why the read() and close() methods throw IOException? //OS based checking
Ans) We know the file operations like read, write and close() etc. are OS dependent and are declared as native methods. In the communication, the OS may not read properly or write properly and also close properly. Even though these failures are very rare, the designers of Java did not take a chance (to make Java a robust language) and informs the programmer through IOException. As this is a checked exception, it must be handled by the programmer else program does not compile; here it is handled with try-catch block. IOException is a general exception which indicates some input output exception and is thrown by many methods of stream classes.

 */
