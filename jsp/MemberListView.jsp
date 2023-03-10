<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberListView</title>
<style>
	.item{background: lightgray; font-weight: bold;}
</style>
</head>
<body>
<jsp:include page="AdminPage.jsp"/>
<h2 align="center">회원 상세 보기(관리자)</h2>
<form name="writeFrm">
	<input type="hidden" name="id" value="아이디"/>
    <input type="hidden" name="num" value="번호" />
    <table border="1" width="90%">
        <tr>
            <td class="item">아이디</td>
            <td>${dto.user_id }</td>
            <td class="item">비밀번호</td>
            <td>${dto.user_pass }</td>
        </tr>
        <tr>
            <td class="item">회원이름</td>
            <td>${dto.name }</td>
            <td class="item">회원닉네임</td>
            <td>${dto.nick }</td>
        </tr>
        <tr>
            <td class="item">전화번호</td>
            <td>${dto.tel }</td>
            <td class="item">이메일</td>
            <td>${dto.email }</td>
        </tr>
        <tr>
            <td class="item">질문</td>
            <td>${dto.ask }</td>
            <td class="item">답변</td>
            <td>${dto.answer }</td>
        </tr>
        <tr>
            <td class="item">선호장르</td>
            <td>${dto.fav_movie }</td>
            <td class="item">가입일</td>
            <td>${dto.regidate }</td>
        </tr>
        <tr>
        	<td class="item">등급</td>
            <td>${dto.user_class }</td>
        </tr>
        <tr>
            <td colspan="4" align="center">
           		<button type="button">삭제하기</button>
                <button type="button">목록보기</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>