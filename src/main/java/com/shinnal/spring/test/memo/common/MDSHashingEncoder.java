package com.shinnal.spring.test.memo.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDSHashingEncoder {

	// mds를 통한 암호화
	// static = 객체생성 없이 사용 - 구조를 만들어서 사용하기 때문에 객체생성이 필요없음
	
	public static String encode(String message) {
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("md5");
			
			byte[] bytes = message.getBytes();
			
			messageDigest.update(bytes);
			
			byte[] digest = messageDigest.digest();
			
			String result = "";
			for(int i = 0; i < digest.length; i++) {
				result += Integer.toHexString(digest[i] & 0xff);
					
			}
			
			return result;
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
}
