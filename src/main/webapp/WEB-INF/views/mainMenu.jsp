<HTML>

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

	});
	/*$( document ).ready(function() {
		$('#dialog-form').modal('show');
	});*/
</script>
</head>
<body>

	<div id="dialog-form" title="Sample Question" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="page"><h2>Why did the chicken cross the road?</h2></div>
						</div>
						<div class="panel-body">
							<input type="radio" name="testAnswer" class="testAnswer" value="1">To get to the other side.
							</br> 
							<input type="radio" name="testAnswer"class="testAnswer" value="2">Colonel Sanders wasn't far behind.
							<br> 
							<input type="radio" name="testAnswer" class="testAnswer" value="3">It never made it. Nuggets for all!
							<br>
						</div>
						<div class="panel-footer" style="overflow:hidden;">
							<div class="col-xs-6 text-center">
								<input type="button" class="btn btn-info btn-lg" value="Submit"/>
							</div>
							<div class="col-xs-6 text-center">
								<input type="button" class="btn btn-warning btn-lg" value="Close" data-dismiss="modal"/>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<section class="flat">
		<button name="Categories" id="categories">Categories</button>
		<button name="Questions" id="questions">Questions</button>
		<button name="Reports" id="reports">Reports</button>
		<button name="Exclusions" id="exclusions">Exclusions</button>
		<button name="SampleQuestion" id="sample-question" data-toggle="modal" data-target="#dialog-form">Sample</button>
	</section>

</BODY>
</HTML>