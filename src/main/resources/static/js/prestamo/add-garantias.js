
function create(){
	
	$.ajax({
		url : "/garantia/create",
		method : 'GET',
		success : function(response){
			console.log(response);
			$("#frmGarantia").empty();
			$("#frmGarantia").html(response);
			
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
			console.log(response);
			$("#lstGarantias").empty();
			$("#lstGarantias").html(response);
		},
		error : function(err){
			console.log(err);
		}
	});
	
}


function save(){
	
	var dataForm = objectifyForm($("#frmGarantia").serializeArray());	
	var requestBody = JSON.stringify(dataForm);
	console.log(requestBody);		
	$.ajax({
		url : "http://localhost:8080/prestamo/add",
		method : 'POST',
		contentType : "application/json",
		headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
		data : requestBody,
		success : function (response){
			console.log(response);
			list();
		},
		error : function(err){
			console.log(err);
		}
	});
}

function objectifyForm(formArray) {
	var returnArray = {};
	for (var i = 0; i < formArray.length; i++) {
		returnArray[formArray[i]['name']] = formArray[i]['value'];
	}
	return returnArray;
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