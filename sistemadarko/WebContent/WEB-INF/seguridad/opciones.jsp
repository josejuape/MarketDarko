<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Opciones de usuario</title>
</head>
<body>
	<div class="block-area">
    <h3>Opciones de usuario</h3>
    <form name="form" id="form" action="">
    <div class="col-md-3 col-sm-3 col-xs-6">
    	<input type="hidden" name="control" value="nuevo" />
	    <input type="hidden" name="idopcion" value="0" />
        <select name="cbousuario" class="form-control m-b-10" >
            <c:forEach var="usuario" items="${listausuarios}">
        		<option value="${ usuario.idusuario }">${ usuario.nombre } - ${ usuario.rol.desc_rol }</option>
        	</c:forEach>
        </select>
    </div> 
    <div class="col-md-3 col-sm-3 col-xs-6">
        <select name="cbomenu" class="form-control m-b-10" >
            <c:forEach var="menu" items="${listamenus}">
        		<option value="${ menu.idmenu }">${ menu.desc_menu }</option>
        	</c:forEach>
        </select>
    </div> 
     <div class="col-md-3 col-sm-3 col-xs-6">
	    	<div class="box-btn-add" style="margin:0 0 10px 0;">
	            <a href="javascript:limpiar_opcion();" style="margin:0;">Cancelar</a>
	        </div>
	</div>    
    <div class="col-md-3 col-sm-3 col-xs-6">
        <div class="box-btn-confirm" style="margin:0;">
            <a href="javascript:guardaropcion();" style="margin:0;">Guardar</a>
        </div>
    </div>
    </form>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="table-responsive overflow" tabindex="5001" style="overflow: hidden; outline: none;">
                <table class="table tile" id="tbl_opcion" >
                            <thead>
                                <tr>
                                    <th style="width:80px;text-align:center;">Número</th>
                                    <th>Usuario - Rol</th>
                                    <th>Opción Menu</th>
                                    <th colspan="2" style="width:80px;text-align:center;">Opción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="opcion" items="${listaopciones}">
                                	<tr id="tr${ opcion.idopcion }">
	                                    <td class="td-center">${ opcion.idopcion }</td>
	                                    <td>${ opcion.usuario.nombre } - ${ opcion.usuario.rol.desc_rol }</td>
	                                    <td>${ opcion.menu.desc_menu }</td>
	                                    <td class="td-center">
	                                        <a href="javascript:cargar_opcion(${ opcion.idopcion },'${ opcion.usuario.idusuario }','${ opcion.menu.idmenu }');"><i class="menu-icon fa fa-sign-in"></i></a>
	                                    </td>
	                                    <td class="td-center">
	                                        <a href="javascript:eliminar_opcion(${ opcion.idopcion });"><i class="menu-icon fa fa-times-circle"></i></a>
	                                    </td>
                                	</tr>
                                </c:forEach> 
                            </tbody>
                </table>
        </div>
    </div>
</div>
</body>
</html>