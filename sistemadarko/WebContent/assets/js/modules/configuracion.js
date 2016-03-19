/**
 * Gestion de categorias
 */

function guardarcategoria(){
	var form = $("#form").serialize();
	$.ajax({
        type: "POST",
        url: "../sistemadarko/Categoria",
        data: form,
        success: function(a){
        	var dataJson = eval(a);
        	if(dataJson["control"]=="nuevo"){
	        	var row = "<tr id='tr"+dataJson["id"]+"'><td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
	        			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["flete"]+"</td>" +
	        		    "<td class='td-center'><a href='javascript:cargar_categoria("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["flete"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
	        		    "<td class='td-center'><a href='javascript:eliminar_categoria("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>"
	            $("#tbl_categoria").append(row);
        	}else if(dataJson["control"]=="modificar"){
        		var row = "<td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
    			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["flete"]+"</td>" +
    		    "<td class='td-center'><a href='javascript:cargar_categoria("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["flete"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
    		    "<td class='td-center'><a href='javascript:eliminar_categoria("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td>"
    		    $("#tr"+dataJson["id"]).html(row);
        		$("input[name='control']").val("nuevo");
        	}
        	limpiar();
        }
    });
}

function cargar_categoria(id,nombre,obs,flete){
	$("input[name='control']").val("modificar");
	$("input[name='idcategoria']").val(id);
	$("input[name='txtcat_desc']").val(nombre);
	$("input[name='txtcat_obs']").val(obs);
	$("input[name='txtcat_valorflete']").val(flete);
}

function eliminar_categoria(id){
	var r = confirm("¿Eliminar categoria?");
	if(r){
		$.ajax({
	        type: "POST",
	        url: "../sistemadarko/Categoria",
	        data: {control:"eliminar",idcategoria:id},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#tr"+id).remove();
	        	limpiar();
	        }
	    });
	}
}


function limpiar(){
	$("input[type='text']").each(function(){
		$(this).val("");
	});
	$("input[name='control']").val("nuevo");
	$("input[name='idcategoria']").val("0");
}


/**
 * Gestion de marcas
 */

function guardarmarca(){
	var datos = {
		control:$("[name$='control']").val(),
		idmarca:$("[name$='idmarca']").val(),
		txtmarca_desc:$("[name$='txtmarca_desc']").val(),
		txtmarca_obs:$("[name$='txtmarca_obs']").val(),
	}
	$.ajax({
        type: "POST",
        url: "../sistemadarko/Marca",
        data: datos,
        success: function(a){
        	var dataJson = eval(a);
        	if(dataJson["control"]=="nuevo"){
	        	var row = "<tr id='tr"+dataJson["id"]+"'><td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
	        			"<td>"+dataJson["observacion"]+"</td>" +
	        		    "<td class='td-center'><a href='javascript:cargar_marca("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
	        		    "<td class='td-center'><a href='javascript:eliminar_marca("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>"
	            $("#tbl_marca").append(row);
        	}else if(dataJson["control"]=="modificar"){
        		var row = "<td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
    			"<td>"+dataJson["observacion"]+"</td>" +
    		    "<td class='td-center'><a href='javascript:cargar_marca("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
    		    "<td class='td-center'><a href='javascript:eliminar_marca("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td>"
    		    $("#tr"+dataJson["id"]).html(row);
        	}
        	limpiar_marca();
        }
    });
}

function cargar_marca(id,nombre,obs,categoria){
	$("[name$='control']").val("modificar");
	$("[name$='idmarca']").val(id);
	$("[name$='txtmarca_desc']").val(nombre);
	$("[name$='txtmarca_obs']").val(obs);
}

function eliminar_marca(id){
	var r = confirm("¿Eliminar marca?");
	if(r){
		$.ajax({
	        type: "POST",
	        url: "../sistemadarko/Marca",
	        data: {control:"eliminar",idmarca:id},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#tr"+id).remove();
	        	limpiar_marca();
	        }
	    });
	}
}


function limpiar_marca(){
	$("input[type='text']").each(function(){
		$(this).val("");
	});
	$("[name$='control']").val("nuevo");
	$("[name$='idmarca']").val("0");
}


/**
 * Gestion de modelos
 */

