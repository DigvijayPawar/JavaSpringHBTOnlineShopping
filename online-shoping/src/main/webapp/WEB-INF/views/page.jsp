<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="js" value="/resources/js" />
<spring:url var="css" value="/resources/css" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />



<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>online shopping - ${title}</title>

<script type="text/javascript">
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap-lux-theme-CSS -->
<link href="${css}/bootstrap-lux-theme.css" rel="stylesheet">

<!-- Bootstrap-DataTables-CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation ----  this code is pasted in the navbar.jsp page -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content --- the main content code is pasted in home.jsp page -->
		<div class="content">
			<c:if test="${userclickshome==true}">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userclicksabout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if
				test="${userclicksallproducts==true or userclickscategoryproducts==true}">
				<%@include file="listproducts.jsp"%>
			</c:if>

			<%-- <!-- here it displays single product when clicked  -->
				<c:if test="${userclicksshowproducts==true}">
				<%@include file="SingleProduct.jsp"%>
			</c:if> --%>

			<c:if test="${userclicksshowproducts==true}">
				<%@include file="SingleProduct2.jsp"%>
			</c:if>

			<c:if test="${userclickscontact==true}">
				<%@include file="contact.jsp"%>
			</c:if>

		</div>

		<!-- Footer  ---  the footer code is pasted into footer.jsp file -->
		<%@include file="./shared/footer.jsp"%>


		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- Datatable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- Datatable BootStrap Script -->
		<%-- 		<script src="${js}/dataTables.bootstrap.js"></script> --%>

		<!-- self coded java script -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
