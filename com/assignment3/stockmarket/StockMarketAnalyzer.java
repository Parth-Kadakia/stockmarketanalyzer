package com.assignment3.stockmarket;

import java.util.Scanner;
import java.util.StringTokenizer;
import com.assignment3.stockmarket.LinkedListQueue;

public class StockMarketAnalyzer {
	static LinkedListQueue Stock = new LinkedListQueue();
	static String status = "true";
	static int stockQuantity;
	static double stockPrice;
	static int sellQuantity;
	static double sellPrice;
	static double gain;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (!status.equals("false")) {
			if (status.equals("true")) {
				enterValues(sc);
			}
		}
		System.out.println("Thank you for using Stock Analyzer");
	}

	private static void enterValues(Scanner sc) {
		System.out.println("Enter either of the following lines to perform various operations");
		System.out.println("------");
		System.out.println("buy <share quantity> shares at <share price> each");
		System.out.println("sell <share quantity> shares at <share price> each");
		System.out.println("show stocks");
		System.out.println("exit");
		System.out.println("------");
		String input = sc.nextLine();
		StringTokenizer st = new StringTokenizer(input);
		decisionValue(st);
	}

	private static void decisionValue(StringTokenizer st) {
		while (st.hasMoreTokens()) {
			String choice = st.nextToken();
			if (choice.equals("buy")) {
				stockQuantity = Integer.parseInt(st.nextToken());
				st.nextToken();
				st.nextToken();
				stockPrice = Double.parseDouble(st.nextToken());
				Stock.enqueue(stockQuantity, stockPrice);
				break;
			} else if (choice.equals("exit")) {
				status = "false";
			} else if (choice.equals("sell")) {
				sellQuantity = Integer.parseInt(st.nextToken());
				st.nextToken();
				st.nextToken();
				sellPrice = Double.parseDouble(st.nextToken());
				sellingPriceCalculator(sellQuantity, sellPrice);
			}else if(choice.equals("show")){
				Stock.printList();
			}
		}
	}

	private static void sellingPriceCalculator(int sellQuantity, double sellPrice) {

		int totalQuantity = Stock.calculateStockQuantity();

		if (sellQuantity > totalQuantity) {
			System.out.println("You do not have " + sellQuantity + " amount of stock to sell.");
			return;
		} else if (sellQuantity < 0) {
			return;
		} else {
			if (Stock.getStock() == sellQuantity) {
				double price = Stock.getPrice();
				Stock.dequeue();
				gain = gain + sellQuantity * (sellPrice - price);
			} else if (Stock.getStock() < sellQuantity) {
				int quantity = Stock.getStock();
				double price = Stock.getPrice();
				Stock.dequeue();
				gain = gain + quantity * (sellPrice - price);
				sellQuantity = sellQuantity - quantity;
				sellingPriceCalculator(sellQuantity, sellPrice);
			} else if (Stock.getStock() > sellQuantity) {
				int quantity = Stock.getStock();
				double price = Stock.getPrice();
				int sellableStock = quantity - sellQuantity;
				Stock.dequeue();
				gain = gain + sellQuantity * (sellPrice - price);
				Stock.enqueue(sellableStock, price);
			}
		}

		calculateGain();
		Stock.printList();
		System.out.println(" ");
	}

	private static void calculateGain() {
		if (gain < 0) {
			System.out.println(" ");
			System.out.println("Total capital loss is  $" + gain);
			System.out.println(" ");
		} else {
			System.out.println(" ");
			System.out.println("Total capital gain is  $" + gain);
			System.out.println(" ");
		}
	}
}
