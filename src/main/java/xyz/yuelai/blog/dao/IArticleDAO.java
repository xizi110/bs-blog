package xyz.yuelai.blog.dao;

import java.util.List;
import java.util.Map;

import xyz.yuelai.blog.entity.Article;

public interface IArticleDAO {

	/**
	 * 保存文章
	 * 
	 * @param article
	 *            保存的文章
	 */
	public void saveArticle(Article article);

	/**
	 * 删除一篇文章
	 * 
	 * @param id 文章id
	 *            
	 */
	public void deleteArticle(Integer id);

	/**
	 * 更新文章
	 * 
	 * @param article
	 *            更新的文章,必须包含文章id
	 */
	public void updateArticle(Article article);

	/**
	 * 查询最大id
	 * 
	 * @return max id
	 */
	public Integer getMaxID();

	/**
	 * 查询一篇文章简介
	 * 
	 * @param id
	 *            文章id
	 * @return 仅仅包含文章简介的article,不包含detail
	 */
	public Article getArticleBrief(Integer id);

	/**
	 * 查询一篇文章详情
	 * 
	 * @param id
	 *            文章id
	 * @return 查询到的文章
	 */
	public Article getArticle(Integer id);

	/**
	 * 查询文章简介列表
	 * 
	 * @param conditionMap
	 *            查询条件	category or publishTime
	 * @return 文章简介列表
	 */
	public List<Article> getArticleBriefList(Map<String, Object> conditionMap);

	/**
	 * 查询文章列表
	 * 
	 * @param conditionMap
	 *            查询条件
	 * @return 文章list
	 */
	public List<Article> getArticleList(Map<String, Object> conditionMap);
	
	/**
	 * 查询所有文章分类
	 * @return
	 */
	public List<Map<String,Object>> getArticleCategories();
	
	/**
	 * 查询所有文章日期
	 * @return
	 */
	public List<Map<String,Object>> getArticleDate();

	/**
	 * 当前id的上一条数据
	 * @param id
	 * @return
	 */
	public Article getPrevArticle(Integer id);

	/**
	 * 当前id的下一条数据
	 * @param id
	 * @return
	 */
	public Article getNextArticle(Integer id);

}
