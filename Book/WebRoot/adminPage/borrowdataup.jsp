<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
	background-image:url(<%=basePath%>image/signinbg.jpg);
}
#bg{
	margin-left: auto;
	margin-right: auto;
	width:100%; 
	height:530px; 
	position:relative;
}
#title{
	position:absolute;
	top:1px;
	left:30%;
	color:#40F3E5;	
}
#text{
	padding:10px;
	border-radius:5px;
	border:1px solid #D4D4D4;
	box-shadow:inset 0 2px 5px #eee;
	color:#B8B8B8;
	width:180px;
}
#but{
	padding:10px;
	border-radius:5px;
	border:1px solid #D4D4D4;
	box-shadow:inset 0 2px 5px #eee;
	width:130px;
	margin-top:5px;
	color:#40F3E5;
	font-size:18px;
}
#box{
	position:absolute;
	top:70px;
	left:28%;
	width:330px;
	height:360px;
	background-image:url(<%=basePath%>image/touming.png);
	border-radius: 20px;
	border-top:100px;
    -webkit-box-shadow:0 0 10px rgba(0, 204, 204, .5);
    -moz-box-shadow:0 0 10px rgba(0, 204, 204, .5);
    box-shadow:0 0 10px rgba(0, 204, 204, .5);
}
#select{
	padding:10px;
	border-radius:5px;
	border:1px solid #D4D4D4;
	box-shadow:inset 0 2px 5px #eee;
	font-size:14px; 
	width:200px;
}
table{ margin-top:20px}
span{
	color:red;
}
</style>
</head>
<body>
	<div id="bg">
		<div id="title">
		  <h1>借阅信息修改页面</h1>
		</div>
	    <div id="box">
	    	<form action="<%=basePath%>BorrowUpdateServlet" method="post">
	    		<center>
			    	<table>
			            <tr>
			            	<td>借阅编号</td>
			                <td>
			                	<input type="hidden" value="${borrow.borrid}" name="borrid"/>
			                	<input type="text" disabled="disabled" value="${borrow.borrid}" id="text"/>
			                </td>
			            </tr>
			            <tr>
			            	<td>用户编号</td>
			                <td><input type="text" value="${borrow.user.uid}" name="uid" id="text"/></td>
			            </tr>
			            <tr>
			            	<td>图书编号</td>
			                <td><input type="text" value="${borrow.book.bid}" name="bid" id="text"/></td>
			            </tr>
			            <tr>
			            	<td>借阅数量</td>
			                <td><input type="text" value="${borrow.borrcount}" name="borrcount" id="text"/></td>
			            </tr>
						 <tr>
			            	<td>借阅时间</td>
			                <td><input type="text" value="${borrow.borrtime}" name="borrtime" id="text"/></td>
			            </tr>
			            <c:if test="${borrow.returntime != null && borrow.returntime != \"\"}">
			            	<tr>
				            	<td>归还时间</td>
				                <td><input type="text" value="${borrow.returntime}" name="returntime" id="text"/></td>
				            </tr>
			            </c:if>
			            <tr><td colspan="2"><span>${msg}</span></td></tr>
			            <tr>
			            	<td colspan="2">
			                	<button type="submit" id="but">修改</button>
			        			<button type="reset" id="but">重置</button>
			                </td>
			            </tr>
			        </table>
		        </center>
	    	</form>
	    </div>
	</div>
</body>
</html>