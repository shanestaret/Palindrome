package com.company;

/**
 * Created by Shane on 2/20/2018.
 */
public class UnderflowException extends RuntimeException
{
    public UnderflowException()
    {
        super();
    }

    public UnderflowException(String message)
    {
        super(message);
    }
}
