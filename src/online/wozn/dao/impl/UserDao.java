package online.wozn.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import online.wozn.common.dao.impl.BaseDao;
import online.wozn.dao.UserDaoable;
import online.wozn.domain.User;

public class UserDao  extends BaseDao<User>  implements UserDaoable {

	@Override
	public User selectByUname(String uname) {
		List<User> ulist = find("select u from User u where u.uname=?0",uname);
		if(ulist!=null && ulist.size()>0){
			return ulist.get(0);
		}
		return null;
	}

	@Override
	public User selectByUnamePwd(User user) {
		List<User> ulist = find("select u from User u where u.uname=?0 and u.pwd=?1",user.getUname(),user.getPwd());
		if(ulist!=null && ulist.size()>0){
			return ulist.get(0);
		}
		return null;
	}

	@Override
	public User selectById(Integer user_id) {
		List<User> ulist = find("select u from User u where u.user_id=?0",user_id);
		if(ulist!=null && ulist.size()>0){
			return ulist.get(0);
		}
		return null;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
				Session session = sessionFactory
						.openSession();
				Query query2 = session.createQuery("delet User u where u.user_id = ?0 ");
				query2.setParameter(0+"", id);
				if(query2.executeUpdate()>0){
					return true;
				}
				return false;
	}
	
	
	
	


}
