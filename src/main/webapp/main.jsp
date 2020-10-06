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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<title>学生管理系统后台管理</title>
		<style type="text/css">
		/* body {
				background-image: url(${pageContext.request.contextPath}/images/pp12.png;);
				background-size: cover;
			} */
		#ww{
		margin-top: 70px;
		margin-left: 70px;
		}
		#h2{
		margin-top: 70px;
		}
		#a{
		margin-left: 15px;
		}
		</style>
		
	</head>
	<body>
		<div class="container-fluid">
			<div class="row">
				<div class="col-2" >
					<div class="row">
					<div class="col-3"></div>
					<div class="col-9">
					<a href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/images/数据加密.png" width="120px" height="120px"></a>
					</div>
					</div>
				</div>
				<div class="col-8" id="h2">
					<h2>学生管理系统后台页面</h2>
				</div>
				<div class="col-2">
					<div class="btn-group " id="ww">
						<button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
						 aria-expanded="false">
							管理员信息
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item">
								<img src="${pageContext.request.contextPath}/img/tou.png" class="rounded-circle w-50 h-50" />
							</a>
							<a class="dropdown-item">身份：${admin.rname}</a>
							<a class="dropdown-item">用户名：${admin.aname}</a>
							<div class="dropdown-divider"></div>
							<div class="row">
							<div class="col-4"></div>
							<div class="col-6">
							<a class="" href="${pageContext.request.contextPath}/admin?action=exit"><img src="${pageContext.request.contextPath}/images/退出.png" width="50%"></a>
							</div>
							<div class="col-2"></div>
							</div>
						</div>
					</div>
					
					<a href="index.jsp" class="ml-3"><img src="${pageContext.request.contextPath}/images/登录.png" width="20%" /></a>
					
				</div>
			</div>
		</div>
		<div class="container-fluid mt-2">
			<div class="row" style="height: 600px;">
				<div class="col-2">
					<div class="accordion" id="accordionExample">
						
						<div class="card">
							<div class="card-header" id="headingOne">
								<h2 class="mb-0">
									<button class="btn btn-link btn-block text-left active" type="button" data-toggle="collapse" data-target="#collapseOne"
									 aria-expanded="false" aria-controls="collapseOne">
										学生管理
									</button>
								</h2>
							</div>

							<div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
								<div class="card-body">
									<!-- 一堆超链接 -->
									<div class="btn-group-vertical" role="group" aria-label="Basic example">
									
									<%-- <a href="${pageContext.request.contextPath}/user?action=userlist" class="btn btn-secondary">学生列表</a> --%>
									
									<a href="${pageContext.request.contextPath}/user?action=userlistPage&currentPage=1" target="myframe" class="btn btn-info">学生列表管理</a>
									</div>
									</div>
								</div>
							</div>
						
						<div class="card">
							<div class="card-header" id="headingTwo">
								<h2 class="mb-0">
									<button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo"
									 aria-expanded="false" aria-controls="collapseTwo">
										学院专业分类管理
									</button>
								</h2>
							</div>
							<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
								<div class="card-body">
									<!-- 一堆超链接 -->
									<div class="btn-group-vertical" role="group" aria-label="Basic example">
									  <a href="${pageContext.request.contextPath}/category?action=categorylist" target="myframe" class="btn btn-primary">学院专业分类管理</a>
									  <!-- <a href="" class="btn btn-secondary">新增列表</a> -->
									 <!-- <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal" >添加学院</button> -->
										<%-- <a type="button" class="btn btn-info" data-toggle="modal" data-target="#exampleModal2" href="${pageContext.request.contextPath}/category?action=categorylist" >添加专业</a> --%>										
										<!-- <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
										  <div class="modal-dialog">
										    <div class="modal-content">
										      <div class="modal-header">
										        <h5 class="modal-title" id="exampleModalLabel">添加学院</h5>
										        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
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
										        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
										        
										      </div>
										    </div>
										  </div>
										</div> -->
									</div>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingThree">
								<h2 class="mb-0">
									<button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree"
									 aria-expanded="false" aria-controls="collapseThree">
									公告管理
									</button>
								</h2>
							</div>
							<div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
								<div class="card-body">
									<!-- 一堆超链接 -->
									<div class="btn-group-vertical" role="group" aria-label="Basic example">
									  <a href="${pageContext.request.contextPath}/notice?action=noticeList" class="btn btn-primary" target="myframe">公告列表</a>
									  <a href="${pageContext.request.contextPath}/filter/addnotice.jsp" class="btn btn-success" target="myframe">新增公告</a>
									</div>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingThree">
								<h2 class="mb-0">
									<button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapsefour"
									 aria-expanded="false" aria-controls="collapseThree">
									留言管理
									</button>
								</h2>
							</div>
							<div id="collapsefour" class="collapse show" aria-labelledby="headingThree" data-parent="#accordionExample">
								<div class="card-body">
									<!-- 一堆超链接(target指定在哪显示) -->
									<div class="btn-group-vertical" role="group" aria-label="Basic example">
									  <a href="${pageContext.request.contextPath}/message?action=messagelist&currentPage=1" target="myframe" class="btn btn-primary">留言列表</a>
									  <a href="${pageContext.request.contextPath}/replymsg.jsp" class="btn btn-success" target="myframe">留言回复</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-10">
					<iframe name="myframe" src="${pageContext.request.contextPath}/default.html" frameborder="0" scrolling="auto" width="100%" height="100%"></iframe>
						<!-- <div class="embed-responsive embed-responsive-16by9">
						  <iframe class="embed-responsive-item" src="login.html"></iframe>
					</div> -->
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
	$("#addcol").click(function(){
		var col = $("#newcol").val();
		var  datas= {"action":"addnewcol","col":col}
		if (col=="") {
			alert("输入值不能为null");
		}else{
			$.ajax({
				   type: "POST",
				   url: "${pageContext.request.contextPath}/category",
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
</html>