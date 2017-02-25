package online.wozn.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.jws.soap.SOAPBinding.Use;

import com.opensymphony.xwork2.Action;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import online.wozn.action.base.BaseCommentAction;
import online.wozn.domain.Comment;
import online.wozn.domain.News;

public class AddCommentAction extends BaseCommentAction implements Action {
	private Comment comment;
	private InputStream inputStream;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() {
		System.out.println("do add comment now");
		System.out.println("Comment is " + comment);
		cmgr.saveAComment(comment);
		inputStream = new ByteArrayInputStream("add_comment_success".getBytes());
		return SUCCESS;
	}

}
