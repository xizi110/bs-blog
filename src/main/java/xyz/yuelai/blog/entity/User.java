package xyz.yuelai.blog.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * @author xizi QQ1103884823
 *	
 * 2018年9月16日 下午11:43:24
 * 
 */
public class User implements Serializable {
	private static final long serialVersionUID = 4727009308071124295L;
	private Integer userID;		//用户id
	private String username;	//用户名
	private String email;		//用户邮箱
	private String password;	//用户密码
	private String headPortrait;//用户头像
	private Date regDate;		//注册日期
	private Integer roleID;		//角色id

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", email=" + email + ", password=" + password
				+ "]";
	}

}
