function eliminar(id,nombre){
	swal({
		  title: "Está seguro que desea eliminar el registro de "+nombre +"?",
		  icon: "warning",
		  buttons: ["Cancelar", "Confirmar"],
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				  url:"/cliente/delete/"+ id,
				  success: function(res) {
					  console.log(res);
				  }
				  
			  });
		    swal("Registro eliminado correctamente", {
		      icon: "success",
		    }).then((OK)=>{
		    	if(OK){
		    		location.href="/cliente/list";
		    	}
		    });
		  } 
		});
	
}
