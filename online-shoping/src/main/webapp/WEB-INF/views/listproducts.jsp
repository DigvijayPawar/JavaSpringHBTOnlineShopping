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
						<script>
							window.categoryId = '';
						</script>

						<ul class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class=" breadcrumb-item">All Products</li>
						</ul>
					</c:if>

					<c:if test="${userclickscategoryproducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>

						<ul class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item">All Products</li>
							<li class="breadcrumb-item">${category.name}</li>
						</ul>
					</c:if>



				</div>

			</div>

			<div class="row">

				<div class="col-xl-12">

					<table id="productListTable"
						class="table table-striped table-bordered">

						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							</tr>

						</thead>
							<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							</tr>

						</tfoot>


					</table>

				</div>

			</div>

		</div>

	</div>

</div>