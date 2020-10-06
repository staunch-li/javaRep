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
				<h2>留言回复/通知页面</h2>
				<h3 id="updatepswshow" class="text-primary">${msg }</h3>
				  <input type="hidden" name="uid"/>
				  <div class="form-group">
				    <label for="title">留言名称:</label>
				    <input type="text" class="form-control" name="title" id="title" aria-describedby="titlehelp">
				    <small id="titlehelp" class="form-text text-muted">留言名称不能为空</small>
				  </div>
				  <div class="form-group">
				    <label for="content">留言内容:</label>
				    <input type="text" class="form-control" name="content" id="content" aria-describedby="contenthelp">
				    <small id="contenthelp" class="form-text text-muted">内容不能为空</small>
				  </div>
					<br/>
					<br/>
				  <button type="button" id="btn" class="btn btn-primary btn-block" ${user==null?'disabled':'' }>上传留言</button>
				  <button type="button" id="btn2" class="btn btn-primary btn-block">返回主页</button>
				</form>
			</div>
			<div class="col-4"></div>
		</div>
	</div>
	<script type="text/javascript">
	$("#btn2").click(function(){
		window.location.href='${pageContext.request.contextPath}/index.jsp';
	})
	$("#btn").click(function(){
		var title = $("#title").val();
		var content = $("#content").val();
		var datas = {"action":"upmessage","title":title,"content":content}
		$.ajax({
			url: "${pageContext.request.contextPath}/message",
			data: datas,
			type: "POST",
			dataType:"text",
			async: true,
			success: function(msg){
				alert(msg);
			   }
			});
	})
	</script>
</body>
</html>