<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gentelella Alela! | </title>

    <!-- Bootstrap -->
    <link href="<c:url value = "/template/vendors/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value = "/template/vendors/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
    <!-- NProgress -->
    <link href="<c:url value = "/template/vendors/nprogress/nprogress.css"/>" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="<c:url value = "/template/build/css/custom.min.css"/>" rel="stylesheet">
  </head>

  <body class="nav-md">
  	<decorator:body/>

    <!-- jQuery -->
    <script src="<c:url value = "/template/vendors/jquery/dist/jquery.min.js"/>"></script>
    <!-- Bootstrap -->
   <script src="<c:url value = "/template/vendors/bootstrap/dist/js/bootstrap.bundle.min.js"/>"></script>
    <!-- FastClick -->
    <script src="<c:url value = "/template/vendors/fastclick/lib/fastclick.js"/>"></script>
    <!-- NProgress -->
    <script src="<c:url value = "/template/vendors/nprogress/nprogress.js"/>"></script>

    <!-- Custom Theme Scripts -->
    <script src="<c:url value = "/template/build/js/custom.min.js"/>"></script>
  </body>
</html>