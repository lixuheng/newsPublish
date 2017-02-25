package online.wozn.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import online.wozn.action.base.BaseUserAction;
import online.wozn.domain.User;

public class RegAction extends BaseUserAction implements Action {
	private User user;
	private String authImg;
	private InputStream inputStream;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAuthImg() {
		return authImg;
	}

	public void setAuthImg(String authImg) {
		this.authImg = authImg;
	}
	
	

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("input user is" + this.user);
		System.out.println("do register begin");
		ActionContext ac = ActionContext.getContext();
		System.out.println(((String) (ac.getSession().get("rand"))));
		if (!((String) (ac.getSession().get("rand"))).equalsIgnoreCase(authImg)) {
			inputStream = new ByteArrayInputStream("验证码不正确！".getBytes("UTF-8"));
			return ERROR;
		} else {
			user.setLevel(1);
			if (umgr.doReg(user)) {
				inputStream = new ByteArrayInputStream("注册成功！".getBytes("UTF-8"));
				return SUCCESS;
			} else {
				inputStream = new ByteArrayInputStream("对不起，用户名、密码不匹配！".getBytes("UTF-8"));
			}
		}
		return ERROR;
	}
	
	public String isHadOneName(){
		System.out.println("校验重复姓名输入的user"+user);
		if(!umgr.isHadOne(user)){
			inputStream = new ByteArrayInputStream("false".getBytes());
		}else{
			inputStream = new ByteArrayInputStream("true".getBytes());
		}
		return SUCCESS;
	}

}
