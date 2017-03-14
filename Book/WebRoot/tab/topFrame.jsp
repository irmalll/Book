<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
	*{
		margin:auto;
	}
	body{
		background:url(../image/topbg.png);
	}
	.ant_head{
		height:120px;
	}
	p{
		text-align: right;
		margin: 15px 25px 0 0;
	}
	span{
		color:red;
	}
</style> 
</head>
<body>
	<div class="ant_head">
		<p>
			<c:if test="${user.urole == \"0\"}">用户：</c:if>
			<c:if test="${user.urole == \"1\"}">管理员：</c:if>
			<span>${user.uname}</span>
		</p>
	</div> 
</body>
</html>