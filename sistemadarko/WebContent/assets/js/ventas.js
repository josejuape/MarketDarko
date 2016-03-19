function realizarVenta(){
    $.ajax({
        type: "POST",
        url: "../sistemadarko/realizarventa.html",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function finalizarVenta(){
    var r = confirm("¿Finalizar venta?");
    if(r){
        //$.ajax({
        //    type: "POST",
        //    url: "../prorotipodarko/ServletFinalizarVenta",
        //    data: "",
        //    success: function(resp){
        //        $("#box-container").html(resp);
        //    }
        //});
        location.reload();
    }
}

function ventasrealizadas(){
    $.ajax({
        type: "POST",
        url: "../prorotipodarko/ventasrealizadas.html",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}


// MODULO COMPRAS

function generarcompra(){
    $.ajax({
    	type: "GET",
        url: "../sistemadarko/GenerarCompra",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function confirmarcompra(){
    $.ajax({
        type: "POST",
        url: "../sistemadarko/ConfirmarCompra",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function inventario(){
    $.ajax({
        type: "POST",
        url: "../prorotipodarko/inventario.html",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}




// CONFIGURACION

function categoria(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/Categoria",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function marca(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/Marca",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function modelo(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/Modelo",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function color(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/Color",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function tipopago(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/TipoPago",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function ubicacion(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/Ubicacion",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function talla(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/Talla",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function comprobante(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/Comprobante",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function estado(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/Estado",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function productos(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/Producto",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

//Seguridad

function menu(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/Menu",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function opcionesmenu(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/Opcion",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function roles(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/Rol",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}

function usuarios(){
    $.ajax({
        type: "GET",
        url: "../sistemadarko/Usuario",
        data: "",
        success: function(resp){
            $("#box-container").html(resp);
        }
    });
}







