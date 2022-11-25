<%-- 
    Document   : iniciarSesion
    Created on : 17/11/2022, 06:20:36 PM
    Author     : DANIEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="unipiloto.proyecto.Usuario" %>
<%@page import="unipiloto.proyecto.UsuarioDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    </head>
    <body>

        <%!
            UsuarioDAO userDAO = new UsuarioDAO();
        %>
        <div class="container">
            <%@include file="/template/menu.jsp" %>
        </div>


        <br><br>
        <div class="container-fluid" style="background-image: url('https://mdbcdn.b-cdn.net/img/new/slides/003.webp');">
            <br><br>
            <div class="modal-dialog text-center" role="document">
                <div class="col-sm-8 offset-sm-2">
                    <div class="modal-content">
                        <div class="col-12">
                            <img height="150" width="150" src="images/IconoIniciarSesion.png"/>
                        </div>


                        <form action="${pageContext.servletContext.contextPath}/ingresarServlet" method="POST" class="container col-12 ">
                            <div class="mb-3">
                                <label for="exampleDropdownFormEmail1" class="form-label">Usuario</label>
                                <input name="usuario_entrar" type="text" class="form-control" id="exampleDropdownFormEmail1" placeholder="Ingrese el usuario">
                            </div>
                            <div class="mb-3">
                                <label for="exampleDropdownFormPassword1" class="form-label">Contrase&ntilde;a</label>
                                <input name="password_entrar" type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Ingrese la contraseña">
                            </div>
                            <button type="submit" name="btn_ingress" class="btn btn-primary"><i class="bi bi-box-arrow-in-right"></i> Ingresar</button>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="bi bi-person-fill-add"></i> Registrarse</button>

                        </form>
                        <div class="dropdown-divider"></div>
                        <a type="button" data-bs-toggle="modal" data-bs-target="#recuperarModal" class="dropdown-item" >No recuerda la contrase&ntilde;a?</a>



                    </div>


                </div>
            </div>
            <br><br><br><br>
        </div>

        <!-- Modal Registro-->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Registro</h5>
                        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form  action="${pageContext.servletContext.contextPath}/UsuarioServlet" method="POST" class="row g-3">
                            <div class="col-12">
                                <label for="inputUser" class="form-label">Usuario</label>
                                <input type="text" class="form-control" id="user" placeholder="Ingrese Usuario" name="user">
                            </div>
                            <div class="col-md-6">
                                <label for="inputNombre" class="form-label">Nombre</label>
                                <input type="text" class="form-control" id="name" placeholder="Ingrese su Nombre" name="name">
                            </div>
                            <div class="col-md-6">
                                <label for="inputApellido" class="form-label">Apellido</label>
                                <input type="text" class="form-control" id="lastName" placeholder="Ingrese su Appelido" name="lastName">
                            </div>
                            <div class="col-md-6">
                                <label for="inputEmail4" class="form-label">Correo</label>
                                <input type="email" class="form-control" id="email" placeholder="Ingrese su Correo" name="email">
                            </div>
                            <div class="col-md-6">
                                <label for="inputPassword4" class="form-label">Contrase&ntilde;a</label>
                                <input type="password" class="form-control" id="password" placeholder="*********" name="password">
                            </div>

                            <div class="col-12">
                                <label for="exampleRol">Rol</label>
                                <select name="tiporol" class="form-select" id="tipo_rol">
                                    <option value="">Seleccionar Rol</option>
                                    <option value="1">Administrador</option>
                                    <option value="2">Cliente</option>

                                </select>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" name="btn_registrar" class="btn btn-success justify-content-end col-3">Registrarme</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>



        <!-- Modal Recuperar-->
        <div class="modal fade" id="recuperarModal" tabindex="-1" role="dialog" aria-labelledby="recuperarModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="recuperarModalLabel">Recuperar Contrase&ntilde;a</h5>
                        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form  action="${pageContext.servletContext.contextPath}/recuperarServlet" method="POST" class="row g-3">
                            <div class="col-12">
                                <label for="ingreseEmail" class="form-label">Correo</label>
                                <input type="text" class="form-control" placeholder="Ingrese su correo para recuperar contraseña" name="correo_recuperar">
                            </div>
                            <div class="col-12">
                                <label for="ingresePass" class="form-label">Contrase&ntilde;a</label>
                                <input type="password" class="form-control" placeholder="Ingrese contraseña nueva" name="password_recuperar">
                            </div>
                            <div class="col-12">
                                <label for="ingresePassx2" class="form-label">Repetir Contrase&ntilde;a</label>
                                <input type="password" class="form-control" placeholder="Reingrese contraseña nueva" name="passnew_recuperar">
                            </div>
                            <div class="modal-footer">
                                <button type="submit" name="btn_recu" class="btn btn-success justify-content-end col-3">Recuperar</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>

        <%
            if (request.getAttribute("message") != null) {


        %>
        <script>
            alert('<%=request.getAttribute("message")%>');
        </script>
        <%
            }else if(request.getAttribute("message_recuperar") != null){
            
            
        %>
        <script>
            alert('<%=request.getAttribute("message_recuperar")%>');
        </script>
        <%
            }
        %>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </body>
</html>
