<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 库文件 -->
<script type="text/javascript" src="facelib/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="facelib/bootstrap.min.css" />
<script type="text/javascript" src="facelib/bootstrap.min.js"></script>
<script type="text/javascript" src="facelib/wangEditor.js"></script>
<link rel="stylesheet" href="facelib/wangEditor.css" />
<link rel="stylesheet" href="css/startwangEditor.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>搜索结果</title>
</head>
<body>
	<!-- 导航和头部 -->
	<%@include file="../header.jsp"%>
	<br/><br/>
	<div class="list-group">
		<s:iterator value="searchNews" id="news" status="st">
			<a href="newsview?news_id=${news.news_id}" class="list-group-item "> ${news.title}</a>
		</s:iterator>
	</div>
</body>
</html>