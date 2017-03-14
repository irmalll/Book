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
* {
	margin:0 auto;
	font-family:"微软雅黑";
	font-size:13px;
	background-image:url(../image/tabbg.png);
}
.menu_list {
	width:178px
}
.menu_head {
	height:30px;
	line-height:30px;
	padding-left:15px;
	/*font-size:14px;
	*/ color:#FFF;
	/*未选择的二级菜单字体颜色*/
	cursor:pointer;
	border-left:1px solid #e1e1e1;
	border-right:1px solid #e1e1e1;
	border-bottom:1px solid #e1e1e1;
	border-top:1px solid #F1F1F1;
	position:relative;
	margin:0px;
	font-weight:bold;
	background-image:url(../image/blue.png);
}
.menu_head:hover {
	color:#30F
}
.menu_list .current {
	background:#09F;
}
.menu_body {
	line-height:28px;
	border-left:1px solid #e1e1e1;
	/*backguound:#fff;*/
	border-right:1px solid #e1e1e1;
}
.menu_body a {
	display:block;
	height:30px;
	line-height:30px;
	padding-left:25px;
	color:#777777;
	background-image:url(../image/gray.png);
	text-decoration:none;
	border-bottom:1px solid #e1e1e1;
}
.menu_body a:hover {
	text-decoration:none;
	color:#09F;
}
</style>
<script src="../js/jquery.js"></script>
<script>
$(document).ready(function(){
	$("#firstpane .menu_body:eq(0)").show();
	$("#firstpane h3.menu_head").click(function(){
		$(this).addClass("current").next("div.menu_body").slideToggle(300).siblings("div.menu_body").slideUp("slow");
		$(this).siblings().removeClass("current");
	});
	$("#secondpane .menu_body:eq(0)").show();
	$("#secondpane h3.menu_head").mouseover(function(){
		$(this).addClass("current").next("div.menu_body").slideDown(500).siblings("div.menu_body").slideUp("slow");
		$(this).siblings().removeClass("current");
	});
});
</script>
</head>
<body>
	<!--这是一个主菜单-->
	<div id="firstpane" class="menu_list">
		<h3 class="menu_head current">图书管理</h3>
		<div style="display:block" class="menu_body">
			<a href="../adminPage/bookadd.jsp" target="mainFrame">图书信息增加</a>
			<a href="../adminPage/booksearch.jsp" target="mainFrame">图书信息查询</a>
		</div>
		<h3 class="menu_head">借阅管理</h3>
		<div style="display:block" class="menu_body">
			<a href="../adminPage/borrowadd.jsp" target="mainFrame">借阅信息增加</a>
			<a href="../adminPage/borrowsearch.jsp" target="mainFrame">借阅信息查询</a>
		</div>
		<h3 class="menu_head">系统管理</h3>
		<div style="display:block" class="menu_body">
			<a href="<%=basePath%>LogoutServlet" target="mainFrame">退出系统</a>
		</div>
	</div>
</body>
</html>