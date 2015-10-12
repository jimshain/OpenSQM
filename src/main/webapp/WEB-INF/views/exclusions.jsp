<header>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
		<div class="navbar-header">
		  <h1 class="navbar-brand"><span class="glyphicon glyphicon-calendar"></span> Exclusions</h1>
		</div>
		<div class="navbar-form navbar-right">
	
		  
		  <input type="text" class="form-control" placeholder="Search for..." ng-model="searchText">
		  
		
		<div class="btn-group " role="group">
			<button type="button" class="btn btn-primary">Add</button>
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
                        <th>Day&nbsp;</th>
                        <th>Start Time&nbsp;</th>
                        <th>End Time &nbsp;</th>
                      	<th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat="item in exclusions | filter:searchText | orderBy:'-day'">
                        <td>{{$index + 1}}</td>
                        <td>{{item.day}}</td>
                        <td>{{item.start_time}}</td>
                        <td>{{item.end_time}}</td>
						<td>
							<div class="btn-group btn-group-xs">
							   <button class="btn btn-danger" type="button"  ng-click="delete($index)">Remove</button>
							</div>
						</td>
                    </tr>
					<tr ng-if="exclusions.length==0">
						<td class="text-center" colspan="5"><br/><br/><br/>Loading...<br/><br/><br/></td>
					</tr>
                </tbody>
            </table>
		</div>
	</div>
</main>
					