function guardarmodelo(){
	var datos = {
		control:$("[name$='control']").val(),
		idmodelo:$("[name$='idmodelo']").val(),
		txtmodelo_desc:$("[name$='txtmodelo_desc']").val(),
		txtmodelo_obs:$("[name$='txtmodelo_obs']").val(),
		cbomarca:$("[name$='cbomarca']").val(),
		marca:$("[name$='cbomarca'] option:selected").html(),
		cbocategoria:$("[name$='cbocategoria']").val(),
		categoria:$("[name$='cbocategoria'] option:selected").html()
	}
	$.ajax({
        type: "POST",
        url: "../sistemadarko/Modelo",
        data: datos,
        success: function(a){
        	var dataJson = eval(a);
        	if(dataJson["control"]=="nuevo"){
	        	var row = "<tr id='tr"+dataJson["id"]+"'><td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
	        		    "<td class='td-center'><a href='javascript:cargar_modelo("+dataJson["id"]+",&quot;"+dataJson["modelo"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["marca"]+"&quot;,&quot;"+dataJson["categoria"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
	        		    "<td class='td-center'><a href='javascript:eliminar_modelo("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>"
	            $("#tbl_modelo").append(row);
        	}else if(dataJson["control"]=="modificar"){
        		var row = "<td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
    		    "<td class='td-center'><a href='javascript:cargar_modelo("+dataJson["id"]+",&quot;"+dataJson["modelo"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["marca"]+"&quot;,&quot;"+dataJson["categoria"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
    		    "<td class='td-center'><a href='javascript:eliminar_modelo("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td>"
    		    $("#tr"+dataJson["id"]).html(row);
        	}
        	limpiar_marca();
        }
    });
}

function cargar_modelo(id,nombre,obs,marca,categoria){
	$("[name$='control']").val("modificar");
	$("[name$='idmodelo']").val(id);
	$("[name$='txtmodelo_desc']").val(nombre);
	$("[name$='txtmodelo_obs']").val(obs);
	$("[name$='cbomarca'] option[value="+marca+"]").attr("selected",true);
	$("[name$='cbocategoria'] option[value="+categoria+"]").attr("selected",true);
}

function eliminar_modelo(id){
	var r = confirm("¿Eliminar modelo?");
	if(r){
		$.ajax({
	        type: "POST",
	        url: "../sistemadarko/Modelo",
	        data: {control:"eliminar",idmodelo:id},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#tr"+id).remove();
	        	limpiar_modelo();
	        }
	    });
	}
}


function limpiar_modelo(){
	$("input[type='text']").each(function(){
		$(this).val("");
	});
	$("[name$='control']").val("nuevo");
	$("[name$='idmodelo']").val("0");
	$("[name$='cbomarca'] option[value=1]").attr("selected",true);
}


/**
 * Gestion de colores
 */

function guardarcolor(){
	var datos = {
		control:$("[name$='control']").val(),
		idcolor:$("[name$='idcolor']").val(),
		txtcolor_desc:$("[name$='txtcolor_desc']").val(),
		txtcolor_obs:$("[name$='txtcolor_obs']").val(),
		cbomarca:$("[name$='cbomarca']").val(),
		marca:$("[name$='cbomarca'] option:selected").html()
	}
	$.ajax({
        type: "POST",
        url: "../sistemadarko/Color",
        data: datos,
        success: function(a){
        	var dataJson = eval(a);
        	if(dataJson["control"]=="nuevo"){
	        	var row = "<tr id='tr"+dataJson["id"]+"'><td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
	        			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["marca"]+"</td>" +
	        		    "<td class='td-center'><a href='javascript:cargar_color("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["idmarca"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
	        		    "<td class='td-center'><a href='javascript:eliminar_color("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>"
	            $("#tbl_color").append(row);
        	}else if(dataJson["control"]=="modificar"){
        		var row = "<td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
    			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["marca"]+"</td>" +
    		    "<td class='td-center'><a href='javascript:cargar_color("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["idmarca"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
    		    "<td class='td-center'><a href='javascript:eliminar_color("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td>"
    		    $("#tr"+dataJson["id"]).html(row);
        	}
        	limpiar_color();
        }
    });
}

function cargar_color(id,nombre,obs,marca){
	$("[name$='control']").val("modificar");
	$("[name$='idcolor']").val(id);
	$("[name$='txtcolor_desc']").val(nombre);
	$("[name$='txtcolor_obs']").val(obs);
	$("[name$='cbocolor'] option[value="+marca+"]").attr("selected",true);
}

function eliminar_color(id){
	var r = confirm("¿Eliminar modelo?");
	if(r){
		$.ajax({
	        type: "POST",
	        url: "../sistemadarko/Color",
	        data: {control:"eliminar",idcolor:id},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#tr"+id).remove();
	        	limpiar_color();
	        }
	    });
	}
}

function limpiar_color(){
	$("input[type='text']").each(function(){
		$(this).val("");
	});
	$("[name$='control']").val("nuevo");
	$("[name$='idcolor']").val("0");
	$("[name$='cbomarca'] option[value=1]").attr("selected",true);
}

/**
 * Gestion de tipos de pagos
 */

function guardarpago(){
	var datos = {
		control:$("[name$='control']").val(),
		idpago:$("[name$='idpago']").val(),
		txtpago_desc:$("[name$='txtpago_desc']").val(),
		txtpago_obs:$("[name$='txtpago_obs']").val(),
		txtpago_defecto:$("[name$='txtpago_defecto']").val()
	}
	$.ajax({
        type: "POST",
        url: "../sistemadarko/TipoPago",
        data: datos,
        success: function(a){
        	var dataJson = eval(a);
        	if(dataJson["control"]=="nuevo"){
	        	var row = "<tr id='tr"+dataJson["id"]+"'><td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
	        			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["defecto"]+"</td>" +
	        		    "<td class='td-center'><a href='javascript:cargar_pago("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["defecto"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
	        		    "<td class='td-center'><a href='javascript:eliminar_pago("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>"
	            $("#tbl_pago").append(row);
        	}else if(dataJson["control"]=="modificar"){
        		var row = "<td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
    			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["defecto"]+"</td>" +
    		    "<td class='td-center'><a href='javascript:cargar_pago("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["defecto"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
    		    "<td class='td-center'><a href='javascript:eliminar_pago("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td>"
    		    $("#tr"+dataJson["id"]).html(row);
        	}
        	limpiar_pago();
        }
    });
}

function cargar_pago(id,nombre,obs,defecto){
	$("[name$='control']").val("modificar");
	$("[name$='idpago']").val(id);
	$("[name$='txtpago_desc']").val(nombre);
	$("[name$='txtpago_obs']").val(obs);
	$("[name$='txtpago_defecto']").val(defecto);
}

function eliminar_pago(id){
	var r = confirm("¿Eliminar tipo de pago?");
	if(r){
		$.ajax({
	        type: "POST",
	        url: "../sistemadarko/TipoPago",
	        data: {control:"eliminar",idpago:id},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#tr"+id).remove();
	        	limpiar_pago();
	        }
	    });
	}
}

function limpiar_pago(){
	$("input[type='text']").each(function(){
		$(this).val("");
	});
	$("[name$='control']").val("nuevo");
	$("[name$='idpago']").val("0");
}


/**
 * Gestion de Comprobante
 */

function guardarcomprobante(){
	var datos = {
		control:$("[name$='control']").val(),
		idcomprobante:$("[name$='idcomprobante']").val(),
		txtcomprobante_desc:$("[name$='txtcomprobante_desc']").val(),
		txtcomprobante_obs:$("[name$='txtcomprobante_obs']").val(),
		txtcomprobante_defecto:$("[name$='txtcomprobante_defecto']").val()
	}
	$.ajax({
        type: "POST",
        url: "../sistemadarko/Comprobante",
        data: datos,
        success: function(a){
        	var dataJson = eval(a);
        	if(dataJson["control"]=="nuevo"){
	        	var row = "<tr id='tr"+dataJson["id"]+"'><td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
	        			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["defecto"]+"</td>" +
	        		    "<td class='td-center'><a href='javascript:cargar_comprobante("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["defecto"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
	        		    "<td class='td-center'><a href='javascript:eliminar_comprobante("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>"
	            $("#tbl_comprobante").append(row);
        	}else if(dataJson["control"]=="modificar"){
        		var row = "<td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
    			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["defecto"]+"</td>" +
    		    "<td class='td-center'><a href='javascript:cargar_comprobante("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["defecto"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
    		    "<td class='td-center'><a href='javascript:eliminar_comprobante("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td>"
    		    $("#tr"+dataJson["id"]).html(row);
        	}
        	limpiar_comprobante();
        }
    });
}

function cargar_comprobante(id,nombre,obs,defecto){
	$("[name$='control']").val("modificar");
	$("[name$='idcomprobante']").val(id);
	$("[name$='txtcomprobante_desc']").val(nombre);
	$("[name$='txtcomprobante_obs']").val(obs);
	$("[name$='txtcomprobante_defecto']").val(defecto);
}

function eliminar_comprobante(id){
	var r = confirm("¿Eliminar comprobante?");
	if(r){
		$.ajax({
	        type: "POST",
	        url: "../sistemadarko/Comprobante",
	        data: {control:"eliminar",idcomprobante:id},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#tr"+id).remove();
	        	limpiar_comprobante();
	        }
	    });
	}
}

function limpiar_comprobante(){
	$("input[type='text']").each(function(){
		$(this).val("");
	});
	$("[name$='control']").val("nuevo");
	$("[name$='idcomprobante']").val("0");
}

/**
 * Gestion de Estado Venta
 */

function guardarestado(){
	var datos = {
		control:$("[name$='control']").val(),
		idestado:$("[name$='idestado']").val(),
		txtestado_desc:$("[name$='txtestado_desc']").val(),
		txtestado_obs:$("[name$='txtestado_obs']").val(),
		txtestado_defecto:$("[name$='txtestado_defecto']").val()
	}
	$.ajax({
        type: "POST",
        url: "../sistemadarko/Estado",
        data: datos,
        success: function(a){
        	var dataJson = eval(a);
        	if(dataJson["control"]=="nuevo"){
	        	var row = "<tr id='tr"+dataJson["id"]+"'><td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
	        			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["defecto"]+"</td>" +
	        		    "<td class='td-center'><a href='javascript:cargar_estado("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["defecto"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
	        		    "<td class='td-center'><a href='javascript:eliminar_estado("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>"
	            $("#tbl_estado").append(row);
        	}else if(dataJson["control"]=="modificar"){
        		var row = "<td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
    			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["defecto"]+"</td>" +
    		    "<td class='td-center'><a href='javascript:cargar_estado("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["defecto"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
    		    "<td class='td-center'><a href='javascript:eliminar_estado("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td>"
    		    $("#tr"+dataJson["id"]).html(row);
        	}
        	limpiar_estado();
        }
    });
}

function cargar_estado(id,nombre,obs,defecto){
	$("[name$='control']").val("modificar");
	$("[name$='idestado']").val(id);
	$("[name$='txtestado_desc']").val(nombre);
	$("[name$='txtestado_obs']").val(obs);
	$("[name$='txtestado_defecto']").val(defecto);
}

function eliminar_estado(id){
	var r = confirm("¿Eliminar Estado?");
	if(r){
		$.ajax({
	        type: "POST",
	        url: "../sistemadarko/Estado",
	        data: {control:"eliminar",idestado:id},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#tr"+id).remove();
	        	limpiar_estado();
	        }
	    });
	}
}

function limpiar_estado(){
	$("input[type='text']").each(function(){
		$(this).val("");
	});
	$("[name$='control']").val("nuevo");
	$("[name$='idestado']").val("0");
}

/**
 * Gestion de Tallas
 */

function guardartalla(){
	var datos = {
		control:$("[name$='control']").val(),
		idtalla:$("[name$='idtalla']").val(),
		txttalla_desc:$("[name$='txttalla_desc']").val(),
		txttalla_obs:$("[name$='txttalla_obs']").val(),
		txttalla_defecto:$("[name$='txttalla_defecto']").val(),
		idcategoria:$("[name$='cbocategoria']").val(),
		categoria:$("[name$='cbocategoria'] option:selected").html()
	}
	$.ajax({
        type: "POST",
        url: "../sistemadarko/Talla",
        data: datos,
        success: function(a){
        	var dataJson = eval(a);
        	if(dataJson["control"]=="nuevo"){
	        	var row = "<tr id='tr"+dataJson["id"]+"'><td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
	        			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["defecto"]+"</td><td>"+dataJson["categoria"]+"</td>" +
	        		    "<td class='td-center'><a href='javascript:cargar_talla("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["defecto"]+"&quot;,&quot;"+dataJson["idcategoria"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
	        		    "<td class='td-center'><a href='javascript:eliminar_talla("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>"
	            $("#tbl_talla").append(row);
        	}else if(dataJson["control"]=="modificar"){
        		var row = "<td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
    			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["defecto"]+"</td><td>"+dataJson["categoria"]+"</td>" +
    		    "<td class='td-center'><a href='javascript:cargar_talla("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["defecto"]+"&quot;,&quot;"+dataJson["idcategoria"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
    		    "<td class='td-center'><a href='javascript:eliminar_talla("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td>"
    		    $("#tr"+dataJson["id"]).html(row);
        	}
        	limpiar_talla();
        }
    });
}

function cargar_talla(id,nombre,obs,defecto,categoria){
	$("[name$='control']").val("modificar");
	$("[name$='idtalla']").val(id);
	$("[name$='txttalla_desc']").val(nombre);
	$("[name$='txttalla_obs']").val(obs);
	$("[name$='txttalla_defecto']").val(defecto);
	$("[name$='cbocategoria'] option[value="+categoria+"]").attr("selected",true);
}

function eliminar_talla(id){
	var r = confirm("¿Eliminar Talla?");
	if(r){
		$.ajax({
	        type: "POST",
	        url: "../sistemadarko/Talla",
	        data: {control:"eliminar",idtalla:id},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#tr"+id).remove();
	        	limpiar_talla();
	        }
	    });
	}
}

function limpiar_talla(){
	$("input[type='text']").each(function(){
		$(this).val("");
	});
	$("[name$='control']").val("nuevo");
	$("[name$='idtalla']").val("0");
}

/**
 * Gestion de Ubicacion
 */

function guardarubicacion(){
	var datos = {
		control:$("[name$='control']").val(),
		idubicacion:$("[name$='idubicacion']").val(),
		txtubicacion_desc:$("[name$='txtubicacion_desc']").val(),
		txtubicacion_obs:$("[name$='txtubicacion_obs']").val(),
		txtubicacion_defecto:$("[name$='txtubicacion_defecto']").val()
	}
	$.ajax({
        type: "POST",
        url: "../sistemadarko/Ubicacion",
        data: datos,
        success: function(a){
        	var dataJson = eval(a);
        	if(dataJson["control"]=="nuevo"){
	        	var row = "<tr id='tr"+dataJson["id"]+"'><td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
	        			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["defecto"]+"</td>" +
	        		    "<td class='td-center'><a href='javascript:cargar_ubicacion("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["defecto"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
	        		    "<td class='td-center'><a href='javascript:eliminar_ubicacion("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>"
	            $("#tbl_ubicacion").append(row);
        	}else if(dataJson["control"]=="modificar"){
        		var row = "<td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
    			"<td>"+dataJson["observacion"]+"</td><td>"+dataJson["defecto"]+"</td>" +
    		    "<td class='td-center'><a href='javascript:cargar_ubicacion("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["observacion"]+"&quot;,&quot;"+dataJson["defecto"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
    		    "<td class='td-center'><a href='javascript:eliminar_ubicacion("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td>"
    		    $("#tr"+dataJson["id"]).html(row);
        	}
        	limpiar_ubicacion();
        }
    });
}

function cargar_ubicacion(id,nombre,obs,defecto){
	$("[name$='control']").val("modificar");
	$("[name$='idubicacion']").val(id);
	$("[name$='txtubicacion_desc']").val(nombre);
	$("[name$='txtubicacion_obs']").val(obs);
	$("[name$='txtubicacion_defecto']").val(defecto);
}

function eliminar_ubicacion(id){
	var r = confirm("¿Eliminar ubicación?");
	if(r){
		$.ajax({
	        type: "POST",
	        url: "../sistemadarko/Ubicacion",
	        data: {control:"eliminar",idubicacion:id},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#tr"+id).remove();
	        	limpiar_ubicacion();
	        }
	    });
	}
}

function limpiar_ubicacion(){
	$("input[type='text']").each(function(){
		$(this).val("");
	});
	$("[name$='control']").val("nuevo");
	$("[name$='idubicacion']").val("0");
}


