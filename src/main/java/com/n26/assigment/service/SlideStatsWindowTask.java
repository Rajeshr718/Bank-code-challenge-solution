package com.n26.assigment.service;

import java.util.TimerTask;


public class SlideStatsWindowTask extends TimerTask{

	private StatisticsProcessor processor;
	
	public SlideStatsWindowTask(StatisticsProcessor processor){
		this.processor = processor;
	}
	
	@Override
	public void run() {
		processor.slidePerodicStatsicsWindow();
	}
		
}
