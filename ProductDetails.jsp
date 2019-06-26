<%@ include file="Header.jsp" %>  
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<html>
<head>

<script src="resources/js/vendor/jquery-3.2.1.min.js"></script>
	<script src="resources/js/popper.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/plugins.js"></script>
	<script src="resources/js/active.js"></script>
	
	<meta charset="utf-8">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Home</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Favicons -->
	<link rel="shortcut icon" href="resources/images/favicon.ico">
	<link rel="apple-touch-icon" href="resources/images/icon.png">

	<!-- Google font (font-family: 'Roboto', sans-serif; Poppins ; Satisfy) -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet"> 
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,500,600,600i,700,700i,800" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" rel="stylesheet"> 

	<!-- Stylesheets -->
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/css/plugins.css">
	<link rel="stylesheet" href="resources/css/style.css">

	<!-- Cusom css -->
   <link rel="stylesheet" href="resources/css/custom.css">

	<!-- Modernizer js -->
	<script src="resources/js/vendor/modernizr-3.5.0.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>

<body>
<div class="container">
<div class="col-md-4 item-photo">
<img src="<c:url value="/resources/images/${product.productid}.jpg"/>"  height=500 width=300 />
</div>

<div class="col-md-4">
<h3><b>${product.productname}</b></h3>
<h5><small>Stock : ${product.stock}</small></h5>
<h4><b>M.R.P. : Rs.${product.price}</b></h4>
<h6>Description : ${product.productdescription}</h6>


<c:choose>
<c:when test="${product.stock>0}">
<a href="<c:url value="/addToCart/${product.productid}"/> "><input type="submit" class="btn btn-success" value="Add to Cart"/></a>
</c:when>
<c:otherwise>
<i>Will be soon In Stock</i>
<a class="btn btn-info" href="<c:url value="/saveForLater/${product.productid}" />">Save for Later</a>
</c:otherwise>
</c:choose>
</div>

</div>

</body>
</html>

