$(document).ready(function() {
	$.ajax({
		method : "POST",
		url : "categoryInqWeb",
		data : "{}",
		datatype : "application/json",
		contentType : "text/plain",
		success : function(result) {
			var resp = JSON.parse(result);
			$.each(resp.categories, function(idx, elem){
			    $('table#categoryTbl TBODY').append('<tr><td>'+elem.text+'</td><td>'+elem.weight +'</td><td>Change</td></tr>');
			    });
		}
	});
});