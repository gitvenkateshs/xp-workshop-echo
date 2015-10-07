package com.echo.userauth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteProperties {
	public static void main(String[] args) {
		try {
			Properties properties = new Properties();
			properties.setProperty("userID", "XYZ");
			properties.setProperty("channellist", "101,202,303,505,606,808,909,1010");

			File file = new File("XYZ.properties");
			FileOutputStream fileOut = new FileOutputStream(file);
			properties.store(fileOut, "Channel Properties");
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
