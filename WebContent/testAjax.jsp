<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<body>

	<div style="width: 100px; height: 100px; background: red" id="div1"
		onclick="hello()">点我试试</div>
	<script type="text/javascript">
		function hello() {
			/* //创建XHR对象
			var xhr = new XMLHttpRequest();
			//打开连接
			xhr.open("post","testAjax.do",true);
			//设置请求头，数据的类型
			xhr.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			//发送参数
			xhr.send("username=张三");
			//监听数据接受的状态
			xhr.onreadystatechange = function(){
				console.log("状态："+xhr.readyState+
						",响应吗："+xhr.status);
				//判断数据是否完全接受
				if(xhr.readyState == 4 && xhr.status == 200){
					//更新页面
					document.getElementById("div1").innerHTML=
						xhr.responseText;
				}
			} */
			/* 	$.ajax({
					type:"post",
					url:"testAjax.do",
					data:{username:"张三"},
					success:function(text){
						$("#div1").html(text);
					}}); */
			$.post("testAjax.do", {
				username : "李四"
			}, function(text) {
				$("#div1").html(text);
			});
		}
	</script>
</body>
</html>