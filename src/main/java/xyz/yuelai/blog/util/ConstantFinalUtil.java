package xyz.yuelai.blog.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author xizi QQ1103884823
 *	
 * 2018年9月16日 下午11:46:23
 * 
 */
public class ConstantFinalUtil {

	/* 所有的公共的日志工具类 */
	public static Logger LOGGER = LogManager.getLogger();

	/**
	 * 常量字符串
	 */
	public static String ALL_STR = "abcdefghjklmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ23456789";

	/* 日期格式 */
	public static String DATE_FORMAT = "yyyy-MM-dd";
	/* 日期时间格式 */
	public static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
