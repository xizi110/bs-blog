package xyz.yuelai.blog.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;

import xyz.yuelai.blog.dao.IArticleDAO;
import xyz.yuelai.blog.entity.Article;
import xyz.yuelai.blog.service.IArticleService;
import xyz.yuelai.blog.util.PageInfoUtil;

@Service("articleService")
public class ArticleServiceImpl implements IArticleService {

	@Autowired
	private IArticleDAO articleDAO;

	@Override
	public void saveArticle(Article article) {
		articleDAO.saveArticle(article);
	}

	@Override
	public void deleteArticle(Integer articleID) {
		articleDAO.deleteArticle(articleID);
	}

	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}

	@Override
	public Article getArticleBrief(Integer id) {
		return articleDAO.getArticleBrief(id);
	}

	@Override
	public Article getArticle(Integer id) {
		return articleDAO.getArticle(id);
	}

	@Override
	public List<Article> getArticleBriefList(PageInfoUtil pageInfoUtil, Map<String, Object> conditionMap) {
		if (pageInfoUtil != null) {
			Page<Article> page = PageMethod.startPage(pageInfoUtil.getCurrentPage(), pageInfoUtil.getPageSize());
			List<Article> articleList = articleDAO.getArticleBriefList(conditionMap);
			pageInfoUtil.setTotalRecord((int) page.getTotal());
			return articleList;
		}
		return articleDAO.getArticleBriefList(conditionMap);
	}
	
	@Override
	public List<Article> getArticleList(PageInfoUtil pageInfoUtil, Map<String, Object> conditionMap) {
		if (pageInfoUtil != null) {
			Page<Article> page = PageMethod.startPage(pageInfoUtil.getCurrentPage(), pageInfoUtil.getPageSize());
			List<Article> articleList = articleDAO.getArticleList(conditionMap);
			pageInfoUtil.setTotalRecord((int) page.getTotal());
			return articleList;
		}
		return articleDAO.getArticleList(conditionMap);
	}

	@Override
	public Integer getMaxID() {
		return articleDAO.getMaxID();
	}

	@Override
	public Map<String,Integer> getArticleCategories() {
		Map<String,Integer> map1 = new HashMap<>();
		List<Map<String, Object>> articleCategories = articleDAO.getArticleCategories();
		for (Map<String, Object> map : articleCategories) {
			String category = map.get("category").toString();
			Integer count = Integer.valueOf(map.get("count").toString());
			map1.put(category, count);
		}
		return map1;
	}

	@Override
	public Map<String,Integer> getArticleDate() {
		Map<String,Integer> map1 = new LinkedHashMap<>();
		List<Map<String, Object>> articledate = articleDAO.getArticleDate();
		for (Map<String, Object> map : articledate) {
			String publishTime = map.get("publishTime").toString();
			Integer count = Integer.valueOf(map.get("count").toString());
			map1.put(publishTime, count);
		}
		return map1;
	}
	@Override
	public Article getPrevArticle(Integer id) {
		return articleDAO.getPrevArticle(id);
	}

	@Override
	public Article getNextArticle(Integer id) {
		return articleDAO.getNextArticle(id);
	}

	
}
