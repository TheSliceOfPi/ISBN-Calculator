/**
 * ISBN.java
 * ISBN determines the last digit of a 10 or 13 digit long ISBN code.
 * Input: 9 or 12 digit ISBN
 * Returns: 10th or 13th ISBN digit, respectively
 * Part of Homework 1, Part 2 and 3.
 */



import java.util.Scanner;

/**
 * Contains the main function for the program
 */


public class ISBN
{
    public static void main(String[] args)
    { 
	Scanner scan=new Scanner(System.in);
	Boolean invalid = true;
	while (invalid) //Determines which ISBN to calculate and whether the input is valid.
	    {
	     System.out.println("First 9-digits or 12-digits of ISBN number: ");
	     long isbn=scan.nextLong();
	     long isbnleng=String.valueOf(isbn).length();
	     if (isbnleng==9)
		 {
		     int intisbn=(int)isbn;
		     invalid=false;
		     System.out.println("10th digit: "+isbn10(intisbn));
			   	 
		 }


	     else if (isbnleng==12)
		 {
		    invalid=false;
		    System.out.println("13th digit: "+isbn13(isbn));
		    
		 }

	     else
		 {
		     System.out.println("ISBN has to be 9 or 12 digits. You entered "+ isbnleng +" digits");
		 }
	    }

    }
    /**
     *
     *Function to calculate the 10th ISBN digit.
     *
     *@param n int, the 9-digit ISBN.
     *
     *@returns 10th digit of ISBN
     *
     */

    public static String isbn10(int n) 
    {
		int x10=0;
		for (int i=9;i>0;i--) //Determines all 9 separate digits
	    {
	        x10=x10+(i*(n%10));
		n=n/10;
		    
		}
	     
		x10=x10%11; //Calculates 10th digit

	if (x10==10)
	    {
		return "X"; //Returns X if calculation is 10
	    }
	    else
	    {
		return (String.valueOf(x10)); //Returns the 10th digit otherwise
		}
	 
    } 
     /**
     *
     *Function to calculate the 13th ISBN digit.
     *
     *@param n int, the 12-digit ISBN.
     *
     *@returns 13th digit of ISBN
     *
     */
    public static String isbn13(long n) 
    {
	long x13=0;
        for (int i=1;i<13;i++) //Determines all 12 separate digits
	    {
		if (i%2==0)
		    {
			x13=x13+(n%10);
			n=n/10	;    
		    }
		else
		    {
			x13=x13+(3*(n%10));
			n=n/10;
		    }
	    }
        

	x13=10-(x13%10); //Calculates 13th digit

	if (x13==10)
	    {
		return "0"; //Returns 0 if calculation is 10
	    }
	else
	    {
		return (String.valueOf(x13)); //Returns the 13th digit otherwise.
	    }
    

    }
}
