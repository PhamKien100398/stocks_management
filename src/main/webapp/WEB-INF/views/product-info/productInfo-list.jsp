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
			<div class="row" style="display: block;">
				<div class="clearfix"></div>

				<div class="col-md-12 col-sm-12  ">
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
							<div class="input-group" style="justify-content: space-between;">
								<a href="<c:url value="/product-info/add"/>" class="btn btn-app"><i
									class="fa fa-plus"></i>Add</a>
								<form:form modelAttribute="searchForm" cssClass="form-inline"
									servletRelativeAction="/product-info/list" id="search_form">
									<i class="fa fa-search" aria-hidden="true"></i>
									<form:input path="name"
										cssClass="form-control form-control-sm ml-3 w-75"
										title="Search" placeholder="Search" id="search_input" />
								</form:form>
							</div>
							<div class="table-responsive">
								<table class="table table-striped jambo_table bulk_action">
									<thead>
										<tr class="headings">
											<th class="column-title text-center">#</th>
											<th class="column-title text-center">Id</th>
											<th class="column-title text-center">Name</th>
											<th class="column-title text-center">Code</th>
											<th class="column-title text-center">Image</th>
											<th class="column-title no-link last text-center" colspan="3"><span
												class="nobr">Action</span></th>
											<th class="bulk-actions" colspan="7"><a class="antoo"
												style="color: #fff; font-weight: 500;">Bulk Actions ( <span
													class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
											</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="product" items="${list}" varStatus="loop">
											<c:choose>
												<c:when test="${loop.index % 2 == 0}">
													<tr class="even pointer">
												</c:when>
												<c:otherwise>
													<tr class="odd pointer">
												</c:otherwise>
											</c:choose>
											<td class="text-center align-middle">${product.id}</td>
											<td class="text-center align-middle">${product.id}</td>
											<td class="text-center align-middle">${product.name}</td>
											<td class="text-center align-middle">${product.code}</td>
											<td class="text-center align-middle"><img src="<c:url value="${product.imgUrl}"/>" width="100px" height="100px"/></td>
											<td class="text-center"><a
												href="<c:url value = "/product-info/view/${product.id}"/>"
												class="btn btn-secondary btn-rounded"
												style="font-size: 13px;">View</a></td>
											<td class="text-center"><a
												href="<c:url value = "/product-info/edit/${product.id}"/>"
												class="btn btn-primary btn-rounded" style="font-size: 13px;">Update</a></td>

											<td class="text-center"><a href="javascript:void(0);"
												onclick="confirmDelete(${product.id})"
												class="btn btn-danger btn-rounded" style="font-size: 13px;">Delete</a>
											</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<nav aria-label="Page navigation example"
								style="margin: 15px auto;">
								<ul class="pagination" style="justify-content: center;" id="pagination">
									
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function confirmDelete(id) {
			if(confirm("Do you want delete this record?")){
				window.location.href = "<c:url value = '/product-info/delete/'/>"+id;
			}
		}
		
		$(document).ready(function(){
			processNotify();
			processPage();
			processMenu();
		});
		
		function processPage() {
			var limit = parseInt('${pa.limit}');
			var indexPage = parseInt('${pa.indexPage}');
			var totalPage = parseInt('${pa.totalPage}');
			var active;
			var pageCutLow = indexPage - 1;
  			var pageCutHigh = indexPage + 1;
			if(indexPage > 1){
				$('#pagination').append('<li class="page-item"><a class="page-link" href="<c:url value = "/product-info/list/'+(indexPage-1)+'"/>">Previous</a></li>');
			}else{
				$('#pagination').append('<li class="disabled"><a class="page-link" href="javascript:void(0);">Previous</a></li>');
			}
			if(totalPage < 6){
				for(var i = 1; i <= totalPage; i++){
					active = indexPage == i ? "active" : "";
					$('#pagination').append('<li class="page-item '+active+'"><a class="page-link" href= "<c:url value = "/product-info/list/'+i+'"/>">'+i+'</a></li>');
				}
			}else {
    // Show the very first page followed by a "..." at the beginning of the
    // pagination section (after the Previous button)
    			if (indexPage > 2) {
					$('#pagination').append('<li class="page-item"><a class="page-link" href= "<c:url value = "/product-info/list/1"/>">1</a></li>');
      				if (indexPage > 3) {
						$('#pagination').append('<li class="out-of-range"><a class="page-link" href="<c:url value = "/product-info/list/'+(indexPage-2)+'"/>">...</a></li>');
      				}
    			}
    // Determine how many pages to show after the current page index
    			if (indexPage === 1) {
      				pageCutHigh += 2;
    			} else if (indexPage === 2) {
      				pageCutHigh += 1;
    			}
    // Determine how many pages to show before the current page index
    			if (indexPage === totalPage) {
      				pageCutLow -= 2;
   				} else if (indexPage === totalPage-1) {
      				pageCutLow -= 1;
    			}
    // Output the indexes for pages that fall inside the range of pageCutLow
    // and pageCutHigh
    			for (let p = pageCutLow; p <= pageCutHigh; p++) {
      				if (p === 0) {
        				p += 1;
      				}
     				if (p > totalPage) {
        				continue;
      				}
      				active = indexPage == p ? "active" : "no";
      				$('#pagination').append('<li class="page-item '+active+'"><a class="page-link" href= "<c:url value = "/product-info/list/'+p+'"/>">'+ p +'</a></li>');
    			}
    // Show the very last page preceded by a "..." at the end of the pagination
    // section (before the Next button)
    			if (indexPage < totalPage-1) {
      				if (indexPage < totalPage-2) {
        				$('#pagination').append('<li class="out-of-range"><a class="page-link" href= "<c:url value = "/product-info/list/'+(indexPage+2)+'"/>">...</a></li>');
      				}
      				$('#pagination').append('<li class="page-item"><a class="page-link" href="<c:url value = "/product-info/list/'+totalPage+'"/>">'+totalPage+'</a></li>');
    			}
  			}

			if (indexPage < totalPage) {
    			$('#pagination').append('<li class="page-item"><a class="page-link" href= "<c:url value = "/product-info/list/'+(indexPage+1)+'"/>">Next</a></li>');
  			}else{
				$('#pagination').append('<li class="disabled"><a class="page-link" href= "javascript:void(0);">Next</a></li>');
			  }
		}
		
		function processMenu() {
			$('#product-infolistId').addClass('current-page').siblings().removeClass("current-page");
			var parent = $('#product-infolistId').parents('li');
			parent.addClass('active').siblings().removeClass('active');
			$('#product-infolistId').parents().show();
		}

		function processNotify(){
			var msg_sucess = '${msg_success}';
			var msg_error = '${msg_error}';

			if(msg_sucess){
				new PNotify({
					title: 'Success',
					text: msg_sucess,
					type: 'success',
					styling: 'bootstrap3'
				});
			}
			if(msg_error){
				new PNotify({
					title: 'Error',
					text: msg_error,
					type: 'error',
					styling: 'bootstrap3'
				});
			}
		}
		
		 $(function(){
		      $('*').keyup(function(e){
		          if(e.keyCode=='13'){
		            $('#search_form').submit();
		          }     
		      })
		    })
	</script>
</body>
</html>