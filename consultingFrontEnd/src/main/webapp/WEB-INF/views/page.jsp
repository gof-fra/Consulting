<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<%-- <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/> ">
<img src="<c:url value="/resources/img/iphone.jpg"/>" />


<script type="text/javascript" src="<c:url value="/resources/script/myscript.js"/>" >

</script>
 --%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />  
  



<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Consulting - ${title} </title>
    
    <script>
    
    	window.menu = '${title}';
    	
    	window.contextRoot = '${contextRoot}';
    
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
    <!-- Readable theme --Don't use -- -->
     <link href="${css}/" rel="stylesheet">
     
     <!-- dataTable -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

		   <!-- navigateur -->
		   <%@include file="./partage/navbar.jsp" %>
		   
		   <div class="content">
				   <!-- Home -->
				   <c:if test="${userClickHome == true}">
				  	 <%@include file="home.jsp" %>
				   </c:if>
				   
				   <c:if test="${userClickAbout == true}">
				 	  <%@include file="about.jsp" %>
				   </c:if>
				   
				   <c:if test="${userClickContact == true}">
				  	 <%@include file="contact.jsp" %>
				   </c:if>
				   
				   <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				  	 <%@include file="listProducts.jsp" %>
				   </c:if>
		   
		   </div>
		   
		   
		   <!-- /.container -->
		
			<!-- Footer -->
			<%@include file="./partage/footer.jsp" %>
		  <!-- /.container -->
		
		    <!-- JavaScript -->
		    <script src="${js}/jquery.js"></script>
		    
		    <!-- daatTable plugin-->
		    <script src="${js}/jquery.dataTables.js"></script>
		    
		    <!-- dataTable boostrap-->
		    <script src="${js}/dataTables.bootstrap.js"></script>
		    
		    
		    <script src="${js}/bootstrap.min.js"></script>
		    
		    <script src="${js}/myapp.js"></script>
    
    </div>

</body>

</html>
