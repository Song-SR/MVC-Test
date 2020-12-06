<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%	String ctx = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font-size: 12px;
}
</style>
</head>
<body>
	<fieldset>
		<legend>회원가입화면</legend>
		<form action="insert.do" method = "post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="pass"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="tel"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td colspan = "2" align = "center">
						<input type="submit" value="회원가입">
						<input type="reset" value="취소" onclick = "location.href='<%=ctx%>/list.do'">
					</td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>