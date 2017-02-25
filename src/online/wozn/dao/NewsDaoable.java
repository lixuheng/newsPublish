package online.wozn.dao;

import java.util.List;

import online.wozn.common.dao.BaseDaoable;
import online.wozn.domain.Comment;
import online.wozn.domain.News;
import online.wozn.domain.User;

public interface NewsDaoable extends BaseDaoable<News>{
	News selectById(Integer news_id);
	//按照标题查询新闻
	List<News> selectByTitle(String title);
	//按照作者查询新闻
	List<News> selectByUser(User user);
	//按照新闻内容查询新闻
	List<News> selectByContent(String Content);
	//按主键更新实体 
	boolean updateById(News news);
	//根据ID删除实体
	boolean deleteById(Integer id);
}
