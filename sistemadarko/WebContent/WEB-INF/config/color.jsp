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
    <h3>Colores</h3>
    <form name="form" id="form" action="">
    <div class="col-md-4 col-sm-4 col-xs-6">
    	<input type="hidden" name="control" value="nuevo" />
    	<input type="hidden" name="idcolor" value="0" />
        <input type="text" name="txtcolor_desc" class="form-control m-b-10" placeholder="Nombre" />
    </div>
    <div class="col-md-4 col-sm-4 col-xs-6">
        <input type="text" name="txtcolor_obs" class="form-control m-b-10" placeholder="Observación" />
    </div>
    <div class="col-md-4 col-sm-4 col-xs-6">
        <select name="cbomarca" class="form-control m-b-10" >
            <c:forEach var="marca" items="${listamarcas}">
        		<option value="${ marca.idmarca }">${ marca.nombre }</option>
        	</c:forEach> 
        </select>
    </div>   
    <div class="col-md-3 col-sm-3 col-xs-6"></div> 
	<div class="col-md-3 col-sm-3 col-xs-6">
	    <div class="box-btn-add" style="margin:0 0 10px 0;">
	        <a href="javascript:limpiar_color();" style="margin:0;">Cancelar</a>
	    </div>
	</div> 
	<div class="col-md-3 col-sm-3 col-xs-6">
	    <div class="box-btn-confirm" style="margin:0 0 10px 0;">
	        <a href="javascript:guardarcolor();" style="margin:0;">Guardar</a>
	    </div>	        
	</div>	    
	<div class="col-md-3 col-sm-3 col-xs-6"></div>
	</form>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="table-responsive overflow" tabindex="5001" style="overflow: hidden; outline: none;">
                <table id="tbl_color" class="table tile">
                            <thead>
                                <tr>
                                    <th style="width:80px;text-align:center;">Número</th>
                                    <th>Nombre</th>
                                    <th>Observación</th>
                                    <th>Marca</th>
                                    <th colspan="2" style="width:80px;text-align:center;">Opción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="color" items="${listacolores}">
                                	<tr id="tr${ color.idcolor }">
	                                    <td class="td-center">${ color.idcolor }</td>
	                                    <td>${ color.nombre }</td>
	                                    <td>${ color.observacion }</td>
	                                    <td>${ color.marca.nombre }</td>
	                                    <td class="td-center">
	                                        <a href="javascript:cargar_color(${ color.idcolor },'${ color.nombre }','${ color.observacion }','${ color.marca.idmarca }');"><i class="menu-icon fa fa-sign-in"></i></a>
	                                    </td>
	                                    <td class="td-center">
	                                        <a href="javascript:eliminar_color(${ color.idcolor });"><i class="menu-icon fa fa-times-circle"></i></a>
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