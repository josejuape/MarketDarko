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
    <h3>Usuarios del sistema</h3>
    <form name="form" id="form" action="">
    <div class="col-md-4 col-sm-4 col-xs-6">
    	<input type="hidden" name="control" value="nuevo" />
	    <input type="hidden" name="idusuario" value="0" />
        <input type="text" name="txtuser_nombre" class="form-control m-b-10" placeholder="Nombre" />
    </div>
    <div class="col-md-4 col-sm-4 col-xs-6">
        <input type="text" name="txtuser_dni" class="form-control m-b-10" placeholder="DNI" />
    </div>
    <div class="col-md-4 col-sm-4 col-xs-6">
        <input type="text" name="txtuser_email" class="form-control m-b-10" placeholder="Email" />
    </div>
    <div class="col-md-4 col-sm-4 col-xs-6">
        <input type="text" name="txtuser_movil" class="form-control m-b-10" placeholder="Número movil" />
    </div>
    <div class="col-md-4 col-sm-4 col-xs-6">
        <input type="text" name="txtuser_user" class="form-control m-b-10" placeholder="Usuario" />
    </div>
    <div class="col-md-4 col-sm-4 col-xs-6">
        <input type="text" name="txtuser_password" class="form-control m-b-10" placeholder="Password" />
    </div>
    <div class="col-md-4 col-sm-4 col-xs-6">
        <select name="cborol" class="form-control m-b-10" >
            <c:forEach var="rol" items="${listaroles}">
        		<option value="${ rol.idrol }">${ rol.desc_rol }</option>
        	</c:forEach>
        </select>
    </div>    
    <div class="col-md-3 col-sm-3 col-xs-6">
	    	<div class="box-btn-add" style="margin:0 0 10px 0;">
	            <a href="javascript:limpiar_usuario();" style="margin:0;">Cancelar</a>
	        </div>
	</div> 
	<div class="col-md-3 col-sm-3 col-xs-6">
	        <div class="box-btn-confirm" style="margin:0 0 10px 0;">
	            <a href="javascript:guardaruser();" style="margin:0;">Guardar</a>
	        </div>	        
	</div>	    
	</form>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="table-responsive overflow" tabindex="5001" style="overflow: hidden; outline: none;">
                <table class="table tile" id="tbl_usuario">
                            <thead>
                                <tr>
                                    <th style="width:80px;text-align:center;">Número</th>
                                    <th>Nombre</th>
                                    <th>Usuario</th>
                                    <th>Password</th>
                                    <th>Movil</th>
                                    <th colspan="2" style="width:80px;text-align:center;">Opción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="user" items="${listausuarios}">
                                	<tr id="tr${ user.idusuario }">
	                                    <td class="td-center">${ user.idusuario }</td>
	                                    <td>${ user.nombre }</td>
	                                    <td>${ user.user }</td>
	                                    <td>${ user.password }</td>
	                                    <td>${ user.movil }</td>
	                                    <td class="td-center">
	                                        <a href="javascript:cargar_user(${ user.idusuario },'${ user.nombre }','${ user.dni }','${ user.user }','${ user.password }','${ user.email }','${ user.movil }','${ user.rol.idrol }');"><i class="menu-icon fa fa-sign-in"></i></a>
	                                    </td>
	                                    <td class="td-center">
	                                        <a href="javascript:eliminar_user(${ user.idusuario });"><i class="menu-icon fa fa-times-circle"></i></a>
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