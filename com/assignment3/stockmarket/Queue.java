package com.assignment3.stockmarket;

import java.util.EmptyStackException;

public interface Queue {
public int size();
public boolean isEmpty();
//public E front() throws EmptyStackException;
public void enqueue (int element1, double element2);
public int dequeue() throws EmptyStackException;
}
