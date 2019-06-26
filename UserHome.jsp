<%@include file="Header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="container">
<br><br><br><br><br><br>
<div class="row">
   <div class="col-sm-4" >
   <a href="<c:url value="/AllProducts"/>">
   <img src="<c:url value="/resources/images/"/>" width=150 height=100>
   </a>
   </div>
   
   <div class="col-sm-4" style="background-color:Lavenderblush;">
   <a href="<c:url value="/AllProducts"/>">
    <img src="<c:url value="/resources/images/"/>" width=150 height=100>
   </a>
</div>
</div>
</div>

<div class="container">
<div class="row">
<div class="col-sm-4" style="background-color:Lavenderblush;">
<a href="<c:url value="/AllProducts"/>">
 <img src="<c:url value="/resources/images/"/>" width=150 height=100>
   </a>
   </div>

<div class="col-sm-4" >
   <a href="<c:url value="/AllProducts"/>">
   <img src="<c:url value="/resources/images/"/>" width=150 height=100>
   </a>
   </div>
</div>
</div>