<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

	<div class="row">
		
		<!-- sidebar -->
		<div class="col-md-3">
			
			<%@include file="./partage/sidebar.jsp" %>
			
		
		</div>
		
		<!-- new products -->
		<div class="col-md-9">
			
			<!-- added breadcrumb -->
			<div class="row">
				<div class="col-lg-12">
				
					<c:if test="${userClickAllProducts == true}">
					
						<script>
								window.categoryId = '';
						</script>
					
					<ol class="breadcrumb">
						
						<li><a href="${contextRoot}/home">Home</a> </li>
						<li class="active">All Products</li>
					</ol>
					</c:if>
					
					<!-- ------- Part list product ------- -->
					
					<c:if test="${userClickCategoryProducts == true}">
						
						<script>
								window.categoryId = '${category.id}';
						</script>
						
					<ol class="breadcrumb">
						
						<li><a href="${contextRoot}/home">Home</a> </li>
						<li class="active">Category</li>
						<li class="active">${category.name}</li>
					</ol>
					</c:if>
					
				
				</div>
			
			</div>
		
			
			<!--  -->
			
			<div class="row">
				
				<div class="col-xs-12">
					
						<table id="productListTable" class="table table-striped table-borderd">
						
							<thead>
									
								<tr>
									
									<th> </th>
									<th>Name </th>
									<th>Brand </th>
									<th>Price </th>
									<th>Qty. Available </th>
									<th> Operation</th>
								
								</tr>
							
							</thead>
							
							<tfoot>
								
								<tr>
									
									<th> </th>
									<th>Name </th>
									<th>Brand </th>
									<th>Price </th>
									<th>Qty. Available </th>
									<th> Operation</th>
								
								</tr>
							
							</tfoot>
						
						</table>
				
				</div>
			
			</div>
			
			
		</div>
	
	
	</div>

</div>