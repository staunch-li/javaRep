<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>categorylist</title>
<style type="text/css">
body {
	background-image: url(${pageContext.request.contextPath}/myimgs/i7.jpg);
	background-size: cover;
}
/* #a1{
margin-left: 80px
} */
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="height: 120px;"></div>
		<div class="row">
			<div class="col-lg-3 col-md-4 col-sm-12">
			<div class="row">
			<button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#exampleModal" id="a1">添加学院</button>
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal"  data-target="#exampleModal3">更改该学院名字</button>
			<button type="button" class="btn btn-danger btn-lg" data-toggle="modal" id="deletecol" onclick="del()">删除该学院</button>
			</div>
				<div class="modal fade" id="exampleModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">添加学院</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form>
									<div class="form-group">
										<label for="recipient-name" class="col-form-label">添加学院</label>
										<input type="text" class="form-control" id="newcol">
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" id="addcol">添加</button>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">关闭</button>
							</div>  
						</div>
					</div>
				</div>
				<div class="modal fade" id="exampleModal3" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">修改学院名</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form>
									<div class="form-group">
										<label for="recipient-name" class="col-form-label">修改学院名</label>
										<input type="text" class="form-control" id="updatecol">
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" id="updatecolname">修改</button>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">关闭</button>
							</div>  
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-12">
				<select class="custom-select custom-select-lg mb-3" id="category">
					<option selected value="c0">-学院分类-</option>
					<c:forEach items="${cates }" var="cate">
						<option value="${cate.cid }">${cate.ccol }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-12">
				<select class="custom-select custom-select-lg mb-3"
					id="smallcategory">
					<option selected value="s0">-专业分类-</option>
				</select>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-12">
			<div class="row">
			<button type="button" class="btn btn-success btn-lg" data-toggle="modal"
					data-target="#exampleModal2"
					href="${pageContext.request.contextPath}/category?action=categorylist">在所选学院中添加新专业</button>
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#exampleModal4">修改该专业名</button>
			<button type="button" class="btn btn-danger btn-lg" data-toggle="modal" id="deletemaj">删除该专业</button>
			</div>
					<div class="modal fade" id="exampleModal2" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">添加专业</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form>									
									<div class="form-group">
										<label for="message-text" class="col-form-label">添加专业</label>
										<textarea class="form-control" id="newmajor"></textarea>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" id="addmajor">添加</button>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">关闭</button>
							</div>
						</div>
					</div>
				</div>
				<div class="modal fade" id="exampleModal4" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">修改专业名</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form>
									<div class="form-group">
										<label for="recipient-name" class="col-form-label">修改专业名</label>
										<input type="text" class="form-control" id="updatemaj">
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" id="updatemajname">修改</button>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">关闭</button>
							</div>  
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
<script type="text/javascript">
	$("#category").change(function() {
		$("#smallcategory").empty();
		var cateValue = $("#category option:selected").val();
		if (cateValue == "c0") {
			var $op = $("$<option></option>");
			$op.val("s0");
			$op.text("-专业分类-");
			$("smallcategory").append($op);
			return;
		}
		var datas = {
			"action" : "smcateByCid",
			"cid" : cateValue
		};
		$.ajax({
			url : "${pageContext.request.contextPath}/category",
			data : datas,
			type : "POST",
			async : true,
			dataType : "json",
			success : function(smcates) {
				for (var i = 0; i < smcates.length; i++) {
					var smcate = smcates[i];
					var $op = $("<option></option>");
					$op.val(smcate.sid);
					$op.text(smcate.smajor);
					$("#smallcategory").append($op);
				}
			}
		});
	});
	$("#addcol").click(function(){
		var col = $("#newcol").val();
		var  datas= {"action":"addnewcol","col":col}
		if (col=="") {
			alert("输入值不能为空");
		}else{
			$.ajax({
				   type: "POST",
				   url: "${pageContext.request.contextPath}/category",
				   data: datas,
				   dataType:"text",
				   async: true,
				   success: function(msg){
				     alert(msg);
				     window.location.href=window.location.href;
					 window.location.reload;
				   }
				});
		}
	})
	$("#addmajor").click(function(){
		var major = $("#newmajor").val();
		var cid = $("#category option:selected").val();
		var datas= {"action":"addnewmaj","newmajor":major,"cid":cid}
		if (major=="") {
			alert("输入值不能为空");
		}else{
			$.ajax({
				   type: "POST",
				   url: "${pageContext.request.contextPath}/category",
				   data: datas,
				   dataType:"text",
				   async: true,
				   success: function(msg){
				     alert(msg);
				     window.location.href=window.location.href;
					 window.location.reload;
				   }
				});
		}
	})
	
	function del() {
		var cid = $("#category option:selected").val();
		var datas= {"action":"deletecol","cid":cid};
		var msg =confirm("你确定要删除该学院吗?");
        if(msg){
            $.ajax({
				   type: "POST",
				   url: "${pageContext.request.contextPath}/category",
				   data: datas,
				   dataType:"text",
				   async: true,
				   success: function(msg){
				     alert(msg);
				     window.location.href=window.location.href;
					 window.location.reload;
				   }
				});
        }else {
            alert("已经取消了删除操作");
        }
	}
	$("#deletemaj").click(function(){
		var sid = $("#smallcategory option:selected").val();
		var datas= {"action":"deletemaj","sid":sid};
		var msg =confirm("你确定要删除该专业吗?");
        if(msg){
            $.ajax({
				   type: "POST",
				   url: "${pageContext.request.contextPath}/category",
				   data: datas,
				   dataType:"text",
				   async: true,
				   success: function(msg){
				     alert(msg);
				     window.location.href=window.location.href;
					 window.location.reload;
				   }
				});
        }else {
            alert("已经取消了删除操作");
        }
	})
	$("#updatecolname").click(function(){
		var newcolname = $("#updatecol").val();
		var cid = $("#category option:selected").val();
		var datas= {"action":"updatecolname","newcolname":newcolname,"cid":cid}
		alert(newcolname+cid);
		if (newcolname=="") {
			alert("输入值不能为空");
		}else{
			$.ajax({
				   type: "POST",
				   url: "${pageContext.request.contextPath}/category",
				   data: datas,
				   dataType:"text",
				   async: true,
				   success: function(msg){
				     alert(msg);
				     window.location.href=window.location.href;
					 window.location.reload;
				   }
				});
		}
	})
	$("#updatemajname").click(function(){
		var newmajname = $("#updatemaj").val();
		var sid = $("#smallcategory option:selected").val();
		var datas= {"action":"updatemajname","newmajname":newmajname,"sid":sid}
		if (newmajname=="") {
			alert("输入值不能为空");
		}else{
			$.ajax({
				   type: "POST",
				   url: "${pageContext.request.contextPath}/category",
				   data: datas,
				   dataType:"text",
				   async: true,
				   success: function(msg){
				     alert(msg);
				     window.location.href=window.location.href;
					 window.location.reload;
				   }
				});
		}
	})
        
</script>
</html>
