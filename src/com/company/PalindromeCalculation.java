package com.company;

import java.util.ArrayList;

/**
 * Created by Shane on 2/20/2018.
 */
public class PalindromeCalculation {
    private static int year; //int that holds year given by user
    private static int lastDayOfMonth; //int that holds last day of month
    private static int[] yearDigits; //int array that will hold the year's digits in each element
    private static String completeDate = ""; //String that will hold the individual complete dates in MMDDYYYY form
    private static ArrayList<String> palindromeDates; //ArrayList that will hold all of the palindrome dates
    private static ArrayBoundedDate date = new ArrayBoundedDate(); //Queue that will be used to determine if a date is palindromic

    public static ArrayList<String> findPalindromes(int y) {
        //finds palindrome dates for the given year
        year = y; //holds year given by user
        palindromeDates = new ArrayList<>(); //instantiates ArrayList that will hold the palindrome dates
        yearDigits = new int[4]; //instantiates the int array that will hold the year's digits in each element

        //determines each digit in the year
        for(int i = 3; i >= 0; i--) {
            yearDigits[i] = year % 10;
            year /= 10;
        }

        //loops through every individual month, from January (1) to December (12) and adds it to the queue
        for(int i = 1; i < 13; i++) {
            //determining what the last day of the month is based on the month
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
                lastDayOfMonth = 31;
            else if(i != 2)
                lastDayOfMonth = 30;
            else
                //In February, a day is added every 4 years, so we must account for leap year
                if(year % 4 == 0)
                    lastDayOfMonth = 29;
                else
                    lastDayOfMonth = 28;

            //loops through every individual day in the month and adds it to the queue
            for(int j = 1; j < lastDayOfMonth + 1; j++) {
                if(i < 10)
                    date.enqueue(0);
                else
                    date.enqueue(1);
                date.enqueue(i % 10);
                if(j < 10)
                    date.enqueue(0);
                else if(j >= 10 &&  j < 20)
                    date.enqueue(1);
                else if(j >= 20 &&  j < 30)
                    date.enqueue(2);
                else
                    date.enqueue(3);
                date.enqueue(j % 10);

                //loops through the individual digit's in the year that was given, adds these digits to the queue
                for(int k = 0; k < yearDigits.length; k++)
                    date.enqueue(yearDigits[k]);

                //add the date to the ArrayList that will be returned if the date is a palindrome
                if(date.isPalindrome()) {
                    for(int m = 0; m < 8; m++)
                        completeDate += date.dequeue();
                    palindromeDates.add(completeDate);
                }
                date.clear(); //clear out the queue to get ready for a new date
            }
        }
        return palindromeDates; //return the ArrayList that holds all of the dates that are palindromes
    }
}