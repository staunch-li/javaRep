<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<base target="_self">
		<title>学生个人中心</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="湖南强智科技教务系统">
		<meta http-equiv="description" content="湖南强智科技教务系统">
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">
		<script type="${pageContext.request.contextPath}/text/javascript" src="/jsxsd/js/jquery-min.js" language="javascript"></script>
		<script type="${pageContext.request.contextPath}/text/javascript" src="/jsxsd/js/common.js" language="javascript"></script>
		<script type="${pageContext.request.contextPath}/text/javascript" src="/jsxsd/js/iepngfix_tilebg.js" language="javascript"></script>
		<link href="${pageContext.request.contextPath}/jsxsd/framework/images/common.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/jsxsd/framework/images/blue.css" rel="stylesheet" type="text/css" id="link_theme">
		<link href="${pageContext.request.contextPath}/jsxsd/framework/images/workstation.css" rel="stylesheet" type="text/css">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>学生信息管理系統 </title>
		<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/bxslider.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bxslider.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/common.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	<body style="overflow-x: hidden;">
		<link href="${pageContext.request.contextPath}/css/jiathis_share.css" rel="stylesheet" type="text/css"><iframe frameborder="0" style="position: absolute; display: none; opacity: 0;"></iframe>
		<div class="jiathis_style" style="position: absolute; z-index: 1000000000; display: none; top: 50%; left: 50%; overflow: auto;"></div>
		<div class="jiathis_style" style="position: absolute; z-index: 1000000000; display: none; overflow: auto;"></div><iframe
		 frameborder="0" src="/jiathis_utility.html" style="display: none;"></iframe>
		<link href="${pageContext.request.contextPath}/css/jiathis_share.css" rel="stylesheet" type="text/css"><iframe frameborder="0" style="position: absolute; display: none; opacity: 0;"></iframe>
		<div class="jiathis_style" style="position: absolute; z-index: 1000000000; display: none; top: 50%; left: 50%; overflow: auto;"></div>
		<div class="jiathis_style" style="position: absolute; z-index: 1000000000; display: none; overflow: auto;"></div><iframe
		 frameborder="0" src="${pageContext.request.contextPath}/jiathis_utility.html" style="display: none;"></iframe>
		<style type="text/css">
			body {
				color: #FFF;
				font-size: 14px;
				font-family: "微软雅黑";
			}

			ul,
			dl,
			dd,
			h1,
			h3,
			h4,
			h5,
			h6,
			form,
			p,
				{
				padding: 0;
				margin: 0;
			}

			font {
				color: #FFF;
			}

			.wap {
				position: relative;
				height: 450px;
				width: 910px;
				margin: 0 auto;
			}

			.block1 {
				width: 265px;
				height: 287px;
				background: #09619F;
			}

			.block1 img {
				position: absolute;
				top: 92px;
				left: 28px;
			}

			.block1tex {
				position: absolute;
				top: 169px;
				left: 33px;
			}

			.block1text {
				position: absolute;
				top: 120px;
				left: 135px;
				width: 150px;
				height: 73px;
				line-height: 21px;
			}

			.block1text2 {
				position: absolute;
				top: 100px;
				left: -5px;
				width: 150px;
				height: 73px;
				line-height: 21px;
			}

			.block1pc {
				background: #2271A9;
				position: absolute;
				width: 90px;
				height: 117px;
				left: 141px;
				top: 31px;
			}

			.block1pc img {
				position: absolute;
				width: 90px;
				height: 117px;
				left: 0;
				top: 0;
			}

			.block2 {
				position: absolute;
				width: 153px;
				height: 287px;
				background: #4FB5C7;
				left: 270px;
				top: 0px;
			}

			.block2 img {
				position: absolute;
				top: 92px;
				left: 43px;
			}

			.block2tex {
				position: absolute;
				top: 164px;
				left: 48px;
			}

			.block3 {
				position: absolute;
				width: 173px;
				height: 141px;
				background: #1978D8;
				left: 428px;
				top: 0px;
			}

			.block3 img {
				position: absolute;
				top: 29px;
				left: 38px;
			}

			.block3tex {
				position: absolute;
				top: 91px;
				left: 58px;
			}

			.block4 {
				position: absolute;
				width: 173px;
				height: 141px;
				background: #90A8E3;
				left: 428px;
				top: 146px;
			}

			.block4 img {
				position: absolute;
				top: 21px;
				left: 48px;
			}

			.block4tex {
				position: absolute;
				top: 91px;
				left: 57px;
			}

			.block5 {
				position: absolute;
				width: 304px;
				height: 141px;
				background: #DB6987;
				right: 0px;
				top: 0px;
			}

			.block5 img {
				position: absolute;
				top: 28px;
				left: 21px;
			}

			.block5tex {
				position: absolute;
				top: 96px;
				left: 35px;
			}

			.block5text {
				line-height: 21px;
				position: absolute;
				top: 30px;
				left: 112px;
				width: 172px;
				height: 87px;
			}

			.block6 {
				position: absolute;
				width: 304px;
				height: 141px;
				background: #8E7AAA;
				right: 0px;
				top: 146px;
			}

			.block6 img {
				position: absolute;
				top: 12px;
				left: 21px;
			}

			.block6tex {
				position: absolute;
				top: 96px;
				left: 35px;
			}

			.block6text {
				line-height: 21px;
				position: absolute;
				top: 30px;
				left: 112px;
				width: 172px;
				height: 87px;
			}

			.block7 {
				position: absolute;
				width: 130px;
				height: 138px;
				background: #187D9A;
				top: 292px;
			}

			.block7 img {
				position: absolute;
				top: 26px;
				left: 30px;
			}

			.block7tex {
				position: absolute;
				top: 94px;
				left: 36px;
			}

			.block8 {
				position: absolute;
				width: 130px;
				height: 138px;
				background: #A0CF41;
				left: 135px;
				top: 292px;
			}

			.block8 img {
				position: absolute;
				top: 26px;
				left: 30px;
			}

			.block8tex {
				position: absolute;
				top: 94px;
				left: 35px;
			}

			.block9 {
				position: absolute;
				width: 153px;
				height: 138px;
				background: #EAAF76;
				left: 270px;
				top: 292px;
			}

			.block9 img {
				position: absolute;
				top: 26px;
				left: 41px;
			}

			.block9tex {
				position: absolute;
				top: 94px;
				left: 46px;
			}

			.block10 {
				position: absolute;
				width: 173px;
				height: 138px;
				background: #88BAD9;
				left: 428px;
				top: 292px;
			}

			.block10 img {
				position: absolute;
				top: 22px;
				left: 51px;
			}

			.block10tex {
				position: absolute;
				top: 94px;
				left: 53px;
			}

			.block11 {
				position: absolute;
				width: 149px;
				height: 138px;
				background: #B69CCC;
				left: 606px;
				top: 292px;
			}

			.block11 img {
				position: absolute;
				top: 19px;
				left: 45px;
			}

			.block11tex {
				position: absolute;
				top: 94px;
				left: 47px;
			}

			.block12 {
				position: absolute;
				width: 149px;
				height: 138px;
				background: #09619F;
				right: 0px;
				top: 292px;
			}

			.block12 img {
				position: absolute;
				top: 26px;
				left: 45px;
			}

			.block12tex {
				position: absolute;
				top: 94px;
				left: 46px;
			}

			a {
				color: #FFFFFF;
			}
			#p{
				margin-top: 75px;
			}
			h4{
				text-align: center;
				color: #000000;
			}
			#tu{
				margin-left:80px;
			}
		</style>
		<header>
		<fmt:setBundle basename="web"/>
		<fmt:setLocale value="${locale }"/>
			<div class="top_menu">
				<div class="container-fluid">

					<span class="top_name"></span>
					<div class="top_lang">语言选择：
						<a href="${pageContext.request.contextPath}/user?action=changeChinese" title="中文版" ><img src="images/Chinese.gif" alt="中文版"></a>
						∷&nbsp;
						<a href="${pageContext.request.contextPath}/user?action=changeEnglish" title="English"><img src="images/English.gif" alt="英文版"></a>
					</div>
				</div>
			</div>
		<!-- <div class="container-fluid">
				<div class="row">
					<div class="col-lg-2">

					</div>
					<div class="col-lg-8">
						<h2>欢迎登录教学一体化服务平台</h2>
					</div>
					<div class="col-lg-2">
						<a href="CustomerLogin.jsp" class="btn btn-block btn-lg border border-bottom text-danger mr-2">登录</a>
					</div>


				</div> 
			</div> -->

			<!-- Fixed navbar -->
			<nav id="top_nav" class="navbar navbar-default navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						 aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<span id="small_search" class="glyphicon glyphicon-search" aria-hidden="true"></span>
						<a class="navbar-brand" href="javascript:;">导航菜单</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<c:if test="${user!=null }">
							<li><a href="javascript:;">
								<fmt:bundle basename="web">
									<fmt:message key="index"></fmt:message>
								</fmt:bundle>
							</a></li>

							<li><a href="${pageContext.request.contextPath}/user?action=myselfgradeshow">
							<fmt:bundle basename="web">
									<fmt:message key="StudentAchievement"></fmt:message>
								</fmt:bundle>
							</a></li>
							<li class="dropdown">
								<a href="${pageContext.request.contextPath}/usersub?action=musublist">
								<fmt:bundle basename="web">
									<fmt:message key="managementAndTraining"></fmt:message>
								</fmt:bundle>
								</a>
								<a href="javascript:;" id="app_menudown" class="dropdown-toggle" data-toggle="dropdown" role="button"
								 aria-expanded="false"><span class="glyphicon glyphicon-menu-down btn-xs"></span></a>
							</li>
							<li class="dropdown">
								<a href="javascript:;">
								<fmt:bundle basename="web">
									<fmt:message key="TestRegistration"></fmt:message>
								</fmt:bundle>
								</a>
								<a href="javascript:;" id="app_menudown" class="dropdown-toggle" data-toggle="dropdown" role="button"
								 aria-expanded="false"><span class="glyphicon glyphicon-menu-down btn-xs"></span></a>
								<ul class="dropdown-menu nav_small" role="menu" style="display: none;">
									<li><a href="http://cet-bm.neea.cn/">英语四六级报名</a></li>
									<li><a href="http://ncre.neea.edu.cn/">计算机二级报名</a></li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="javascript:;">
								<fmt:bundle basename="web">
									<fmt:message key="Worshiplink"></fmt:message>
								</fmt:bundle>
								</a>
								<a href="javascript:;" id="app_menudown" class="dropdown-toggle" data-toggle="dropdown" role="button"
								 aria-expanded="false"><span class="glyphicon glyphicon-menu-down btn-xs"></span></a>
								<ul class="dropdown-menu nav_small" role="menu" style="display: none;">
									<li><a href="${pageContext.request.contextPath}/grade?action=javamatchshow">java项目创新大赛排名</a></li>
								</ul>
							</li>
							</c:if>
							<li><a href="${pageContext.request.contextPath}/upmessage.jsp">
							<fmt:bundle basename="web">
									<fmt:message key="Message"></fmt:message>
								</fmt:bundle>
							</a></li>
							<c:if test="${user!=null }">
								<li class="dropdown">
									<a href="javascript:;">
									<fmt:bundle basename="web">
									<fmt:message key="personalInformation"></fmt:message>
								</fmt:bundle>
									</a>
									<a href="javascript:;" id="app_menudown" class="dropdown-toggle" data-toggle="dropdown" role="button"
									 aria-expanded="false"><span class="glyphicon glyphicon-menu-down btn-xs"></span></a>
									<ul class="dropdown-menu nav_small" role="menu" style="display: none;">
										<li><img id="tu" src="${photopath}/${user.uphoto }" width="50" height="50"></li>
										<li><a href="javascript:;">学号:${user.unumber }</a></li>
										<li><a href="javascript:;">姓名:${user.uname }</a></li>
										<li><a href="javascript:;">学院:${user.ucol }</a></li>
										<li><a href="javascript:;">学院:${user.umajor }</a></li>
										<li><a href="${pageContext.request.contextPath}/updateStudent.jsp">修改个人信息</a></li>
										<li><a href="${pageContext.request.contextPath}/updatePhoto.jsp">修改头像</a></li>
										<li><a href="${pageContext.request.contextPath}/updatePSW.jsp">修改密码</a></li>
										<li><a href="${pageContext.request.contextPath}/user?action=exit">退出登录</a></li>
									</ul>
								</li>
							</c:if>
						</ul>
						<c:if test="${user==null }">
						<a href="${pageContext.request.contextPath}/studentLogin.jsp" class="btn btn-block btn-lg border border-bottom text-white mr-2">登录/注册</a>
						</c:if>
					</div>

				</div>
			</nav>
		</header>

		<!-- 轮播图 -->
		<div class="container-fluid" id="p">
			<div class="wap">
				<div class="block1">
				<c:if test="${user!=null }">
					<div>
						<img src="${photopath}/${user.uphoto }" width="72" height="64">
					</div>
					<div class="block1tex">
						<fmt:bundle basename="web">
							<fmt:message key="personalInformation"></fmt:message>
						</fmt:bundle>
					</div>
					<div class="block1text">
						姓名：${user.uname }<br>
						学号：${user.unumber }<br>
					</div>
				</c:if>
				</div>


				<a href="${pageContext.request.contextPath}/usersub?action=csubject">
					<div class="block2">
						<div>
							<img src="images/tp2.png" width="65" height="65">
						</div>
						<div class="block2tex">
						<fmt:bundle basename="web">
							<fmt:message key="RegistrationCenter"></fmt:message>
						</fmt:bundle></div>
					</div>
				</a>




				<a href="${pageContext.request.contextPath}/grade?action=javamatchshow">
					<div class="block3">
						<div>
							<img src="images/tp3.png" width="92" height="55">
						</div>
						<div class="block3tex">
						<fmt:bundle basename="web">
							<fmt:message key="Worshiplink"></fmt:message>
						</fmt:bundle>
						</div>
					</div>
				</a>



				<a href="${pageContext.request.contextPath}/user?action=myselfgradeshow">
					<div class="block4">
						<div>
							<img src="images/tp10.png" width="71" height="69">
						</div>
						<div class="block10tex">
						<fmt:bundle basename="web">
							<fmt:message key="testScore"></fmt:message>
						</fmt:bundle>
						</div>
					</div>
				</a>


				<a href="${pageContext.request.contextPath}/upmessage.jsp">
					<div class="block5">
						<div>
							<img src="images/tp5.png" width="80" height="57">
						</div>
						<div class="block5tex">
						<fmt:bundle basename="web">
								<fmt:message key="Message"></fmt:message>
						</fmt:bundle>
								</div>
						<div class="block5text" id="grxx"></div>
					</div>
				</a>




				<a href="${pageContext.request.contextPath}/message?action=messageshow">
					<div class="block6">
						<div>
							<img src="images/tp6.png" width="67" height="79">
						</div>
						<div class="block6tex">
						<fmt:bundle basename="web">
								<fmt:message key="Reply"></fmt:message>
						</fmt:bundle>
						</div>
						<div class="block6text" id="ggtz"></div>
					</div>
				</a>




				<a>
					<div class="block7">
						<div>
							<img src="images/tp7.png" width="66" height="59">
						</div>
						<div class="block7tex">
						<%-- <fmt:bundle basename="web">
							<fmt:message key="program"></fmt:message>
						</fmt:bundle> --%>
						</div>
					</div>
				</a>



				<a>
					<div class="block8">
						<div>
							<img src="images/tp8.png" width="64" height="60">
						</div>
						<div class="block8tex"></div>
					</div>
				</a>



				<a>
					<div class="block9">
						<div>
							<img src="images/tp9.png" width="66" height="66">
						</div>
						<div class="block9tex"></div>
					</div>
				</a>


				<a>
					<div class="block10">
						<div>
							<img src="images/tp4.png" width="71" height="62">
						</div>
						<div class="block4tex">
						<%-- <fmt:bundle basename="web">
							<fmt:message key="program"></fmt:message>
						</fmt:bundle> --%>
						</div>
					</div>
				</a>


				<a>
					<div class="block11">
						<div>
							<img src="images/tp11.png" width="62" height="73">
						</div>
						<div class="block11tex"></div>
					</div>
				</a>



				<a>
					<div class="block12">
						<div>
							<img src="images/tp12.png" width="55" height="67">
						</div>
						<div class="block12tex"></div>
					</div>
				</a>


			</div>
		</div>
		</div>
		<script type="text/javascript">
			$('.bxslider').bxSlider({
				adaptiveHeight: true,
				infiniteLoop: true,
				hideControlOnEnd: true,
				auto: true
			});
		</script>
		<div id="Footer1_divCopyright" class="Nsb_pw">
		  <div class="Nsb_rights text-black-50">
			<h4>(C) staunch科技发展有限公司  All Rights Reserved 鲁ICP 备12010071号</h4>
		</div>
		<script type="text/javascript" src="js/online.js"></script>
		<script>
			document.write('<script src="//' + (location.host || 'localhost').split(':')[0] +
				':35929/livereload.js?snipver=1"></' + 'script>')
		</script>
		<script src="//127.0.0.1:35929/livereload.js?snipver=1"></script>
		<script>
			document.addEventListener('LiveReloadDisconnect', function() {
				setTimeout(function() {
					window.location.reload();
				}, 500);
			})
		</script>
		<script type="text/javascript">
			var winHeight = 200;
			var timer = null;

			function show() {
				document.getElementById("popWin").style.display = "block";
				timer = setInterval("lift(5)", 2);
			}

			function hid() {
				timer = setInterval("lift(-5)", 2);
			}

			function lift(n) {
				var w = document.getElementById("popWin");
				var h = parseInt(w.style.height || w.currentStyle.height);
				if (h < winHeight && n > 0 || h > 1 && n < 0) {
					w.style.height = (h + n).toString() + "px";
				} else {
					w.style.display = (n > 0 ? "block" : "none");
					clearInterval(timer);
				}
			}
			window.onload = function() {
				setTimeout("show()", 1000);
			}
		</script>
	</body>

