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
				  <form class="form-inline">
				    <label for="condition" style="font-size: 1.2rem;">查询条件:</label>
				    <input type="text" class="form-control mb-2 mr-sm-2" id="condition" name="selectname" placeholder="例:李世民">
					
					<label class="mr-2" for="xingbie">性别:</label>
					<select class="custom-select mb-2 mr-sm-2" name="sex" id="xingbie" name="sex">
					  <option selected value="0">Choose...</option>
					  <option value="1">女:</option>
					  <option value="2">男:</option>
					</select>
					
				    <button type="submit" class="btn btn-primary mb-2">Search</button>
				  </form>
			  </div>
			  <div class="col-4">
			  	<button type="button" class="btn btn-danger" href="批量删除的java程序路径">批量删除</button>	  
			  </div>
		  </div>
	  </div>
    <div class="container-fluid">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered table-dark table-hover text-center">
				  <thead>
				    <tr>
				      <th scope="col"><input type="checkbox" name="total" id="total"/>Batch</th>
				      <th scope="col">Username</th>
				      <th scope="col">number</th>
					  <th scope="col">sex</th>
				      <th scope="col">college</th>
					  <th scope="col">major</th>
					  <th scope="col">subject</th>
					  <th scope="col">grade</th>
					  <th scope="col">photo</th>
					  <th scope="col">state</th>

				    </tr>
				  </thead>
				  <tbody>
					  <c:forEach items="${grade}" var="user">
						    <tr>
						      <th scope="row"><input type="checkbox" name="single"/></th>
						      <td>${user.uname }</td>
						      <td>${user.unumber }</td>
						      <td>${user.usex==1?'女':'男' }</td>
							  <td>${user.ucol}</td>
						      <td>${user.umajor}</td>
							  <td>${user.usub}</td>
							  <td>${user.ugrade}</td>
							  <td><img src="${photopath }/${user.uphoto}" width="30px" height="30px" class="rounded"></td>
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
			</div>
		</div>	
	</div>
  </body>
</html>