package online.wozn.dao;

import java.util.List;

import online.wozn.common.dao.BaseDaoable;
import online.wozn.domain.User;

public interface UserDaoable extends BaseDaoable<User>{
	User selectById(Integer user_id);
	//按姓名和密码查询一个用户 
	User selectByUnamePwd(User user);
	//按照姓名查询用户
	User selectByUname(String uname);
	//根据ID删除实体
	boolean deleteById(Integer id);
}
