package online.wozn.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import online.wozn.action.base.BaseNewsAction;
import online.wozn.domain.Comment;
import online.wozn.domain.News;

public class NewsView extends BaseNewsAction implements Action{
	private Integer news_id;
	public void setNews_id(Integer news_id){
		this.news_id = news_id;
	}
	
	public Integer getNews_id(){
		return this.news_id;
	}

	@Override
	public String execute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		System.out.println("news_id is "+news_id);
		System.out.println("开始检索一条新闻");
		News news = nmgr.viewANews(news_id);
		List<Comment> clist =nmgr.getCommentByNewsId(news_id);
		System.out.println("NewsView'news is "+news);
		System.out.println("NewsView'clist is "+clist);
		ac.put("anews",news);
		ac.put("anewsComment", clist);
		return SUCCESS;
	}


	
	
	
}
