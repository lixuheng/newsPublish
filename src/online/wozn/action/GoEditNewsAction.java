package online.wozn.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import online.wozn.action.base.BaseNewsAction;
import online.wozn.domain.News;

public class GoEditNewsAction extends BaseNewsAction implements Action{
	private Integer news_id;
	public void setNews_id(Integer news_id){
		this.news_id = news_id;
	}
	public Integer getNews_id(){
		return news_id;
	}
	private News news;
	public News getNews(){
		return this.news;
	}
	public void setNews(News news){
		this.news = news;
	}
	@Override 
	public String execute(){
		news = nmgr.viewANews(news_id);
		ActionContext.getContext().put("news", news);
		return SUCCESS;
	}
}
