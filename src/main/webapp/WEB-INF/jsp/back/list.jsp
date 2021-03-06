<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/page.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>管理博客</title>
	<link rel="stylesheet" href="${rootPath }/static/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${rootPath }/static/menu/css/style.css">

<style type="text/css" media="screen">
		@media (min-width: 600px) {
			.menu{
				background: rgb(50, 60, 60);
				position: fixed;
				height: 100%;
				width: 250px;
				display: block !important;
			}
			.main{
				background-color: #fff;
				margin-left: 250px;
				height: 300px;
				padding: 15px;
			}
			.navbar-btn{
				display: none;
			}
		}	
	
		@media (max-width: 600px){
			.menu{
				background: rgb(50, 60, 60);
				position: fixed;
				top: 51px;
				bottom: 0;
				width: 70%;
				display: none;
				z-index: 1;
			}
			.main{
				background-color: #fff;
				height: 400px;
				padding: 15px;
			}
			.navbar-btn{
				background-color: rgba(0,0,0,0.3);
				border: 0;
				border-radius: 6px;
				outline: none;
				position: fixed;
				left: 2em;
				bottom: 2em;
				display: block;
				z-index: 2;
			}
		}
	</style>
</head>
<body>
	
	<header class="navbar navbar-inverse  navbar-fixed-top bs-docs-nav" id="top" style="margin-bottom: 0;">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#bs-navbar" aria-controls="bs-navbar" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a href="${rootPath }/" class="navbar-brand">悦来</a>
	    </div>
	    <nav id="bs-navbar" class="collapse navbar-collapse">
	      <ul class="nav navbar-nav">
	        <li>
	          <a href="${rootPath }/">博客首页</a>
	        </li>
	        <li>
	          <a href="${rootPath }/back/index.html">个人信息</a>
	        </li>
	        <li>
	          <a href="${rootPath}/back/article-add.html ">写博客</a>
	        </li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li>
	        	<a href="javascript:" class="dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">1103884823@qq.com<span class="caret"></span></a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
					    <li><a href="${rootPath }/back/index.html">个人信息</a></li>
					    <li><a href="${rootPath }/back/article-add.html">写博客</a></li>
					    <li><a href="${rootPath }/back/logout.html">退出</a></li>
					  </ul>
	        </li>
	      </ul>
	    </nav>
	  </div>
	</header>

	<div style="margin-top: 51px;">
		<div class="menu">
				<ul id="accordion" class="accordion">
					<li>
						<a href="${rootPath }/back/index.html" class="link">个人信息</a>
					</li>
					<li>
						<div class="link"><i class="fa fa-paint-brush"></i>博客管理&emsp;<i class="fa fa-chevron-down"></i><span class="glyphicon glyphicon-menu-down"></span></div>
						<ul class="submenu">
							<li><a href="${rootPath}/back/article-add.html ">写博客</a></li>
							<li><a href="${rootPath}/back/list.html ">管理</a></li>
						</ul>
					</li>
					<li>
						<div class="link"><i class="fa fa-code"></i>评论管理&emsp;<i class="fa fa-chevron-down"></i><span class="glyphicon glyphicon-menu-down"></span></div>
						<ul class="submenu">
							<li><a href="#">Javascript</a></li>
							<li><a href="#">jQuery</a></li>
							<li><a href="#">Frameworks javascript</a></li>
						</ul>
					</li>
					<li>
						<div class="link"><i class="fa fa-mobile"></i>网站设置&emsp;<i class="fa fa-chevron-down"></i><span class="glyphicon glyphicon-menu-down"></span></div>
						<ul class="submenu">
							<li><a href="#">Tablets</a></li>
							<li><a href="#">Dispositivos mobiles</a></li>
							<li><a href="#">Medios de escritorio</a></li>
							<li><a href="#">Otros dispositivos</a></li>
						</ul>
					</li>
				</ul>
			</div>

			<div class="main">
				<div class="col-md-10 col-md-offset-1 table-responsive">
					<table class="table table-striped table-hover">
						<tr>
							<th width="10">#id</th>
							<th width="250">title</th>
							<th width="100">keywords</th>
							<th >summary</th>
							<th width="70">category</th>
							<th width="70">author</th>
							<th width="70">source</th>
							<th width="150">date</th>
							<th width="100">operate</th>

						</tr>
						<c:forEach items="${articles }" var="article">
							<tr>
								<td>${article.id }</td>
								<td>${article.title }</td>
								<td>${article.keywords }</td>
								<td>${article.summary }</td>
								<td>${article.category }</td>
								<td>${article.author }</td>
								<td>${article.source }</td>
								<td><fmt:formatDate value="${article.publishTime }" pattern="yyyy/MM/dd HH:mm:ss"/></td>
								<td><a onclick="del(${article.id })" href="javascript:">删除</a>|<a href="${rootPath }/back/article-edit.html?id=${article.id}">编辑</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
			<button class="navbar-btn" onclick="javascript:$('.menu').toggle(200)">
			<span class="glyphicon glyphicon-menu-hamburger" style="font-size: xx-large;color: #eee"></span>
		</button>
	
	<script src="${rootPath }/static/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="${rootPath }/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${rootPath }/static/menu/js/index.js" type="text/javascript"></script>
	<script type="text/javascript">
		function del(e){
			$.ajax({
				url: "${rootPath}/back/article-delete.html?id="+e,
				type: "GET",
				dataType: "json",
				error: function(){
					alert("删除操作失败")
				},
				success: function(data){
					if(data.status==1){
						alert("删除成功");
						window.location.reload();
					}else{
						alert("删除失败");
					}
				}
				
			})
		}
	</script>
</body>
</html>