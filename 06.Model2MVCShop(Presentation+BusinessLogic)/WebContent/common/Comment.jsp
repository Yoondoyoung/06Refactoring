<%@ page contentType="text/html; charset=euc-kr" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
	<c:forEach var="cmt" items="${comment}">
		<tr>
			<td width="104" class="ct_write">${cmt.userId.userId }<img
				src="/images/ct_icon_red.gif" width="1" height="1" align="absmiddle" />
			</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<c:if test="${cmt.userId.userId==user.userId}">
				<td class="ct_write01">${cmt.comment }</td>
				<td><a href="updateComment.do">¼öÁ¤</a>
			</c:if>
			<c:if test="${cmt.userId.userId!=user.userId}">
				<td class="ct_write01">${cmt.comment }</td>
			</c:if>
			<br />
		</tr>

	</c:forEach>
</table>