<html>
<head>
<title>OpenSQM Main Menu</title>
<link rel="stylesheet" type="text/css" href="assets/css/opensqm.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="assets/js/categories.js"></script>
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
<script>
	function addCategory() {
		//document.form.submit();
		$
				.ajax({
					method : "POST",
					url : "categoryAddWeb",
					data : "{text:\"" + $('#category').val() + "\", weight:\""
							+ $('#weight').val() + "\"}",
					datatype : "application/json",
					contentType : "text/plain",
					success : function(result) {
						var resp = JSON.parse(result);
						alert(result);
						//if (resp.status.code == "0") {
						$('table#categoryTbl tr:first')
								.after(
										"<tr><td>"
												+ $('#category').val()
												+ "</td><td>"
												+ $('#weight').val()
												+ "</td><td><button class=\"btn btn-success btn-sm\">Change</button></td></tr>");
						//	}
					}
				});
		$('#dialog-form').modal('hide');
	}
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
			<h2>Categories</h2>
			<button id="newCategory" class="btn btn-primary align-right"
				data-toggle="modal" data-target="#dialog-form">New Category</button>
		</div>

		<div class="table-responsive panel-body">
			<table id="categoryTbl"
				class="table table-hover table-bordered table-striped">
				<tr>
					<th>Category</th>
					<th>Weight</th>
					<th></th>
				</tr>
			</table>
		</div>
	</div>
	<div id="dialog-form" title="Category" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="page col-sm-6">
						<h2>Catagories</h2>
					</div>
					<div class="col-sm-6" style="text-align:right;">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
				</div>

				<form>
					<div class="modal-body">
						<table class="table table-hover table-bordered table-striped">
							<tr>
								<td><label class="control-label">Category</label></td>
								<td><input type="text" class="form-control"
									placeholder="Category" id="category"></td>
							</tr>
							<tr>
								<td><label class="control-label">Weight</label></td>
								<td><input type="text" class="form-control"
									placeholder="Weight" id="weight"></td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<div class="col-xs-6 text-center">
							<input type="button" class="btn btn-info btn-lg" value="Add"
								onclick="return addCategory();" />
						</div>
						<div class="col-xs-6 text-center">
							<input type="button" class="btn btn-warning btn-lg"
								value="cancel" data-dismiss="modal" />
						</div>
					</div>
				</form>
			</div>
		</div>
</body>

</html>