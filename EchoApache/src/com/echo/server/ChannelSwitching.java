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

import com.echo.channel.ChannelManager;

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
		ChannelManager channelManager = new ChannelManager();
		String channelid = channelManager.getChannelId(channelNumber);
		if(channelid!=null){
			System.out.println(channelid);
			out.write(channelid);
		}
		else {
			System.out.println("No channel found");
			out.write("-1");
			return ;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
