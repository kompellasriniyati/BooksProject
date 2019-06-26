<%@include file="Header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
<br><br><br><br><br><br><br>
<form:form modelAttribute="supplier" action="addsup" method="post">
<table align="center" class="table table-bordered" style="width:50">

<tr>
<td colspan=2 bgcolor="blue"><center>Enter Suppliers Details</center>
</td>
</tr>
<tr>
<td>Supplier Name</td>
<td><form:input path="suppliername"  name="suppliername" id="suppliername"/></td>
</tr>

<tr>
<td>Supplier Description</td>
<td><form:input path="supplierdescription" name="supplierdescription" id="supplierdescription"/></td>
</tr>

<tr>
   <td><b>Category Id</b></td>
   <td><form:select path="category.categoryid" 
   items="${listCategories }" itemValue="categoryid" 
      itemLabel="categoryname">
      </form:select>
     </td>
      </tr>

<tr bgcolor="yellow">
<td colspan=2><center><input type="Submit" value="Add New Supplier"/> 
<input type="Reset" value="Cancel"/>
</center>
</td>
</tr>
</table>
</form:form>
<br><br><br><br>
<table align="center" cellspacing="2" border="1" class="table table-bordered">
<tr>
<td colspan=4 bgcolor="blue"><h3><b><center>Total Supplier List</center></b></h3></td>
</tr>
<tr bgcolor="cyan">
      <td><b>Supplier ID</b></td>
      <td><b>Supplier Description</b></td>
      <td><b>Supplier Name</b></td>
      <td><b>Category Id</b></td>
      <td><b>Operations</b></td>
</tr>
  <c:forEach items="${listSuppliers}" var="supplier">
<tr>
   <td>${supplier.supplierid}</td>
   <td>${supplier.suppliername}</td>
   <td>${supplier.supplierdescription}</td>
   <td>${supplier.category.categoryid}</td>
   <td>
   	  <a href="<c:url value="/editSupplier/${supplier.supplierid}"/>"> Edit    </a>/
   	  <a href="<c:url value="/deleteSupplier/${supplier.supplierid}"/>">    Delete</a>
   </td>
   </tr>
   </c:forEach>	  
</table>
</div>
