package com.echo.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.echo.server.ChannelSwitching;

public class ChannelSwitchingTest {
	private static ChannelSwitching chSw;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		chSw=new ChannelSwitching();
		MockitoAnnotations.initMocks(chSw);
	
	}

	@Test
	public void getChannel_should_return_channel_number_for_valid_input() {
		
		 

		//assertEquals("Pogo", chSw.getChannel("3"));
		//assertEquals("Pogo", chSw.doGet(request,response));

	}
	//@Test
	public void getChannel_should_return_no_channel_for_invalid_input() {
		assertEquals("No channel found", chSw.getChannel("999"));
	}
}
