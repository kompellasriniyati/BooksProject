<%@ include file="UserHome.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class = "row">
 <c:forEach items="${listProducts}" var="product">
 
 <div class="col-sm-2 col-sm-2">
 <a href="<c:url value="/AllProducts/${product.productid}" />" class="thumbnail">
 <img src="<c:url value="/resources/images/${product.productid}.jpg"/>" alt="image" width=300 height=300/></a>
 
 
 <br>
 <strong>${product.productname}</strong><br>
 <strong>${product.price}</strong><br>
 
 <c:choose>
 <c:when test="${product.stock>0}">
 <i>In stock</i>
 </c:when>
 <c:otherwise>
 <font color="red"><b>Out of Stock</b></font>
 </c:otherwise>
 </c:choose>
 </div>
 </c:forEach>
 </div>