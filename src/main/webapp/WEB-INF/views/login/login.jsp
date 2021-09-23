<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="animate form login_form">
		<section class="login_content">
			<form:form modelAttribute="userAttribute" id="login_form"
				method="POST" servletRelativeAction="login_process">
				<h1>Login Form</h1>
				<div>
					<form:input path="email" id="email" cssClass="form-control"
						placeholder="Email or phone number" />
					<div class="has-error">
						<form:errors path="email" cssClass="help-block" />
					</div>
				</div>
				<div>
					<form:password path="password" id="password"
						cssClass="form-control" placeholder="Password" />
					<div class="has-error">
						<form:errors path="password" cssClass="help-block" />
					</div>
				</div>
				<div>
					<a class="btn btn-default submit" id="login"
						style="cursor: pointer;">Log in</a> <a class="reset_pass">Lost
						your password?</a>
				</div>

				<div class="clearfix"></div>

				<div class="separator">
					<p class="change_link">
						New to site? <a href="#signup" class="to_register"> Create
							Account </a>
					</p>

					<div class="clearfix"></div>
					<br />

					<div>
						<h1>
							<i class="fa fa-paw"></i> Gentelella Alela!
						</h1>
						<p>Â©2016 All Rights Reserved. Gentelella Alela! is a
							Bootstrap 3 template. Privacy and Terms</p>
					</div>
				</div>
			</form:form>
		</section>
	</div>

	<div id="register" class="animate form registration_form">
		<section class="login_content">
			<form>
				<h1>Create Account</h1>
				<div>
					<input type="text" class="form-control" placeholder="Username"
						required="" />
				</div>
				<div>
					<input type="email" class="form-control" placeholder="Email"
						required="" />
				</div>
				<div>
					<input type="password" class="form-control" placeholder="Password"
						required="" />
				</div>
				<div>
					<a class="btn btn-default submit" href="index.html">Submit</a>
				</div>

				<div class="clearfix"></div>

				<div class="separator">
					<p class="change_link">
						Already a member ? <a href="#signin" class="to_register"> Log
							in </a>
					</p>

					<div class="clearfix"></div>
					<br />

					<div>
						<h1>
							<i class="fa fa-paw"></i> Gentelella Alela!
						</h1>
						<p>Â©2016 All Rights Reserved. Gentelella Alela! is a
							Bootstrap 3 template. Privacy and Terms</p>
					</div>
				</div>
			</form>
		</section>
	</div>

	<script type="text/javascript">
		/* var login_form = document.getElementById("login_form");

		document.getElementById("login").addEventListener("click", function(){
			login_form.submit();
		}); */
		$(document).ready(function() {
			$('#login').click(function() {
				//   if(e.keyCode=='13'){
				//     $('search_form').submit();
				//   }     
				$('#login_form').submit();
			})
			$('*').keyup(function(e) {
				if (e.keyCode == '13') {
					$('#login_form').submit();
				}
			})
		})
	</script>
</body>
</html>