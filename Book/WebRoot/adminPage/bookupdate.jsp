<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	height:470px; 
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
	top:75px;
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
		  <h1>图书信息更新页面</h1>
		</div>
	    <div id="box">
	    	<form action="<%=basePath%>BookUpdateServlet" method="post">
	    		<center>
			    	<table>
						<tr>
			            	<td>图书编号</td>
			                <td>
			                	<input type="hidden" name="bid" value="${book.bid}"/>
			               		<input type="text" disabled="disabled" value="${book.bid}" id="text"/>
			                </td>
			            </tr>
			            <tr>
			            	<td>图书名称</td>
			                <td><input type="text" value="${book.bname}" name="bname" id="text"/></td>
			            </tr>
			            <tr>
			            	<td>图书作者</td>
			                <td><input type="text" value="${book.bauthor}" name="bauthor" id="text"/></td>
			            </tr>
						   <tr>
			            	<td>出版社</td>
			                <td><input type="text" value="${book.bpress}" name="bpress" id="text"/></td>
			            </tr>
			            <tr>
			            	<td>图书总数</td>
			                <td><input type="text" value="${book.bamount}" name="bamount" id="text"/></td>
			            </tr>
			            <tr>
			            	<td>图书库存</td>
			                <td><input type="text" value="${book.binventory}" name="binventory" id="text"/></td>
			            </tr>
			            <tr><td colspan="2"><span>${msg}</span></td></tr>
			            <tr>
			            	<td colspan="2">
			                	<button type="submit" id="but">提交</button>
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