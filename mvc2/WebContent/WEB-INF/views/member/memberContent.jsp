<%@page import="kr.smhrd.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberVO vo = (MemberVO)request.getAttribute("vo");
	String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		font-size: 12px;
	}
</style>

<script type="text/javascript">

function deleteFn(num){
	location.href = "<%=ctx%>/delete.do?num="+num;
}

function list(){
	location.href = "<%=ctx%>/list.do";
}

</script>


</head>
<body>
<fieldset>
	<legend> <%=vo.getName()%>님의 정보 상세보기 </legend>
	<form action = "<%=ctx%>/update.do" method = "post">
	<input type = "hidden" name = "num" value = "<%=vo.getNum()%>">
	<table border = "1px">
		<tr>
			<td>번호</td>
			<td><%=vo.getNum()%></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%=vo.getId()%></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=vo.getPass()%></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type = "text" value = "<%=vo.getTel()%>" name = "tel"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type = "text" value = "<%=vo.getEmail()%>" name = "email"></td>
		</tr>
		<tr >
			<td colspan = "2" align = "center">
				<input type = "submit" value = "수정하기">
				<input type = "button" value = "삭제" onclick = "deleteFn(<%=vo.getNum()%>)">
				<input type = "button" value = "리스트" onclick = "location.href='<%=ctx%>/list.do'">
			</td>
		</tr>
	
	</table>
	</form>
</fieldset>


</body>
</html>