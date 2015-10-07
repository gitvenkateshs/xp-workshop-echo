package com.echo.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

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
		
		request.addParameter("ChannelNo","3");
		//assertEquals("Pogo", chSw.getChannel("3"));
		//assertEquals("Pogo", chSw.doGet(request,response));
		 try {
			chSw.doPost(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	        try {
				assertEquals("Pogo", response.getContentAsString());
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();                    
			}

	}
	//@Test
	public void getChannel_should_return_no_channel_for_invalid_input() {
		assertEquals("No channel found", chSw.getChannel("999"));
	}
}
