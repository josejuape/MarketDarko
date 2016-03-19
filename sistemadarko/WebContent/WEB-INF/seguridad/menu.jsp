<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="block-area">
    <h3>Menu del sistema</h3>
    <form name="form" id="form" action="">
    <div class="col-md-3 col-sm-3 col-xs-6">
    	<input type="hidden" name="control" value="nuevo" />
	    <input type="hidden" name="idmenu" value="0" />
        <input type="text" name="txtmenu_desc" class="form-control m-b-10" placeholder="Descripción" />
    </div>
    <div class="col-md-3 col-sm-3 col-xs-6">
        <input type="text" name="txtmenu_url" class="form-control m-b-10" placeholder="URL menu" />
    </div>
    <div class="col-md-3 col-sm-3 col-xs-6">
        <input type="text" name="txtmenu_icon" class="form-control m-b-10" placeholder="Icono menu" />
    </div>
    <div class="col-md-3 col-sm-3 col-xs-6">
        <input type="text" name="txtmenu_nodo" class="form-control m-b-10" placeholder="ID Menu" />
    </div>
    <div class="col-md-3 col-sm-3 col-xs-6">
        <input type="text" name="txtmenu_nodopadre" class="form-control m-b-10" placeholder="ID Menu Padre" />
    </div>
    <div class="col-md-3 col-sm-3 col-xs-6">
	    	<div class="box-btn-add" style="margin:0 0 10px 0;">
	            <a href="javascript:limpiar_menu();" style="margin:0;">Cancelar</a>
	        </div>
	    </div> 
	    <div class="col-md-3 col-sm-3 col-xs-6">
	        <div class="box-btn-confirm" style="margin:0 0 10px 0;">
	            <a href="javascript:guardarmenu();" style="margin:0;">Guardar</a>
	        </div>	        
	    </div>	    
	<div class="col-md-3 col-sm-3 col-xs-6"></div>
    </form>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="table-responsive overflow" tabindex="5001" style="overflow: hidden; outline: none;">
                <table class="table tile" id="tbl_menu">
                            <thead>
                                <tr>
                                    <th style="width:100px;text-align:center;">Número</th>
                                    <th>Descripción</th>
                                    <th>URL Menu</th>
                                    <th>URL Icono</th>
                                    <th>ID Menu</th>
                                    <th>ID Menu Padre</th>
                                    <th colspan="2" style="width:80px;text-align:center;">Opción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="menu" items="${listamenus}">
                                	<tr id="tr${ menu.idmenu }">
	                                    <td class="td-center">${ menu.idmenu }</td>
	                                    <td>${ menu.desc_menu }</td>
	                                    <td>${ menu.url_menu }</td>
	                                    <td>${ menu.icon_menu }</td>
	                                    <td>${ menu.nodo }</td>
	                                    <td>${ menu.nodo_padre }</td>
	                                    <td class="td-center">
	                                        <a href="javascript:cargar_menu(${ menu.idmenu },'${ menu.desc_menu }','${menu.url_menu }','${ menu.icon_menu }','${ menu.nodo }','${ menu.nodo_padre }');"><i class="menu-icon fa fa-sign-in"></i></a>
	                                    </td>
	                                    <td class="td-center">
	                                        <a href="javascript:eliminar_menu(${ menu.idmenu });"><i class="menu-icon fa fa-times-circle"></i></a>
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