package com.echo.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String channelNumber = request.getParameter("ChannelNo");
		System.out.println(channelNumber);
		String json = getChannelNumber(channelNumber);
		System.out.println(json);
		PrintWriter out = response.getWriter();
		//out.write(json);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private String getChannelNumber(String channelNumber) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			System.out.println(File.separator+"CONFIG"+File.separator+"channel.properties");
			input = new FileInputStream(File.separator+"CONFIG"+File.separator+"channel.properties");
			prop.load(input);
			System.out.println(prop.getProperty(channelNumber.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(channelNumber.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
