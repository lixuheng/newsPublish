<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div id="header"></div>
<div id="navigate" class="container">
	<br /> <br /> <br /> <br />
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> <img alt="Brand"
					src="images/brand.jpg">
				</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul id="navigationUL" class="nav navbar-nav">
					<li class="active"><a href='index?type=society'>社会</a></li>
					<li><a href='index?type=military'>军事</a></li>
					<li><a href='index?type=political'>政治</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">更多 <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href='index?type=technology'>科技</a></li>
							<li><a href='index?type=fiance'>财经</a></li>
							<li><a href='index?type=amusement'>娱乐</a></li>
						</ul></li>
				</ul>
				
				<script >
				/*
					var str = 'index?type=';
					str+='<s:property value="#request.type" />';
					alert(str);
					$('#navigationUL a').parent().attr("class","active");
					*/
				</script>
				
				<form action="searchNews" class="navbar-form navbar-left" role="新闻搜索">
					<div class="form-group">
						<input type="text" name="keyWord" class="form-control" placeholder="新闻搜索">
					</div>
					<button type="submit" class="btn btn-success">搜索</button>
				</form>
				

				<ul id="userbar" class="nav navbar-nav navbar-right">
				<!--<s:property value="这是什么事情"/>
				<s:property value="#session.user"/>
				<s:property value="session.user"/>  -->
					<s:if test="#session.user.level>0">
						<s:if test="#session.user.level>5">
							<li><a href="news_addNews">发布新闻</a></li>
							<li><a href="manageNews?pn=1">新闻管理</a></li>
						</s:if>
						<li><a href="logout">注销</a></li>
						<li><a href="index">首页</a></li>
					</s:if>
					<s:else>
					<li><a href="index">首页</a></li>
					<li><a href="#">
							<button id="toLoginbtn" onclick="chlogin()" type="button" class="btn btn-default btn-sm"
								data-toggle="modal" data-target="#staticModal">登录</button>
					</a></li>
					<li><a href="#">
							<button id="toregbtn" onclick="chreg()" type="button" class="btn btn-default btn-sm"
								data-toggle="modal" data-target="#staticModal">注册</button>
					</a></li>
					</s:else>
				</ul>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</div>
	<%@include file="user/login.jsp"%>
	<script type="text/javascript" src="js/postForm.js"></script>