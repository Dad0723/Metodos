<%-- 
    Document   : index
    Created on : 29/09/2022, 01:27:45 PM
    Author     : DANIEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paneles De Mensajería Variable</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <%@include file="template/menu.jsp" %>
        </div>

       

        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" style="background-color: #07333f">
            <br>

            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner ">
                <div class="carousel-item active">
                    <img src="./images/PanelesMensajeriaVariable.jpg" class="d-block w-50 rounded mx-auto " alt="...">
                </div>
                <div class="carousel-item">
                    <img src="./images/PanelesMensajeriaVariable(1).jpg" class="d-block w-50 rounded mx-auto" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="./images/PanelesMensajeriaVariable(2).jpg" class="d-block w-50 rounded mx-auto" alt="...">
                </div>
            </div>
            <button style="background-color: #07333f" class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button style="background-color: #07333f" class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>


        
        </br>
        <div class="text-center">
            <h1 >Paneles de Mensajer&iacute;a Variable</h1>
            <br>

        </div>
        <div class="container">
            <p>El Panel de Mensaje Variable  es un aparato dise&ntilde;ado para exhibir mensajes informativos 
                y avisos a los conductores de m&uacute;ltiples carreteras en todo el pa&iacute;s. Este producto est&aacute; fabricado
                       de forma modular.</p>
            <p>Posee densidad o&oacute;ptica de 1600 pixeles por metro cuadrado, con LEDs de alta intensidad que 
                garantizan una visibilidad adecuada durante el d&iacute;a, y textos escritos con fuente de tama&ntilde;o
                grande, lo que permite mantener la legibilidad del texto ¡a 200 metros o m&aacute;s!  Este es uno
                        de los diferenciales de este producto, que permite que se transmita cualquier tipo de
                        informaci&oacute;n a los usuarios. Este PMV permite cambiar los mensajes y avisar sobre el tr&aacute;fico,
                        accidentes y especialmente sobre cambio de rutas, por si algunas estan cerradas</p>
            
            <h2>Caracteristicas</h2>
        </div>        
                
        <div class="container-fluid" style="background-color: #8c8f91">
            <div class="container">
                <div class="row">
                    
                    <div class="col-12 text-center"><br><h2>Ventajas</h2></div>
                    <div class="col-5">
                        <img width="445" height="232" src="https://velsis.com.br/es/wp-content/uploads/2021/02/menor2.jpg" class="attachment-large size-large" alt="" loading="lazy" srcset="https://velsis.com.br/es/wp-content/uploads/2021/02/menor2.jpg 891w, https://velsis.com.br/es/wp-content/uploads/2021/02/menor2-300x156.jpg 300w, https://velsis.com.br/es/wp-content/uploads/2021/02/menor2-768x398.jpg 768w" sizes="(max-width: 891px) 100vw, 891px">

                    </div>
                    <div class="col-7">
                        <br><br>
                        <ul>
                            <li>Notificar a los usuarios de la autopista acerca de la situaci&oacute;n de la v&iacute;a.</li>
                            <li>Notificar de tomar v&iacute;as alternas.</li>
                            <li>Invias puede insertar, editar y eliminar cada panel seg&uacute;n corresponda.</li>

                        </ul>
                    </div>
                   
                </div>    
            </div>
            
            
        </div>        
                
                <h2></h2>
                <h2></h2>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
