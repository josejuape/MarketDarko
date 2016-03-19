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
    <h3>Modelos</h3>
    <form name="form" id="form" action="">
    <div class="col-md-8 col-sm-8 col-xs-8">
    <div class="col-md-6 col-sm-6 col-xs-6">
        <select name="cbocategoria" class="form-control m-b-10" >
        	<option value="0">- Categoria -</option>
            <c:forEach var="categoria" items="${listacategorias}">            	
        		<option value="${ categoria.idcategoria }">${ categoria.nombre }</option>
        	</c:forEach> 
        </select>
    </div> 
    <div class="col-md-6 col-sm-6 col-xs-6">
        <select name="cbomarca" class="form-control m-b-10" >
        	<option value="0">- Marca -</option>
            <c:forEach var="marca" items="${listamarcas}">            	
        		<option value="${ marca.idmarca }">${ marca.nombre }</option>
        	</c:forEach> 
        </select>
    </div> 
    <div class="col-md-6 col-sm-6 col-xs-6">
    	<input type="hidden" name="control" value="nuevo" />
	    <input type="hidden" name="idmodelo" value="0" />
        <input type="text" name="txtmodelo_desc" class="form-control m-b-10" placeholder="Nombre de Modelo" />
    </div>
    <div class="col-md-6 col-sm-6 col-xs-6">
        <input type="text" name="txtmodelo_obs" class="form-control m-b-10" placeholder="Observación" />
    </div> 
	    <div class="col-md-6 col-sm-6 col-xs-6">
	    	<div class="box-btn-add" style="margin:0 0 10px 0;">
	            <a href="javascript:limpiar_modelo();" style="margin:0;">Cancelar</a>
	        </div>
	    </div> 
	    <div class="col-md-6 col-sm-6 col-xs-6">
	        <div class="box-btn-confirm" style="margin:0 0 10px 0;">
	            <a href="javascript:guardarmodelo();" style="margin:0;">Guardar</a>
	        </div>	        
	    </div>	    
	</div>
	<div class="col-md-4 col-sm-4 col-xs-4">
		<div id='ctn_banner' class="ctn-img-banner"> </div>
		<div class="col-md-12 col-sm-12 col-xs-12">
	        <label class='cargar'>Cargar imagen
	            <span>
	                <input type="hidden" name="url_name_banner" id="url_name_banner" value="" />
	                <input type='file' name="url_banner" id='url_banner' value='Cargar Imagen' class="btn btn-success" />
	            </span>
	        </label>
    	</div>
	</div>
	</form>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="table-responsive overflow" tabindex="5001" style="overflow: hidden; outline: none;">
                <table class="table tile" id="tbl_modelo" >
                            <thead>
                                <tr>
                                    <th style="width:80px;text-align:center;">Número</th>
                                    <th>Nombre de Producto</th>
                                    <th colspan="2" style="width:80px;text-align:center;">Opción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="producto" items="${listaproductos}">
                                	<tr id="tr${ producto.modelo.idmodelo }">
	                                    <td class="td-center">${ producto.idproducto }</td>
	                                    <td>${ producto.nombre }</td>
	                                    <td class="td-center">
	                                        <a href="javascript:cargar_modelo(${ producto.modelo.idmodelo },'${ producto.modelo.nombre }','${ producto.modelo.observacion }''${ modelo.marca.idmarca }','${ modelo.categoria.idcategoria }');"><i class="menu-icon fa fa-sign-in"></i></a>
	                                    </td>
	                                    <td class="td-center">
	                                        <a href="javascript:eliminar_modelo(${ producto.modelo.idmodelo });"><i class="menu-icon fa fa-times-circle"></i></a>
	                                    </td>
                                	</tr>
                                </c:forEach>
                            </tbody>
                </table>
        </div>
    </div>
</div>
<script src="assets/js/loadimage.js"></script>
</body>
</html>