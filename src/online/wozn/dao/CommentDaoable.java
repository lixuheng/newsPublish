package online.wozn.dao;

import java.util.List;

import online.wozn.common.dao.BaseDaoable;
import online.wozn.domain.Comment;
import online.wozn.domain.News;
import online.wozn.domain.User;

public interface CommentDaoable extends BaseDaoable<Comment> {
	Comment selectById(Integer comment_id);

	// 按照评论内容查询
	List<Comment> selectByContent(String content);

	// 按照用户查询评论
	List<Comment> selectByUser(User usre);

	List<Comment> selectByNews(Integer news_id);

	// 根据ID删除实体
	boolean deleteById(Integer id);
	
	//根据用户删除评论
	boolean deleteByUserName(String uname);
	//根据新闻删除评论
	boolean deleteByNewsId(Integer news_id);
}
