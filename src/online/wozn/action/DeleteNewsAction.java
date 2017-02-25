package online.wozn.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.Action;

import online.wozn.action.base.BaseNewsAction;
import online.wozn.domain.News;

public class DeleteNewsAction extends BaseNewsAction implements Action{
	private News news;
	private InputStream inputStream;
	public void setNews(News news){
		this.news = news;
	}
	
	public News getNews(){
		return this.news;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("delNews the news is "+news);
		if(nmgr.delNewsById(news)){
			inputStream = new ByteArrayInputStream("del_success".getBytes());
			return SUCCESS;
		}else{
			inputStream = new ByteArrayInputStream("del_error".getBytes());
			return ERROR;
		}
		
	}

}
