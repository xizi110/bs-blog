package xyz.yuelai.blog.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.yuelai.blog.entity.Article;
import xyz.yuelai.blog.service.IArticleService;
import xyz.yuelai.blog.service.IUserService;

@Controller
@RequestMapping("/back")
public class BackController {

	@Resource
	private IUserService userService;
	@Resource
	private IArticleService articleService;

	/**
	 * 后台登陆首页
	 * 
	 * @param page
	 *            页码
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index() {
		return "/back/index";
	}
	
	/**
	 * 博客列表
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String index(Integer page, Model model) {
		Map<String, Object> conditionMap = new HashMap<>();
		List<Article> articles = articleService.getArticleBriefList(null, conditionMap);
		model.addAttribute("articles", articles);
		return "/back/list";
	}
	
	@ResponseBody
	@RequestMapping(value="/article-delete",method=RequestMethod.GET,produces="text/html;charset=utf8")
	public String delete(Integer id) {
		JSONObject jsonObj = new JSONObject();
		try {
			articleService.deleteArticle(id);
			jsonObj.put("status", 1);
		}catch (Exception e) {
			jsonObj.put("status", 0);
		}
		return jsonObj.toString();
	}

	/**
	 * 新增文章，编辑文章页面跳转入口
	 * 
	 * @param type
	 *            新增还是编辑
	 * @param id
	 *            编辑指定文章id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/article-{type}",method=RequestMethod.GET)
	public String article(@PathVariable String type, Integer id, Model model) {
		if (type.equals("edit")) {
			Map<String, Integer> categorys = articleService.getArticleCategories();
			model.addAttribute("categorys", categorys);
			Article article = articleService.getArticle(id);
			model.addAttribute("article", article);
		} else if (type.equals("add")) {
			Map<String, Integer> categorys = articleService.getArticleCategories();
			model.addAttribute("categorys", categorys);
		}
		return "/back/article-"+type;
	}

	@RequestMapping(value="/article-{type}",method=RequestMethod.POST)
	public String articleSubmit(@PathVariable String type, Article article,Model model) {
		if (type.equals("add")) {
			article.setPublishTime(new Date());
			article.setReadNum(0);
			article.setStatus(1);
			articleService.saveArticle(article);
			System.out.println(article);
		} else if (type.equals("edit")) {
			System.out.println(article);
			articleService.updateArticle(article);
		}

		return "redirect:/back/list.html";
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:/auth/login.html";
	}

}
