<html>
<head>
<title>OpenSQM Main Menu</title>
<link rel="stylesheet" type="text/css" href="assets/css/opensqm.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		var dialog, form;

		function addCategory() {
			alert("submitting");
			dialog.dialog("close");
		}

		dialog = $("#dialog-form").dialog({
			autoOpen : false,
			height : 300,
			width : 450,
			modal : true,
			buttons : {
			    "Add": addCategory,
				"Cancel" : function() {
					dialog.dialog("close");
				}
			},
			close : function() {
				form[0].reset();
				allFields.removeClass("ui-state-error");
			}
		});

		form = dialog.find("form").on("submit", function(event) {
		alert("submitted");
		});

		$("#newCategory").button().on("click", function() {
			dialog.dialog("open");
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
	<p>
	<h2>Categories</h2>

	<button id="newCategory">New Category</button>

	<table>
		<tr>
			<th>Category</th>
			<th>Weight</th>
			<th></th>
		</tr>
		<tr>
			<td>Money Transfer</td>
			<td>20</td>
			<td>Change</td>
		</tr>
		<tr>
			<td>Check Cashing</td>
			<td>20</td>
			<td>Change</td>
		</tr>
		<tr>
			<td>Bill Payment</td>
			<td>15</td>
			<td>Change</td>
		</tr>
		<tr>
			<td>Credit Card</td>
			<td>5</td>
			<td>Change</td>
		</tr>
		<tr>
			<td>Store Operations</td>
			<td>15</td>
			<td>Change</td>
		</tr>
	</table>
	
		<div id="dialog-form" title="Category">
		<form>
			<fieldset>
			<table>
			<tr><td>Category:</td><td><input type="text"></td></tr>
			<tr><td>Weight:</td><td><input type="text"></td></tr>
			</table>
				<!-- Allow form submission with keyboard without duplicating the dialog button -->
				<input type="submit" tabindex="-1"
					style="position:absolute; top:-1000px">
			</fieldset>
		</form>
	</div>
	
</body>

</html>