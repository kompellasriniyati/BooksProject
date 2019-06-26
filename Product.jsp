<%@include file="Header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<br><br><br><br>
<div class="container">
<form:form modelAttribute="product" action="InsertProduct" method="post" enctype="multipart/form-data">
<table align="center" class="table table-bordered" style="width:50%">

<tr>
   <td colspan=2 bgcolor="green"><center>Enter Product Details</center></td>
   </tr>
   
   <tr>
   <td colspan=2 ><h5 align="center"><font color="red">${Error}</font></h5>
   </td>
   </tr>
   
   <tr>
   <td>Product Name</td>
   <td><form:input path="productname"/></td>
   </tr>
   
   <tr>
   <td>Product Desc</td>
   <td><form:input path="productdescription"/></td>
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
   <td>Product Stock</td>
   <td><form:input path="stock"/></td>
   </tr>
   
   <tr>
   <td>Product Price</td>
   <td><form:input path="price"/></td>
   </tr>
   
    <tr>
   <td>Product Quantity</td>
   <td><form:input path="quantity"/></td>
   </tr>
   <tr>
   <td>Product Image</td>
   <td><form:input type="file" path="prodimage"/></td>
   </tr>
   
   <tr bgcolor="yellow">
   <td colspan=2><center><input type="submit" value="Insert New Product"/><input type="reset" value="Clear All"/></center></td><br>
   </tr>
   
   </table>
   </form:form>
   
   <br><br><br>
   <table align="center" class="table table-bordered" border="1">
   <tr>
   <td colspan=9 bgcolor="pink"><h3><b><center>Total Products List</center></b></h3></td>
   </tr>
   
   <tr>
   <td><b>Product ID</b></td>
   <td><b>Product Name</b></td>
   
   <td><b>Category ID</b></td>
   <td><b>Product Stock</b></td>
   <td><b>Product Price</b></td>
   <td><b>Product Quantity</b></td>
   <td><b>Product Image</b></td>
   <td><b>Operations</b></td>
   </tr>
   
   <c:forEach items="${listProducts}" var="product">
   <tr>
    <td>${product.productid}</td>
    <td>${product.productname}</td>
    
     <td>${product.category.categoryid}</td>
    <td>${product.productdescription}</td>
    <td>${product.stock}</td>
    <td>${product.price}</td>
    <td>${product.quantity}</td>
    <td><img src="<c:url value="/resources/images/${product.productid}.jpg"/>"width=100 height=100/></td>
    <td>
     <a href="<c:url value="/editProduct/${product.productid}"/>">Edit     </a>   /
     <a href="<c:url value="/deleteProduct/${product.productid}"/>">    Delete</a> 
     </td>
     </tr>  
   </c:forEach>
   </table>
</div>
