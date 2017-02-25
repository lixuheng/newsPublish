package online.wozn.service.impl;
import java.util.List;

import online.wozn.dao.impl.CommentDao;
import online.wozn.dao.impl.NewsDao;
import online.wozn.dao.impl.UserDao;
import online.wozn.domain.Comment;
import online.wozn.domain.News;
import online.wozn.service.*;
public class NewsMgrImpl implements NewsMgr{
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
	public List<News> selectNewsByPage(int pageNo, int pageSize) {
		return getNewsDao().findByPage("select n from News n", pageNo, pageSize);
	}

	@Override
	public List<News> selectHotNews(int topN) {
		return getNewsDao().findByPage("select n from News n  order by clickCount desc",1,topN);
	}

	@Override
	public List<News> selectNewColNewsByPage(int pageNo, int pageSize, String type) {
		return getNewsDao().findByPage("select n from News n where n.type=?0 and n.label=?1 ", pageNo, pageSize, type, "newcol");
	}

	@Override
	public List<News> selectProfessionalNewsByPage(int pageNo, int pageSize, String type) {
		return getNewsDao().findByPage("select n from News n where n.type=?0 and n.label=?1 ", pageNo, pageSize, type, "professional");
	}
	@Override
	public List<News> selectDeepNewsByPage(int pageNo, int pageSize, String type) {
		return getNewsDao().findByPage("select n from News n where n.type=?0 and n.label=?1 ", pageNo, pageSize, type, "deep");
	}

	@Override
	public List<News> selectPictureNewsByPage(int pageNo, int pageSize, String type) {
		return getNewsDao().findByPage("select n from News n where n.type=?0 and n.label=?1 ", pageNo, pageSize, type, "picture");
	}

	@Override
	public List<News> selectPictureSWNewsByPage(int pageNo, int pageSize, String type) {
		return getNewsDao().findByPage("select n from News n where n.type=?0 and n.label=?1 ", pageNo, pageSize, type, "pictureswitch");
	}

	@Override
	public List<News> searchNewsByPage(int pageNo, int pageSize, String keyword) {
		return getNewsDao().findByPage("select distinct n from News n where n.content like ?0 or n.title like ?0",pageNo, pageSize,"%"+keyword+"%");
	}

	@Override
	public List<News> viewPWNewsByPage(int pageNo, int pageSize, Integer news_id) {
		return getNewsDao().findByPage("select distinct n from News n where n.news_id=?0",pageNo, pageSize,news_id);
	}

	@Override
	public News viewANews(Integer news_id) {
		return getNewsDao().selectById(news_id);
	}
	public List<Comment> getCommentByNewsId(Integer news_id){
		return getCommentDao().selectByNews(news_id);
	}

	@Override
	public boolean delNewsById(News news) {
		boolean a = getCommentDao().deleteByNewsId(news.getNews_id());
		boolean b = getNewsDao().deleteById(news.getNews_id());
		if(a&b){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delNewsByAuthor(String author_user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateNews(News news) {
		getNewsDao().update(news);
		return true;
	}

	@Override
	public boolean saveANews(News news) {
		if(getNewsDao().save(news)!=null){
			return true;
		}
		return false;
	}
	


}
