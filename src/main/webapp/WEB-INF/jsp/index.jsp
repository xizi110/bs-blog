<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/page.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>博客首页-悦来</title>
	<meta name="keywords" content="Java程序开发，数据库使用，MySQL，JavaWeb，软件使用，程序开发">
	<meta name="description" content="个人博客，专注于Java程序开发，软件使用，各种网络技术">
	<link rel="stylesheet" href="${rootPath }/static/bootstrap/css/bootstrap.min.css">
	<style type="text/css" media="screen">
		@media (min-width: 992px) {
			.sidebar-fixd{
				/* position: fixed;
				left: 71%;
				width: 262px; */
			}
		}
	</style>
</head>
<body style="background: url(${rootPath}/images/bg1.jpg) fixed center;">
	<!-- 顶部导航 -->
<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand hidden-sm" href="${rootPath }/">悦来</a>
    </div>
    <div class="navbar-collapse collapse" role="navigation" aria-expanded="false" style="height: 1px;">
      <ul class="nav navbar-nav">
        <li><a href="${rootPath }/">Blog首页</a></li>
        <li><a href="https://gitee.com/xizi110" target="_blank">gitee</a></li>
       <!-- <li><a href="" target="_blank">Bootstrap4中文文档</a></li> -->
       <!-- <li><a href="" target="_blank">Less 教程</a></li> -->
       <!-- <li><a href="" target="_blank">jQuery API</a></li> -->
       <!-- <li><a href="" target="_blank">网站实例</a></li> -->
      </ul>
      <ul class="nav navbar-nav navbar-right hidden-sm">
        <li><a target="_blank" href="http://shang.qq.com/wpa/qunwpa?idkey=014732ca625c07285d352a2ddcce6668eebb398f94e960b861b08eb13fc0ba9f"><img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="JavaWeb&amp;C&amp;Python交流群" title="JavaWeb&amp;C&amp;Python交流群"></a></li>
      </ul>
    </div>
  </div>
</div><!--  顶部导航end -->

	
	<div class="container" style="margin-top: 81px;">
		<div class="row">
			<div class="col-md-9"><!-- 文章简介列表  -->
			<c:forEach items="${articles }" var="article">
				<div class="jumbotron" style="word-break: break-word; ">
				<span class=""><fmt:formatDate value="${article.publishTime }" pattern="yyyy-MM-dd HH:mm:ss"/> </span>
				  <h2>${article.title }</h2>
				  <p>${article.summary }</p>
				  <p>
				  <a class="btn btn-info btn-lg" href="${rootPath }/detail/${article.id}.html" target="_blank">See more</a>
				  
				  </p>
				</div>
			</c:forEach>
			<c:if test="${page!=null&&page.totalPage>1 }">
			<nav aria-label="Page navigation" style="text-align: center;">
			  <ul class="pagination pagination-lg" style="margin: 0 ;">
			  <c:if test="${page.currentPage==page.prePage }">
			    <li class="disabled">
			        <span aria-hidden="true">&laquo;</span>
			    </li>
			  </c:if>
			  <c:if test="${page.currentPage>page.prePage }">
			  	<li>
			  		<a href="${rootPath }/index.html?page=${page.prePage }"><span aria-hidden="true">&laquo;</span></a>
			    </li>
			  </c:if>
			  <c:set var="end" value="${page.totalPage>5?(page.currentPage>3?page.currentPage+2>page.totalPage?page.totalPage:page.currentPage+2 : 5):page.totalPage}"></c:set>
			  <c:set var="begin" value="${page.totalPage>5?(page.currentPage>3?(end==page.totalPage?end-4:page.currentPage-2):1): 1}"></c:set>
			  <c:forEach begin="${begin }" end="${end }" var="size">
			  	<c:if test="${page.currentPage==size }">
				    <li class="disabled"><span>${size }</span></li>
			  	</c:if>
			  	<c:if test="${page.currentPage!=size }">
				    <li><a href="${rootPath }/index.html?page=${size }">${size }</a></li>
				</c:if>
			  </c:forEach>
			  <c:if test="${page.currentPage==page.nextPage }">
			    <li class="disabled">
			       <span aria-hidden="true">&raquo;</span>
			    </li>
			  </c:if>
			  <c:if test="${page.currentPage!=page.nextPage }">
			  	<li>
			      <a href="${rootPath }/index.html?page=${page.nextPage }" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </c:if>
			  </ul>
			</nav>
			</c:if>
			</div>

			<div class="col-md-3 sidebar-fixd"><!-- 侧边栏 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						个人分类
					</div>
					<nav class="bs-docs-sidebar hidden-print ">
						<ul class="nav bs-docs-sidenav">
							<c:forEach items="${articleCategories.entrySet() }" var="entry">
						    		<li><a href="${rootPath }/list.html?c=${entry.key}">${entry.key }&nbsp;(${entry.value })</a></li>
							</c:forEach>
						</ul>
					</nav>
				</div>
				<div class="panel panel-default ">
					<div class="panel-heading">
						归档
					</div>
					<nav class="bs-docs-sidebar hidden-print">
						<ul class="nav bs-docs-sidenav">
						<c:forEach items="${articleDate.entrySet() }" var="entry">
						    <li class=""><a href="${rootPath }/list.html?d=${entry.key}">${entry.key }&nbsp;(${entry.value })</a></li>
						</c:forEach>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	
	<script src="${rootPath }/static/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="${rootPath }/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>