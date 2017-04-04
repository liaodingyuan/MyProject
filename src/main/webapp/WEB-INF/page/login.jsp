<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录页面</title>
<script>
	function validate() {
		var userName = document.getElementById("userName");
		var pass = document.getElementById("password");
		if (userName.value == null || userName.value =="") {
			alert("请输入用户名");
			userName.focus();
			return false;
		}
		if ((userPassword.value== null || userPassword.value == "") && userName!=null && userPassword!="") {
			alert("请输入密码");
			userPassword.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<center>
		<h1>用户登录</h1>
		<form action=/MyProject/login method="post">
			<table width="350" bgcolor="#ccffcc" style="" border="1">
				<tr align=center>
					<td>用户名</td>
					<td><input type="text" name="userName" id="userName"></td>
				</tr>
				<tr align=center>
					<td>密 码</td>
					<td><input type="password" name="userPassword" id="userPassword"></td>
				</tr>
				<tr align=center>
					<td colspan="2"><input type="submit" value="登 录"
						onclick="return validate();" /> <input type="reset" value="重 置" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>