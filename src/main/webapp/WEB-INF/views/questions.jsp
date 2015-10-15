<header>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
		<div class="navbar-header">
		  <h1 class="navbar-brand"><span class="glyphicon glyphicon-question-sign"></span> Questions</h1>
		</div>
		<div class="navbar-form navbar-right">
	
		  
		  <input type="text" class="form-control" placeholder="Search for..." ng-model="searchText">
		  
		
		<div class="btn-group " role="group">
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#add_question">Add Questions</button>
		</div>
		</div>
		</div><!-- /.navbar -->
	</nav>
</header>
<main>
	<div class="container-fluid">
		<div class="page-content">
			<table class="table table-hover">
                <thead>
                    <tr>
                        <th>SN&nbsp;</th>
                        <th>Question&nbsp;</th>
                        <th>Category&nbsp;</th>
						<th>Choices&nbsp;</th>
                        <th>Active &nbsp;</th>
                        <th>Created At &nbsp;</th>
                        <th>Action &nbsp;</th>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat="item in questions | filter:searchText | orderBy:'-created'">
                        <td>{{$index + 1}}</td>
                        <td>{{item.text}}</td>
						<td>{{item.category}}</td>
						<td>{{item.choices}}</td>
						<td>{{item.active}}</td>
	                    <td>{{item.created | date :"dd MMM y | hh:mm a"}}</td>
						<td>
							<div class="btn-group-xs">
							  <button class="btn btn-info" type="button" ng-click="edit(item)">Edit</button>
							  <!--<button class="btn btn-danger" type="button"  ng-click="delete($index)">Remove</button>-->
							  <button class="btn btn-info" type="button" ng-click="view(item)">View</button>
							  <button class="btn btn-info" type="button" ng-click="sample(item)">Sample</button>
							</div>
						</td>   
                    </tr>
					<tr ng-if="questions.length==0">
						<td class="text-center" colspan="7"><br/><br/><br/>Loading...<br/><br/><br/></td>
					</tr>
                </tbody>
            </table>
		</div>
	</div>
	
	<div id="add_question" class="modal fade">
	  <div class="modal-dialog">
	  <form name="From" novalidate>
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<h4 class="modal-title">Add New Question</h4>
		  </div>
		  <div class="modal-body">
			<div class="form-group">
				<label for="item_name">Question</label>
				<textarea class="form-control" id="item_name" placeholder="Enter Question" ng-model="item.question" required></textarea>
			</div>
			<div class="form-group">
				<label for="choices">Choices <span class="help-block small">(Select checkboxes to indicate correct awnsers.)</span></label>
				
				<div class="row">
					<div class="col-sm-6">
						<div class="input-group">
						  <input type="text" class="form-control" id="choice1" placeholder="Choice 1">
						  <div class="input-group-addon"><input type="checkbox"></div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="input-group">
						  <input type="text" class="form-control" id="choice2" placeholder="Choice 2">
						  <div class="input-group-addon"><input type="checkbox"></div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="input-group">
						  <input type="text" class="form-control" id="choice3" placeholder="Choice 3">
						  <div class="input-group-addon"><input type="checkbox"></div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="input-group">
						  <input type="text" class="form-control" id="choice4" placeholder="Choice 4">
						  <div class="input-group-addon"><input type="checkbox"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="category">Select Category </label>
						<select class="form-control" id="category" placeholder="Select Category" ng-model="item.category" required>
							<option value="">Select Category</option>
							<option ng-repeat="option in categories" value="{{option.category}}">{{option.category}}</option>
						</select>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="active">Active Flag</label>
						<select class="form-control" id="active" ng-model="item.active" required>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select>
					</div>
				</div>
			</div>
				
			  		 
		  </div>
		  <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			<button type="submit" class="btn btn-primary" ng-click="save()">Save</button>
		  </div>
		</div><!-- /.modal-content -->
		</form>
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<div id="edit_question" class="modal fade">
	  <div class="modal-dialog">
	  <form name="From" novalidate>
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<h4 class="modal-title">Edit Question</h4>
		  </div>
		  <div class="modal-body">
			<div class="form-group">
				<label for="item_name">Question</label>
				<textarea class="form-control" id="item_name" placeholder="Enter Question" ng-model="item.question" required></textarea>
			</div>
			<div class="form-group">
				<label for="choices">Choices <span class="help-block small">(Select checkboxes to indicate correct awnsers.)</span></label>
				
				<div class="row">
					<div class="col-sm-6">
						<div class="input-group">
						  <input type="text" class="form-control" id="choice1" placeholder="Choice 1">
						  <div class="input-group-addon"><input type="checkbox"></div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="input-group">
						  <input type="text" class="form-control" id="choice2" placeholder="Choice 2">
						  <div class="input-group-addon"><input type="checkbox"></div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="input-group">
						  <input type="text" class="form-control" id="choice3" placeholder="Choice 3">
						  <div class="input-group-addon"><input type="checkbox"></div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="input-group">
						  <input type="text" class="form-control" id="choice4" placeholder="Choice 4">
						  <div class="input-group-addon"><input type="checkbox"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="category">Select Category </label>
						<select class="form-control" id="category" placeholder="Select Category" ng-model="item.category" required>
							<option value="">Select Category</option>
							<option ng-repeat="option in categories" value="{{option.category}}">{{option.category}}</option>
						</select>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="active">Active Flag</label>
						<select class="form-control" id="active" ng-model="item.active" required>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select>
					</div>
				</div>
			</div>
				
			  		 
		  </div>
		  <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			<button type="submit" class="btn btn-primary" ng-click="save()">Save Changes</button>
		  </div>
		</div><!-- /.modal-content -->
		</form>
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</main>
					