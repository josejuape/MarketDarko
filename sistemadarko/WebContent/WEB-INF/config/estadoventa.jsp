<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estado de ventas</title>
</head>
<body>
	<div class="block-area">
    <h3>Estados de ventas</h3>
    <form name="form" id="form" action="">
	    <div class="col-md-4 col-sm-4 col-xs-6">
	    	<input type="hidden" name="control" value="nuevo" />
    		<input type="hidden" name="idestado" value="0" />
	        <input type="text" name="txtestado_desc" class="form-control m-b-10" placeholder="Nombre" />
	    </div>
	    <div class="col-md-4 col-sm-4 col-xs-6">
	        <input type="text" name="txtestado_obs" class="form-control m-b-10" placeholder="Observaci�n" />
	    </div> 
	    <div class="col-md-4 col-sm-4 col-xs-6">
	        <input type="text" name="txtestado_defecto" class="form-control m-b-10" placeholder="Elegir por defecto" />
	    </div>
	    <div class="col-md-3 col-sm-3 col-xs-6"></div> 
		<div class="col-md-3 col-sm-3 col-xs-6">
		    <div class="box-btn-add" style="margin:0 0 10px 0;">
		        <a href="javascript:limpiar_estado();" style="margin:0;">Cancelar</a>
		    </div>
		</div> 
		<div class="col-md-3 col-sm-3 col-xs-6">
		    <div class="box-btn-confirm" style="margin:0 0 10px 0;">
		        <a href="javascript:guardarestado();" style="margin:0;">Guardar</a>
		    </div>	        
		</div>	    
		<div class="col-md-3 col-sm-3 col-xs-6"></div> 
    </form>  
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="table-responsive overflow" tabindex="5001" style="overflow: hidden; outline: none;">
                <table id="tbl_estado" class="table tile">
                            <thead>
                                <tr>
                                    <th style="width:80px;text-align:center;">N�mero</th>
                                    <th>Nombre</th>
                                    <th>Observaci�n</th>
                                    <th>Por defecto</th>
                                    <th colspan="2" style="width:80px;text-align:center;">Opci�n</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="estado" items="${listaestados}">
                                	<tr id="tr${ estado.idestadoventa }">
	                                    <td class="td-center">${ estado.idestadoventa }</td>
	                                    <td>${ estado.nombre }</td>
	                                    <td>${ estado.observacion }</td>
	                                    <td>${ estado.defecto }</td>
	                                    <td class="td-center">
	                                        <a href="javascript:cargar_estado(${ estado.idestadoventa },'${ estado.nombre }','${ estado.observacion }','${ estado.defecto }');"><i class="menu-icon fa fa-sign-in"></i></a>
	                                    </td>
	                                    <td class="td-center">
	                                        <a href="javascript:eliminar_estado(${ estado.idestadoventa });"><i class="menu-icon fa fa-times-circle"></i></a>
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