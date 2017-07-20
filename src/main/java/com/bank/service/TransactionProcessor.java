package com.bank.service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.bank.model.Transaction;

public class TransactionProcessor{

	/**
	 * Queue for handling new transaction as we handle asynchronized, to make
	 * add transaction request is not blocking.
	 */
	private final Queue<Transaction> transQueue;
	
	private final StatisticsProcessor statsProcessor;

	public TransactionProcessor(StatisticsProcessor statsProcessor) {
		this.transQueue = new ConcurrentLinkedQueue<>();
		this.statsProcessor =  statsProcessor;
		Thread thread = new Thread(){
			public void run() {
				process();
			};
		};
		thread.start();
	}

	public void addTransaction(Transaction transaction){
		
		System.out.println(transQueue.toString());
		this.transQueue.add(transaction);
	}
	
	protected boolean hasTransactionsInQueue(){
		return transQueue.size() >1;
	}
	
	
	private void process() {
		while (true) {
			Transaction transaction = transQueue.poll();
			if (transaction != null) {
				statsProcessor.processTransaction(transaction);
			}
		}
	}

}
