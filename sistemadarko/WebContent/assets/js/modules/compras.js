// Funcion que muestra la lista de productos segun el texto ingresado
function onsearchproduct(){
	// funcion para buscar dinamicamente el producto
	// alert("hola");
	var prod = $("#txtbuscador").val();
	if(prod !=""){
		$.ajax({
	    	type: "GET",
	        url: "../sistemadarko/Producto",
	        data: {nombre:prod},
	        success: function(resp){
	        	var dataJson = eval(resp);
	            $("#selectproductos").html(dataJson["lista"]);
	        }
	    });
	}else{
		$("#selectproductos").html("");
	}
}
// Funcion que carga el nombre de producto al seleccionar de la lista de busqueda
function selectionItem(idproducto,nombre){
	//alert("Idproducto: "+idproducto);
	$("#hdidproducto").val(idproducto);
	$("#txtbuscador").val(nombre);
	$("#selectproductos").html("");
	
}
// Funcion que muestra las tallas y colores relacionados con la categoria y marca correspondiente
function cargarProducto(){
	var id = $("#hdidproducto").val();
	var nombre = $("#txtbuscador").val();
	$("#txtproducto").val(nombre);
	//Cargar tallas y colores
	$.ajax({
		type:"GET",
		url: "../sistemadarko/Producto",
        data: {opcion:'detalles',idproducto:id,producto:nombre},
        success: function(resp){
        	var dataJson = eval(resp);
            $("#listtallas").html(dataJson["tallas"]);
            $("#listcolores").html(dataJson["colores"]);
            $("#txtbuscador").val("");
        }
	});

}

// Funcion para seleccionar un detalle marca o color
function selectItemDetalle(tipo,id,nombre){	
	var accion="";
	if($("#"+tipo+id).hasClass("selectitem")){		
		accion = "quit";
	}else{		
		accion = "add";
	}
	$.ajax({
		type:"POST",
		url:"../sistemadarko/Producto",
		data:{accion:accion,tipo:tipo,id:id,nombre:nombre},
		success: function(resp){
			var dataJson = eval(resp);
			if(dataJson["success"] == "ok"){
				if(accion == "add"){
					$("#"+tipo+id).addClass("selectitem");
				}else{
					$("#"+tipo+id).removeClass("selectitem");
				}
			}
		}
	});
}

//Funcion que agrega un producto a la lista de compras
function addProductoLista(){
	var cantidad = $("#txtcantidad").val();
	var costounit = $("#txtcosto").val();
	if(cantidad != "" && costounit != ""){
		$.ajax({
			type:"POST",
			url:"../sistemadarko/Producto",
			data:{accion:"addproducto",cantidad:cantidad,costo:costounit},
			success: function(resp){
				var dataJson = eval(resp);
				$("#tbl_listproductos").append(dataJson["row"]);
				$("#txtcantidad").val("");
				$("#txtcosto").val("");
				$("#txtproducto").val("");
				$("#hdidproducto").val("0");
				$("#listtallas").html("");
	            $("#listcolores").html("");
			}
		});
	}else{
		alert("Falta agregar cantidad y/o costo unitario");
	}
} 

// Funcion para quitar un inventario de la lista
function quitarInventario(idproducto){
	if(confirm("¿Desea quitar de lista?")){
		$.ajax({
			type:"POST",
			url:"../sistemadarko/Producto",
			data:{accion:"quitarproducto",id:idproducto},
			success: function(resp){
				var dataJson = eval(resp);
				if(dataJson["success"]=="ok"){
					$("#inv"+idproducto).remove();
				}
			}
		});
	}
}

// Funcion para terminar el proceso de generar un tracking (compra)
function guardarcompra(){
	if(confirm("Confirma registrar compra?")){
		var tracking = $("#txttracking").val();
		var fecha = $("#id-date-picker-1").val();
		if(tracking != ""){
			$.ajax({
				type:"POST",
				url:"../sistemadarko/Producto",
				data:{accion:"registrarcompra",tracking:tracking,fecha:fecha},
				success: function(resp){
					var dataJson = eval(resp);
					if(dataJson["success"]=="ok"){
						alert("Correcto!");
						generarcompra();
					}else if(dataJson["success"]=="error"){
						alert("Debe agregar productos!");
					}
				}
			});
		}else{
			alert("Ingrese serie de tracking");
		}
	}
}










