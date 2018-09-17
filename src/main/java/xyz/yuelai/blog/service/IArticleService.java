package xyz.yuelai.blog.service;

import java.util.List;
import java.util.Map;

import xyz.yuelai.blog.entity.Article;
import xyz.yuelai.blog.util.PageInfoUtil;

public interface IArticleService {
	/**
	 * @param article 保存的文章
	 */
	public void saveArticle(Article article);
	
	/**
	 * 删除一篇文章
	 * @param articleID 文章id
	 */
	public void deleteArticle(Integer articleID);
	
	/**
	 * 更新文章
	 * @param article 更新的文章,必须包含文章id
	 */
	public void updateArticle(Article article);
	
	/**
	 * 查询最大id
	 * @return	max id
	 */
	public Integer getMaxID();
	
	/**
	 * 查询一篇文章简介
	 * @param id 文章id
	 * @return	查询到的文章简介
	 */
	public Article getArticleBrief(Integer id);
	
	/**
	 * 查询一篇文章详情
	 * @param id 文章id
	 * @return	查询到的文章详情
	 */
	public Article getArticle(Integer id);
	
	/**
	 * 根据当前id查询上一条数据
	 * @param id
	 * @return
	 */
	public Article getPrevArticle(Integer id);
	
	/**
	 * 根据当前id查询下一条数据
	 * @param id
	 * @return
	 */
	public Article getNextArticle(Integer id);
	
	/**
	 * 查询文章简介列表
	 * @param pageInfoUtil 分页信息
	 * @param conditionMap 查询条件
	 * @return 文章简介列表
	 */
	public List<Article> getArticleBriefList(PageInfoUtil pageInfoUtil,Map<String,Object> conditionMap);
	
	/**
	 * 查询文章列表
	 * @param pageInfoUtil	 分页信息
	 * @param conditionMap	查询条件	
	 * @return 文章list
	 */
	public List<Article> getArticleList(PageInfoUtil pageInfoUtil,Map<String,Object> conditionMap);
	
	/**
	 * 查询所有分类
	 * @return
	 */
	public Map<String,Integer> getArticleCategories();
	
	/**
	 * 查询所有日期
	 * @return
	 */
	public Map<String,Integer> getArticleDate();
	
}
