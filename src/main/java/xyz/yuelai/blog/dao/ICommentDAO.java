package xyz.yuelai.blog.dao;

import java.util.List;

import xyz.yuelai.blog.entity.Comment;

public interface ICommentDAO {

	
	int saveComment(Comment comment);

	
	List<Comment> getCommentList(Integer articleID);
}
