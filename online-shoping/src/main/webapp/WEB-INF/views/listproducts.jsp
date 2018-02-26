<div class="container">

	<div class="row">

		<!-- here inside div class container we are applying two columns & first column to display sidebar class as follows    -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- second class two display actual product -->

		<div class="col-md-9">
			<!-- added breadcrumb component -->
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userclicksallproducts == true}">
						<ul class="breadcrumb">
							<li class ="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class=" breadcrumb-item" >All Products</li>
						</ul>
					</c:if>

					<c:if test="${userclickscategoryproducts == true}">
						<ul class="breadcrumb">
							<li  class ="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li  class ="breadcrumb-item">All Products</li>
							<li  class ="breadcrumb-item">${category.name}</li>
						</ul>
					</c:if>



				</div>

			</div>

		</div>

	</div>

</div>