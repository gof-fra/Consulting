<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">

	<div class="row">
	
	  <c:if test="${not empty message}">
		<div class="col-xs-12">
		
			<div class="alert alert-success alert-dismissible">
			
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				
				${message}
			
			</div>
		
		
		</div>
	  </c:if>
	  
	  
		<div class="col-md-offset-2 col-md-8">
			
			<div class="panel panel-primary">
			
				<div class="panel-heading">
				
					<h4>Product Management</h4>
				
				</div>
				
				<div class="panel-body">
				
					<!-- Form element -->
					
					<sf:form class="form-horizontal" modelAttribute="product"
					action="${contextRoot}/manage/products"
					method="POST"
					enctype="multipart/form-data"
					
					>
		
						<div class="form-group">
						
							<label class="control-label col-md-4" for="name"> Enter Product Name: </label>
							
							<div class="col-md-8">
								
								<sf:input type="text" path="name" id="name" placeholder="Product name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>
						
						
						
						<div class="form-group">
						
							<label class="control-label col-md-4" for="brand"> Enter Brand Name: </label>
							
							<div class="col-md-8">
								
								<sf:input type="text" path="brand" id="brand" placeholder="Brand name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							
							</div>
						</div>
						
						
						
						<div class="form-group">
						
							<label class="control-label col-md-4" for="description"> Product Description: </label>
							
							<div class="col-md-8">
								
								<sf:textarea path="description" id="description" rows="4" placeholder="Write some description" class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>
						
						
						
						<div class="form-group">
						
							<label class="control-label col-md-4" for="unitPrice"> Enter Unit Price: </label>
							
							<div class="col-md-8">
								
								<sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Write price" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" /> 
							</div>
						</div>
						
						
						
						<div class="form-group">
						
							<label class="control-label col-md-4" for="quantity"> Quantity: </label>
							
							<div class="col-md-8">
								
								<sf:input type="number" path="quantity" id="quantity" placeholder="Write quantity" class="form-control" />
								
							</div>
						</div>
						
						<!-- image -->
						<div class="form-group">
						
							<label class="control-label col-md-4" for="file"> Select an Image: </label>
							
							<div class="col-md-8">
								
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
								
							</div>
						</div>
						
						<!-- File image -->
						<div class="form-group">
						
							<label class="control-label col-md-4" for="categoryId"> Select Category: </label>
							
							<div class="col-md-8">
								
								<sf:select class="form-control" id="categoryId" path="categoryId" 
									items="${categories}"
									itemLabel = "name"
									itemValue = "id"
									
								/>
								
								<!-- add category -->
								
								<%-- <c:if test="${product.id == 0}">
								
									<div class="text-right">
										<br />
										<button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add New Category</button>
									</div>
								</c:if> --%>
																
							</div>
						</div>
						
						
						
						
						<div class="form-group">
						
							<div class="col-md-offset-4 col-md-8">
								
								<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary">
								
								<!-- Hidden fields for products -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
								
							</div>
							
						</div>
						
						
						</sf:form>
						
					</div>
					
				</div>
				
			</div>
			
		</div>
	
	
	<div class="row">
		
		
		<div class="col-xs-12">
		
			<h3>Available Product</h3>
			<hr/>
		
		</div>
		
		
		<div class="col-xs-12">
			<div style="overflow:auto">
			
				<!-- product table for admin -->
				
				<table id="adminProductsTable" class="table table-striped table-bordered">
				
					<thead>
							<tr>
								<th>ID</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
					</thead>
					
<%-- 					<tbody>
							<tr>
								<td> 4 </td>
								<td> 
									
									<img class="adminDatatableImg" src="${contextRoot}/resources/images/PRDDEF121OPMC.jpg"
									alt="Macbook Pro" />
									
								</td>
								
								<td> Macbook Pro</td>
								
								<td> 3 </td>  <!-- 3 quantity -->
								
								<td> &#8377; 54000.00 /- </td>
								
								<td> 
									<!-- toggle switch -->
									<label class="switch">
										<input type="checkbox" checked="checked" value="4"/>
										<div class="slider"></div>
									</label>
								</td>
								
								<td> 
									
									<a href="${contextRoot}/manage/4/product" class="btn btn-warning">
										<span class="glyphicon glyphicon-pencil"></span>
									</a>
									
								</td>
							</tr>
							
							<!-- ------- -->
							
							<tr>
								<td> 4 </td>
								<td> 
									
									<img class="adminDatatableImg" src="${contextRoot}/resources/images/PRDDEF121OPMC.jpg"
									alt="Macbook Pro" />
									
								</td>
								
								<td> Macbook Pro</td>
								
								<td> 3 </td>
								
								<td> &#8377; 54000.00 /- </td>
								
								<td> 
									<!-- toggle switch -->
									<label class="switch">
										<input type="checkbox"  value="4"/>
										<div class="slider"></div>
									</label>
								</td>
								
								<td> 
									
									<a href="${contextRoot}/manage/4/product" class="btn btn-warning">
										<span class="glyphicon glyphicon-pencil"></span>
									</a>
									
								</td>
							</tr>
							
							
					</tbody> --%>
					
					<tfoot>
							<tr>
								<th>ID</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
					</tfoot>
				
				
				</table>
			
			
			
			</div>
		
		</div>
	
	
	</div>
	
	
	<%-- <div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header"> <!-- Modal header	 -->
					<button type="button" class="close" data-dismiss="modal" >
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add New Product</h4>
					
					
					<div class="modal-body"> <!-- Modal body -->
						<sf:form modelAttribute="category" action="${contextRoot}/manage/category"
							method="POST"
							class="form-horizontal"
							 >
							 
							 <div class="form-group">
								 <label for="category_name" class="control-label col-md-4">Category Name</label>
								 <div class="col-md-8">
								 	<sf:input type="text" path="name" id="category_name" class="form-control" />								 	
								 </div>
							 </div>
							 
							 <div class="form-group">
								 <label for="category_description" class="control-label col-md-4">Category Description</label>
								 <div class="col-md-8">
								 	<sf:textarea cols="" rows="5"  path="description" id="category_description" class="form-control" />								 	
								 </div>
							 </div>
							 
							 <div class="form-group">
								 <div class="col-md-offset-4 col-md-8">
								 	<input type="submit" value="Add Category" class="btn btn-primary" />
								 </div>	
							 </div>
						</sf:form>
					</div>
					
				</div>
			</div>
		
		</div>
	</div>
	 --%>
</div>
	
