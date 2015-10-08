<html>
<head>
<TITLE>OpenSQM Main Menu</TITLE>
<link rel="stylesheet" type="text/css" href="assets/css/opensqm.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script>
	$(function() {
		$("#reports").button().on("click", function() {
			window.location.href = "reports";
		});

		$("#categories").button().on("click", function() {
			window.location.href = "categories";
		});
		
		$("#questions").button().on("click", function() {
			window.location.href = "questions";
		});
		$("#exclusions").button().on("click", function() {
			window.location.href = "exclusions";
		});
		$("#sample-question").button().on("click", function() {
			window.location.href = "mainMenu";
		});

	});
</script>
</head>

<body>
	<section class="flat">
		<button name="Categories" id="categories">Categories</button>
		<button name="Questions">Questions</button>
		<button name="Reports" id="reports">Reports</button>
		<button name="Exclusions" id="exclusions">Exclusions</button>
		<button name="SampleQuestion" id="sample-question">Sample</button>
	</section>
	
<div>
<div class="panel panel-green col-xs-6">
	<div class="panel-heading">
		<div class="page col-sm-6"><h2>Questions</h2></div>
	</div>
	<div class="panel-body">
		<table class="table table-hover table-bordered table-striped">
			<tr><td><label class="control-label">Start Date</label></td><td><input type="text" class="form-control" name="startDate" placeholder="Start Date"></td></tr>
			<tr><td><label class="control-label">End Date</label></td><td><input type="text" class="form-control" name="endDate" placeholder="End Date"></td></tr>
			<tr><td><label class="control-label">Store Number</label></td><td><input type="text" class="form-control" name="storeNumber" placeholder="Store Number"></td></tr>
			<tr><td><label class="control-label">Category</label></td><td><input type="text" class="form-control" name="category" placeholder="Category"></td></tr>
		</table>
	</div>
	<div class="panel-footer">
		<div class="col-sm-6" style="text-align:right;"><input type="button" class="btn btn-info btn-lg" value="Add Question"/></div>
	</div>
</div>
<div class="panel panel-green col-xs-6">
	<div class="panel-heading">
		<div class="page col-sm-6"><h2>Run Report</h2></div>
		
	</div>
	<div class="panel-body">
		<table class="table table-hover table-bordered table-striped">
			<tr><th>Store</th><th>Taken</th><th>Passed</th><th>Percent</th></tr>
			<tr><td>100</td><td>47</td><td>23</td><td>49</td></tr>
			<tr><td>110</td><td>101</td><td>5</td><td>5</td></tr>
			<tr><td>240</td><td>30</td><td>27</td><td>90</td></tr>
			<tr><td>594</td><td>204</td><td>143</td><td>70</td></tr>
		</table>
	</div>
</div>
</div>

</body>

</html>