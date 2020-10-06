<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="icon"
	href="${pageContext.request.contextPath}/img/favicon.png" sizes="32X32" />
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
	type="text/javascript" charset="utf-8"></script>
<title>Customer Update</title>
<style type="text/css">
body {
	background-image: url(${pageContext.request.contextPath}/images/pp8.jpg);
	background-size: cover;
}
.ppp{
	height: 150px
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row" >
			<div class="ppp" ></div>
		</div>
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<form method="post" action="">
				<h2>客户部分信息修改</h2>
				<h3 id="updatepswshow" class="text-primary">${msg }</h3>
				  <input type="hidden" name="uid"/>
				  <div class="form-group">
				    <label for="oldpassword">老密码:</label>
				    <input type="text" class="form-control" name="oldpassword" id="oldpassword" aria-describedby="UsernameHelp">
				    <small id="UsernameHelp" class="form-text text-muted">密码由3-8位字母数字下滑线组成</small>
				  </div>
				  <div class="form-group">
				    <label for="newpassword">新密码:</label>
				    <input type="text" class="form-control" id="newpassword" name="newpassword" aria-describedby="newpasswordHelp">
				  	<small id="newpasswordHelp" class="form-text text-muted">密码由3-8位字母数字下滑线组成</small>
				  </div>
				  <div class="form-group">
				    <label for="newpasswordrepeat">重复密码:</label>
				    <input type="text" class="form-control" id="newpasswordrepeat" name="newpasswordrepeat">
				  </div>
					<br/>
					<br/>
				  <button type="button" id="btn" class="btn btn-primary btn-block" ${user==null?'disabled':'' }>修改</button>
				  <button type="button" id="btn2" class="btn btn-primary btn-block">返回主页</button>
				</form>
			</div>
			<div class="col-4"></div>
		</div>
	</div>
	<script type="text/javascript">
	$("#btn").attr("disabled",true);
	$("#oldpassword").blur(function(){
		var oldpsw = $("#oldpassword").val();
		var datas = {"action":"upswfind","oldpsw":oldpsw};
		$.ajax({		   
			url:"${pageContext.request.contextPath}/user",
			data:datas,
			type:"POST",
			async:true,
			dataType:"text",
			success:function(backdata){
			//alert(backdata);
					if (backdata=="yes") {
						$("#UsernameHelp").css("background-color","lime");
						$("#UsernameHelp").text("密码匹配成功");
						$("#btn").attr("disabled",false);
					}else{
						$("#UsernameHelp").css("background-color","red");
						$("#UsernameHelp").text("原密码不正确");
						$("#btn").attr("disabled",true);
					}
			}
		});
	});
	$("#btn").click(function(){
		var newpassword = $("#newpassword").val();
		var newpasswordrepeat = $("#newpasswordrepeat").val();
		var datas = {"action":"updatePSW","newpassword":newpassword,"newpasswordrepeat":newpasswordrepeat};
		$.ajax({		   
			url:"${pageContext.request.contextPath}/user",
			data:datas,
			type:"POST",
			async:true,
			dataType:"text",
			success:function(backdata){
				alert(backdata);
				/* $("#updatepswshow").text(backdata); */
			}
		});
	})
	$("#btn2").click(function(){
		window.location.href='${pageContext.request.contextPath}/index.jsp';
	})
	</script>
</body>
</html>