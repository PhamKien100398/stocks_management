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
	<div class="right_col" role="main">
		<div class="">
			<%-- <div class="page-title">
				<div class="title_left">
					<h2>${titlePage}</h2>
				</div>
			</div> --%>
			<div class="clearfix"></div>
			<div class="row">
				<div class="col-md-12 col-sm-12 ">
					<div class="x_panel">
						<div class="x_title">
							<h2>${titlePage}</h2>
							<ul class="nav navbar-right panel_toolbox">
								<li><a class="collapse-link"><i
										class="fa fa-chevron-up"></i></a></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown" role="button" aria-expanded="false"><i
										class="fa fa-wrench"></i></a>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<a class="dropdown-item" href="#">Settings 1</a> <a
											class="dropdown-item" href="#">Settings 2</a>
									</div></li>
								<li><a class="close-link"><i class="fa fa-close"></i></a></li>
							</ul>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<br />
							<form:form modelAttribute="modelForm"
								cssClass="form-horizontal form-label-left"
								servletRelativeAction="/product-info/save" method="POST"
								enctype="multipart/form-data">
								<form:hidden path="id" />
								<form:hidden path="create_date" />
								<form:hidden path="active_flag" />
								<div class="item form-group">
									<label class="col-form-label col-md-3 col-sm-3 label-align"
										for="code">Category <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:select path="cateId" cssClass="form-control" id="state"
											disabled="${viewOnly}" style="width:100%">
												<c:forEach var="cate" items="${mapCategory}">
													<c:choose>
														<c:when test="${id == cate.key}">
															<form:option value="${cate.key}" selected="selected" disabled="${viewOnly}">${cate.value}</form:option>
														</c:when>
														<c:otherwise>
															<form:option value="${cate.key}" disabled="${viewOnly}">${cate.value}</form:option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
										</form:select>
									</div>
									<div class="has-error">
										<form:errors path="cateId" cssClass="help-block" />
									</div>
								</div>
								<div class="item form-group">
									<label class="col-form-label col-md-3 col-sm-3 label-align"
										for="code">Code <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:input path="code" cssClass="form-control "
											disabled="${viewOnly}" />
									</div>
									<div class="has-error">
										<form:errors path="code" cssClass="help-block" />
									</div>
								</div>
								<div class="item form-group">
									<label class="col-form-label col-md-3 col-sm-3 label-align"
										for="name">Name <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:input path="name" cssClass="form-control "
											disabled="${viewOnly}" />
									</div>
									<div class="has-error">
										<form:errors path="name" cssClass="help-block" />
									</div>
								</div>
								<div class="item form-group">
									<label for="description"
										class="col-form-label col-md-3 col-sm-3 label-align">Description
										<span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:textarea path="description" cssClass="form-control "
											disabled="${viewOnly}" />
									</div>
									<div class="has-error">
										<form:errors path="description" cssClass="help-block" />
									</div>
								</div>
								<c:if test="${viewOnly != true}">
									<div class="item form-group">
									<label for="multipartFile"
										class="col-form-label col-md-3 col-sm-3 label-align">Image
										Upload <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:input path="multipartFile" cssClass="form-control "
											disabled="${viewOnly}" type="file" />
									</div>
									<div class="has-error">
										<form:errors path="multipartFile" cssClass="help-block" />
									</div>
								</div>
								</c:if>
								<div class="ln_solid"></div>
								<div class="item form-group">
									<div class="col-md-6 col-sm-6 offset-md-3">
										<button class="btn btn-primary" type="button"
											onclick="cancel()">Cancel</button>
										<c:if test="${!viewOnly}">
											<button class="btn btn-primary" type="reset">Reset</button>
											<button type="submit" class="btn btn-success">Submit</button>
										</c:if>
									</div>
								</div>

							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(
				function() {
					$("#product-infolistId").addClass("current-page")
							.siblings().removeClass("current-page");
					var parent = $("#product-infolistId").parents('li');
					parent.addClass("active").siblings().removeClass("active");
					$("#product-infolistId").parents().show();

					$('#state').select2({
						placeholder : "Select a state",
						allowClear : true
					});

					$('select2.select2-container.select2-container--default')
							.css("width", "100%");

				});

		function cancel() {
			window.location.href = "<c:url value = "/product-info/list"/>";
		}
	</script>
</body>
</html>