package com.echo.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChannelSwitching
 */
public class ChannelSwitching extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChannelSwitching() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String channelNumber = request.getParameter("ChannelNo");
		System.out.println(channelNumber);
		PrintWriter out = response.getWriter();
		String channelid = getChannel(channelNumber);
		String channelName = getChannelName(channelid);
		if(channelid!=null){
			System.out.println(channelid + " " + channelName);
			out.write(channelid);
		}
		else {
			System.out.println("No channel found");
			out.write("-1");
			return ;
		}
	}

	public String getChannel(String channelNumber) {
		File input = new File(getServletContext().getRealPath("/")+"CONFIG"+File.separator+"pmt.properties");
		Properties pmt = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(input);
			pmt.load(inputStream);
			//return getChannelName(pmt.getProperty(channelNumber));
			return pmt.getProperty(channelNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getChannelName(String property) {
		File input = new File(getServletContext().getRealPath("/")+"CONFIG"+File.separator+"pmtToservice.properties");
		Properties pmtToservice = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(input);
			pmtToservice.load(inputStream);
			return pmtToservice.getProperty(property);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
