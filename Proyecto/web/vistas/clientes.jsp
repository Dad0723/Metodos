<%-- 
    Document   : clientes
    Created on : 12/11/2022, 12:34:35 PM
    Author     : DANIEL
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="unipiloto.proyecto.PanelDAO" %>
<%@page import="unipiloto.proyecto.Panel" %>
<%@page import="java.util.ArrayList" %>
<%@page import="unipiloto.proyecto.Notificacion"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>

        <%!
            PanelDAO panelDAO = new PanelDAO();
        %>

        <div class="container">
            <%@include file="/template/menuUser.jsp" %>
        </div>
        </br>
        </br>
        </br>
        <div class="row mb-2">
            <h1 class="col-10 text-center">Bienvenido Usuario</h1>
                <button type="button" data-bs-toggle="modal" data-bs-target="#recuperarModal" class="btn btn-success col-2">NOTIFICACIONES</button>
            <hr>
            <h2>Aqui puede ver los paneles</h2>
        </div>
        </br>

        <div class="table-responsive">
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
                </thead>
                <tbody>

                    <%
                        ArrayList<Panel> listaPanel = panelDAO.mostrarPaneles();

                        for (Panel elem : listaPanel) {


                    %>

                    <tr>
                        <td class=""><%= elem.getId()%></td>
                        <td class=""><%= elem.getIdentificacion()%></td>
                        <td class=""><%= elem.getNombre()%></td>
                        <td class=""><%= elem.getApellido()%></td>
                        <td class=""><%= elem.getFe_registro()%></td>
                        <td class=""><%= elem.getTipopanel()%></td>
                        <td class=""><%= elem.getMensaje()%></td>
                        <td class=""><%= elem.getUbicacion()%></td>
                        <td class=""><%= elem.getFe_entrada()%></td>
                        <td class=""><%= elem.getFe_salida()%></td>
                    </tr>

                    <%
                        }
                    %>
                </tbody>
            </table>

        </div>

        <!-- Modal MANTENIMIENTO    -->
        <div class="modal fade" id="recuperarModal" tabindex="-1" role="dialog" aria-labelledby="recuperarModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="recuperarModalLabel">Notificaci&oacute;n Mantenimiento</h5>
                        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="container fluid">
                            <div class="row row-cols-2">

                                <%
                                    ArrayList<Notificacion> notPanel = panelDAO.notificarPanel();

                                    for (Notificacion elem : notPanel) {


                                %>

                                <div class="col border">
                                    <div class="row col-12">
                                        <label class="form-label col-4">IdPanel:</label>
                                        <p class="col-7"><%= elem.getId()%></p>
                                    </div>
                                    <div class="mensaje row col-12">
                                        <b><p class="col-12 text-center h4"><%= elem.getMensaje()%></p></b>
                                    </div>
                                    <div class=" row col-12">
                                        <label class="form-label col-1"><i class="bi bi-geo-alt-fill"></i></label>
                                        <p class="col-10" style="font-size: 14px;"><%= elem.getUbicacion()%></p>
                                    </div>
                                    <div class="row col-12">
                                        <label class="form-label col-4 text-center"><b>Via Alterna</b></label>
                                        <p class="col-8" style="font-size: 14px;"><%= elem.getViaAlterna()%></p>
                                    </div>
                                </div>

                                <%
                                    }
                                %>    
                            </div>
                        </div>


                    </div>
                </div>    


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>

<%    if (request.getAttribute("message") != null) {


%>
<script>
    alert('<%=request.getAttribute("message")%>');
</script>
<%
    }
%>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
