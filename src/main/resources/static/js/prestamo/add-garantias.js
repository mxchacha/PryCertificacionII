function searchByCedula(){
	console.log("Entro a buscar");
	var criteria = $("#txtCedula").val();
	console.log(criteria);
	$.ajax({
		url : "/cliente/search/" + criteria,
		method : 'GET',
		success : function(response){
			$("#clienteid").empty();			
			var count = Object.keys(response).length;			
			if(count > 0){								
				$("#clienteid").addClass('visible').removeClass('invisible');
				$.each( response, function(index, cliente) {					
					$("#clienteid").append("<option value='"+ persona.cliente.idpersona +"'>" + cliente.nombre + " " + cliente.apellido + "</option>");					
				});
			}
			else{
				$("#clienteid").addClass('invisible').removeClass('visible');
				console.log("No hay garantes para ese inicio de cédula: " + criteria);				
			}			
		},
		error : function(err){
			console.error(err);
		}		
	});
}

function create(){		
	$.ajax({
		url : "/garante/create",
		method : 'GET',
		success : function(response){
			console.log(response);
			$("#contentFrmGarante").empty();
			$("#contentFrmGarante").html(response);
		},
		error : function(err){
			console.log(err);
		}		
	});
}

function list(){	
	$.ajax({
		url : "/prestamo/guarantor/",
		method : 'GET',
		success : function(response){
			$("#lstGarantes").empty();
			$("#lstGarantes").html(response);
		},
		error : function(err){
			console.log(err);
		}		
	});	
}

function save(){	
	var dataForm = objectifyForm($("#frmGarante").serializeArray());	
	var requestBody = JSON.stringify(dataForm);
	console.log(requestBody);			
	$.ajax({
		url : developURL + "prestamo/add",
		method : 'POST',
		contentType : "application/json",
		headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},		
		data : requestBody,
		success : function(response){
			console.log(response);			 
			list();
		},
		error : function(err){
			console.log(err);
		}		
	});
	
}



$(document).ready(function(){
	
	list();
	
	$("#btnAdd").click(function(){
		create();		
	});
	
	$("#btnSubmit").click(function(){
		save();		
	});
		
});