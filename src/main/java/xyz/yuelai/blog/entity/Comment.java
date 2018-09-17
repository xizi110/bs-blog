/**
 * 
 */
package xyz.yuelai.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xizi QQ1103884823
 * 
 *         2018年8月25日 上午9:59:36
 * 
 */
public class Comment implements Serializable{
	private static final long serialVersionUID = 3051618378049421760L;
	private Integer commentID;
	private String content;
	private String nickname;
	private Date time;
	private Integer articleID;
	
	public Integer getCommentID() {
		return commentID;
	}
	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getArticleID() {
		return articleID;
	}
	public void setArticleID(Integer articleID) {
		this.articleID = articleID;
	}


}
