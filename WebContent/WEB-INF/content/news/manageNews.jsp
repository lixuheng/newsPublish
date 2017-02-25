<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 库文件 -->
<script type="text/javascript" src="facelib/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="facelib/bootstrap.min.css" />
<script type="text/javascript" src="facelib/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻管理</title>
</head>
<body style="padding: 20px">
	<!-- 导航和头部 -->
	<%@include file="../header.jsp"%>
	<table class="table table-hover table-bordered table-responsive">
		<caption>
			<h3>新闻管理</h3>
		</caption>
		<thead>
			<tr style="background: #eee">
				<th>序号</th>
				<th>ID</th>
				<th>标题</th>
				<th>作者</th>
				<th>分类</th>
				<th>版块</th>
				<th>时间</th>
				<th>地点</th>
				<th>来源</th>
				<th colspan="2" align="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#nlist" id="news" status="st">
				<tr id="${news.news_id }">
					<td>${st.index +1}</td>
					<td>${news.news_id }</td>
					<td><a href="newsview?news_id=${news.news_id}"
							class="list-group-item "> ${news.title}</a></td>
					<td>${news.user.uname }</td>
					<td>${news.type }</td>
					<td>${news.label }</td>
					<td>${news.arise_date }</td>
					<td>${news.place }</td>
					<td>${news.source }</td>

					<td><button value="${news.news_id }"
							class="btn btn-sm btn-success">编辑</button></td>
					<td><button value="${news.news_id }"
							class="btn btn-sm btn-warning">删除</button></td>
				</tr>
	
			</s:iterator>
		</tbody>
	</table>
<script type="text/javascript" src="js/newsM.js">
				</script>
	<nav>
	<ul class="pagination">
		<li><a href="#">&laquo;</a></li>
		<li><a href="manageNews?pn=1">1</a></li>
		<li><a href="manageNews?pn=2">2</a></li>
		<li><a href="manageNews?pn=3">3</a></li>
		<li><a href="manageNews?pn=4">4</a></li>
		<li><a href="manageNews?pn=5">5</a></li>
		<li><a href="#">&raquo;</a></li>
	</ul>
	</nav>

</body>
</html>