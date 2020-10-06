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
				<h2>校长信箱</h2>
				<h3 id="updatepswshow" class="text-primary">${msg }</h3>
				  <input type="hidden" name="uid"/>
				  <div class="form-group">
				    <label for="rnum">(回复/通知)人:</label>
				    <input type="text" class="form-control" name="rnum" id="rnum" aria-describedby="rnumhelp" value="${mnum}" required="required">
				    <small id="rnumhelp" class="form-text text-muted">(回复/通知)人不能为空</small>
				  </div>
				  <div class="form-group">
				    <label for="rtitle">(回复/通知)名称:</label>
				    <input type="text" class="form-control" name="rtitle" id="rtitle" value="${title }" aria-describedby="rtitlehelp" required="required">
				    <small id="rtitlehelp" class="form-text text-muted">(回复/通知)名称不能为空</small>
				  </div>
				  <div class="form-group">
				    <label for="rreply">(回复/通知)内容:</label>
				    <input type="text" class="form-control" name="rreply" id="rreply" aria-describedby="rreplyhelp" required="required">
				    <small id="rreplyhelp" class="form-text text-muted">内容不能为空</small>
				  </div>
					<br/>
					<br/>
				  <button type="button" id="btn" class="btn btn-primary btn-block" ${admin==null?'disabled':'' }>回复/通知</button>
				</form>
			</div>
			<div class="col-4"></div>
		</div>
	</div>
	<script type="text/javascript">
	$(".btn").click(function(){
	var rnum = $("#rnum").val();
	var rtitle = $("#rtitle").val();
	var rreply = $("#rreply").val();
	if(rnum==""&&rnum==""&&rreply==""){
		alert('输入框不能为空');
	}else{
		var datas = {"action":"replymsg","rnum":rnum,"rtitle":rtitle,"rreply":rreply};
		$.ajax({
			   url: "${pageContext.request.contextPath}/message",
			   type: "POST",
			   data: datas,
			   dataType:"text",
			   async: true,
			   success: function(msg){
			     alert(msg);
			   }
			});
	}
	
	})
	
	</script>
</body>
</html>