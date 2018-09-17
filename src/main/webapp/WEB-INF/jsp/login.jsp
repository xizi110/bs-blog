<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/page.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>博客登录-悦来</title>
	<link rel="stylesheet" href="${rootPath }/static/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${rootPath}/static/bootstrapvalidator/css/bootstrapValidator.min.css">

	<style type="text/css" media="screen">
		body{
	    background: url("${rootPath}/images/bg1.jpg");
	    animation-name:myfirst;
	    animation-duration:12s;
	    /*变换时间*/
	    animation-delay:2s;
	    /*动画开始时间*/
	    animation-iteration-count:infinite;
	    /*下一周期循环播放*/
	    animation-play-state:running;
	    /*动画开始运行*/
		}
		@keyframes myfirst
		{
		    0%   {background:url("${rootPath}/images/bg1.jpg") fixed center;}
		    34%  {background:url("${rootPath}/images/bg2.jpg") fixed center;}
		    67%  {background:url("${rootPath}/images/bg3.jpg") fixed center;}
		    100% {background:url("${rootPath}/images/bg1.jpg") fixed center;}
		}
		@media (min-width: 992px) {
			.form{
				width: 600px;
			}
		}
		.form{background: rgba(255,255,255,0.4);margin:130px auto;padding: 15px;}
		/*阴影*/
		.fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
		input[type="email"],input[type="password"]{padding-left:26px;}
		.checkbox{padding-left:21px;}
		.help-block{
			color:yellow !important ;
		}
	</style>
</head>
<body style="background: url(${rootPath}/images/bg1.jpg) fixed center;">
	<div class="container">
        <div class="form row">
            <form class="form-horizontal col-md-offset-1" role="form" id="login_form">
                <h3 class="form-title">LOGIN</h3>
                <div class="col-md-11">
                    <div class="form-group">
                    	<label>Email</label>
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required input-lg" type="email" placeholder="Email" id="email" name="email" autofocus="autofocus" maxlength="30"/>
                    </div>
                    <div class="form-group">
                    	<label>Password</label>
                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required input-lg" type="password" placeholder="Password" id="password" name="password" maxlength="20"/>
                    </div>
                    
                    <label>Code:</label>
                    <div class="input-group form-group" >
                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required input-lg" style="border-radius: 6px;" type="text" placeholder="Code" id="code" name="code" maxlength="4"/>
                        <span class="input-group-addon " style="border-radius: 6px;" onclick="javascript:$('#codeimg').attr('src','${rootPath }' + '/verifyCode.html?s=' + new Date().getTime())">
                        	<img src="${rootPath }/verifyCode.html" id="codeimg" height="30">
                        </span>
                    </div>
                    
                    <div class="form-group">
                        <label class="checkbox">
                            <input type="checkbox" name="remember" value="1"/><span style="color:white;">记住我</span>
                        </label>
                    </div>
                    <div class="form-group col-md-offset-9">
                        <span class="btn btn-success pull-right" id="submit-btn">登录${rand }</span>
                    </div>
                </div>
            </form>
        </div>
    </div>

	<script src="${rootPath }/static/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="${rootPath }/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${rootPath }/static/bootstrapvalidator/js/bootstrapValidator.min.js" type="text/javascript" ></script>


<script>
	$(function () {
		$("#login_form").bootstrapValidator({
		  live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
		  excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
		  //submitButtons: '#submit-btn',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
		  message: '通用的验证失败消息',//好像从来没出现过
		  feedbackIcons: {//根据验证结果显示的各种图标
		      valid: 'glyphicon glyphicon-ok',
		      invalid: 'glyphicon glyphicon-remove',
		      validating: 'glyphicon glyphicon-refresh'
		  },
		  fields: {
		      email: {
		          validators: {
		              notEmpty: {//检测非空,radio也可用
		                  message: '邮箱不能为空'
		              },
		              emailAddress: {//验证email地址
		                  message: '不是正确的email地址'
		              },
		             /* identical: {//与指定控件内容比较是否相同，比如两次密码不一致
		                  field: 'confirmPassword',//指定控件name
		                  message: '输入的内容不一致'
		              },*/
		          }
		      },
		       password: {
		          validators: {
		              notEmpty: {//检测非空,radio也可用
		                  message: '文本框必须输入'
		              },
		          }
		      },
		       code: {
		    	  validators: {
		    		  /* notEmpty: {
		    			  message: '验证码不能为空'
		    		  }, */
					 remote: {
						 url: "${rootPath}/checkCode.html",
						 message: "验证码不正确",
						 type: "get",
						 dateType: "json",
						 date: $("#code").serialize(),
						 delay: 1000,
					 }
		    	  }
		      },
		  }
		})
	})
	
	$("#submit-btn").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
	  $("#login_form").bootstrapValidator('validate');//提交验证
	  if ($("#login_form").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
      $.ajax({
				url: "${rootPath}/auth/login.html",//提交地址
				data: $('#login_form').serialize(),//将表单数据序列化
				type: "POST",
				dataType: "json",
				success: function (result) {
					if (result.code == 1) {
						window.open('${rootPath}'+result.action,'_self');
					} else {
						alert(result.msg);
					}
				},
				error: function (xhr) {
					alert("错误提示： " + xhr.status + " " + xhr.statusText);
				}
			});
	  }
	});
</script>
</body>
</html>