package xyz.yuelai.blog.service.impl;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xyz.yuelai.blog.entity.Article;
import xyz.yuelai.blog.service.IArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/*.xml"})
public class ArticleServiceImplTest {

	@Autowired
	private IArticleService articleService;
	
	@Test
	public void testSaveArticle() {
		Article article = new Article();
		article.setId(100);
		article.setTitle("aaaa");
		article.setSummary("aaaaaaaa");
		article.setPublishTime(new Date());
		article.setReadNum(0);
		article.setStatus(1);
		article.setCategory("");
		article.setDetail("Hello World!!!!");
		article.setKeywords("hello,world");
		article.setAuthor("xizi");
		article.setSource("悦来");
		articleService.saveArticle(article);
	}

	@Test
	public void testDeleteArticle() {
		articleService.deleteArticle(100);
	}

	@Test
	public void testUpdateArticle() {
		Article article = new Article();
		article.setId(100);
		article.setPublishTime(new Date());
		article.setAuthor("李泽众");
		articleService.updateArticle(article);
	}

	@Test
	public void testGetArticle() {
		/*ArticleBrief brief = articleService.getArticleBrief(100);
		System.out.println(brief);*/
		Article detail = articleService.getArticle(100);
		System.out.println(detail);
		/*List<ArticleBrief> briefList = articleService.getArticleBriefList(null, new HashMap<String,Object>());
		System.out.println(briefList.size());*/
	}

	@Test
	public void testGetArticleList() {
//		System.out.println(articleService.getMaxID());
//		Map<String, Integer> list = articleService.getArticleCategories();
//		System.out.println(list);
		
//		Map<String, Integer> articleDate = articleService.getArticleDate();
//		System.out.println(articleDate);
		Article prevArticle = articleService.getPrevArticle(25);
		Article nextArticle = articleService.getNextArticle(25);
		System.out.println(prevArticle.getId()+"=="+prevArticle.getTitle());
		System.out.println(nextArticle.getId()+"=="+nextArticle.getTitle());
		
//		Map<String,Object> conditionMap = new HashMap<>();
//		conditionMap.put("publishTime", "2018-03");
//		articleService.getArticleBriefList(null, conditionMap);
	}

}
