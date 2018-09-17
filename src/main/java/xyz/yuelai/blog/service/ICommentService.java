package xyz.yuelai.blog.service;

import java.util.List;

import xyz.yuelai.blog.entity.Comment;
import xyz.yuelai.blog.util.PageInfoUtil;

public interface ICommentService {
	/**
	 * 保存评论
	 * 
	 * @param comment
	 *            待保存评论
	 */
	void saveComment(Comment comment);

	/**
	 * 获取评论list
	 * 
	 * @param pageInfoUtil
	 *            分页信息
	 * @param conditionMap
	 *            条件map
	 * @return 评论list
	 */
	List<Comment> getCommentList(PageInfoUtil pageInfoUtil,
			Integer articleID);
}
