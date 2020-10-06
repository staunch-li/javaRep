<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
		<link rel="icon" type="text/css" href="${pageContext.request.contextPath}/img/favicon.png"/>
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<title>adminLogin</title>
		<style type="text/css">
			body{background-image: url(${pageContext.request.contextPath}/images/pp7.jpg);background-size: cover;}
			h1 {
				    font-size: 3vw;
				    color: #fff;
				    text-align: center;
				    padding: 2.5vw 1vw 1vw;
				    letter-spacing: 3px;
				    text-transform: uppercase;
				    font-weight: 600;
				}
			.image-style {
		   	background-image: url(${pageContext.request.contextPath}/images/m.jpg);
		    background-size: cover;
		    -webkit-background-size: cover;
		    -moz-background-size: cover;
		    -o-background-size: cover;
		    -ms-background-size: cover;
		    min-height: 450px;
				}
		</style>
	</head>
	<body>
		<div class="container-fluid">
			<div class="row" style="height: 150px;">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">  
			<h1>学生成绩后台管理系统</h1>
			</div>
			<div class="col-lg-3"></div>
			</div>
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-12"></div>
				<div class="col-lg-2 col-md-2 col-sm-12">
					<div class="image-style"></div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-12 border border-light pt-4 pb-4">
					<form action="${pageContext.request.contextPath}/admin?action=login" method="post" class="text-white">
						<h2 class="text-center">管理员&老师登录</h2>
						<h2 class="text-center text-danger">${param.msg==1?'用户名或密码错误':'' }</h2>
						<h2 class="text-center text-danger">${param.msg==2?'你还未登录!请先登录':''}</h2>
						<h2 class="text-center text-danger">${param.mss==1?'验证码错误':''}</h2>
						
						<div class="form-group">
							<label for="aname">用户名</label>
							<input type="text" class="form-control" id="aname" name="aname" placeholder="input username" value="${cookie.yhm.value }">


						</div>
						<div class="form-group">
							<label for="apassword">密码</label>
							<input type="password" class="form-control" id="apassword" name="apassword" value="${cookie.mm.value }">
						</div>


						<div class="form-group form-check">
							<input type="checkbox" class="form-check-input" id="exampleCheck1" name="remeberme" value="1" ${cookie.yhm!=null?'checked':'' }>
							<label class="form-check-label" for="exampleCheck1">记住用户名和密码</label>
						</div>
						<div class="form-group">
							<label for="verify">验证码</label>
							<div class="form-row">
								<div class="col">
									<img id="myVerify" src="${pageContext.request.contextPath}/createVerify" width="200px" height="40px" />
								</div>
								<div class="col">
									<input type="text" class="form-control" id="verify" name="verify">
								</div>
							</div>
						</div>
						<script type="text/javascript">
						$(function () {
							var v = Math.random();
							$("#myVerify").attr("src","${pageContext.request.contextPath}/createVerify?k="+v)
							
							$("#myVerify").click(function(){
								var v = Math.random();
								$("#myVerify").attr("src","${pageContext.request.contextPath}/createVerify?k="+v)
							 	});
							});
							
						var v = $("#aname").attr("value");
						v = decodeURI(v);
						$("#username").attr("value",v);
						
						
						</script>


						<button type="submit" class="btn btn-primary btn-block btn-lg mt-4">登录</button>
						<button type="button" class="btn btn-success btn-block btn-lg mt-4" data-toggle="modal" data-target="#staticBackdrop" disabled="disabled">注册</button>
					</form>
					<!-- 注册表单 -->

					<!-- 注册表单 -->
					<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog"
					 aria-labelledby="staticBackdropLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-scrollable">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="staticBackdropLabel">adminRegister</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<!-- 注册表单 -->
									<form action="服务器java路径" method="post">
										
										<div class="form-group">
											<label for="username">Username</label>
											<input type="text" class="form-control" id="username" name="username" aria-describedby="emailHelp"
											 placeholder="input username">
											<small id="emailHelp" class="form-text text-muted">用户名4-8位字母数字，数字不开头</small>
										</div>

										<div class="form-group">
											<label for="exampleInputPassword1">Password</label>
											<input type="password" class="form-control" id="exampleInputPassword1" name="password">
										</div>
										<div class="form-group">
											<label for="college">college</label>
											<input type="text" class="form-control" id="college" name="college">
										</div>
										<div class="form-group">
											<label for="major">major</label>
											<input type="email" class="form-control" id="major" name="major">
										</div>										
										<button type="submit" class="btn btn-primary btn-block">Register</button>
									</form>
									<!-- 注册表单 -->
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">back to login</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-12"></div>
			</div>
		</div>
	</body>
</html>
