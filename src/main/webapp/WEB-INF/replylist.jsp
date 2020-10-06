<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="p" %>
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
				  <form class="form-inline" action="">
				   <%--  <label for="condition" style="font-size: 1.2rem;">查询条件:</label>
				    <input type="text" class="form-control mb-2 mr-sm-2" id="condition" name="condition" placeholder="例:李世民">
					
					<!-- <label class="mr-2" for="xingbie">性别:</label>
					<select class="custom-select mb-2 mr-sm-2" name="sex" id="xingbie" name="sex">
					  <option selected value="0">Choose...</option>
					  <option value="1">女:</option>
					  <option value="2">男:</option>
					</select> -->
					<a href="${pageContext.request.contextPath}/user?action=userlistPage" type="button" class="btn btn-primary mb-2" >Search</a>
				    <button type="submit" class="btn btn-primary mb-2">Search</button> --%>
				  </form>
			  </div>
			  <div class="col-4">
			  	<!-- <button type="button" class="btn btn-danger" href="批量删除的java程序路径">批量删除</button>	   -->
			  </div>
		  </div>
	  </div>
    <div class="container-fluid">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered table-hover text-center">
				  <thead>
				    <tr>
				      <!-- <th scope="col"><input type="checkbox" name="total" id="total"/>Batch</th> -->
				      <th scope="col">信息编号</th>
				      <th scope="col">(回复/通知)标题</th>
				      <th scope="col">内容</th>
					  <th scope="col">操作</th>
				    </tr>
				  </thead>
				  <tbody>
					  <c:forEach items="${reply}" var="reply">
						    <tr>
						      <!-- <th scope="row"><input type="checkbox" name="single"/></th> -->
						      <td class="rid">${reply.rid }</td>
						      <td>${reply.rtitle }</td>
						      <td>${reply.rreply }</td>
						      <td><button type="button" class="btn btn-danger delete">删除</button></td>
						    </tr>
					   </c:forEach>
					 </tbody>
				</table>
			</div>
		</div>
		<button type="button" id="btn2" class="btn btn-primary btn-block">返回主页</button>	
	</div>
  </body>
  <script type="text/javascript">
	$(".delete").click(function(){
		var $tr = $(this).parent().parent();
		var rid = $tr.children(".rid").text();
		var datas = {"action":"daletereply","rid":rid};
		$.ajax({
			   data: datas,
			   type: "POST",
			   url: "${pageContext.request.contextPath}/message",
			   dataType:"text",
			   async: true,
			   success: function(msg){
			     alert(msg);
			     window.location.href=window.location.href;
				 window.location.reload;
			   }
			});
	})
	$(".reply").click(function(){
		var $tr = $(this).parent().parent();
		var mnum = $tr.children(".mnum").text();
		var title = $tr.children(".title").text();
		var datas = {"action":"reply","mnum":mnum,"title":title};
		$.ajax({
			   type: "POST",
			   url: "${pageContext.request.contextPath}/message",
			   data: datas,
			   dataType:"text",
			   async: true,
			   success: function(msg){
				     window.location.href='${pageContext.request.contextPath}/replymsg.jsp';
					 
				   }
			});
	})
	$("#btn2").click(function(){
		window.location.href='${pageContext.request.contextPath}/index.jsp';
	})
</script>
</html>