function create(){		
	$.ajax({
		url : "/prestamo/create",
		method : 'GET',
		success : function(response){
			console.log(response);
			$("#contentFrmParticipante").empty();
			$("#contentFrmParticipante").html(response);
		},
		error : function(err){
			console.log(err);
		}		
	});
}
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