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
	height:220px;
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
<script type="text/javascript">
	//检测原密码
	function checkOpwd(){
		//获取session中存储的用户密码
		var pwd = document.getElementById("pwd").value;
		//获取用户在页面中输入的原密码
		var opwd = document.getElementById("opwd").value;
		//判断两者是否一致。是，继续其他操作；否，提示信息。
		if(opwd == pwd){
			document.getElementById("info").innerHTML = "";
			return true;			
		}else{
			document.getElementById("info").innerHTML = "原密码不正确，请重新输入";
			return false;
		}
	}
	
	//检测新密码
	function checkUpwd(){
		//获取用户输入的新密码
		var upwd = document.getElementById("upwd").value;
		//判断新密码是否为空。非空，继续其他操作；为空，提示信息。
		if(upwd != null && upwd != ""){
			document.getElementById("info").innerHTML = "";
			return true;
		}else{
			document.getElementById("info").innerHTML = "新密码不能为空";
			return false;
		}
	}
	
	//检测确认密码
	function checkUnpwd(){
		var upwd = document.getElementById("upwd").value;
		//获取用户输入的确认密码
		var unpwd = document.getElementById("unpwd").value;
		//判断确认密码是否为空。非空，继续其他操作；为空，提示信息。
		if(unpwd != null && unpwd != ""){
			//判断新密码与确认密码是否一致。一致，跳转到ChangePwdServlet；不一致，提示信息。
			if(upwd == unpwd){
				document.getElementById("info").innerHTML = "";
				return true;
			}else{
				document.getElementById("info").innerHTML = "新密码与确认密码不一致，请重新输入";
				return false;
			}
		}else{
			document.getElementById("info").innerHTML = "确认密码不能为空";
			return false;
		}
	}
	
	function changePwd(id){
		if(checkOpwd() && checkUpwd() && checkUnpwd()){
			var changePwd = document.getElementById("changePwd");
			changePwd.action = "<%=basePath%>ChangePwdServlet?id="+id;
			changePwd.submit();
		}
	}
</script>
</head>
<body>
	<div id="bg">
		<div id="title">
		  <h1>修改密码页面</h1>
		</div>
	    <div id="box">
	    	<form action="" method="post" id="changePwd">
	    		<center>
			    	<table>
			            <tr>
			            	<td>原密码</td>
			                <td>
			                	<input type="hidden" value="${user.upwd}" id="pwd"/>
			                	<input type="text" id="opwd" class="text"/>
			                </td>
			            </tr>
			            <tr>
			            	<td>新密码</td>
			                <td><input type="text" name="upwd" id="upwd" class="text"/></td>
			            </tr>
			            <tr>
			            	<td>确认密码</td>
			                <td><input type="text" id="unpwd" class="text"/></td>
			            </tr>
			            <tr><td colspan="2"><span id="info">${msg}</span></td></tr>
			            <tr>
			            	<td colspan="2">
			                	<button type="button" id="but" onclick="changePwd(${user.id})">确定</button>
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