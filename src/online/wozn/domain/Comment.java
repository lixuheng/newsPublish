package online.wozn.domain;

import java.util.Date;

import javax.persistence.*;
@Entity
public class Comment {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer comment_id;
	@ManyToOne(targetEntity=User.class,cascade=CascadeType.REMOVE)
	@JoinTable(
			name="Comment_user",
			joinColumns=@JoinColumn(name="comment_id",
				referencedColumnName="comment_id"),
			inverseJoinColumns=@JoinColumn(name="user_id",
					referencedColumnName="user_id")
			)
	private User user;
	@ManyToOne(targetEntity=News.class,cascade=CascadeType.REMOVE)	
	@JoinTable(
			name="Comment_news",
			joinColumns=@JoinColumn(name="comment_id",
				referencedColumnName="comment_id"),
			inverseJoinColumns=@JoinColumn(name="news_id",
					referencedColumnName="news_id")
			)
	private News news;
	@Column(nullable=false)
	private String content;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date c_Date;
	
	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", user=" + user + ", news=" + news + ", content=" + content
				+ ", c_Date=" + c_Date + "]";
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean b= false;
		if(obj==null)
			return b;
		if(obj instanceof Comment == false)
			return b;
		if(((Comment)obj).toString().equals(this.toString())){
			b=true;
		}
		return b;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return comment_id + super.hashCode();
	}

	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getC_Date() {
		return c_Date;
	}

	public void setC_Date(Date c_Date) {
		this.c_Date = c_Date;
	}
	
	
	

	
}
