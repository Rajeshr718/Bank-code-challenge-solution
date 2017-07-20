package com.bank.service;

import java.util.Timer;

import org.springframework.stereotype.Service;

import com.bank.model.StatisticsData;
import com.bank.model.Transaction;

@Service
public class StatisticsService {
	
	//we could also use spring injection
	private final StatisticsProcessor statsProcessor;
	
	private final TransactionProcessor transProcessor;
	
	
	public StatisticsService(){
		this.statsProcessor = new StatisticsProcessor();
		this.transProcessor = new TransactionProcessor(statsProcessor);
		Timer timer = new Timer();// 
		// we are going to set delay with zero because we may have transactions from past 
		timer.schedule(new SlideStatsWindowTask(statsProcessor), 0, 1000);
	}
	
	public void addTransaction(Transaction trans) {
		transProcessor.addTransaction(trans);
	}

	public StatisticsData getOverallStats() {
		return statsProcessor.getOverallStatistics();
	}

	protected boolean hasTransactionsInQueue() {
		return transProcessor.hasTransactionsInQueue();
	}
}
