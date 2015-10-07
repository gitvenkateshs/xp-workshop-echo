package com.echo.userauth;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserAuth {

	Properties prop = new Properties();
	InputStream input = null;
	int channel_no;
	boolean flag = false;
	
	UserAuth(int channel_no){
		channel_no=this.channel_no;
	}

	public boolean authenticate(){
	
		try {

		input = new FileInputStream("XYZ.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		//System.out.println(prop.getProperty("userID"));
		//System.out.println(prop.getProperty("channellist"));
		
		String[] a = prop.getProperty("channellist").split(",");
		for(int i=0; i<a.length;i++){
			if(Integer.toString(channel_no) == a[i]){
				flag = true;
				System.out.println("its der");
				break;
			}
		}
		

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		return flag;
}
}
 

