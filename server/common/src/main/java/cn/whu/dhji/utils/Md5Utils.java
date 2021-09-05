package cn.whu.dhji.utils;

import java.io.UnsupportedEncodingException;

import org.springframework.util.DigestUtils;

public class Md5Utils {
	public static String md5(String str) {
		try {
			return DigestUtils.md5DigestAsHex(str.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
