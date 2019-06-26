<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header.jsp"%>


<div class="container">
<br><br><br><br>

<form action="addcategory" method="post">
<table cellspacing="2" style="width:50" align="center" class="table table-bordered">
<br><br><br><br>
<tr>
<td colspan=2 bgcolor="blue"> <center> Enter Category Details</center>
</td>
</tr>
<tr>
<td>Category Name</td>
<td><input type="text" name="catName" id="catName"/></td>
</tr>

<tr>
<td>Category Description</td>
<td><input type="text" name="catDesc" id="catDesc"/></td>
</tr>

<tr bgcolor="yellow">
<td colspan=2><center><input type="Submit" value="Add New Category"/> 
<input type="Reset" value="Cancel"/>
</center>
</td>
</tr>
</table>
</form>
<br><br><br><br>
<table align="center" cellspacing="2" border="1" class="table table-bordered">
<tr bgcolor="orange">
<td colspan=4 bgcolor="blue"><h3><b><center>Total Categories List</center></b></h3></td>
</tr>
<tr bgcolor="cyan">
      <td><b>Category Id</b></td>
      <td><b>Category name</b></td>
      <td><b>Category desc</b></td>
      <td><b>Operations</b></td>
</tr>
  <c:forEach items="${categories}" var="category">
<tr>
   <td>${category.categoryid}</td>
   <td>${category.categoryname}</td>
   <td>${category.categorydescription}</td>
   <td>
   	  <a href="<c:url value="/editCategory/${category.categoryid}" />"> Edit    </a>/
   	  <a href="<c:url value="/deleteCategory/${category.categoryid}" />">    Delete</a>
   </td>
   </tr>
   </c:forEach>	  
</table>
</div>