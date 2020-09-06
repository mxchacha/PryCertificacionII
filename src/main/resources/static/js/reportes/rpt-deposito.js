function report2(){
	
	var color = Chart.helpers.color;
	var barChartData = {
		labels: ['Certificación I', 'Ingeniería Web', 'Métodos numéricos', 'Estructura de datos', 'Metodología'],
		datasets: [{
			label: 'diegoismael',
			backgroundColor: color(getRandomColor()).alpha(0.5).rgbString(),			
			borderWidth: 1,
			data: [
				10,
				2,
				5,
				9,
				8				
			]
		}, {
			label: 'dsanchez',
			backgroundColor: color(getRandomColor()).alpha(0.5).rgbString(),			
			borderWidth: 1,
			data: [
				16,
				12,
				4,
				0,
				9
			]
		}]

	};

	
	var ctx = document.getElementById('canvas22').getContext('2d');
	window.myBar = new Chart(ctx, {
		type: 'bar',
		data: barChartData,
		options: {
			responsive: true,
			legend: {
				position: 'top',
			},
			title: {
				display: true,
				text: 'Matrículas por materia y por usuario [MUESTRA]'
			}
		}
	});

		
}





function report3(){
	$.ajax({
		url : "/deposito/dataRptDeposito",
		method : 'GET',
		success : function(response){
			console.log(response);
			var toData = [];
			var toFechasTodas = [];
			var toMontosTodos = [];
			var toBarras = [];
			var color = Chart.helpers.color;
			var toCantidad = [];
			
			$.each(response, function(i, item){
				console.log(item);
				toMontosTodos.push(item.monto);
				toFechasTodas.push(item.fechaDeposito);
				
			});
			
			//Cargar las barras
			var usuTemp = ".";//Variable temporal para almacenar el nombre y que no se repita
			var cantTemp = 0;
			$.each(toFechasTodas, function(i, item){//Controla que solo se trabaje con las fechas que no estan repetidos
				console.log("--------------------------------");
				console.log(item);//prueba en consola de que se imprima la fecha
				cantTemp = 0;//Variable para controlar si no tiene atributos
				response.forEach(function(element){//Controla que se vea todo lo que venia de la base de datos 
					if(item == element.fechaDeposito ){
						console.log(element.fechaDeposito);
						console.log(element.monto);
						cantTemp=1;
						toCantidad.push(element.monto);//Asignacion de la cantidad en la barra
					}	
				});
				if(cantTemp == 0){
					toCantidad.push(0);//Si no tiene atributos que se llene con 0 
				}
				usuTemp = item;	//Asignacion del usuario temporal para que no se repitan y controlar
				var barra = { //Carga del datasets para que se cree la barra 
						label: item,
						backgroundColor: color(getRandomColor()).alpha(0.5).rgbString(),			
						borderWidth: 1,
						data: toCantidad,
					}
				toBarras.push(barra);
				toCantidad = []; 
			});
			
			
			var barChartData = {
				labels: [''],
				datasets: toBarras
			};

			
			var ctx = document.getElementById('canvas33').getContext('2d');
			window.myBar = new Chart(ctx, {
				type: 'bar',
				data: barChartData,
				options: {
					responsive: true,
					legend: {
						position: 'top',
					},
					title: {
						display: true,
						text: 'Reporte de retiros por dia en el Sistema'
					}
				}
			});
			
		},
		error : function(err){
			console.log(err);
		}		
	});
	
			
}



$(document).ready(function(){
	window.onload = function() {

		//report2();		
		report3();	

	};
	
	
});
