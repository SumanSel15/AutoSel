package com.mvnselfrmwrk;

import java.io.IOException;

import org.testng.annotations.Test;

public class GetDatafromFile{
	 static ReadFileData readfiledata;
	@Test
	public static void getdata() throws IOException {
		String abc= readfiledata.getObject("surname");
		System.out.println(abc);
		
	}

}
