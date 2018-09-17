<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/page.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="${article.keywords }">
	<meta name="description" content="${article.summary }">
	<title>${article.title}-悦来 </title>
	<link rel="stylesheet" href="${rootPath }/static/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" media="screen" href="${rootPath}/static/lib/ueditor/1.4.3/third-party/SyntaxHighlighter/shCoreDefault.css">
	<style type="text/css">
		.panel-body img{
			max-width: 100%;
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
        <li><a href="${rootPath }/">Blog</a></li>
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
		<div class="col-md-10 col-md-offset-1"><!-- 文章简介列表  -->
				<div class="panel panel-default">
					<div class="panel-heading" style="word-break: break-word;">
						<h1>${article.title }</h1>
						<p>作者： ${article.author }</p>
						<p>来源： ${article.source }</p>
						<p>日期： <fmt:formatDate value="${article.publishTime }" pattern="yyyy-MM-dd HH:mm:ss"/> </p>
						<%-- <p>本文系作者原创,但欢迎大家转载,转载时请注明: ${article.author }[www.yuelai.xyz/detail/${article.id }.html]</p> --%>
					</div>
					<div class="panel-body">
						${article.detail }
					</div>
					<div class="panel-footer" >
						<div>上一篇:<a href="${rootPath }/detail/${prevArticle.id}.html" title="${prevArticle.title }">${prevArticle.title }</a></div>
						<div>下一篇:<a href="${rootPath }/detail/${nextArticle.id}.html" title="${nextArticle.title}">${nextArticle.title}</a></div>
					</div>
				</div>
		</div>
	</div>
</div>
<script src="${rootPath }/static/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="${rootPath }/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${rootPath}/static/lib/ueditor/1.4.3/third-party/SyntaxHighlighter/shCore.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		SyntaxHighlighter.all();
	});
</script>
</body>
</html>