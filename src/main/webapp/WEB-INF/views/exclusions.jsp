<html>
<head>
<title>OpenSQM Main Menu</title>
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
		<button name="Questions" id="questions">Questions</button>
		<button name="Reports" id="reports">Reports</button>
		<button name="Exclusions" id="exclusions">Exclusions</button>
		<button name="SampleQuestion" id="sample-question">Sample</button>
	</section>

	
<div class="panel panel-green">
	<div class="panel-heading">
		<div class="page col-sm-6"><h2>Exclusions</h2></div>
		<div class="col-sm-6" style="text-align:right;"><input type="button" class="btn btn-info btn-lg" value="Add"/></div>
	</div>
	<div class="panel-body">
		<table class="table table-hover table-bordered table-striped">
			<tr><th>Day</th><th>Start Time</th><th>End Time</th><th></th></tr>
			<tr><td>Fri</td><td>16:00</td><td>20:00</td><td>Remove</td></tr>
			<tr><td>11/27/2015<td>0:00</td><td>23:59</td><td>Remove</td></tr>
		</table>
	</div>
</div>
</body>
</html>