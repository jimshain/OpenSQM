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
		<div class="page col-sm-6"><h2>Questions</h2></div>
		<div class="col-sm-6" style="text-align:right;"><input type="button" class="btn btn-info btn-lg" value="Add Question"/></div>
	</div>
	<div class="panel-body">
		<table class="table table-hover table-bordered table-striped">
			<tr><th>Question</th><th>Category</th><th>Active</th><th></th></tr>
			<tr><td>Why did the chicken cross the road?</td><td>Money Transfer</td><td>Y</td><td><button class="btn btn-success btn-sm">Edit</button></td></tr>
			<tr><td>How much would could a wookchuck chuck?</td><td>Check Cashing</td><td>Y</td><td><button class="btn btn-success btn-sm">Edit</button></td></tr>
		</table>
	</div>
</div>

</body>

</html>