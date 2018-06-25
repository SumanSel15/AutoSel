package com.mvnselfrmwrk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFileData {
	static Properties properties;

	public static void readfile() throws IOException {
		properties = new Properties();
		InputStream input = new FileInputStream("E:\\Sel_Framewrk\\mvnselprj\\datafile.properties");
		properties.load(input);
		
	}
	
	public static String getObject(String Data) throws IOException {
		readfile();
		String data = properties.getProperty(Data);
		return data;
		
	}
}
