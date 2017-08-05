package com.assignment3.stockmarket;

public class Node {

	int stockQuantity;
	double stockPrice;

	Node next;

	Node() {
	}

	public void setElement(int quantity,double price) {
		stockQuantity = quantity;
		stockPrice = price;
	}

	public void setNext(Node n) {
		next = n;
	}

	public int getElement1() {
		// TODO Auto-generated method stub
		return stockQuantity;
	}
	
	public double getElement2() {
		return stockPrice;
	}

	public Node getNext() {
		// TODO Auto-generated method stub
		return next;
	}

}
