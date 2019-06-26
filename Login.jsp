<%-- <%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<br><br><br><br><br><br><br>

 <style>
 
body, html {
  height: 100%;
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}

.bg-img {
  /* The image used */
  background-image: url("resources/images/bg/loginbg.png");

  min-height: 380px;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

/* Add styles to the form container */
.container {
  position: absolute;
  right: 0;
  margin: 20px;
  max-width: 300px;
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=email], input[type=password] {
  
  width: 200px;
  padding: 5px;
  margin: 20px;
  max-width: 400px;
  border: none;
	
}

 input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
} 

/* Set a style for the submit button */
.btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}

h2{
	color:#fff;

}

h4{
	font-weight: normal;
	color:#fff;
}
</style>

</head> 
<body>
<center>
<div class="bg-img">
<form action="perform_login" method="post">
<table>
<tr><td colspan="2"><h2 align="center"> Login </h2><br></td></tr>
<tr><td><h4>Email Id</h4></td>
	<td><input type="email" name="email"></td>
</tr>
<tr><td><h4>Password</h4></td>   
	<td><input type="password" name="password"></td>
</tr>
<tr><td align="center">
		<input type="submit" value="Login">
	</td>
	</tr>
	
</table>
</form>
</div>
</center>
</body>
</html>