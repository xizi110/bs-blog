/**
 * 
 */
package xyz.yuelai.blog.realm;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;

import xyz.yuelai.blog.entity.User;
import xyz.yuelai.blog.service.IUserService;
import xyz.yuelai.blog.util.EncryptUtil;

/**
 * @author xizi QQ1103884823
 *	
 * 2018年8月18日 上午9:36:39
 */
public class MyRealm extends AuthenticatingRealm {

	@Resource
	private IUserService userService;
	
	
	/**
	 * 用户认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String email = token.getPrincipal().toString();
		String password = new String((char[]) token.getCredentials());
		Map<String, Object> conditionMap = new HashMap<>();
		conditionMap.put("email", email);
		User user = userService.getUser(conditionMap);
		if (user != null) {
			if (EncryptUtil.sha256CheckStr(password, user.getPassword())) {
				SecurityUtils.getSubject().getSession().setAttribute("user",
						user);
				return new SimpleAuthenticationInfo(email, password, getName());
			}
			return null;
		}
		return null;
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	@Override
	public String getName() {
		return "myRealm";
	}

}
