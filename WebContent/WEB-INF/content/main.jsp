<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 库文件 -->
<script type="text/javascript" src="facelib/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="facelib/bootstrap.min.css" />
<script type="text/javascript" src="facelib/bootstrap.min.js"></script>

<title>新闻发布系统</title>
<%@taglib prefix="s" uri="/struts-tags"%>
</head>
<body style="padding: 10px">
	<div id="bigbox">
		<!-- 导航和头部 -->
		<%@include file="header.jsp"%>
		<div id="main" class="row">
			<div id="left-box" class="col-md-2">
				<h3 class="center" style="color: blue;">热点新闻</h3>
				<div class="list-group">
					<s:iterator value="hotnews" id="hotit" status="st">
						<!-- <s:if test="#st.odd">active</s:if> -->
						<a href="newsview?news_id=${hotit.news_id}"
							class="list-group-item "> ${hotit.title}</a>
					</s:iterator>
				</div>
			</div>
			<div id="middel-box" class="col-md-8">
				<h3 style="color: blue;">看天下</h3>
				<!-- img-news -->
				<ul class="nav nav-tabs" role="tablist">
					<li id="newcol" class="active" role="presentation"><a href="#">新闻</a></li>
					<li id="professional" role="presentation"><a href="#">专访</a></li>
					<li id="deep" role="presentation"><a href="#">深度</a></li>
				</ul>
				<div id="module1">
					<div id="right-up-box1">
						<div class="list-group">
							<s:iterator value="newcolList" id="news" status="st">
								<!-- <s:else>${typeit.label } <s:property value="#typeit.label"/></s:else> <s:if test="#st.odd">active</s:if>-->
								<a href="newsview?news_id=${news.news_id}"
									class="list-group-item "> ${news.title}</a>
							</s:iterator>
						</div>
					</div>
					<div id="right-down-box1">
						<nav>
						<ul class="pagination">
							<li><a href="#">&laquo;</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
						</nav>
					</div>
				</div>

				<div id="module2" style="display: none">
					<div id="right-up-box2">
						<div class="list-group">
							<s:iterator value="professionalList" id="news" status="st">
								<!-- <s:else>${typeit.label } <s:property value="#typeit.label"/></s:else> <s:if test="#st.odd">active</s:if> -->
								<a href="newsview?news_id=${news.news_id}"
									class="list-group-item "> ${news.title}</a>
							</s:iterator>
						</div>
					</div>
					<div id="right-down-box2">
						<nav>
						<ul class="pagination">
							<li><a href="#">&laquo;</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
						</nav>
					</div>

				</div>
				<!--module2 -->


				<div id="module3" style="display: none">
					<div id="right-up-box2">
						<div class="list-group">
							<s:iterator value="deepList" id="news" status="st">
								<!-- <s:else>${typeit.label } <s:property value="#typeit.label"/></s:else>  <s:if test="#st.odd">active</s:if> -->
								<a href="newsview?news_id=${news.news_id}"
									class="list-group-item "> ${news.title}</a>
							</s:iterator>
						</div>
					</div>
					<div id="right-down-box2">
						<nav>
						<ul class="pagination">
							<li><a href="#">&laquo;</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
						</nav>
					</div>

				</div>
				<!--module3 -->
				<script type="text/javascript" src="js/main.js"></script>
				<h3 class="center" style="color: blue;">图片新闻</h3>

				<s:iterator value="pictureList" id="news" status="st">
					<div id="img-news" class="row">
						<div class="col-sm-6 col-md-4">
							<div class="thumbnail">
								<img width=300px height=300px src="${news.picture_url }" />
								<!-- <img data-src="holder.js/300x300" alt=""> -->
								<div class="caption">
									<h3>${news.title }</h3>
									<p>${news.content}</p>
								</div>
							</div>
						</div>
					</div>
				</s:iterator>
			</div>
			<!--middle-box -->

			
			<div id="right-box" class="row">
				<h3 style="color: blue;">新闻滚播</h3>
				<s:iterator value="switchNews">
				<div class="col-md-2">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<s:iterator value="pictureView" id="pic" status="st">
								<s:if test="#st.index == 0">
									<div class="item active">
										<img src="${pic.url}">
										<div class="carousel-caption">${pic.contentPart }</div>
									</div>
								</s:if>
								<s:else>
									<div class="item">
										<img src="${pic.url}">
										<div class="carousel-caption">${pic.contentPart }</div>
									</div>
								</s:else>
							</s:iterator>
						</div>
						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							role="button" data-slide="prev"> <span
							class="glypicon glyphicon-chevron-left"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>


				</div>
				</s:iterator>
			</div>
		</div>
		<!-- main -->
		<div id="bottom"></div>
	</div>

</body>
</html>