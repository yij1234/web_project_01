<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h2 align="center">공지사항</h2><h4>현재 페이지 ${map.pageNum } / ${map.totalPage } (총게시물수 : ${map.totalCount })</h4>
	<jsp:include page="BoardIndex.jsp"/>
	<form method="get">
		<input type="hidden" name="mode" value="board">  
	    <table border="1" width="90%">
		    <tr>
		        <td align="center">
		            <select name="searchField"> 
		                <option value="title">제목</option> 
		                <option value="user_id">작성자</option>
		            </select>
		            <input type="text" name="searchWord" />
		            <input type="submit" value="검색하기" />
		        </td>
		        <td align="center">
		            <select name="searchField2"> 
		                <option value="5">5개씩 보기</option> 
		                <option value="10">10개씩 보기</option>
		                <option value="15">15개씩 보기</option>
		            </select>
		        </td>
		    </tr>   
	    </table>
    </form>
	<table border="1" width="90%">
        <tr>
            <th width="10%">번호</th>
            <th width="50%">제목</th>
            <th width="15%">작성자</th>
            <th width="10%">조회수</th>
            <th width="15%">작성일</th>
        </tr>
        <c:forEach items="${boards }" var="boards" varStatus="loop">
	        <tr align="center">
	            <td>${map.totalCount - ((map.pageNum - 1)  * map.pageSize + loop.index) }</td>
	            <td align="left">
	                <a href="/member/adminpage.do?mode=view&b_id=${boards.b_id }">${boards.title }</a> 
	            </td>
	            <td align="center">${boards.user_id }</td>
	            <td align="center">${boards.visitcount}</td>
	            <td align="center">${boards.postdate }</td>
	        </tr>
        </c:forEach>
    </table>
    <table border="1" width="90%">
        <tr align="right">
	        <td align="center">${map.pagingImg }</td>
	        <td><button type="button" onclick="location.href='/Board/Insert.jsp?mode=boardwrite';">글쓰기</button></td>
        </tr>
    </table>
</body>
</html>
