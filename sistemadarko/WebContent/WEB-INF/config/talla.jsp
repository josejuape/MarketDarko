<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tallas</title>
</head>
<body>
	<div class="block-area">
    <h3>Tallas</h3>
    <form name="form" id="form" action="">
	    <div class="col-md-3 col-sm-3 col-xs-6">
	    	<input type="hidden" name="control" value="nuevo" />
    		<input type="hidden" name="idtalla" value="0" />
	        <input type="text" name="txttalla_desc" class="form-control m-b-10" placeholder="Nombre" />
	    </div>
	    <div class="col-md-3 col-sm-3 col-xs-6">
	        <input type="text" name="txttalla_obs" class="form-control m-b-10" placeholder="Observación" />
	    </div> 
	    <div class="col-md-3 col-sm-3 col-xs-6">
	        <input type="text" name="txttalla_defecto" class="form-control m-b-10" placeholder="Elegir por defecto" />
	    </div>
	    <div class="col-md-3 col-sm-3 col-xs-6">
	        <select name="cbocategoria" class="form-control m-b-10" >
	        	<c:forEach var="categoria" items="${listacategorias}">
	        		<option value="${ categoria.idcategoria }">${ categoria.nombre }</option>
	        	</c:forEach>            	
        	</select>
	    </div>
	    <div class="col-md-3 col-sm-3 col-xs-6"></div> 
		<div class="col-md-3 col-sm-3 col-xs-6">
		    <div class="box-btn-add" style="margin:0 0 10px 0;">
		        <a href="javascript:limpiar_talla();" style="margin:0;">Cancelar</a>
		    </div>
		</div> 
		<div class="col-md-3 col-sm-3 col-xs-6">
		    <div class="box-btn-confirm" style="margin:0 0 10px 0;">
		        <a href="javascript:guardartalla();" style="margin:0;">Guardar</a>
		    </div>	        
		</div>	    
		<div class="col-md-3 col-sm-3 col-xs-6"></div> 
    </form>  
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="table-responsive overflow" tabindex="5001" style="overflow: hidden; outline: none;">
                <table id="tbl_talla" class="table tile">
                            <thead>
                                <tr>
                                    <th style="width:80px;text-align:center;">Número</th>
                                    <th>Nombre</th>
                                    <th>Observación</th>
                                    <th>Por defecto</th>
                                    <th colspan="2" style="width:80px;text-align:center;">Opción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="talla" items="${listatallas}">
                                	<tr id="tr${ talla.idtalla }">
	                                    <td class="td-center">${ talla.idtalla }</td>
	                                    <td>${ talla.nombre }</td>
	                                    <td>${ talla.observacion }</td>
	                                    <td>${ talla.defecto }</td>
	                                    <td>${ talla.categoria.nombre }</td>
	                                    <td class="td-center">
	                                        <a href="javascript:cargar_talla(${ talla.idtalla },'${ talla.nombre }','${ talla.observacion }','${ talla.defecto }','${ talla.categoria.idcategoria }');"><i class="menu-icon fa fa-sign-in"></i></a>
	                                    </td>
	                                    <td class="td-center">
	                                        <a href="javascript:eliminar_talla(${ talla.idtalla });"><i class="menu-icon fa fa-times-circle"></i></a>
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