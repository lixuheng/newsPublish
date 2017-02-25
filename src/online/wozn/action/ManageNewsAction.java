package online.wozn.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import online.wozn.action.base.BaseNewsAction;
import online.wozn.domain.News;

public class ManageNewsAction extends BaseNewsAction implements Action{
	private News news;
	private static final Integer PZ = 5;
	private Integer pn;
	
	

	public Integer getPn() {
		return pn;
	}

	public void setPn(Integer pn) {
		this.pn = pn;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("begin news manage");
		List<News> nlist = nmgr.selectNewsByPage( pn, PZ);
		ActionContext.getContext().put("nlist", nlist);
		System.out.println(nlist);
		return super.execute();
	}
	
	

}
