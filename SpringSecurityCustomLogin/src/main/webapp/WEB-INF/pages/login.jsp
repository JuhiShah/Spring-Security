<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- for spring security you must have to use 'j_username' for username 'name' attribute and 'j_password' for password 'name' attibute.
And for form 'action' the value '/SpringSecurityCustomLogin/j_spring_security_check'is mandatory. -->

<form  action="/SpringSecurityCustomLogin/j_spring_security_check" method="POST">
 <table>
 	<tbody>
 		<tr>
 			<td>User:</td>
 			<td><input type="text" name="j_username" value=""></td>
 		</tr>
    	<tr>
    		<td>Password:</td>
    		<td><input type="password" name="j_password"></td>
    	</tr>
    	<tr>
    		<td colspan="2"><input name="submit" type="submit" value="Login"></td>
    	</tr>
  </tbody>
 </table>
</form>
</body>
</html>