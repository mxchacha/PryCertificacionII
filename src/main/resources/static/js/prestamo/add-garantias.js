function list(){	
	$.ajax({
		url : "/prestamo/things/",
		method : 'GET',
		success : function(response){
			$("#listGarantias").empty();
			$("#listGarantias").html(response);
		},
		error : function(err){
			console.log(err);
		}		
	});	
}

$(document).ready(function(){
	
	list();

		
});