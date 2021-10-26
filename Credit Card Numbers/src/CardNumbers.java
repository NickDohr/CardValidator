import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class CardNumbers
	{
		static long creditCardNumber;
		static Long [] cardDigits = new Long[16];
		static long totalNumber;
		static int validCounter;
		static int invalidCounter;
		
		public static void main(String[] args) throws IOException
			{
				Scanner myFile = new Scanner(new File("cardList.txt"));
				while(myFile.hasNext()) {
					  

					creditCardNumber = myFile.nextLong();
					
					  checkValid();
				   }
				//actual printout 
				System.out.println();
				System.out.println("There was " + validCounter + " valid numbers, and " + invalidCounter + " invalid numbers in the list.");
				
			}
		
		public static void checkValid()
		{
			long printCC = creditCardNumber;
			totalNumber = 0;
			
			for(int c = 15; c >= 0; c--)
				{
					//adding card number into digits
					cardDigits[c] = creditCardNumber % 10;
					
					creditCardNumber /= 10;
					
				}
			
	//digit stripping and multiplying by two
			for(int a = 0; a < 16; a = a+2)
				{
					
					cardDigits[a] = cardDigits[a]*2;
					if(cardDigits[a] >= 10)
						{
							
							long digit1 = cardDigits[a] % 10;
							long digit2 = cardDigits[a]/10;
							cardDigits[a] = digit1 + digit2;
							
						}
					
				}
			//adding arary numbers up 
			for(int b = 0; b < cardDigits.length; b++)
				{
					totalNumber+=cardDigits[b];
				}
			//checking for actual valid number
		if(totalNumber % 10 == 0)
			{
				
				System.out.println(printCC + " is valid");
				validCounter++;
			}
		else
			{
				
				System.out.println(printCC + " is not valid");
				invalidCounter++;
			}
				
			
			
			
		}
	}
