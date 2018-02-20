package com.company;

/**
 * Created by Shane on 2/20/2018.
 */
public class OverflowException extends RuntimeException
{
    public OverflowException()
    {
        super();
    }

    public OverflowException(String message)
    {
        super(message);
    }
}