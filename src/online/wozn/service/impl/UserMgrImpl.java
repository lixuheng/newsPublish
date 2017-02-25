package online.wozn.service.impl;

import java.io.ByteArrayInputStream;

import com.opensymphony.xwork2.ActionContext;

import online.wozn.dao.impl.CommentDao;
import online.wozn.dao.impl.NewsDao;
import online.wozn.dao.impl.UserDao;
import online.wozn.domain.User;
import online.wozn.service.UserMgr;

public class UserMgrImpl implements UserMgr {
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
	public boolean isHadOne(User user) {
		if (getUserDao().selectByUname(user.getUname()) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean doLogin(User user) {
		// 判断用户名、密码，生成对应的响应
		ActionContext ac = ActionContext.getContext();
		User u = getUserDao().selectByUnamePwd(user);
		System.out.println("u is " + u);
		if (u != null && u.getLevel() != null && u.getLevel() > 0) {
			ac.getSession().put("user", u);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean doReg(User user) {
		user.setLevel(1);
		if (getUserDao().save(user).toString() != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean selectUserByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delUserByUname(String uname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delUserById(String user_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
