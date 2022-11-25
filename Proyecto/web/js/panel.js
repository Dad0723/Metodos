/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function llenarFormulario(fila){
    var codigo = $(fila).find(".id").text();
    var identificacion = $(fila).find(".identificacion").text();
    var nombre = $(fila).find(".nombre").text();
    var apellido = $(fila).find(".apellido").text();
    var fe_registro = $(fila).find(".fe_registro").text();
    var idTipo = $(fila).find(".tipopanel").text();
    var mensaje = $(fila).find(".mensaje").text();
    var ubicacion = $(fila).find(".ubicacion").text();
    var fe_entrada = $(fila).find(".fe_entrada").text();
    var fe_salida = $(fila).find(".fe_salida").text();
    
    $("#id").val(codigo);
    $("#identificacion").val(identificacion);
    $("#nombre").val(nombre);
    $("#apellido").val(apellido);
    $("#fecha_registro").val(fe_registro);
    $("#tipo_panel option:contains("+idTipo+")").attr('selected' , true);
    $("#mensaje").val(mensaje);
    $("#ubicacion").val(ubicacion);
    $("#fecha_entrada").val(fe_entrada);
    $("#fecha_salida").val(fe_salida);
    
}

//alert("hola", "hola afuera");
$(document).ready(function (){
    
    $(document).on('click','.btnEditar', function(){
        llenarFormulario($(this).closest('tr'));
    });
    
    $(document).on('click','.btnEliminar', function(){
        llenarFormulario($(this).closest('tr'));
    });
});