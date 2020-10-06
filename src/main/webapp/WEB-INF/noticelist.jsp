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
				      <th scope="col">公告编号</th>
				      <th scope="col">公告名称</th>
				      <th scope="col">公告内容</th>
					  <th scope="col">公告发布时间</th>
				      <th scope="col">公告状态</th>
				      <th scope="col">公告显示操作</th>
				      <th scope="col">公告删除操作</th>
				    </tr>
				  </thead>
				  <tbody>
					  <c:forEach items="${noticelist}" var="noticelist">
						    <tr>
						      <!-- <th scope="row"><input type="checkbox" name="single"/></th> -->
						      <td class="nid">${noticelist.nid }</td>
						      <td>${noticelist.nname }</td>
						      <td>${noticelist.ncontent }</td>
						      <td>${noticelist.ntime }</td>
							  <td class="showstate">
							  	<c:choose>
							  		<c:when test="${noticelist.nstate==1}">
							  			<button class="btn btn-sm btn-success">显示</button>
							  		</c:when>
							  		<c:when test="${noticelist.nstate==2}">
							  			<button class="btn btn-sm btn-light">不显示</button>
							  		</c:when>
							  	</c:choose>
							  </td>
							  <td class="adminop">
							  <button class="conceal btn btn-sm btn-danger" ${noticelist.nstate==2?'disabled':''}>公告不显示</button>
							  <button class="display btn btn-sm btn-info" ${noticelist.nstate==1?'disabled':''}>公告显示</button>
							  </td>
							  <td><button class="btn btn-sm btn-danger delete">删除公告</button></td>
						    </tr>
					   </c:forEach>
				  </tbody>
				</table>
			</div>
		</div>	
	</div>
  </body>
  <script type="text/javascript">
	$(".conceal").click(function(){
		var $tr = $(this).parent().parent();
		var $showstate = $tr.children(".showstate");
		var $adminop = $tr.children(".adminop");
		var $conceal = $(this);
		var $display = $(this).parent().children(".display");
		var nid =$tr.children(".nid").text();
		var datas = {"action":"conceal","nid":nid};
		$.ajax({	   
			url: "${pageContext.request.contextPath}/notice",
			data: datas,
			type: "POST",	
			dataType:"json",
			async: true,
			success: function(msg){
				$showstate.html("");
				$showstate.html('<button class="btn btn-sm btn-light">不显示</button>');
				$conceal.prop("disabled",true);
				$display.prop("disabled",false);
			}
		})
	})
	$(".display").click(function(){
		var $tr = $(this).parent().parent();
		var $showstate = $tr.children(".showstate");
		var $adminop = $tr.children(".adminop");
		var $display = $(this);
		var $conceal = $(this).parent().children(".conceal");
		var nid =$tr.children(".nid").text();
		var datas = {"action":"display","nid":nid};
		$.ajax({	   
			url: "${pageContext.request.contextPath}/notice",
			data: datas,
			type: "POST",	
			dataType:"json",
			async: true,
			success: function(msg){
				$showstate.html("");
				$showstate.html('<button class="btn btn-sm btn-success">显示</button>');
				$display.prop("disabled",true);
				$conceal.prop("disabled",false);
			}
		})
	})
	$(".delete").click(function(){
		var $tr = $(this).parent().parent();
		var nid = $tr.children(".nid").text();
		var datas = {"action":"delete","nid":nid};
		$.ajax({
			url: "${pageContext.request.contextPath}/notice",
			type: "POST",
			data: datas,
			dataType:"text",
			async: true,
			success: function(msg){
				alert(msg);
				 window.location.href=window.location.href;
				 window.location.reload;
			}
			
			});
	})
	
	</script>
</html>