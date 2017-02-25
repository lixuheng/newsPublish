package online.wozn.service.impl;

import java.util.List;

import online.wozn.dao.impl.CommentDao;
import online.wozn.dao.impl.NewsDao;
import online.wozn.dao.impl.UserDao;
import online.wozn.domain.Comment;
import online.wozn.service.CommentMgr;

public class CommentMgrImpl implements CommentMgr{
	protected UserDao userDao;
	protected NewsDao newsDao;
	protected CommentDao commentDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public List<Comment> selectCommentByNews(int pageNo, int pageSize, Integer news_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> selectCommnetByUser(int pageNo, int pageSize, Integer user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveAComment(Comment comment) {
		if(getCommentDao().save(comment)!=null){
			return true;
		}else{
			return false;
		}
	}
	
}
