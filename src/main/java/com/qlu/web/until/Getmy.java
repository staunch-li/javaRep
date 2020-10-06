package com.qlu.web.until;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Getmy {

	private static List<String> datas = new ArrayList<String>();
	static {
		InputStream is = Getmy.class.getClassLoader().getResourceAsStream("path.my");
		String line = null;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is));){
			while ((line=br.readLine())!=null) {
				datas.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<String> getDatas() {
		return datas;
	}
	
	
	
}
