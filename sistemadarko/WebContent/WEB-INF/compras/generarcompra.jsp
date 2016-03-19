<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	#selectproductos li{
		color:black;cursor:pointer;list-style-type:none;padding:8px;
	}
	#selectproductos li:hover{
		background:#666;
		color:white;
	}
	.itemdetalle{
		background: rgba(0,0,0,.5);
    	padding: 5px 10px;
    	cursor: pointer;
    	margin-right: 5px;
    	font-size: 12px;
	}
	.itemdetalle:hover{
		background: rgba(0,0,0,.6);
	}
	.selectitem{
		background: white !important;
		color: black !important;
	}
</style>
</head>
<body>
	<div class="block-area">
    <h3>Crear nueva mercaderia</h3>
    <div class="col-md-6 col-sm-6 col-xs-6">
        <input type="text" name="txttracking" id="txttracking" class="form-control m-b-10" placeholder="N° Tracking" />
    </div>
    <div class="col-md-6 col-sm-6 col-xs-6">
        <div class="input-group">
            <input class="form-control date-picker" id="id-date-picker-1" type="text" data-date-format="dd-mm-yyyy" placeholder="Fecha de recepción">
            <span class="input-group-addon">
                <i class="fa fa-calendar"></i>
            </span>
        </div>
    </div>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="title-underline">Agregar producto</div>
    </div> 
    <div class="col-md-10 col-sm-10 col-xs-10" style="position:relative;">
    		<input type="text" name="txtbuscador" id="txtbuscador" class="form-control m-b-10" placeholder="Buscar producto" onkeyup="onsearchproduct()" />
    		<input type="hidden" name="hdidproducto" id="hdidproducto" value="0" />
    		<ul id="selectproductos" style="background:white;padding:0;position:absolute;top:35px;width:98%;z-index: 9999;">
    			<!--  <li style="color:black;list-style-type:none;padding:8px;">producto 1</li> -->
    		</ul>
    </div>
    <div class="col-md-2 col-sm-2 col-xs-2">
    		<div class="box-btn-add">
                <a href="javascript:cargarProducto();">Cargar producto</a>
            </div>
    </div>
     <div class="col-md-8 col-sm-8 col-xs-8">
           <input type="text" name="txtproducto" id="txtproducto" class="form-control m-b-10" placeholder="" disabled="disabled" />
     </div>
     <div class="col-md-4 col-sm-4 col-xs-4">
           <input type="text" name="txtcantidad" id="txtcantidad" class="form-control m-b-10" placeholder="Cantidad" />
     </div>
     <div class="col-md-8 col-sm-8 col-xs-8">
          	<div class="col-md-6 col-sm-6 col-xs-6" style="padding:0px;">
          		<h5>Tallas</h5>
          		<div id="listtallas">
          		
          		</div>
     		</div>
     		<div class="col-md-6 col-sm-6 col-xs-6" style="padding:0px;">
          		<h5>Colores</h5>
          		<div id="listcolores">
          		
          		</div>
     		</div>
     </div>
     <div class="col-md-4 col-sm-4 col-xs-4">
     		<input type="text" name="txtcosto" id="txtcosto" class="form-control m-b-10" placeholder="Costo unidad (/S)" />
            <div class="box-btn-add">
                <a href="javascript:addProductoLista();">Agregar producto</a>
            </div>          
     </div>     
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="title-underline">Lista productos</div>
    </div>
    
<!-- Table of the products add in mercaderia -->
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="table-responsive overflow" tabindex="5001" style="overflow: hidden; outline: none;">
                <table class="table tile" id="tbl_listproductos">
                            <thead>
                                <tr>
                                    <th style="width:80px;text-align:center;">Cantidad</th>
                                    <th>Descripción de producto</th>
                                    <th>Talla(s)</th>
                                    <th>Color(es)</th>
                                    <th style="width:150px;text-align:center;">Costo</th>
                                    <th style="width:80px;text-align:center;">Opción</th>
                                </tr>
                            </thead>
                </table>
        </div>
    </div>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="col-md-2 col-sm-2 col-xs-3"></div>
        <div class="col-md-4 col-sm-4 col-xs-6">
            <div class="box-btn-confirm">
                <a href="javascript:generarcompra();">Cancelar compra</a>
            </div>
        </div>
        <div class="col-md-4 col-sm-4 col-xs-6">
            <div class="box-btn-confirm">
                <a href="javascript:guardarcompra();">Guardar compra</a>
            </div>
        </div>
        <div class="col-md-2 col-sm-2 col-xs-3"></div>
    </div>
</div>
<!--Scripts -->
<script src="assets/js/datetime/bootstrap-datepicker.js"></script>
<script>
    $('.date-picker').datepicker();
</script>
</body>
</html>