package online.wozn.service;
import java.util.List;

import online.wozn.domain.Comment;

public interface CommentMgr {
	List<Comment> selectCommentByNews(int pageNo, int pageSize,Integer news_id);
	List<Comment> selectCommnetByUser(int pageNo, int pageSize ,Integer user_id);
	boolean saveAComment(Comment comment);
}
