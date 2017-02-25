package online.wozn.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import online.wozn.action.base.BaseNewsAction;
import online.wozn.domain.News;

public class SearchNewsAction extends BaseNewsAction implements Action {
	private News news;
	private String keyWord;
	
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@Override
	public String execute() throws Exception {
		List<News>  searchNews = nmgr.searchNewsByPage(1, 10, keyWord);
		ActionContext.getContext().put("searchNews", searchNews);
		return SUCCESS;
	}
	
}
