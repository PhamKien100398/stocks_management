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

<title>Gentelella Alela! |</title>

<!-- Bootstrap -->
<link
	href="<c:url value = "/template/vendors/bootstrap/dist/css/bootstrap.min.css"/>"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="<c:url value = "/template/vendors/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet">
<!-- NProgress -->
<link
	href="<c:url value = "/template/vendors/nprogress/nprogress.css"/>"
	rel="stylesheet">
<!-- Animate.css -->
<link
	href="<c:url value = "/template/vendors/animate.css/animate.min.css"/>"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="<c:url value = "/template/build/css/custom.min.css"/>"
	rel="stylesheet">
	
<script
	src="<c:url value = "/template/vendors/jquery/dist/jquery.min.js"/>"></script>

<style type="text/css">
.has-error {
	color: red;
}
.login_content form input[type="text"], .login_content form input[type="email"], .login_content form input[type="password"]{
	margin: 20px 0 10px;
}

</style>
</head>

<body class="login">
	<div>
		<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor"
			id="signin"></a>

		<div class="login_wrapper">
			<decorator:body />
		</div>
	</div>
</body>
</html>
