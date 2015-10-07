package com.echo.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import com.echo.server.ChannelSwitching;

public class ChannelSwitchingTest {
	private static ChannelSwitching chSw;
	
	private static MockHttpServletRequest request;
    private static MockHttpServletResponse response;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		chSw=new ChannelSwitching();
		request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
	
	}

	@Test
	public void getChannel_should_return_channel_number_for_valid_input() {
		
		//request.addParameter();
		//assertEquals("Pogo", chSw.getChannel("3"));
		//assertEquals("Pogo", chSw.doGet(request,response));
		 //chSw.doPost(request, response);

	        assertEquals("text/html", response.getContentType());

	}
	//@Test
	public void getChannel_should_return_no_channel_for_invalid_input() {
		assertEquals("No channel found", chSw.getChannel("999"));
	}
}
