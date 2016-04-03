import java.io.*;  // Imports all of the java I/O(input/output) objects and methods.
	/*Specifically FileInputStream, FileOutputStream, FileReader, FileWriter, and IOException will be needed in this program.
		The first two are for byte stream I/O while the next two are for character stream I/O. The last one is for handling IOExceptions.
	*/
import java.util.Scanner;  // Imports the java Scanner for reading user input from the command line.

	/*This is a program that accepts a text file and operates on the file according to the user input
	copies the text into an output file, "outputText.txt"*/

public class CopyText{
	public static void main(String[] args) throws IOException{
		/*This method must throw an IOException to detect when the user doesn't input the type of
		data the program asks for*/
		
		Scanner sc = new Scanner(System.in);
		/*The try block is explained down below at line 97.*/
		try{
			System.out.print("\n\tHello! This is a text copier!\n\tPlease tell me what is the text file you wish to copy:  ");
			/*Now we read the user input and create a File object based on the input name.*/
			File inputFile = new File(sc.nextLine());
			
			/*Now the program enters an infinite loop to check the user's input file name.
			If the file name is not in the program's directory or is not a text file, then an
			error message prompts the user to try again or quit. Then the continue statement
			restarts the loop. The checks are ordered in what should be the proper priority:
			First check to	see if the user asked to quit. Then check if the file even exists in
			the local directory.  Lastly if it does exist, then it must be checked to ensure it
			is a text file.*/
			while(true){
				
				/* Of course we use the equalsIgnoreCase method in case the user doesn't
				type "quit" in all lowercase like we asked */
				if(inputFile.getName().equalsIgnoreCase("quit") == true){
					System.out.print("\n\n\tSorry if you had any difficulties. Please come again. Good bye!\n");
					return;
				}
				if(inputFile.exists() == false){
					System.out.print("\n\n\tHey! I don't see that file here. Make sure you entered it right and try again (or type \"quit\" to exit):  ");
					inputFile = new File(sc.nextLine());
					continue;
				}
				/*MY ANSWER*/
				else{
					if(inputFile.getName().substring(inputFile.getName().length()-3 , inputFile.getName().length()).equals("txt") == false){
						System.out.print("\n\n\tWait that isn't a text file (.txt). "+
						"I only operate on text files because I'm not that complicated. Can you please enter a text file?(or type \"quit\" to exit)  ");
						inputFile = new File(sc.nextLine());
						continue;
					}
				}
				
				/*At this point we know the input file is correct, so we're ready to exit this infinite loop and move on*/
				break;
			}
			
			// It's a good idea to let the user know what was the file they entered.
			System.out.println("\n\n\tThe input file is: "+inputFile.getName());
			
			/*This is used for the user interface to store whether or not the user has decided to quit.*/
			boolean quit = false;
			
			/*This is the user interface. It will show the user the following options for copying text from an input file
			and then call the appropriate method based on that input. After execution of the selected method, the interface
			loops until the user asks to quit.*/
			while(quit == false){
				System.out.print("\n\tSo here are your options:"+
				"\n\n\t1. Copy the text by bytes"+
				"\n\t2. Copy the text by characters"+
				"\n\t3. Print the text word by word on individual lines"+
				"\n\t4. Quit"+
				"\n\n\tSo what would you like to do? (Enter the number of choice):  ");
				
				/*An int to store the user input*/
				int choice = sc.nextInt();
				
				/*If the user enters any number other than what was given to them, then we go into a small loop
				that asks them to try again until they give an appropriate input*/
				while(choice < 1 || choice > 4){
					System.out.print("\n\n\tThat was not an option! Try again: ");
					choice = sc.nextInt();
				}
				
				/*The switch statement directs the program to the block of code that matches the input number.
				Again, it is good to let the user know that the execution was successful*/
				switch(choice){
					case 1:	byteCopy(inputFile);
									System.out.println("\n\n\tThe copied text has been output to \"outputText.txt\" in this same directory. Check it out.");
									break;
					case 2:	characterCopy(inputFile);
									System.out.println("\n\n\tThe copied text has been output to \"outputText.txt\" in this same directory. Check it out.");
									break;
					case 3:	wordPrint(inputFile);
									break;
					case 4:	quit = true;
									// A break statement is optional here.
				}
			}
			
			/*At this point we know the user asked to quit so it is time to wish them well and end the program.*/
			System.out.println("\n\tThank you for using the text copier. Have a great day!\n");
		}
		/*The whole reason we put the above code in a try block was so that we could
			follow it up with this finally block. This is our safety net for the scanner. No
			matter what happens in the try block above, all the code in the finally block
			is guaranteed to execute normally! I use this to make sure that the no matter
			what happens during the execution of the program, the scanner always gets
			closed at the end. In a small program like this, it isn't a big issue, but in large
			scale applications, this could be the source of a memory leak, so I'm getting in
			the habit of doing this from now. You'll see this repeated in the following methods.*/
		finally{
			if (sc != null)
				sc.close();
		}
		return;
	}

	/*This method reads in the input file via a byte stream and copies the byte code of each character one
	by one and then writes the byte code of each character to the output file.*/
	public static void byteCopy(File inputText) throws IOException{	
		
		/*These byte streams are declared and initialized here so they can be checked against in the finally block below*/
		FileInputStream input = null;
		FileOutputStream output = null;
		
		/*Creating a new byte stream is similar to opening a Scanner in that they need to be closed once they
		are no longer needed. For this reason, the following code is contained in a try block. (See the notes above
		at line 97)*/
		try{
			input = new FileInputStream(inputText);
			output = new FileOutputStream("outputText.txt");
			
			/*An int to hold the byte currently being read and copied*/
			int currentByte;
			
			/*The method input.read() reads the next byte and the assignment operation stores that byte in the container
			"currentByte." The conditional checks to see if that byte had a valid value. If the value was invalid, then it would
			contain a -1 and in that case, the loop should terminate.*/
			while((currentByte = input.read()) != -1){
				/*The method output.write() writes the current byte (stored in "currentByte") into the output file*/
				output.write(currentByte);
			}
		}
		finally{
			if(input != null)
				input.close();
			if(output != null)
				output.close();
		}
	}
	
	/*This method reads in the input file via a character stream and copies each character one by one and
	then writes those characters to the output file.*/
	public static void characterCopy(File inputText) throws IOException{	
		/*The following code is nearly identical to the code in the above method. The only difference is in
		the specific syntax required for reading and writing via a character stream.*/
		
		FileReader input = null;
		FileWriter output = null;
		
		try{
			input = new FileReader(inputText);
			output = new FileWriter("outputText.txt");
			int currentCharacter;
			
			while((currentCharacter = input.read()) != -1){
				output.write(currentCharacter);
			}
		}
		finally{
			if(input != null)
				input.close();
			if(output != null)
				output.close();
		}
	}
	
	/*This method reads in the input file via a Scanner and prints each word on an individual line*/
	public static void wordPrint(File inputText) throws IOException{
		/*The following code is nearly identical to the code in the above method. The only difference is in
		the specific syntax required for reading via a Scanner.*/
		
		Scanner sc1 = null;
		
		try{
			sc1 = new Scanner(new BufferedReader(new FileReader(inputText)));
			
			while(sc1.hasNext()){
				System.out.println(sc1.next());
			}
		}
		finally{
			if(sc1 != null)
				sc1.close();
		}
	}
}