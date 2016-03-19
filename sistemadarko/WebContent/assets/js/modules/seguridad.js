/**
 * Gestion de Menu
 */

function guardarmenu(){
	var datos = {
		control:$("[name$='control']").val(),
		idmenu:$("[name$='idmenu']").val(),
		txtmenu_desc:$("[name$='txtmenu_desc']").val(),
		txtmenu_url:$("[name$='txtmenu_url']").val(),
		txtmenu_icon:$("[name$='txtmenu_icon']").val(),
		txtmenu_nodo:$("[name$='txtmenu_nodo']").val(),
		txtmenu_nodopadre:$("[name$='txtmenu_nodopadre']").val()
	}
	$.ajax({
        type: "POST",
        url: "../sistemadarko/Menu",
        data: datos,
        success: function(a){
        	var dataJson = eval(a);
        	if(dataJson["control"]=="nuevo"){
	        	var row = "<tr id='tr"+dataJson["id"]+"'><td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["desc"]+"</td>" +
	        			"<td>"+dataJson["url"]+"</td><td>"+dataJson["icon"]+"</td>" +
	        			"<td>"+dataJson["nodo"]+"</td><td>"+dataJson["nodopadre"]+"</td>" +
	        		    "<td class='td-center'><a href='javascript:cargar_menu("+dataJson["id"]+",&quot;"+dataJson["desc"]+"&quot;,&quot;"+dataJson["url"]+"&quot;,&quot;"+dataJson["icon"]+"&quot;,&quot;"+dataJson["nodo"]+"&quot;,&quot;"+dataJson["nodopadre"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
	        		    "<td class='td-center'><a href='javascript:eliminar_menu("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>"
	            $("#tbl_menu").append(row);
        	}else if(dataJson["control"]=="modificar"){
        		var row = "<td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["desc"]+"</td>" +
        		"<td>"+dataJson["url"]+"</td><td>"+dataJson["icon"]+"</td>" +
    			"<td>"+dataJson["nodo"]+"</td><td>"+dataJson["nodopadre"]+"</td>" +
    			"<td class='td-center'><a href='javascript:cargar_menu("+dataJson["id"]+",&quot;"+dataJson["desc"]+"&quot;,&quot;"+dataJson["url"]+"&quot;,&quot;"+dataJson["icon"]+"&quot;,&quot;"+dataJson["nodo"]+"&quot;,&quot;"+dataJson["nodopadre"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
    		    "<td class='td-center'><a href='javascript:eliminar_menu("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>"
    		    $("#tr"+dataJson["id"]).html(row);
        	}
        	limpiar_menu();
        }
    });
}

function cargar_menu(id,desc,url,icon,nodo,nodopadre){
	$("[name$='control']").val("modificar");
	$("[name$='idmenu']").val(id);
	$("[name$='txtmenu_desc']").val(desc);
	$("[name$='txtmenu_url']").val(url);
	$("[name$='txtmenu_icon']").val(icon);
	$("[name$='txtmenu_nodo']").val(nodo);
	$("[name$='txtmenu_nodopadre']").val(nodopadre);
}

function eliminar_menu(id){
	var r = confirm("¿Eliminar menu?");
	if(r){
		$.ajax({
	        type: "POST",
	        url: "../sistemadarko/Menu",
	        data: {control:"eliminar",idmenu:id},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#tr"+id).remove();
	        	limpiar_menu();
	        }
	    });
	}
}

function limpiar_menu(){
	$("input[type='text']").each(function(){
		$(this).val("");
	});
	$("[name$='control']").val("nuevo");
	$("[name$='idmenu']").val("0");
}


/**
 * Gestion de Opciones
 */

function guardaropcion(){
	var datos = {
		control:$("[name$='control']").val(),
		idopcion:$("[name$='idopcion']").val(),
		txtcbousuario:$("[name$='cbousuario']").val(),
		txtusuario:$("[name$='cbousuario'] option:selected").html(),
		cbomenu:$("[name$='cbomenu']").val(),
		menu:$("[name$='cbomenu'] option:selected").html()
	}
	$.ajax({
        type: "POST",
        url: "../sistemadarko/Opcion",
        data: datos,
        success: function(a){
        	var dataJson = eval(a);
        	if(dataJson["control"]=="nuevo"){
	        	var row = "<tr id='tr"+dataJson["id"]+"'><td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["usuario"]+"</td>" +
	        			"<td>"+dataJson["menu"]+"</td>" +
	        		    "<td class='td-center'><a href='javascript:cargar_opcion("+dataJson["id"]+",&quot;"+dataJson["idusuario"]+"&quot;,&quot;"+dataJson["idmenu"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
	        		    "<td class='td-center'><a href='javascript:eliminar_opcion("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>"
	            $("#tbl_opcion").append(row);
        	}else if(dataJson["control"]=="modificar"){
        		var row = "<td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["usuario"]+"</td>" +
    			"<td>"+dataJson["menu"]+"</td>" +
    		    "<td class='td-center'><a href='javascript:cargar_opcion("+dataJson["id"]+",&quot;"+dataJson["idusuario"]+"&quot;,&quot;"+dataJson["idmenu"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
    		    "<td class='td-center'><a href='javascript:eliminar_opcion("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td>"
    		    $("#tr"+dataJson["id"]).html(row);
        	}
        	limpiar_opcion();
        }
    });
}

function cargar_opcion(id,usuario,menu){
	$("[name$='control']").val("modificar");
	$("[name$='idopcion']").val(id);
	$("[name$='cbousuario'] option[value="+usuario+"]").attr("selected",true);
	$("[name$='cbomenu'] option[value="+menu+"]").attr("selected",true);
	
}

function eliminar_opcion(id){
	var r = confirm("¿Eliminar ubicación?");
	if(r){
		$.ajax({
	        type: "POST",
	        url: "../sistemadarko/Ubicacion",
	        data: {control:"eliminar",idopcion:id},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#tr"+id).remove();
	        	limpiar_opcion();
	        }
	    });
	}
}

function limpiar_opcion(){	
	$("[name$='control']").val("nuevo");
	$("[name$='idopcion']").val("0");
	$("[name$='cbousuario'] option[value=1]").attr("selected",true);
	$("[name$='cbomenu'] option[value=1]").attr("selected",true);
}


/**
 * Gestion de Rol
 */

function guardarrol(){
	var datos = {
		control:$("[name$='control']").val(),
		idrol:$("[name$='idrol']").val(),
		txtrol_desc:$("[name$='txtrol_desc']").val(),
		txtrol_obs:$("[name$='txtrol_obs']").val()
	}
	
	$.ajax({
        type: "POST",
        url: "../sistemadarko/Rol",
        data: datos,
        success: function(a){
        	var dataJson = eval(a);
        	if(dataJson["control"]=="nuevo"){
	        	var row = "<tr id='tr"+dataJson["id"]+"'><td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["desc"]+"</td>" +
	        			"<td>"+dataJson["obs"]+"</td>" +
	        		    "<td class='td-center'><a href='javascript:cargar_rol("+dataJson["id"]+",&quot;"+dataJson["desc"]+"&quot;,&quot;"+dataJson["obs"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
	        		    "<td class='td-center'><a href='javascript:eliminar_rol("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>"
	            $("#tbl_rol").append(row);
        	}else if(dataJson["control"]=="modificar"){
        		var row = "<td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["desc"]+"</td>" +
    			"<td>"+dataJson["obs"]+"</td>" +
    		    "<td class='td-center'><a href='javascript:cargar_rol("+dataJson["id"]+",&quot;"+dataJson["desc"]+"&quot;,&quot;"+dataJson["obs"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
    		    "<td class='td-center'><a href='javascript:eliminar_rol("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td>"
    		    $("#tr"+dataJson["id"]).html(row);
        	}
        	limpiar_rol();
        }
    });
}

function cargar_rol(id,desc,obs){
	$("[name$='control']").val("modificar");
	$("[name$='idrol']").val(id);
	$("[name$='txtrol_desc']").val(desc);
	$("[name$='txtrol_obs']").val(obs);
}

function eliminar_rol(id){
	var r = confirm("¿Eliminar rol?");
	if(r){
		$.ajax({
	        type: "POST",
	        url: "../sistemadarko/Rol",
	        data: {control:"eliminar",idrol:id},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#tr"+id).remove();
	        	limpiar_rol();
	        }
	    });
	}
}

function limpiar_rol(){
	$("input[type='text']").each(function(){
		$(this).val("");
	});
	$("[name$='control']").val("nuevo");
	$("[name$='idrol']").val("0");
}

/**
 * Gestion de Usuarios
 */

function guardaruser(){
	var datos = {
		control:$("[name$='control']").val(),
		idusuario:$("[name$='idusuario']").val(),
		txtuser_nombre:$("[name$='txtuser_nombre']").val(),
		txtuser_dni:$("[name$='txtuser_dni']").val(),
		txtuser_user:$("[name$='txtuser_user']").val(),
		txtuser_password:$("[name$='txtuser_password']").val(),
		txtuser_email:$("[name$='txtuser_email']").val(),
		txtuser_movil:$("[name$='txtuser_movil']").val(),
		cborol:$("[name$='cborol']").val(),
		rol:$("[name$='cborol'] option:selected").html()
	}
	$.ajax({
        type: "POST",
        url: "../sistemadarko/Usuario",
        data: datos,
        success: function(a){
        	var dataJson = eval(a);
        	if(dataJson["control"]=="nuevo"){
	        	var row = "<tr id='tr"+dataJson["id"]+"'><td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
	        			"<td>"+dataJson["user"]+"</td>" +"</td><td>"+dataJson["password"]+"</td>" +"</td><td>"+dataJson["movil"]+"</td>" +
	        		    "<td class='td-center'><a href='javascript:cargar_user("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["dni"]+"&quot;,&quot;"+dataJson["user"]+"&quot;,&quot;"+dataJson["password"]+"&quot;,&quot;"+dataJson["email"]+"&quot;,&quot;"+dataJson["movil"]+"&quot;,&quot;"+dataJson["idrol"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
	        		    "<td class='td-center'><a href='javascript:eliminar_user("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td></tr>";
	            $("#tbl_usuario").append(row);
        	}else if(dataJson["control"]=="modificar"){
        		var row = "<td class='td-center'>"+dataJson["id"]+"</td><td>"+dataJson["nombre"]+"</td>" +
    			"<td>"+dataJson["user"]+"</td>" +"</td><td>"+dataJson["password"]+"</td>" +"</td><td>"+dataJson["movil"]+"</td>" +
    		    "<td class='td-center'><a href='javascript:cargar_user("+dataJson["id"]+",&quot;"+dataJson["nombre"]+"&quot;,&quot;"+dataJson["dni"]+"&quot;,&quot;"+dataJson["user"]+"&quot;,&quot;"+dataJson["password"]+"&quot;,&quot;"+dataJson["email"]+"&quot;,&quot;"+dataJson["movil"]+"&quot;,&quot;"+dataJson["idrol"]+"&quot;)'><i class='menu-icon fa fa-sign-in'></i></a></td>" +
    		    "<td class='td-center'><a href='javascript:eliminar_user("+dataJson["id"]+");'><i class='menu-icon fa fa-times-circle'></i></a></td>";
    		    $("#tr"+dataJson["id"]).html(row);
        	}
        	limpiar_usuario();
        }
    });
}

function cargar_user(id,nombre,dni,user,pass,email,movil,idrol){
	$("[name$='control']").val("modificar"),
	$("[name$='idusuario']").val(id),
	$("[name$='txtuser_nombre']").val(nombre),
	$("[name$='txtuser_dni']").val(dni),
	$("[name$='txtuser_user']").val(user),
	$("[name$='txtuser_password']").val(pass),
	$("[name$='txtuser_email']").val(email),
	$("[name$='txtuser_movil']").val(movil),
	$("[name$='cborol'] option[value="+idrol+"]").attr("selected",true);
}

function eliminar_user(id){
	var r = confirm("¿Eliminar usuario?");
	if(r){
		$.ajax({
	        type: "POST",
	        url: "../sistemadarko/Usuario",
	        data: {control:"eliminar",idusuario:id},
	        success: function(a){
	        	var dataJson = eval(a);
	        	$("#tr"+id).remove();
	        	limpiar_usuario();
	        }
	    });
	}
}

function limpiar_usuario(){
	$("input[type='text']").each(function(){
		$(this).val("");
	});
	$("[name$='control']").val("nuevo");
	$("[name$='idusuario']").val("0");
}







