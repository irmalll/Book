<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>

<style type="text/css">
	#bg{
		margin-left: auto;
		margin-right: auto;
		width:1366px; 
		height:768px; 
		background-image:url(image/loginbg.jpg);
		position:relative;
	}
	#box{
		position:absolute;
		top:200px;
		left:37%;
		margin-left: auto;
		margin-right: auto;
		width:366px;
		height:268px;
		background-image:url(image/touming.png);
		border-radius: 20px;
		border-top:100px;
	    -webkit-box-shadow:0 0 10px rgba(0, 204, 204, .5);
	    -moz-box-shadow:0 0 10px rgba(0, 204, 204, .5);
	    box-shadow:0 0 10px rgba(0, 204, 204, .5);
	}
	#text{
		padding:10px;
		border-radius:5px;
		border:1px solid #D4D4D4;
		box-shadow:inset 0 2px 5px #eee;
		color:#B8B8B8;
		width:226px;
		margin-top:5px;
	}
	#but{
		padding:10px;
		border-radius:5px;
		border:1px solid #D4D4D4;
		box-shadow:inset 0 2px 5px #eee;
		width:123px;
		margin-top:5px;
		color:#40F3E5;
		font-size:18px;
	}
	table{ margin-top:20px}
	span{
		color:red;
	}
</style>
<script type="text/javascript">
	function register(){
		var form1 = document.getElementById("form1");
		form1.action = "register.jsp";
		form1.submit();
	}
</script>
</head>
<body>
	<div id="bg">
		<div id="box">
			<form action="LoginServlet" method="post" id="form1">
				<center>
		        	<table>
		            	<tr>
		                	<td colspan="2" style="font-size:20px; color:#40F3E5; text-align:center">欢迎登录图书管理系统</td>
		                </tr>
		            	<tr>
		                	<td colspan="2"><input type="text" name="uname" id="text" placeholder="请输入用户名"/></td>
		                </tr>
		                <tr>
		                	<td colspan="2"><center><input type="password" name="upwd" id="text" placeholder="请输入密码"/></center></td>
		                </tr>
		                <tr>
		                	<td colspan="2"><span>${msg}</span></td>
		                </tr>
		                <tr>
		                	<td><input type="submit" value="登录" id="but"/></td>
		                    <td><input type="button" value="注册" id="but" onclick="register()"/></td>
		                </tr>
		            </table>
		    	</center>
			</form>
	    </div>
	</div>
</body>
</html>