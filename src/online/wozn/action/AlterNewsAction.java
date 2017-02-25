package online.wozn.action;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import com.opensymphony.xwork2.Action;

import online.wozn.action.base.BaseNewsAction;
import online.wozn.domain.News;

public class AlterNewsAction extends BaseNewsAction implements Action {
	private InputStream inputStream;
	private News news;

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() {
		System.out.println("update news "+news);
		news.setLast_modify_date(new Date());
		nmgr.updateNews(news);
		inputStream = new ByteArrayInputStream("success".getBytes());
		return SUCCESS;
	}

}
