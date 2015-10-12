<header>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
		<div class="navbar-header">
		  <h1 class="navbar-brand"><span class="glyphicon glyphicon-file"></span> Reports</h1>
		</div>
		<div class="navbar-form navbar-right">
	
		  
		  <input type="text" class="form-control" placeholder="Search for..." ng-model="searchText">
		  
		
		<div class="btn-group " role="group">
			<button type="button" class="btn btn-primary">Create</button>
		</div>
		</div>
		</div><!-- /.navbar -->
	</nav>
</header>
<main>
	<div class="container-fluid">
		<div class="page-content">
			<div class="row">
				<div class="col-sm-5">
					<div class="panel panel-default">
					  <div class="panel-heading">
						<h3 class="panel-title">Questions</h3>
					  </div>
					  <div class="panel-body">
						<form class="form-horizontal">
						  <div class="form-group">
							<label for="start_date" class="col-sm-4 control-label">Start Date</label>
							<div class="col-sm-8">
							  <input type="date" class="form-control" id="start_date" placeholder="Start Date">
							</div>
						  </div>
						  <div class="form-group">
							<label for="end_date" class="col-sm-4 control-label">End Date</label>
							<div class="col-sm-8">
							  <input type="date" class="form-control" id="end_date" placeholder="End Date">
							</div>
						  </div>
						  <div class="form-group">
							<label for="store_number" class="col-sm-4 control-label">Store Number</label>
							<div class="col-sm-8">
							  <input type="number" class="form-control" id="store_number" placeholder="Store Number">
							</div>
						  </div>
						  <div class="form-group">
							<label for="category" class="col-sm-4 control-label">Category</label>
							<div class="col-sm-8">
							  <input type="text" class="form-control" id="category" placeholder="Category">
							</div>
						  </div>
						  <div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
							  <button type="submit" class="btn btn-success">Run Report</button>
							</div>
						  </div>
						</form>
					  </div>
					</div>
				</div>
				<div class="col-sm-7">
					<div class="panel panel-default">
					  <div class="panel-heading">
						<h3 class="panel-title">Report Result</h3>
					  </div>
					  <div class="panel-body no-padding">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>SN&nbsp;</th>
										<th>Store&nbsp;</th>
										<th>Taken&nbsp;</th>
										<th>Passed &nbsp;</th>
										<th>Percent&nbsp;</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="item in reports | filter:searchText">
										<td>{{$index + 1}}</td>
										<td>{{item.store}}</td>									
										<td>{{item.taken}}</td>
										<td>{{item.passed}}</td>
										<td>{{item.percent}}</td>
									</tr>
									<tr ng-if="reports.length==0">
										<td class="text-center" colspan="5"><br/><br/><br/>Loading...<br/><br/><br/></td>
									</tr>
								</tbody>
							</table>
					  </div>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>
					