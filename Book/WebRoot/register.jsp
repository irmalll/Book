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
<title>注册页面</title>

	<style type="text/css">
		body{
			background-image:url(image/signinbg.jpg);
		}
		#bg{
			margin-left: auto;
			margin-right: auto;
			width:100%; 
			height:400px; 
			position:relative;
		}
		#box1{
			position:absolute;
			top:15px;
			left:37%;
		}
		#box2{
			position:absolute;
			top:100px;
			left:36.5%;
			width:330px;
			height:360px;
			background-image:url(image/touming.png);
			border-radius: 20px;
			border-top:100px;
		    -webkit-box-shadow:0 0 10px rgba(0, 204, 204, .5);
		    -moz-box-shadow:0 0 10px rgba(0, 204, 204, .5);
		    box-shadow:0 0 10px rgba(0, 204, 204, .5);
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
		.text{
			padding:10px;
			border-radius:5px;
			border:1px solid #D4D4D4;
			box-shadow:inset 0 2px 5px #eee;
			width:180px;
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
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript">
		var upwd = null;
		function checkUname(){
			var uname = document.getElementById("uname").value;
			if(uname != null && uname != ""){
				document.getElementById("uname_msg").innerHTML = "";
				return true;
			}else{
				document.getElementById("uname_msg").innerHTML = "用户名不能为空";
				return false;
			}
		}
		
		function checkUpwd(){
			upwd = document.getElementById("upwd").value;
			if(upwd != null && upwd != ""){
				document.getElementById("upwd_msg").innerHTML = "";
				return true;
			}else{
				document.getElementById("upwd_msg").innerHTML = "密码不能为空";
				return false;
			}
		}
		
		function checkUnpwd(){
			var unpwd = document.getElementById("unpwd").value;
			if(unpwd != null && unpwd != ""){
				if(upwd == unpwd){
					document.getElementById("unpwd_msg").innerHTML = "";
					return true;
				}else{
					document.getElementById("unpwd_msg").innerHTML = "两次输入的密码不一致";
					return false;
				}
			}else{
				document.getElementById("unpwd_msg").innerHTML = "确认密码不能为空";
				return false;
			}
		}
		
		function register(){
			if(checkUname() && checkUpwd() && checkUnpwd()){
				var register = document.getElementById("register");
				register.action = "RegisterServlet";
				register.submit();
			}
		}
	</script>
</head>
<body>
	<div id="bg">
		<div id="box1">
			<h1 style="color:#40F3E5">图书管理系统注册页面</h1>
		</div>	
		<div id="box2">
		    <center>
			    <form action="" method="post" id="register">
			    	<table>
				    	<tr>
				        	<td>用 &nbsp;户 &nbsp;名</td>
				            <td><input type="text" name="uname" id="uname" class="text"/></td>
				         </tr>
				         <tr><td colspan="2"><span id="uname_msg"></span></td></tr>
				        <tr>
				         	<td>密 &nbsp; &nbsp; &nbsp; &nbsp;码</td>
				            <td><input type="password" name = "upwd" id="upwd" class="text"/></td>
				        </tr>
				        <tr><td colspan="2"><span id="upwd_msg"></span></td></tr>
				        <tr>
				        	<td>确认密码</td>
				            <td><input type="password" class="text" id="unpwd"/></td>
				        </tr>
				        <tr><td colspan="2"><span id="unpwd_msg"></span></td></tr>
				        <tr>
				        	<td>权 &nbsp; &nbsp; &nbsp; 限</td>
				            <td>
				            	<select name="urole" id="select">
				                <option value="1">————管理员————</option>
				                <option value="0">————用&nbsp;&nbsp;&nbsp;户————</option>
				                </select>
				            </td>
				        </tr>
				        <tr><td colspan="2"><span>${msg}</span></td></tr>
				        <tr>
				        	<td colspan="2">
				            	<button type="button" id="but" class="reg" onclick="register()">注册</button>
				        		<button type="reset" id="but">重置</button>
				            </td>
				        </tr>
				    </table>
			    </form>
		    </center>
		</div>
	</div>
</body>
</html>