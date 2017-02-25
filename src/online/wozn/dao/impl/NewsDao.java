package online.wozn.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import online.wozn.common.dao.impl.BaseDao;
import online.wozn.dao.NewsDaoable;
import online.wozn.domain.Comment;
import online.wozn.domain.News;
import online.wozn.domain.User;

public class NewsDao  extends BaseDao<News>  implements NewsDaoable {

	@Override
	public List<News> selectByTitle(String title) {
		List<News> nlist = find("select n from News n where n.title like ?0","%"+title+"%");
		if(nlist!=null && nlist.size()>0){
			return nlist;
		}
		return null;
	}

	@Override
	public List<News> selectByUser(User user) {
		List<News> nlist = find("select n from News n  inner join n.user u where u.user_id =?0",user.getUser_id());
		if(nlist!=null && nlist.size()>0){
			return nlist;
		}
		return null;
	}

	@Override
	public List<News> selectByContent(String content) {
		System.out.println("content is "+content);
		List<News> nlist = find("select distinct n from News n where n.content like ?0 or n.title like ?0","%"+content+"%");
		if(nlist!=null && nlist.size()>0){
			return nlist;
		}
		return null;
	}

	@Override
	public News selectById(Integer news_id) {
		List<News> nlist = find("select n from News n where n.news_id=?0",news_id);
		if(nlist!=null && nlist.size()>0){
			return nlist.get(0);
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteById(Integer id) {
		Session session = sessionFactory
				.openSession();
		Query query2 = session.createQuery("delete News n where n.news_id = ?0 ");
		query2.setParameter(0+"", id);
		if(query2.executeUpdate()>0){
			return true;
		}
		return false;
	}
	//有问题
	@SuppressWarnings("unchecked")
	@Override
	public boolean updateById(News news) {
		// TODO Auto-generated method stub
		Session session = sessionFactory
				.openSession();
		String sql = "update News as n set n.title=?0 n.arise_date=?1 n.last_modify_date=?2 n.label=?3 n.place=?4"
				+ " n.type = ?5 n.picture_url=?6 n.clickCount=?7 n.content=?8 "
				+ " where n.news_id =?9 ";
		Query query2 = session.createQuery(sql);
		query2.setParameter(0+"", news.getTitle());
		query2.setParameter(1+"", news.getArise_date());
		query2.setParameter(2+"", news.getLast_modify_date());
		query2.setParameter(3+"", news.getLabel());
		query2.setParameter(4+"", news.getPlace());
		query2.setParameter(5+"", news.getType());
		query2.setParameter(6+"", news.getPicture_url());
		query2.setParameter(7+"", news.getClickCount());
		query2.setParameter(8+"", news.getContent());
		query2.setParameter(9+"", news.getNews_id());
		if(query2.executeUpdate()>0){
			return true;
		}
		return false;
	}
	
	
}
