<%@include file="/commons/taglib.jsp"%>
<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
	<div class="menu_section">
		<h3>General</h3>
		<ul class="nav side-menu">
			<c:forEach var="menu" items="${menu}">
				<li id="${menu.id_menu}"><a><i class="fa fa-home"></i>${menu.name}<span
						class="fa fa-chevron-down"></span></a>
					<ul class="nav child_menu">
					<c:forEach var="menuChild" items="${menu.listMenuChild}">
						<li id="${menuChild.id_menu}"><a href="<c:url value = "${menuChild.url}"/>">${menuChild.name}</a></li>
						</c:forEach>
					</ul></li>
			</c:forEach>
		</ul>
	</div>
</div>