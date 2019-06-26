<%@include file="Header.jsp"%> 

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class = "row">

<c:forEach items="${listProducts}" var="product">

   <div class = "col-sm-2 col-sm-2">
<a href="<c:url value="/ProductDetails/${product.productid}" />" class="thumbnail">
<img src="<c:url value="/resources/images/product/${product.productid}.jpg"/>" alt="Generic placeholder thumbnail" width=200 height=200/></a> 


<br>
<strong>${product.productname}</strong><br>
<strong>Rs.${product.price}</strong><br>


  <c:choose>
  
    <c:when test="${product.stock>0}" >
     <i>In Stock</i>
    </c:when>   
    
    <c:otherwise>
       <font color="red"><b>Out of Stock</b></font>
    </c:otherwise>
    
   </c:choose> 
 
</div> 
</c:forEach>
</div>

