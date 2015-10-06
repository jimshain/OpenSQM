<html>
<head>
<TITLE>OpenSQM Main Menu</TITLE>
<link rel="stylesheet" type="text/css" href="assets/css/opensqm.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>

<body>
	<section class="flat">
		<button name="Categories" id="categories">Categories</button>
		<button name="Questions">Questions</button>
		<button name="Reports" id="reports">Reports</button>
		<button name="Exclusions" id="exclusions">Exclusions</button>
		<button name="SampleQuestion" id="sample-question">Sample</button>
	</section>

<h2>Reports</h2>

<table>
<tr><td>Start Date:</td><td><input type="text" name="startDate"></td></tr>
<tr><td>End Date:</td><td><input type="text" name="endDate"></td></tr>
<tr><td>Store Number:</td><td><input type="text" name="storeNumber"></td></tr>
<tr><td>Category:</td><td><input type="text" name="category"></td></tr>
</table>
<button>Run Report</button>
<p>
<table>
<tr><th>Store</th><th>Taken</th><th>Passed</th><th>Percent</th></tr>
<tr><td>100</td><td>47</td><td>23</td><td>49</td></tr>
<tr><td>110</td><td>101</td><td>5</td><td>5</td></tr>
<tr><td>240</td><td>30</td><td>27</td><td>90</td></tr>
<tr><td>594</td><td>204</td><td>143</td><td>70</td></tr>
</table>
</body>

</html>