package com.company;

/**
 * Created by Shane on 2/20/2018.
 */
public class InvalidYearFormatException extends RuntimeException
{
    public InvalidYearFormatException()
    {
        super();
    }

    public InvalidYearFormatException(String message)
    {
        super(message);
    }
}
