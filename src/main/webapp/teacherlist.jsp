<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="icon" type="text/css"
	href="${pageContext.request.contextPath}/img/favicon.png" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
	type="text/javascript" charset="utf-8"></script>
<title>老师后台</title>
<style type="text/css">
#ww{
		margin-top: 70px;
		margin-left: 70px;
		}
		#h2{
		margin-top: 70px;
		}
		#a{
		margin-left: 15px;
		}

</style>
</head>
<body>
	<div class="container-fluid">
			<div class="row">
				<div class="col-2" >
					<div class="row">
					<div class="col-3"></div>
					<div class="col-9">
					<a href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/images/数据加密.png" width="120px" height="120px"></a>
					</div>
					</div>
				</div>
				<div class="col-8" id="h2">
					<h2>学生成绩管理系统后台页面(教师页面)</h2>
				</div>
				<div class="col-2">
					<div class="btn-group " id="ww">
						<button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
						 aria-expanded="false">
							老师信息
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item">
								<img src="${pageContext.request.contextPath}/img/tou.png" class="rounded-circle w-50 h-50" />
							</a>
							<a class="dropdown-item">身份：${admin.rname}</a>
							<a class="dropdown-item">用户名：${admin.aname}</a>
							<div class="dropdown-divider"></div>
							<div class="row">
							<div class="col-4"></div>
							<div class="col-6">
							<a class="" href="${pageContext.request.contextPath}/admin?action=exit"><img src="${pageContext.request.contextPath}/images/退出.png" width="50%"></a>
							</div>
							<div class="col-2"></div>
							</div>
						</div>
					</div>
					
					<a href="index.jsp" class="ml-3"><img src="${pageContext.request.contextPath}/images/登录.png" width="20%" /></a>
					
				</div>
			</div>
		</div>
		<div class="container-fluid mt-2">
			<div class="row" style="height: 600px;">
				<div class="col-2">
					<div class="card" style="width: 18rem;">
					  <div class="card-header">
					   	学生列表
					  </div>
					  <ul class="list-group list-group-flush">
					    <li class="list-group-item"><a href="${pageContext.request.contextPath}/user?action=userlistPage" class="btn btn-dark btn-light" target="myframe">学生列表</a></li>
					  </ul>
					</div>
				
					<div class="card" style="width: 18rem;">
					  <div class="card-header">
					   	学生成绩列表
					  </div>
					  <ul class="list-group list-group-flush">
					    <li class="list-group-item"><a href="${pageContext.request.contextPath}/grade?action=usergradelist" class="btn btn-dark btn-light" target="myframe">学生成绩列表</a></li>
					    <li class="list-group-item"><a href="${pageContext.request.contextPath}/grade?action=usergradelistPage" class="btn btn-dark btn-light" target="myframe">学生成绩列表分页</a></li>
					    <li class="list-group-item"><a class="btn btn-dark btn-light" href="${pageContext.request.contextPath}/user?action=csv">下载学生名单</a></li>
					  </ul>
					</div>
				</div>
				<div class="col-10">
					<iframe name="myframe" src="${pageContext.request.contextPath}/default.html" frameborder="0" scrolling="auto" width="100%" height="100%"></iframe>
						<!-- <div class="embed-responsive embed-responsive-16by9">
						  <iframe class="embed-responsive-item" src="login.html"></iframe>
					</div> -->
				</div>
			</div>
		</div>
</body>
</html>