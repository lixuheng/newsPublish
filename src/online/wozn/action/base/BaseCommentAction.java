package online.wozn.action.base;

import com.opensymphony.xwork2.ActionSupport;

import online.wozn.service.CommentMgr;

public class BaseCommentAction  extends ActionSupport{
	
	protected CommentMgr cmgr;

	public CommentMgr getCmgr() {
		return cmgr;
	}

	public void setCmgr(CommentMgr cmgr) {
		this.cmgr = cmgr;
	}
	
	
}
