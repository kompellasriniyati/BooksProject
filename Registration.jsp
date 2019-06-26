<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            
            <br><br><br><br><br><br><br>
            <style>
 
body, html {
  height: 100%;
  font-family: Arial, Helvetica, sans-serif;
  background-image: url("resources/images/bg/bgr.jpg"); 
}

* {
  box-sizing: border-box;
}

/* Add styles to the form container */
.container {
  position: absolute;
  left:41%;
  margin: 20px;
  width:340px;
  padding: 16px;
  background: white;
}

/* Full-width input fields */
form:input,form:password {
  
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
input[type="submit"] {
height:30px;
width:60px;
font-size:15px;
color:#fff;
border:none;
background-color: #2E8B57;
border-radius: 2px;
cursor:pointer;  
}

input[type="reset"] {
height:30px;
width:60px;
font-size:15px;
color:#fff;
border:none;
background-color: #FF6347;
border-radius: 2px;
cursor:pointer;  
}

.btn:hover {
  opacity: 1;
}

h2{
	color:black;

}

h4{
	font-weight: normal;
	color:#fff;
}
</style>
            
        </head>
        <body>
        
         <div class="container">
            <form:form id="regForm" modelAttribute="user" action="adduser" method="post">
                <table>
                         <tr><td colspan="2"><h2 align="center"> Registration </h2><br></td></tr> 
                    <tr>
                        <td>
                            <label for="firstname">FirstName</label>
                         
                        </td>
                        <td>
                            <form:input path="firstname" name="firstname" id="firstname" /><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="lastname">LastName</label><br>
                        </td>
                        <td>
                            <form:input path="lastname" name="lastname" id="lastname" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="emailid">Email</label>
                        </td>
                        <td>
                            <form:input path="emailid" name="emailid" id="emailid" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="address">Address</label>
                        </td>
                        <td>
                            <form:input path="address" name="address" id="address" />
                        </td>
                    </tr><tr>
                        <td>
                            <label for="location">location</label>
                        </td>
                        <td>
                            <form:input path="location" name="location" id="location" />
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <label for="contactno">contactno</label>
                        </td>
                        <td>
                            <form:input path="contactno" name="contactno" id="contactno" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="password">password</label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                    </tr>
                     <tr>
                        <td>
                            <label for="confirmpassword">confirmpassword<label>
                        </td>
                        <td>
                            <form:password path="confirmpassword" name="confirmpassword" id="confirmpassword" />
                        </td>
                    </tr>
                    <tr></tr><tr></tr>
                    <tr>
                        
                        <td>
                    		<input type="submit" value="Signup">
                        </td>
                        <td>
                        	<input type="reset" value="cancel">
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="home.jsp" style="text-decoration: none3.">Home</a>
                        </td>
                    </tr>
                </table>
  
            </form:form>
            </div>
 		
        </body>
                  
 
        </html>