package com.company;

import java.util.Arrays;

/**
 * Created by Shane on 2/20/2018.
 */
public class ArrayBoundedDate implements QueueInterface {
    protected Integer[] dateElements; //array holding the queue elements that are individual digits that make up a date
    protected int numOfDateElements; //number of digits in the queue
    protected int front; //the index of the front of the queue
    protected int rear; //the index of the back of the queue

    public ArrayBoundedDate() {
        dateElements = new Integer[8]; //instantiate Integer array that holds the queue elements; always of length 8 in MMDDYYYY format
        numOfDateElements = 0; //always start with no elements in the queue
        front = 0; //queue always starts at first index
        rear = -1; //queue always ends at first index at the start, but must add 1 before putting an element in the rear; Therefore, -1 + 1 = 0
    }

    public void enqueue(int dateElement) {
        // Throws OverflowException if this queue is full;
        // otherwise, adds element to the rear of this queue.
        if(isFull())
            throw new OverflowException("Attempted enqueue but queue is full.");
        else {
            rear = (rear + 1) % dateElements.length;
            dateElements[rear] = dateElement;
            numOfDateElements++;
        }
    }

    public int dequeue() {
        // Throws UnderflowException if this queue is empty;
        // otherwise, removes front element from this queue and returns it.
        if(isEmpty())
            throw new UnderflowException("Attempted dequeue but queue is empty.");
        else {
            int dateElementNeeded = dateElements[front];
            dateElements[front] = null;
            front = (front + 1) % dateElements.length;
            numOfDateElements--;
            return dateElementNeeded;
        }
    }

    public boolean isEmpty() {
        //returns true if queue is empty, otherwise false
        return numOfDateElements == 0;
    }

    public boolean isFull() {
        //returns true if queue is full, otherwise false
        return numOfDateElements == dateElements.length;
    }

    public int getSize() {
        //returns number of elements in the queue
        return numOfDateElements;
    }

    public boolean isPalindrome() {
        //returns whether the queue represents a palindrome
        int first;
        int second;
        for (int i = 0; i < dateElements.length / 2; i++) {
                first = dateElements[i];
                second = dateElements[dateElements.length - 1 - i];
            if(first != second)
                return false;
        }
        return true;
    }

    public void clear() {
        //clears out queue for new date
        for(int i = 0; i < dateElements.length; i++) {
            dateElements[i] = null;
            numOfDateElements--;
        }
        front = 0;
        rear = -1;
    }
}
