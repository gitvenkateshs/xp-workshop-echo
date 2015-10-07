package com.echo.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.echo.server.ChannelSwitching;

public class ChannelSwitchingTest {
	private static ChannelSwitching chSw;
	@Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Mock
	 HttpSession session;

	 @Mock
	 RequestDispatcher rd;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		chSw=new ChannelSwitching();
		MockitoAnnotations.initMocks(chSw);
	}

	@Test
	public void getChannel_should_return_channel_number_for_valid_input() {
		
		  try {
			chSw.doGet(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals("Pogo", chSw.getChannel("3"));
	}
	//@Test
	public void getChannel_should_return_no_channel_for_invalid_input() {
		assertEquals("No channel found", chSw.getChannel("999"));
	}
}
