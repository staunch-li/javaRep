<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
	<link rel="icon" type="text/css" href="${pageContext.request.contextPath}/img/favicon.png" />
    <link rel="stylesheet" href="css/bootstrap.min.css">
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <title>	Custmer 数据表格(可打印)</title>
  </head>
  <body>
	  <div class="container-fluid">
		  <div class="row pt-2">
			  <div class="col-8">
			  </div>
			  <div class="col-4">  
			  </div>
		  </div>
	  </div>
    <div class="container-fluid">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered table-dark table-hover text-center">
				  <thead>
				    <tr>
				      <!-- <th scope="col"><input type="checkbox" name="total" id="total"/>Batch</th> -->
				      <th scope="col">姓名</th>
				      <th scope="col">学号</th>
					  <th scope="col">性别</th>
				      <th scope="col">学院</th>
					  <th scope="col">专业</th>
					  <th scope="col">科目</th>
					  <th scope="col">成绩</th>
					  <th scope="col">头像</th>
					  <th scope="col">点赞量</th>
					  <th scope="col">账号状态</th>

				    </tr>
				  </thead>
				  <tbody>
					  <c:forEach items="${mygrade}" var="user">
						    <tr>
						      <!-- <th scope="row"><input type="checkbox" name="single"/></th> -->
						      <td>${user.uname }</td>
						      <td>${user.unumber }</td>
						      <td>${user.usex==1?'女':'男' }</td>
							  <td>${user.ucol}</td>
						      <td>${user.umajor}</td>
							  <td>${user.usub}</td>
							  <td>${user.ugrade}</td>
							  <td><img src="${photopath }/${user.uphoto}" width="30px" height="30px" class="rounded"></td>
							  <td>${user.ulike}</td>
							  <td>
							  	<c:choose>
							  		<c:when test="${user.ustate==1}">
							  			<button class="btn btn-sm btn-success">正常</button>
							  		</c:when>
							  		<c:when test="${user.ustate==2}">
							  			<button class="btn btn-sm btn-light">注销</button>
							  		</c:when>
							  	</c:choose>
							  </td>
						    </tr>
					   </c:forEach>
				  </tbody>
				</table>
				<button type="button" id="btn" class="btn btn-info btn-lg">返回学生主页</button>
			</div>
		</div>	
	</div>
  </body>
	  <script type="text/javascript">
	$("#btn").click(function(){
		 window.location.href='${pageContext.request.contextPath}/index.jsp';
	})
	</script>
</html>