package xyz.yuelai.blog.util;

import java.util.Random;


/**
 * 字符串工具类
 * 
 * @author xizi QQ1103884823
 *	
 * 2018年9月16日 下午11:47:53
 * 
 */
public class StringUtil {
	
	/**
	 * 获得指定长度的随机字符串，包含a~z,A~Z,0~9
	 * @param len 字符串长度
	 * @return 指定长度的随机字符串
	 */
	public static String randStr(int len) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			char c = ConstantFinalUtil.ALL_STR.charAt(rand.nextInt(ConstantFinalUtil.ALL_STR.length()));
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(randStr(10));
	}
}
