package xyz.yuelai.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.yuelai.blog.entity.User;

/**
 * @author xizi
 * 
 *         身份验证,注册,登录
 * 
 *         2018年8月18日上午9:49:00
 * 
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {
		return "/login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST,produces="text/html; charset=utf-8" )
	public String login(User user, String code,Integer remember, HttpServletRequest req) {
		String sessionCode = (String) req.getSession().getAttribute("rand");
		System.out.println(remember);
		boolean rememberMe = true;
		if(remember == null) {
			rememberMe = false;
		}
		JSONObject jsonObj = new JSONObject();
		if (sessionCode != null && sessionCode.equalsIgnoreCase(code)) {
			UsernamePasswordToken token = new UsernamePasswordToken(
					user.getEmail(), user.getPassword());
			try {
				token.setRememberMe(rememberMe);
				SecurityUtils.getSubject().login(token);
				jsonObj.put("code", "1");
				jsonObj.put("msg", "登陆成功");
				jsonObj.put("action", "/back/index.html");
				
			} catch (AuthenticationException e) {
				jsonObj.put("code", "0");
				jsonObj.put("msg", "邮箱或密码错误");
			}
		} else {
			jsonObj.put("code", "0");
			jsonObj.put("msg", "验证码不正确");
		}
		return jsonObj.toString();
	}

}
