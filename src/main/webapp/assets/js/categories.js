$(document).ready(function() {
	$.ajax({
		method : "POST",
		url : "categoryInqWeb",
		data : "",
		datatype : "application/json",
		contentType : "text/plain",
		success : function(result) {

			var resp = JSON.parse(result);
			if (resp.status.returnCode == '0') {
				window.location.href = resp.nextUrl;
			} else {
				alert(resp.status.message);
			}
		}
	});
});