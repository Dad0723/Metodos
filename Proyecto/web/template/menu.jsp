<%-- 
    Document   : menu
    Created on : 12/11/2022, 01:07:28 PM
    Author     : DANIEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand navbar-dark fixed-top" style="background-color: #484545">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp" >
            Paneles de Mensajeria Variable
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="iniciarSesion.jsp" >Iniciar Sesi&oacute;n</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="quienesSomos.jsp" >Quienes somos</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">

                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown" >
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="${pageContext.servletContext.contextPath}/iniciarSesion.jsp" >Registrarse</a></li>
  
                    </ul>
                </li>
            </ul>

        </div>
    </div>
                        
                        
                        
</nav>
