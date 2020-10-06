package com.qlu.web.until;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PSWUtil {

	public static String getPSW(String password) {
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		return bpe.encode(password);
	}
	public static boolean matchPSW(String password,String psw) {
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		return bpe.matches(password, psw);
	}
}
