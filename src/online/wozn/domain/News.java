package online.wozn.domain;

import java.util.Date;

import javax.persistence.*;
@Entity
public class News {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer news_id;
	@Column(length=255)
	private String title;
	@Lob
	private String content;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date arise_date;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date last_modify_date;
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinTable(
			name="news_user",
			joinColumns=@JoinColumn(name="news_id",
				referencedColumnName="news_id"),
			inverseJoinColumns=@JoinColumn(name="user_id",
					referencedColumnName="user_id")
			)
	private User user;
	@Column(length=20)
	private String type;//类别
	@Column(length=80)
	private String place;//发生地
	@Column(length=20)
	private String source;//新闻来源  原创 、新浪、头条、网易等
	private Integer clickCount;//点击量
	@Column(length=40)
	private String label;//标签
	@Lob
	private String picture_url;
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean b= false;
		if(obj==null)
			return b;
		if(obj instanceof News == false)
			return b;
		if(((News)obj).toString().equals(this.toString())){
			b=true;
		}
		return b;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return news_id+super.hashCode();
	}
	
	
	
	@Override
	public String toString() {
		return "News [news_id=" + news_id + ", title=" + title + ", content=" + content + ", arise_date=" + arise_date
				+ ", last_modify_date=" + last_modify_date + ", user=" + user + ", type=" + type + ", place=" + place
				+ ", source=" + source + ", clickCount=" + clickCount + ", label=" + label + ", picture_url="
				+ picture_url + "]";
	}

	public Integer getNews_id() {
		return news_id;
	}
	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getArise_date() {
		return arise_date;
	}
	public void setArise_date(Date arise_date) {
		this.arise_date = arise_date;
	}
	public Date getLast_modify_date() {
		return last_modify_date;
	}
	public void setLast_modify_date(Date last_modify_date) {
		this.last_modify_date = last_modify_date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Integer getClickCount() {
		return clickCount;
	}
	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}


	
	
}
