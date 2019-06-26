<%@include file="Header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<div class="container">
<br><br><br>
<form:form action="/UpdateSupplier" modelAttribute="editablesupplier" method="post">
<table cellspacing="2" align="center" class="table table-bordered" style="width:50%">
<tr bgcolor="orange"><td colspan="2"><center>Edit Category Details</center></td></tr>

<tr>
 <td>Supplier ID</td>
 <td><form:input path="supplierid"  readonly="true"/></td>
 </tr>
<tr>
   <td>Supplier Name</td>
   <td><form:input path="suppliername"/></td>
   </tr>
  <tr>
   <td><b>Category Id</b></td>
   <td><form:select path="category.categoryid" 
   items="${listCategories }" itemValue="categoryid" 
      itemLabel="categoryname">
      </form:select>
     </td>
      </tr>
      <tr>
   <td>Supplier Description</td>
   <td><form:input path="supplierdescription"/></td>
   </tr>
      <tr bgcolor="green">
      <td colspan=2><center><input type="submit" value="confirm Update"/></center>
      </td>
      </tr>
</table>
</form:form>
</div>