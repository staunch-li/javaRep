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
				      <th scope="col">留言编号</th>
				      <th scope="col">留言人姓名</th>
				      <th scope="col">留言人学号</th>
					  <th scope="col">留言标题</th>
					  <th scope="col">留言内容</th>
					  <th scope="col">留言回复</th>
					  <th scope="col">留言删除</th>
				    </tr>
				  </thead>
				  <tbody>
					  <c:forEach items="${page.datas}" var="message">
						    <tr>
						      <!-- <th scope="row"><input type="checkbox" name="single"/></th> -->
						      <td class="mid">${message.mid }</td>
						      <td class="mname">${message.mname }</td>
						      <td class="mnum">${message.mnum }</td>
							  <td class="title">${message.title}</td>
						      <td>${message.content}</td>
						      <td><button type="button" class="btn btn-success reply">回复</button></td>
						      <td><button type="button" class="btn btn-danger delete">删除</button></td>
						      
						    </tr>
					   </c:forEach>
				  </tbody>
				</table>
			</div>
		</div>	
	</div>
	<!-- 数据分页 页码 -->
	<p:mypaga pagepath="${pageContext.request.contextPath}/message?action=messagelist&currentPage=1"></p:mypaga>
 	<!-- 数据分页 页码 -->
 	
  </body>
  <script type="text/javascript">
	$(".delete").click(function(){
		var $tr = $(this).parent().parent();
		var mid = $tr.children(".mid").text();
		var datas = {"action":"daletemsg","mid":mid};
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
</script>
</html>