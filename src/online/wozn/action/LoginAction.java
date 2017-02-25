package online.wozn.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import online.wozn.action.base.BaseUserAction;
import online.wozn.domain.User;

public class LoginAction extends BaseUserAction implements Action {
	private User user;
	private String authImg;
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

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

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("login is begin ");
		System.out.println(user);
		System.out.println(authImg);
		ActionContext ac = ActionContext.getContext();
		System.out.println(((String) (ac.getSession().get("rand"))));
		if (!((String) (ac.getSession().get("rand"))).equalsIgnoreCase(authImg)) {
			inputStream = new ByteArrayInputStream("验证码不正确！".getBytes("UTF-8"));
		} 
		else {
			// 判断用户名、密码，生成对应的响应
			if (umgr.doLogin(user)) {
				inputStream = new ByteArrayInputStream("恭喜你，登录成功!".getBytes("UTF-8"));
			} else {
				inputStream = new ByteArrayInputStream("对不起，用户名、密码不匹配！".getBytes("UTF-8"));
			}
		}
		return SUCCESS;
	}
	

}
