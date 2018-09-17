/**
 * 
 */
package xyz.yuelai.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import xyz.yuelai.blog.dao.ICommentDAO;
import xyz.yuelai.blog.entity.Comment;
import xyz.yuelai.blog.service.ICommentService;
import xyz.yuelai.blog.util.PageInfoUtil;

/**
 * @author xizi QQ1103884823
 * 
 *         2018年8月25日 上午10:08:42
 * 
 */
@Service("commentService")
public class CommentServiceImpl implements ICommentService {

	@Autowired
	private ICommentDAO commentDAO;

	@Override
	public void saveComment(Comment comment) {
		commentDAO.saveComment(comment);
	}

	@Override
	public List<Comment> getCommentList(PageInfoUtil pageInfoUtil,
			Integer articleID) {
		if (pageInfoUtil != null) {
			Page<Comment> page = PageHelper.startPage(
					pageInfoUtil.getCurrentPage(), pageInfoUtil.getPageSize());
			List<Comment> commentList = commentDAO.getCommentList(articleID);
			pageInfoUtil.setTotalRecord((int) page.getTotal());
			return commentList;
		}
		return commentDAO.getCommentList(articleID);
	}

}
