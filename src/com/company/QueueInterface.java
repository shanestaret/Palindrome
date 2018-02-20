package com.company;

/**
 * Created by Shane on 2/20/2018.
 */
public interface QueueInterface {
    void enqueue(int element) throws OverflowException;
    // Throws OverflowException if this queue is full
    // otherwise, adds element to the rear of this queue.

    int dequeue() throws UnderflowException;
    // Throws UnderflowException if this queue is empty
    // otherwise, removes front element from this queue and returns it.

    boolean isFull();
    // Returns true if this queue is full;
    // otherwise, returns false.

    boolean isEmpty();
    // Returns true if this queue is empty;
    // otherwise, returns false.

    int getSize();
    // Returns the number of elements in this queue.

    public boolean isPalindrome();
    //returns whether the queue represents a palindrome

    public void clear();
    //clears queue
}
