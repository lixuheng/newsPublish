package online.wozn.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import online.wozn.action.base.BaseNewsAction;
import online.wozn.domain.News;
import online.wozn.domain.User;
import online.wozn.vo.Picture;

public class FirstLoad extends BaseNewsAction implements Action {
	private User user;
	private News news;
	private String type;
	private static final Integer PS = 10;
	private Integer pn = 1;

	@Override
	public String execute() throws Exception {
		System.out.println("haha  index");
		// newsSysManager.getNewsDao().getSessionFactory().openSession();
		System.out.println("type = " + type);
		if (type == null || "".equals(type) || "null".equals(type)) {
			type = "society";
		}
		// 热点新闻
		List<News> hotnews = nmgr.selectHotNews( PS);
		// newcol栏新闻
		List<News> newcolList = nmgr.selectNewColNewsByPage(pn,PS,type);
		// professional栏新闻
		List<News> professionalList = nmgr.selectProfessionalNewsByPage(pn,PS,type);
		// deep栏新闻
		List<News> deepList = nmgr.selectDeepNewsByPage(pn,PS,type);
		// 图片新闻
		List<News> pictureList = nmgr.selectPictureNewsByPage(pn,PS,type);
		// 图片滚播新闻
		List<News> pictureswitchList = nmgr.selectPictureSWNewsByPage(pn,PS,type);
		String[] urlsplit = null;
		String[] contentsplit = null;
		News switchNews = null;
		List<Picture> pictureView=null;
		if (pictureswitchList != null && pictureswitchList.size() > 0) {
			switchNews = pictureswitchList.get(0);
			try {
				urlsplit = switchNews.getPicture_url().split("\\|\\|");
				contentsplit=switchNews.getContent().split("\\|\\|");
				pictureView = new ArrayList<Picture>();
				for(int i=0 ;i< urlsplit.length ;i++){
					Picture picture = new Picture();
					picture.setUrl(urlsplit[i]);
					picture.setContentPart ( contentsplit[i]);
					pictureView.add(picture);
				}
			} catch (NullPointerException e) {
				System.out.println("没有内容");
			} catch (ArrayIndexOutOfBoundsException r){
				System.out.println("图片张数和内容描述不匹配");
			}
		}
		
		ActionContext ac = ActionContext.getContext();
		ac.put("hotnews", hotnews);
		ac.put("newcolList", newcolList);
		ac.put("professionalList", professionalList);
		ac.put("deepList", deepList);
		ac.put("pictureList", pictureList);
		ac.put("switchNews", switchNews);
		ac.put("pictureView", pictureView);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPn() {
		return pn;
	}

	public void setPn(Integer pn) {
		this.pn = pn;
	}

}


