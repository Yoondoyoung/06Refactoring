<%@ page contentType="text/html; charset=euc-kr" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<c:if test="${ resultPage.currentPage <= resultPage.pageUnit }">
			�� ����
	</c:if>
	<c:if test="${ resultPage.currentPage > resultPage.pageUnit }">
			<a href="/listProduct.do?page=${resultPage.currentPage - 1}&menu=${menu=='manage' ? 'manage' : 'search' }&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}">�� ����</a>
	</c:if>
	
	<c:forEach var="i"  begin="${resultPage.beginUnitPage}" end="${resultPage.endUnitPage}" step="1">
		<a href="/listProduct.do?page=${i}&menu=${menu=='manage' ? 'manage' : 'search' }&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}">${ i }</a>
	</c:forEach>
	
	<c:if test="${ resultPage.endUnitPage >= resultPage.maxPage }">
			���� ��
	</c:if>
	<c:if test="${ resultPage.endUnitPage < resultPage.maxPage }">
			<a href="/listProduct.do?page=${resultPage.endUnitPage + 1}&menu=${menu=='manage' ? 'manage' : 'search' }&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}">���� ��</a>
	</c:if>
	

	
	