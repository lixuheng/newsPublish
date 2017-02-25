package online.wozn.service;

import online.wozn.domain.User;

public interface UserMgr {
	boolean isHadOne(User user);
	boolean doLogin(User user);
	boolean doReg(User user);
	boolean selectUserByPage(int pageNo, int pageSize);
	boolean delUserByUname(String uname);
	boolean delUserById(String user_id);
	boolean updateUser(User user);
}
