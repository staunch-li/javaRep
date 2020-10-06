<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="pagepath" required="true" type="java.lang.String" %>
<div class="container-fluid">
		<nav aria-label="Page navigation example">
			<ul class="pagination pagination-lg justify-content-center">
				<c:if test="${page.first==1 }">
					<li class="page-item">
						<a class="page-link" href="${pagepath}&currentPage=1">First</a>
					</li>
				</c:if>
				<c:if test="${page.previous==1 }">
					<li class="page-item">
						<a class="page-link" href="${pagepath}&currentPage=${page.currentPage-1}" tabindex="-1" aria-disabled="true">Previous</a>
					</li>
				</c:if>
				<c:set scope="page" var="start" value="${page.currentPage-2 }"></c:set>
				<c:set scope="page" var="stop" value="${page.currentPage+2 }"></c:set>
				<c:if test="${start<1 }">
					<c:set scope="page" var="start" value="1"></c:set>
				</c:if>
				<c:if test="${stop>page.totalPage }">
					<c:set scope="page" var="stop" value="${page.totalPage}"></c:set>
				</c:if>
				<c:forEach begin="${start }" end="${stop}" step="1" varStatus="status" >
					<c:if test="${page.currentPage==status.index }">
						<li class="page-item active"><a class="page-link" href="${pagepath}&currentPage=${status.index }" >${status.index }</a></li>
					</c:if>
					<c:if test="${page.currentPage!=status.index }">
						<li class="page-item"><a class="page-link" href="${pagepath}&currentPage=${status.index }" >${status.index }</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${page.next==1 }">
					<li class="page-item">
						<a class="page-link" href="${pagepath}&currentPage=${page.currentPage+1}">Next</a>
					</li>
				</c:if>
				<c:if test="${page.last==1 }">
					<li class="page-item">
						<a class="page-link" href="${pagepath}&currentPage=${page.totalPage}">Last</a>
					</li>
				</c:if>
				<li class="page-item"><a class="page-link">${page.currentPage}/${page.totalPage}</a></li>
			</ul>
		</nav>
	</div>