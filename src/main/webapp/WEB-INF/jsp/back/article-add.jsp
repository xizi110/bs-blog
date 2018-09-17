<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/page.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>写博客</title>
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
				z-index: 1000;
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
				z-index: 1000;
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
	      <a href="../" class="navbar-brand">悦来</a>
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
	        	<a href="javascript:" class="dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">欢迎您：${user.username }<span class="caret"></span></a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
					    <li><a href="${rootPath }/back/index.html">个人信息</a></li>
					    <li><a href="${rootPath}/back/article-add.html">写博客</a></li>
					    <li role="separator" class="divider"></li>
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
				<form class="form-horizontal col-md-10 col-md-offset-1" method="post" action="${rootPath }/back/article-add.html">
					<div class="form-group">
					  <label class="col-sm-2 control-label">标题:</label>
					  <div class="col-md-8">
					    <input type="text" class="form-control" name="title" placeholder="标题" required >
					  </div>
					</div>
					<div class="form-group">
					  <label class="col-sm-2 control-label">作者:</label>
					  <div class="col-md-8">
					    <input type="text" class="form-control" name="author" placeholder="作者" required>
					  </div>
					</div>
					<div class="form-group ">
					  <label class="col-sm-2 control-label">来源:</label>
					  <div class="col-md-8">
					    <input type="text" class="form-control" name="source" placeholder="文章来源" required>
					  </div>
					</div>
					<div class="form-group ">
					  <label class="col-sm-2 control-label">关键字:</label>
					  <div class="col-md-8">
					    <input type="text" class="form-control" name="keywords" placeholder="多个关键字用“,”分割" required>
					  </div>
					</div>
					<div class="form-group ">
						<label class="col-sm-2 control-label">摘要:</label>
					  <div class="col-md-8">
					    <textarea name="summary" cols="30" rows="8" class="form-control" required>
					    	
					    </textarea>
					  </div>
					</div>
					
					<label class="col-sm-2 control-label" style="padding-right: 2em;">分类:</label>
					<div class="input-group col-md-8" style="margin-bottom: 15px;padding: 0 8px 0 4px">
		          		<input type="text" class="form-control col-md-5" name="category">
		          		<div class="input-group-btn">
		            		<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">选择 <span class="caret"></span></button>
			            	<ul class="dropdown-menu dropdown-menu-right">
			            	 	<c:forEach items="${categorys.entrySet() }" var="entry">
					              <li><a onclick="setCate(this)">${entry.key }</a></li>
						  		</c:forEach>
				            </ul>
			          	</div><!-- /btn-group -->
		        	</div>
					
					<div class="form-group ">
					  <label class="col-sm-2 control-label">编辑器:</label>
					  <div class="col-md-8">
					    <script id="editor" type="text/plain" style="width:100%;height:400px;" name="detail">${detail.detail}</script> 
					  </div>
					</div>
					<div class="form-group">
						<div class="text-center">
				  		<button type="submit" class="btn btn-default">发布</button>
						</div>
					</div>
				</form>	
			</div>
		</div>
			<button class="navbar-btn" onclick="javascript:$('.menu').toggle(200)">
			<span class="glyphicon glyphicon-menu-hamburger" style="font-size: xx-large;color: #eee"></span>
		</button>
	
	<script src="${rootPath }/static/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="${rootPath }/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${rootPath }/static/menu/js/index.js" type="text/javascript"></script>
	<script type="text/javascript" src="${rootPath }/static/lib/ueditor/1.4.3/ueditor.config.js"></script> 
	<script type="text/javascript" src="${rootPath }/static/lib/ueditor/1.4.3/ueditor.all.min.js"> </script> 
	<script type="text/javascript" src="${rootPath }/static/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
	
	
	
	<script type="text/javascript">
		console.log(window.parent.location.href)
		console.log(top.location.href)
		var ue = UE.getEditor('editor');
		
		function setCate(e){
			$("input[name='category']").val(e.text)
		}
	</script>
</body>
</html>