<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 库文件 -->
<script type="text/javascript" src="facelib/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="facelib/bootstrap.min.css" />
<script type="text/javascript" src="facelib/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻详情</title>
</head>
<body style="padding: 20px">
	<!-- 导航和头部 -->
	<%@include file="../header.jsp"%>
	<div class="page-header">
		<center>
			<h1>${anews.title }</h1>
		</center>
	</div>
		来源：${anews.source}&nbsp;&nbsp;
		作者:${anews.user.uname}&nbsp;&nbsp;
		发生时间：${anews.arise_date}&nbsp;&nbsp;
		发生地点：${anews.place}&nbsp;&nbsp;
<br/><br/>
	<div class="bs-example bs-example-tabs">
		<ul id="myTab" class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active"><a href="#home"
				id="home-tab" role="tab" data-toggle="tab" aria-controls="home"
				aria-expanded="false">新闻详情</a></li>

			<li role="presentation" class=""><a href="#profile" role="tab"
				id="profile-tab" data-toggle="tab" aria-controls="profile"
				aria-expanded="true">热门评论</a></li>

			<li role="presentation" class=""><a href="#docoment" role="tab"
				id="profile-tab" data-toggle="tab" aria-controls="profile"
				aria-expanded="true">我有话说</a></li>

		</ul>
		<div id="myTabContent" class="tab-content">
			<div role="tabpanel" class="tab-pane active in" id="home"
				aria-labelledby="home-tab">
				<div style="margin: 0px 40px 0px 10px">
					<p>
					<!--  escape = false  原样输出html不进行转义-->
						<s:property value="#anews.content" escape="false"/>
					</p>
				</div>

			</div>


			<div role="tabpanel" class="tab-pane fade  in" id="profile"
				aria-labelledby="profile-tab">
				<s:iterator value="#anewsComment" id="commentit">
					<div class="media">
						<a class="media-left media-middle" href="#"> <img
							data-src="..." alt="...">
						</a>
						<a href="#"> ${commentit.user.uname} </a>
						${commentit.content }
						<!-- <div class="media-body"></div> -->
					</div>
				</s:iterator>
			</div>


			<div role="tabpanel" class="tab-pane fade" id="docoment"
				aria-labelledby="home-tab">
				<s:if test="#session.user!=null">
					<form id="docommentform">
						<textarea id="content" rows="5" cols="100"
							style="resize: none; overflow: auto">
						</textarea>
						<br /> 
						<input type="hidden" id="contentH" name="comment.content" />
						<script type="text/javascript">
						$("#content").focusin(function(){
							$("#content").empty();
							//alert("in");
							$("#content").focusout(function(){
								//alert("out");
								$("#contentH")
									.val($("#content").val());
								//alert($("#content").val());
							})
						})
						</script>
						<input type="hidden" name="comment.user.user_id" value="${session.user.user_id}" /> 
						<input type="hidden" name="comment.news.news_id" value="${anews.news_id }" /> 
						<input
							class="btn btn-info" type="submit" value="提交" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							class="btn btn-default" type="reset" value="重置" />
					</form>
					<script type="text/javascript">
						$("#docommentform").on("submit",function(){
							$.ajax({
								cache:true,
								type:"post",
								url:"addComment",
								dataType:"text",
								data: $("#docommentform").serialize(),
								error:function(error){
									console.log(error);
									alert("后台错误");
								},
								success: function(success){
									//alert("ok")
									if(success=="add_comment_success"){
										alert("评论成功");
									}else{
										alert("评论失败");
									}
								},
								async:false
							});
							return false;
						})
					
					</script>
				</s:if>
				<s:else>
					<h4>请先登录</h4>
				</s:else>
			</div>

		</div>
	</div>
</body>
</html>