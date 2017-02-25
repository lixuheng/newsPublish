package online.wozn.service;
import java.io.Serializable;
import java.util.List;

import online.wozn.domain.Comment;
import online.wozn.domain.News;

public interface NewsMgr {
	List<News> selectNewsByPage(int pageNo, int pageSize);
	List<News> selectHotNews(int topN);
	List<News> selectNewColNewsByPage(int pageNo, int pageSize , String type);
	List<News> selectDeepNewsByPage(int pageNo, int pageSize, String type);
	List<News> selectProfessionalNewsByPage(int pageNo, int pageSize, String type);
	List<News> selectPictureNewsByPage(int pageNo, int pageSize, String type);
	List<News> selectPictureSWNewsByPage(int pageNo, int pageSize, String type);
	List<News> searchNewsByPage(int pageNo, int pageSize, String keyword);
	List<News> viewPWNewsByPage(int pageNo, int pageSize, Integer news_id);
	List<Comment> getCommentByNewsId(Integer news_id);
	News viewANews(Integer news_id);
	boolean delNewsById(News news);
	boolean delNewsByAuthor(String author_user);
	boolean updateNews(News news);
	boolean saveANews(News news);

}
