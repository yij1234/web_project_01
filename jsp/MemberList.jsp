<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList.jsp</title>
</head>
<body>
<jsp:include page="AdminPage.jsp"/>
<h2 align="center">회원 목록</h2>
 <table border="1" width="90%">
        <tr>
            <th width="10%">번호</th>
            <th width="30%">회원 아이디</th>
            <th width="30%">회원 이름</th>
            <th width="30%">가입일자</th>
        </tr>
        <c:forEach items="${members }" var="members">
        	<c:set var="initNum" value="${totNum }"/>
	        <tr align="center">
	            <td>${initNum }</td>
	            <td align="center">
	                <a href="/member/adminpage.do?mode=adminview&user_id=${members.user_id }">${members.user_id }</a> 
	            </td>
	            <td align="center">${members.name }</td>
	            <td align="center">${members.regidate }</td>
	        </tr>
	        <c:set var="totNum" value="${initNum - 1 }"/>
        </c:forEach>
    </table>
</body>
</html>