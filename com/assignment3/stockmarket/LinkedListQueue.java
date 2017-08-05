package com.assignment3.stockmarket;

public class LinkedListQueue implements Queue {
	Node head;
	Node tail;
	int size;

	public LinkedListQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enqueue(int element1, double element2) {
		Node node = new Node();
		node.setElement(element1, element2);
		node.setNext(null);

		if (size == 0) {
			head = node;
		} else {
			tail.setNext(node);
		}
		tail = node;
		size++;
	}

	@Override
	public int dequeue() throws EmptyQueueException {
		if (size == 0)
			throw new EmptyQueueException("Queue is empty");
		int tmp = head.getElement1();

		head = head.getNext();
		size--;
		if (size == 0)
			tail = null; // the queue is now empty
		return tmp;
	}

	public void printList() {
		if (head == null) {
			System.out.println("You do not have any stocks");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.println("Stock Quantity Remaining - " + temp.getElement1() + ", bought at Stock Price - " + temp.getElement2());
			temp = temp.getNext();
		}
	}

	public int calculateStockQuantity() {
		int totalStockQuantity = 0;

		if (head == null) {
			System.out.println("You do not have any stocks");
			return 0;
		}
		Node temp = head;
		while (temp != null) {
			totalStockQuantity = totalStockQuantity + temp.getElement1();
			temp = temp.getNext();
		}
		// System.out.println("Total Number of Stocks - " + totalStockQuantity);
		return totalStockQuantity;
	}

	public double calculateStockPrice() {
		double totalStockPrice = 0;

		if (head == null) {
			System.out.println("You do not have any stocks");
			return 0;
		}
		Node temp = head;
		while (temp != null) {
			totalStockPrice = totalStockPrice + temp.getElement2();
			temp = temp.getNext();
		}
		// System.out.println("Total Price of Stocks - " + totalStockPrice);
		return totalStockPrice;
	}

	public int getStock() {
		int quantity = head.getElement1();
		return quantity;
	}
	
	public double getPrice(){
		double price = head.getElement2();
		return price;
	}

}
