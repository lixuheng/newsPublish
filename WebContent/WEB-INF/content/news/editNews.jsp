<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<!-- 库文件 -->
<script type="text/javascript" src="facelib/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="facelib/bootstrap.min.css" />
<script type="text/javascript" src="facelib/bootstrap.min.js"></script>
<script type="text/javascript" src="facelib/wangEditor.js"></script>
<link rel="stylesheet" href="facelib/wangEditor.css" />
<link rel="stylesheet" href="css/startwangEditor.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改新闻</title>
</head>
<body>
	<!-- 导航和头部 -->
	<%@include file="../header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<h3>修改新闻</h3>
			</div>
		</div>
		<div id="info" class="row">
		<!-- method="post" action="alterNews" -->
			<form id="editNewsForm" 
				class="form-horizontal" role="form">
				<!--  新闻附加信息框-->
				<div id="news_inf" style="padding: 40px">
					<div class="row">
						<div class="col-md-5">
							<div class="form-group">
								<label for="text3" class="col-sm-2 control-label">标题</label>
								<div class="col-sm-10">
									<input type="hidden" name="news.news_id" value="${news.news_id}" />
									<input type="text" class="form-control" id="title"
										name="news.title" value="${news.title}" placeholder="标题">
								</div>
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<label for="text3" class="col-sm-2 control-label">类别</label>
								<div class="col-sm-10">
									<div class="row">
										<div class="col-md-3">
											<select name="news.type"
												style="border-color: #ddd; border-width: 2px; width: 100%; height: 40px; min-width: 100px;">
												<option value="" selected="true" disabled="true">选择分类</option>
												<option value="society">社会</option>
												<option value="military">军事</option>
												<option value="political">政治</option>
												<option value="technology">科技</option>
												<option value="fiance">财经</option>
												<option value="amusement">娱乐</option>
											</select>
										</div>
										<div class="col-md-3">&nbsp;</div>
										<div class="col-md-3">
											<select name="news.label"
												style="border-color: #ddd; width: 100%; border-width: 2px; height: 40px; min-width: 100px">
												<option value="" selected="true" disabled="true">选择板块</option>
												<option value="newcol">普通新闻</option>
												<option value="professional">专题</option>
												<option value="deep">深度</option>
												<option value="picture">图片介绍</option>
												<option value="pictureswitch">图片切换</option>
											</select>

										</div>
									</div>


								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-5">
							<div class="form-group">
								<label for="text3" class="col-sm-2 control-label">编者</label>
								<div class="col-sm-10">
									<input type="hidden" name="news.user.user_id" value="${news.user.user_id}" />
									<input type="text" class="form-control" id="author"
									readonly="readonly"	name="news.user.user_uname"  value="${news.user.uname}"  placeholder="编者">
								</div>
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<label for="text3" class="col-sm-2 control-label">时间</label>
								<div class="col-sm-10">
									<input type="datetime-local" class="form-control"
										name="arise_date" id="ariseTime" value="${news.arise_date}" >
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-5">
							<div class="form-group">
								<label for="text3" class="col-sm-2 control-label">地点</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="addr"
										name="news.place" value="${news.place}"  placeholder="发生地点">
								</div>
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<label for="text3" class="col-sm-2 control-label">来源</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="text3"
										name="news.source" value="${news.source}"  placeholder="新闻来源">
								</div>
							</div>
						</div>
					</div>


				</div>
				<!-- news info -->
				<!--  新闻编辑框 -->
				<div id="main" class="row">
					<div class="form-group">
						<div class="col-md-10">
							<div id="editor-container" class="container">
								<div id="editor-trigger">${news.content}</div>
								<script type="text/javascript" src="js/startwangEditor.js"></script>
							</div>
						</div>
					</div>
				</div>


				<div id="submitbox" class="row">
					<div class="col-md-10">
						<input type="submit" id="ok" onclick="return postaddnewsform();"
							class="btn btn-success" value="确认修改" />
						<input type="reset" id="cancel" onclick="quxiao();" class="btn" />
					</div>
				</div>
				<script type="text/javascript" src="js/editNews.js"></script>
			</form>
		</div>
	</div>
</body>
</html>