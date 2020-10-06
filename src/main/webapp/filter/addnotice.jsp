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
	background-image: url(${pageContext.request.contextPath}/images/pp12.png;);
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
				<form method="post" action="${pageContext.request.contextPath}/notice?action=addnotice">
					<h3 class="text-primary">新增公告</h3> 
					<h3 class="text-primary">${noticecan}</h3>
					  <div class="form-group">
					    <label for="nname">通知名称</label>
					    <input type="text" class="form-control" name="nname" id="nname">				    
					  </div>
					  <div class="form-group">
					    <label for="ncontent">通知内容</label>
					    <input type="text" class="form-control" name="ncontent" id="ncontent">				    
					  </div>
					  <div class="form-group">
					    <label for="ntime">通知时间</label>
					    <input type="date" class="form-control" name="ntime" id="ntime">				    
					  </div>
						<br/>
						<br/>
						
					  <button type="submit" class="btn btn-primary btn-block" ${admin==null?'disabled':'' }>增加</button>
					  <button type="button" id="btn2" class="btn btn-primary btn-block">返回主页</button>
				</form>
			</div>
			<div class="col-4"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
$("#gettime").click(function(){
	strTime = new Date();
	$("#ntime").val(strTime)
})
</script>
</html>