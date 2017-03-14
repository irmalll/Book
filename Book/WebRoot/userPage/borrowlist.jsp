<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
body{
	background-image:url(../image/signinbg.jpg);
}
#bg{
	margin-left: auto;
	margin-right: auto;
	padding-top: 15px;
	width:100%; 
	height:100%; 
	position:relative;
}
table{
	width: 95%;
	border-collapse: collapse;
	border-spacing: 0 0;
	text-align: center;
}
table td{
	border: 1px solid #C7EBF3;
	height: 25px;
}
#th{
	background-color: #C7EBF3;
}
#th td{
	border: 1px solid white;	
}
.info{
	border: none;
}
</style>
</head>
<body>
	<div id = "bg">
		<center>
			<table>
				<tr><td colspan="8" class="info"><span>${msg}</span></td></tr>
	        	<tr id="th">
	        		<td>借阅编号</td>
	        		<td>用户编号</td>
	        		<td>图书编号</td>
	        		<td>借阅数量</td>
	        		<td>借阅时间</td>
	        		<td>归还时间</td>
	        		<td width="130px">借阅状态(0:未归还，1:已归还)</td>
	        	</tr>
	        	
	        	<c:forEach var="borr" items="${borrowList}">
	        		<c:if test="${borr.borrstate == '1'}">
	        			<tr>
							<td>${borr.borrid}</td>
							<td>${borr.user.uid}</td>
							<td>${borr.book.bid}</td>
							<td>${borr.borrcount}</td>
							<td>${borr.borrtime}</td>
							<td>${borr.returntime}</td>
							<td>${borr.borrstate}</td>
						</tr>
	        		</c:if>
	        		<c:if test="${borr.borrstate == '0'}">
	        			<tr>
							<td>${borr.borrid}</td>
							<td>${borr.user.uid}</td>
							<td>${borr.book.bid}</td>
							<td>${borr.borrcount}</td>
							<td>${borr.borrtime}</td>
							<td>${borr.returntime}</td>
							<td>${borr.borrstate}</td>
						</tr>
	        		</c:if>
	        	</c:forEach>
	        </table>
	     </center>
     </div>
</body>
</html>