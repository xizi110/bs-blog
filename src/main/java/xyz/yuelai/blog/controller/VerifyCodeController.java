package xyz.yuelai.blog.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.yuelai.blog.util.StringUtil;
import xyz.yuelai.blog.util.VerifyCodeUtils;

@Controller
public class VerifyCodeController {

	@RequestMapping("/verifyCode")
	public void verifyCode(HttpServletResponse resp,HttpServletRequest req) {
		resp.setHeader("Pragma", "No-cache");  
        resp.setHeader("Cache-Control", "no-cache");  
        resp.setDateHeader("Expires", 0);  
        resp.setContentType("image/jpeg");
		try {
			String code = StringUtil.randStr(4);
			HttpSession session = req.getSession(true);  
			session.setAttribute("rand", code);  
			VerifyCodeUtils.outputImage(100, 40, resp.getOutputStream(), code);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/checkCode",method=RequestMethod.GET, produces="text/html;charset=utf-8")
	public String checkCode(String code,HttpSession session) {
		JSONObject jsonObj = new JSONObject();
		if(code!=null) {
			boolean equals = code.equalsIgnoreCase((String) session.getAttribute("rand"));
			jsonObj.put("valid", equals);
		}
		return jsonObj.toString();
	}
}
