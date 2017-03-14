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
	border: 1px solid white;
	height: 25px;
}
#th{
	background-color: #C7EBF3;
}
span{
	color:red;
}
</style>
<script type="text/javascript">
	function confirmDelete(bid){
		if(confirm("是否确认删除？")){
			window.location.href="<%=basePath%>BookDeleteServlet?bid="+ bid;
		}
	}
</script>
</head>
<body>
	<div id = "bg">
		<center>
			<table>
				<tr><td colspan="8"><span>${msg}</span></td></tr>
	        	<tr id="th">
	        		<td>图书编号</td>
	        		<td>图书名称</td>
	        		<td>图书作者</td>
	        		<td>出版社</td>
	        		<td>图书总数</td>
	        		<td>图书库存</td>
	        		<c:if test="${user.urole == '1'}">
	        			<td>操作</td>
	        		</c:if>
	        	</tr>
	        	<c:forEach var="bk" items="${bookList}">
					<tr>
						<td>${bk.bid}</td>
						<td>${bk.bname}</td>
						<td>${bk.bauthor}</td>
						<td>${bk.bpress}</td>
						<td>${bk.bamount}</td>
						<td>${bk.binventory}</td>
						<c:if test="${user.urole == '1'}">
							<td><a href="BookUpdateServlet?bid=${bk.bid}">修改</a> &nbsp;&nbsp;&nbsp; <a href="#" onclick="confirmDelete(${bk.bid})">刪除</a></td>
						</c:if>
					</tr>
				</c:forEach>
	        </table>
	     </center>
     </div>
</body>
</html>