<%-- 
    Document   : registrar
    Created on : 29/09/2022, 01:51:13 PM
    Author     : DANIEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="unipiloto.proyecto.Panel" %>
<%@page import="unipiloto.proyecto.Tipo" %>
<%@page import="unipiloto.proyecto.PanelDAO" %>
<%@page import="unipiloto.proyecto.TipoDAO" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paneles de mensajeria variable </title>
        <link rel="stylesheet" href="./bootstrap.min (2).css"/>
    </head>

    <body>

        <%!
            TipoDAO tipoDAO = new TipoDAO();
            PanelDAO panelDAO = new PanelDAO();
        %>

        <div class="container">
            <%@include file="template/menuAdmin.jsp" %>
        </div>
        </br>
        <br>
        <br>
        <h1 class="text-center">Registro de Panel</h1>

        <div class="container">

            <div id="contenido"></div>
            <form action="${pageContext.servletContext.contextPath}/PanelServlet" method="POST" role="form">
                <div class="form-group">
                    <label for="exampleInputEmail1">Id Panel</label>
                    <input type="text" name="id" value="${panel.id}" class="form-control" id="id" placeholder="Ingrese id de panel">
                    <small id="textHelp" class="form-text text-muted">Nosotros nunca compartiremos tu informaci&oacute;n con alguien m&aacute;s</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Identificacion</label>
                    <input type="text" name="identificacion" value="${panel.identificacion}" class="form-control" id="identificacion" placeholder="Ingrese identificacion">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Nombre</label>
                    <input type="text" name="nombre" value="${panel.nombre}" class="form-control" id="nombre" placeholder="Ingrese su nombre">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Apellido</label>
                    <input type="text" name="apellido" value="${panel.apellido}" class="form-control" id="apellido" placeholder="Ingrese su apellido">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Fecha Registro</label>
                    <input type="text" name="fe_registro" value="${panel.fe_registro}" class="form-control" id="fecha_registro" placeholder="Ingrese fecha de registro en formato (DD/MM/AAAA)">
                </div>
                <h2></br>Panel</br></h2>
                <div class="form-group">
                    <label for="exampleInputEmail1">Tipo de panel</label>
                    <select name="tipopanel" class="form-select" id="tipo_panel">
                        <option value="">Seleccionar Panel</option>

                        <%
                            ArrayList<Tipo> lista = tipoDAO.mostrarTipo();

                            for (Tipo elem : lista) {


                        %>
                        <option value="<%= elem.getIdTipo()%>"> <%= elem.getTipopanel()%></option>
                        <%
                            }
                        %>
                    </select>

                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Mensaje</label>
                    <input type="text" name="mensaje" value="${panel.mensaje}" class="form-control" id="mensaje" placeholder="Ingrese el mensaje que ira en el panel">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Ubicacion</label>
                    <input type="text" name="ubicacion" value="${panel.ubicacion}" class="form-control" id="ubicacion" placeholder="Ingrese ubicacion con ciudad y pais">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Fecha de Entrada</label>
                    <input type="text" name="fe_entrada" value="${panel.fe_entrada}" class="form-control" id="fecha_entrada" placeholder="Ingrese fecha de entrada del panel en formato (DD/MM/AAAA)">
                </div>
                <div class="form-group ">
                    <label for="exampleInputEmail1">Fecha de Salida</label>
                    <input type="text" name="fe_salida" value="${panel.fe_salida}" class="form-control" id="fecha_salida" placeholder="Ingrese fecha de salida del panel en formato (DD/MM/AAAA)">
                </div>
                </br>
                </br>
                <div class="text-center">
                    <button type="submit" name="btnGuardar" class="btn btn-success">Guardar</button>
                    <button type="submit" name="botonEditar" class="btn btn-success">Editar</button>
                    <button type="submit" name="botonEliminar" class="btn btn-success">Eliminar</button>

                </div>
            </form>    
            </br>
            </br>
            <a id="tabla_paneles"></a>
            <div class="table-responsive" >
                <table class="table table-striped">
                    <thead>
                    <th>Id</th>
                    <th>Identificación</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Fecha Registro</th>
                    <th>Tipo de Panel</th>
                    <th>Mensaje</th>
                    <th>Ubicacion</th>
                    <th>Fecha Entrada</th>
                    <th>Fecha Salida</th>
                    <th>Acci&oacute;n</th>
                    </thead>
                    <tbody>

                        <%
                            ArrayList<Panel> listaPanel = panelDAO.mostrarPaneles();

                            for (Panel elem : listaPanel) {


                        %>

                        <tr>
                            <td class="id"><%= elem.getId()%></td>
                            <td class="identificacion"><%= elem.getIdentificacion()%></td>
                            <td class="nombre"><%= elem.getNombre()%></td>
                            <td class="apellido"><%= elem.getApellido()%></td>
                            <td class="fe_registro"><%= elem.getFe_registro()%></td>
                            <td class="tipopanel"><%= elem.getTipopanel()%></td>
                            <td class="mensaje"><%= elem.getMensaje()%></td>
                            <td class="ubicacion"><%= elem.getUbicacion()%></td>
                            <td class="fe_entrada"><%= elem.getFe_entrada()%></td>
                            <td class="fe_salida"><%= elem.getFe_salida()%></td>
                            <td>
                                <button type="button" class="btn btn-secondary btnEditar">Editar</button>
                                <button type="button" class="btn btn-danger btnEliminar">Eliminar</button>
                            </td>
                        </tr>

                        <%
                            }
                        %>
                    </tbody>
                </table>

            </div>
        </div>

        <%
            if (request.getAttribute("message") != null) {


        %>
        <script>
                        alert('<%=request.getAttribute("message")%>');
        </script>
        <%
            }
        %>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

        <script src="${pageContext.servletContext.contextPath}/js/panel.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    
    </body>
</html>
