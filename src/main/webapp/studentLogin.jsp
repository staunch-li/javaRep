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
		<title>Customs Login</title>
		<style type="text/css">
			body{background-image: url(${pageContext.request.contextPath}/images/pp6.jpg);background-size: cover;}
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
			<h1>教学管理系统</h1>
			</div>
			<div class="col-lg-3"></div>
			</div>
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-12">
					<div class="card" style="width: 30rem;">
						  <div class="card-body">
						    <h3 class="card-title">公告:</h3>
						    <h5 class="card-subtitle mb-2 text-muted">${notice.nname }</h5>
						    <h5 class="card-subtitle mb-2 text-muted">发布时间:${notice.ntime }</h5>
						    <h4><p class="card-text">公告内容:${notice.ncontent }</p></h4>
						  </div>
					</div>
				
				</div>
				<div class="col-lg-2 col-md-2 col-sm-12">
					<div class="image-style"></div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-12 border border-light pt-4 pb-4">
					<form action="${pageContext.request.contextPath}/user?action=customerlogin" method="post" class="text-white">
						<h2 class="text-center">学生登录</h2>
						<h2 class="text-center text-danger">${param.msg==9?'用户名或密码错误或账号状态异常':'' }</h2>
						<h2 class="text-center text-danger">${param.msg==2?'你还未登录!请先登录':''}</h2>
						<h2 class="text-center text-danger">${param.mss==1?'验证码错误':'' }</h2>
						<div class="form-group">
							<label for="usernumber">学号</label>
							<input type="text" class="form-control" id="usernumber" name="unumber" placeholder="input usernumber" value="${cookie.num.value }">


						</div>
						<div class="form-group">
							<label for="password">密码</label>
							<input type="password" class="form-control" id="password" name="upassword" value="${cookie.smm.value }">
						</div>


						<div class="form-group form-check">
							<input type="checkbox" class="form-check-input" id="exampleCheck1" name="remeberme" value="1" ${cookie.num!=null?'checked':'' }>
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
						</script>


						<button type="submit" class="btn btn-primary btn-block btn-lg">登录</button>
						<button type="button" id="GoAdmin" class="btn btn-secondary btn-block btn-lg">管理员&老师登录入口</button>
						<button type="button" class="btn btn-success btn-block btn-lg" data-toggle="modal" data-target="#staticBackdrop">注册</button>
						
						<script type="text/javascript">
						$("#GoAdmin").click(function(){
							//跳转管理员页面
							window.location.assign("${pageContext.request.contextPath}/adminLogin.jsp");
						})
						</script>
					
					</form>
					<!-- 注册表单 -->

					<!-- 注册表单 -->
					<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog"
					 aria-labelledby="staticBackdropLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-scrollable">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="staticBackdropLabel">学生注册</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<!-- 注册表单 -->
									<form action="" method="post">
									<h3 id="regmsgshow" class="text-primary">${msg }</h3>
										<div class="form-group">
											<label for="unumberReg">学号</label>
											<input type="text" class="form-control" id="unumberReg" name="unumber" aria-describedby="unumberHelp">
											<small id="unumberHelp" class="form-text text-muted">学号由6位数字组成</small>
										</div>
										<div class="form-group">
											<label for="UsernameReg">姓名</label>
											<input type="text" class="form-control" id="UsernameReg" name="uname" aria-describedby="usernameHelp"
											 placeholder="input username">
											<small id="usernameHelp" class="form-text text-muted">姓名由2-4个汉字组成组成</small>
										</div>
										
										<div class="form-group">
											<label for="upasswordReg">密码</label>
											<input type="password" class="form-control" id="upasswordReg" name="upassword" aria-describedby="passwordHelp">
											<small id="passwordHelp" class="form-text text-muted">密码由3-8位字母数字组成</small>
										</div>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="usex" id="sex1" value="1">
											<label class="form-check-label" for="sex1">女</label>
										</div>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="usex" id="sex1" value="2">
											<label class="form-check-label" for="sex1">男</label>
										</div>
										<div class="form-group">
											<label for="college">学院</label>
											<input type="text" class="form-control" id="college" name="ucol" aria-describedby="collegeHelp">
											<small id="collegeHelp" class="form-text text-muted">学院名由3-10个汉字组成</small>
										</div>
										<div class="form-group">
											<label for="major">专业</label>
											<input type="text" class="form-control" id="major" name="umajor" aria-describedby="umajorHelp">
											<small id="umajorHelp" class="form-text text-muted">专业名由3-10个汉字组成</small>
										</div>		

										<button type="button" id="studentReg" class="btn btn-primary btn-block">注册</button>
									</form>
									<!-- 注册表单 -->
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">返回登录</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-12"></div>
			</div>
		</div>
		<script type="text/javascript">
		$("#unumberReg").blur(function(){
			var unumber = $("#unumberReg").val();
			if (unumber=="") {
				$("#unumberHelp").css("background-color","red");
				$("#unumberHelp").text("学号不能为空!");
				return false;
			}
			var datas = {"action":"unumFind","unumber":unumber};
			$.ajax({
				url:"${pageContext.request.contextPath}/user",
				data:datas,
				type:"POST",
				async:true,
				dataType:"text",
				success:function(backdata){
					//alert(backdata);
					if (backdata=="can") {
						$("#unumberHelp").css("background-color","lime");
						$("#unumberHelp").text("学号可用!");
					}else{
						$("#unumberHelp").css("background-color","red");
						$("#unumberHelp").text("学号太受欢迎了!");
					} 
				}
			});
		});
		
		$("#studentReg").click(function(){
			var unumber = $("#unumberReg").val();
			var unumberReg = /^[0-9]{6}$/;
			if (!unumberReg.test(unumber)) {
				$("#unumberHelp").css("background-color","red");
				$("#unumberHelp").text("学号由6位数字组成!");
				return false;
			}else{
				$("#unumberHelp").css("background-color","lime");
				$("#unumberHelp").text("格式正确!");
			}
			var uname = $("#UsernameReg").val();
			var unameReg = /^[\u4E00-\u9FA5]{2,4}$/;
			if (!unameReg.test(uname)) {
				$("#usernameHelp").css("background-color","red");
				$("#usernameHelp").text("姓名由2-4个汉字组成组成");
				return false;
			}else{
				$("#usernameHelp").css("background-color","lime");
				$("#usernameHelp").text("格式正确!");
			}
			
			var upassword = $("#upasswordReg").val();
			var upasswordReg = /^[0-9A-Za-z]{3,8}$/;
			if (!upasswordReg.test(upassword)) {
				$("#passwordHelp").css("background-color","red");
				$("#passwordHelp").text("密码由3-8位字母数字组成");
				return false;
			}else{
				$("#passwordHelp").css("background-color","lime");
				$("#passwordHelp").text("格式正确!");
			}
			var usex = $("input[name='usex']:checked").val();
			var ucol = $("#college").val();
			var ucolReg = /^[\u4E00-\u9FA5]{3,10}$/;
			if (!ucolReg.test(ucol)) {
				$("#collegeHelp").css("background-color","red");
				$("#collegeHelp").text("学院名由3-10个汉字组成");
				return false;
			}else{
				$("#collegeHelp").css("background-color","lime");
				$("#collegeHelp").text("格式正确!");
			}
			var umajor = $("#major").val();
			var umajorReg = /^[\u4E00-\u9FA5]{3,10}$/;
			if (!umajorReg.test(umajor)) {
				$("#umajorHelp").css("background-color","red");
				$("#umajorHelp").text("专业名由3-10个汉字组成");
				return false;
			}else{
				$("#umajorHelp").css("background-color","lime");
				$("#umajorHelp").text("格式正确!");
			}
			var datas = {"action":"userRegister","unumber":unumber,"uname":uname,"upassword":upassword,"usex":usex,"ucol":ucol,"umajor":umajor};
			
			$.ajax({
				url:"${pageContext.request.contextPath}/user",
				data:datas,
				type:"POST",
				dataType:"text",
				success:function(msg){
					$("#regmsgshow").text(msg);
				}
			});
			return false;
		});
		$(function(){
			var datas = {"action":"noticeShow"};
			$.ajax({
				url:"${pageContext.request.contextPath}/notice",
				data:datas,
				type:"POST",
				dataType:"text",
				success:function(msg){
					//alert(msg);
				}
			});
		});
		</script>
	</body>
</html>
