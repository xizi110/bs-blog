package xyz.yuelai.blog.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;


/**
 * @author l1103
 *	加密工具类
 */
@Component("encryptUtil")
public class EncryptUtil {
	/**
	 * 加密字符串
	 * 
	 * 加密算法名字$32位随机数$密文(加密算法加密(明文+随机数))
	 * 
	 * sha256$vGUYBd4BzksRLR2VfQlTcK9qpR2enm9T$386cc5be6a45b7a73ec7a1ea64f6793649af72ee9547662a5dbd8fe639177053
	 * 
	 * @param souStr
	 * @return
	 */
	public static String sha256EncodeStr(String souStr) {
		/* 分隔符 */
		String split = "$";
		/* 加密算法 */
		String encType = "sha256";
		/*
		 * 随机数 生成指定位数的随机数(字母+数字)
		 */
		String randStr = StringUtil.randStr(32);
		System.out.println("randStr= " + randStr);
		String jiamaHead = encType + split + randStr + split;

		/* 加密字符串 */
		String jiamiStr = DigestUtils.sha256Hex(souStr + randStr);
		return jiamaHead + jiamiStr;
	}

	/**
	 * 对比加密字符串
	 * 
	 * 拿着明文再加密一次,比对密文
	 * 
	 * 加密算法$随机数$密文(加密算法加密(明文+随机数))
	 * 
	 * @param souStr
	 * @return
	 */
	public static boolean sha256CheckStr(String souStr, String encodeStr) {
		/* 分隔符 */
		String split = "$";
		/* 加密算法 */
		String encType = "sha256";
		/*
		 * 取随机数 按照$拆分 0:加密算法 1:随机数 2:加密后的部分字符串(用不到)
		 */
		String[] encodeStrs = encodeStr.split("\\" + split);
		/* 拆分后的字符串我只使用了第2个 */
		if (encodeStrs.length == 3) {
			/* 传入的密码必须含$ */
			/* 拼装结果的部分字符串 */
			String jiamaHead = encType + split + encodeStrs[1] + split;
			/* 加密字符串 */
			String jiamiStr = DigestUtils.sha256Hex(souStr + encodeStrs[1]);
			/*
			 * 拼装最终的字符串 加密算法$随机数$密文(加密算法加密(明文+随机数))
			 */
			String finalStr = jiamaHead + jiamiStr;
			/* 验证明文是否一致 */
			return finalStr.equalsIgnoreCase(encodeStr);
		}
		return false;
	}

	public static void main(String[] args) {
		String encodeStr = EncryptUtil.sha256EncodeStr("li19971116");
		System.out.println("li19971116= " + encodeStr);
		boolean res = EncryptUtil.sha256CheckStr("li19971116",
				"sha256$MKns7ecelwRz32z7MqUUqBgbbxbfmzeY$364d159899037c914c3075309b3b116d4425e1a309d69740551d6876130e2a58"
						+ "");
		System.out.println(res);
	}
}
