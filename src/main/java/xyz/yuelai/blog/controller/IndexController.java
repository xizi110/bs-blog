package xyz.yuelai.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.yuelai.blog.entity.Article;
import xyz.yuelai.blog.service.IArticleService;
import xyz.yuelai.blog.service.ICommentService;
import xyz.yuelai.blog.util.PageInfoUtil;

@Controller
public class IndexController {

	@Resource
	private IArticleService articleService;
	@Resource
	private ICommentService commentService;

	@RequestMapping(value = { "/", "index" })
	public String index(Model model, Integer page) {
		PageInfoUtil pageInfoUtil = new PageInfoUtil();
		if (page == null || page <= 0) {
			page = 1;
		}
		pageInfoUtil.setCurrentPage(page);
		pageInfoUtil.setPageSize(20);
		List<Article> article = articleService.getArticleBriefList(null, new HashMap<>());
		Map<String, Integer> articleCategories = articleService.getArticleCategories();
		Map<String, Integer> articleDate = articleService.getArticleDate();
		model.addAttribute("articles", article);
		model.addAttribute("articleCategories", articleCategories);
		model.addAttribute("articleDate", articleDate);
		model.addAttribute("page", pageInfoUtil);
		
		return "/index";
	}
	
	@RequestMapping(value= {"/list"})
	public String list(String c,String d, Model model) {
		Map<String,Object> conditionMap = new HashMap<>();
		conditionMap.put("category", c);
		conditionMap.put("publishTime", d);
		List<Article> articleBriefList = articleService.getArticleBriefList(null, conditionMap);
		Map<String, Integer> articleCategories = articleService.getArticleCategories();
		Map<String, Integer> articleDate = articleService.getArticleDate();
		model.addAttribute("articles", articleBriefList);
		model.addAttribute("articleCategories", articleCategories);
		model.addAttribute("articleDate", articleDate);
		return "/index";
	}

	@RequestMapping(value = { "/detail/{id}" })
	public String detail(Model model, @PathVariable Integer id,HttpServletResponse resp) {
		if (id == null) {
			return "redirect:/index.html";
		}
		Article article = articleService.getArticle(id);
		if (article == null) {
			model.addAttribute("msg", "找不到文章了");
			return "/detail";
		}
		model.addAttribute("prevArticle", articleService.getPrevArticle(id));
		model.addAttribute("nextArticle", articleService.getNextArticle(id));
		model.addAttribute("article", article);
		return "/detail";
	}
}
