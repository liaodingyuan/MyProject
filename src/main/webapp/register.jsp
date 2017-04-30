<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>注册页面</title>
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
		if ((userPassword.value== null || userPassword.value == "") && userName!=null && userPassword!="" && userEmail.value==null) {
			alert("请输入邮箱地址");
			userEmail.focus();
			return false;
		}
		return true;
	}

    // 使用javascript防止表单重复提交
	 var isCommitted = false;//表单是否已经提交标识，默认为false
          function dosubmit(){
               if(isCommitted==false){
                 isCommitted = true;//提交表单后，将表单是否已经提交标识设置为true
                  return true;//返回true让表单正常提交
               }else{
                   return false;//返回false那么表单将不提交
               }
           }
</script>
</head>
<body>
	<center>
		<h1>用户注册</h1>
		<form action=/liaody/register method="post">
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
					<td>邮 箱</td>
					<td><input type="text" name="userEmail" id="userEmail"></td>
				</tr>
				<tr align=center>
					<td colspan="2"><input type="submit" value="注 册"
						onclick="return validate();" id="submit" /> <input type="reset" value="重 置" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>