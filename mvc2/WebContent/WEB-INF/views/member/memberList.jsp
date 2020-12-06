<%@page import="kr.smhrd.model.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
	String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트보기</title>
<style type="text/css">
body {
	font-size: 12px;
}

.title{
		background-color: gray;
	}
	
	.content{
		background-color: whitesmoke;
	}


</style>

<script type="text/javascript">
	
	function insertForm(){
		location.href="<%=ctx%>/insertForm.do";
	}
	
</script>

</head>
<body>
<h1>-MVC2 Framework : 팀명(지으니의 수족관)</h1>
	<table width = "550px">
		<tr class = "title">
			<td>번호</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>전화번호</td>
			<td>이메일</td>
			<td>삭제</td>
		</tr>

		<%-- <%
	for(int i = 0; i < list.size(); i++){
		MemberVO vo = list.get(i);%> --%>

		<%
			// 향상된 for문 (담겨있는 변수 : 컬렉션류 객체) = enhanced for문  = for each문  
			for (MemberVO vo : list) {
		%>

		<tr class = "content">
			<td><%=vo.getNum()%></td>
			<td><a href = "<%=ctx%>/content.do?num=<%=vo.getNum()%>"><%=vo.getId()%></a></td>
			<td><%=vo.getPass()%></td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getTel()%></td>
			<td><%=vo.getEmail()%></td>
			<td><a href = "<%=ctx%>/delete.do?num=<%=vo.getNum()%>" >삭제</a></td>
		</tr>

		<%
			}
		%>

		<tr>
			<td colspan="7" align="right"><input type="button" value="회원가입"
				onclick="insertForm()"></td>
		</tr>

	</table>



</body>
</html>