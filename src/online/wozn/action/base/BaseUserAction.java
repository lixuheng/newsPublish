package online.wozn.action.base;

import com.opensymphony.xwork2.ActionSupport;

import online.wozn.service.UserMgr;


public class BaseUserAction extends ActionSupport {
	protected UserMgr umgr;

	public UserMgr getUmgr() {
		return umgr;
	}

	public void setUmgr(UserMgr umgr) {
		this.umgr = umgr;
	}

}
