package com.company;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //establish Scanner to receive input from user
        ArrayList<String> allPalindromes; //declare ArrayList to hold all dates that are palindromes
        int year; //declare int that will hold the year give by the user

        System.out.println("Enter a valid year in the form YYYY to see all dates in that year that are palindromes."); //prompt user for year

        //the input is accepted if an integer is given, otherwise an exception is thrown
        try {
            year = input.nextInt();
        }
        catch (InputMismatchException e) {
            throw new InputMismatchException("You did not enter an integer.");
        }

        //an exception is thrown if the year given is greater than 4 digits or negative
        if(year > 9999 || year < 0) {
            throw new InvalidYearFormatException("You entered an invalid date.");
        }

        allPalindromes = PalindromeCalculation.findPalindromes(year); //calling method to find palindrome dates for the given year; all dates are stored in this ArrayList

        //if any palindrome dates were found, then print them out, otherwise say that there were no palindrome dates
        if(allPalindromes.size() > 0) {
            System.out.println("\nThe following are dates that are palindromes for the year " + year + ":");
            for (int i = 0; i < allPalindromes.size(); i++)
                System.out.println(allPalindromes.get(i));
        }
        else
            System.out.println("\nThere are no dates that are palindromes for the year " + year + ".");
    }
}