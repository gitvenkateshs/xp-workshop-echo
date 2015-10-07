package com.echo.channel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ChannelManager {

	public String getChannelId(String channelNumber) {
		File input = new File("pmt.properties");
		Properties pmt = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(input);
			pmt.load(inputStream);
			return pmt.getProperty(channelNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "-1";
	}

}
