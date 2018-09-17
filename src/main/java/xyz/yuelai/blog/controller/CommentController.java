/**
 * 
 */
package xyz.yuelai.blog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.yuelai.blog.entity.Comment;
import xyz.yuelai.blog.service.ICommentService;

/**
 * @author xizi QQ1103884823
 *	
 * 2018年8月25日 上午9:50:38
 * 
 */
@Controller
public class CommentController {
	
	@Resource
	private ICommentService commentService;
	
	/**
	 * 
	 */
	@RequestMapping("/comment")
	public String comment(HttpServletRequest req,Comment comment,String returnUrl) {
		commentService.saveComment(comment);
		return "redirect:"+returnUrl;
	}
}
