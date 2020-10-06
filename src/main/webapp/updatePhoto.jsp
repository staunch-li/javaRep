<%@page import="java.net.URLDecoder"%>
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
<title>用户头像修改</title>
<style type="text/css">
</style>
</head>
<body>

	<div class="container-fluid">
		<div class="row" style="height: 120px;"></div>
		<div class="row">
			<div class="col-lg-4 col-md-4 col-sm-12"></div>
			<div
				class="col-lg-4 col-md-4 col-sm-12 border border-light rounded-lg pt-4 pb-4">
				<form action="${pageContext.request.contextPath}/user?action=updatemyphoto"
					method="post" class="text-white" enctype="multipart/form-data">
					<!-- 有文件上传的表单,需要修改 上传数据的格式  enctype="multipart/form-data"
						另外必须是post提交方式!
					-->
					<h2 class="text-dark">头像修改</h2>
					<h2 class="text-dark">${msg }</h2>
					<div class="custom-file">
						<input type="file" class="custom-file-input" id="photo" name="photo">
						<label class="custom-file-label" for="photo btn-lg">Choose file</label>
					</div>
					<button type="submit" class="btn btn-info btn-block btn-lg" ${user==null?'disabled':'' }>Submit</button>
					<button type="button" id="btn2" class="btn btn-primary btn-block">返回主页</button>
				</form>

				<div class="col-lg-4 col-md-4 col-sm-12"></div>
			</div>
		</div>
</body>
<script type="text/javascript">
$("#btn2").click(function(){
	window.location.href='${pageContext.request.contextPath}/index.jsp';
})
</script>
</html>
