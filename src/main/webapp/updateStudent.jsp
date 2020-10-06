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
	background-image: url(${pageContext.request.contextPath}/images/pp11.jpg;);
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
				
				<h3 class="text-primary">学生部分信息修改</h3>
				  <input type="hidden" name="uid" value="${user.uid }" id="uid"/>
				  <div class="form-group">
				    <label for="Unumber">学号</label>
				    <input type="text" class="form-control" name="unumber" value="${user.unumber }" id="Unumber" aria-describedby="UnumberHelp" readonly="readonly">
				    <small id="UnumberHelp" class="form-text text-muted">学号不可更改!</small>
				  </div>
				<div class="form-group">
				    <label for="Username">姓名</label>
				    <input type="text" class="form-control" name="uname" value="${user.uname }" id="Username" aria-describedby="UsernameHelp" readonly="readonly">
				    <small id="UsernameHelp" class="form-text text-muted">姓名不可更改!</small>
				  </div>
				  <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" id="sex1" value="1" name="usex" ${user.usex==1?'checked':'' }>
					  <label class="form-check-label" for="inlineCheckbox1">女</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" id="sex2" value="2" name="usex" ${user.usex==2?'checked':'' }>
					  <label class="form-check-label" for="inlineCheckbox2">男</label>
					</div>
					<div class="form-group">
				    <label for="Usercol">学院</label>
				    <input type="text" class="form-control" name="ucol" value="${user.ucol }" id="ucol" aria-describedby="UsercolHelp">
				    <small id="UsercolHelp" class="form-text text-muted">学院名由3-10个汉字组成!</small>
				  </div>
				  <div class="form-group">
				    <label for="Usermajor">专业</label>
				    <input type="text" class="form-control" name="umajor" value="${user.umajor }" id="umajor" aria-describedby="UsermajorHelp">
				    <small id="UsermajorHelp" class="form-text text-muted">专业名由3-10个汉字组成!</small>
				  </div>
					<br/>
					<br/>
					
				  <button type="button" class="btn btn-primary btn-block" ${user==null?'disabled':'' }>修改</button>
				 <button type="button" id="bb" class="btn-primary btn-block">返回主页</button>
				
			</div>
			<div class="col-4"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(".btn").click(function(){
	var uid = $("#uid").val();
	var usex = $("input[name='usex']:checked").val();
	var ucol = $("#ucol").val();
	var umajor = $("#umajor").val();
	var datas = {"action":"update","uid":uid,"usex":usex,"ucol":ucol,"umajor":umajor};
	$.ajax({		   
		url:"${pageContext.request.contextPath}/user",
		data:datas,
		type:"POST",
		async:true,
		dataType:"text",
		success:function(backdata){
			alert(backdata);
		}
	});
})
$("#bb").click(function(){
	window.location.href='${pageContext.request.contextPath}/index.jsp';
})
</script>
</html>