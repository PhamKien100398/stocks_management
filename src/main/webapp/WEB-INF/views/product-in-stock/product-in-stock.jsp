<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="right_col" role="main">
	<div class="">

		<div class="clearfix"></div>
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>Product In Stock List</h2>

					<div class="clearfix"></div>
				</div>


				<div class="x_content">
					<div class="container" style="padding: 50px;">
						<form:form modelAttribute="searchForm"
								cssClass="form-horizontal form-label-left"
								servletRelativeAction="/product-in-stock/list/1" method="POST"
								enctype="multipart/form-data">
								
								<div class="item form-group">
									<label class="col-form-label col-md-3 col-sm-3 label-align"
										for="code">Code <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6">
										<form:input path="productInfo.code" cssClass="form-control "
											disabled="${viewOnly}" />
									</div>
								</div>
								<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align" for="code">Category <span class="required">*</span></label>
								<div class="col-md-6 col-sm-6">
									<form:input path="productInfo.category.name" cssClass="form-control" />
								</div>
							</div>
								<div class="item form-group">
									<label class="col-form-label col-md-3 col-sm-3 label-align"
										for="name">Name <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6">
										<form:input path="productInfo.name" cssClass="form-control "
											disabled="${viewOnly}" />
									</div>
								</div>
								
								<div class="item form-group">
									<div class="col-md-6 col-sm-6 offset-md-3">
										<button class="btn btn-success" type="submit">Search</button>
									</div>
								</div>

							</form:form>
					</div>

					<div class="table-responsive">
						<table class="table table-striped jambo_table bulk_action">
							<thead>
								<tr class="headings">
									<th class="column-title">#</th>
									<th class="column-title">Category</th>
									<th class="column-title">Code</th>
									<th class="column-title">Name</th>
									<th class="column-title">Image</th>
									<th class="column-title">Qty</th>
									<th class="column-title">Price</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${list}" var="product" varStatus="loop">

									<c:choose>
										<c:when test="${loop.index%2==0 }">
											<tr class="even pointer">
										</c:when>
										<c:otherwise>
											<tr class="odd pointer">
										</c:otherwise>
									</c:choose>
									<td class=" ">${pageInfo.getOffset()+loop.index+1}</td>
									<td class=" ">${product.productInfo.category.name }</td>
									<td class=" ">${product.productInfo.code }</td>
									<td class=" ">${product.productInfo.name }</td>
									<td class=" "><img src="<c:url value="${product.productInfo.imgUrl}"/>" width="100px" height="100px"/></td>
									<td class="">${product.qty }</td>
									<td class="">${product.price }</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
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

	 $(document).ready(function(){
		 processMessage();
		 processPage();
		 processMenu();
	 });
	 
	 function processPage() {
			var indexPage = parseInt('${pa.indexPage}');
			var totalPage = parseInt('${pa.totalPage}');
			var active;
			var pageCutLow = indexPage - 1;
			var pageCutHigh = indexPage + 1;
			if(indexPage > 1){
				$('#pagination').append('<li class="page-item"><a class="page-link" href="<c:url value = "/product-in-stock/list/'+(indexPage-1)+'"/>">Previous</a></li>');
			}else{
				$('#pagination').append('<li class="disabled"><a class="page-link" href="javascript:void(0);">Previous</a></li>');
			}
			if(totalPage < 6){
				for(var i = 1; i <= totalPage; i++){
					active = indexPage == i ? "active" : "";
					$('#pagination').append('<li class="page-item '+active+'"><a class="page-link" href= "<c:url value = "/product-in-stock/list/'+i+'"/>">'+i+'</a></li>');
				}
			}else {
 // Show the very first page followed by a "..." at the beginning of the
 // pagination section (after the Previous button)
 			if (indexPage > 2) {
					$('#pagination').append('<li class="page-item"><a class="page-link" href= "<c:url value = "/product-in-stock/list/1"/>">1</a></li>');
   				if (indexPage > 3) {
						$('#pagination').append('<li class="out-of-range"><a class="page-link" href="<c:url value = "/product-in-stock/list/'+(indexPage-2)+'"/>">...</a></li>');
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
   				$('#pagination').append('<li class="page-item '+active+'"><a class="page-link" href= "<c:url value = "/product-in-stock/list/'+p+'"/>">'+ p +'</a></li>');
 			}
 // Show the very last page preceded by a "..." at the end of the pagination
 // section (before the Next button)
 			if (indexPage < totalPage-1) {
   				if (indexPage < totalPage-2) {
     				$('#pagination').append('<li class="out-of-range"><a class="page-link" href= "<c:url value = "/product-in-stock/list/'+(indexPage+2)+'"/>">...</a></li>');
   				}
   				$('#pagination').append('<li class="page-item"><a class="page-link" href="<c:url value = "/product-in-stock/list/'+totalPage+'"/>">'+totalPage+'</a></li>');
 			}
			}

			if (indexPage < totalPage) {
 			$('#pagination').append('<li class="page-item"><a class="page-link" href= "<c:url value = "/product-in-stock/list/'+(indexPage+1)+'"/>">Next</a></li>');
			}else{
				$('#pagination').append('<li class="disabled"><a class="page-link" href= "javascript:void(0);">Next</a></li>');
			  }
		}
	 
	 function processMessage(){
		 var msgSuccess = '${msgSuccess}';
		 var msgError = '${msgError}';
		 if(msgSuccess){
			 new PNotify({
                 title: ' Success',
                 text: msgSuccess,
                 type: 'success',
                 styling: 'bootstrap3'
             });
		 }
		 if(msgError){
			 new PNotify({
                 title: ' Error',
                 text: msgError,
                 type: 'error',
                 styling: 'bootstrap3'
             });
		 }
	 }
	 
	 function processMenu() {
			$('#product-in-stocklistId').addClass('current-page').siblings().removeClass("current-page");
			var parent = $('#product-in-stocklistId').parents('li');
			parent.addClass('active').siblings().removeClass('active');
			$('#product-in-stocklistId').parents().show();
		}
	
	
</script>