package online.wozn.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import online.wozn.common.dao.impl.BaseDao;
import online.wozn.dao.CommentDaoable;
import online.wozn.domain.Comment;
import online.wozn.domain.User;

public class CommentDao extends BaseDao<Comment> implements CommentDaoable {

	@Override
	public List<Comment> selectByContent(String content) {
		List<Comment> clist = find("select c from Comment c where c.content list ?0", "%" + content + "%");
		if (clist != null && clist.size() > 0) {
			return clist;
		}
		return null;
	}

	@Override
	public List<Comment> selectByUser(User user) {
		List<Comment> clist = find("select c from Comment c join c.user u where u.user_id = ?0", user.getUser_id());
		if (clist != null && clist.size() > 0) {
			return clist;
		}
		return null;
	}

	@Override
	public Comment selectById(Integer comment_id) {
		List<Comment> clist = find("select c from Comment c where c.comment_id = ?0", comment_id);
		if (clist != null && clist.size() > 0) {
			return clist.get(0);
		}
		return null;
	}

	@Override
	public List<Comment> selectByNews(Integer news_id) {
		List<Comment> clist = find("select c from Comment c join c.news n where n.news_id = ?0", news_id);
		if (clist != null && clist.size() > 0) {
			return clist;
		}
		return null;
	}



	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query2 = session.createQuery("delete Comment c where c.comment_id = ?0 ");
		query2.setParameter(0 + "", id);
		if (query2.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteByUserName(String uname) {
		Session session = sessionFactory.openSession();
		Query query2 = session.createQuery("delete Comment c where c.user.uname = ?0 ");
		query2.setParameter(0 + "", uname);
		if (query2.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteByNewsId(Integer news_id) {
		Session session = sessionFactory.openSession();
		Query query2 = session.createQuery("delete Comment c where c.news.news_id = ?0 ");
		query2.setParameter(0 + "", news_id);
		if (query2.executeUpdate() > 0) {
			return true;
		}
		return false;
	}



}
