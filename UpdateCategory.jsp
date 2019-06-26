<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header.jsp"%>

<div class="container">
<br><br><br>
<form action="<c:url value="/UpdateCategory" />" method="post">
<table cellspacing="2" align="center" class="table table-bordered" style="width:50%">
<tr bgcolor="orange"><td colspan="2"><center>Edit Category Details</center></td></tr>

<tr>
 <td>Category ID</td>
 <td><input type="text" name="catId" id="catId" value="${editablecategory.categoryid}" readonly/></td>
 </tr>
<tr>
   <td>Category Name</td>
   <td><input type="text" name="catName" id="catName" value="${editablecategory.categoryname}"/></td>
   </tr>
   <tr>
      <td>Category Desc</td>
      <td><input type="text" name="catDesc" id="catDesc" value="${editablecategory.categorydescription}"/></td> 
      </tr>
      <tr bgcolor="green">
      <td colspan=2><center><input type="submit" value="confirm Update"/></center>
      </td>
      </tr>
</table>
</form>
</div>