package com.bank.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.bank.service.SlideStatsWindowTask;
import com.bank.service.StatisticsProcessor;

public class SlideStatsWindowTaskTest {

	@Test
	public void testAddTransaction() {

		StatisticsProcessor statsProcessorMock = mock(StatisticsProcessor.class);

		new SlideStatsWindowTask(statsProcessorMock).run();

		verify(statsProcessorMock, times(1)).slidePerodicStatsicsWindow();

	}
}
