package xyz.yuelai.blog.entity;

import java.io.Serializable;
import java.util.Date;

 /**
 * @author xizi QQ1103884823
 *	
 * 2018年9月16日 下午11:43:02
 * 
 */
public class Article implements Serializable {
	private static final long serialVersionUID = 2523085941973910907L;
	private Integer id; // 数据库表主键id,文章id
	private String title; // 文章标题
	private String keywords; // 文章关键词
	private String summary; // 文章简介(摘要)
	private String author; // 文章作者
	private String source; // 文章来源
	private String category; // 文章分类
	private Date publishTime; // 发布时间
	private Integer readNum; // 阅读数
	private Integer status; // 发布状态(1已发布,0未发布)
	private String detail; // 文章详情
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Integer getReadNum() {
		return readNum;
	}
	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", keywords="
				+ keywords + ", summary=" + summary + ", author=" + author
				+ ", source=" + source + ", category=" + category
				+ ", publishTime=" + publishTime + ", readNum=" + readNum
				+ ", status=" + status + ", detail=" + detail + "]";
	}

	
}
