package online.wozn.action.base;

import com.opensymphony.xwork2.ActionSupport;

import online.wozn.service.NewsMgr;

public class BaseNewsAction extends ActionSupport {

	protected NewsMgr nmgr;

	public NewsMgr getNmgr() {
		return nmgr;
	}

	public void setNmgr(NewsMgr nmgr) {
		this.nmgr = nmgr;
	}

}
