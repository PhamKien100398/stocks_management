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
<link rel="icon" href="images/favicon.ico" type="image/ico" />

<title>Stocks Manager!</title>

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
<!-- iCheck -->
<link
	href="<c:url value = "/template/vendors/iCheck/skins/flat/green.css"/>"
	rel="stylesheet">
<!-- bootstrap-wysiwyg -->
<link
	href="<c:url value = "/template/vendors/google-code-prettify/bin/prettify.min.css"/>"
	rel="stylesheet">
<!-- Select2 -->
<link
	href="<c:url value = "/template/vendors/select2/dist/css/select2.min.css"/>"
	rel="stylesheet">
<!-- Switchery -->
<link
	href="<c:url value = "/template/vendors/switchery/dist/switchery.min.css"/>"
	rel="stylesheet">
<!-- starrr -->
<link href="<c:url value = "/template/vendors/starrr/dist/starrr.css"/>"
	rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link
	href="<c:url value = "/template/vendors/bootstrap-daterangepicker/daterangepicker.css"/>"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="<c:url value = "/template/build/css/custom.min.css"/>"
	rel="stylesheet">

<link href="<c:url value = "/template/css/style.css"/>" rel="stylesheet">

<!-- PNotify -->
<link
	href="<c:url value="/template/vendors/pnotify/dist/pnotify.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/template/vendors/pnotify/dist/pnotify.buttons.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/template/vendors/pnotify/dist/pnotify.nonblock.css"/>"
	rel="stylesheet">
	
	<link href="<c:url value="/template/vendor/select2/dist/css/select2.min.css"/>" rel="stylesheet" />

<!-- jQuery -->
<script
	src="<c:url value = "/template/vendors/jquery/dist/jquery.min.js"/>"></script>
<style type="text/css">
.has-error {
	color: red;
}

.login_content form input[type="text"], .login_content form input[type="email"],
	.login_content form input[type="password"] {
	margin: 20px 0 10px;
}

.disabled {
	pointer-events: none;
	cursor: default;
}

span .style {
	width: 100%;
}


</style>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-paw"></i>
							<span>Stocks Manager</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<%@include file="/commons/admin/menu_info.jsp"%>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<%@include file="/commons/admin/sidebar.jsp"%>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<%@include file="/commons/admin/menu_footer.jsp"%>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<%@include file="/commons/admin/top_nav.jsp"%>
			<!-- /top navigation -->

			<!-- page content -->
			<decorator:body />
			<!-- /page content -->

			<!-- footer content -->
			<%@include file="/commons/admin/footer.jsp"%>
			<!-- /footer content -->
		</div>
	</div>

	<!-- Bootstrap -->
	<script
		src="<c:url value = "/template/vendors/bootstrap/dist/js/bootstrap.bundle.min.js"/>"></script>
	<!-- FastClick -->
	<script
		src="<c:url value = "/template/vendors/fastclick/lib/fastclick.js"/>"></script>
	<!-- NProgress -->
	<script
		src="<c:url value = "/template/vendors/nprogress/nprogress.js"/>"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="<c:url value = "/template/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"/>"></script>
	<!-- iCheck -->
	<script src="<c:url value = "/template/vendors/iCheck/icheck.min.js"/>"></script>
	<!-- bootstrap-daterangepicker -->
	<script
		src="<c:url value = "/template/vendors/moment/min/moment.min.js"/>"></script>
	<script
		src="<c:url value = "/template/vendors/bootstrap-daterangepicker/daterangepicker.js"/>"></script>
	<!-- bootstrap-wysiwyg -->
	<script
		src="<c:url value = "/template/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"/>"></script>
	<script
		src="<c:url value = "/template/vendors/jquery.hotkeys/jquery.hotkeys.js"/>"></script>
	<script
		src="<c:url value = "/template/vendors/google-code-prettify/src/prettify.js"/>"></script>
	<!-- jQuery Tags Input -->
	<script
		src="<c:url value = "/template/vendors/jquery.tagsinput/src/jquery.tagsinput.js"/>"></script>
	<!-- Switchery -->
	<script
		src="<c:url value = "/template/vendors/switchery/dist/switchery.min.js"/>"></script>
	<!-- Select2 -->
	<script
		src="<c:url value = "/template/vendors/select2/dist/js/select2.full.min.js"/>"></script>
	<!-- Parsley -->
	<script
		src="<c:url value = "/template/vendors/parsleyjs/dist/parsley.min.js"/>"></script>
	<!-- Autosize -->
	<script
		src="<c:url value = "/template/vendors/autosize/dist/autosize.min.js"/>"></script>
	<!-- jQuery autocomplete -->
	<script
		src="<c:url value = "/template/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"/>"></script>
	<!-- starrr -->
	<script
		src="<c:url value = "/template/vendors/starrr/dist/starrr.js"/>"></script>
	<!-- PNotify -->
	<script
		src="<c:url value="/template/vendors/pnotify/dist/pnotify.js"/>"></script>
	<script
		src="<c:url value="/template/vendors/pnotify/dist/pnotify.buttons.js"/>"></script>
	<script
		src="<c:url value="/template/vendors/pnotify/dist/pnotify.nonblock.js"/>"></script>
		
	<script src="<c:url value="/template/vendor/select2/dist/js/select2.min.js"/>"></script>

	<!-- Custom Theme Scripts -->
	<script src="<c:url value = "/template/build/js/custom.min.js"/>"></script>
</body>
</html>
