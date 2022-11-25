<%-- 
    Document   : administrador
    Created on : 20/11/2022, 07:07:10 PM
    Author     : DANIEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    </head>
    <body>
        <div class="container">
            <%@include file="/template/menuAdmin.jsp" %>
        </div>
        </br>
        </br>
        </br>
        <h1 class="text-center">Bienvenido Administrador</h1>
        <hr>
        
        
        <div class="container">
            <div class="row">
            <div class="col-4">
                <h5>
                    En la pesta&ntilde;a de registrar usted puede, registrar los paneles de mensajer&iacute;a variable
                    que usted considere. As&iacute; como tambi&eacute;n puede editar los paneles ya creados y que los muestra
                    en la parte final a partir de filas y de esta forma al usted darle en editar(dentro de la fila), se llena el formulario 
                    autom&aacute;ticamente para de esta forma darle en el bot&oacute;n editar. Al usted hacer una petici&oacute;n, 
                    saldra una alerta para ver si los datos fueron ingresados, editados o eliminados correctamente. As&iacute; 
                    mismo usted puede ver una tabla con los paneles que ya estan en la base de datos.
                  
                </h5>
            </div>
            <div class="col-8">
                <img height="100%" width="100%" src="${pageContext.servletContext.contextPath}/images/Imagen_registrar.png"></img>
            </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    
    </body>
</html>
