<HTML>

<head>
<title>OpenSQM Main Menu</title>
<link rel="stylesheet" type="text/css" href="assets/css/opensqm.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script>
	$(function() {
		var dialog, form;

		dialog = $("#dialog-form").dialog({
			autoOpen : false,
			height : 300,
			width : 450,
			modal : true,
			buttons : {
				"Submit" : function() {
					dialog.dialog("close");
				}
			},
			close : function() {
				form[0].reset();
				allFields.removeClass("ui-state-error");
			}
		});

		form = dialog.find("form").on("submit", function(event) {
		});

		$("#sample-question").button().on("click", function() {
			dialog.dialog("open");
		});

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
</script>
</head>
<body>

	<div id="dialog-form" title="Sample Question">
		<form>
			<fieldset>
				<p class="testQuestion">Why did the chicken cross the road?</p>
				<input type="radio" name="testAnswer" class="testAnswer" value="1">To
				get to the other side.</br> <input type="radio" name="testAnswer"
					class="testAnswer" value="2">Colonel Sanders wasn't far
				behind.<br> <input type="radio" name="testAnswer"
					class="testAnswer" value="3">It never made it. Nuggets for
				all!<br>

				<!-- Allow form submission with keyboard without duplicating the dialog button -->
				<input type="submit" tabindex="-1"
					style="position:absolute; top:-1000px">
			</fieldset>
		</form>
	</div>

	<section class="flat">
		<button name="Categories" id="categories">Categories</button>
		<button name="Questions" id="questions">Questions</button>
		<button name="Reports" id="reports">Reports</button>
		<button name="Exclusions" id="exclusions">Exclusions</button>
		<button name="SampleQuestion" id="sample-question">Sample</button>
	</section>

</BODY>
</HTML>