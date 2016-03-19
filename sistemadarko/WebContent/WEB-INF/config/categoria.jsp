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
    <h3>Categorías</h3>
    <form name="form" id="form" action="">
	    <div class="col-md-4 col-sm-4 col-xs-6">
	    	<input type="hidden" name="control" value="nuevo" />
	    	<input type="hidden" name="idcategoria" value="0" />	    	
	        <input type="text" name="txtcat_desc" class="form-control m-b-10" placeholder="Nombre" />
	    </div>
	    <div class="col-md-4 col-sm-4 col-xs-6">
	        <input type="text" name="txtcat_obs" class="form-control m-b-10" placeholder="Observación" />
	    </div>
	    <div class="col-md-4 col-sm-4 col-xs-6">
	        <input type="text" name="txtcat_valorflete" class="form-control m-b-10" placeholder="Valor de flete" />
	    </div> 
	    <div class="col-md-3 col-sm-3 col-xs-6"></div> 
	    <div class="col-md-3 col-sm-3 col-xs-6">
	    	<div class="box-btn-add" style="margin:0;">
	            <a href="javascript:limpiar();" style="margin:0;">Cancelar</a>
	        </div>
	    </div> 
	    <div class="col-md-3 col-sm-3 col-xs-6">
	        <div class="box-btn-confirm" style="margin:0;">
	            <a href="javascript:guardarcategoria();" style="margin:0;">Guardar</a>
	        </div>	        
	    </div>	    
	    <div class="col-md-3 col-sm-3 col-xs-6"></div>  
    </form>
    <div class="col-md-12 col-sm-12 col-xs-12" style="margin-top:16px;">
        <div class="table-responsive overflow" tabindex="5001" style="overflow: hidden; outline: none;">
                <table class="table tile" id="tbl_categoria">
                            <thead>
                                <tr>
                                    <th style="width:80px;text-align:center;">Número</th>
                                    <th>Nombre</th>
                                    <th>Observación</th>
                                    <th>Valor flete</th>
                                    <th colspan="2" style="width:80px;text-align:center;">Opción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="categoria" items="${listacategorias}">
                                	<tr id="tr${ categoria.idcategoria }">
	                                    <td class="td-center">${ categoria.idcategoria }</td>
	                                    <td>${ categoria.nombre }</td>
	                                    <td>${ categoria.observacion }</td>
	                                    <td>${ categoria.valor_flete }</td>
	                                    <td class="td-center">
	                                        <a href="javascript:cargar_categoria(${ categoria.idcategoria },'${ categoria.nombre }','${ categoria.observacion }','${ categoria.valor_flete }');"><i class="menu-icon fa fa-sign-in"></i></a>
	                                    </td>
	                                    <td class="td-center">
	                                        <a href="javascript:eliminar_categoria(${ categoria.idcategoria });"><i class="menu-icon fa fa-times-circle"></i></a>
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