/**
 * Catalogo
 */

function cargarmarcas(){
	var cat = $("#cbocategoria").val();
	if(cat != "0"){
		$("#cbomarca").empty();
	    $.ajax({
	        type: "GET",
	        url: "../sistemadarko/Marca",
	        data: {listar:"true",categoria:cat},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#cbomarca").append("<option value='0'>- Marcas -</option>");
	            $("#cbomarca").append(dataJson["opciones"]);
	        }
	    });
	}else{
		alert("Seleccione una categoria");
	}
}

function cargarmodelos(){
	var mar = $("#cbomarca").val();
	if(mar != "0"){
		$("#cbomodelo").empty();
	    $.ajax({
	        type: "GET",
	        url: "../sistemadarko/Modelo",
	        data: {listar:"true",marca:mar},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#cbomodelo").append("<option value='0'>- Modelos -</option>");
	            $("#cbomodelo").append(dataJson["opciones"]);
	        }
	    });
	    cargarcolores();
	}else{
		alert("Seleccione una marca");
	}
}

function cargarcolores(){
	var mar = $("#cbomarca").val();
	if(mar != "0"){
		$("#cbocolor").empty();
	    $.ajax({
	        type: "GET",
	        url: "../sistemadarko/Color",
	        data: {listar:"true",marca:mar},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#cbocolor").append("<option value='0'>- Color -</option>");
	            $("#cbocolor").append(dataJson["opciones"]);
	        }
	    });
	}else{
		alert("Seleccione una marca");
	}
}


